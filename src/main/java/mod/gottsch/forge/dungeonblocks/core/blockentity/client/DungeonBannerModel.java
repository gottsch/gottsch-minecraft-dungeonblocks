/*
 * This file is part of  DungeonBlocks.
 * Copyright (c) 2026 Mark Gottschling (gottsch)
 *
 * DungeonBlocks is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * DungeonBlocks is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with DungeonBlocks.  If not, see <http://www.gnu.org/licenses/lgpl>.
 */
package mod.gottsch.forge.dungeonblocks.core.blockentity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import mod.gottsch.forge.dungeonblocks.DungeonBlocks;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * The banner's geometry: a rod across the top with a cloth hanging beneath it.
 *
 * <p><b>The cloth is five flat, zero-thickness quads, and the taper is painted, not modelled.</b>
 * Both of those are deliberate, and between them they remove every problem the first version had:
 *
 * <ul>
 * <li><b>Zero thickness makes the seams exact.</b> Each slice hinges on its own top edge, and with
 *     no depth that edge lies <em>exactly</em> on the rotation axis — so it cannot move at all, and
 *     two neighbouring slices stay joined however far apart their angles drift. A 1px-deep slice has
 *     its top edge half a pixel off the axis, which is enough to open a hairline; that is what the
 *     overlap fudge used to be papering over, and it is gone.</li>
 * <li><b>The taper is alpha in the texture.</b> Slices are all the same width, so the art is a plain
 *     {@value #CLOTH_WIDTH}x{@value #CLOTH_HEIGHT} rectangle laid out contiguously in the atlas
 *     rather than one column-inset strip per slice. The silhouette costs no geometry, is not
 *     quantised to the slice height, and can be reshaped — a swallowtail, a ragged hem — by editing
 *     the PNG alone.</li>
 * <li><b>Five slices is enough.</b> The wave is a few degrees; subdividing past this buys curve
 *     smoothness nobody can see, at a cube each.</li>
 * </ul>
 *
 * <p><b>Zero thickness has exactly one requirement</b>, and the renderer has to honour it: the front
 * and back quads are coincident, so they <em>must</em> be drawn with backface culling on
 * ({@code entityCutout}, never {@code entityCutoutNoCull}) or they z-fight. With culling, only one
 * of the two is ever rasterised at a given pixel and the surface is clean.
 *
 * <p><b>Coordinates.</b> {@code DungeonBannerRenderer} sets up the usual entity-model frame, so in
 * here <b>+y is down</b> and <b>+z is into the wall</b>, with the origin at the centre of the
 * <em>upper</em> block — the half that owns the BlockEntity. The wall plane is therefore z=8. y runs
 * from -8 (the top of the upper block) to +24 (the bottom of the lower one), and the geometry fills
 * exactly that: 2px of rod and 30px of cloth. Nothing is drawn outside the two blocks the banner
 * occupies.
 *
 * <p><b>Texture layout.</b> A zero-depth box unwraps to just two quads, the front at {@code (u, v)}
 * and the back at {@code (u + w, v)}. Stacking the slices at {@code texOffs(0, s * SLICE_HEIGHT)}
 * therefore makes the fronts one contiguous {@value #CLOTH_WIDTH}x{@value #CLOTH_HEIGHT} block at
 * the atlas origin, with the mirrored backs directly beside it.
 *
 * @author Mark Gottschling on Sep 12, 2026
 */
@OnlyIn(Dist.CLIENT)
public class DungeonBannerModel {

	public static final ModelLayerLocation LAYER_LOCATION =
			new ModelLayerLocation(new ResourceLocation(DungeonBlocks.MOD_ID, "dungeon_banner"), "main");

	/**
	 * 10px wide against 30px of drop is roughly a 1:3 banner — narrower than vanilla's, which is the
	 * proportion that suits a two-block hang. Where the cloth actually ends inside that rectangle is
	 * up to the texture's alpha.
	 */
	public static final int CLOTH_WIDTH = 10;
	public static final int CLOTH_HEIGHT = 30;
	/** Hinges, not detail: see the class comment on why five is enough. */
	public static final int SLICE_COUNT = 5;
	private static final int SLICE_HEIGHT = CLOTH_HEIGHT / SLICE_COUNT;

	/** y of the cloth's top edge: just under the rod. */
	private static final float CLOTH_TOP = -6.0F;
	/** The plane the cloth hangs in. 3px clear of the wall, and the billow only ever moves it away. */
	private static final float CLOTH_Z = 4.5F;

	private static final int ROD_WIDTH = 12;
	/** The cloth's two unwraps occupy the top-left 20x30 of the atlas, so the rod goes below them. */
	private static final int ROD_TEX_U = 0;
	private static final int ROD_TEX_V = 32;

	/** One full turn in radians. */
	private static final float TAU = (float) (Math.PI * 2.0D);

	/**
	 * Per-slice billow, in radians. Small because it accumulates: five slices of ~0.7 degrees is a
	 * ~7 degree bend by the time it reaches the point, which moves the hem about 3px.
	 */
	private static final float AMPLITUDE = 0.012F;
	/**
	 * A standing outward bow, equal to the amplitude, so the billow swings between "flat" and "bowed
	 * out" and <b>never crosses zero into the wall</b>. Without it the wave would drive the hem
	 * several pixels backwards on every half-cycle, and the cloth hangs only 3px clear of the wall —
	 * it would sink into the stone twice a cycle. Vanilla's banner biases its sway the same way and
	 * for the same reason. It is also what keeps a motionless banner looking like cloth: see
	 * {@link #still}.
	 */
	private static final float BILLOW_BIAS = AMPLITUDE;
	/** Cycles per tick: a 5-second period, the same unhurried rate vanilla banners use. */
	private static final float SPEED = 0.01F;
	/** Cycles of delay per slice down the cloth — this is what makes the wave travel. */
	private static final float SLICE_LAG = 0.09F;
	/** ~1.4 degrees of whole-cloth roll, so the hem drifts under a pixel. See {@link #wave}. */
	private static final float LEAN_AMPLITUDE = 0.025F;
	/** Detuned against SPEED (~7s) so the lean drifts in and out of phase with the billow. */
	private static final float LEAN_SPEED = 0.0071F;

	private final ModelPart root;
	/** Index 0 is the slice at the rod; each is the previous one's child. */
	private final ModelPart[] slices;

	public DungeonBannerModel(ModelPart root) {
		this.root = root;
		this.slices = new ModelPart[SLICE_COUNT];
		ModelPart parent = root;
		for (int i = 0; i < SLICE_COUNT; i++) {
			parent = parent.getChild(sliceName(i));
			this.slices[i] = parent;
		}
	}

	private static String sliceName(int index) {
		return "slice" + index;
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition parts = mesh.getRoot();

		parts.addOrReplaceChild("rod",
				CubeListBuilder.create()
						.texOffs(ROD_TEX_U, ROD_TEX_V)
						.addBox(-ROD_WIDTH / 2.0F, -8.0F, 5.0F, ROD_WIDTH, 2.0F, 2.0F, CubeDeformation.NONE),
				PartPose.ZERO);

		// each slice hinges on its own top edge, so its pivot sits there and its quad hangs below it.
		// depth is 0, which puts that whole edge on the rotation axis - the seams cannot open.
		PartDefinition parent = parts;
		for (int i = 0; i < SLICE_COUNT; i++) {
			PartPose pose = i == 0
					? PartPose.offset(0.0F, CLOTH_TOP, CLOTH_Z)
					: PartPose.offset(0.0F, SLICE_HEIGHT, 0.0F);
			parent = parent.addOrReplaceChild(sliceName(i),
					CubeListBuilder.create()
							.texOffs(0, i * SLICE_HEIGHT)
							.addBox(-CLOTH_WIDTH / 2.0F, 0.0F, 0.0F,
									CLOTH_WIDTH, SLICE_HEIGHT, 0.0F, CubeDeformation.NONE),
					pose);
		}

		return LayerDefinition.create(mesh, 64, 64);
	}

	/**
	 * Poses the cloth for this frame.
	 *
	 * <p>Every angle is a cosine of the clock — nothing is integrated, so there is no state to keep
	 * and no way for two clients to drift apart.
	 *
	 * <p><b>The rule that matters here: a per-slice hinge may only turn about the seam it shares with
	 * its neighbour.</b> {@code xRot}'s axis <em>is</em> that horizontal seam line, so however far two
	 * neighbouring slices differ, their shared edge stays shared and the cloth reads as one sheet.
	 * {@code zRot} and {@code yRot} turn about axes that cross the seam instead of lying along it, so
	 * applying either per slice tilts each slice's top edge away from the bottom edge of the one above
	 * it — opening a wedge that is invisible at the centre and widest at the cloth's edges.
	 *
	 * <p>So the billow is per-slice and lagged, which is what makes the wave crest travel down to the
	 * hem; the sideways lean is set once, on the top slice, and every slice below inherits it through
	 * the hierarchy — the whole cloth rolls as one rigid sheet and no seam can open.
	 *
	 * @param now   game time in ticks, including partial ticks
	 * @param phase 0..1 offset from the block position, so neighbouring banners aren't in lockstep
	 */
	public void wave(float now, float phase) {
		for (int i = 0; i < this.slices.length; i++) {
			// negative is away from the wall, since +z points into it
			this.slices[i].xRot =
					-BILLOW_BIAS - AMPLITUDE * Mth.cos(TAU * (now * SPEED + phase + i * SLICE_LAG));
		}
		this.slices[0].zRot = LEAN_AMPLITUDE * Mth.cos(TAU * (now * LEAN_SPEED + phase));
	}

	/**
	 * Poses the cloth as a still banner, for players who turn the animation off.
	 *
	 * <p>It keeps the standing outward bow rather than going flat. A dead-flat stack of quads pinned
	 * against a wall reads as a painted board; a couple of degrees of bow still reads as hanging
	 * cloth, and costs nothing.
	 */
	public void still() {
		for (ModelPart slice : this.slices) {
			slice.xRot = -BILLOW_BIAS;
			slice.zRot = 0.0F;
		}
	}

	public void render(PoseStack poseStack, VertexConsumer consumer, int packedLight, int packedOverlay) {
		this.root.render(poseStack, consumer, packedLight, packedOverlay);
	}
}

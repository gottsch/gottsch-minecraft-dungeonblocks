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

import mod.gottsch.forge.dungeonblocks.DungeonBlocks;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

/**
 * One 1-block length of chain: the same two crossed planes vanilla's {@code block/chain} model uses,
 * rebuilt as a {@code ModelPart} so the renderer can rotate each length independently.
 *
 * <p>The UVs line up with vanilla {@code block/chain.png} for free. A box of
 * {@code 3 x 16 x 0} at {@code texOffs(0, 0)} puts its north face at u 0..3 and its south face at
 * u 3..6 — exactly the two strips vanilla's two elements sample (the texture only has art in its
 * first six columns). So no new art is needed; this borrows the vanilla chain texture directly,
 * which also means it matches any resource pack the player is using.
 *
 * <p>Unlike the entity models in this mod, this is authored in <b>natural block orientation</b> —
 * the box hangs from y=0 down to y=-16 and the renderer applies no mirror flip. That keeps the
 * rotation maths in the renderer readable (+Y is up, as you'd expect). The only cost is that the
 * texture is sampled bottom-up, which is invisible on a repeating chain-link pattern.
 *
 * @author Mark Gottschling on Jul 26, 2026
 */
public class ChainSegmentModel {

	public static final ModelLayerLocation LAYER_LOCATION =
			new ModelLayerLocation(new ResourceLocation(DungeonBlocks.MOD_ID, "swinging_chain"), "main");

	/** Name of the part to fetch from the baked root. */
	public static final String SEGMENT = "segment";

	private static final float PLANE_A_YAW = (float) (Math.PI / 4.0D);
	private static final float PLANE_B_YAW = (float) (3.0D * Math.PI / 4.0D);

	private ChainSegmentModel() {
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition root = mesh.getRoot();
		PartDefinition segment = root.addOrReplaceChild(SEGMENT, CubeListBuilder.create(), PartPose.ZERO);

		// two zero-depth planes crossed at 90 degrees. Zero depth means the top/bottom/side quads are
		// degenerate and contribute nothing, and the north/south quads face opposite ways -- the
		// renderer draws them with a no-cull render type so the chain is visible from every angle.
		segment.addOrReplaceChild("plane_a",
				CubeListBuilder.create()
						.texOffs(0, 0)
						.addBox(-1.5F, -16.0F, 0.0F, 3.0F, 16.0F, 0.0F, CubeDeformation.NONE),
				PartPose.rotation(0.0F, PLANE_A_YAW, 0.0F));
		segment.addOrReplaceChild("plane_b",
				CubeListBuilder.create()
						.texOffs(0, 0)
						.addBox(-1.5F, -16.0F, 0.0F, 3.0F, 16.0F, 0.0F, CubeDeformation.NONE),
				PartPose.rotation(0.0F, PLANE_B_YAW, 0.0F));

		return LayerDefinition.create(mesh, 16, 16);
	}
}

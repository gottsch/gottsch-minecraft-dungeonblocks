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
import com.mojang.math.Axis;
import mod.gottsch.forge.dungeonblocks.core.blockentity.SwingingChainBlockEntity;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * Draws a swinging chain, one 1-block segment at a time.
 *
 * <p><b>No physics, no state.</b> Every angle here is a closed-form function of the current time, so
 * there is nothing to integrate, nothing to desync and nothing to persist. Two motions are summed:
 *
 * <ul>
 * <li><b>Idle sway</b> — always running, client-only, seeded from the block position so neighbouring
 *     chains don't move in lockstep. Two slightly detuned sines on the X and Z axes make the chain
 *     wander in a slow ellipse rather than swinging flatly back and forth. This is what banners do,
 *     and it matters: a chain that only reacts to hits reads as dead scenery.</li>
 * <li><b>Impulse swing</b> — a damped pendulum {@code A e^(-t/tau) cos(w t)} driven off the three
 *     numbers the BlockEntity synced. The bell does the same thing.</li>
 * </ul>
 *
 * <p><b>The whip.</b> Each joint gets a share of the total deflection, tapering downward, evaluated
 * at a progressively later lag. That's what makes the chain trail and curve instead of swinging like
 * a rigid stick — for a fraction of the cost of an actual per-joint verlet solve, and with no
 * possibility of the simulation blowing up.
 *
 * @author Mark Gottschling on Jul 26, 2026
 */
@OnlyIn(Dist.CLIENT)
public class SwingingChainRenderer implements BlockEntityRenderer<SwingingChainBlockEntity> {

	/** Borrowed from vanilla, so resource packs restyle these chains too. */
	private static final ResourceLocation TEXTURE =
			new ResourceLocation("minecraft", "textures/block/chain.png");

	/**
	 * Degrees of ambient drift. Small on purpose: at 2 degrees the bottom of a 3-block chain travels
	 * about 2 pixels, which reads as "hanging in still air" rather than "windy".
	 */
	private static final float IDLE_AMPLITUDE = 2.0F;
	/** ~5.7s period. Much slower than this and the drift stops registering as movement at all. */
	private static final float IDLE_SPEED = 0.055F;
	/** Detuned against IDLE_SPEED (~7.7s) so the two axes drift in and out of phase. */
	private static final float IDLE_SPEED_CROSS = 0.041F;

	/** Ticks of delay per joint down the chain — the source of the trailing curve. */
	private static final float JOINT_LAG_TICKS = 1.6F;
	/** Each joint bends this fraction as much as the one above it. */
	private static final float JOINT_TAPER = 0.62F;

	private final ModelPart segment;

	public SwingingChainRenderer(BlockEntityRendererProvider.Context context) {
		this.segment = context.bakeLayer(ChainSegmentModel.LAYER_LOCATION).getChild(ChainSegmentModel.SEGMENT);
	}

	@Override
	public void render(SwingingChainBlockEntity chain, float partialTicks, PoseStack poseStack,
			MultiBufferSource buffer, int packedLight, int packedOverlay) {
		Level level = chain.getLevel();
		if (level == null) {
			return;
		}

		int length = chain.getChainLength();
		float now = (float) level.getGameTime() + partialTicks;
		float omega = SwingingChainBlockEntity.angularFrequency(length);
		float phase = idlePhase(chain.getBlockPos());

		// normalise the per-joint shares so the whole chain's deflection adds up to the swing angle
		// regardless of how long it is
		float weightSum = 0.0F;
		for (int i = 0; i < length; i++) {
			weightSum += (float) Math.pow(JOINT_TAPER, i);
		}

		VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.entityCutoutNoCull(TEXTURE));
		BlockPos pos = chain.getBlockPos();

		poseStack.pushPose();
		// start at the top centre of the anchor block: the chain hangs from the ceiling, not the floor
		poseStack.translate(0.5D, 1.0D, 0.5D);

		for (int i = 0; i < length; i++) {
			float weight = (float) Math.pow(JOINT_TAPER, i) / weightSum;
			float t = now - i * JOINT_LAG_TICKS;

			float swing = swingAngle(chain, t, omega);
			float yawRad = chain.getSwingYaw() * Mth.DEG_TO_RAD;
			float towardX = swing * Mth.cos(yawRad) + IDLE_AMPLITUDE * Mth.sin(t * IDLE_SPEED + phase);
			float towardZ = swing * Mth.sin(yawRad)
					+ IDLE_AMPLITUDE * Mth.sin(t * IDLE_SPEED_CROSS + phase * 1.7F);

			// a downward-hanging chain tips toward +X when rotated about +Z, and toward -Z when
			// rotated about +X -- hence the negation on the Z component.
			poseStack.mulPose(Axis.ZP.rotationDegrees(towardX * weight));
			poseStack.mulPose(Axis.XP.rotationDegrees(-towardZ * weight));

			// sample light per segment: the bottom of a long chain can hang into much darker air
			int segmentLight = LevelRenderer.getLightColor(level, pos.below(i));
			this.segment.render(poseStack, vertexConsumer, segmentLight, OverlayTexture.NO_OVERLAY);

			// step down to the next joint, in this segment's rotated frame so the bend accumulates
			poseStack.translate(0.0D, -1.0D, 0.0D);
		}

		poseStack.popPose();
	}

	/** Damped pendulum from the synced impulse; zero once it has decayed or if never struck. */
	private static float swingAngle(SwingingChainBlockEntity chain, float time, float omega) {
		if (!chain.isSwinging()) {
			return 0.0F;
		}
		float elapsed = time - chain.getSwingStartTick();
		if (elapsed < 0.0F) {
			return 0.0F;
		}
		float envelope = (float) Math.exp(-elapsed / SwingingChainBlockEntity.DECAY_TAU);
		return chain.getSwingAmplitude() * envelope * Mth.cos(omega * elapsed);
	}

	/** Position-derived phase so adjacent chains idle out of step with each other. */
	private static float idlePhase(BlockPos pos) {
		int hash = pos.getX() * 31 + pos.getY() * 17 + pos.getZ() * 13;
		return (float) ((hash & 0xFF) / 255.0F * Math.PI * 2.0D);
	}
}

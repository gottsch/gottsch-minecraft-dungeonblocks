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
import com.mojang.math.Axis;
import mod.gottsch.forge.dungeonblocks.core.block.DungeonLanternBlock;
import mod.gottsch.forge.dungeonblocks.core.block.ModBlocks;
import mod.gottsch.forge.dungeonblocks.core.block.SwingingChainBlock;
import mod.gottsch.forge.dungeonblocks.core.blockentity.SwingingChainBlockEntity;
import mod.gottsch.forge.dungeonblocks.core.state.properties.ChainFixture;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

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

	/**
	 * Each link is vanilla's own chain block model, drawn per segment.
	 *
	 * <p>A hand-built {@code ModelPart} was tried first and looked wrong: two crossed zero-depth
	 * boxes produce <em>coincident</em> north/south quads, which z-fight unless backface culling
	 * removes one — and the box UV layout hands each plane a different half of the texture per side,
	 * where vanilla puts strip 0-3 on both faces of one plane and 3-6 on both faces of the other.
	 * Borrowing the real model sidesteps both and guarantees the chain matches vanilla exactly,
	 * resource packs included.
	 */
	private static final BlockState CHAIN_LINK = Blocks.CHAIN.defaultBlockState();

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

	private final BlockRenderDispatcher blockRenderer;

	public SwingingChainRenderer(BlockEntityRendererProvider.Context context) {
		this.blockRenderer = context.getBlockRenderDispatcher();
	}

	/**
	 * The block model each fixture is drawn from. Every one is an existing block, so fixtures need no
	 * geometry of their own and follow the player's resource pack.
	 */
	@Nullable
	private static BlockState fixtureState(ChainFixture fixture, boolean lit) {
		return switch (fixture) {
			case LANTERN -> Blocks.LANTERN.defaultBlockState().setValue(LanternBlock.HANGING, true);
			case SOUL_LANTERN -> Blocks.SOUL_LANTERN.defaultBlockState().setValue(LanternBlock.HANGING, true);
			case DUNGEON_LANTERN -> ModBlocks.DUNGEON_LANTERN.get().defaultBlockState()
					.setValue(LanternBlock.HANGING, true)
					.setValue(DungeonLanternBlock.LIT, lit);
			case NONE -> null;
		};
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
		float phase = idlePhase(chain.getBlockPos());

		// a fixture only ever sits on the bottom segment, and its weight changes how the chain moves
		BlockState bottom = level.getBlockState(chain.getBlockPos().below(length - 1));
		ChainFixture fixture = bottom.hasProperty(SwingingChainBlock.FIXTURE)
				? bottom.getValue(SwingingChainBlock.FIXTURE)
				: ChainFixture.NONE;
		boolean weighted = fixture.isWeighted();
		float omega = SwingingChainBlockEntity.angularFrequency(length, weighted);
		float tau = SwingingChainBlockEntity.decayTau(weighted);
		BlockState fixtureState = fixtureState(fixture,
				bottom.hasProperty(SwingingChainBlock.LIT) && bottom.getValue(SwingingChainBlock.LIT));

		// normalise the per-joint shares so the whole chain's deflection adds up to the swing angle
		// regardless of how long it is
		float weightSum = 0.0F;
		for (int i = 0; i < length; i++) {
			weightSum += (float) Math.pow(JOINT_TAPER, i);
		}

		BlockPos pos = chain.getBlockPos();

		poseStack.pushPose();
		// start at the top centre of the anchor block: the chain hangs from the ceiling, not the floor
		poseStack.translate(0.5D, 1.0D, 0.5D);

		for (int i = 0; i < length; i++) {
			float weight = (float) Math.pow(JOINT_TAPER, i) / weightSum;
			float t = now - i * JOINT_LAG_TICKS;

			float swing = swingAngle(chain, t, omega, tau);
			float yawRad = chain.getSwingYaw() * Mth.DEG_TO_RAD;
			float towardX = swing * Mth.cos(yawRad) + IDLE_AMPLITUDE * Mth.sin(t * IDLE_SPEED + phase);
			float towardZ = swing * Mth.sin(yawRad)
					+ IDLE_AMPLITUDE * Mth.sin(t * IDLE_SPEED_CROSS + phase * 1.7F);

			// a downward-hanging chain tips toward +X when rotated about +Z, and toward -Z when
			// rotated about +X -- hence the negation on the Z component.
			poseStack.mulPose(Axis.ZP.rotationDegrees(towardX * weight));
			poseStack.mulPose(Axis.XP.rotationDegrees(-towardZ * weight));

			// sample light per segment: the bottom of a long chain can hang into much darker air
			// The fixture takes the place of the bottom segment's chain link rather than hanging in the
			// air below it. That block is real, so the lantern you see is the block you can click —
			// an air block has nothing to ray-trace against, and a VoxelShape spilling downward would
			// not help, since block selection walks the voxel grid cell by cell. It also puts the
			// light source exactly where the lantern appears.
			//
			// Net effect matches vanilla: N stacked blocks read as (N-1) links plus a lantern, the
			// same as placing N-1 chains and a lantern.
			BlockState toDraw = (fixtureState != null && i == length - 1) ? fixtureState : CHAIN_LINK;

			poseStack.pushPose();
			// the origin is this segment's top joint, while renderSingleBlock draws into the unit cube
			// 0..1 upward — so drop a block to land it in this segment's own space. Vanilla's hanging
			// lantern model reaches y=16, so a fixture's connector meets the link above with no gap.
			poseStack.translate(-0.5D, -1.0D, -0.5D);
			this.blockRenderer.renderSingleBlock(toDraw, poseStack, buffer,
					LevelRenderer.getLightColor(level, pos.below(i)), OverlayTexture.NO_OVERLAY);
			poseStack.popPose();

			// step down to the next joint, in this segment's rotated frame so the bend accumulates
			poseStack.translate(0.0D, -1.0D, 0.0D);
		}

		poseStack.popPose();
	}

	/** Damped pendulum from the synced impulse; zero once it has decayed or if never struck. */
	private static float swingAngle(SwingingChainBlockEntity chain, float time, float omega, float tau) {
		if (!chain.isSwinging()) {
			return 0.0F;
		}
		float elapsed = time - chain.getSwingStartTick();
		if (elapsed < 0.0F) {
			return 0.0F;
		}
		float envelope = (float) Math.exp(-elapsed / tau);
		return chain.getSwingAmplitude() * envelope * Mth.cos(omega * elapsed);
	}

	/** Position-derived phase so adjacent chains idle out of step with each other. */
	private static float idlePhase(BlockPos pos) {
		int hash = pos.getX() * 31 + pos.getY() * 17 + pos.getZ() * 13;
		return (float) ((hash & 0xFF) / 255.0F * Math.PI * 2.0D);
	}
}

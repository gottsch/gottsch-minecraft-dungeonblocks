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
package mod.gottsch.forge.dungeonblocks.core.blockentity;

import mod.gottsch.forge.dungeonblocks.core.block.SwingingChainBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Swing state for a {@link SwingingChainBlock}.
 *
 * <p><b>The chain is never simulated.</b> Nothing here integrates physics per tick. An impulse
 * records three numbers — which way, how hard, and when — and the renderer evaluates a damped
 * pendulum from them on the fly. So the network cost of a swinging chain is one small packet per
 * hit, not a per-tick position stream, and every client renders it perfectly smoothly at its own
 * frame rate.
 *
 * <p>The server's only job is spotting something moving through the chain. The client never runs
 * that scan, so the impulse <em>must</em> be synced rather than inferred client-side — the same
 * lesson as {@code PotShardEntity}'s landed flag.
 *
 * @author Mark Gottschling on Jul 26, 2026
 */
public class SwingingChainBlockEntity extends BlockEntity {

	/** Below this horizontal speed, brushing past doesn't disturb the chain. */
	private static final double MIN_NUDGE_SPEED = 0.06D;
	/** Walking is ~0.216 b/t and sprinting ~0.28, so a walk gives ~13 deg and a sprint ~17. */
	private static final double SPEED_TO_DEGREES = 62.0D;
	private static final float MIN_AMPLITUDE = 4.0F;
	private static final float MAX_AMPLITUDE = 24.0F;
	/** A new impulse has to beat the current swing by this much to replace it. */
	private static final float AMPLITUDE_EPSILON = 1.5F;
	private static final int IMPULSE_COOLDOWN_TICKS = 10;

	/** Decay time constant, in ticks: the swing visibly settles over roughly 2 seconds. */
	public static final float DECAY_TAU = 30.0F;

	private float swingYaw;
	private float swingAmplitude;
	private long swingStartTick;
	private boolean swinging;

	private int impulseCooldown;

	public SwingingChainBlockEntity(BlockPos pos, BlockState state) {
		super(ModBlockEntityTypes.SWINGING_CHAIN.get(), pos, state);
	}

	public int getChainLength() {
		BlockState state = this.getBlockState();
		return state.hasProperty(SwingingChainBlock.LENGTH)
				? state.getValue(SwingingChainBlock.LENGTH)
				: 1;
	}

	public float getSwingYaw() {
		return this.swingYaw;
	}

	public float getSwingAmplitude() {
		return this.swingAmplitude;
	}

	public long getSwingStartTick() {
		return this.swingStartTick;
	}

	public boolean isSwinging() {
		return this.swinging;
	}

	/**
	 * How far the swing envelope has decayed by {@code gameTime} — the peak angle it would still
	 * reach. Used to decide whether a fresh impulse is actually stronger than what's already going on.
	 */
	public float decayedAmplitude(long gameTime) {
		if (!this.swinging) {
			return 0.0F;
		}
		float elapsed = gameTime - this.swingStartTick;
		if (elapsed < 0.0F) {
			return this.swingAmplitude;
		}
		return (float) (this.swingAmplitude * Math.exp(-elapsed / DECAY_TAU));
	}

	/** The pendulum's angular frequency: longer chains swing slower, as they should. */
	public static float angularFrequency(int length) {
		return (float) (0.35D / Math.sqrt(Math.max(1, length)));
	}

	public static void serverTick(Level level, BlockPos pos, BlockState state, SwingingChainBlockEntity chain) {
		if (chain.impulseCooldown > 0) {
			chain.impulseCooldown--;
			return;
		}

		int length = state.getValue(SwingingChainBlock.LENGTH);
		// one AABB spanning the whole hanging column -- the cheap part of the anchor-block design
		AABB column = new AABB(
				pos.getX(), pos.getY() - (length - 1), pos.getZ(),
				pos.getX() + 1.0D, pos.getY() + 1.0D, pos.getZ() + 1.0D).inflate(0.15D, 0.0D, 0.15D);

		List<LivingEntity> movers = level.getEntitiesOfClass(LivingEntity.class, column, LivingEntity::isAlive);
		if (movers.isEmpty()) {
			return;
		}

		LivingEntity fastest = null;
		double bestSpeed = 0.0D;
		for (LivingEntity mover : movers) {
			double speed = mover.getDeltaMovement().horizontalDistance();
			if (speed > bestSpeed) {
				bestSpeed = speed;
				fastest = mover;
			}
		}
		if (fastest == null || bestSpeed < MIN_NUDGE_SPEED) {
			return;
		}

		float amplitude = (float) Mth.clamp(bestSpeed * SPEED_TO_DEGREES, MIN_AMPLITUDE, MAX_AMPLITUDE);
		// without this, standing and shuffling inside a chain would re-impulse it every few ticks and
		// it would never settle
		if (amplitude <= chain.decayedAmplitude(level.getGameTime()) + AMPLITUDE_EPSILON) {
			return;
		}

		Vec3 motion = fastest.getDeltaMovement();
		chain.impulse((float) Math.toDegrees(Mth.atan2(motion.z, motion.x)), amplitude, level.getGameTime());
		chain.impulseCooldown = IMPULSE_COOLDOWN_TICKS;

		level.playSound(null, pos, SoundEvents.CHAIN_HIT, SoundSource.BLOCKS,
				0.35F, 0.9F + level.getRandom().nextFloat() * 0.2F);
	}

	/**
	 * Starts a fresh swing. Safe to call from structure/worldgen code as well as from the tick scan.
	 *
	 * @param yaw       direction the chain is pushed, in degrees (0 = +X, 90 = +Z)
	 * @param amplitude peak deflection in degrees
	 * @param gameTime  tick the swing starts from
	 */
	public void impulse(float yaw, float amplitude, long gameTime) {
		this.swingYaw = yaw;
		this.swingAmplitude = amplitude;
		this.swingStartTick = gameTime;
		this.swinging = true;
		this.setChanged();
		if (this.level != null) {
			// pushes getUpdatePacket() to everyone tracking this chunk
			this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(),
					Block.UPDATE_CLIENTS);
		}
	}

	private void writeSwing(CompoundTag tag) {
		tag.putBoolean("Swinging", this.swinging);
		tag.putFloat("SwingYaw", this.swingYaw);
		tag.putFloat("SwingAmplitude", this.swingAmplitude);
		tag.putLong("SwingStartTick", this.swingStartTick);
	}

	private void readSwing(CompoundTag tag) {
		this.swinging = tag.getBoolean("Swinging");
		this.swingYaw = tag.getFloat("SwingYaw");
		this.swingAmplitude = tag.getFloat("SwingAmplitude");
		this.swingStartTick = tag.getLong("SwingStartTick");
	}

	@Override
	protected void saveAdditional(CompoundTag tag) {
		super.saveAdditional(tag);
		writeSwing(tag);
	}

	@Override
	public void load(CompoundTag tag) {
		super.load(tag);
		readSwing(tag);
	}

	@Override
	public CompoundTag getUpdateTag() {
		CompoundTag tag = new CompoundTag();
		writeSwing(tag);
		return tag;
	}

	@Nullable
	@Override
	public ClientboundBlockEntityDataPacket getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}

	/**
	 * The chain hangs below its block, so the default single-block box would cull it as soon as the
	 * anchor left the frustum.
	 */
	@Override
	public AABB getRenderBoundingBox() {
		int length = this.getChainLength();
		return new AABB(this.worldPosition).expandTowards(0.0D, -length, 0.0D).inflate(0.5D, 0.0D, 0.5D);
	}
}

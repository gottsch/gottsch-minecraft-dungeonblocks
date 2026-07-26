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
import mod.gottsch.forge.dungeonblocks.core.state.properties.ChainFixture;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

/**
 * Swing state for a {@link SwingingChainBlock}.
 *
 * <p><b>The chain is never simulated, and this never ticks.</b> Nothing here integrates physics. An
 * impulse records three numbers — which way, how hard, and when — and the renderer evaluates a damped
 * pendulum from them on the fly. Impulses arrive from
 * {@code SwingingChainBlock#entityInside}, which vanilla only calls when something is genuinely
 * inside a segment, so there is no ticker and no per-tick scanning: a chain nobody is near costs
 * nothing at all on the server. The network cost is one small packet per hit rather than a
 * position stream, and each client renders smoothly at its own frame rate.
 *
 * <p>Exactly one of these exists per chain, on the top segment (see
 * {@code SwingingChainBlock#TOP}).
 *
 * <p>Impulses are decided server-side and synced; the client must not infer them, since it would
 * disagree about timing — the same lesson as {@code PotShardEntity}'s landed flag.
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
	/** Extra swing per segment of depth: a hit near the free end has more leverage on the pivot. */
	private static final float LEVERAGE_PER_SEGMENT = 0.09F;

	/** Decay time constant, in ticks: the swing visibly settles over roughly 2 seconds. */
	public static final float DECAY_TAU = 30.0F;
	/** A weighted end keeps swinging longer — more inertia against the same damping. */
	private static final float WEIGHTED_DECAY_FACTOR = 1.6F;
	/** ...and slightly slower, as the mass concentrates toward the free end. */
	private static final float WEIGHTED_FREQUENCY_FACTOR = 0.9F;

	private float swingYaw;
	private float swingAmplitude;
	private long swingStartTick;
	private boolean swinging;

	public SwingingChainBlockEntity(BlockPos pos, BlockState state) {
		super(ModBlockEntityTypes.SWINGING_CHAIN.get(), pos, state);
	}

	/**
	 * Number of segments hanging from here. Derived from the blocks below rather than stored, so
	 * breaking a link off the bottom shortens the chain with no bookkeeping. The walk is bounded and
	 * only ever runs for the one top segment, not per segment.
	 */
	public int getChainLength() {
		return this.level == null ? 1 : SwingingChainBlock.runLength(this.level, this.worldPosition);
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
	public float decayedAmplitude(long gameTime, float tau) {
		if (!this.swinging) {
			return 0.0F;
		}
		float elapsed = gameTime - this.swingStartTick;
		if (elapsed < 0.0F) {
			return this.swingAmplitude;
		}
		return (float) (this.swingAmplitude * Math.exp(-elapsed / tau));
	}

	/** The pendulum's angular frequency: longer chains swing slower, as they should. */
	public static float angularFrequency(int length, boolean weighted) {
		float omega = (float) (0.35D / Math.sqrt(Math.max(1, length)));
		return weighted ? omega * WEIGHTED_FREQUENCY_FACTOR : omega;
	}

	public static float decayTau(boolean weighted) {
		return weighted ? DECAY_TAU * WEIGHTED_DECAY_FACTOR : DECAY_TAU;
	}

	/** True when a fixture hangs off the end of this chain — see {@link ChainFixture#isWeighted}. */
	public boolean isWeighted() {
		if (this.level == null) {
			return false;
		}
		BlockState bottom = SwingingChainBlock.bottomSegment(this.level, this.worldPosition);
		return bottom.hasProperty(SwingingChainBlock.FIXTURE)
				&& bottom.getValue(SwingingChainBlock.FIXTURE).isWeighted();
	}

	/**
	 * Something moved through the chain. Called from
	 * {@code SwingingChainBlock#entityInside} on the server, for whichever segment was actually
	 * entered.
	 *
	 * @param mover the entity passing through
	 * @param depth how many segments below the top the contact happened
	 */
	public void nudge(LivingEntity mover, int depth) {
		if (this.level == null || this.level.isClientSide) {
			return;
		}
		double speed = mover.getDeltaMovement().horizontalDistance();
		if (speed < MIN_NUDGE_SPEED) {
			return;
		}

		long gameTime = this.level.getGameTime();
		// no ticker to count down, so throttle against the clock instead
		if (gameTime - this.swingStartTick < IMPULSE_COOLDOWN_TICKS && this.swinging) {
			return;
		}

		float leverage = 1.0F + depth * LEVERAGE_PER_SEGMENT;
		float amplitude = (float) Mth.clamp(speed * SPEED_TO_DEGREES * leverage, MIN_AMPLITUDE, MAX_AMPLITUDE);
		// without this, standing and shuffling inside a chain would re-impulse it constantly and it
		// would never settle
		if (amplitude <= this.decayedAmplitude(gameTime, decayTau(this.isWeighted())) + AMPLITUDE_EPSILON) {
			return;
		}

		Vec3 motion = mover.getDeltaMovement();
		this.impulse((float) Math.toDegrees(Mth.atan2(motion.z, motion.x)), amplitude, gameTime);

		this.level.playSound(null, this.worldPosition, SoundEvents.CHAIN_HIT, SoundSource.BLOCKS,
				0.35F, 0.9F + this.level.getRandom().nextFloat() * 0.2F);
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
		// a block of margin past the run, so a swung fixture at the end can't clip the box
		int length = this.getChainLength();
		return new AABB(this.worldPosition).expandTowards(0.0D, -(length + 1), 0.0D).inflate(0.5D, 0.0D, 0.5D);
	}
}

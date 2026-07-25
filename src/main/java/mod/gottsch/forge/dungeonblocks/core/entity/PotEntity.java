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
package mod.gottsch.forge.dungeonblocks.core.entity;

import mod.gottsch.forge.dungeonblocks.core.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

/**
 * A decorative, physics-driven prop entity: gravity pulls it down, it can be
 * shoved around by living entities ({@link #isPushable()}), and it shatters
 * into shard items on the first hit or a hard enough fall.
 *
 * @author Mark Gottschling on Jul 25, 2026
 */
public class PotEntity extends Entity {

	private static final float GRAVITY = 0.04F;
	private static final float AIR_DRAG = 0.98F;
	private static final double SETTLE_THRESHOLD = 0.003D;
	private static final float FALL_BREAK_DISTANCE = 3.0F;
	private static final int MIN_SHARDS = 2;
	private static final int MAX_SHARDS = 4;

	private double lerpX;
	private double lerpY;
	private double lerpZ;
	private float lerpYRot;
	private float lerpXRot;
	private int lerpSteps;

	public PotEntity(EntityType<? extends PotEntity> type, Level level) {
		super(type, level);
		this.blocksBuilding = false;
	}

	@Override
	protected void defineSynchedData() {
		// no synced data needed for v1
	}

	@Override
	public void tick() {
		super.tick();

		if (this.level().isClientSide) {
			if (this.lerpSteps > 0) {
				this.lerpPositionAndRotation();
			}
			return;
		}

		Vec3 motion = this.getDeltaMovement();

		if (!this.onGround() && !this.isNoGravity()) {
			motion = motion.add(0.0D, -GRAVITY, 0.0D);
		}

		this.move(MoverType.SELF, motion);
		motion = this.getDeltaMovement();

		double drag = AIR_DRAG;
		if (this.onGround()) {
			BlockPos posBelow = this.getBlockPosBelowThatAffectsMyMovement();
			drag = this.level().getBlockState(posBelow).getBlock().getFriction() * 0.91F;
			motion = new Vec3(motion.x, 0.0D, motion.z);
		}

		motion = motion.multiply(drag, 0.98D, drag);

		if (Math.abs(motion.x) < SETTLE_THRESHOLD) {
			motion = new Vec3(0.0D, motion.y, motion.z);
		}
		if (Math.abs(motion.z) < SETTLE_THRESHOLD) {
			motion = new Vec3(motion.x, motion.y, 0.0D);
		}

		this.setDeltaMovement(motion);
	}

	@Override
	public void lerpTo(double x, double y, double z, float yRot, float xRot, int steps, boolean teleport) {
		this.lerpX = x;
		this.lerpY = y;
		this.lerpZ = z;
		this.lerpYRot = yRot;
		this.lerpXRot = xRot;
		this.lerpSteps = 10;
	}

	private void lerpPositionAndRotation() {
		double newX = this.getX() + (this.lerpX - this.getX()) / this.lerpSteps;
		double newY = this.getY() + (this.lerpY - this.getY()) / this.lerpSteps;
		double newZ = this.getZ() + (this.lerpZ - this.getZ()) / this.lerpSteps;
		double yRotDelta = Mth.wrapDegrees(this.lerpYRot - this.getYRot());
		float newYRot = (float) (this.getYRot() + yRotDelta / this.lerpSteps);
		float newXRot = (float) (this.getXRot() + (this.lerpXRot - this.getXRot()) / this.lerpSteps);
		this.lerpSteps--;
		this.setPos(newX, newY, newZ);
		this.setRot(newYRot, newXRot);
	}

	@Override
	public boolean isPushable() {
		return true;
	}

	@Override
	public boolean isPickable() {
		return true;
	}

	@Override
	public boolean hurt(DamageSource damageSource, float amount) {
		if (this.isInvulnerableTo(damageSource) || this.isRemoved()) {
			return false;
		}
		this.breakAndDrop();
		return true;
	}

	@Override
	public boolean causeFallDamage(float distance, float multiplier, DamageSource source) {
		if (distance >= FALL_BREAK_DISTANCE) {
			this.breakAndDrop();
		}
		return false;
	}

	private void breakAndDrop() {
		if (this.isRemoved()) {
			return;
		}

		Level level = this.level();
		if (!level.isClientSide) {
			int shardCount = MIN_SHARDS + this.random.nextInt(MAX_SHARDS - MIN_SHARDS + 1);
			for (int i = 0; i < shardCount; i++) {
				ItemEntity shard = new ItemEntity(level, this.getX(), this.getY() + 0.1D, this.getZ(),
						new ItemStack(ModItems.POT_SHARD.get()));
				shard.setDeltaMovement(
						(this.random.nextDouble() - 0.5D) * 0.3D,
						0.2D + this.random.nextDouble() * 0.2D,
						(this.random.nextDouble() - 0.5D) * 0.3D);
				level.addFreshEntity(shard);
			}

			level.playSound(null, this.blockPosition(), SoundEvents.DECORATED_POT_SHATTER,
					SoundSource.BLOCKS, 1.0F, 0.9F + this.random.nextFloat() * 0.2F);

			if (level instanceof net.minecraft.server.level.ServerLevel serverLevel) {
				serverLevel.sendParticles(ParticleTypes.POOF, this.getX(), this.getY() + this.getBbHeight() * 0.5D,
						this.getZ(), 8, 0.2D, 0.2D, 0.2D, 0.02D);
			}
		}

		this.discard();
	}

	@Override
	protected void readAdditionalSaveData(CompoundTag compound) {
		// no persisted data for v1
	}

	@Override
	protected void addAdditionalSaveData(CompoundTag compound) {
		// no persisted data for v1
	}
}

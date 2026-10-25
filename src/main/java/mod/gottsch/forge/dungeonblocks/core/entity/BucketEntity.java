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
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

/**
 * A wooden bucket of standing water: a pot-family prop that never breaks. It has the pots' gravity,
 * pushing and settling, and a knock tips it over as it does a pot, but a hard knock or a long fall
 * only tips it too - iron-bound timber does not shatter. Tipping spills it: a splash and the vanilla
 * bucket-emptying sound, and the model hides its water once it lies on its side (see
 * {@code WoodenBucketModel}).
 *
 * <p>An attack tips an upright bucket. A player hitting one already on its side picks it up - it
 * drops as its item, as a painting does - so a survival player can clear one out of the way;
 * anything else hitting it does nothing more. A creative player removes it outright.
 *
 * <p>It carries no loot: {@link #releasePayload} is only reached through the break path, which a
 * bucket never takes.
 *
 * @author Mark Gottschling on 10/25/2026
 */
public class BucketEntity extends PotEntity {

	public BucketEntity(EntityType<? extends PotEntity> type, Level level) {
		// the material only colours shatter debris, and a bucket never shatters
		super(type, level, PotMaterial.STONE);
	}

	@Override
	protected boolean isBreakable() {
		return false;
	}

	@Override
	public boolean hurt(DamageSource damageSource, float amount) {
		if (this.isInvulnerableTo(damageSource) || this.isRemoved()) {
			return false;
		}
		if (this.level().isClientSide) {
			return true;
		}
		if (damageSource.getEntity() instanceof Player player) {
			if (player.getAbilities().instabuild) {
				this.discard();
				return true;
			}
			if (this.isTumbled()) {
				this.spawnAtLocation(new ItemStack(ModItems.WOODEN_BUCKET.get()));
				this.discard();
				return true;
			}
		}
		if (!this.isTumbled()) {
			this.tipOver();
		}
		return true;
	}

	/** Spills as it goes over: the bucket-emptying sound and a splash about the mouth. */
	@Override
	protected void tipOver() {
		super.tipOver();
		this.level().playSound(null, this.blockPosition(), SoundEvents.BUCKET_EMPTY,
				SoundSource.BLOCKS, 1.0F, 0.9F + this.random.nextFloat() * 0.2F);
		if (this.level() instanceof ServerLevel serverLevel) {
			serverLevel.sendParticles(ParticleTypes.SPLASH,
					this.getX(), this.getY() + this.getBbHeight() * 0.5D, this.getZ(),
					24, 0.3D, 0.1D, 0.3D, 0.1D);
		}
	}
}

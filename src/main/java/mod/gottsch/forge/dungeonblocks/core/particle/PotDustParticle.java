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
package mod.gottsch.forge.dungeonblocks.core.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * A small puff of terracotta grit thrown off when a ceramic pot shatters.
 *
 * <p>Deliberately tiny: a particle's quad is drawn at ±{@code quadSize}, so it spans
 * {@code 2 * quadSize} blocks. Vanilla {@code POOF} averages a quadSize of ~0.3 — about 0.6 blocks
 * across, wider than the 0.5-block pot itself, which swallowed the shard entities behind a grey
 * cloud. These motes stay near a tenth of that so the shattering stays visible.
 *
 * @author Mark Gottschling on Jul 25, 2026
 */
public class PotDustParticle extends TextureSheetParticle {

	protected PotDustParticle(ClientLevel level, SpriteSet sprites, double x, double y, double z,
			double xd, double yd, double zd) {
		super(level, x, y, z);
		this.setSize(0.02F, 0.02F);
		this.pickSprite(sprites);

		// take the server-sent velocity as-is; the 6-arg super would re-randomize and renormalize it
		this.xd = xd;
		this.yd = yd;
		this.zd = zd;

		this.quadSize = 0.02F + this.random.nextFloat() * 0.03F;
		this.lifetime = 10 + this.random.nextInt(11);
		this.gravity = 0.8F;
		this.friction = 0.9F;
		this.hasPhysics = true;

		// slight per-mote shade variation so the burst doesn't read as uniform blobs
		float shade = 0.8F + this.random.nextFloat() * 0.2F;
		this.setColor(shade, shade, shade);
	}

	@Override
	public ParticleRenderType getRenderType() {
		return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
	}

	@OnlyIn(Dist.CLIENT)
	public static class Provider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet sprites;

		public Provider(SpriteSet sprites) {
			this.sprites = sprites;
		}

		@Override
		public Particle createParticle(SimpleParticleType particleType, ClientLevel level,
				double x, double y, double z, double xd, double yd, double zd) {
			return new PotDustParticle(level, this.sprites, x, y, z, xd, yd, zd);
		}
	}
}

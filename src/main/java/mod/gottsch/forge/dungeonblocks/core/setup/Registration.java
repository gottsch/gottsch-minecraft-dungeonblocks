/*
 * This file is part of  DungeonBlocks.
 * Copyright (c) 2022 Mark Gottschling (gottsch)
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
package mod.gottsch.forge.dungeonblocks.core.setup;

import mod.gottsch.forge.dungeonblocks.DungeonBlocks;
import mod.gottsch.forge.dungeonblocks.core.block.BarredWindows;
import mod.gottsch.forge.dungeonblocks.core.block.CorbelBlocks;
import mod.gottsch.forge.dungeonblocks.core.block.LedgeBlocks;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * 
 * @author Mark Gottschling on Aug 28, 2022
 *
 */
public class Registration {
	/*
	 * deferred registries
	 */
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, DungeonBlocks.MOD_ID);
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DungeonBlocks.MOD_ID);
	public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, DungeonBlocks.MOD_ID);
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, DungeonBlocks.MOD_ID);
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, DungeonBlocks.MOD_ID);

	/**
	 * 
	 */
	public static void registerBlocks() {
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

		BarredWindows.register();
		//KeystoneBlocks.register();
		LedgeBlocks.register();
		CorbelBlocks.register();

		BLOCKS.register(eventBus);
	}
	
	/**
	 * 
	 */
	public static void registerItems() {
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
		ITEMS.register(eventBus);
	}

	public static void registerParticles(IEventBus bus) {
		PARTICLES.register(bus);
	}

	public static void registerEntityTypes(IEventBus bus) {
		ENTITY_TYPES.register(bus);
	}

	public static void registerBlockEntityTypes(IEventBus bus) {
		BLOCK_ENTITY_TYPES.register(bus);
	}
}

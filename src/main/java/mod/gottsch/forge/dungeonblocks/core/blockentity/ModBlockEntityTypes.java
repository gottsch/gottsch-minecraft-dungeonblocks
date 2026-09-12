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

import mod.gottsch.forge.dungeonblocks.core.block.ModBlocks;
import mod.gottsch.forge.dungeonblocks.core.setup.Registration;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;

/**
 * @author Mark Gottschling on Jul 26, 2026
 */
public class ModBlockEntityTypes {

	public static final RegistryObject<BlockEntityType<SwingingChainBlockEntity>> SWINGING_CHAIN =
			Registration.BLOCK_ENTITY_TYPES.register("swinging_chain",
					() -> BlockEntityType.Builder
							.of(SwingingChainBlockEntity::new, ModBlocks.SWINGING_CHAIN.get())
							.build(null));

	/**
	 * <b>One type for every banner variant.</b> The variants differ only by texture, and the
	 * renderer derives that from the block's own id - so registering a type per variant would buy
	 * nothing and would need a matching renderer registration each time. Valid blocks are read from
	 * {@link ModBlocks#BANNERS} inside the supplier, which runs after the block registry is filled.
	 */
	public static final RegistryObject<BlockEntityType<DungeonBannerBlockEntity>> DUNGEON_BANNER =
			Registration.BLOCK_ENTITY_TYPES.register("dungeon_banner",
					() -> BlockEntityType.Builder
							.of(DungeonBannerBlockEntity::new, ModBlocks.BANNERS.stream()
									.map(RegistryObject::get)
									.toArray(net.minecraft.world.level.block.Block[]::new))
							.build(null));

	public static void register(IEventBus bus) {
		Registration.registerBlockEntityTypes(bus);
	}
}

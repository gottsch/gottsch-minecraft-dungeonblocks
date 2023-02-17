/*
 * This file is part of  Dungeon Blocks.
 * Copyright (c) 2020 Mark Gottschling (gottsch)
 * 
 * All rights reserved.
 *
 * Dungeon Blocks is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Dungeon Blocks is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Dungeon Blocks.  If not, see <http://www.gnu.org/licenses/lgpl>.
 */
package mod.gottsch.forge.dungeonblocks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mod.gottsch.forge.dungeonblocks.core.block.ModBlocks;
import mod.gottsch.forge.dungeonblocks.core.config.DungeonBlocksConfig;
import mod.gottsch.forge.dungeonblocks.core.item.ModItems;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * @author Mark Gottschling on Jan 1, 2020
 *
 */
@Mod(value = DungeonBlocks.MOD_ID)
public class DungeonBlocks {
	// logger
	public static final Logger LOGGER = LogManager.getLogger(DungeonBlocks.class.getSimpleName());

	// constants
	public static final String MOD_ID = "dungeonblocks";
	protected static final String NAME = "DungeonBlocks";
	protected static final String VERSION = "1.1.1";
	protected static final String UPDATE_JSON_URL = "https://raw.githubusercontent.com/gottsch/gottsch-minecraft-dungeonblocks/1.18.2-master/update.json";

	public static DungeonBlocks instance;

	public DungeonBlocks() {
		DungeonBlocks.instance = this;
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, DungeonBlocksConfig.COMMON_CONFIG);

		// register the deferred registries
		ModBlocks.register();
		ModItems.register();
				
		// Register the setup method for modloading
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
	}

	/**
	 * ie. preint
	 * 
	 * @param event
	 */
	private void setup(final FMLCommonSetupEvent event) {
	}

}

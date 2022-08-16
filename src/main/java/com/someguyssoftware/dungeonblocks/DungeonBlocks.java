/**
 * 
 */
package com.someguyssoftware.dungeonblocks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.someguyssoftware.dungeonblocks.config.DungeonBlocksConfig;
import com.someguyssoftware.gottschcore.annotation.Credits;
import com.someguyssoftware.gottschcore.annotation.ModInfo;
import com.someguyssoftware.gottschcore.config.IConfig;
import com.someguyssoftware.gottschcore.mod.IMod;

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
@ModInfo(
		modid = DungeonBlocks.MOD_ID, 
		name = DungeonBlocks.NAME, 
		version = DungeonBlocks.VERSION, 
		minecraftVersion = "1.18.2", 
		forgeVersion = "40.1.0", 
		updateJsonUrl = DungeonBlocks.UPDATE_JSON_URL)
@Credits(values = { "DungeonBlocks for Minecraft 1.14+ was first developed by Mark Gottschling on Jan 1, 2020." })
public class DungeonBlocks implements IMod {
	// logger
	public static final Logger LOGGER = LogManager.getLogger(DungeonBlocks.class.getSimpleName());

	// constants
	public static final String MOD_ID = "dungeonblocks";
	protected static final String NAME = "DungeonBlocks";
	protected static final String VERSION = "1.1.1";
	protected static final String UPDATE_JSON_URL = "https://raw.githubusercontent.com/gottsch/gottsch-minecraft-dungeonblocks/1.18.2-master/update.json";

	public static DungeonBlocks instance;
	private static DungeonBlocksConfig config;

	public DungeonBlocks() {
		DungeonBlocks.instance = this;
		DungeonBlocks.config = new DungeonBlocksConfig(this);
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, DungeonBlocksConfig.COMMON_CONFIG);

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

	@Override
	public IMod getInstance() {
		return DungeonBlocks.instance;
	}

	@Override
	public String getId() {
		return DungeonBlocks.MOD_ID;
	}

	@Override
	public IConfig getConfig() {
		return DungeonBlocks.config;
	}
}

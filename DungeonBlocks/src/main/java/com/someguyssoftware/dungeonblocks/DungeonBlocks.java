/**
 * 
 */
package com.someguyssoftware.dungeonblocks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.someguyssoftware.dungeonblocks.config.DungeonBlocksConfig;
import com.someguyssoftware.gottschcore.annotation.Credits;
import com.someguyssoftware.gottschcore.annotation.ModInfo;
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
@ModInfo(modid = DungeonBlocks.MOD_ID, name = DungeonBlocks.NAME, version = DungeonBlocks.VERSION, minecraftVersion = "1.14.4", forgeVersion = "28.1.0", updateJsonUrl = "https://raw.githubusercontent.com/gottsch/gottsch-minecraft-dungeonblocks/master/DungeonBlocks/update.json")
@Credits(values = { "DungeonBlocks for Minecraft 1.14+ was first developed by Mark Gottschling on Jan 1, 2020." })
public class DungeonBlocks implements IMod {
	// logger
	public static final Logger LOGGER = LogManager.getLogger(DungeonBlocks.class.getSimpleName());

	// constants
	public static final String MOD_ID = "dungeonblocks";
	protected static final String NAME = "DungeonBlocks";
	protected static final String VERSION = "1.0.0";

	public static DungeonBlocks instance;

	public DungeonBlocks() {
		DungeonBlocks.instance = this;

//		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, DungeonBlocksConfig.CLIENT_CONFIG);
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, DungeonBlocksConfig.COMMON_CONFIG);

		// Register the setup method for modloading
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

		// test accessing the logs
//		DungeonBlocksConfig.LOGGING.filename.get();
	}

	/**
	 * ie. preint
	 * 
	 * @param event
	 */
	private void setup(final FMLCommonSetupEvent event) {

		// some preinit code
//		LOGGER.info("HELLO FROM PREINIT");
//		LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
	}

	@Override
	public IMod getInstance() {
		return this.instance;
	}

	@Override
	public String getId() {
		return DungeonBlocks.MOD_ID;
	}
}

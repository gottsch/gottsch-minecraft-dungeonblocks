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

import net.minecraft.block.Blocks;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

/**
 * @author Mark Gottschling on Jan 1, 2020
 *
 */
@Mod(value=DungeonBlocks.MODID)
@ModInfo(
		modid=DungeonBlocks.MODID,
		name=DungeonBlocks.NAME,
		version=DungeonBlocks.VERSION,
		minecraftVersion="1.14.4",
		forgeVersion="28.1.0",
		updateJsonUrl="https://raw.githubusercontent.com/gottsch/gottsch-minecraft-DungeonBlocks/master/DungeonBlocks1.12.2/update.json")
@Credits(values={"DungeonBlocks for Minecraft 1.14+ was first developed by Mark Gottschling on Jan 1, 2020."})

public class DungeonBlocks implements IMod {
	// logger
	public static final Logger LOGGER = LogManager.getLogger(DungeonBlocks.class.getSimpleName());

	// constants
	public static final String MODID = "dungeonblocks";
	protected static final String NAME = "DungeonBlocks";
	protected static final String VERSION = "1.0.0";
	
	public static DungeonBlocks instance;

	public DungeonBlocks() {
		DungeonBlocks.instance = this;
		
		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, DungeonBlocksConfig.CLIENT_CONFIG);
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, DungeonBlocksConfig.COMMON_CONFIG);

		// Register the setup method for modloading
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

		DungeonBlocksConfig.loadConfig(DungeonBlocksConfig.CLIENT_CONFIG, FMLPaths.CONFIGDIR.get().resolve("DungeonBlocks-client.toml"));
		DungeonBlocksConfig.loadConfig(DungeonBlocksConfig.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve("DungeonBlocks-common.toml"));

		// test accessing the logs
		DungeonBlocksConfig.LOGGING.filename.get();
	}
	
	/**
	 * ie. preint
	 * @param event
	 */
	private void setup(final FMLCommonSetupEvent event) {   	

		// some preinit code
		LOGGER.info("HELLO FROM PREINIT");
		LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
	}

	@Override
	public IMod getInstance() {
		return this.instance;
	}


	@Override
	public String getId() {
		return DungeonBlocks.MODID;
	}
}

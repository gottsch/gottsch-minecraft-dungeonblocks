/**
 * 
 */
package com.someguyssoftware.dungeonblocks.config;

import java.nio.file.Path;

import org.apache.commons.lang3.tuple.Pair;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import com.someguyssoftware.gottschcore.GottschCore;
import com.someguyssoftware.gottschcore.config.AbstractConfig;
import com.someguyssoftware.gottschcore.mod.IMod;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

/**
 * 
 * @author Mark Gottschling on Jan 5, 2020
 *
 */
@Mod.EventBusSubscriber
public class DungeonBlocksConfig extends AbstractConfig {
    public static ForgeConfigSpec COMMON_CONFIG;
    public static ForgeConfigSpec CLIENT_CONFIG;
    
    static {
        COMMON_CONFIG = COMMON_BUILDER.build();
        CLIENT_CONFIG = CLIENT_BUILDER.build();
    }
    
    /**
     * 
     * @param mod
     */
    public DungeonBlocksConfig(IMod mod) {
    }
    
    public static class BlockID {
    	// facade
    	public static final String STONE_FACADE_ID = "stone_facade_block";
    	public static final String SMOOTH_STONE_FACADE_ID = "smooth_stone_facade_block";
    	public static final String COBBLESTONE_FACADE_ID = "cobblestone_facade_block";
    	public static final String MOSSY_COBBLESTONE_FACADE_ID = "mossy_cobblestone_facade_block";
    	public static final String BRICKS_FACADE_ID = "bricks_facade_block";
    	public static final String STONE_BRICKS_FACADE_ID = "stone_bricks_facade_block";
    	public static final String CRACKED_STONE_BRICKS_FACADE_ID = "cracked_stone_bricks_facade_block";
    	public static final String CHISELED_STONE_BRICKS_FACADE_ID = "chiseled_stone_bricks_facade_block";
    	public static final String OBSIDIAN_FACADE_ID = "obsidian_facade_block";
    	
    	public static final String SANDSTONE_FACADE_ID = "sandstone_facade_block";
    	public static final String SMOOTH_SANDSTONE_FACADE_ID = "smooth_sandstone_facade_block";
    	public static final String CHISELED_SANDSTONE_FACADE_ID = "chiseled_sandstone_facade_block";
    	public static final String CUT_SANDSTONE_FACADE_ID = "cut_sandstone_facade_block";
    	public static final String RED_SANDSTONE_FACADE_ID = "red_sandstone_facade_block";
    	public static final String SMOOTH_RED_SANDSTONE_FACADE_ID = "smooth_red_sandstone_facade_block";
    	public static final String CHISELED_RED_SANDSTONE_FACADE_ID = "chiseled_red_sandstone_facade_block";
    	public static final String CUT_RED_SANDSTONE_FACADE_ID = "cut_red_sandstone_facade_block";
    	
    	public static final String GRANITE_FACADE_ID = "granite_facade_block";
    	public static final String POLISHED_GRANITE_FACADE_ID = "polished_granite_facade_block";
    	public static final String DIORITE_FACADE_ID = "diorite_facade_block";
    	public static final String POLISHED_DIORITE_FACADE_ID = "polished_diorite_facade_block";
    	public static final String ANDESITE_FACADE_ID = "andesite_facade_block";
    	public static final String POLISHED_ANDESITE_FACADE_ID = "polished_andesite_facade_block";
    	
    	// quarter
    	public static final String STONE_QUARTER_FACADE_ID = "stone_quarter_facade_block";
    	public static final String SMOOTH_STONE_QUARTER_FACADE_ID = "smooth_stone_quarter_facade_block";
    	public static final String COBBLESTONE_QUARTER_FACADE_ID = "cobblestone_quarter_facade_block";
    	public static final String MOSSY_COBBLESTONE_QUARTER_FACADE_ID = "mossy_cobblestone_quarter_facade_block";
    	public static final String BRICKS_QUARTER_FACADE_ID = "bricks_quarter_facade_block";
    	public static final String STONE_BRICKS_QUARTER_FACADE_ID = "stone_bricks_quarter_facade_block";
    	public static final String CRACKED_STONE_BRICKS_QUARTER_FACADE_ID = "cracked_stone_bricks_quarter_facade_block";
    	public static final String CHISELED_STONE_BRICKS_QUARTER_FACADE_ID = "chiseled_stone_bricks_quarter_facade_block";
    	public static final String OBSIDIAN_QUARTER_FACADE_ID = "obsidian_quarter_facade_block";
    	public static final String SANDSTONE_QUARTER_FACADE_ID = "sandstone_quarter_facade_block";
    	public static final String SMOOTH_SANDSTONE_QUARTER_FACADE_ID = "smooth_sandstone_quarter_facade_block";
    	public static final String CHISELED_SANDSTONE_QUARTER_FACADE_ID = "chiseled_sandstone_quarter_facade_block";
    	public static final String CUT_SANDSTONE_QUARTER_FACADE_ID = "cut_sandstone_quarter_facade_block";
    	public static final String RED_SANDSTONE_QUARTER_FACADE_ID = "red_sandstone_quarter_facade_block";
    	public static final String SMOOTH_RED_SANDSTONE_QUARTER_FACADE_ID = "smooth_red_sandstone_quarter_facade_block";
    	public static final String CHISELED_RED_SANDSTONE_QUARTER_FACADE_ID = "chiseled_red_sandstone_quarter_facade_block";
    	public static final String CUT_RED_SANDSTONE_QUARTER_FACADE_ID = "cut_red_sandstone_quarter_facade_block";
    	public static final String GRANITE_QUARTER_FACADE_ID = "granite_quarter_facade_block";
    	public static final String POLISHED_GRANITE_QUARTER_FACADE_ID = "polished_granite_quarter_facade_block";
    	public static final String DIORITE_QUARTER_FACADE_ID = "diorite_quarter_facade_block";
    	public static final String POLISHED_DIORITE_QUARTER_FACADE_ID = "polished_diorite_quarter_facade_block";
    	public static final String ANDESITE_QUARTER_FACADE_ID = "andesite_quarter_facade_block";
    	public static final String POLISHED_ANDESITE_QUARTER_FACADE_ID = "polished_andesite_quarter_facade_block";
    	
    	// fluted
    	public static final String STONE_FLUTED_ID = "stone_fluted_block";
    	public static final String SMOOTH_STONE_FLUTED_ID = "smooth_stone_fluted_block";
    	public static final String COBBLESTONE_FLUTED_ID = "cobblestone_fluted_block";
    	public static final String MOSSY_COBBLESTONE_FLUTED_ID = "mossy_cobblestone_fluted_block";
    	public static final String BRICKS_FLUTED_ID = "bricks_fluted_block";
    	public static final String STONE_BRICKS_FLUTED_ID = "stone_bricks_fluted_block";
    	public static final String CRACKED_STONE_BRICKS_FLUTED_ID = "cracked_stone_bricks_fluted_block";
    	public static final String CHISELED_STONE_BRICKS_FLUTED_ID = "chiseled_stone_bricks_fluted_block";
    	public static final String OBSIDIAN_FLUTED_ID = "obsidian_fluted_block";
    	public static final String SANDSTONE_FLUTED_ID = "sandstone_fluted_block";
    	public static final String SMOOTH_SANDSTONE_FLUTED_ID = "smooth_sandstone_fluted_block";
    	public static final String CHISELED_SANDSTONE_FLUTED_ID = "chiseled_sandstone_fluted_block";
    	public static final String CUT_SANDSTONE_FLUTED_ID = "cut_sandstone_fluted_block";
    	public static final String RED_SANDSTONE_FLUTED_ID = "red_sandstone_fluted_block";
    	public static final String SMOOTH_RED_SANDSTONE_FLUTED_ID = "smooth_red_sandstone_fluted_block";
    	public static final String CHISELED_RED_SANDSTONE_FLUTED_ID = "chiseled_red_sandstone_fluted_block";
    	public static final String CUT_RED_SANDSTONE_FLUTED_ID = "cut_red_sandstone_fluted_block";
    	public static final String GRANITE_FLUTED_ID = "granite_fluted_block";
    	public static final String POLISHED_GRANITE_FLUTED_ID = "polished_granite_fluted_block";
    	public static final String DIORITE_FLUTED_ID = "diorite_fluted_block";
    	public static final String POLISHED_DIORITE_FLUTED_ID = "polished_diorite_fluted_block";
    	public static final String ANDESITE_FLUTED_ID = "andesite_fluted_block";
    	public static final String POLISHED_ANDESITE_FLUTED_ID = "polished_andesite_fluted_block";
    	
    	// fluted facade
    	public static final String STONE_FLUTED_FACADE_ID = "stone_fluted_facade_block";
    	public static final String SMOOTH_STONE_FLUTED_FACADE_ID = "smooth_stone_fluted_facade_block";
    	public static final String COBBLESTONE_FLUTED_FACADE_ID = "cobblestone_fluted_facade_block";
    	public static final String MOSSY_COBBLESTONE_FLUTED_FACADE_ID = "mossy_cobblestone_fluted_facade_block";
    	public static final String BRICKS_FLUTED_FACADE_ID = "bricks_fluted_facade_block";
    	public static final String STONE_BRICKS_FLUTED_FACADE_ID = "stone_bricks_fluted_facade_block";
    	public static final String CRACKED_STONE_BRICKS_FLUTED_FACADE_ID = "cracked_stone_bricks_fluted_facade_block";
    	public static final String CHISELED_STONE_BRICKS_FLUTED_FACADE_ID = "chiseled_stone_bricks_fluted_facade_block";
    	public static final String OBSIDIAN_FLUTED_FACADE_ID = "obsidian_fluted_facade_block";
    	public static final String SANDSTONE_FLUTED_FACADE_ID = "sandstone_fluted_facade_block";
    	public static final String SMOOTH_SANDSTONE_FLUTED_FACADE_ID = "smooth_sandstone_fluted_facade_block";
    	public static final String CHISELED_SANDSTONE_FLUTED_FACADE_ID = "chiseled_sandstone_fluted_facade_block";
    	public static final String CUT_SANDSTONE_FLUTED_FACADE_ID = "cut_sandstone_fluted_facade_block";
    	public static final String RED_SANDSTONE_FLUTED_FACADE_ID = "red_sandstone_fluted_facade_block";
    	public static final String SMOOTH_RED_SANDSTONE_FLUTED_FACADE_ID = "smooth_red_sandstone_fluted_facade_block";
    	public static final String CHISELED_RED_SANDSTONE_FLUTED_FACADE_ID = "chiseled_red_sandstone_fluted_facade_block";
    	public static final String CUT_RED_SANDSTONE_FLUTED_FACADE_ID = "cut_red_sandstone_fluted_facade_block";
    	public static final String GRANITE_FLUTED_FACADE_ID = "granite_fluted_facade_block";
    	public static final String POLISHED_GRANITE_FLUTED_FACADE_ID = "polished_granite_fluted_facade_block";
    	public static final String DIORITE_FLUTED_FACADE_ID = "diorite_fluted_facade_block";
    	public static final String POLISHED_DIORITE_FLUTED_FACADE_ID = "polished_diorite_fluted_facade_block";
    	public static final String ANDESITE_FLUTED_FACADE_ID = "andesite_fluted_facade_block";
    	public static final String POLISHED_ANDESITE_FLUTED_FACADE_ID = "polished_andesite_fluted_facade_block";

    }
    
//    public static class Mod {
//    	public ConfigValue<String> folder;
//    	@Deprecated
//    	public ForgeConfigSpec.BooleanValue enabled;
//    	public ForgeConfigSpec.BooleanValue enableVersionChecker;
//    	public ConfigValue<String> latestVersion;
//    	public ForgeConfigSpec.BooleanValue latestVersionReminder;
//    	
//	    public Mod(final ForgeConfigSpec.Builder builder) {
//			builder
//			.comment("General mod properties")
//			.push(MOD_CATEGORY);    	
//			
//		    folder = builder.comment("The relative path to the mods folder.").define("folder", "mods");
//		    enabled = builder.comment("").define("enabled", true);
//		    enableVersionChecker = builder.comment("").define("enableVersionChecker", true);
//		    // TODO could get the annotation @Version here if null;
//		    latestVersion = builder.comment("").define("latestVersion", "");
//		    latestVersionReminder = builder.comment("").define("latestVersionReminder", true);
//	    }	 
//    }
    @SubscribeEvent
    public static void onLoad(final ModConfig.Loading configEvent) {

    }

    @SubscribeEvent
    public static void onReload(final ModConfig.ConfigReloading configEvent) {
    }
}

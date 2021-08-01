/**
 * 
 */
package com.someguyssoftware.dungeonblocks.block;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.common.base.Preconditions;
import com.someguyssoftware.dungeonblocks.DungeonBlocks;
import com.someguyssoftware.dungeonblocks.config.DungeonBlocksConfig.BlockID;
import com.someguyssoftware.dungeonblocks.item.ModItemGroups;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.IForgeRegistry;

/**
 * @author Mark Gottschling on Jan 12, 2020
 *
 */
public class ModBlocks {

	/*
	 * blocks
	 */
	// facade blocks
	public static  Block STONE_FACADE;
	public static  Block SMOOTH_STONE_FACADE;
	public static  Block COBBLESTONE_FACADE;
	public static  Block MOSSY_COBBLESTONE_FACADE;
	public static  Block BRICKS_FACADE;
	public static  Block STONE_BRICKS_FACADE;
	public static  Block MOSSY_STONE_BRICKS_FACADE;
	public static  Block CRACKED_STONE_BRICKS_FACADE;
	public static  Block CHISELED_STONE_BRICKS_FACADE;
	public static  Block OBSIDIAN_FACADE;
	public static  Block SANDSTONE_FACADE;
	public static  Block SMOOTH_SANDSTONE_FACADE;
	public static  Block CHISELED_SANDSTONE_FACADE;
	public static  Block CUT_SANDSTONE_FACADE;
	public static  Block RED_SANDSTONE_FACADE;
	public static  Block SMOOTH_RED_SANDSTONE_FACADE;
	public static  Block CHISELED_RED_SANDSTONE_FACADE;
	public static  Block CUT_RED_SANDSTONE_FACADE;
	public static  Block GRANITE_FACADE;
	public static  Block POLISHED_GRANITE_FACADE;
	public static  Block DIORITE_FACADE;
	public static  Block POLISHED_DIORITE_FACADE;
	public static  Block ANDESITE_FACADE;
	public static  Block POLISHED_ANDESITE_FACADE;

	// quarter facade
	public static  Block STONE_QUARTER_FACADE;
	public static  Block SMOOTH_STONE_QUARTER_FACADE;
	public static  Block COBBLESTONE_QUARTER_FACADE;
	public static  Block MOSSY_COBBLESTONE_QUARTER_FACADE;
	public static  Block BRICKS_QUARTER_FACADE;
	public static  Block STONE_BRICKS_QUARTER_FACADE;
	public static  Block MOSSY_STONE_BRICKS_QUARTER_FACADE;
	public static  Block CRACKED_STONE_BRICKS_QUARTER_FACADE;
	public static  Block CHISELED_STONE_BRICKS_QUARTER_FACADE;
	public static  Block OBSIDIAN_QUARTER_FACADE;
	public static  Block SANDSTONE_QUARTER_FACADE;
	public static  Block SMOOTH_SANDSTONE_QUARTER_FACADE;
	public static  Block CHISELED_SANDSTONE_QUARTER_FACADE;
	public static  Block CUT_SANDSTONE_QUARTER_FACADE;
	public static  Block RED_SANDSTONE_QUARTER_FACADE;
	public static  Block SMOOTH_RED_SANDSTONE_QUARTER_FACADE;
	public static  Block CHISELED_RED_SANDSTONE_QUARTER_FACADE;
	public static  Block CUT_RED_SANDSTONE_QUARTER_FACADE;
	public static  Block GRANITE_QUARTER_FACADE;
	public static  Block POLISHED_GRANITE_QUARTER_FACADE;
	public static  Block DIORITE_QUARTER_FACADE;
	public static  Block POLISHED_DIORITE_QUARTER_FACADE;
	public static  Block ANDESITE_QUARTER_FACADE;
	public static  Block POLISHED_ANDESITE_QUARTER_FACADE;

	// fluted
	public static  Block STONE_FLUTED;
	public static  Block SMOOTH_STONE_FLUTED;
	public static  Block COBBLESTONE_FLUTED;
	public static  Block MOSSY_COBBLESTONE_FLUTED;
	public static  Block BRICKS_FLUTED;
	public static  Block STONE_BRICKS_FLUTED;
	public static  Block MOSSY_STONE_BRICKS_FLUTED;
	public static  Block CRACKED_STONE_BRICKS_FLUTED;
	public static  Block CHISELED_STONE_BRICKS_FLUTED;
	public static  Block OBSIDIAN_FLUTED;
	public static  Block SANDSTONE_FLUTED;
	public static  Block SMOOTH_SANDSTONE_FLUTED;
	public static  Block CHISELED_SANDSTONE_FLUTED;
	public static  Block CUT_SANDSTONE_FLUTED;
	public static  Block RED_SANDSTONE_FLUTED;
	public static  Block SMOOTH_RED_SANDSTONE_FLUTED;
	public static  Block CHISELED_RED_SANDSTONE_FLUTED;
	public static  Block CUT_RED_SANDSTONE_FLUTED;
	public static  Block GRANITE_FLUTED;
	public static  Block POLISHED_GRANITE_FLUTED;
	public static  Block DIORITE_FLUTED;
	public static  Block POLISHED_DIORITE_FLUTED;
	public static  Block ANDESITE_FLUTED;
	public static  Block POLISHED_ANDESITE_FLUTED;

	// fluted facade
	public static  Block STONE_FLUTED_FACADE;
	public static  Block SMOOTH_STONE_FLUTED_FACADE;
	public static  Block COBBLESTONE_FLUTED_FACADE;
	public static  Block MOSSY_COBBLESTONE_FLUTED_FACADE;
	public static  Block BRICKS_FLUTED_FACADE;
	public static  Block STONE_BRICKS_FLUTED_FACADE;
	public static  Block MOSSY_STONE_BRICKS_FLUTED_FACADE;
	public static  Block CRACKED_STONE_BRICKS_FLUTED_FACADE;
	public static  Block CHISELED_STONE_BRICKS_FLUTED_FACADE;
	public static  Block OBSIDIAN_FLUTED_FACADE;
	public static  Block SANDSTONE_FLUTED_FACADE;
	public static  Block SMOOTH_SANDSTONE_FLUTED_FACADE;
	public static  Block CHISELED_SANDSTONE_FLUTED_FACADE;
	public static  Block CUT_SANDSTONE_FLUTED_FACADE;
	public static  Block RED_SANDSTONE_FLUTED_FACADE;
	public static  Block SMOOTH_RED_SANDSTONE_FLUTED_FACADE;
	public static  Block CHISELED_RED_SANDSTONE_FLUTED_FACADE;
	public static  Block CUT_RED_SANDSTONE_FLUTED_FACADE;
	public static  Block GRANITE_FLUTED_FACADE;
	public static  Block POLISHED_GRANITE_FLUTED_FACADE;
	public static  Block DIORITE_FLUTED_FACADE;
	public static  Block POLISHED_DIORITE_FLUTED_FACADE;
	public static  Block ANDESITE_FLUTED_FACADE;
	public static  Block POLISHED_ANDESITE_FLUTED_FACADE;

	// sill
	public static  Block STONE_SILL;
	public static  Block SMOOTH_STONE_SILL;
	public static  Block COBBLESTONE_SILL;
	public static  Block MOSSY_COBBLESTONE_SILL;
	public static  Block BRICKS_SILL;
	public static  Block STONE_BRICKS_SILL;
	public static  Block MOSSY_STONE_BRICKS_SILL;
	public static  Block CRACKED_STONE_BRICKS_SILL;
	public static  Block CHISELED_STONE_BRICKS_SILL;
	public static  Block OBSIDIAN_SILL;
	public static  Block SANDSTONE_SILL;
	public static  Block SMOOTH_SANDSTONE_SILL;
	public static  Block CHISELED_SANDSTONE_SILL;
	public static  Block CUT_SANDSTONE_SILL;
	public static  Block RED_SANDSTONE_SILL;
	public static  Block SMOOTH_RED_SANDSTONE_SILL;
	public static  Block CHISELED_RED_SANDSTONE_SILL;
	public static  Block CUT_RED_SANDSTONE_SILL;
	public static  Block GRANITE_SILL;
	public static  Block POLISHED_GRANITE_SILL;
	public static  Block DIORITE_SILL;
	public static  Block POLISHED_DIORITE_SILL;
	public static  Block ANDESITE_SILL;
	public static  Block POLISHED_ANDESITE_SILL;

	// double sill
	public static  Block STONE_DOUBLE_SILL;
	public static  Block SMOOTH_STONE_DOUBLE_SILL;
	public static  Block COBBLESTONE_DOUBLE_SILL;
	public static  Block MOSSY_COBBLESTONE_DOUBLE_SILL;
	public static  Block BRICKS_DOUBLE_SILL;
	public static  Block STONE_BRICKS_DOUBLE_SILL;
	public static  Block MOSSY_STONE_BRICKS_DOUBLE_SILL;
	public static  Block CRACKED_STONE_BRICKS_DOUBLE_SILL;
	public static  Block CHISELED_STONE_BRICKS_DOUBLE_SILL;
	public static  Block OBSIDIAN_DOUBLE_SILL;
	public static  Block SANDSTONE_DOUBLE_SILL;
	public static  Block SMOOTH_SANDSTONE_DOUBLE_SILL;
	public static  Block CHISELED_SANDSTONE_DOUBLE_SILL;
	public static  Block CUT_SANDSTONE_DOUBLE_SILL;
	public static  Block RED_SANDSTONE_DOUBLE_SILL;
	public static  Block SMOOTH_RED_SANDSTONE_DOUBLE_SILL;
	public static  Block CHISELED_RED_SANDSTONE_DOUBLE_SILL;
	public static  Block CUT_RED_SANDSTONE_DOUBLE_SILL;
	public static  Block GRANITE_DOUBLE_SILL;
	public static  Block POLISHED_GRANITE_DOUBLE_SILL;
	public static  Block DIORITE_DOUBLE_SILL;
	public static  Block POLISHED_DIORITE_DOUBLE_SILL;
	public static  Block ANDESITE_DOUBLE_SILL;
	public static  Block POLISHED_ANDESITE_DOUBLE_SILL;

	// cornice
	public static  Block STONE_CORNICE;
	public static  Block SMOOTH_STONE_CORNICE;
	public static  Block COBBLESTONE_CORNICE;
	public static  Block MOSSY_COBBLESTONE_CORNICE;
	public static  Block BRICKS_CORNICE;
	public static  Block STONE_BRICKS_CORNICE;
	public static  Block MOSSY_STONE_BRICKS_CORNICE;
	public static  Block CRACKED_STONE_BRICKS_CORNICE;
	public static  Block CHISELED_STONE_BRICKS_CORNICE;
	public static  Block OBSIDIAN_CORNICE;
	public static  Block SANDSTONE_CORNICE;
	public static  Block SMOOTH_SANDSTONE_CORNICE;
	public static  Block CHISELED_SANDSTONE_CORNICE;
	public static  Block CUT_SANDSTONE_CORNICE;
	public static  Block RED_SANDSTONE_CORNICE;
	public static  Block SMOOTH_RED_SANDSTONE_CORNICE;
	public static  Block CHISELED_RED_SANDSTONE_CORNICE;
	public static  Block CUT_RED_SANDSTONE_CORNICE;
	public static  Block GRANITE_CORNICE;
	public static  Block POLISHED_GRANITE_CORNICE;
	public static  Block DIORITE_CORNICE;
	public static  Block POLISHED_DIORITE_CORNICE;
	public static  Block ANDESITE_CORNICE;
	public static  Block POLISHED_ANDESITE_CORNICE;

	// crown molding
	public static  Block STONE_CROWN_MOLDING;
	public static  Block SMOOTH_STONE_CROWN_MOLDING;
	public static  Block COBBLESTONE_CROWN_MOLDING;
	public static  Block MOSSY_COBBLESTONE_CROWN_MOLDING;
	public static  Block BRICKS_CROWN_MOLDING;
	public static  Block STONE_BRICKS_CROWN_MOLDING;
	public static  Block MOSSY_STONE_BRICKS_CROWN_MOLDING;
	public static  Block CRACKED_STONE_BRICKS_CROWN_MOLDING;
	public static  Block CHISELED_STONE_BRICKS_CROWN_MOLDING;
	public static  Block OBSIDIAN_CROWN_MOLDING;
	public static  Block SANDSTONE_CROWN_MOLDING;
	public static  Block SMOOTH_SANDSTONE_CROWN_MOLDING;
	public static  Block CHISELED_SANDSTONE_CROWN_MOLDING;
	public static  Block CUT_SANDSTONE_CROWN_MOLDING;
	public static  Block RED_SANDSTONE_CROWN_MOLDING;
	public static  Block SMOOTH_RED_SANDSTONE_CROWN_MOLDING;
	public static  Block CHISELED_RED_SANDSTONE_CROWN_MOLDING;
	public static  Block CUT_RED_SANDSTONE_CROWN_MOLDING;
	public static  Block GRANITE_CROWN_MOLDING;
	public static  Block POLISHED_GRANITE_CROWN_MOLDING;
	public static  Block DIORITE_CROWN_MOLDING;
	public static  Block POLISHED_DIORITE_CROWN_MOLDING;
	public static  Block ANDESITE_CROWN_MOLDING;
	public static  Block POLISHED_ANDESITE_CROWN_MOLDING;

	// pillar base
	public static  Block STONE_PILLAR_BASE;
	public static  Block SMOOTH_STONE_PILLAR_BASE;
	public static  Block COBBLESTONE_PILLAR_BASE;
	public static  Block MOSSY_COBBLESTONE_PILLAR_BASE;
	public static  Block BRICKS_PILLAR_BASE;
	public static  Block STONE_BRICKS_PILLAR_BASE;
	public static  Block MOSSY_STONE_BRICKS_PILLAR_BASE;
	public static  Block CRACKED_STONE_BRICKS_PILLAR_BASE;
	public static  Block CHISELED_STONE_BRICKS_PILLAR_BASE;
	public static  Block OBSIDIAN_PILLAR_BASE;
	public static  Block SANDSTONE_PILLAR_BASE;
	public static  Block SMOOTH_SANDSTONE_PILLAR_BASE;
	public static  Block CHISELED_SANDSTONE_PILLAR_BASE;
	public static  Block CUT_SANDSTONE_PILLAR_BASE;
	public static  Block RED_SANDSTONE_PILLAR_BASE;
	public static  Block SMOOTH_RED_SANDSTONE_PILLAR_BASE;
	public static  Block CHISELED_RED_SANDSTONE_PILLAR_BASE;
	public static  Block CUT_RED_SANDSTONE_PILLAR_BASE;
	public static  Block GRANITE_PILLAR_BASE;
	public static  Block POLISHED_GRANITE_PILLAR_BASE;
	public static  Block DIORITE_PILLAR_BASE;
	public static  Block POLISHED_DIORITE_PILLAR_BASE;
	public static  Block ANDESITE_PILLAR_BASE;
	public static  Block POLISHED_ANDESITE_PILLAR_BASE;

	// pillar
	public static  Block STONE_PILLAR;
	public static  Block SMOOTH_STONE_PILLAR;
	public static  Block COBBLESTONE_PILLAR;
	public static  Block MOSSY_COBBLESTONE_PILLAR;
	public static  Block BRICKS_PILLAR;
	public static  Block STONE_BRICKS_PILLAR;
	public static  Block MOSSY_STONE_BRICKS_PILLAR;
	public static  Block CRACKED_STONE_BRICKS_PILLAR;
	public static  Block CHISELED_STONE_BRICKS_PILLAR;
	public static  Block OBSIDIAN_PILLAR;
	public static  Block SANDSTONE_PILLAR;
	public static  Block SMOOTH_SANDSTONE_PILLAR;
	public static  Block CHISELED_SANDSTONE_PILLAR;
	public static  Block CUT_SANDSTONE_PILLAR;
	public static  Block RED_SANDSTONE_PILLAR;
	public static  Block SMOOTH_RED_SANDSTONE_PILLAR;
	public static  Block CHISELED_RED_SANDSTONE_PILLAR;
	public static  Block CUT_RED_SANDSTONE_PILLAR;
	public static  Block GRANITE_PILLAR;
	public static  Block POLISHED_GRANITE_PILLAR;
	public static  Block DIORITE_PILLAR;
	public static  Block POLISHED_DIORITE_PILLAR;
	public static  Block ANDESITE_PILLAR;
	public static  Block POLISHED_ANDESITE_PILLAR;

	// wall sconce
	public static  Block STONE_WALL_SCONCE;
	public static  Block SMOOTH_STONE_WALL_SCONCE;
	public static  Block COBBLESTONE_WALL_SCONCE;
	public static  Block MOSSY_COBBLESTONE_WALL_SCONCE;
	public static  Block BRICKS_WALL_SCONCE;
	public static  Block STONE_BRICKS_WALL_SCONCE;
	public static  Block MOSSY_STONE_BRICKS_WALL_SCONCE;
	public static  Block CRACKED_STONE_BRICKS_WALL_SCONCE;
	public static  Block CHISELED_STONE_BRICKS_WALL_SCONCE;
	public static  Block OBSIDIAN_WALL_SCONCE;
	public static  Block SANDSTONE_WALL_SCONCE;
	public static  Block SMOOTH_SANDSTONE_WALL_SCONCE;
	public static  Block CHISELED_SANDSTONE_WALL_SCONCE;
	public static  Block CUT_SANDSTONE_WALL_SCONCE;
	public static  Block RED_SANDSTONE_WALL_SCONCE;
	public static  Block SMOOTH_RED_SANDSTONE_WALL_SCONCE;
	public static  Block CHISELED_RED_SANDSTONE_WALL_SCONCE;
	public static  Block CUT_RED_SANDSTONE_WALL_SCONCE;
	public static  Block GRANITE_WALL_SCONCE;
	public static  Block POLISHED_GRANITE_WALL_SCONCE;
	public static  Block DIORITE_WALL_SCONCE;
	public static  Block POLISHED_DIORITE_WALL_SCONCE;
	public static  Block ANDESITE_WALL_SCONCE;
	public static  Block POLISHED_ANDESITE_WALL_SCONCE;

	public static  Block GRATE;

	public static List<Block> BLOCKS = new ArrayList<>(100);

	static {

	}

	@Mod.EventBusSubscriber(modid = DungeonBlocks.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
	public static class RegistrationHandler {
		
		public static  Set<BlockItem> ITEM_BLOCKS = new HashSet<>();

		@SubscribeEvent
		public static void registerBlocks(RegistryEvent.Register<Block> event) {
			// facade
			STONE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.STONE_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			SMOOTH_STONE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.SMOOTH_STONE_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			COBBLESTONE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.COBBLESTONE_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			MOSSY_COBBLESTONE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.MOSSY_COBBLESTONE_FACADE_ID,
					Block.Properties.of(Material.STONE).strength(2.0F, 6.0F));
			BRICKS_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.BRICKS_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_RED).strength(2.0F, 6.0F));
			STONE_BRICKS_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.STONE_BRICKS_FACADE_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			MOSSY_STONE_BRICKS_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.MOSSY_STONE_BRICKS_FACADE_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			CRACKED_STONE_BRICKS_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.CRACKED_STONE_BRICKS_FACADE_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			CHISELED_STONE_BRICKS_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.CHISELED_STONE_BRICKS_FACADE_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			OBSIDIAN_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.OBSIDIAN_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(50.0F, 1200.0F));

			SANDSTONE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.SANDSTONE_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			SMOOTH_SANDSTONE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.SMOOTH_SANDSTONE_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CHISELED_SANDSTONE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.CHISELED_SANDSTONE_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CUT_SANDSTONE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.CUT_SANDSTONE_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			RED_SANDSTONE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.RED_SANDSTONE_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			SMOOTH_RED_SANDSTONE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.SMOOTH_RED_SANDSTONE_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CHISELED_RED_SANDSTONE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.CHISELED_RED_SANDSTONE_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CUT_RED_SANDSTONE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.CUT_RED_SANDSTONE_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));

			GRANITE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.GRANITE_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			POLISHED_GRANITE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.POLISHED_GRANITE_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			DIORITE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.DIORITE_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.QUARTZ).strength(1.5F, 6.0F));
			POLISHED_DIORITE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.POLISHED_DIORITE_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.QUARTZ).strength(1.5F, 6.0F));
			ANDESITE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.ANDESITE_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 6.0F));
			POLISHED_ANDESITE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.POLISHED_ANDESITE_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 6.0F));

			// quarter facade
			STONE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID, BlockID.STONE_QUARTER_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			SMOOTH_STONE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.SMOOTH_STONE_QUARTER_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			COBBLESTONE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID, BlockID.COBBLESTONE_QUARTER_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			MOSSY_COBBLESTONE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.MOSSY_COBBLESTONE_QUARTER_FACADE_ID,
					Block.Properties.of(Material.STONE).strength(2.0F, 6.0F));
			BRICKS_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID, BlockID.BRICKS_QUARTER_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_RED).strength(2.0F, 6.0F));
			STONE_BRICKS_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.STONE_BRICKS_QUARTER_FACADE_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			MOSSY_STONE_BRICKS_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.MOSSY_STONE_BRICKS_QUARTER_FACADE_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			CRACKED_STONE_BRICKS_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.CRACKED_STONE_BRICKS_QUARTER_FACADE_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			CHISELED_STONE_BRICKS_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.CHISELED_STONE_BRICKS_QUARTER_FACADE_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			OBSIDIAN_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID, BlockID.OBSIDIAN_QUARTER_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(50.0F, 1200.0F));

			SANDSTONE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID, BlockID.SANDSTONE_QUARTER_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			SMOOTH_SANDSTONE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.SMOOTH_SANDSTONE_QUARTER_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CHISELED_SANDSTONE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.CHISELED_SANDSTONE_QUARTER_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CUT_SANDSTONE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.CUT_SANDSTONE_QUARTER_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			RED_SANDSTONE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.RED_SANDSTONE_QUARTER_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			SMOOTH_RED_SANDSTONE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.SMOOTH_RED_SANDSTONE_QUARTER_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CHISELED_RED_SANDSTONE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.CHISELED_RED_SANDSTONE_QUARTER_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CUT_RED_SANDSTONE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.CUT_RED_SANDSTONE_QUARTER_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));

			GRANITE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID, BlockID.GRANITE_QUARTER_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			POLISHED_GRANITE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.POLISHED_GRANITE_QUARTER_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			DIORITE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID, BlockID.DIORITE_QUARTER_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.QUARTZ).strength(1.5F, 6.0F));
			POLISHED_DIORITE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.POLISHED_DIORITE_QUARTER_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.QUARTZ).strength(1.5F, 6.0F));
			ANDESITE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID, BlockID.ANDESITE_QUARTER_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 6.0F));
			POLISHED_ANDESITE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.POLISHED_ANDESITE_QUARTER_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 6.0F));

			// fluted
			STONE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.STONE_FLUTED_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			SMOOTH_STONE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.SMOOTH_STONE_FLUTED_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			COBBLESTONE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.COBBLESTONE_FLUTED_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			MOSSY_COBBLESTONE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.MOSSY_COBBLESTONE_FLUTED_ID,
					Block.Properties.of(Material.STONE).strength(2.0F, 6.0F));
			BRICKS_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.BRICKS_FLUTED_ID,
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_RED).strength(2.0F, 6.0F));
			STONE_BRICKS_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.STONE_BRICKS_FLUTED_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			MOSSY_STONE_BRICKS_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.MOSSY_STONE_BRICKS_FLUTED_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			CRACKED_STONE_BRICKS_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.CRACKED_STONE_BRICKS_FLUTED_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			CHISELED_STONE_BRICKS_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.CHISELED_STONE_BRICKS_FLUTED_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			OBSIDIAN_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.OBSIDIAN_FLUTED_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(50.0F, 1200.0F));

			SANDSTONE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.SANDSTONE_FLUTED_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			SMOOTH_SANDSTONE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.SMOOTH_SANDSTONE_FLUTED_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CHISELED_SANDSTONE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.CHISELED_SANDSTONE_FLUTED_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CUT_SANDSTONE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.CUT_SANDSTONE_FLUTED_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			RED_SANDSTONE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.RED_SANDSTONE_FLUTED_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			SMOOTH_RED_SANDSTONE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.SMOOTH_RED_SANDSTONE_FLUTED_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CHISELED_RED_SANDSTONE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.CHISELED_RED_SANDSTONE_FLUTED_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CUT_RED_SANDSTONE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.CUT_RED_SANDSTONE_FLUTED_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));

			GRANITE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.GRANITE_FLUTED_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			POLISHED_GRANITE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.POLISHED_GRANITE_FLUTED_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			DIORITE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.DIORITE_FLUTED_ID,
					Block.Properties.of(Material.STONE, MaterialColor.QUARTZ).strength(1.5F, 6.0F));
			POLISHED_DIORITE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.POLISHED_DIORITE_FLUTED_ID,
					Block.Properties.of(Material.STONE, MaterialColor.QUARTZ).strength(1.5F, 6.0F));
			ANDESITE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.ANDESITE_FLUTED_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 6.0F));
			POLISHED_ANDESITE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.POLISHED_ANDESITE_FLUTED_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 6.0F));

			// fluted facade
			STONE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, BlockID.STONE_FLUTED_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			SMOOTH_STONE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, BlockID.SMOOTH_STONE_FLUTED_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			COBBLESTONE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, BlockID.COBBLESTONE_FLUTED_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			MOSSY_COBBLESTONE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.MOSSY_COBBLESTONE_FLUTED_FACADE_ID,
					Block.Properties.of(Material.STONE).strength(2.0F, 6.0F));
			BRICKS_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, BlockID.BRICKS_FLUTED_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_RED).strength(2.0F, 6.0F));
			STONE_BRICKS_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, BlockID.STONE_BRICKS_FLUTED_FACADE_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			MOSSY_STONE_BRICKS_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.MOSSY_STONE_BRICKS_FLUTED_FACADE_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			CRACKED_STONE_BRICKS_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.CRACKED_STONE_BRICKS_FLUTED_FACADE_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			CHISELED_STONE_BRICKS_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.CHISELED_STONE_BRICKS_FLUTED_FACADE_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			OBSIDIAN_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, BlockID.OBSIDIAN_FLUTED_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(50.0F, 1200.0F));

			SANDSTONE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, BlockID.SANDSTONE_FLUTED_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			SMOOTH_SANDSTONE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.SMOOTH_SANDSTONE_FLUTED_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CHISELED_SANDSTONE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.CHISELED_SANDSTONE_FLUTED_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CUT_SANDSTONE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.CUT_SANDSTONE_FLUTED_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			RED_SANDSTONE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.RED_SANDSTONE_FLUTED_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			SMOOTH_RED_SANDSTONE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.SMOOTH_RED_SANDSTONE_FLUTED_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CHISELED_RED_SANDSTONE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.CHISELED_RED_SANDSTONE_FLUTED_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CUT_RED_SANDSTONE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.CUT_RED_SANDSTONE_FLUTED_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));

			GRANITE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, BlockID.GRANITE_FLUTED_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			POLISHED_GRANITE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.POLISHED_GRANITE_FLUTED_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			DIORITE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, BlockID.DIORITE_FLUTED_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.QUARTZ).strength(1.5F, 6.0F));
			POLISHED_DIORITE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.POLISHED_DIORITE_FLUTED_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.QUARTZ).strength(1.5F, 6.0F));
			ANDESITE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, BlockID.ANDESITE_FLUTED_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 6.0F));
			POLISHED_ANDESITE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.POLISHED_ANDESITE_FLUTED_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 6.0F));

			// sill
			STONE_SILL = new SillBlock(DungeonBlocks.MOD_ID, BlockID.STONE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			SMOOTH_STONE_SILL = new SillBlock(DungeonBlocks.MOD_ID, BlockID.SMOOTH_STONE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			COBBLESTONE_SILL = new SillBlock(DungeonBlocks.MOD_ID, BlockID.COBBLESTONE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			MOSSY_COBBLESTONE_SILL = new SillBlock(DungeonBlocks.MOD_ID, BlockID.MOSSY_COBBLESTONE_SILL_ID,
					Block.Properties.of(Material.STONE).strength(2.0F, 6.0F));
			BRICKS_SILL = new SillBlock(DungeonBlocks.MOD_ID, BlockID.BRICKS_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_RED).strength(2.0F, 6.0F));
			STONE_BRICKS_SILL = new SillBlock(DungeonBlocks.MOD_ID, BlockID.STONE_BRICKS_SILL_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			MOSSY_STONE_BRICKS_SILL = new SillBlock(DungeonBlocks.MOD_ID, BlockID.MOSSY_STONE_BRICKS_SILL_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			CRACKED_STONE_BRICKS_SILL = new SillBlock(DungeonBlocks.MOD_ID, BlockID.CRACKED_STONE_BRICKS_SILL_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			CHISELED_STONE_BRICKS_SILL = new SillBlock(DungeonBlocks.MOD_ID, BlockID.CHISELED_STONE_BRICKS_SILL_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			OBSIDIAN_SILL = new SillBlock(DungeonBlocks.MOD_ID, BlockID.OBSIDIAN_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(50.0F, 1200.0F));

			SANDSTONE_SILL = new SillBlock(DungeonBlocks.MOD_ID, BlockID.SANDSTONE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			SMOOTH_SANDSTONE_SILL = new SillBlock(DungeonBlocks.MOD_ID, BlockID.SMOOTH_SANDSTONE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CHISELED_SANDSTONE_SILL = new SillBlock(DungeonBlocks.MOD_ID, BlockID.CHISELED_SANDSTONE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CUT_SANDSTONE_SILL = new SillBlock(DungeonBlocks.MOD_ID, BlockID.CUT_SANDSTONE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			RED_SANDSTONE_SILL = new SillBlock(DungeonBlocks.MOD_ID, BlockID.RED_SANDSTONE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			SMOOTH_RED_SANDSTONE_SILL = new SillBlock(DungeonBlocks.MOD_ID, BlockID.SMOOTH_RED_SANDSTONE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CHISELED_RED_SANDSTONE_SILL = new SillBlock(DungeonBlocks.MOD_ID, BlockID.CHISELED_RED_SANDSTONE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CUT_RED_SANDSTONE_SILL = new SillBlock(DungeonBlocks.MOD_ID, BlockID.CUT_RED_SANDSTONE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));

			GRANITE_SILL = new SillBlock(DungeonBlocks.MOD_ID, BlockID.GRANITE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			POLISHED_GRANITE_SILL = new SillBlock(DungeonBlocks.MOD_ID, BlockID.POLISHED_GRANITE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			DIORITE_SILL = new SillBlock(DungeonBlocks.MOD_ID, BlockID.DIORITE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.QUARTZ).strength(1.5F, 6.0F));
			POLISHED_DIORITE_SILL = new SillBlock(DungeonBlocks.MOD_ID, BlockID.POLISHED_DIORITE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.QUARTZ).strength(1.5F, 6.0F));
			ANDESITE_SILL = new SillBlock(DungeonBlocks.MOD_ID, BlockID.ANDESITE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 6.0F));
			POLISHED_ANDESITE_SILL = new SillBlock(DungeonBlocks.MOD_ID, BlockID.POLISHED_ANDESITE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 6.0F));

			// double sill
			STONE_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID, BlockID.STONE_DOUBLE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			SMOOTH_STONE_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID, BlockID.SMOOTH_STONE_DOUBLE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			COBBLESTONE_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID, BlockID.COBBLESTONE_DOUBLE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			MOSSY_COBBLESTONE_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID,
					BlockID.MOSSY_COBBLESTONE_DOUBLE_SILL_ID,
					Block.Properties.of(Material.STONE).strength(2.0F, 6.0F));
			BRICKS_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID, BlockID.BRICKS_DOUBLE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_RED).strength(2.0F, 6.0F));
			STONE_BRICKS_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID, BlockID.STONE_BRICKS_DOUBLE_SILL_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			MOSSY_STONE_BRICKS_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID,
					BlockID.MOSSY_STONE_BRICKS_DOUBLE_SILL_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			CRACKED_STONE_BRICKS_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID,
					BlockID.CRACKED_STONE_BRICKS_DOUBLE_SILL_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			CHISELED_STONE_BRICKS_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID,
					BlockID.CHISELED_STONE_BRICKS_DOUBLE_SILL_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			OBSIDIAN_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID, BlockID.OBSIDIAN_DOUBLE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(50.0F, 1200.0F));

			SANDSTONE_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID, BlockID.SANDSTONE_DOUBLE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			SMOOTH_SANDSTONE_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID,
					BlockID.SMOOTH_SANDSTONE_DOUBLE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CHISELED_SANDSTONE_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID,
					BlockID.CHISELED_SANDSTONE_DOUBLE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CUT_SANDSTONE_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID, BlockID.CUT_SANDSTONE_DOUBLE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			RED_SANDSTONE_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID, BlockID.RED_SANDSTONE_DOUBLE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			SMOOTH_RED_SANDSTONE_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID,
					BlockID.SMOOTH_RED_SANDSTONE_DOUBLE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CHISELED_RED_SANDSTONE_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID,
					BlockID.CHISELED_RED_SANDSTONE_DOUBLE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CUT_RED_SANDSTONE_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID,
					BlockID.CUT_RED_SANDSTONE_DOUBLE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));

			GRANITE_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID, BlockID.GRANITE_DOUBLE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			POLISHED_GRANITE_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID,
					BlockID.POLISHED_GRANITE_DOUBLE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			DIORITE_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID, BlockID.DIORITE_DOUBLE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.QUARTZ).strength(1.5F, 6.0F));
			POLISHED_DIORITE_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID,
					BlockID.POLISHED_DIORITE_DOUBLE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.QUARTZ).strength(1.5F, 6.0F));
			ANDESITE_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID, BlockID.ANDESITE_DOUBLE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 6.0F));
			POLISHED_ANDESITE_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID,
					BlockID.POLISHED_ANDESITE_DOUBLE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 6.0F));

			// Cornice
			STONE_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, BlockID.STONE_CORNICE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			SMOOTH_STONE_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, BlockID.SMOOTH_STONE_CORNICE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			COBBLESTONE_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, BlockID.COBBLESTONE_CORNICE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			MOSSY_COBBLESTONE_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, BlockID.MOSSY_COBBLESTONE_CORNICE_ID,
					Block.Properties.of(Material.STONE).strength(2.0F, 6.0F));
			BRICKS_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, BlockID.BRICKS_CORNICE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_RED).strength(2.0F, 6.0F));
			STONE_BRICKS_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, BlockID.STONE_BRICKS_CORNICE_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			MOSSY_STONE_BRICKS_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, BlockID.MOSSY_STONE_BRICKS_CORNICE_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			CRACKED_STONE_BRICKS_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, BlockID.CRACKED_STONE_BRICKS_CORNICE_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			CHISELED_STONE_BRICKS_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, BlockID.CHISELED_STONE_BRICKS_CORNICE_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			OBSIDIAN_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, BlockID.OBSIDIAN_CORNICE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(50.0F, 1200.0F));

			SANDSTONE_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, BlockID.SANDSTONE_CORNICE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			SMOOTH_SANDSTONE_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, BlockID.SMOOTH_SANDSTONE_CORNICE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CHISELED_SANDSTONE_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, BlockID.CHISELED_SANDSTONE_CORNICE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CUT_SANDSTONE_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, BlockID.CUT_SANDSTONE_CORNICE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			RED_SANDSTONE_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, BlockID.RED_SANDSTONE_CORNICE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			SMOOTH_RED_SANDSTONE_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, BlockID.SMOOTH_RED_SANDSTONE_CORNICE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CHISELED_RED_SANDSTONE_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID,
					BlockID.CHISELED_RED_SANDSTONE_CORNICE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CUT_RED_SANDSTONE_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, BlockID.CUT_RED_SANDSTONE_CORNICE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));

			GRANITE_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, BlockID.GRANITE_CORNICE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			POLISHED_GRANITE_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, BlockID.POLISHED_GRANITE_CORNICE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			DIORITE_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, BlockID.DIORITE_CORNICE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.QUARTZ).strength(1.5F, 6.0F));
			POLISHED_DIORITE_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, BlockID.POLISHED_DIORITE_CORNICE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.QUARTZ).strength(1.5F, 6.0F));
			ANDESITE_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, BlockID.ANDESITE_CORNICE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 6.0F));
			POLISHED_ANDESITE_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, BlockID.POLISHED_ANDESITE_CORNICE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 6.0F));

			// crown molding
			STONE_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID, BlockID.STONE_CROWN_MOLDING_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			SMOOTH_STONE_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID, BlockID.SMOOTH_STONE_CROWN_MOLDING_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			COBBLESTONE_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID, BlockID.COBBLESTONE_CROWN_MOLDING_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			MOSSY_COBBLESTONE_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID,
					BlockID.MOSSY_COBBLESTONE_CROWN_MOLDING_ID,
					Block.Properties.of(Material.STONE).strength(2.0F, 6.0F));
			BRICKS_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID, BlockID.BRICKS_CROWN_MOLDING_ID,
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_RED).strength(2.0F, 6.0F));
			STONE_BRICKS_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID, BlockID.STONE_BRICKS_CROWN_MOLDING_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			MOSSY_STONE_BRICKS_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID,
					BlockID.MOSSY_STONE_BRICKS_CROWN_MOLDING_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			CRACKED_STONE_BRICKS_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID,
					BlockID.CRACKED_STONE_BRICKS_CROWN_MOLDING_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			CHISELED_STONE_BRICKS_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID,
					BlockID.CHISELED_STONE_BRICKS_CROWN_MOLDING_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			OBSIDIAN_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID, BlockID.OBSIDIAN_CROWN_MOLDING_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(50.0F, 1200.0F));

			SANDSTONE_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID, BlockID.SANDSTONE_CROWN_MOLDING_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			SMOOTH_SANDSTONE_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID,
					BlockID.SMOOTH_SANDSTONE_CROWN_MOLDING_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CHISELED_SANDSTONE_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID,
					BlockID.CHISELED_SANDSTONE_CROWN_MOLDING_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CUT_SANDSTONE_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID,
					BlockID.CUT_SANDSTONE_CROWN_MOLDING_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			RED_SANDSTONE_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID,
					BlockID.RED_SANDSTONE_CROWN_MOLDING_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			SMOOTH_RED_SANDSTONE_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID,
					BlockID.SMOOTH_RED_SANDSTONE_CROWN_MOLDING_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CHISELED_RED_SANDSTONE_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID,
					BlockID.CHISELED_RED_SANDSTONE_CROWN_MOLDING_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CUT_RED_SANDSTONE_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID,
					BlockID.CUT_RED_SANDSTONE_CROWN_MOLDING_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));

			GRANITE_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID, BlockID.GRANITE_CROWN_MOLDING_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			POLISHED_GRANITE_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID,
					BlockID.POLISHED_GRANITE_CROWN_MOLDING_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			DIORITE_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID, BlockID.DIORITE_CROWN_MOLDING_ID,
					Block.Properties.of(Material.STONE, MaterialColor.QUARTZ).strength(1.5F, 6.0F));
			POLISHED_DIORITE_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID,
					BlockID.POLISHED_DIORITE_CROWN_MOLDING_ID,
					Block.Properties.of(Material.STONE, MaterialColor.QUARTZ).strength(1.5F, 6.0F));
			ANDESITE_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID, BlockID.ANDESITE_CROWN_MOLDING_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 6.0F));
			POLISHED_ANDESITE_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID,
					BlockID.POLISHED_ANDESITE_CROWN_MOLDING_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 6.0F));

			// pillar base
			STONE_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID, BlockID.STONE_PILLAR_BASE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			SMOOTH_STONE_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID, BlockID.SMOOTH_STONE_PILLAR_BASE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			COBBLESTONE_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID, BlockID.COBBLESTONE_PILLAR_BASE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			MOSSY_COBBLESTONE_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID,
					BlockID.MOSSY_COBBLESTONE_PILLAR_BASE_ID,
					Block.Properties.of(Material.STONE).strength(2.0F, 6.0F));
			BRICKS_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID, BlockID.BRICKS_PILLAR_BASE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_RED).strength(2.0F, 6.0F));
			STONE_BRICKS_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID, BlockID.STONE_BRICKS_PILLAR_BASE_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			MOSSY_STONE_BRICKS_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID,
					BlockID.MOSSY_STONE_BRICKS_PILLAR_BASE_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			CRACKED_STONE_BRICKS_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID,
					BlockID.CRACKED_STONE_BRICKS_PILLAR_BASE_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			CHISELED_STONE_BRICKS_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID,
					BlockID.CHISELED_STONE_BRICKS_PILLAR_BASE_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			OBSIDIAN_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID, BlockID.OBSIDIAN_PILLAR_BASE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(50.0F, 1200.0F));

			SANDSTONE_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID, BlockID.SANDSTONE_PILLAR_BASE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			SMOOTH_SANDSTONE_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID,
					BlockID.SMOOTH_SANDSTONE_PILLAR_BASE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CHISELED_SANDSTONE_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID,
					BlockID.CHISELED_SANDSTONE_PILLAR_BASE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CUT_SANDSTONE_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID, BlockID.CUT_SANDSTONE_PILLAR_BASE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			RED_SANDSTONE_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID, BlockID.RED_SANDSTONE_PILLAR_BASE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			SMOOTH_RED_SANDSTONE_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID,
					BlockID.SMOOTH_RED_SANDSTONE_PILLAR_BASE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CHISELED_RED_SANDSTONE_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID,
					BlockID.CHISELED_RED_SANDSTONE_PILLAR_BASE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CUT_RED_SANDSTONE_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID,
					BlockID.CUT_RED_SANDSTONE_PILLAR_BASE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));

			GRANITE_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID, BlockID.GRANITE_PILLAR_BASE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			POLISHED_GRANITE_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID,
					BlockID.POLISHED_GRANITE_PILLAR_BASE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			DIORITE_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID, BlockID.DIORITE_PILLAR_BASE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.QUARTZ).strength(1.5F, 6.0F));
			POLISHED_DIORITE_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID,
					BlockID.POLISHED_DIORITE_PILLAR_BASE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.QUARTZ).strength(1.5F, 6.0F));
			ANDESITE_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID, BlockID.ANDESITE_PILLAR_BASE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 6.0F));
			POLISHED_ANDESITE_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID,
					BlockID.POLISHED_ANDESITE_PILLAR_BASE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 6.0F));

			// pillar
			STONE_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, BlockID.STONE_PILLAR_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			SMOOTH_STONE_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, BlockID.SMOOTH_STONE_PILLAR_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			COBBLESTONE_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, BlockID.COBBLESTONE_PILLAR_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			MOSSY_COBBLESTONE_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, BlockID.MOSSY_COBBLESTONE_PILLAR_ID,
					Block.Properties.of(Material.STONE).strength(2.0F, 6.0F));
			BRICKS_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, BlockID.BRICKS_PILLAR_ID,
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_RED).strength(2.0F, 6.0F));
			STONE_BRICKS_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, BlockID.STONE_BRICKS_PILLAR_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			MOSSY_STONE_BRICKS_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, BlockID.MOSSY_STONE_BRICKS_PILLAR_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			CRACKED_STONE_BRICKS_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, BlockID.CRACKED_STONE_BRICKS_PILLAR_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			CHISELED_STONE_BRICKS_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, BlockID.CHISELED_STONE_BRICKS_PILLAR_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			OBSIDIAN_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, BlockID.OBSIDIAN_PILLAR_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(50.0F, 1200.0F));

			SANDSTONE_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, BlockID.SANDSTONE_PILLAR_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			SMOOTH_SANDSTONE_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, BlockID.SMOOTH_SANDSTONE_PILLAR_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CHISELED_SANDSTONE_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, BlockID.CHISELED_SANDSTONE_PILLAR_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CUT_SANDSTONE_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, BlockID.CUT_SANDSTONE_PILLAR_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			RED_SANDSTONE_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, BlockID.RED_SANDSTONE_PILLAR_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			SMOOTH_RED_SANDSTONE_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, BlockID.SMOOTH_RED_SANDSTONE_PILLAR_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CHISELED_RED_SANDSTONE_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, BlockID.CHISELED_RED_SANDSTONE_PILLAR_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CUT_RED_SANDSTONE_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, BlockID.CUT_RED_SANDSTONE_PILLAR_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));

			GRANITE_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, BlockID.GRANITE_PILLAR_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			POLISHED_GRANITE_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, BlockID.POLISHED_GRANITE_PILLAR_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			DIORITE_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, BlockID.DIORITE_PILLAR_ID,
					Block.Properties.of(Material.STONE, MaterialColor.QUARTZ).strength(1.5F, 6.0F));
			POLISHED_DIORITE_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, BlockID.POLISHED_DIORITE_PILLAR_ID,
					Block.Properties.of(Material.STONE, MaterialColor.QUARTZ).strength(1.5F, 6.0F));
			ANDESITE_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, BlockID.ANDESITE_PILLAR_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 6.0F));
			POLISHED_ANDESITE_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, BlockID.POLISHED_ANDESITE_PILLAR_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 6.0F));

			// wall sconce
			STONE_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID, BlockID.STONE_WALL_SCONCE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F)
							.noCollission().lightLevel((light)->{return  14;}).sound(SoundType.WOOD));
			SMOOTH_STONE_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID, BlockID.SMOOTH_STONE_WALL_SCONCE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F)
							.noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD));
			COBBLESTONE_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID, BlockID.COBBLESTONE_WALL_SCONCE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F)
							.noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD));
			MOSSY_COBBLESTONE_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID, BlockID.MOSSY_COBBLESTONE_WALL_SCONCE_ID,
					Block.Properties.of(Material.STONE).strength(2.0F, 6.0F).noCollission()
							.lightLevel((light)->{return 14;}).sound(SoundType.WOOD));
			BRICKS_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID, BlockID.BRICKS_WALL_SCONCE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_RED).strength(2.0F, 6.0F)
							.noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD));
			STONE_BRICKS_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID, BlockID.STONE_BRICKS_WALL_SCONCE_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F).noCollission()
							.lightLevel((light)->{return 14;}).sound(SoundType.WOOD));
			MOSSY_STONE_BRICKS_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID,
					BlockID.MOSSY_STONE_BRICKS_WALL_SCONCE_ID, Block.Properties.of(Material.STONE)
							.strength(1.5F, 6.0F).noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD));
			CRACKED_STONE_BRICKS_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID,
					BlockID.CRACKED_STONE_BRICKS_WALL_SCONCE_ID, Block.Properties.of(Material.STONE)
							.strength(1.5F, 6.0F).noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD));
			CHISELED_STONE_BRICKS_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID,
					BlockID.CHISELED_STONE_BRICKS_WALL_SCONCE_ID, Block.Properties.of(Material.STONE)
							.strength(1.5F, 6.0F).noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD));
			OBSIDIAN_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID, BlockID.OBSIDIAN_WALL_SCONCE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(50.0F, 1200.0F)
							.noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD));

			SANDSTONE_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID, BlockID.SANDSTONE_WALL_SCONCE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F)
							.noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD));
			SMOOTH_SANDSTONE_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID, BlockID.SMOOTH_SANDSTONE_WALL_SCONCE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F)
							.noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD));
			CHISELED_SANDSTONE_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID,
					BlockID.CHISELED_SANDSTONE_WALL_SCONCE_ID, Block.Properties.of(Material.STONE, MaterialColor.SAND)
							.strength(0.8F).noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD));
			CUT_SANDSTONE_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID, BlockID.CUT_SANDSTONE_WALL_SCONCE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F)
							.noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD));
			RED_SANDSTONE_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID, BlockID.RED_SANDSTONE_WALL_SCONCE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F)
							.noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD));
			SMOOTH_RED_SANDSTONE_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID,
					BlockID.SMOOTH_RED_SANDSTONE_WALL_SCONCE_ID, Block.Properties.of(Material.STONE, MaterialColor.SAND)
							.strength(0.8F).noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD));
			CHISELED_RED_SANDSTONE_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID,
					BlockID.CHISELED_RED_SANDSTONE_WALL_SCONCE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F)
							.noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD));
			CUT_RED_SANDSTONE_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID, BlockID.CUT_RED_SANDSTONE_WALL_SCONCE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F)
							.noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD));

			GRANITE_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID, BlockID.GRANITE_WALL_SCONCE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F)
							.noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD));
			POLISHED_GRANITE_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID, BlockID.POLISHED_GRANITE_WALL_SCONCE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F)
							.noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD));
			DIORITE_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID, BlockID.DIORITE_WALL_SCONCE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.QUARTZ).strength(1.5F, 6.0F)
							.noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD));
			POLISHED_DIORITE_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID, BlockID.POLISHED_DIORITE_WALL_SCONCE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.QUARTZ).strength(1.5F, 6.0F)
							.noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD));
			ANDESITE_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID, BlockID.ANDESITE_WALL_SCONCE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 6.0F)
							.noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD));
			POLISHED_ANDESITE_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID, BlockID.POLISHED_ANDESITE_WALL_SCONCE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 6.0F)
							.noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD));

			GRATE = new GrateBlock(DungeonBlocks.MOD_ID, BlockID.GRATE_ID,
					Block.Properties.of(Material.METAL, MaterialColor.STONE).strength(1.5F, 6.0F));

			/*
			 * setup array
			 */

			// facades
			BLOCKS.add(STONE_FACADE);
			BLOCKS.add(SMOOTH_STONE_FACADE);
			BLOCKS.add(COBBLESTONE_FACADE);
			BLOCKS.add(MOSSY_COBBLESTONE_FACADE);
			BLOCKS.add(BRICKS_FACADE);
			BLOCKS.add(STONE_BRICKS_FACADE);
			BLOCKS.add(MOSSY_STONE_BRICKS_FACADE);
			BLOCKS.add(CRACKED_STONE_BRICKS_FACADE);
			BLOCKS.add(CHISELED_STONE_BRICKS_FACADE);
			BLOCKS.add(OBSIDIAN_FACADE);
			BLOCKS.add(SANDSTONE_FACADE);
			BLOCKS.add(SMOOTH_SANDSTONE_FACADE);
			BLOCKS.add(CHISELED_SANDSTONE_FACADE);
			BLOCKS.add(CUT_SANDSTONE_FACADE);
			BLOCKS.add(RED_SANDSTONE_FACADE);
			BLOCKS.add(SMOOTH_RED_SANDSTONE_FACADE);
			BLOCKS.add(CHISELED_RED_SANDSTONE_FACADE);
			BLOCKS.add(CUT_RED_SANDSTONE_FACADE);
			BLOCKS.add(GRANITE_FACADE);
			BLOCKS.add(POLISHED_GRANITE_FACADE);
			BLOCKS.add(DIORITE_FACADE);
			BLOCKS.add(POLISHED_DIORITE_FACADE);
			BLOCKS.add(ANDESITE_FACADE);
			BLOCKS.add(POLISHED_ANDESITE_FACADE);

			// quarter facades
			BLOCKS.add(STONE_QUARTER_FACADE);
			BLOCKS.add(SMOOTH_STONE_QUARTER_FACADE);
			BLOCKS.add(COBBLESTONE_QUARTER_FACADE);
			BLOCKS.add(MOSSY_COBBLESTONE_QUARTER_FACADE);
			BLOCKS.add(BRICKS_QUARTER_FACADE);
			BLOCKS.add(STONE_BRICKS_QUARTER_FACADE);
			BLOCKS.add(MOSSY_STONE_BRICKS_QUARTER_FACADE);
			BLOCKS.add(CRACKED_STONE_BRICKS_QUARTER_FACADE);
			BLOCKS.add(CHISELED_STONE_BRICKS_QUARTER_FACADE);
			BLOCKS.add(OBSIDIAN_QUARTER_FACADE);
			BLOCKS.add(SANDSTONE_QUARTER_FACADE);
			BLOCKS.add(SMOOTH_SANDSTONE_QUARTER_FACADE);
			BLOCKS.add(CHISELED_SANDSTONE_QUARTER_FACADE);
			BLOCKS.add(CUT_SANDSTONE_QUARTER_FACADE);
			BLOCKS.add(RED_SANDSTONE_QUARTER_FACADE);
			BLOCKS.add(SMOOTH_RED_SANDSTONE_QUARTER_FACADE);
			BLOCKS.add(CHISELED_RED_SANDSTONE_QUARTER_FACADE);
			BLOCKS.add(CUT_RED_SANDSTONE_QUARTER_FACADE);
			BLOCKS.add(GRANITE_QUARTER_FACADE);
			BLOCKS.add(POLISHED_GRANITE_QUARTER_FACADE);
			BLOCKS.add(DIORITE_QUARTER_FACADE);
			BLOCKS.add(POLISHED_DIORITE_QUARTER_FACADE);
			BLOCKS.add(ANDESITE_QUARTER_FACADE);
			BLOCKS.add(POLISHED_ANDESITE_QUARTER_FACADE);

			// fluted
			BLOCKS.add(STONE_FLUTED);
			BLOCKS.add(SMOOTH_STONE_FLUTED);
			BLOCKS.add(COBBLESTONE_FLUTED);
			BLOCKS.add(MOSSY_COBBLESTONE_FLUTED);
			BLOCKS.add(BRICKS_FLUTED);
			BLOCKS.add(STONE_BRICKS_FLUTED);
			BLOCKS.add(MOSSY_STONE_BRICKS_FLUTED);
			BLOCKS.add(CRACKED_STONE_BRICKS_FLUTED);
			BLOCKS.add(CHISELED_STONE_BRICKS_FLUTED);
			BLOCKS.add(OBSIDIAN_FLUTED);
			BLOCKS.add(SANDSTONE_FLUTED);
			BLOCKS.add(SMOOTH_SANDSTONE_FLUTED);
			BLOCKS.add(CHISELED_SANDSTONE_FLUTED);
			BLOCKS.add(CUT_SANDSTONE_FLUTED);
			BLOCKS.add(RED_SANDSTONE_FLUTED);
			BLOCKS.add(SMOOTH_RED_SANDSTONE_FLUTED);
			BLOCKS.add(CHISELED_RED_SANDSTONE_FLUTED);
			BLOCKS.add(CUT_RED_SANDSTONE_FLUTED);
			BLOCKS.add(GRANITE_FLUTED);
			BLOCKS.add(POLISHED_GRANITE_FLUTED);
			BLOCKS.add(DIORITE_FLUTED);
			BLOCKS.add(POLISHED_DIORITE_FLUTED);
			BLOCKS.add(ANDESITE_FLUTED);
			BLOCKS.add(POLISHED_ANDESITE_FLUTED);

			// fluted facade
			BLOCKS.add(STONE_FLUTED_FACADE);
			BLOCKS.add(SMOOTH_STONE_FLUTED_FACADE);
			BLOCKS.add(COBBLESTONE_FLUTED_FACADE);
			BLOCKS.add(MOSSY_COBBLESTONE_FLUTED_FACADE);
			BLOCKS.add(BRICKS_FLUTED_FACADE);
			BLOCKS.add(STONE_BRICKS_FLUTED_FACADE);
			BLOCKS.add(MOSSY_STONE_BRICKS_FLUTED_FACADE);
			BLOCKS.add(CRACKED_STONE_BRICKS_FLUTED_FACADE);
			BLOCKS.add(CHISELED_STONE_BRICKS_FLUTED_FACADE);
			BLOCKS.add(OBSIDIAN_FLUTED_FACADE);
			BLOCKS.add(SANDSTONE_FLUTED_FACADE);
			BLOCKS.add(SMOOTH_SANDSTONE_FLUTED_FACADE);
			BLOCKS.add(CHISELED_SANDSTONE_FLUTED_FACADE);
			BLOCKS.add(CUT_SANDSTONE_FLUTED_FACADE);
			BLOCKS.add(RED_SANDSTONE_FLUTED_FACADE);
			BLOCKS.add(SMOOTH_RED_SANDSTONE_FLUTED_FACADE);
			BLOCKS.add(CHISELED_RED_SANDSTONE_FLUTED_FACADE);
			BLOCKS.add(CUT_RED_SANDSTONE_FLUTED_FACADE);
			BLOCKS.add(GRANITE_FLUTED_FACADE);
			BLOCKS.add(POLISHED_GRANITE_FLUTED_FACADE);
			BLOCKS.add(DIORITE_FLUTED_FACADE);
			BLOCKS.add(POLISHED_DIORITE_FLUTED_FACADE);
			BLOCKS.add(ANDESITE_FLUTED_FACADE);
			BLOCKS.add(POLISHED_ANDESITE_FLUTED_FACADE);

			// sill
			BLOCKS.add(STONE_SILL);
			BLOCKS.add(SMOOTH_STONE_SILL);
			BLOCKS.add(COBBLESTONE_SILL);
			BLOCKS.add(MOSSY_COBBLESTONE_SILL);
			BLOCKS.add(BRICKS_SILL);
			BLOCKS.add(STONE_BRICKS_SILL);
			BLOCKS.add(MOSSY_STONE_BRICKS_SILL);
			BLOCKS.add(CRACKED_STONE_BRICKS_SILL);
			BLOCKS.add(CHISELED_STONE_BRICKS_SILL);
			BLOCKS.add(OBSIDIAN_SILL);
			BLOCKS.add(SANDSTONE_SILL);
			BLOCKS.add(SMOOTH_SANDSTONE_SILL);
			BLOCKS.add(CHISELED_SANDSTONE_SILL);
			BLOCKS.add(CUT_SANDSTONE_SILL);
			BLOCKS.add(RED_SANDSTONE_SILL);
			BLOCKS.add(SMOOTH_RED_SANDSTONE_SILL);
			BLOCKS.add(CHISELED_RED_SANDSTONE_SILL);
			BLOCKS.add(CUT_RED_SANDSTONE_SILL);
			BLOCKS.add(GRANITE_SILL);
			BLOCKS.add(POLISHED_GRANITE_SILL);
			BLOCKS.add(DIORITE_SILL);
			BLOCKS.add(POLISHED_DIORITE_SILL);
			BLOCKS.add(ANDESITE_SILL);
			BLOCKS.add(POLISHED_ANDESITE_SILL);

			// double sill
			BLOCKS.add(STONE_DOUBLE_SILL);
			BLOCKS.add(SMOOTH_STONE_DOUBLE_SILL);
			BLOCKS.add(COBBLESTONE_DOUBLE_SILL);
			BLOCKS.add(MOSSY_COBBLESTONE_DOUBLE_SILL);
			BLOCKS.add(BRICKS_DOUBLE_SILL);
			BLOCKS.add(STONE_BRICKS_DOUBLE_SILL);
			BLOCKS.add(MOSSY_STONE_BRICKS_DOUBLE_SILL);
			BLOCKS.add(CRACKED_STONE_BRICKS_DOUBLE_SILL);
			BLOCKS.add(CHISELED_STONE_BRICKS_DOUBLE_SILL);
			BLOCKS.add(OBSIDIAN_DOUBLE_SILL);
			BLOCKS.add(SANDSTONE_DOUBLE_SILL);
			BLOCKS.add(SMOOTH_SANDSTONE_DOUBLE_SILL);
			BLOCKS.add(CHISELED_SANDSTONE_DOUBLE_SILL);
			BLOCKS.add(CUT_SANDSTONE_DOUBLE_SILL);
			BLOCKS.add(RED_SANDSTONE_DOUBLE_SILL);
			BLOCKS.add(SMOOTH_RED_SANDSTONE_DOUBLE_SILL);
			BLOCKS.add(CHISELED_RED_SANDSTONE_DOUBLE_SILL);
			BLOCKS.add(CUT_RED_SANDSTONE_DOUBLE_SILL);
			BLOCKS.add(GRANITE_DOUBLE_SILL);
			BLOCKS.add(POLISHED_GRANITE_DOUBLE_SILL);
			BLOCKS.add(DIORITE_DOUBLE_SILL);
			BLOCKS.add(POLISHED_DIORITE_DOUBLE_SILL);
			BLOCKS.add(ANDESITE_DOUBLE_SILL);
			BLOCKS.add(POLISHED_ANDESITE_DOUBLE_SILL);

			// cornice
			BLOCKS.add(STONE_CORNICE);
			BLOCKS.add(SMOOTH_STONE_CORNICE);
			BLOCKS.add(COBBLESTONE_CORNICE);
			BLOCKS.add(MOSSY_COBBLESTONE_CORNICE);
			BLOCKS.add(BRICKS_CORNICE);
			BLOCKS.add(STONE_BRICKS_CORNICE);
			BLOCKS.add(MOSSY_STONE_BRICKS_CORNICE);
			BLOCKS.add(CRACKED_STONE_BRICKS_CORNICE);
			BLOCKS.add(CHISELED_STONE_BRICKS_CORNICE);
			BLOCKS.add(OBSIDIAN_CORNICE);
			BLOCKS.add(SANDSTONE_CORNICE);
			BLOCKS.add(SMOOTH_SANDSTONE_CORNICE);
			BLOCKS.add(CHISELED_SANDSTONE_CORNICE);
			BLOCKS.add(CUT_SANDSTONE_CORNICE);
			BLOCKS.add(RED_SANDSTONE_CORNICE);
			BLOCKS.add(SMOOTH_RED_SANDSTONE_CORNICE);
			BLOCKS.add(CHISELED_RED_SANDSTONE_CORNICE);
			BLOCKS.add(CUT_RED_SANDSTONE_CORNICE);
			BLOCKS.add(GRANITE_CORNICE);
			BLOCKS.add(POLISHED_GRANITE_CORNICE);
			BLOCKS.add(DIORITE_CORNICE);
			BLOCKS.add(POLISHED_DIORITE_CORNICE);
			BLOCKS.add(ANDESITE_CORNICE);
			BLOCKS.add(POLISHED_ANDESITE_CORNICE);

			// crown molding
			BLOCKS.add(STONE_CROWN_MOLDING);
			BLOCKS.add(SMOOTH_STONE_CROWN_MOLDING);
			BLOCKS.add(COBBLESTONE_CROWN_MOLDING);
			BLOCKS.add(MOSSY_COBBLESTONE_CROWN_MOLDING);
			BLOCKS.add(BRICKS_CROWN_MOLDING);
			BLOCKS.add(STONE_BRICKS_CROWN_MOLDING);
			BLOCKS.add(MOSSY_STONE_BRICKS_CROWN_MOLDING);
			BLOCKS.add(CRACKED_STONE_BRICKS_CROWN_MOLDING);
			BLOCKS.add(CHISELED_STONE_BRICKS_CROWN_MOLDING);
			BLOCKS.add(OBSIDIAN_CROWN_MOLDING);
			BLOCKS.add(SANDSTONE_CROWN_MOLDING);
			BLOCKS.add(SMOOTH_SANDSTONE_CROWN_MOLDING);
			BLOCKS.add(CHISELED_SANDSTONE_CROWN_MOLDING);
			BLOCKS.add(CUT_SANDSTONE_CROWN_MOLDING);
			BLOCKS.add(RED_SANDSTONE_CROWN_MOLDING);
			BLOCKS.add(SMOOTH_RED_SANDSTONE_CROWN_MOLDING);
			BLOCKS.add(CHISELED_RED_SANDSTONE_CROWN_MOLDING);
			BLOCKS.add(CUT_RED_SANDSTONE_CROWN_MOLDING);
			BLOCKS.add(GRANITE_CROWN_MOLDING);
			BLOCKS.add(POLISHED_GRANITE_CROWN_MOLDING);
			BLOCKS.add(DIORITE_CROWN_MOLDING);
			BLOCKS.add(POLISHED_DIORITE_CROWN_MOLDING);
			BLOCKS.add(ANDESITE_CROWN_MOLDING);
			BLOCKS.add(POLISHED_ANDESITE_CROWN_MOLDING);

			// pillar base
			BLOCKS.add(STONE_PILLAR_BASE);
			BLOCKS.add(SMOOTH_STONE_PILLAR_BASE);
			BLOCKS.add(COBBLESTONE_PILLAR_BASE);
			BLOCKS.add(MOSSY_COBBLESTONE_PILLAR_BASE);
			BLOCKS.add(BRICKS_PILLAR_BASE);
			BLOCKS.add(STONE_BRICKS_PILLAR_BASE);
			BLOCKS.add(MOSSY_STONE_BRICKS_PILLAR_BASE);
			BLOCKS.add(CRACKED_STONE_BRICKS_PILLAR_BASE);
			BLOCKS.add(CHISELED_STONE_BRICKS_PILLAR_BASE);
			BLOCKS.add(OBSIDIAN_PILLAR_BASE);
			BLOCKS.add(SANDSTONE_PILLAR_BASE);
			BLOCKS.add(SMOOTH_SANDSTONE_PILLAR_BASE);
			BLOCKS.add(CHISELED_SANDSTONE_PILLAR_BASE);
			BLOCKS.add(CUT_SANDSTONE_PILLAR_BASE);
			BLOCKS.add(RED_SANDSTONE_PILLAR_BASE);
			BLOCKS.add(SMOOTH_RED_SANDSTONE_PILLAR_BASE);
			BLOCKS.add(CHISELED_RED_SANDSTONE_PILLAR_BASE);
			BLOCKS.add(CUT_RED_SANDSTONE_PILLAR_BASE);
			BLOCKS.add(GRANITE_PILLAR_BASE);
			BLOCKS.add(POLISHED_GRANITE_PILLAR_BASE);
			BLOCKS.add(DIORITE_PILLAR_BASE);
			BLOCKS.add(POLISHED_DIORITE_PILLAR_BASE);
			BLOCKS.add(ANDESITE_PILLAR_BASE);
			BLOCKS.add(POLISHED_ANDESITE_PILLAR_BASE);

			// pillar
			BLOCKS.add(STONE_PILLAR);
			BLOCKS.add(SMOOTH_STONE_PILLAR);
			BLOCKS.add(COBBLESTONE_PILLAR);
			BLOCKS.add(MOSSY_COBBLESTONE_PILLAR);
			BLOCKS.add(BRICKS_PILLAR);
			BLOCKS.add(STONE_BRICKS_PILLAR);
			BLOCKS.add(MOSSY_STONE_BRICKS_PILLAR);
			BLOCKS.add(CRACKED_STONE_BRICKS_PILLAR);
			BLOCKS.add(CHISELED_STONE_BRICKS_PILLAR);
			BLOCKS.add(OBSIDIAN_PILLAR);
			BLOCKS.add(SANDSTONE_PILLAR);
			BLOCKS.add(SMOOTH_SANDSTONE_PILLAR);
			BLOCKS.add(CHISELED_SANDSTONE_PILLAR);
			BLOCKS.add(CUT_SANDSTONE_PILLAR);
			BLOCKS.add(RED_SANDSTONE_PILLAR);
			BLOCKS.add(SMOOTH_RED_SANDSTONE_PILLAR);
			BLOCKS.add(CHISELED_RED_SANDSTONE_PILLAR);
			BLOCKS.add(CUT_RED_SANDSTONE_PILLAR);
			BLOCKS.add(GRANITE_PILLAR);
			BLOCKS.add(POLISHED_GRANITE_PILLAR);
			BLOCKS.add(DIORITE_PILLAR);
			BLOCKS.add(POLISHED_DIORITE_PILLAR);
			BLOCKS.add(ANDESITE_PILLAR);
			BLOCKS.add(POLISHED_ANDESITE_PILLAR);

			// wall sconce
			BLOCKS.add(STONE_WALL_SCONCE);
			BLOCKS.add(SMOOTH_STONE_WALL_SCONCE);
			BLOCKS.add(COBBLESTONE_WALL_SCONCE);
			BLOCKS.add(MOSSY_COBBLESTONE_WALL_SCONCE);
			BLOCKS.add(BRICKS_WALL_SCONCE);
			BLOCKS.add(STONE_BRICKS_WALL_SCONCE);
			BLOCKS.add(MOSSY_STONE_BRICKS_WALL_SCONCE);
			BLOCKS.add(CRACKED_STONE_BRICKS_WALL_SCONCE);
			BLOCKS.add(CHISELED_STONE_BRICKS_WALL_SCONCE);
			BLOCKS.add(OBSIDIAN_WALL_SCONCE);
			BLOCKS.add(SANDSTONE_WALL_SCONCE);
			BLOCKS.add(SMOOTH_SANDSTONE_WALL_SCONCE);
			BLOCKS.add(CHISELED_SANDSTONE_WALL_SCONCE);
			BLOCKS.add(CUT_SANDSTONE_WALL_SCONCE);
			BLOCKS.add(RED_SANDSTONE_WALL_SCONCE);
			BLOCKS.add(SMOOTH_RED_SANDSTONE_WALL_SCONCE);
			BLOCKS.add(CHISELED_RED_SANDSTONE_WALL_SCONCE);
			BLOCKS.add(CUT_RED_SANDSTONE_WALL_SCONCE);
			BLOCKS.add(GRANITE_WALL_SCONCE);
			BLOCKS.add(POLISHED_GRANITE_WALL_SCONCE);
			BLOCKS.add(DIORITE_WALL_SCONCE);
			BLOCKS.add(POLISHED_DIORITE_WALL_SCONCE);
			BLOCKS.add(ANDESITE_WALL_SCONCE);
			BLOCKS.add(POLISHED_ANDESITE_WALL_SCONCE);
			BLOCKS.add(GRATE);
			
			 IForgeRegistry<Block> registry = event.getRegistry();
			for (Block b : BLOCKS) {
				registry.register(b);
			}
		}

		/**
		 * Register this mod's {@link ItemBlock}s.
		 *
		 * @param event The event
		 */
		@SubscribeEvent
		public static void registerItemBlocks( RegistryEvent.Register<Item> event) {
			 IForgeRegistry<Item> registry = event.getRegistry();
			for (Block b : BLOCKS) {
				BlockItem itemBlock = new BlockItem(b, new Item.Properties().tab(ModItemGroups.MOD_ITEM_GROUP));
				 ResourceLocation registryName = Preconditions.checkNotNull(b.getRegistryName(),
						"Block %s has null registry name", b);
				registry.register(itemBlock.setRegistryName(registryName));
				ITEM_BLOCKS.add(itemBlock);
			}
		}
	}
}

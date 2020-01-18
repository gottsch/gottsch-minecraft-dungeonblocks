/**
 * 
 */
package com.someguyssoftware.dungeonblocks.block;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.naming.spi.DirObjectFactory;

import com.google.common.base.Preconditions;
import com.someguyssoftware.dungeonblocks.DungeonBlocks;
import com.someguyssoftware.dungeonblocks.config.DungeonBlocksConfig.BlockID;
import com.someguyssoftware.dungeonblocks.item.ModItemGroups;
import com.someguyssoftware.dungeonblocks.item.ModItems;
import com.someguyssoftware.gottschcore.block.FacingBlock;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ToolType;
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
	 *  blocks 
	 */
	// facade blocks
	public static final Block STONE_FACADE;
	public static final Block SMOOTH_STONE_FACADE;
	public static final Block COBBLESTONE_FACADE;
	public static final Block MOSSY_COBBLESTONE_FACADE;
	public static final Block BRICKS_FACADE;
	public static final Block STONE_BRICKS_FACADE;
	public static final Block CRACKED_STONE_BRICKS_FACADE;
	public static final Block CHISELED_STONE_BRICKS_FACADE;
	public static final Block OBSIDIAN_FACADE;
	public static final Block SANDSTONE_FACADE;
	public static final Block SMOOTH_SANDSTONE_FACADE;
	public static final Block CHISELED_SANDSTONE_FACADE;
	public static final Block CUT_SANDSTONE_FACADE;
	public static final Block RED_SANDSTONE_FACADE;
	public static final Block SMOOTH_RED_SANDSTONE_FACADE;
	public static final Block CHISELED_RED_SANDSTONE_FACADE;
	public static final Block CUT_RED_SANDSTONE_FACADE;	
	public static final Block GRANITE_FACADE;
	public static final Block POLISHED_GRANITE_FACADE;
	public static final Block DIORITE_FACADE;
	public static final Block POLISHED_DIORITE_FACADE;
	public static final Block ANDESITE_FACADE;
	public static final Block POLISHED_ANDESITE_FACADE;
	
	// quarter facade
	public static final Block STONE_QUARTER_FACADE;
	public static final Block SMOOTH_STONE_QUARTER_FACADE;
	public static final Block COBBLESTONE_QUARTER_FACADE;
	public static final Block MOSSY_COBBLESTONE_QUARTER_FACADE;
	public static final Block BRICKS_QUARTER_FACADE;
	public static final Block STONE_BRICKS_QUARTER_FACADE;
	public static final Block CRACKED_STONE_BRICKS_QUARTER_FACADE;
	public static final Block CHISELED_STONE_BRICKS_QUARTER_FACADE;
	public static final Block OBSIDIAN_QUARTER_FACADE;
	public static final Block SANDSTONE_QUARTER_FACADE;
	public static final Block SMOOTH_SANDSTONE_QUARTER_FACADE;
	public static final Block CHISELED_SANDSTONE_QUARTER_FACADE;
	public static final Block CUT_SANDSTONE_QUARTER_FACADE;
	public static final Block RED_SANDSTONE_QUARTER_FACADE;
	public static final Block SMOOTH_RED_SANDSTONE_QUARTER_FACADE;
	public static final Block CHISELED_RED_SANDSTONE_QUARTER_FACADE;
	public static final Block CUT_RED_SANDSTONE_QUARTER_FACADE;
	public static final Block GRANITE_QUARTER_FACADE;
	public static final Block POLISHED_GRANITE_QUARTER_FACADE;
	public static final Block DIORITE_QUARTER_FACADE;
	public static final Block POLISHED_DIORITE_QUARTER_FACADE;
	public static final Block ANDESITE_QUARTER_FACADE;
	public static final Block POLISHED_ANDESITE_QUARTER_FACADE;
	
	// fluted
	public static final Block STONE_FLUTED;
	public static final Block SMOOTH_STONE_FLUTED;
	public static final Block COBBLESTONE_FLUTED;
	public static final Block MOSSY_COBBLESTONE_FLUTED;
	public static final Block BRICKS_FLUTED;
	public static final Block STONE_BRICKS_FLUTED;
	public static final Block CRACKED_STONE_BRICKS_FLUTED;
	public static final Block CHISELED_STONE_BRICKS_FLUTED;
	public static final Block OBSIDIAN_FLUTED;
	public static final Block SANDSTONE_FLUTED;
	public static final Block SMOOTH_SANDSTONE_FLUTED;
	public static final Block CHISELED_SANDSTONE_FLUTED;
	public static final Block CUT_SANDSTONE_FLUTED;
	public static final Block RED_SANDSTONE_FLUTED;
	public static final Block SMOOTH_RED_SANDSTONE_FLUTED;
	public static final Block CHISELED_RED_SANDSTONE_FLUTED;
	public static final Block CUT_RED_SANDSTONE_FLUTED;
	public static final Block GRANITE_FLUTED;
	public static final Block POLISHED_GRANITE_FLUTED;
	public static final Block DIORITE_FLUTED;
	public static final Block POLISHED_DIORITE_FLUTED;
	public static final Block ANDESITE_FLUTED;
	public static final Block POLISHED_ANDESITE_FLUTED;

	// fluted facade
	public static final Block STONE_FLUTED_FACADE;
	public static final Block SMOOTH_STONE_FLUTED_FACADE;
	public static final Block COBBLESTONE_FLUTED_FACADE;
	public static final Block MOSSY_COBBLESTONE_FLUTED_FACADE;
	public static final Block BRICKS_FLUTED_FACADE;
	public static final Block STONE_BRICKS_FLUTED_FACADE;
	public static final Block CRACKED_STONE_BRICKS_FLUTED_FACADE;
	public static final Block CHISELED_STONE_BRICKS_FLUTED_FACADE;
	public static final Block OBSIDIAN_FLUTED_FACADE;
	public static final Block SANDSTONE_FLUTED_FACADE;
	public static final Block SMOOTH_SANDSTONE_FLUTED_FACADE;
	public static final Block CHISELED_SANDSTONE_FLUTED_FACADE;
	public static final Block CUT_SANDSTONE_FLUTED_FACADE;
	public static final Block RED_SANDSTONE_FLUTED_FACADE;
	public static final Block SMOOTH_RED_SANDSTONE_FLUTED_FACADE;
	public static final Block CHISELED_RED_SANDSTONE_FLUTED_FACADE;
	public static final Block CUT_RED_SANDSTONE_FLUTED_FACADE;
	public static final Block GRANITE_FLUTED_FACADE;
	public static final Block POLISHED_GRANITE_FLUTED_FACADE;
	public static final Block DIORITE_FLUTED_FACADE;
	public static final Block POLISHED_DIORITE_FLUTED_FACADE;
	public static final Block ANDESITE_FLUTED_FACADE;
	public static final Block POLISHED_ANDESITE_FLUTED_FACADE;

	
	public static Block testBlock = new Block(Block.Properties.create(Material.IRON)
 		   .hardnessAndResistance(5)
 		   .harvestLevel(2)
 		   .harvestTool(ToolType.PICKAXE))
    .setRegistryName(DungeonBlocks.MOD_ID, "test_block");

	public static Block facadeBlock = new FacadeBlock(DungeonBlocks.MOD_ID, "facade_block", Block.Properties.create(Material.ROCK, MaterialColor.DIRT)
			.hardnessAndResistance(1.5F, 6.0F));
	
	public static List<Block> BLOCKS = new ArrayList<>(100);
	
	static {
		// facade
		STONE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.STONE_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.DIRT).hardnessAndResistance(1.5F, 6.0F));
		SMOOTH_STONE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.SMOOTH_STONE_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.DIRT).hardnessAndResistance(1.5F, 6.0F));
		COBBLESTONE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.COBBLESTONE_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.DIRT).hardnessAndResistance(1.5F, 6.0F));
		MOSSY_COBBLESTONE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.MOSSY_COBBLESTONE_FACADE_ID, Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0F, 6.0F));
		BRICKS_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.BRICKS_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.RED).hardnessAndResistance(2.0F, 6.0F));
		STONE_BRICKS_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.STONE_BRICKS_FACADE_ID, Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F));
		CRACKED_STONE_BRICKS_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.CRACKED_STONE_BRICKS_FACADE_ID, Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F));
		CHISELED_STONE_BRICKS_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.CHISELED_STONE_BRICKS_FACADE_ID, Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F));
		OBSIDIAN_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.OBSIDIAN_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.BLACK).hardnessAndResistance(50.0F, 1200.0F));

		SANDSTONE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.SANDSTONE_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(0.8F));
		SMOOTH_SANDSTONE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.SMOOTH_SANDSTONE_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(0.8F));
		CHISELED_SANDSTONE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.CHISELED_SANDSTONE_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(0.8F));
		CUT_SANDSTONE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.CUT_SANDSTONE_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(0.8F));
		RED_SANDSTONE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.RED_SANDSTONE_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(0.8F));
		SMOOTH_RED_SANDSTONE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.SMOOTH_RED_SANDSTONE_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(0.8F));
		CHISELED_RED_SANDSTONE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.CHISELED_RED_SANDSTONE_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(0.8F));
		CUT_RED_SANDSTONE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.CUT_RED_SANDSTONE_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(0.8F));
		
		GRANITE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.GRANITE_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.DIRT).hardnessAndResistance(1.5F, 6.0F));
		POLISHED_GRANITE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.POLISHED_GRANITE_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.DIRT).hardnessAndResistance(1.5F, 6.0F));
		DIORITE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.DIORITE_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.QUARTZ).hardnessAndResistance(1.5F, 6.0F));
		POLISHED_DIORITE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.POLISHED_DIORITE_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.QUARTZ).hardnessAndResistance(1.5F, 6.0F));
		ANDESITE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.ANDESITE_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F));
		POLISHED_ANDESITE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.POLISHED_ANDESITE_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F));		
		
		// quarter facade
		STONE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID, BlockID.STONE_QUARTER_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.DIRT).hardnessAndResistance(1.5F, 6.0F));
		SMOOTH_STONE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID, BlockID.SMOOTH_STONE_QUARTER_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.DIRT).hardnessAndResistance(1.5F, 6.0F));
		COBBLESTONE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID, BlockID.COBBLESTONE_QUARTER_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.DIRT).hardnessAndResistance(1.5F, 6.0F));
		MOSSY_COBBLESTONE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID, BlockID.MOSSY_COBBLESTONE_QUARTER_FACADE_ID, Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0F, 6.0F));
		BRICKS_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID, BlockID.BRICKS_QUARTER_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.RED).hardnessAndResistance(2.0F, 6.0F));
		STONE_BRICKS_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID, BlockID.STONE_BRICKS_QUARTER_FACADE_ID, Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F));
		CRACKED_STONE_BRICKS_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID, BlockID.CRACKED_STONE_BRICKS_QUARTER_FACADE_ID, Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F));
		CHISELED_STONE_BRICKS_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID, BlockID.CHISELED_STONE_BRICKS_QUARTER_FACADE_ID, Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F));
		OBSIDIAN_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID, BlockID.OBSIDIAN_QUARTER_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.BLACK).hardnessAndResistance(50.0F, 1200.0F));

		SANDSTONE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID, BlockID.SANDSTONE_QUARTER_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(0.8F));
		SMOOTH_SANDSTONE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID, BlockID.SMOOTH_SANDSTONE_QUARTER_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(0.8F));
		CHISELED_SANDSTONE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID, BlockID.CHISELED_SANDSTONE_QUARTER_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(0.8F));
		CUT_SANDSTONE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID, BlockID.CUT_SANDSTONE_QUARTER_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(0.8F));
		RED_SANDSTONE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID, BlockID.RED_SANDSTONE_QUARTER_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(0.8F));
		SMOOTH_RED_SANDSTONE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID, BlockID.SMOOTH_RED_SANDSTONE_QUARTER_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(0.8F));
		CHISELED_RED_SANDSTONE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID, BlockID.CHISELED_RED_SANDSTONE_QUARTER_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(0.8F));
		CUT_RED_SANDSTONE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID, BlockID.CUT_RED_SANDSTONE_QUARTER_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(0.8F));
		
		GRANITE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID, BlockID.GRANITE_QUARTER_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.DIRT).hardnessAndResistance(1.5F, 6.0F));
		POLISHED_GRANITE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID, BlockID.POLISHED_GRANITE_QUARTER_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.DIRT).hardnessAndResistance(1.5F, 6.0F));
		DIORITE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID, BlockID.DIORITE_QUARTER_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.QUARTZ).hardnessAndResistance(1.5F, 6.0F));
		POLISHED_DIORITE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID, BlockID.POLISHED_DIORITE_QUARTER_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.QUARTZ).hardnessAndResistance(1.5F, 6.0F));
		ANDESITE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID, BlockID.ANDESITE_QUARTER_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F));
		POLISHED_ANDESITE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID, BlockID.POLISHED_ANDESITE_QUARTER_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F));		

		// fluted
		STONE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.STONE_FLUTED_ID, Block.Properties.create(Material.ROCK, MaterialColor.DIRT).hardnessAndResistance(1.5F, 6.0F));
		SMOOTH_STONE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.SMOOTH_STONE_FLUTED_ID, Block.Properties.create(Material.ROCK, MaterialColor.DIRT).hardnessAndResistance(1.5F, 6.0F));
		COBBLESTONE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.COBBLESTONE_FLUTED_ID, Block.Properties.create(Material.ROCK, MaterialColor.DIRT).hardnessAndResistance(1.5F, 6.0F));
		MOSSY_COBBLESTONE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.MOSSY_COBBLESTONE_FLUTED_ID, Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0F, 6.0F));
		BRICKS_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.BRICKS_FLUTED_ID, Block.Properties.create(Material.ROCK, MaterialColor.RED).hardnessAndResistance(2.0F, 6.0F));
		STONE_BRICKS_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.STONE_BRICKS_FLUTED_ID, Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F));
		CRACKED_STONE_BRICKS_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.CRACKED_STONE_BRICKS_FLUTED_ID, Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F));
		CHISELED_STONE_BRICKS_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.CHISELED_STONE_BRICKS_FLUTED_ID, Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F));
		OBSIDIAN_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.OBSIDIAN_FLUTED_ID, Block.Properties.create(Material.ROCK, MaterialColor.BLACK).hardnessAndResistance(50.0F, 1200.0F));

		SANDSTONE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.SANDSTONE_FLUTED_ID, Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(0.8F));
		SMOOTH_SANDSTONE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.SMOOTH_SANDSTONE_FLUTED_ID, Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(0.8F));
		CHISELED_SANDSTONE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.CHISELED_SANDSTONE_FLUTED_ID, Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(0.8F));
		CUT_SANDSTONE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.CUT_SANDSTONE_FLUTED_ID, Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(0.8F));
		RED_SANDSTONE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.RED_SANDSTONE_FLUTED_ID, Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(0.8F));
		SMOOTH_RED_SANDSTONE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.SMOOTH_RED_SANDSTONE_FLUTED_ID, Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(0.8F));
		CHISELED_RED_SANDSTONE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.CHISELED_RED_SANDSTONE_FLUTED_ID, Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(0.8F));
		CUT_RED_SANDSTONE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.CUT_RED_SANDSTONE_FLUTED_ID, Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(0.8F));
		
		GRANITE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.GRANITE_FLUTED_ID, Block.Properties.create(Material.ROCK, MaterialColor.DIRT).hardnessAndResistance(1.5F, 6.0F));
		POLISHED_GRANITE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.POLISHED_GRANITE_FLUTED_ID, Block.Properties.create(Material.ROCK, MaterialColor.DIRT).hardnessAndResistance(1.5F, 6.0F));
		DIORITE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.DIORITE_FLUTED_ID, Block.Properties.create(Material.ROCK, MaterialColor.QUARTZ).hardnessAndResistance(1.5F, 6.0F));
		POLISHED_DIORITE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.POLISHED_DIORITE_FLUTED_ID, Block.Properties.create(Material.ROCK, MaterialColor.QUARTZ).hardnessAndResistance(1.5F, 6.0F));
		ANDESITE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.ANDESITE_FLUTED_ID, Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F));
		POLISHED_ANDESITE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.POLISHED_ANDESITE_FLUTED_ID, Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F));		

		// fluted facade
		STONE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, BlockID.STONE_FLUTED_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.DIRT).hardnessAndResistance(1.5F, 6.0F));
		SMOOTH_STONE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, BlockID.SMOOTH_STONE_FLUTED_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.DIRT).hardnessAndResistance(1.5F, 6.0F));
		COBBLESTONE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, BlockID.COBBLESTONE_FLUTED_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.DIRT).hardnessAndResistance(1.5F, 6.0F));
		MOSSY_COBBLESTONE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, BlockID.MOSSY_COBBLESTONE_FLUTED_FACADE_ID, Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0F, 6.0F));
		BRICKS_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, BlockID.BRICKS_FLUTED_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.RED).hardnessAndResistance(2.0F, 6.0F));
		STONE_BRICKS_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, BlockID.STONE_BRICKS_FLUTED_FACADE_ID, Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F));
		CRACKED_STONE_BRICKS_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, BlockID.CRACKED_STONE_BRICKS_FLUTED_FACADE_ID, Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F));
		CHISELED_STONE_BRICKS_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, BlockID.CHISELED_STONE_BRICKS_FLUTED_FACADE_ID, Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F));
		OBSIDIAN_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, BlockID.OBSIDIAN_FLUTED_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.BLACK).hardnessAndResistance(50.0F, 1200.0F));

		SANDSTONE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, BlockID.SANDSTONE_FLUTED_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(0.8F));
		SMOOTH_SANDSTONE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, BlockID.SMOOTH_SANDSTONE_FLUTED_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(0.8F));
		CHISELED_SANDSTONE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, BlockID.CHISELED_SANDSTONE_FLUTED_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(0.8F));
		CUT_SANDSTONE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, BlockID.CUT_SANDSTONE_FLUTED_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(0.8F));
		RED_SANDSTONE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, BlockID.RED_SANDSTONE_FLUTED_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(0.8F));
		SMOOTH_RED_SANDSTONE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, BlockID.SMOOTH_RED_SANDSTONE_FLUTED_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(0.8F));
		CHISELED_RED_SANDSTONE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, BlockID.CHISELED_RED_SANDSTONE_FLUTED_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(0.8F));
		CUT_RED_SANDSTONE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, BlockID.CUT_RED_SANDSTONE_FLUTED_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(0.8F));
		
		GRANITE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, BlockID.GRANITE_FLUTED_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.DIRT).hardnessAndResistance(1.5F, 6.0F));
		POLISHED_GRANITE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, BlockID.POLISHED_GRANITE_FLUTED_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.DIRT).hardnessAndResistance(1.5F, 6.0F));
		DIORITE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, BlockID.DIORITE_FLUTED_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.QUARTZ).hardnessAndResistance(1.5F, 6.0F));
		POLISHED_DIORITE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, BlockID.POLISHED_DIORITE_FLUTED_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.QUARTZ).hardnessAndResistance(1.5F, 6.0F));
		ANDESITE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, BlockID.ANDESITE_FLUTED_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F));
		POLISHED_ANDESITE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, BlockID.POLISHED_ANDESITE_FLUTED_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F));		

		
		/*
		 * setup array
		 */
		BLOCKS.add(testBlock);
		BLOCKS.add(facadeBlock);
		
		// facades
		BLOCKS.add(STONE_FACADE);
		BLOCKS.add(SMOOTH_STONE_FACADE);
		BLOCKS.add(COBBLESTONE_FACADE);
		BLOCKS.add(MOSSY_COBBLESTONE_FACADE);
		BLOCKS.add(BRICKS_FACADE);
		BLOCKS.add(STONE_BRICKS_FACADE);
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
		
		//  quarter facades
		BLOCKS.add(STONE_QUARTER_FACADE);
		BLOCKS.add(SMOOTH_STONE_QUARTER_FACADE);
		BLOCKS.add(COBBLESTONE_QUARTER_FACADE);
		BLOCKS.add(MOSSY_COBBLESTONE_QUARTER_FACADE);
		BLOCKS.add(BRICKS_QUARTER_FACADE);
		BLOCKS.add(STONE_BRICKS_QUARTER_FACADE);
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

	}

	
	@Mod.EventBusSubscriber(modid = DungeonBlocks.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
	public static class RegistrationHandler {
		public static final Set<BlockItem> ITEM_BLOCKS = new HashSet<>();
		
		@SubscribeEvent
		public static void registerBlocks(RegistryEvent.Register<Block> event) {
			final IForgeRegistry<Block> registry = event.getRegistry();
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
		public static void registerItemBlocks(final RegistryEvent.Register<Item> event) {
			final IForgeRegistry<Item> registry = event.getRegistry();
			for (Block b : BLOCKS) {
				BlockItem itemBlock = new BlockItem(b, new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP));
				final ResourceLocation registryName = Preconditions.checkNotNull(b.getRegistryName(), "Block %s has null registry name", b);
				registry.register(itemBlock.setRegistryName(registryName));
				ITEM_BLOCKS.add(itemBlock);			
			}
		}		
	}
}

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
	public static Block STONE_FACADE;
	public static Block SMOOTH_STONE_FACADE;
	public static Block COBBLESTONE_FACADE;
	public static Block BRICK_FACADE;
	public static Block MOSSY_COBBLESTONE_FACADE;
	public static Block STONEBRICK_FACADE;
	public static Block CRACKED_STONEBRICK_FACADE;
	public static Block CHISELED_STONEBRICK_FACADE;
	public static Block OBSIDIAN_FACADE;
	public static Block SANDSTONE_FACADE;
	public static Block SMOOTH_SANDSTONE_FACADE;
	public static Block CHISELED_SANDSTONE_FACADE;
	public static Block CUT_SANDSTONE_FACADE;
	public static Block RED_SANDSTONE_FACADE;
	public static Block SMOOTH_RED_SANDSTONE_FACADE;
	public static Block CHISELED_RED_SANDSTONE_FACADE;
	public static Block CUT_RED_SANDSTONE_FACADE;
	
	public final static Block GRANITE_FACADE;
	public final static Block POLISHED_GRANITE_FACADE;
	public final static Block DIORITE_FACADE;
	public final static Block POLISHED_DIORITE_FACADE;
	public final static Block ANDESITE_FACADE;
	public final static Block POLISHED_ANDESITE_FACADE;
	
	public static Block testBlock = new Block(Block.Properties.create(Material.IRON)
 		   .hardnessAndResistance(5)
 		   .harvestLevel(2)
 		   .harvestTool(ToolType.PICKAXE))
    .setRegistryName(DungeonBlocks.MOD_ID, "test_block");
	
	public static Block facingBlock = new MyFacingBlock(DungeonBlocks.MOD_ID, "facing_block", Block.Properties.create(Material.ROCK, MaterialColor.DIRT)
			.hardnessAndResistance(1.5F, 6.0F));

	public static Block facadeBlock = new FacadeBlock(DungeonBlocks.MOD_ID, "facade_block", Block.Properties.create(Material.ROCK, MaterialColor.DIRT)
			.hardnessAndResistance(1.5F, 6.0F));
	
	public static List<Block> BLOCKS = new ArrayList<>(100);
	
	static {
		// facade
		GRANITE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.GRANITE_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.DIRT).hardnessAndResistance(1.5F, 6.0F));
		POLISHED_GRANITE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.POLISHED_GRANITE_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.DIRT).hardnessAndResistance(1.5F, 6.0F));
		DIORITE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.DIORITE_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.DIRT).hardnessAndResistance(1.5F, 6.0F));
		POLISHED_DIORITE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.POLISHED_DIORITE_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.DIRT).hardnessAndResistance(1.5F, 6.0F));
		ANDESITE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.ANDESITE_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.DIRT).hardnessAndResistance(1.5F, 6.0F));
		POLISHED_ANDESITE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.POLISHED_ANDESITE_FACADE_ID, Block.Properties.create(Material.ROCK, MaterialColor.DIRT).hardnessAndResistance(1.5F, 6.0F));		
		
		/*
		 * setup array
		 */
		BLOCKS.add(testBlock);
		BLOCKS.add(facingBlock);
		BLOCKS.add(facadeBlock);
		
		BLOCKS.add(GRANITE_FACADE);
		BLOCKS.add(POLISHED_GRANITE_FACADE);
		BLOCKS.add(DIORITE_FACADE);
		BLOCKS.add(POLISHED_DIORITE_FACADE);
		BLOCKS.add(ANDESITE_FACADE);
		BLOCKS.add(POLISHED_ANDESITE_FACADE);
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
//			registry.registerAll(
//			           testBlock, facingBlock
//					);

		}
		
		/**
		 * Register this mod's {@link ItemBlock}s.
		 *
		 * @param event The event
		 */
		@SubscribeEvent
		public static void registerItemBlocks(final RegistryEvent.Register<Item> event) {
			final IForgeRegistry<Item> registry = event.getRegistry();
//			BlockItem itemBlock = new BlockItem(testBlock, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
//			final ResourceLocation registryName = Preconditions.checkNotNull(testBlock.getRegistryName(), "Block %s has null registry name", testBlock);
//			registry.register(itemBlock.setRegistryName(registryName));
			for (Block b : BLOCKS) {
				// TODO update item properties with group so all items can be added to our item group (tab)
				BlockItem itemBlock = new BlockItem(b, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
				final ResourceLocation registryName = Preconditions.checkNotNull(b.getRegistryName(), "Block %s has null registry name", b);
				registry.register(itemBlock.setRegistryName(registryName));
				ITEM_BLOCKS.add(itemBlock);			
			}
		}		
	}
}

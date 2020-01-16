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
import net.minecraftforge.fml.common.Mod.*;
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
	public static Block stoneFacade;
	public static Block flutedStoneFacade;
	
	public static Block testBlock = new Block(Block.Properties.create(Material.IRON)
 		   .hardnessAndResistance(5)
 		   .harvestLevel(2)
 		   .harvestTool(ToolType.PICKAXE))
    .setRegistryName(DungeonBlocks.MOD_ID, "test_block");
	
	public static Block facingBlock = new MyFacingBlock(DungeonBlocks.MOD_ID, "facing_block", Block.Properties.create(Material.ROCK)
			.hardnessAndResistance(5)
			.harvestLevel(2)
			.harvestTool(ToolType.PICKAXE));

	public static Block facadeBlock = new MyFacingBlock(DungeonBlocks.MOD_ID, "facade_block", Block.Properties.create(Material.ROCK)
			.hardnessAndResistance(5)
			.harvestLevel(2)
			.harvestTool(ToolType.PICKAXE));
	
	public static List<Block> BLOCKS = new ArrayList<>(100);
	
	static {
		// basic facade
//		stoneFacade = new BasicFacadeBlock(DungeonBlocks.MODID, ModConfig.basicStoneFacadeId, Material.ROCK).setHardness(1.5F).setResistance(10.0F);

		// flute pillar facade
//		flutedStoneFacade = new FlutedFacadeBlock(DungeonBlocks.MODID, "fluted_stone_facade", Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 10.0F)
//				.harvestLevel(2));

		/*
		 * setup array
		 */
//		BLOCKS.add(flutedStoneFacade);
		BLOCKS.add(testBlock);
		BLOCKS.add(facingBlock);
		BLOCKS.add(facadeBlock);
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

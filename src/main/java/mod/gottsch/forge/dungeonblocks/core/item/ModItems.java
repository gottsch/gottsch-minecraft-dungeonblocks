/*
 * This file is part of  DungeonBlocks.
 * Copyright (c) 2021 Mark Gottschling (gottsch)
 * 
 * All rights reserved.
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
package mod.gottsch.forge.dungeonblocks.core.item;

import mod.gottsch.forge.dungeonblocks.DungeonBlocks;
import mod.gottsch.forge.dungeonblocks.core.block.ModBlocks;
import mod.gottsch.forge.dungeonblocks.core.entity.ModEntityTypes;
import mod.gottsch.forge.dungeonblocks.core.setup.Registration;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

/**
 * @author Mark Gottschling on Jan 13, 2020
 * This class has the register event handler for all custom items.
 * This class uses @Mod.EventBusSubscriber so the event handler has to be static
 * This class uses @ObjectHolder to get a reference to the items
 *
 */
@Mod.EventBusSubscriber(modid = DungeonBlocks.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItems {
	
	public static final Item.Properties ITEM_PROPERTIES = new Item.Properties();
	public static final Supplier<Item.Properties> ITEM_PROPS_SUPPLIER = Item.Properties::new;

	public static final RegistryObject<Item> LOGO = Registration.ITEMS.register("dungeonblocks_logo", () -> new Item(new Item.Properties()));

	static {
		// create items
		Registration.BLOCKS.getEntries().forEach(block -> {
			if (block != ModBlocks.MOLD && block != ModBlocks.LICHEN
			&& block != ModBlocks.SKELETON) {
				ModBlocks.MAP.put(block, fromBlock(block, ModItems.ITEM_PROPERTIES));
			}
		});	
	}

	// static referenced items
	public static RegistryObject<Item> MOLD = fromBlock(ModBlocks.MOLD, ITEM_PROPERTIES);
	public static RegistryObject<Item> LICHEN = fromBlock(ModBlocks.LICHEN, ITEM_PROPERTIES);
	public static RegistryObject<Item> SKELETON = Registration.ITEMS.register("skeleton", () -> new SkeletonItem(ModBlocks.SKELETON.get(), new Item.Properties()));

	// entity-backed decorative props. The lambdas defer ModEntityTypes' class init so it isn't
	// forced during ModItems' own static initialization.
	public static final RegistryObject<Item> POT = Registration.ITEMS.register("pot",
			() -> new PotItem(() -> ModEntityTypes.POT.get(), new Item.Properties()));
	public static final RegistryObject<Item> SQUAT_CLAY_POT = Registration.ITEMS.register("squat_clay_pot",
			() -> new PotItem(() -> ModEntityTypes.SQUAT_CLAY_POT.get(), new Item.Properties()));
	public static final RegistryObject<Item> THIN_CLAY_POT = Registration.ITEMS.register("thin_clay_pot",
			() -> new PotItem(() -> ModEntityTypes.THIN_CLAY_POT.get(), new Item.Properties()));
	public static final RegistryObject<Item> STONE_POT = Registration.ITEMS.register("stone_pot",
			() -> new PotItem(() -> ModEntityTypes.STONE_POT.get(), new Item.Properties()));
	public static final RegistryObject<Item> SQUAT_STONE_POT = Registration.ITEMS.register("squat_stone_pot",
			() -> new PotItem(() -> ModEntityTypes.SQUAT_STONE_POT.get(), new Item.Properties()));
	public static final RegistryObject<Item> THIN_STONE_POT = Registration.ITEMS.register("thin_stone_pot",
			() -> new PotItem(() -> ModEntityTypes.THIN_STONE_POT.get(), new Item.Properties()));
	public static final RegistryObject<Item> RED_POT = Registration.ITEMS.register("red_pot",
			() -> new PotItem(() -> ModEntityTypes.RED_POT.get(), new Item.Properties()));
	public static final RegistryObject<Item> SQUAT_RED_POT = Registration.ITEMS.register("squat_red_pot",
			() -> new PotItem(() -> ModEntityTypes.SQUAT_RED_POT.get(), new Item.Properties()));
	public static final RegistryObject<Item> THIN_RED_POT = Registration.ITEMS.register("thin_red_pot",
			() -> new PotItem(() -> ModEntityTypes.THIN_RED_POT.get(), new Item.Properties()));
	public static final RegistryObject<Item> BLUE_POT = Registration.ITEMS.register("blue_pot",
			() -> new PotItem(() -> ModEntityTypes.BLUE_POT.get(), new Item.Properties()));
	public static final RegistryObject<Item> SQUAT_BLUE_POT = Registration.ITEMS.register("squat_blue_pot",
			() -> new PotItem(() -> ModEntityTypes.SQUAT_BLUE_POT.get(), new Item.Properties()));
	public static final RegistryObject<Item> THIN_BLUE_POT = Registration.ITEMS.register("thin_blue_pot",
			() -> new PotItem(() -> ModEntityTypes.THIN_BLUE_POT.get(), new Item.Properties()));
	public static final RegistryObject<Item> BIG_RED_POTION = Registration.ITEMS.register("big_red_potion",
			() -> new PotItem(() -> ModEntityTypes.BIG_RED_POTION.get(), new Item.Properties()));
	public static final RegistryObject<Item> RED_FLASK = Registration.ITEMS.register("red_flask",
			() -> new PotItem(() -> ModEntityTypes.RED_FLASK.get(), new Item.Properties()));
	public static final RegistryObject<Item> BIG_YELLOW_POTION = Registration.ITEMS.register("big_yellow_potion",
			() -> new PotItem(() -> ModEntityTypes.BIG_YELLOW_POTION.get(), new Item.Properties()));
	public static final RegistryObject<Item> YELLOW_FLASK = Registration.ITEMS.register("yellow_flask",
			() -> new PotItem(() -> ModEntityTypes.YELLOW_FLASK.get(), new Item.Properties()));
	public static final RegistryObject<Item> BIG_BLUE_POTION = Registration.ITEMS.register("big_blue_potion",
			() -> new PotItem(() -> ModEntityTypes.BIG_BLUE_POTION.get(), new Item.Properties()));
	public static final RegistryObject<Item> BLUE_FLASK = Registration.ITEMS.register("blue_flask",
			() -> new PotItem(() -> ModEntityTypes.BLUE_FLASK.get(), new Item.Properties()));
	public static final RegistryObject<Item> BIG_GREEN_POTION = Registration.ITEMS.register("big_green_potion",
			() -> new PotItem(() -> ModEntityTypes.BIG_GREEN_POTION.get(), new Item.Properties()));
	public static final RegistryObject<Item> GREEN_FLASK = Registration.ITEMS.register("green_flask",
			() -> new PotItem(() -> ModEntityTypes.GREEN_FLASK.get(), new Item.Properties()));

	/**
	 * Items belonging to the decorative-entity subsystem. These are pulled out of the main
	 * DungeonBlocks tab (which otherwise sweeps up every registered item) and shown in the
	 * DungeonBlocks Entities tab instead — see {@link ModCreativeModeTabs}.
	 */
	public static final List<RegistryObject<Item>> ENTITY_ITEMS = List.of(
			POT, SQUAT_CLAY_POT, THIN_CLAY_POT,
			STONE_POT, SQUAT_STONE_POT, THIN_STONE_POT,
			RED_POT, SQUAT_RED_POT, THIN_RED_POT,
			BLUE_POT, SQUAT_BLUE_POT, THIN_BLUE_POT,
			BIG_RED_POTION, RED_FLASK,
			BIG_YELLOW_POTION, YELLOW_FLASK,
			BIG_BLUE_POTION, BLUE_FLASK,
			BIG_GREEN_POTION, GREEN_FLASK);

	/**
	 * 
	 */
	public static void register() {
		// cycle through all block and create items
		Registration.registerItems();
	}
	
	// conveniance method: take a RegistryObject<Block> and make a corresponding RegistryObject<Item> from it
	public static <B extends Block> RegistryObject<Item> fromBlock(RegistryObject<B> block, Item.Properties itemProperties) {
		return Registration.ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), itemProperties));
	}
}

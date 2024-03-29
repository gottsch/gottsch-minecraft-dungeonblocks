/*
 * This file is part of  DungeonBlocks.
 * Copyright (c) 2021, Mark Gottschling (gottsch)
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
package com.someguyssoftware.dungeonblocks.item;

import com.someguyssoftware.dungeonblocks.DungeonBlocks;
import com.someguyssoftware.dungeonblocks.block.ModBlocks;
import com.someguyssoftware.dungeonblocks.setup.Registration;
import com.someguyssoftware.gottschcore.item.ModItem;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.RegistryObject;

/**
 * @author Mark Gottschling on Jan 13, 2020
 * This class has the register event handler for all custom items.
 * This class uses @Mod.EventBusSubscriber so the event handler has to be static
 * This class uses @ObjectHolder to get a reference to the items
 *
 */
@Mod.EventBusSubscriber(modid = DungeonBlocks.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItems {

	public static final CreativeModeTab ITEM_GROUP = new CreativeModeTab(DungeonBlocks.MOD_ID) {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(ModItems.LOGO.get());
		}
	};
	
	public static final Item.Properties ITEM_PROPERTIES = new Item.Properties().tab(ITEM_GROUP);

	public static final RegistryObject<Item> LOGO = Registration.ITEMS.register("dungeonblocks_logo", () -> new Item(new Item.Properties()));

	/**
	 * 
	 */
	public static void register() {
		// cycle through all block and create items
		Registration.registerItems();
	}
}

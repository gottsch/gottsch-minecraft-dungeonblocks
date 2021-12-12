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

import java.util.function.Supplier;

import com.someguyssoftware.dungeonblocks.DungeonBlocks;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

/**
 * @author Mark Gottschling on Jan 17, 2020
 *
 */
public class ModItemGroups {
	public static final CreativeModeTab MOD_ITEM_GROUP = new ModItemGroup(
			DungeonBlocks.MOD_ID,	() -> new ItemStack(ModItems.LOGO));
	
	
	public static class ModItemGroup extends CreativeModeTab {
		
		private final Supplier<ItemStack> iconSupplier;

		public ModItemGroup(final String name, final Supplier<ItemStack> iconSupplier) {
			super(name);
			this.iconSupplier = iconSupplier;
		}

		@Override
		public ItemStack makeIcon() {
			return iconSupplier.get();
		}
	}
}

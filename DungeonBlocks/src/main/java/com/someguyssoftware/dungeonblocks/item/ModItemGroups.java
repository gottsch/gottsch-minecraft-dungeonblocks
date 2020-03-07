/**
 * 
 */
package com.someguyssoftware.dungeonblocks.item;

import java.util.function.Supplier;

import com.someguyssoftware.dungeonblocks.DungeonBlocks;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

/**
 * @author Mark Gottschling on Jan 17, 2020
 *
 */
public class ModItemGroups {
	public static final ItemGroup MOD_ITEM_GROUP = new ModItemGroup(
			DungeonBlocks.MOD_ID,	() -> new ItemStack(ModItems.LOGO));
	
	
	public static class ModItemGroup extends ItemGroup {
		
		private final Supplier<ItemStack> iconSupplier;

		public ModItemGroup(final String name, final Supplier<ItemStack> iconSupplier) {
			super(name);
			this.iconSupplier = iconSupplier;
		}

		@Override
		public ItemStack createIcon() {
			return iconSupplier.get();
		}
	}
}

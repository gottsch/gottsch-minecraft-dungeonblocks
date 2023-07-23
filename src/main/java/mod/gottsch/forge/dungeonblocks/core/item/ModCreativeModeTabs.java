/*
 * This file is part of  DungeonBlocks.
 * Copyright (c) 2023 Mark Gottschling (gottsch)
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
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * 
 * @author Mark Gottschling Feb 17, 2023
 *
 */
@Mod.EventBusSubscriber(modid = DungeonBlocks.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {
	public static CreativeModeTab MOD_TAB;
	
	@SubscribeEvent
	public static void registerTab(CreativeModeTabEvent.Register event) {
		MOD_TAB = event.registerCreativeModeTab(new ResourceLocation(DungeonBlocks.MOD_ID, "dungeon_blocks_tab"),
				builder -> builder.icon(() -> new ItemStack(ModItems.LOGO.get())).title(Component.translatable("itemGroup.dungeonblocks")));
	}
}

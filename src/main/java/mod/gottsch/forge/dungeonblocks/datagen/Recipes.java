/*
 * This file is part of  Dungeon Blocks.
 * Copyright (c) 2023 Mark Gottschling (gottsch)
 *
 * All rights reserved.
 *
 * Dungeon Blocks is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Dungeon Blocks is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Dungeon Blocks.  If not, see <http://www.gnu.org/licenses/lgpl>.
 */
package mod.gottsch.forge.dungeonblocks.datagen;

import mod.gottsch.forge.dungeonblocks.core.block.ModBlocks;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.RegistryObject;

import java.util.*;
import java.util.function.Consumer;

/**
 * 
 * @author Mark Gottschling on Oct 26, 2023
 *
 */
public class Recipes extends RecipeProvider {
	private static String CRITERIA = "criteria";

		public Recipes(PackOutput output) {
			super(output);
		}

		@Override
		protected void buildRecipes(Consumer<FinishedRecipe> recipe) {

			// dungeon lantern
			ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.DUNGEON_LANTERN.get())
					.requires(Blocks.LANTERN)
					.requires(Items.IRON_INGOT)
					.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.LANTERN))
					.save(recipe);

			// torch sconce
			ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.TORCH_SCONCE.get())
					.requires(Blocks.TORCH)
					.requires(Items.IRON_INGOT)
					.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT))
					.save(recipe);

			// candle sconce
			ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CANDLE_SCONCE.get(), 3)
					.pattern("ccc")
					.pattern("   ")
					.pattern("xxx")
					.define('x', Items.IRON_INGOT)
					.define('c', Items.CANDLE)
					.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT))
					.save(recipe);

			// plate bracket
			ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.PLATE_BRACKET_BLOCK.get())
					.requires(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE)
					.requires(Items.IRON_INGOT)
					.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT))
					.save(recipe);

			// iron grate
			ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_IRON_GRATE.get(), 2)
					.pattern("x x")
					.pattern(" x ")
					.pattern("x x")
					.define('x', Items.IRON_INGOT)
					.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT))
					.save(recipe);

			// copper grate
			ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WEATHERED_COPPER_GRATE.get(), 2)
					.pattern("x x")
					.pattern(" x ")
					.pattern("x x")
					.define('x', Items.COPPER_INGOT)
					.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(Items.COPPER_INGOT))
					.save(recipe);

			// brazier
			ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.BRAZIER.get())
					.requires(Blocks.CAMPFIRE)
					.requires(Items.IRON_INGOT)
					.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT))
					.save(recipe);

			// wall ring
			ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WALL_RING.get())
					.pattern(" x ")
					.pattern("x x")
					.pattern(" x ")
					.define('x', Items.IRON_INGOT)
					.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT))
					.save(recipe);

			// dungeon doors
			ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.CRIMSON_DUNGEON_DOOR.get())
					.requires(Blocks.CRIMSON_DOOR)
					.requires(Items.IRON_INGOT)
					.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT))
					.save(recipe);
			ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.DARK_OAK_DUNGEON_DOOR.get())
					.requires(Blocks.DARK_OAK_DOOR)
					.requires(Items.IRON_INGOT)
					.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT))
					.save(recipe);
			ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MANGROVE_DUNGEON_DOOR.get())
					.requires(Blocks.MANGROVE_DOOR)
					.requires(Items.IRON_INGOT)
					.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT))
					.save(recipe);
			ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.SPRUCE_DUNGEON_DOOR.get())
					.requires(Blocks.SPRUCE_DOOR)
					.requires(Items.IRON_INGOT)
					.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT))
					.save(recipe);

			// hay patches
			ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.HAY_BLOCK)
					.pattern("xxx")
					.pattern("xxx")
					.pattern("xxx")
					.define('x', Ingredient.of(ModBlocks.HAY_PATCH.get(), ModBlocks.DIRTY_HAY_PATCH.get()))
					.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.HAY_PATCH.get()))
					.save(recipe);

			// barred windows
			Map<Block, RegistryObject<Block>> barredMap = new HashMap<>();
			barredMap.put(Blocks.STONE, ModBlocks.STONE_BARRED_WINDOW);
			barredMap.put(Blocks.SMOOTH_STONE, ModBlocks.SMOOTH_STONE_BARRED_WINDOW);
			barredMap.put(Blocks.COBBLESTONE, ModBlocks.COBBLESTONE_BARRED_WINDOW);
			barredMap.put(Blocks.MOSSY_COBBLESTONE, ModBlocks.MOSSY_COBBLESTONE_BARRED_WINDOW);
			barredMap.put(Blocks.BRICKS, ModBlocks.BRICKS_BARRED_WINDOW);
			barredMap.put(Blocks.STONE_BRICKS, ModBlocks.STONE_BRICKS_BARRED_WINDOW);
			barredMap.put(Blocks.MOSSY_STONE_BRICKS, ModBlocks.MOSSY_STONE_BRICKS_BARRED_WINDOW);
			barredMap.put(Blocks.CRACKED_STONE_BRICKS, ModBlocks.CRACKED_STONE_BRICKS_BARRED_WINDOW);
			barredMap.put(Blocks.CHISELED_STONE_BRICKS, ModBlocks.CHISELED_STONE_BRICKS_BARRED_WINDOW);
			barredMap.put(Blocks.OBSIDIAN, ModBlocks.OBSIDIAN_BARRED_WINDOW);

			barredMap.put(Blocks.SANDSTONE, ModBlocks.SANDSTONE_BARRED_WINDOW);
			barredMap.put(Blocks.SMOOTH_SANDSTONE, ModBlocks.SMOOTH_SANDSTONE_BARRED_WINDOW);
			barredMap.put(Blocks.CHISELED_SANDSTONE, ModBlocks.CHISELED_SANDSTONE_BARRED_WINDOW);
			barredMap.put(Blocks.CUT_SANDSTONE, ModBlocks.CUT_SANDSTONE_BARRED_WINDOW);
			barredMap.put(Blocks.RED_SANDSTONE, ModBlocks.RED_SANDSTONE_BARRED_WINDOW);
			barredMap.put(Blocks.SMOOTH_RED_SANDSTONE, ModBlocks.SMOOTH_RED_SANDSTONE_BARRED_WINDOW);
			barredMap.put(Blocks.CHISELED_RED_SANDSTONE, ModBlocks.CHISELED_RED_SANDSTONE_BARRED_WINDOW);
			barredMap.put(Blocks.CUT_RED_SANDSTONE, ModBlocks.CUT_RED_SANDSTONE_BARRED_WINDOW);
			barredMap.put(Blocks.TERRACOTTA, ModBlocks.TERRACOTTA_BARRED_WINDOW);

			barredMap.forEach((k,v) -> {
				ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, v.get())
						.requires(k)
						.requires(Ingredient.of(ModBlocks.DARK_IRON_GRATE.get(), ModBlocks.DARK_IRON_GRATE_TRAPDOOR.get()))
						.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.DARK_IRON_GRATE.get(), ModBlocks.DARK_IRON_GRATE_TRAPDOOR.get()))
						.save(recipe);
			});
			barredMap.clear();
			barredMap.put(ModBlocks.STONE_BARRED_WINDOW.get(), ModBlocks.STONE_BARRED_WINDOW_FACADE);
			barredMap.put(ModBlocks.SMOOTH_STONE_BARRED_WINDOW.get(), ModBlocks.SMOOTH_STONE_BARRED_WINDOW_FACADE);
			barredMap.put(ModBlocks.COBBLESTONE_BARRED_WINDOW.get(), ModBlocks.COBBLESTONE_BARRED_WINDOW_FACADE);
			barredMap.put(ModBlocks.MOSSY_COBBLESTONE_BARRED_WINDOW.get(), ModBlocks.MOSSY_COBBLESTONE_BARRED_WINDOW_FACADE);
			barredMap.put(ModBlocks.BRICKS_BARRED_WINDOW.get(), ModBlocks.BRICKS_BARRED_WINDOW_FACADE);
			barredMap.put(ModBlocks.STONE_BRICKS_BARRED_WINDOW.get(), ModBlocks.STONE_BRICKS_BARRED_WINDOW_FACADE);
			barredMap.put(ModBlocks.MOSSY_STONE_BRICKS_BARRED_WINDOW.get(), ModBlocks.MOSSY_STONE_BRICKS_BARRED_WINDOW_FACADE);
			barredMap.put(ModBlocks.CRACKED_STONE_BRICKS_BARRED_WINDOW.get(), ModBlocks.CRACKED_STONE_BRICKS_BARRED_WINDOW_FACADE);
			barredMap.put(ModBlocks.CHISELED_STONE_BRICKS_BARRED_WINDOW.get(), ModBlocks.CHISELED_STONE_BRICKS_BARRED_WINDOW_FACADE);
			barredMap.put(ModBlocks.OBSIDIAN_BARRED_WINDOW.get(), ModBlocks.OBSIDIAN_BARRED_WINDOW_FACADE);

			barredMap.put(ModBlocks.SANDSTONE_BARRED_WINDOW.get(), ModBlocks.SANDSTONE_BARRED_WINDOW_FACADE);
			barredMap.put(ModBlocks.SMOOTH_SANDSTONE_BARRED_WINDOW.get(), ModBlocks.SMOOTH_SANDSTONE_BARRED_WINDOW_FACADE);
			barredMap.put(ModBlocks.CHISELED_SANDSTONE_BARRED_WINDOW.get(), ModBlocks.CHISELED_SANDSTONE_BARRED_WINDOW_FACADE);
			barredMap.put(ModBlocks.CUT_SANDSTONE_BARRED_WINDOW.get(), ModBlocks.CUT_SANDSTONE_BARRED_WINDOW_FACADE);
			barredMap.put(ModBlocks.RED_SANDSTONE_BARRED_WINDOW.get(), ModBlocks.RED_SANDSTONE_BARRED_WINDOW_FACADE);
			barredMap.put(ModBlocks.SMOOTH_RED_SANDSTONE_BARRED_WINDOW.get(), ModBlocks.SMOOTH_RED_SANDSTONE_BARRED_WINDOW_FACADE);
			barredMap.put(ModBlocks.CHISELED_RED_SANDSTONE_BARRED_WINDOW.get(), ModBlocks.CHISELED_RED_SANDSTONE_BARRED_WINDOW_FACADE);
			barredMap.put(ModBlocks.CUT_RED_SANDSTONE_BARRED_WINDOW.get(), ModBlocks.CUT_RED_SANDSTONE_BARRED_WINDOW_FACADE);
			barredMap.put(ModBlocks.TERRACOTTA_BARRED_WINDOW.get(), ModBlocks.TERRACOTTA_BARRED_WINDOW_FACADE);

			barredMap.forEach((k,v) -> {
				ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, v.get(), 2)
						.requires(k)
						.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(v.get()))
						.save(recipe);
			});

			/*
			 * stone cutting
			 */
			DataGenMaps.m.forEach((k, v) -> {
				v.forEach(b -> {
					SingleItemRecipeBuilder.stonecutting(Ingredient.of(k), RecipeCategory.BUILDING_BLOCKS, b.get())
							.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(k))
							.save(recipe);
				});
			});

		}
}

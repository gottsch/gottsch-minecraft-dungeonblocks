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

import mod.gottsch.forge.dungeonblocks.DungeonBlocks;
import mod.gottsch.forge.dungeonblocks.core.block.BarredWindows;
import mod.gottsch.forge.dungeonblocks.core.block.ModBlocks;
import mod.gottsch.forge.dungeonblocks.core.setup.Registration;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
			Map<Block, RegistryObject<Block>> ingredientMap = new HashMap<>();

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

			// angle cobwebs
			ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.ANGLE_COBWEB_1.get())
					.requires(Items.STRING, 4)
					.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(Items.STRING))
					.save(recipe);
			ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.ANGLE_COBWEB_2.get())
					.requires(Items.STRING, 2)
					.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(Items.STRING))
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
			ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.DARK_IRON_PLATE_BRACKET.get())
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

			// iron bars door
			ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE, ModBlocks.IRON_BARS_DOOR.get())
					.requires(Blocks.IRON_DOOR)
					.requires(Blocks.IRON_BARS)
					.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_BARS))
					.save(recipe);

			// dark iron bars: eight iron bars around a coal, blackened; the door as the iron one is
			ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.DARK_IRON_BARS.get(), 8)
					.pattern("bbb")
					.pattern("bcb")
					.pattern("bbb")
					.define('b', Blocks.IRON_BARS)
					.define('c', Items.COAL)
					.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_BARS))
					.save(recipe);
			ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE, ModBlocks.DARK_IRON_BARS_DOOR.get())
					.requires(Blocks.IRON_DOOR)
					.requires(ModBlocks.DARK_IRON_BARS.get())
					.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.DARK_IRON_BARS.get()))
					.save(recipe);

			// dark iron ladder: vanilla's ladder in iron ingots, blackened with a coal
			ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.DARK_IRON_LADDER.get(), 8)
					.pattern("i i")
					.pattern("ici")
					.pattern("i i")
					.define('i', Items.IRON_INGOT)
					.define('c', Items.COAL)
					.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT))
					.save(recipe);

			// sharpened logs: a stripped log sharpened with flint
			sharpened(recipe, ModBlocks.SHARPENED_OAK_LOG, Blocks.STRIPPED_OAK_LOG);
			sharpened(recipe, ModBlocks.SHARPENED_SPRUCE_LOG, Blocks.STRIPPED_SPRUCE_LOG);
			sharpened(recipe, ModBlocks.SHARPENED_BIRCH_LOG, Blocks.STRIPPED_BIRCH_LOG);
			sharpened(recipe, ModBlocks.SHARPENED_JUNGLE_LOG, Blocks.STRIPPED_JUNGLE_LOG);
			sharpened(recipe, ModBlocks.SHARPENED_ACACIA_LOG, Blocks.STRIPPED_ACACIA_LOG);
			sharpened(recipe, ModBlocks.SHARPENED_DARK_OAK_LOG, Blocks.STRIPPED_DARK_OAK_LOG);
			sharpened(recipe, ModBlocks.SHARPENED_MANGROVE_LOG, Blocks.STRIPPED_MANGROVE_LOG);
			sharpened(recipe, ModBlocks.SHARPENED_CHERRY_LOG, Blocks.STRIPPED_CHERRY_LOG);
			sharpened(recipe, ModBlocks.SHARPENED_BAMBOO_BLOCK, Blocks.STRIPPED_BAMBOO_BLOCK);
			sharpened(recipe, ModBlocks.SHARPENED_CRIMSON_STEM, Blocks.STRIPPED_CRIMSON_STEM);
			sharpened(recipe, ModBlocks.SHARPENED_WARPED_STEM, Blocks.STRIPPED_WARPED_STEM);

			// capstones: stonecut from their source, one for one
			ModBlocks.CAPSTONES.forEach((capstone, source) ->
					SingleItemRecipeBuilder.stonecutting(Ingredient.of(source.get()), RecipeCategory.BUILDING_BLOCKS, capstone.get())
							.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(source.get()))
							.save(recipe));

			// spikes: a row of nuggets for points over a row of ingots for the plate
			ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.IRON_SPIKES.get(), 2)
					.pattern("nnn")
					.pattern("iii")
					.define('n', Items.IRON_NUGGET)
					.define('i', Items.IRON_INGOT)
					.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT))
					.save(recipe);
			// dark iron spikes: iron spikes blackened with coal
			ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_IRON_SPIKES.get())
					.requires(ModBlocks.IRON_SPIKES.get())
					.requires(Items.COAL)
					.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.IRON_SPIKES.get()))
					.save(recipe);

			// cheval-de-frise: a log with a sharpened log either side of it
			ModBlocks.CHEVALS_DE_FRISE.forEach(cheval -> {
				String log = DataGenMaps.logOf(DataGenMaps.woodOf(cheval.getId().getPath(), "cheval_de_frise"));
				Block sharpened = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DungeonBlocks.MOD_ID, "sharpened_" + log));
				ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, cheval.get())
						.pattern("sls")
						.define('s', sharpened)
						.define('l', ForgeRegistries.BLOCKS.getValue(new ResourceLocation(log)))
						.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(sharpened))
						.save(recipe);
			});

			// walkway bracket: stripped logs laid out as the knee brace itself
			ModBlocks.WALKWAY_BRACKETS.forEach(bracket -> {
				String log = DataGenMaps.logOf(DataGenMaps.woodOf(bracket.getId().getPath(), "walkway_bracket"));
				Block stripped = ForgeRegistries.BLOCKS.getValue(new ResourceLocation("stripped_" + log));
				ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, bracket.get(), 4)
						.pattern("ss")
						.pattern("s ")
						.define('s', stripped)
						.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(stripped))
						.save(recipe);
			});

			// portcullis: iron bars braced with ingots; the winch is a drum, a chain and iron
			ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.PORTCULLIS.get(), 4)
					.pattern("bib")
					.pattern("bib")
					.define('b', Blocks.IRON_BARS)
					.define('i', Items.IRON_INGOT)
					.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_BARS))
					.save(recipe);
			ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE, ModBlocks.PORTCULLIS_WINCH.get())
					.requires(Blocks.STRIPPED_SPRUCE_LOG)
					.requires(Blocks.CHAIN)
					.requires(Items.IRON_INGOT)
					.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.PORTCULLIS.get()))
					.save(recipe);

			// sarcophagi: a lid of slabs over a chest of the carved block
			sarcophagus(recipe, ModBlocks.STONE_SARCOPHAGUS, Blocks.SMOOTH_STONE_SLAB, Blocks.CHISELED_STONE_BRICKS);
			sarcophagus(recipe, ModBlocks.DEEPSLATE_SARCOPHAGUS, Blocks.POLISHED_DEEPSLATE_SLAB, Blocks.CHISELED_DEEPSLATE);

			// iron maiden: an iron case around iron bars
			ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.IRON_MAIDEN.get())
					.pattern("iii")
					.pattern("ibi")
					.pattern("iii")
					.define('i', Items.IRON_INGOT)
					.define('b', Blocks.IRON_BARS)
					.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT))
					.save(recipe);

			// gibbet: a cage of iron bars around a bone block
			ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.GIBBET.get())
					.pattern("bbb")
					.pattern("bxb")
					.pattern("bbb")
					.define('b', Blocks.IRON_BARS)
					.define('x', Blocks.BONE_BLOCK)
					.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.IRON_BARS))
					.save(recipe);

			// pillory: a slab board between two log posts; the rack: a plank bed on fence legs with a
			// log roller at each end, strung with string. Each takes a bone block to fill, as the
			// gibbet does.
			ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.PILLORY.get())
					.pattern("lsl")
					.pattern("l l")
					.pattern("l l")
					.define('l', Blocks.DARK_OAK_LOG)
					.define('s', Blocks.DARK_OAK_SLAB)
					.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.DARK_OAK_LOG))
					.save(recipe);
			ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.TORTURE_RACK.get())
					.pattern("ltl")
					.pattern("ppp")
					.pattern("f f")
					.define('l', Blocks.DARK_OAK_LOG)
					.define('t', Items.STRING)
					.define('p', Blocks.DARK_OAK_PLANKS)
					.define('f', Blocks.DARK_OAK_FENCE)
					.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.DARK_OAK_LOG))
					.save(recipe);
			for (List<RegistryObject<Block>> pair : List.of(List.of(ModBlocks.PILLORY, ModBlocks.OCCUPIED_PILLORY),
					List.of(ModBlocks.TORTURE_RACK, ModBlocks.OCCUPIED_TORTURE_RACK))) {
				ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, pair.get(1).get())
						.requires(pair.get(0).get())
						.requires(Blocks.BONE_BLOCK)
						.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(pair.get(0).get()))
						.save(recipe);
			}

			// firewood rack: logs between two hoops of iron bars - any log a campfire would burn
			ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.FIREWOOD_RACK.get())
					.pattern("b b")
					.pattern("lll")
					.pattern("b b")
					.define('b', Blocks.IRON_BARS)
					.define('l', ItemTags.LOGS_THAT_BURN)
					.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.IRON_BARS))
					.save(recipe);

			// weapon rack: a rail of iron bars on two iron legs
			ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.WEAPON_RACK.get())
					.pattern("bbb")
					.pattern("i i")
					.define('b', Blocks.IRON_BARS)
					.define('i', Items.IRON_INGOT)
					.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT))
					.save(recipe);

			// coffins: a lid of the wood's slabs over its planks, with a bone laid in
			coffin(recipe, ModBlocks.SPRUCE_COFFIN, Blocks.SPRUCE_SLAB, Blocks.SPRUCE_PLANKS);
			coffin(recipe, ModBlocks.DARK_OAK_COFFIN, Blocks.DARK_OAK_SLAB, Blocks.DARK_OAK_PLANKS);
			coffin(recipe, ModBlocks.CRIMSON_COFFIN, Blocks.CRIMSON_SLAB, Blocks.CRIMSON_PLANKS);
			coffin(recipe, ModBlocks.MANGROVE_COFFIN, Blocks.MANGROVE_SLAB, Blocks.MANGROVE_PLANKS);

			// catacomb niches: the stone with a bone in it
			ModBlocks.CATACOMB_NICHES.forEach((niche, source) ->
					ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, niche.get())
							.requires(source.get())
							.requires(Items.BONE)
							.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(source.get()))
							.save(recipe));

			// skull pike: a bone block on two sticks
			ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.SKULL_PIKE.get())
					.pattern("b")
					.pattern("s")
					.pattern("s")
					.define('b', Blocks.BONE_BLOCK)
					.define('s', Items.STICK)
					.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.BONE_BLOCK))
					.save(recipe);
			// a zombie's head: rotten flesh on the pike; Steve's: leather for his skin, and red dye
			ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.ZOMBIE_HEAD_PIKE.get())
					.pattern("f")
					.pattern("s")
					.pattern("s")
					.define('f', Items.ROTTEN_FLESH)
					.define('s', Items.STICK)
					.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(Items.ROTTEN_FLESH))
					.save(recipe);
			ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.BLOODY_STEVE_HEAD_PIKE.get())
					.pattern("lr")
					.pattern("s ")
					.pattern("s ")
					.define('l', Items.LEATHER)
					.define('r', Items.RED_DYE)
					.define('s', Items.STICK)
					.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(Items.LEATHER))
					.save(recipe);

			// bone pile: four bones
			ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.BONE_PILE.get())
					.requires(Items.BONE, 4)
					.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(Items.BONE))
					.save(recipe);

			// chandelier: a row of candles on a row of iron, hung from a chain
			ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.CHANDELIER.get())
					.pattern(" c ")
					.pattern("kkk")
					.pattern("iii")
					.define('c', Blocks.CHAIN)
					.define('k', ItemTags.CANDLES)
					.define('i', Items.IRON_INGOT)
					.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.CHAIN))
					.save(recipe);

			// gargoyles: the perched one and the bust are carved in a stonecutter; the statue stands
			// on a smooth stone plinth, a block of chiseled stone bricks for its body
			SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.STONE), RecipeCategory.DECORATIONS, ModBlocks.PERCHED_GARGOYLE.get())
					.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.STONE))
					.save(recipe);
			SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.STONE), RecipeCategory.DECORATIONS, ModBlocks.GARGOYLE_BUST.get())
					.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.STONE))
					.save(recipe);
			ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.GARGOYLE_STATUE.get())
					.pattern("c")
					.pattern("c")
					.pattern("s")
					.define('c', Blocks.CHISELED_STONE_BRICKS)
					.define('s', Blocks.SMOOTH_STONE)
					.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.CHISELED_STONE_BRICKS))
					.save(recipe);

			// the secret passage: a torch sconce with a lever in it; a door of the wall's own stone,
			// its redstone set in; a pedestal of polished andesite
			ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE, ModBlocks.LEVER_SCONCE.get())
					.requires(ModBlocks.TORCH_SCONCE.get())
					.requires(Blocks.LEVER)
					.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.TORCH_SCONCE.get()))
					.save(recipe);
			ModBlocks.HIDDEN_DOORS.forEach((door, source) ->
					ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, door.get())
							.pattern("ss")
							.pattern("sr")
							.pattern("ss")
							.define('s', source.get())
							.define('r', Items.REDSTONE)
							.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(source.get()))
							.save(recipe));
			ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.PEDESTAL.get())
					.pattern("sss")
					.pattern(" s ")
					.pattern("sss")
					.define('s', Blocks.POLISHED_ANDESITE)
					.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.POLISHED_ANDESITE))
					.save(recipe);

			// tapestries: wool woven on a rod of sticks, a dye for the scene; a pristine one aged with
			// coarse dirt
			tapestry(recipe, ModBlocks.DRAGON_TAPESTRY, ModBlocks.WORN_DRAGON_TAPESTRY, Items.RED_DYE);
			tapestry(recipe, ModBlocks.HUNT_TAPESTRY, ModBlocks.WORN_HUNT_TAPESTRY, Items.GREEN_DYE);
			tapestry(recipe, ModBlocks.NECROMANCER_TAPESTRY, ModBlocks.WORN_NECROMANCER_TAPESTRY, Items.PURPLE_DYE);
			tapestry(recipe, ModBlocks.SUMMONING_TAPESTRY, ModBlocks.WORN_SUMMONING_TAPESTRY, Items.BLACK_DYE);
			// crumbling floors: the stone laid over gravel
			ModBlocks.CRUMBLING_FLOORS.forEach((floor, source) ->
					ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, floor.get())
							.requires(source.get())
							.requires(Blocks.GRAVEL)
							.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(source.get()))
							.save(recipe));
			// the rubble scatter is a Rubble block broken up
			ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.RUBBLE_SCATTER.get(), 4)
					.requires(ModBlocks.RUBBLE.get())
					.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.RUBBLE.get()))
					.save(recipe);

			// chain fixtures. Manacles: two iron cuffs on a chain
			ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.MANACLES.get())
					.pattern(" c ")
					.pattern("i i")
					.define('c', Blocks.CHAIN)
					.define('i', Items.IRON_INGOT)
					.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.CHAIN))
					.save(recipe);
			// meat hook: an ingot drawn out, and bent
			ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.MEAT_HOOK.get())
					.requires(Items.IRON_INGOT)
					.requires(Items.IRON_NUGGET, 2)
					.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT))
					.save(recipe);
			// censer: an iron bowl of coal on a chain
			ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.CENSER.get())
					.pattern(" c ")
					.pattern("iki")
					.pattern(" i ")
					.define('c', Blocks.CHAIN)
					.define('i', Items.IRON_INGOT)
					.define('k', ItemTags.COALS)
					.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.CHAIN))
					.save(recipe);

			// grate trapdoors
			ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.DARK_IRON_HEAVY_TRAPDOOR.get())
					.requires(Blocks.IRON_TRAPDOOR)
					.requires(Items.IRON_INGOT)
					.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT))
					.save(recipe);

			ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.WEATHERED_COPPER_HEAVY_TRAPDOOR.get())
					.requires(Blocks.IRON_TRAPDOOR)
					.requires(Items.COPPER_INGOT)
					.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT))
					.save(recipe);

			// brazier
			ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.BRAZIER.get())
					.requires(Blocks.CAMPFIRE)
					.requires(Items.IRON_INGOT)
					.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT))
					.save(recipe);

			// slab tables — a trestle: three slabs of top laid across two uprights
			slabTable(recipe, ModBlocks.STONE_SLAB_TABLE, Blocks.STONE_SLAB, Blocks.STONE);
			slabTable(recipe, ModBlocks.STONE_BRICKS_SLAB_TABLE, Blocks.STONE_BRICK_SLAB, Blocks.STONE_BRICKS);
			slabTable(recipe, ModBlocks.MOSSY_STONE_BRICKS_SLAB_TABLE, Blocks.MOSSY_STONE_BRICK_SLAB, Blocks.MOSSY_STONE_BRICKS);
			slabTable(recipe, ModBlocks.SMOOTH_STONE_SLAB_TABLE, Blocks.SMOOTH_STONE_SLAB, Blocks.SMOOTH_STONE);
			slabTable(recipe, ModBlocks.SMOOTH_SANDSTONE_SLAB_TABLE, Blocks.SMOOTH_SANDSTONE_SLAB, Blocks.SMOOTH_SANDSTONE);

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
					// its own id: saved under the result's default id it was minecraft:hay_block,
					// which REPLACED vanilla's nine-wheat hay bale recipe
					.save(recipe, new ResourceLocation(DungeonBlocks.MOD_ID, "hay_block_from_hay_patches"));

			// barred windows
			ingredientMap.clear();
			ingredientMap.put(Blocks.STONE, BarredWindows.STONE_BARRED_WINDOW);
			ingredientMap.put(Blocks.SMOOTH_STONE, BarredWindows.SMOOTH_STONE_BARRED_WINDOW);
			ingredientMap.put(Blocks.COBBLESTONE, BarredWindows.COBBLESTONE_BARRED_WINDOW);
			ingredientMap.put(Blocks.MOSSY_COBBLESTONE, BarredWindows.MOSSY_COBBLESTONE_BARRED_WINDOW);
			ingredientMap.put(Blocks.BRICKS, BarredWindows.BRICKS_BARRED_WINDOW);
			ingredientMap.put(Blocks.STONE_BRICKS, BarredWindows.STONE_BRICKS_BARRED_WINDOW);
			ingredientMap.put(Blocks.MOSSY_STONE_BRICKS, BarredWindows.MOSSY_STONE_BRICKS_BARRED_WINDOW);
			ingredientMap.put(Blocks.CRACKED_STONE_BRICKS, BarredWindows.CRACKED_STONE_BRICKS_BARRED_WINDOW);
			ingredientMap.put(Blocks.CHISELED_STONE_BRICKS, BarredWindows.CHISELED_STONE_BRICKS_BARRED_WINDOW);
			ingredientMap.put(Blocks.OBSIDIAN, BarredWindows.OBSIDIAN_BARRED_WINDOW);

			ingredientMap.put(Blocks.SANDSTONE, BarredWindows.SANDSTONE_BARRED_WINDOW);
			ingredientMap.put(Blocks.SMOOTH_SANDSTONE, BarredWindows.SMOOTH_SANDSTONE_BARRED_WINDOW);
			ingredientMap.put(Blocks.CHISELED_SANDSTONE, BarredWindows.CHISELED_SANDSTONE_BARRED_WINDOW);
			ingredientMap.put(Blocks.CUT_SANDSTONE, BarredWindows.CUT_SANDSTONE_BARRED_WINDOW);
			ingredientMap.put(Blocks.RED_SANDSTONE, BarredWindows.RED_SANDSTONE_BARRED_WINDOW);
			ingredientMap.put(Blocks.SMOOTH_RED_SANDSTONE, BarredWindows.SMOOTH_RED_SANDSTONE_BARRED_WINDOW);
			ingredientMap.put(Blocks.CHISELED_RED_SANDSTONE, BarredWindows.CHISELED_RED_SANDSTONE_BARRED_WINDOW);
			ingredientMap.put(Blocks.CUT_RED_SANDSTONE, BarredWindows.CUT_RED_SANDSTONE_BARRED_WINDOW);

			ingredientMap.put(Blocks.GRANITE, BarredWindows.GRANITE_BARRED_WINDOW);
			ingredientMap.put(Blocks.ANDESITE, BarredWindows.ANDESITE_BARRED_WINDOW);
			ingredientMap.put(Blocks.DIORITE, BarredWindows.DIORITE_BARRED_WINDOW);
			ingredientMap.put(Blocks.POLISHED_GRANITE, BarredWindows.POLISHED_GRANITE_BARRED_WINDOW);
			ingredientMap.put(Blocks.POLISHED_ANDESITE, BarredWindows.POLISHED_ANDESITE_BARRED_WINDOW);
			ingredientMap.put(Blocks.POLISHED_DIORITE, BarredWindows.POLISHED_DIORITE_BARRED_WINDOW);

			ingredientMap.put(Blocks.BLACKSTONE, BarredWindows.BLACKSTONE_BARRED_WINDOW);
			ingredientMap.put(Blocks.POLISHED_BLACKSTONE, BarredWindows.POLISHED_BLACKSTONE_BARRED_WINDOW);
			ingredientMap.put(Blocks.POLISHED_BLACKSTONE_BRICKS, BarredWindows.POLISHED_BLACKSTONE_BRICKS_BARRED_WINDOW);

			ingredientMap.put(Blocks.DEEPSLATE, BarredWindows.DEEPSLATE_BARRED_WINDOW);
			ingredientMap.put(Blocks.DEEPSLATE_BRICKS, BarredWindows.DEEPSLATE_BRICKS_BARRED_WINDOW);
			ingredientMap.put(Blocks.COBBLED_DEEPSLATE, BarredWindows.COBBLED_DEEPSLATE_BARRED_WINDOW);
			ingredientMap.put(Blocks.POLISHED_DEEPSLATE, BarredWindows.POLISHED_DEEPSLATE_BARRED_WINDOW);
			ingredientMap.put(Blocks.DEEPSLATE_TILES, BarredWindows.DEEPSLATE_TILES_BARRED_WINDOW);

			ingredientMap.put(Blocks.TERRACOTTA, BarredWindows.TERRACOTTA_BARRED_WINDOW);

			ingredientMap.forEach((k,v) -> {
				ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, v.get())
						.requires(k)
						.requires(Ingredient.of(ModBlocks.DARK_IRON_GRATE.get(), ModBlocks.DARK_IRON_HEAVY_TRAPDOOR.get()))
						.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.DARK_IRON_GRATE.get(), ModBlocks.DARK_IRON_HEAVY_TRAPDOOR.get()))
						.save(recipe);
			});
			ingredientMap.clear();
			ingredientMap.put(BarredWindows.STONE_BARRED_WINDOW.get(), BarredWindows.STONE_BARRED_WINDOW_FACADE);
			ingredientMap.put(BarredWindows.SMOOTH_STONE_BARRED_WINDOW.get(), BarredWindows.SMOOTH_STONE_BARRED_WINDOW_FACADE);
			ingredientMap.put(BarredWindows.COBBLESTONE_BARRED_WINDOW.get(), BarredWindows.COBBLESTONE_BARRED_WINDOW_FACADE);
			ingredientMap.put(BarredWindows.MOSSY_COBBLESTONE_BARRED_WINDOW.get(), BarredWindows.MOSSY_COBBLESTONE_BARRED_WINDOW_FACADE);
			ingredientMap.put(BarredWindows.BRICKS_BARRED_WINDOW.get(), BarredWindows.BRICKS_BARRED_WINDOW_FACADE);
			ingredientMap.put(BarredWindows.STONE_BRICKS_BARRED_WINDOW.get(), BarredWindows.STONE_BRICKS_BARRED_WINDOW_FACADE);
			ingredientMap.put(BarredWindows.MOSSY_STONE_BRICKS_BARRED_WINDOW.get(), BarredWindows.MOSSY_STONE_BRICKS_BARRED_WINDOW_FACADE);
			ingredientMap.put(BarredWindows.CRACKED_STONE_BRICKS_BARRED_WINDOW.get(), BarredWindows.CRACKED_STONE_BRICKS_BARRED_WINDOW_FACADE);
			ingredientMap.put(BarredWindows.CHISELED_STONE_BRICKS_BARRED_WINDOW.get(), BarredWindows.CHISELED_STONE_BRICKS_BARRED_WINDOW_FACADE);
			ingredientMap.put(BarredWindows.OBSIDIAN_BARRED_WINDOW.get(), BarredWindows.OBSIDIAN_BARRED_WINDOW_FACADE);

			ingredientMap.put(BarredWindows.SANDSTONE_BARRED_WINDOW.get(), BarredWindows.SANDSTONE_BARRED_WINDOW_FACADE);
			ingredientMap.put(BarredWindows.SMOOTH_SANDSTONE_BARRED_WINDOW.get(), BarredWindows.SMOOTH_SANDSTONE_BARRED_WINDOW_FACADE);
			ingredientMap.put(BarredWindows.CHISELED_SANDSTONE_BARRED_WINDOW.get(), BarredWindows.CHISELED_SANDSTONE_BARRED_WINDOW_FACADE);
			ingredientMap.put(BarredWindows.CUT_SANDSTONE_BARRED_WINDOW.get(), BarredWindows.CUT_SANDSTONE_BARRED_WINDOW_FACADE);
			ingredientMap.put(BarredWindows.RED_SANDSTONE_BARRED_WINDOW.get(), BarredWindows.RED_SANDSTONE_BARRED_WINDOW_FACADE);
			ingredientMap.put(BarredWindows.SMOOTH_RED_SANDSTONE_BARRED_WINDOW.get(), BarredWindows.SMOOTH_RED_SANDSTONE_BARRED_WINDOW_FACADE);
			ingredientMap.put(BarredWindows.CHISELED_RED_SANDSTONE_BARRED_WINDOW.get(), BarredWindows.CHISELED_RED_SANDSTONE_BARRED_WINDOW_FACADE);
			ingredientMap.put(BarredWindows.CUT_RED_SANDSTONE_BARRED_WINDOW.get(), BarredWindows.CUT_RED_SANDSTONE_BARRED_WINDOW_FACADE);

			ingredientMap.put(BarredWindows.GRANITE_BARRED_WINDOW.get(), BarredWindows.GRANITE_BARRED_WINDOW_FACADE);
			ingredientMap.put(BarredWindows.ANDESITE_BARRED_WINDOW.get(), BarredWindows.ANDESITE_BARRED_WINDOW_FACADE);
			ingredientMap.put(BarredWindows.DIORITE_BARRED_WINDOW.get(), BarredWindows.DIORITE_BARRED_WINDOW_FACADE);
			ingredientMap.put(BarredWindows.POLISHED_GRANITE_BARRED_WINDOW.get(), BarredWindows.POLISHED_GRANITE_BARRED_WINDOW_FACADE);
			ingredientMap.put(BarredWindows.POLISHED_ANDESITE_BARRED_WINDOW.get(), BarredWindows.POLISHED_ANDESITE_BARRED_WINDOW_FACADE);
			ingredientMap.put(BarredWindows.POLISHED_DIORITE_BARRED_WINDOW.get(), BarredWindows.POLISHED_DIORITE_BARRED_WINDOW_FACADE);

			ingredientMap.put(BarredWindows.BLACKSTONE_BARRED_WINDOW.get(), BarredWindows.BLACKSTONE_BARRED_WINDOW_FACADE);
			ingredientMap.put(BarredWindows.POLISHED_BLACKSTONE_BARRED_WINDOW.get(), BarredWindows.POLISHED_BLACKSTONE_BARRED_WINDOW_FACADE);
			ingredientMap.put(BarredWindows.POLISHED_BLACKSTONE_BRICKS_BARRED_WINDOW.get(), BarredWindows.POLISHED_BLACKSTONE_BRICKS_BARRED_WINDOW_FACADE);

			ingredientMap.put(BarredWindows.DEEPSLATE_BARRED_WINDOW.get(), BarredWindows.DEEPSLATE_BARRED_WINDOW_FACADE);
			ingredientMap.put(BarredWindows.DEEPSLATE_BRICKS_BARRED_WINDOW.get(), BarredWindows.DEEPSLATE_BRICKS_BARRED_WINDOW_FACADE);
			ingredientMap.put(BarredWindows.COBBLED_DEEPSLATE_BARRED_WINDOW.get(), BarredWindows.COBBLED_DEEPSLATE_BARRED_WINDOW_FACADE);
			ingredientMap.put(BarredWindows.POLISHED_DEEPSLATE_BARRED_WINDOW.get(), BarredWindows.POLISHED_DEEPSLATE_BARRED_WINDOW_FACADE);
			ingredientMap.put(BarredWindows.DEEPSLATE_TILES_BARRED_WINDOW.get(), BarredWindows.DEEPSLATE_TILES_BARRED_WINDOW_FACADE);

			ingredientMap.put(BarredWindows.TERRACOTTA_BARRED_WINDOW.get(), BarredWindows.TERRACOTTA_BARRED_WINDOW_FACADE);

			ingredientMap.forEach((k,v) -> {
				ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, v.get(), 2)
						.requires(k)
						.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(v.get()))
						.save(recipe);
			});

			ingredientMap.clear();
			// that's the recipe for a button
//			ingredientMap.put(Blocks.ACACIA_PLANKS, CorbelBlocks.ACACIA_CORBEL);
//			ingredientMap.put(Blocks.BIRCH_PLANKS, CorbelBlocks.BIRCH_CORBEL);
//			ingredientMap.forEach((k,v) -> {
//				ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, v.get(), 2)
//						.requires(k)
//						.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(v.get()))
//						.save(recipe);
//			});

			// TODO add wood corbels to the stonecutting?
			/*
			 * stone cutting
			 */
//			DataGenMaps.m.forEach((k, v) -> {
//				v.forEach(b -> {
//					SingleItemRecipeBuilder.stonecutting(Ingredient.of(k), RecipeCategory.BUILDING_BLOCKS, b.get())
//							.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(k))
//							.save(recipe);
//				});
//			});

			DataGenMaps maps = new DataGenMaps();

			Registration.BLOCKS.getEntries().stream()
					.filter(b -> {
						for(String n : maps.names) {
							if (b.getId().getPath().contains(n)) {
								return true;
							}
						}
						return false;
					})
					.forEach(b -> {
						String name = b.getId().getPath();
						String material = null;
						if (name.contains("corbel")) {
							material = b.getId().getPath().split("_corbel_block")[0];
							DungeonBlocks.LOGGER.info("corbel recipe material ->{} to texture ->{} ", material, maps.m2.get(material));
						} else if (name.contains("ledge")) {
							material = b.getId().getPath().split("_ledge_block")[0];
                        DungeonBlocks.LOGGER.info("ledge recipe material ->{} to texture ->{} ", material, maps.m2.get(material));
						}
//						else if (name.contains("keystone_block")) {
//							material = b.getId().getPath().split("_keystone_block")[0];
//						} else if (name.contains("keystone_slab")) {
//							material = b.getId().getPath().split("_keystone_slab_block")[0];
//						}
						// else do all the other types

						if (material != null) {
							SingleItemRecipeBuilder.stonecutting(Ingredient.of(maps.m2.get(material)), RecipeCategory.BUILDING_BLOCKS, b.get())
									.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(maps.m2.get(material)))
									.save(recipe);
						}

					});

		}

		/**
		 * One item places the whole two-block table, so the recipe yields a single output for what
		 * reads as a trestle: a run of slabs over two uprights.
		 */
		private static void slabTable(Consumer<FinishedRecipe> recipe, RegistryObject<Block> table, Block slab, Block base) {
			ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, table.get())
					.pattern("xxx")
					.pattern("y y")
					.define('x', slab)
					.define('y', base)
					.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(base))
					.save(recipe);
		}

		/** A lid of slabs over a chest of the carved block. */
		private static void sarcophagus(Consumer<FinishedRecipe> recipe, RegistryObject<Block> sarcophagus, Block slab, Block carved) {
			ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, sarcophagus.get())
					.pattern("sss")
					.pattern("ccc")
					.define('s', slab)
					.define('c', carved)
					.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(carved))
					.save(recipe);
		}

		/** Wool on a rod of sticks with the scene's dye; the worn one is the pristine one and coarse dirt. */
		private static void tapestry(Consumer<FinishedRecipe> recipe, RegistryObject<Block> pristine,
				RegistryObject<Block> worn, Item dye) {
			ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, pristine.get())
					.pattern("sss")
					.pattern("wdw")
					.pattern("www")
					.define('s', Items.STICK)
					.define('w', ItemTags.WOOL)
					.define('d', dye)
					.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(dye))
					.save(recipe);
			ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, worn.get())
					.requires(pristine.get())
					.requires(Blocks.COARSE_DIRT)
					.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(pristine.get()))
					.save(recipe);
		}

		/** A lid of the wood's slabs over its planks, with a bone laid in. */
		private static void coffin(Consumer<FinishedRecipe> recipe, RegistryObject<Block> coffin, Block slab, Block planks) {
			ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, coffin.get())
					.pattern("sss")
					.pattern("pbp")
					.define('s', slab)
					.define('p', planks)
					.define('b', Items.BONE)
					.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(planks))
					.save(recipe);
		}

		/**
		 * Shapeless: the stripped block plus flint to sharpen it. The flint is what keeps this clear
		 * of vanilla's one-log-to-planks recipe, which a lone stripped log would collide with.
		 */
		private static void sharpened(Consumer<FinishedRecipe> recipe, RegistryObject<Block> sharpened, Block stripped) {
			ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, sharpened.get())
					.requires(stripped)
					.requires(Items.FLINT)
					.unlockedBy(CRITERIA, InventoryChangeTrigger.TriggerInstance.hasItems(stripped))
					.save(recipe);
		}
}

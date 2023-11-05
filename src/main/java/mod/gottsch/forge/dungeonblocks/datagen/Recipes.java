
package mod.gottsch.forge.dungeonblocks.datagen;

import mod.gottsch.forge.dungeonblocks.DungeonBlocks;
import mod.gottsch.forge.dungeonblocks.core.block.DungeonLanternBlock;
import mod.gottsch.forge.dungeonblocks.core.block.ModBlocks;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.ShapelessRecipe;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Consumer;

/**
 * 
 * @author Mark Gottschling on Oct 26, 2024
 *
 */
public class Recipes extends RecipeProvider {

		public Recipes(PackOutput output) {
			super(output);
		}

		@Override
		protected void buildRecipes(Consumer<FinishedRecipe> recipe) {

			ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.DUNGEON_LANTERN.get())
					.requires(Blocks.LANTERN)
					.requires(Items.IRON_INGOT)
					.unlockedBy("criteria", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.LANTERN))
					.save(recipe);

			ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModBlocks.TORCH_SCONCE.get())
					.requires(Blocks.TORCH)
					.requires(Items.IRON_INGOT)
					.unlockedBy("criteria", InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT))
					.save(recipe);

			ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CANDLE_SCONCE.get())
					.pattern(" c ")
					.pattern("x x")
					.pattern("xxx")
					.define('x', Items.IRON_INGOT)
					.define('c', Items.CANDLE)
					.unlockedBy("criteria", InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT))
					.save(recipe);

			ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_IRON_GRATE.get())
					.pattern("xnx")
					.pattern("nnn")
					.pattern("xnx")
					.define('x', Items.IRON_INGOT)
					.define('n', Items.IRON_NUGGET)
					.unlockedBy("criteria", InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT))
					.save(recipe);

			ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WEATHERED_COPPER_GRATE.get())
					.pattern("x x")
					.pattern(" x ")
					.pattern("x x")
					.define('x', Items.COPPER_INGOT)
					.unlockedBy("criteria", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COPPER_INGOT))
					.save(recipe);

			SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.STONE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.STONE_GREEK_BLOCK.get())
					.unlockedBy("criteria", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.STONE))
					.save(recipe);
			SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.ANDESITE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.ANDESITE_GREEK_BLOCK.get())
					.unlockedBy("criteria", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.STONE))
					.save(recipe);
			SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.POLISHED_BASALT), RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_BASALT_GREEK_BLOCK.get())
					.unlockedBy("criteria", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.STONE))
					.save(recipe);

			SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.STONE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.STONE_BARRED_WINDOW.get())
					.unlockedBy("criteria", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.STONE))
					.save(recipe);
			SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.SMOOTH_STONE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_STONE_BARRED_WINDOW.get())
					.unlockedBy("criteria", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.SMOOTH_STONE))
					.save(recipe);
			SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.COBBLESTONE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.COBBLESTONE_BARRED_WINDOW.get())
					.unlockedBy("criteria", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.COBBLESTONE))
					.save(recipe);
			SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.MOSSY_COBBLESTONE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_COBBLESTONE_BARRED_WINDOW.get())
					.unlockedBy("criteria", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.MOSSY_COBBLESTONE))
					.save(recipe);
			SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.BRICKS), RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICKS_BARRED_WINDOW.get())
					.unlockedBy("criteria", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.BRICKS))
					.save(recipe);

		}

}

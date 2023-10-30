
package mod.gottsch.forge.dungeonblocks.datagen;

import mod.gottsch.forge.dungeonblocks.DungeonBlocks;
import mod.gottsch.forge.dungeonblocks.core.block.ModBlocks;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
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

			// TODO add dark iron and copper grates
			ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModBlocks.DARK_IRON_GRATE.get())
					.pattern("xnx")
					.pattern("nnn")
					.pattern("xnx")
					.define('x', Items.IRON_INGOT)
					.define('n', Items.IRON_NUGGET)
					.unlockedBy("criteria", InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT))
					.save(recipe);

			ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModBlocks.WEATHERED_COPPER_GRATE.get())
					.pattern("x x")
					.pattern(" x ")
					.pattern("x x")
					.define('x', Items.COPPER_INGOT)
					.unlockedBy("criteria", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COPPER_INGOT))
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

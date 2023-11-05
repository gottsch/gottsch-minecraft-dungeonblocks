package mod.gottsch.forge.dungeonblocks.datagen;

import mod.gottsch.forge.dungeonblocks.DungeonBlocks;
import mod.gottsch.forge.dungeonblocks.core.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

/**
 * 
 * @author Mark Gottschling on Oct 26, 2023
 *
 */
public class ItemModelsProvider extends ItemModelProvider {

	public ItemModelsProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
		super(output, DungeonBlocks.MOD_ID, existingFileHelper);
	}

	@Override
	protected void registerModels() {
		/*
		 * block items
		 */
		ModBlocks.MAP.forEach((k, v) -> {
			if (k.getId().getPath().contains("barred_window") ||
					k.getId().getPath().contains("greek_block")) {
				blockItemParent(v);
			}
		});
		blockItemParent(ModBlocks.MAP.get(ModBlocks.TORCH_SCONCE));
		blockItemParent(ModBlocks.MAP.get(ModBlocks.CANDLE_SCONCE));
		blockItemParent(ModBlocks.MAP.get(ModBlocks.BRAZIER));
		blockItemParent(ModBlocks.MAP.get(ModBlocks.DARK_IRON_GRATE));
		blockItemParent(ModBlocks.MAP.get(ModBlocks.WEATHERED_COPPER_GRATE));
		blockItemParent(ModBlocks.MAP.get(ModBlocks.WALL_RING));
		blockItemParent(ModBlocks.MAP.get(ModBlocks.LARGE_WALL_RING));
		blockItemParent(ModBlocks.MAP.get(ModBlocks.WEATHERED_COPPER_SEWER));
		blockItemParent(ModBlocks.MAP.get(ModBlocks.TERRACOTTA_SEWER));
		blockItemParent(ModBlocks.MAP.get(ModBlocks.HAY_PATCH));
		blockItemParent(ModBlocks.MAP.get(ModBlocks.DUNGEON_LANTERN));

		basicItem(ModBlocks.MAP.get(ModBlocks.CRIMSON_DUNGEON_DOOR), mcLoc("item/crimson_door"));
		basicItem(ModBlocks.MAP.get(ModBlocks.DARK_OAK_DUNGEON_DOOR), mcLoc("item/dark_oak_door"));
		basicItem(ModBlocks.MAP.get(ModBlocks.MANGROVE_DUNGEON_DOOR), mcLoc("item/mangrove_door"));
		basicItem(ModBlocks.MAP.get(ModBlocks.SPRUCE_DUNGEON_DOOR), mcLoc("item/spruce_door"));

	}

	public ItemModelBuilder basicItem(RegistryObject<Item> item, ResourceLocation texture) {
		return getBuilder(item.getId().toString())
				.parent(new ModelFile.UncheckedModelFile("item/generated"))
				.texture("layer0", texture);
	}

	public ItemModelBuilder blockItemParent(RegistryObject<Item> item) {
		return withExistingParent(item.getId().getPath(), modLoc("block/" + item.getId().getPath()));
	}

	public ItemModelBuilder withExistingParent(RegistryObject<Item> item, ResourceLocation texture) {
		return withExistingParent(item.getId().getPath(), texture);
	}
}

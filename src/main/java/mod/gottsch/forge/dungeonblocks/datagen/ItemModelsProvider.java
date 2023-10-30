package mod.gottsch.forge.dungeonblocks.datagen;

import mod.gottsch.forge.dungeonblocks.DungeonBlocks;
import mod.gottsch.forge.dungeonblocks.core.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
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
			if (k.getId().getPath().contains("barred_window")) {
				blockItemParent(v);
			}
		});
		blockItemParent(ModBlocks.MAP.get(ModBlocks.TORCH_SCONCE));
		blockItemParent(ModBlocks.MAP.get(ModBlocks.DARK_IRON_GRATE));
		blockItemParent(ModBlocks.MAP.get(ModBlocks.WEATHERED_COPPER_GRATE));
		blockItemParent(ModBlocks.MAP.get(ModBlocks.WALL_RING));
		blockItemParent(ModBlocks.MAP.get(ModBlocks.LARGE_WALL_RING));
		blockItemParent(ModBlocks.MAP.get(ModBlocks.WEATHERED_COPPER_SEWER));
		blockItemParent(ModBlocks.MAP.get(ModBlocks.TERRACOTTA_SEWER));
		blockItemParent(ModBlocks.MAP.get(ModBlocks.STRAW));
	}

	public ItemModelBuilder blockItemParent(RegistryObject<Item> item) {
		return withExistingParent(item.getId().getPath(), modLoc("block/" + item.getId().getPath()));
	}

	public ItemModelBuilder withExistingParent(RegistryObject<Item> item, ResourceLocation texture) {
		return withExistingParent(item.getId().getPath(), texture);
	}
}

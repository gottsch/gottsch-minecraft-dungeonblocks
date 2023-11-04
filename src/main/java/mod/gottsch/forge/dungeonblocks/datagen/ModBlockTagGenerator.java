package mod.gottsch.forge.dungeonblocks.datagen;

import mod.gottsch.forge.dungeonblocks.DungeonBlocks;
import mod.gottsch.forge.dungeonblocks.core.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, DungeonBlocks.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
//        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
//                .add(ModBlocks.SAPPHIRE_ORE.get()).addTag(Tags.Blocks.ORES);

        // TODO only include blocks that require a specific tool
//        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
//                .add(
////                    ModBlocks.TORCH_SCONCE.get()
//
//                );

//        this.tag(BlockTags.NEEDS_IRON_TOOL)
//                .add(ModBlocks.SAPPHIRE_BLOCK.get());
//
//        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
//                .add(ModBlocks.RAW_SAPPHIRE_BLOCK.get());
//
//        this.tag(BlockTags.NEEDS_STONE_TOOL)
//                .add(ModBlocks.NETHER_SAPPHIRE_ORE.get());
//
//        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
//                .add(ModBlocks.END_STONE_SAPPHIRE_ORE.get());


    }
}
package mod.gottsch.forge.dungeonblocks.datagen;

import mod.gottsch.forge.dungeonblocks.DungeonBlocks;
import mod.gottsch.forge.dungeonblocks.core.block.CorbelBlocks;
import mod.gottsch.forge.dungeonblocks.core.block.LedgeBlocks;
import mod.gottsch.forge.dungeonblocks.core.block.ModBlocks;
import mod.gottsch.forge.dungeonblocks.core.setup.Registration;
import mod.gottsch.forge.dungeonblocks.core.tag.ModTags;
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
        // corbels
        tag(ModTags.Blocks.CORBELS).add(CorbelBlocks.ACACIA_CORBEL.get());
        tag(ModTags.Blocks.CORBELS).add(CorbelBlocks.ANDESITE_CORBEL.get());
        tag(ModTags.Blocks.CORBELS).add(CorbelBlocks.COBBLESTONE_CORBEL.get());
        tag(ModTags.Blocks.CORBELS).add(CorbelBlocks.BIRCH_CORBEL.get());
        tag(ModTags.Blocks.CORBELS).add(CorbelBlocks.BLACKSTONE_CORBEL.get());
        tag(ModTags.Blocks.CORBELS).add(CorbelBlocks.CHERRY_CORBEL.get());
        tag(ModTags.Blocks.CORBELS).add(CorbelBlocks.COBBLED_DEEPSLATE_CORBEL.get());
        tag(ModTags.Blocks.CORBELS).add(CorbelBlocks.DARK_OAK_CORBEL.get());
        tag(ModTags.Blocks.CORBELS).add(CorbelBlocks.DEEPSLATE_CORBEL.get());
        tag(ModTags.Blocks.CORBELS).add(CorbelBlocks.DEEPSLATE_BRICKS_CORBEL.get());
        tag(ModTags.Blocks.CORBELS).add(CorbelBlocks.DEEPSLATE_TILES_CORBEL.get());
        tag(ModTags.Blocks.CORBELS).add(CorbelBlocks.DIORITE_CORBEL.get());
        tag(ModTags.Blocks.CORBELS).add(CorbelBlocks.GRANITE_CORBEL.get());
        tag(ModTags.Blocks.CORBELS).add(CorbelBlocks.JUNGLE_CORBEL.get());
        tag(ModTags.Blocks.CORBELS).add(CorbelBlocks.MANGROVE_CORBEL.get());
        tag(ModTags.Blocks.CORBELS).add(CorbelBlocks.MOSSY_COBBLESTONE_CORBEL.get());
        tag(ModTags.Blocks.CORBELS).add(CorbelBlocks.MOSSY_STONE_BRICKS_CORBEL.get());
        tag(ModTags.Blocks.CORBELS).add(CorbelBlocks.OAK_CORBEL.get());
        tag(ModTags.Blocks.CORBELS).add(CorbelBlocks.POLISHED_ANDESITE_CORBEL.get());
        tag(ModTags.Blocks.CORBELS).add(CorbelBlocks.POLISHED_BLACKSTONE_CORBEL.get());
        tag(ModTags.Blocks.CORBELS).add(CorbelBlocks.POLISHED_BLACKSTONE_BRICKS_CORBEL.get());
        tag(ModTags.Blocks.CORBELS).add(CorbelBlocks.POLISHED_DEEPSLATE_CORBEL.get());
        tag(ModTags.Blocks.CORBELS).add(CorbelBlocks.POLISHED_DIORITE_CORBEL.get());
        tag(ModTags.Blocks.CORBELS).add(CorbelBlocks.POLISHED_GRANITE_CORBEL.get());
        tag(ModTags.Blocks.CORBELS).add(CorbelBlocks.SMOOTH_STONE_CORBEL.get());
        tag(ModTags.Blocks.CORBELS).add(CorbelBlocks.SPRUCE_CORBEL.get());
        tag(ModTags.Blocks.CORBELS).add(CorbelBlocks.STONE_CORBEL.get());
        tag(ModTags.Blocks.CORBELS).add(CorbelBlocks.STONE_BRICKS_CORBEL.get());
        tag(ModTags.Blocks.CORBELS).add(CorbelBlocks.STRIPPED_ACACIA_CORBEL.get());
        tag(ModTags.Blocks.CORBELS).add(CorbelBlocks.STRIPPED_BIRCH_CORBEL.get());
        tag(ModTags.Blocks.CORBELS).add(CorbelBlocks.STRIPPED_CHERRY_CORBEL.get());
        tag(ModTags.Blocks.CORBELS).add(CorbelBlocks.STRIPPED_DARK_OAK_CORBEL.get());
        tag(ModTags.Blocks.CORBELS).add(CorbelBlocks.STRIPPED_JUNGLE_CORBEL.get());
        tag(ModTags.Blocks.CORBELS).add(CorbelBlocks.STRIPPED_MANGROVE_CORBEL.get());
        tag(ModTags.Blocks.CORBELS).add(CorbelBlocks.STRIPPED_OAK_CORBEL.get());
        tag(ModTags.Blocks.CORBELS).add(CorbelBlocks.STRIPPED_SPRUCE_CORBEL.get());

        // ledges
        tag(ModTags.Blocks.LEDGES).add(LedgeBlocks.ANDESITE_LEDGE.get());
        tag(ModTags.Blocks.LEDGES).add(LedgeBlocks.BLACKSTONE_LEDGE.get());
        tag(ModTags.Blocks.LEDGES).add(LedgeBlocks.BRICKS_LEDGE.get());
        tag(ModTags.Blocks.LEDGES).add(LedgeBlocks.COBBLESTONE_LEDGE.get());
        tag(ModTags.Blocks.LEDGES).add(LedgeBlocks.COBBLED_DEEPSLATE_LEDGE.get());
        tag(ModTags.Blocks.LEDGES).add(LedgeBlocks.DEEPSLATE_BRICKS_LEDGE.get());
        tag(ModTags.Blocks.LEDGES).add(LedgeBlocks.DEEPSLATE_LEDGE.get());
        tag(ModTags.Blocks.LEDGES).add(LedgeBlocks.DIORITE_LEDGE.get());
        tag(ModTags.Blocks.LEDGES).add(LedgeBlocks.GRANITE_LEDGE.get());
        tag(ModTags.Blocks.LEDGES).add(LedgeBlocks.LIGHT_GRAY_CONCRETE_LEDGE.get());
        tag(ModTags.Blocks.LEDGES).add(LedgeBlocks.MOSSY_COBBLESTONE_LEDGE.get());
        tag(ModTags.Blocks.LEDGES).add(LedgeBlocks.MOSSY_STONE_BRICKS_LEDGE.get());
        tag(ModTags.Blocks.LEDGES).add(LedgeBlocks.POLISHED_ANDESITE_LEDGE.get());
        tag(ModTags.Blocks.LEDGES).add(LedgeBlocks.POLISHED_BLACKSTONE_LEDGE.get());
        tag(ModTags.Blocks.LEDGES).add(LedgeBlocks.POLISHED_BLACKSTONE_BRICKS_LEDGE.get());
        tag(ModTags.Blocks.LEDGES).add(LedgeBlocks.POLISHED_DEEPSLATE_LEDGE.get());
        tag(ModTags.Blocks.LEDGES).add(LedgeBlocks.POLISHED_DIORITE_LEDGE.get());
        tag(ModTags.Blocks.LEDGES).add(LedgeBlocks.POLISHED_GRANITE_LEDGE.get());
        tag(ModTags.Blocks.LEDGES).add(LedgeBlocks.SMOOTH_STONE_LEDGE.get());
        tag(ModTags.Blocks.LEDGES).add(LedgeBlocks.STONE_BRICKS_LEDGE.get());
        tag(ModTags.Blocks.LEDGES).add(LedgeBlocks.STONE_LEDGE.get());
        DataGenMaps maps = new DataGenMaps();

        Registration.BLOCKS.getEntries().stream()
                .filter(b -> {
                    for(String n : maps.stone_blocks) {
                        if (b.getId().getPath().contains(n)) {
                            return true;
                        }
                    }
                    return false;
                })
                .forEach(b -> {
                    String name = b.getId().getPath();

                    if (maps.wood_names.contains(name)) {
//                        this.tag(BlockTags.MINEABLE_WITH_AXE)
//                                .add(b.get());
//                        this.tag(BlockTags.NEEDS_IRON_TOOL)
//                                .add(b.get());
                    } else {
                        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(b.get());
                        if (name.contains("obsidian")) {
                            this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(b.get());
                        } else {
                            this.tag(BlockTags.NEEDS_STONE_TOOL).add(b.get());
                        }
                    }
                });

        // The skeleton matches nothing in stone_blocks, so the loop above skips it - but it still
        // inherits requiresCorrectToolForDrops from Properties.copy(STONE), and a block that
        // requires the correct tool while belonging to no tool tag can never be mined for drops by
        // anything. Tagged explicitly rather than by adding "skeleton" to stone_blocks, which would
        // also pull it into the stone family's model and recipe generation.
        // No tier tag: vanilla bone block is mineable with any pickaxe.
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModBlocks.SKELETON.get());

        // same reason as the skeleton above: "rubble" matches nothing in stone_blocks, so
        // the loop skips it, but it copies requiresCorrectToolForDrops from cobblestone.
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModBlocks.RUBBLE.get(), ModBlocks.MOSSY_RUBBLE.get());
        this.tag(BlockTags.NEEDS_STONE_TOOL).add(ModBlocks.RUBBLE.get(), ModBlocks.MOSSY_RUBBLE.get());
    }
}
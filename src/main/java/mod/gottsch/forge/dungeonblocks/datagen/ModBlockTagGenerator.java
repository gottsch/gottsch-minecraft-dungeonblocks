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

        // Angle cobwebs are decorative webbing, so a sword should cut them the way it cuts a vanilla
        // cobweb. Vanilla gets there by hardcoding Blocks.COBWEB in SwordItem, which a modded block
        // cannot reach; SWORD_EFFICIENT is the tag equivalent and gives swords 1.5F. Combined with
        // the 0.4 hardness set in ModBlocks that lands on 8 ticks, the same as vanilla cobweb.
        // Note vanilla COBWEB itself is NOT in this tag - it does not need to be, given the hardcoding.
        this.tag(BlockTags.SWORD_EFFICIENT).add(ModBlocks.ANGLE_COBWEB_1.get(), ModBlocks.ANGLE_COBWEB_2.get());

        // mineable/needs-tool come from the stone_blocks sweep ("square"); the slab tag does not
        this.tag(BlockTags.SLABS).add(ModBlocks.SQUARE_STONE_BRICK_SLAB.get(), ModBlocks.MOSSY_SQUARE_STONE_BRICK_SLAB.get(),
                ModBlocks.SQUARE_DEEPSLATE_BRICK_SLAB.get(), ModBlocks.MOSSY_SQUARE_DEEPSLATE_BRICK_SLAB.get());

        // same reason as the skeleton above: "rubble" matches nothing in stone_blocks, so
        // the loop skips it, but it copies requiresCorrectToolForDrops from cobblestone.
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModBlocks.RUBBLE.get(), ModBlocks.MOSSY_RUBBLE.get());
        this.tag(BlockTags.NEEDS_STONE_TOOL).add(ModBlocks.RUBBLE.get(), ModBlocks.MOSSY_RUBBLE.get());

        // Same reason again: of the three mossy deepslate full blocks, only "mossy_deepslate_bricks"
        // matches stone_blocks (on "brick"). "tiles" and "cobbled" match nothing there, and both
        // copy requiresCorrectToolForDrops from their base stone. Their eleven decorative types are
        // fine - those match on "facade", "pillar", "sill" and so on.
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.MOSSY_DEEPSLATE_TILES.get(), ModBlocks.MOSSY_COBBLED_DEEPSLATE.get());
        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.MOSSY_DEEPSLATE_TILES.get(), ModBlocks.MOSSY_COBBLED_DEEPSLATE.get());

        // "mossy_tuff" matches nothing in stone_blocks either, and copies requiresCorrectToolForDrops
        // from vanilla tuff. Stone tier to match this mod's tuff decorative blocks, which the sweep
        // already puts there. It has no decorative types of its own to be caught by the sweep.
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModBlocks.MOSSY_TUFF.get());
        this.tag(BlockTags.NEEDS_STONE_TOOL).add(ModBlocks.MOSSY_TUFF.get());

        // Every copper block belonged to no tool tag. Most of them - grates, heavy grates, valve
        // wheels, trapdoors, heavy trapdoors, plate brackets - copy requiresCorrectToolForDrops from
        // COPPER_GRATE, so they could never be mined for a drop. Swept by id rather than listed, so a
        // new copper block is covered automatically; the tier tag follows the block's own property
        // rather than being assumed, so the doors and sewer block (which drop to anything) only
        // gain pickaxe speed. Stone tier matches vanilla copper.
        Registration.BLOCKS.getEntries().stream()
                .filter(b -> b.getId().getPath().contains("copper"))
                .forEach(b -> {
                    this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(b.get());
                    if (b.get().defaultBlockState().requiresCorrectToolForDrops()) {
                        this.tag(BlockTags.NEEDS_STONE_TOOL).add(b.get());
                    }
                });

        // "basalt" matches nothing in stone_blocks, and the block copies requiresCorrectToolForDrops
        // from vanilla polished basalt. Stone tier to match this mod's own polished_basalt_greek_block,
        // which the sweep already puts there - note vanilla polished basalt itself drops to any pickaxe.
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModBlocks.MOSSY_POLISHED_BASALT.get());
        this.tag(BlockTags.NEEDS_STONE_TOOL).add(ModBlocks.MOSSY_POLISHED_BASALT.get());

        // The iron bars door matches nothing in stone_blocks ("barred_window" is not "bars") and
        // copies requiresCorrectToolForDrops from the iron door. Pickaxe with no tier tag, exactly
        // as vanilla tags the iron door. DOORS as vanilla does too - not WOODEN_DOORS, which is
        // what villagers path through.
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModBlocks.IRON_BARS_DOOR.get());
        this.tag(BlockTags.DOORS).add(ModBlocks.IRON_BARS_DOOR.get());

        // Sharpened logs are wood: axe, no tier, like vanilla logs. Their ids match nothing in
        // stone_blocks, and must stay out of that sweep, which would tag them for a pickaxe.
        ModBlocks.SHARPENED_LOGS.forEach(b -> this.tag(BlockTags.MINEABLE_WITH_AXE).add(b.get()));

        // Dark iron grates and heavy trapdoors, plain and rusted, belonged to no tool tag, so a
        // pickaxe mined them no faster than a bare hand. Pickaxe only, no tier tag: they do not
        // require the correct tool for drops and never have, so they still drop to anything.
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                ModBlocks.DARK_IRON_GRATE.get(), ModBlocks.TARNISHED_DARK_IRON_GRATE.get(),
                ModBlocks.RUSTED_DARK_IRON_GRATE.get(), ModBlocks.CORRODED_DARK_IRON_GRATE.get(),
                ModBlocks.DARK_IRON_HEAVY_TRAPDOOR.get(), ModBlocks.TARNISHED_DARK_IRON_HEAVY_TRAPDOOR.get(),
                ModBlocks.RUSTED_DARK_IRON_HEAVY_TRAPDOOR.get(), ModBlocks.CORRODED_DARK_IRON_HEAVY_TRAPDOOR.get());
    }
}
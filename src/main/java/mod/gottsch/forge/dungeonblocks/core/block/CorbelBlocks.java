package mod.gottsch.forge.dungeonblocks.core.block;

import mod.gottsch.forge.dungeonblocks.core.setup.Registration;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;

public class CorbelBlocks {

    public static RegistryObject<Block> ACACIA_CORBEL = Registration.BLOCKS.register("acacia_corbel_block",
            () -> new CorbelBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));
    public static RegistryObject<Block> BIRCH_CORBEL = Registration.BLOCKS.register("birch_corbel_block",
            () -> new CorbelBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)));
      public static RegistryObject<Block> CHERRY_CORBEL = Registration.BLOCKS.register("cherry_corbel_block",
            () -> new CorbelBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS)));
      public static RegistryObject<Block> DARK_OAK_CORBEL = Registration.BLOCKS.register("dark_oak_corbel_block",
            () -> new CorbelBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static RegistryObject<Block> JUNGLE_CORBEL = Registration.BLOCKS.register("jungle_corbel_block",
            () -> new CorbelBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)));
    public static RegistryObject<Block> MANGROVE_CORBEL = Registration.BLOCKS.register("mangrove_corbel_block",
            () -> new CorbelBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS)));
    public static RegistryObject<Block> OAK_CORBEL = Registration.BLOCKS.register("oak_corbel_block",
            () -> new CorbelBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static RegistryObject<Block> SPRUCE_CORBEL = Registration.BLOCKS.register("spruce_corbel_block",
            () -> new CorbelBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)));

    // stripped variants
    public static RegistryObject<Block> STRIPPED_ACACIA_CORBEL = Registration.BLOCKS.register("stripped_acacia_corbel_block",
            () -> new CorbelBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_ACACIA_WOOD)));
    public static RegistryObject<Block> STRIPPED_BIRCH_CORBEL = Registration.BLOCKS.register("stripped_birch_corbel_block",
            () -> new CorbelBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_BIRCH_WOOD)));
    public static RegistryObject<Block> STRIPPED_CHERRY_CORBEL = Registration.BLOCKS.register("stripped_cherry_corbel_block",
            () -> new CorbelBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_CHERRY_WOOD)));
    public static RegistryObject<Block> STRIPPED_DARK_OAK_CORBEL = Registration.BLOCKS.register("stripped_dark_oak_corbel_block",
            () -> new CorbelBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_DARK_OAK_WOOD)));
    public static RegistryObject<Block> STRIPPED_JUNGLE_CORBEL = Registration.BLOCKS.register("stripped_jungle_corbel_block",
            () -> new CorbelBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_JUNGLE_WOOD)));
    public static RegistryObject<Block> STRIPPED_MANGROVE_CORBEL = Registration.BLOCKS.register("stripped_mangrove_corbel_block",
            () -> new CorbelBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_WOOD)));
    public static RegistryObject<Block> STRIPPED_OAK_CORBEL = Registration.BLOCKS.register("stripped_oak_corbel_block",
            () -> new CorbelBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static RegistryObject<Block> STRIPPED_SPRUCE_CORBEL = Registration.BLOCKS.register("stripped_spruce_corbel_block",
            () -> new CorbelBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_SPRUCE_WOOD)));

    public static void register() {
        // this method exists simply to ensure that the static objects are registered before
        // the DeferredRegistry is called.
    }
}

package mod.gottsch.forge.dungeonblocks.core.block;

import mod.gottsch.forge.dungeonblocks.core.setup.Registration;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;

/**
 * @author Mark Gottschling on Jan 12, 2020
 */
public class LedgeBlocks {
    public static RegistryObject<Block> STONE_LEDGE = Registration.BLOCKS.register("stone_ledge_block",
            () -> new LedgeBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static RegistryObject<Block> SMOOTH_STONE_LEDGE = Registration.BLOCKS.register("smooth_stone_ledge_block",
            () -> new LedgeBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static RegistryObject<Block> COBBLESTONE_LEDGE = Registration.BLOCKS.register("cobblestone_ledge_block",
            () -> new LedgeBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static RegistryObject<Block> MOSSY_COBBLESTONE_LEDGE = Registration.BLOCKS.register("mossy_cobblestone_ledge_block",
            () -> new LedgeBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static RegistryObject<Block> BRICKS_LEDGE = Registration.BLOCKS.register("bricks_ledge_block",
            () -> new LedgeBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static RegistryObject<Block> STONE_BRICKS_LEDGE = Registration.BLOCKS.register("stone_bricks_ledge_block",
            () -> new LedgeBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static RegistryObject<Block> MOSSY_STONE_BRICKS_LEDGE = Registration.BLOCKS.register("mossy_stone_bricks_ledge_block",
            () -> new LedgeBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static RegistryObject<Block> LIGHT_GRAY_CONCRETE_LEDGE = Registration.BLOCKS.register("light_gray_concrete_ledge_block",
            () -> new LedgeBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));

    public static RegistryObject<Block> POLISHED_DIORITE_LEDGE = Registration.BLOCKS.register("polished_diorite_ledge_block",
            () -> new LedgeBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_DIORITE)));

    public static void register() {}
}

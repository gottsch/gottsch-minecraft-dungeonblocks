package mod.gottsch.forge.dungeonblocks.core.block;

import mod.gottsch.forge.gottschcore.block.FacingBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

/**
 * @author Mark Gottschling on Nov 6, 2023
 *
 */
public class LedgeBlock extends WaterloggedNonCubeFacingBlock {
    private static final VoxelShape NORTH_SHAPE = Block.box(0.0D, 12D, 12.0D, 16D, 16.0D, 16D);
    private static final VoxelShape EAST_SHAPE = Block.box(0D, 12D, 0.0D, 4D, 16.0D, 16D);
    private static final VoxelShape SOUTH_SHAPE = Block.box(0.0D, 12D, 0D, 16D, 16.0D, 4D);
    private static final VoxelShape WEST_SHAPE = Block.box(12D, 12D, 0.0D, 16D, 16.0D, 16D);

    private static final VoxelShape UP_SHAPE = NORTH_SHAPE;
    private static final VoxelShape DOWN_SHAPE = NORTH_SHAPE;

    public LedgeBlock(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        Direction direction = state.getValue(FACING);

        return switch (direction) {
            case UP -> UP_SHAPE;
            case NORTH -> NORTH_SHAPE;
            case SOUTH -> SOUTH_SHAPE;
            case EAST -> EAST_SHAPE;
            case WEST -> WEST_SHAPE;
            default -> DOWN_SHAPE;
        };
    }
}

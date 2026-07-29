package mod.gottsch.forge.dungeonblocks.core.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * @author Mark Gottschling on Nov 6, 2023
 *
 */
public class LedgeBlock extends FacadeShapeBlock {
    /*
     * canonical geometry, all authored for a NORTH-facing block - ie the orientation
     * the models are drawn in at y-rotation 0. The other three facings, and both
     * handednesses of each corner, are turned out of these.
     */
    private static final VoxelShape STRAIGHT_SHAPE = Block.box(0.0D, 12D, 12.0D, 16D, 16.0D, 16D);

    private static final VoxelShape INNER_SHAPE = Shapes.or(
            STRAIGHT_SHAPE,
            Block.box(12D, 12D, 0.0D, 16D, 16.0D, 16D)
    );

    private static final VoxelShape OUTER_SHAPE = Block.box(12, 12, 12, 16, 16, 16);

    private static final VoxelShape[] VOXEL_SHAPES =
            IFacadeShapeBlock.buildShapeTable(STRAIGHT_SHAPE, INNER_SHAPE, OUTER_SHAPE);


    public LedgeBlock(Properties properties) {
        super(properties);
    }

    /**
     * Returns the VoxelShape (ie bounding box) of the block in the correct position.
     */
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        int shapeIndex = getBlockShapeIndex(state, getter, pos, context);
        return VOXEL_SHAPES[shapeIndex];
    }

    /**
     * Checks if a block is same as LedgeBlock
     */
    @Override
    public boolean isBlockInstanceOf(Block block) {
        return block instanceof LedgeBlock;
    }

}

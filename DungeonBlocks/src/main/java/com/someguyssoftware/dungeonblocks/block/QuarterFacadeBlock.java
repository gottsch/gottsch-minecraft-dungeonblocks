/**
 * 
 */
package com.someguyssoftware.dungeonblocks.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

/**
 * @author Mark Gottschling on Jan 15, 2020
 *
 */
public class QuarterFacadeBlock extends FacadeShapeBlock {

	// Voxels are like the bounding boxes (AABBs)
	// Shapes names are based on the FACING direction. ex. NORTH_SHAPE faces north.
	private static final VoxelShape NORTH_FACING_SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 12.0D, 16.0D, 16.0D, 16.0D);
	private static final VoxelShape EAST_FACING_SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 4.0D, 16.0D, 16.0D);
	private static final VoxelShape SOUTH_FACING_SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 4.0D);
	private static final VoxelShape WEST_FACING_SHAPE = Block.makeCuboidShape(12.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);

	// outer corners
	private static final VoxelShape TOP_LEFT_OUTER_SHAPE = Block.makeCuboidShape(12.0D, 0D, 12.0D, 16.0D, 16.0D, 16.0D);
	private static final VoxelShape TOP_RIGHT_OUTER_SHAPE = Block.makeCuboidShape(0D, 0D, 12.0D, 4.0D, 16.0D, 16.0D);

	private static final VoxelShape BOTTOM_LEFT_OUTER_SHAPE = Block.makeCuboidShape(12.0D, 0D, 0D, 16.0D, 16.0D, 4.0D);
	private static final VoxelShape BOTTOM_RIGHT_OUTER_SHAPE = Block.makeCuboidShape(0D, 0D, 0D, 4.0D, 16.0D, 4.0D);

	// inner corners
	private static final VoxelShape TOP_LEFT_INNER_SHAPE = VoxelShapes.or(SOUTH_FACING_SHAPE,
			Block.makeCuboidShape(0.0D, 0D, 4.0D, 4.0D, 16.0D, 16.0D));
	private static final VoxelShape TOP_RIGHT_INNER_SHAPE = VoxelShapes.or(SOUTH_FACING_SHAPE,
			Block.makeCuboidShape(12.0D, 0D, 4.0D, 16.0D, 16.0D, 16.0D));

	private static final VoxelShape BOTTOM_LEFT_INNER_SHAPE = VoxelShapes.or(NORTH_FACING_SHAPE,
			Block.makeCuboidShape(0.0D, 0D, 0.0D, 4.0D, 16.0D, 12.0D));
	private static final VoxelShape BOTTOM_RIGHT_INNER_SHAPE = VoxelShapes.or(NORTH_FACING_SHAPE,
			Block.makeCuboidShape(12.0D, 0D, 0D, 16.0D, 16.0D, 12.0D));

	// SWNE = 0,1,2,3
	private VoxelShape voxelShapes[] = {
			// straight
			SOUTH_FACING_SHAPE, WEST_FACING_SHAPE, NORTH_FACING_SHAPE, EAST_FACING_SHAPE,

			// inner left
			TOP_LEFT_INNER_SHAPE, // 4
			BOTTOM_LEFT_INNER_SHAPE, // 5

			// inner right
			TOP_RIGHT_INNER_SHAPE, // 6
			BOTTOM_RIGHT_INNER_SHAPE, // 7

			// outer left
			TOP_LEFT_OUTER_SHAPE, BOTTOM_LEFT_OUTER_SHAPE,

			// outer right
			TOP_RIGHT_OUTER_SHAPE, BOTTOM_RIGHT_OUTER_SHAPE };

	/**
	 * 
	 * @param modID
	 * @param registryName
	 * @param properties
	 */
	public QuarterFacadeBlock(String modID, String registryName, Properties properties) {
		super(modID, registryName, properties);
	}

	/**
	 * Returns the VoxelShape (ie bounding box) of the block in the correctposition.
	 * NOTE if shape != STRAIGHT, then facing index can only == North || South
	 */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		int shapeIndex = getBlockShapeIndex(state, worldIn, pos, context);
		return voxelShapes[shapeIndex];
	}

	/**
	 * This method returns the state of the block so that the correct entry in the
	 * blockstate.json file can be selected and the corresponding block model
	 * rendered.
	 */
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		BlockPos blockPos = context.getPos();
		BlockState blockState = this.getDefaultState().with(FACING,
				context.getPlacementHorizontalFacing().getOpposite());
		// custom method to get block state
		BlockState placementBlockState = getBlockStateForPlacement(context.getWorld(), blockState, blockPos);

		return placementBlockState;
	}

	/**
	 * Checks if a block is same as FacadeBlock
	 */
	@Override
	public boolean isBlockInstanceOf(Block block) {
		return block instanceof QuarterFacadeBlock;
	}
}

/**
 * 
 */
package com.someguyssoftware.dungeonblocks.block;

import com.someguyssoftware.gottschcore.block.FacingBlock;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

/**
 * @author Mark Gottschling on Jan 15, 2020
 *
 */
public class QuarterFacadeBlock extends FacingBlock {

	// Voxels are like the bounding boxes (AABBs)
	private static final VoxelShape NORTH_SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 12.0D, 16.0D, 16.0D, 16.0D);
	private static final VoxelShape EAST_SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 4.0D, 16.0D, 16.0D);
	private static final VoxelShape SOUTH_SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 4.0D);
	private static final VoxelShape WEST_SHAPE = Block.makeCuboidShape(12.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);

	public QuarterFacadeBlock(String modID, String registryName, Properties properties) {
		super(modID, registryName, properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
	}

	/**
	 * 
	 */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.get(FACING);

		switch (direction) {
		case NORTH:
		default:
			return NORTH_SHAPE;
		case EAST:
			return EAST_SHAPE;
		case SOUTH:
			return SOUTH_SHAPE;
		case WEST:
			return WEST_SHAPE;
		}
	}
}

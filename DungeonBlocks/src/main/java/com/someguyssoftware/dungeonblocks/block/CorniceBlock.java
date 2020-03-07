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
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

/**
 * @author Mark Gottschling on Jan 18, 2020
 *
 */
public class CorniceBlock extends FacingBlock {
	
	// Voxels are like the bounding boxes (AABBs) NF= North Facing, SF = South Facing, etc
	private static final VoxelShape NORTH_FACING_AABB = VoxelShapes.or(
			Block.makeCuboidShape(0.0D, 0.0D, 8.0D, 16.0D, 12.0D, 16.0D),
			Block.makeCuboidShape(0.0D, 12.0D, 3.0D, 16.0D, 16.0D, 16.0D));

	private static final VoxelShape WEST_FACING_AABB = VoxelShapes.or(
			Block.makeCuboidShape(8.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D),
			Block.makeCuboidShape(3.0D, 12.0D, 0.0D, 16.0D, 16.0D, 16.0D));
	
	private static final VoxelShape SOUTH_FACING_AABB = VoxelShapes.or(
			Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 8.0D),
			Block.makeCuboidShape(0.0D, 12.0D, 0.0D, 16.0D, 16.0D, 13.0D));	
	
	private static final VoxelShape EAST_FACING_AABB = VoxelShapes.or(
			Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 8.0D, 12.0D, 16.0D),
			Block.makeCuboidShape(0.0D, 12.0D, 0.0D, 13.0D, 16.0D, 16.0D));	
	
	public CorniceBlock(String modID, String name, Properties properties) {
		super(modID, name, properties);
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
			return NORTH_FACING_AABB;
		case SOUTH:
			return SOUTH_FACING_AABB;
		case EAST:
			return EAST_FACING_AABB;
		case WEST:
			return WEST_FACING_AABB;
		}
	}
}

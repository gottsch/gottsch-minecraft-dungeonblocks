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
 * @author Mark Gottschling on Jan 15, 2020
 *
 */
public class FlutedFacadeBlock extends FacingBlock {

	// Voxels are like the bounding boxes (AABBs)
	private static final VoxelShape NORTH_FACING_PART = Block.makeCuboidShape(2.0D, 0.0D, 10.0D, 14.0D, 16.0D, 16.0D);
	private static final VoxelShape N1_PART = Block.makeCuboidShape(0.0D, 0.0D, 8.0D, 4.0D, 16.0D, 12.0D);
	private static final VoxelShape N2_PART = Block.makeCuboidShape(12.0D, 0.0D, 8.0D, 16.0D, 16.0D, 12.0D);
	
	private static final VoxelShape SOUTH_FACING_PART = Block.makeCuboidShape(2.0D, 0.0D, 0.0D, 14.0D, 16.0D, 6.0D);
	private static final VoxelShape S1_PART = Block.makeCuboidShape(0.0D, 0.0D, 4.0D, 4.0D, 16.0D, 8.0D);
	private static final VoxelShape S2_PART = Block.makeCuboidShape(12.0D, 0.0D, 4.0D, 16.0D, 16.0D, 8.0D);
	
	private static final VoxelShape EAST_FACING_PART = Block.makeCuboidShape(0.0D, 0.0D, 2.0D, 6.0D, 16.0D, 14.0D);
	private static final VoxelShape E1_PART = Block.makeCuboidShape(4.0D, 0.0D, 0.0D, 8.0D, 16.0D, 4.0D);
	private static final VoxelShape E2_PART = Block.makeCuboidShape(4.0D, 0.0D, 12.0D, 8.0D, 16.0D, 16.0D);	

	private static final VoxelShape WEST_FACING_PART= Block.makeCuboidShape(10.0D, 0.0D, 2.0D, 16.0D, 16.0D, 14.0D);
	private static final VoxelShape W1_PART = Block.makeCuboidShape(8.0D, 0.0D, 0.0D, 12.0D, 16.0D, 4.0D);
	private static final VoxelShape W2_PART = Block.makeCuboidShape(8.0D, 0.0D, 12.0D, 12.0D, 16.0D, 16.0D);
	
	private static final VoxelShape NORTH_FACING_AABB = VoxelShapes.or(NORTH_FACING_PART, N1_PART, N2_PART);
	private static final VoxelShape EAST_FACING_AABB = VoxelShapes.or(EAST_FACING_PART, E1_PART, E2_PART);
	private static final VoxelShape SOUTH_FACING_AABB = VoxelShapes.or(SOUTH_FACING_PART, S1_PART, S2_PART);
	private static final VoxelShape WEST_FACING_AABB = VoxelShapes.or(WEST_FACING_PART, W1_PART, W2_PART);
	
	public FlutedFacadeBlock(String modID, String registryName, Properties properties) {
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
			return NORTH_FACING_AABB;
		case EAST:
			return EAST_FACING_AABB;
		case SOUTH:
			return SOUTH_FACING_AABB;
		case WEST:
			return WEST_FACING_AABB;
		}
	}
}

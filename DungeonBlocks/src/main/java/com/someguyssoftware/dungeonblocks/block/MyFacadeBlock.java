/**
 * 
 */
package com.someguyssoftware.dungeonblocks.block;

import com.someguyssoftware.dungeonblocks.DungeonBlocks;
import com.someguyssoftware.gottschcore.block.FacingBlock;

import net.minecraft.block.BlockState;
import net.minecraft.block.Block;
import net.minecraft.block.Block.Properties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

/**
 * @author Mark Gottschling on Jan 15, 2020
 *
 */
public class MyFacadeBlock extends FacingBlock {
	
	// Voxels are like the bounding boxes (AABBs)
	   private static final VoxelShape NORTH_SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 8.0D, 16.0D, 16.0D, 16.0D);
	   private static final VoxelShape EAST_SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 8.0D, 16.0D, 16.0D);
	   private static final VoxelShape SOUTH_SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 8.0D);
	   private static final VoxelShape WEST_SHAPE = Block.makeCuboidShape(8.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	
	
	public MyFacadeBlock(Properties properties) {
		super(DungeonBlocks.MOD_ID, "facade_block", properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
	}

	/**
	 * 
	 */
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction facing = getFacing(state);
		switch(facing) {
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

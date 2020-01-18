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
 * @author Mark Gottschling on Jan 18, 2020
 *
 */
public class ModTorchBlock extends FacingBlock {
	
	private static final VoxelShape NORTH_FACING_SHAPE = Block.makeCuboidShape(2.0D, 2.0D, 9.0D, 14.0D, 15.0D, 15.9999D);	
	private static final VoxelShape EAST_FACING_SHAPE = Block.makeCuboidShape(0.0001D, 2.0D, 2.0D, 6.0D, 15.0D, 14.0D);
	private static final VoxelShape SOUTH_FACING_SHAPE = Block.makeCuboidShape(2.0D, 2.0D, 0.0001D, 14.0D, 15.0D, 6.0D);
	private static final VoxelShape WEST_FACING_SHAPE = Block.makeCuboidShape(9.0D, 2.0D, 2.0D, 15.9999D, 15.0D, 14.0D);
	
	public ModTorchBlock(String modID, String name, Properties properties) {
		super(modID, name, properties);
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
			return NORTH_FACING_SHAPE;
		case EAST:
			return EAST_FACING_SHAPE;
		case SOUTH:
			return SOUTH_FACING_SHAPE;
		case WEST:
			return WEST_FACING_SHAPE;
		}
	}
}

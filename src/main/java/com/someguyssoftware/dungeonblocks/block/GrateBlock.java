/**
 * 
 */
package com.someguyssoftware.dungeonblocks.block;

import com.someguyssoftware.gottschcore.block.BasedBlock;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

/**
 * 
 * @author Mark Gottschling on Mar 5, 2020
 *
 */
public class GrateBlock extends BasedBlock {

	private static final VoxelShape UP_SHAPE = Block.box(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	private static final VoxelShape DOWN_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);
	private static final VoxelShape NORTH_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 8.0D);
	private static final VoxelShape EAST_SHAPE = Block.box(8.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	private static final VoxelShape SOUTH_SHAPE = Block.box(0.0D, 0.0D, 8.0D, 16.0D, 16.0D, 16.0D);
	private static final VoxelShape WEST_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 8.0D, 16.0D, 16.0D);

	/**
	 * 
	 * @param modID
	 * @param name
	 * @param properties
	 */
	public GrateBlock(String modID, String name, Properties properties) {
		super(modID, name, properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(BASE, Direction.UP));
	}

	/**
	 * 
	 */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.getValue(BASE);

		switch (direction) {
		case UP:
			return UP_SHAPE;
		case DOWN:
		default:
			return DOWN_SHAPE;
		case NORTH:
			return NORTH_SHAPE;
		case SOUTH:
			return SOUTH_SHAPE;
		case EAST:
			return EAST_SHAPE;
		case WEST:
			return WEST_SHAPE;
		}
	}
}

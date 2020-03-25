/**
 * 
 */
package com.someguyssoftware.dungeonblocks.block;

import com.someguyssoftware.dungeonblocks.state.properties.FacadeShape;
import com.someguyssoftware.gottschcore.block.IFacingBlock;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.EnumProperty;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

/**
 * @author Mark Gottschling on Mar 24, 2020
 *
 */
public interface IFacadeShapeBlock extends IFacingBlock {
	public static final EnumProperty<FacadeShape> SHAPE = EnumProperty.create("shape", FacadeShape.class);

	public boolean isBlockInstanceOf(Block block);

	/**
	 * Returns the VoxelShape (ie bounding box) of the block in the correctposition.
	 * NOTE if shape != STRAIGHT, then facing index can only == North || South
	 */
	default public int getBlockShapeIndex(BlockState state, IBlockReader worldIn, BlockPos pos,
			ISelectionContext context) {
		int facingIndex = 0;
		int shapeIndex = 0;

		Direction direction = state.get(FACING);
		FacadeShape shape = state.get(SHAPE);

		switch (direction) {
		case NORTH:
			facingIndex = Direction.NORTH.getHorizontalIndex();
			break;
		case SOUTH:
			facingIndex = Direction.SOUTH.getHorizontalIndex();
			break;
		case EAST:
			facingIndex = Direction.EAST.getHorizontalIndex();
			break;
		case WEST:
			facingIndex = Direction.WEST.getHorizontalIndex();
			break;
		default:
			facingIndex = Direction.NORTH.getHorizontalIndex();
			break;
		}

		// TODO make consts for all the indexes or an enum with int values
		switch (shape) {
		case STRAIGHT:
			shapeIndex = facingIndex;
			break;
		case INNER_LEFT:
			if (facingIndex == 0)
				shapeIndex = 4;
			else if (facingIndex == 2)
				shapeIndex = 5;
			break;
		case INNER_RIGHT:
			if (facingIndex == 0)
				shapeIndex = 6;
			else if (facingIndex == 2)
				shapeIndex = 7;
			break;
		case OUTER_LEFT:
			if (facingIndex == 0)
				shapeIndex = 8;
			else if (facingIndex == 2)
				shapeIndex = 9;
			break;
		case OUTER_RIGHT:
			if (facingIndex == 0)
				shapeIndex = 10;
			else if (facingIndex == 2)
				shapeIndex = 11;
			break;
		default:
			shapeIndex = 0;
			break;
		}
		return shapeIndex;
	}

	/**
	 * 
	 * @param world
	 * @param blockState
	 * @param blockPos
	 * @return
	 */
	default public BlockState getBlockStateForPlacement(World world, BlockState blockState, BlockPos blockPos) {
		Direction direction = blockState.get(FACING);

		// test the direction theblock is facing
		switch (direction) {
		case SOUTH:
			blockState = getStateForSouthDirection(world, blockPos, blockState);
			break;
		case NORTH:
			blockState = getStateForNorthDirection(world, blockPos, blockState);
			break;
		case EAST:
			blockState = getStateForEastDirection(world, blockPos, blockState);
			break;
		case WEST:
			blockState = getStateForWestDirection(world, blockPos, blockState);
			break;
		default:
			blockState = blockState.with(SHAPE, FacadeShape.STRAIGHT);
		}
		return blockState;
	}

	/**
	 * Check whether there is a same block at the given position and it has the same
	 * properties as the given BlockState
	 */
	default public boolean isSameBasic(IBlockReader worldIn, BlockPos pos, BlockState stateIn) {
		BlockState state = worldIn.getBlockState(pos);
		Block block = state.getBlock();
		/**
		 * Checks if a block is an instance of this class
		 */
		return isBlockInstanceOf(block) && state.get(FACING) == stateIn.get(FACING);
	}

	default BlockState getStateForSouthDirection(World world, BlockPos blockPos, BlockState blockState) {
		BlockState neighborState;
		Block neighborBlock;
		Direction neighborFacing;

		neighborState = world.getBlockState(blockPos.south());
		neighborBlock = neighborState.getBlock();

		// inner test
		if (isBlockInstanceOf(neighborBlock)) {
			neighborFacing = neighborState.get(FACING);
			if (neighborFacing == Direction.WEST && !isSameBasic(world, blockPos.east(), blockState)) {
				blockState = blockState.with(SHAPE, FacadeShape.INNER_RIGHT);
			} else if (neighborFacing == Direction.EAST && !isSameBasic(world, blockPos.west(), blockState)) {
				blockState = blockState.with(SHAPE, FacadeShape.INNER_LEFT);
			}
			return blockState;
		}

		// outer test
		neighborState = world.getBlockState(blockPos.north());
		neighborBlock = neighborState.getBlock();

		if (isBlockInstanceOf(neighborBlock)) {
			neighborFacing = neighborState.get(FACING);
			if (neighborFacing == Direction.WEST && !isSameBasic(world, blockPos.west(), blockState)) {
				blockState = blockState.with(SHAPE, FacadeShape.OUTER_LEFT);
			} else if (neighborFacing == Direction.EAST && !isSameBasic(world, blockPos.east(), blockState)) {
				blockState = blockState.with(SHAPE, FacadeShape.OUTER_RIGHT);
			}
		}

		return blockState;
	}

	default public BlockState getStateForNorthDirection(World world, BlockPos blockPos, BlockState blockState) {
		BlockState neighborState;
		Block neighborBlock;
		Direction neighborFacing;

		neighborState = world.getBlockState(blockPos.north());
		neighborBlock = neighborState.getBlock();

		// inner test
		if (isBlockInstanceOf(neighborBlock)) {
			neighborFacing = neighborState.get(FACING);
			if (neighborFacing == Direction.WEST && !isSameBasic(world, blockPos.east(), blockState)) {
				blockState = blockState.with(SHAPE, FacadeShape.INNER_RIGHT);
			} else if (neighborFacing == Direction.EAST && !isSameBasic(world, blockPos.west(), blockState)) {
				blockState = blockState.with(SHAPE, FacadeShape.INNER_LEFT);
			}
			return blockState;
		}

		// outer test
		neighborState = world.getBlockState(blockPos.south());
		neighborBlock = neighborState.getBlock();

		if (isBlockInstanceOf(neighborBlock)) {
			neighborFacing = neighborState.get(FACING);
			if (neighborFacing == Direction.WEST && !isSameBasic(world, blockPos.west(), blockState)) {
				blockState = blockState.with(SHAPE, FacadeShape.OUTER_LEFT);
			} else if (neighborFacing == Direction.EAST && !isSameBasic(world, blockPos.east(), blockState)) {
				blockState = blockState.with(SHAPE, FacadeShape.OUTER_RIGHT);
			}
		}
		return blockState;
	}

	default public BlockState getStateForEastDirection(World world, BlockPos blockPos, BlockState blockState) {
		BlockState neighborState;
		Block neighborBlock;
		Direction neighborFacing;

		neighborState = world.getBlockState(blockPos.east());
		neighborBlock = neighborState.getBlock();

		// inner test
		if (isBlockInstanceOf(neighborBlock)) {
			neighborFacing = neighborState.get(FACING);
			if (neighborFacing == Direction.NORTH && !isSameBasic(world, blockPos.south(), blockState)) {
				blockState = blockState.with(FACING, Direction.NORTH);
				blockState = blockState.with(SHAPE, FacadeShape.INNER_LEFT);
			} else if (neighborFacing == Direction.SOUTH && !isSameBasic(world, blockPos.north(), blockState)) {
				blockState = blockState.with(FACING, Direction.SOUTH);
				blockState = blockState.with(SHAPE, FacadeShape.INNER_LEFT);
			}
			return blockState;
		}

		// outer test
		neighborState = world.getBlockState(blockPos.west());
		neighborBlock = neighborState.getBlock();

		if (isBlockInstanceOf(neighborBlock)) {
			neighborFacing = neighborState.get(FACING);
			if (neighborFacing == Direction.NORTH && !isSameBasic(world, blockPos.north(), blockState)) {
				blockState = blockState.with(FACING, Direction.NORTH);
				blockState = blockState.with(SHAPE, FacadeShape.OUTER_RIGHT);
			} else if (neighborFacing == Direction.SOUTH && !isSameBasic(world, blockPos.south(), blockState)) {
				blockState = blockState.with(FACING, Direction.SOUTH);
				blockState = blockState.with(SHAPE, FacadeShape.OUTER_RIGHT);
			}
		}
		return blockState;
	}

	default public BlockState getStateForWestDirection(World world, BlockPos blockPos, BlockState blockState) {
		BlockState neighborState;
		Block neighborBlock;
		Direction neighborFacing;

		neighborState = world.getBlockState(blockPos.west());
		neighborBlock = neighborState.getBlock();

		// inner test
		if (isBlockInstanceOf(neighborBlock)) {
			neighborFacing = neighborState.get(FACING);
			if (neighborFacing == Direction.NORTH && !isSameBasic(world, blockPos.south(), blockState)) {
				blockState = blockState.with(FACING, Direction.NORTH);
				blockState = blockState.with(SHAPE, FacadeShape.INNER_RIGHT);
			} else if (neighborFacing == Direction.SOUTH && !isSameBasic(world, blockPos.north(), blockState)) {
				blockState = blockState.with(FACING, Direction.SOUTH);
				blockState = blockState.with(SHAPE, FacadeShape.INNER_RIGHT);
			}
			return blockState;
		}

		// outer test
		neighborState = world.getBlockState(blockPos.east());
		neighborBlock = neighborState.getBlock();

		if (isBlockInstanceOf(neighborBlock)) {
			neighborFacing = neighborState.get(FACING);
			if (neighborFacing == Direction.NORTH && !isSameBasic(world, blockPos.north(), blockState)) {
				blockState = blockState.with(FACING, Direction.NORTH);
				blockState = blockState.with(SHAPE, FacadeShape.OUTER_LEFT);
			} else if (neighborFacing == Direction.SOUTH && !isSameBasic(world, blockPos.south(), blockState)) {
				blockState = blockState.with(FACING, Direction.SOUTH);
				blockState = blockState.with(SHAPE, FacadeShape.OUTER_LEFT);
			}
		}
		return blockState;
	}
}

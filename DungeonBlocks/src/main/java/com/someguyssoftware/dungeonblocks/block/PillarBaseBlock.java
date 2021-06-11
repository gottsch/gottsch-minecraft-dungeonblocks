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
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

/**
 * @author Mark Gottschling on Jan 18, 2020
 *
 */
public class PillarBaseBlock extends BasedBlock {

	// Voxels are like the bounding boxes (AABBs) NF= North Facing, SF = South
	// Facing, etc
	private static final VoxelShape NORTH_AABB = VoxelShapes.or(
			Block.box(0.0D, 0.0D, 8.0D, 16.0D, 16.0D, 16.0D), // "base"
			Block.box(1.0D, 1.0D, 6.0D, 15.0D, 15.0D, 8.0D), // "middle base"
			Block.box(2.0D, 2.0D, 2.0D, 14.0D, 14.0D, 6.0D), // "middle top"
			Block.box(1.0D, 1.0D, 0.0D, 15.0D, 15.0D, 2.0D) // "top"
	);

	private static final VoxelShape SOUTH_AABB = VoxelShapes.or(
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 8.0D), // "base"
			Block.box(1.0D, 1.0D, 8.0D, 15.0D, 15.0D, 10.0D), // "middle base"
			Block.box(2.0D, 2.0D, 10.0D, 14.0D, 14.0D, 14.0D), // "middle top"
			Block.box(1.0D, 1.0D, 14.0D, 15.0D, 15.0D, 16.0D) // "top"

	);

	private static final VoxelShape EAST_AABB = VoxelShapes.or(
			Block.box(0.0D, 0.0D, 0.0D, 8.0D, 16.0D, 16.0D), // "base"
			Block.box(8.0D, 1.0D, 1.0D, 10.0D, 15.0D, 15.0D), // "middle base"
			Block.box(10.0D, 2.0D, 2.0D, 14.0D, 14.0D, 14.0D), // "middle top"
			Block.box(14.0D, 1.0D, 1.0D, 16.0D, 15.0D, 15.0D) // "top"
	);

	private static final VoxelShape WEST_AABB = VoxelShapes.or(
			Block.box(8.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), // "base"
			Block.box(6.0D, 1.0D, 1.0D, 8.0D, 15.0D, 15.0D), // "middle base"
			Block.box(2.0D, 2.0D, 2.0D, 6.0D, 14.0D, 14.0D), // "middle top"
			Block.box(0.0D, 1.0D, 1.0D, 2.0D, 15.0D, 15.0D) // "top"
	);

	private static final VoxelShape UP_AABB = VoxelShapes.or(
			Block.box(1.0D, 14.0D, 1.0D, 15.0D, 16.0D, 15.0D),
			Block.box(2.0D, 10.0D, 2.0D, 14.0D, 14.0D, 14.0D),
			Block.box(1.0D, 8.0D, 1.0D, 15.0D, 10.0D, 15.0D),
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D));

	private static final VoxelShape DOWN_AABB = VoxelShapes.or( // shape is inverted
			Block.box(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D), // "base"
			Block.box(1.0D, 6.0D, 1.0D, 15.0D, 8.0D, 15.0D), // "middle base"
			Block.box(2.0D, 2.0D, 2.0D, 14.0D, 6.0D, 14.0D), // "middle top"
			Block.box(1.0D, 0.0D, 1.0D, 15.0D, 2.0D, 15.0D) // "top"
	);

	public PillarBaseBlock(String modID, String name, Properties properties) {
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
			return UP_AABB;
		case DOWN:
		default:
			return DOWN_AABB;
		case NORTH:
			return NORTH_AABB;
		case SOUTH:
			return SOUTH_AABB;
		case EAST:
			return EAST_AABB;
		case WEST:
			return WEST_AABB;
		}
	}
}

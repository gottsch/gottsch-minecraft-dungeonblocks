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
 * @author Mark Gottschling on Jan 18, 2020
 *
 */
public class PillarBlock extends BasedBlock {
	
	// Voxels are like the bounding boxes (AABBs) NF= North Facing, SF = South Facing, etc
	private static final VoxelShape NORTH_SOUTH_AABB = Block.box(3.0D, 3.0D, 0.0D, 13.0D, 13.0D, 16.0D);
	private static final VoxelShape EAST_WEST_AABB = Block.box(0.0D, 3.0D, 3.0D, 16.0D, 13.0D, 13.0D);	
	private static final VoxelShape UP_DOWN_AABB = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 16.0D, 13.0D);
	
	public PillarBlock(String modID, String name, Properties properties) {
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
		case DOWN:
		default:
			return UP_DOWN_AABB;
		case NORTH:
		case SOUTH:
			return NORTH_SOUTH_AABB;
		case EAST:
		case WEST:
			return EAST_WEST_AABB;
		}
	}
}

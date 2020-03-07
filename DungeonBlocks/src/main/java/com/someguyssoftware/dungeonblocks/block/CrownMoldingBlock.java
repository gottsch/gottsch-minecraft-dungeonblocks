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
public class CrownMoldingBlock extends FacingBlock {
	// Voxels are like the bounding boxes (AABBs) NF= North Facing, SF = South Facing, etc
	private static final VoxelShape NORTH_FACING_AABB = 
			VoxelShapes.or(
					Block.makeCuboidShape(0.0D, 0.0D, 12.0D, 16.0D, 3.0D, 16.0D), 		//bottom (16x3x4)
					Block.makeCuboidShape(0.0D, 9.0D, 10.0D, 16.0D, 16.0D, 16.0D), 				// top (16x7x6)
					Block.makeCuboidShape(0.0D, 8.0D, 12.0D, 16.0D, 9.0D, 14.0D), 			// notch (16x1x2)
					Block.makeCuboidShape(0.0D, 3.0D, 14.0D, 16.0D, 9.0D, 16.0D));		//middle (16x6x2)

	private static final VoxelShape EAST_FACING_AABB = 	
			VoxelShapes.or(
					Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 4.0D, 3.0D, 16.0D),
					Block.makeCuboidShape(0.0D, 9.0D, 0.0D, 6.0D, 16.0D, 16.0D),
					Block.makeCuboidShape(2.0D, 8.0D, 0.0D, 4.0D, 9.0D, 16.0D),
					Block.makeCuboidShape(0.0D, 3.0D, 0.0D, 2.0D, 9.0D, 16.0D));

	private static final VoxelShape SOUTH_FACING_AABB = 
			VoxelShapes.or(
					Block.makeCuboidShape(0, 0, 0, 16, 3, 4),
					Block.makeCuboidShape(0, 9, 0, 16, 16, 6),
					Block.makeCuboidShape(0, 8, 2, 16, 9, 4),
					Block.makeCuboidShape(0, 3, 0, 16, 9, 2));

	private static final VoxelShape WEST_FACING_AABB = 
			VoxelShapes.or(
					Block.makeCuboidShape(12, 0, 0, 16, 3, 16),
					Block.makeCuboidShape(10, 9, 0, 16, 16, 16),
					Block.makeCuboidShape(12, 8, 0, 14, 9, 16),
					Block.makeCuboidShape(14, 3, 0, 16, 9, 16));

	/**
	 * 
	 * @param modID
	 * @param name
	 * @param properties
	 */
	public CrownMoldingBlock(String modID, String name, Properties properties) {
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

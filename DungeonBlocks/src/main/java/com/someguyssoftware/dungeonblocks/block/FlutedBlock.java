/**
 * 
 */
package com.someguyssoftware.dungeonblocks.block;

import com.someguyssoftware.gottschcore.block.ModBlock;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

/**
 * @author Mark Gottschling on Jan 17, 2020
 *
 */
public class FlutedBlock extends ModBlock {

	// Voxels are like the bounding boxes (AABBs)
	private static final VoxelShape MAIN_PART = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);
	private static final VoxelShape NW_PART = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 4.0D, 16.0D, 4.0D);
	private static final VoxelShape NE_PART = Block.makeCuboidShape(12.0D, 0.0D, 0.0D, 16.0D, 16.0D, 4.0D);
	private static final VoxelShape SW_PART = Block.makeCuboidShape(0.0D, 0.0D, 12.0D, 4.0D, 16.0D, 16.0D);
	private static final VoxelShape SE_PART = Block.makeCuboidShape(12.0D, 0.0D, 12.0D, 16.0D, 16.0D, 16.0D);
	private static final VoxelShape AABB = VoxelShapes.or(MAIN_PART, NW_PART, NE_PART, SW_PART, SE_PART);
	
	public FlutedBlock(String modID, String name, Properties properties) {
		super(modID, name, properties);
	}

	/**
	 * 
	 */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return AABB;
	}
}

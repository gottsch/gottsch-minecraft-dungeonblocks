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

	private static final VoxelShape UP_SHAPE = Block.makeCuboidShape(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	private static final VoxelShape DOWN_SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);
	private static final VoxelShape NORTH_SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 8.0D);
	private static final VoxelShape EAST_SHAPE = Block.makeCuboidShape(8.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	private static final VoxelShape SOUTH_SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 8.0D, 16.0D, 16.0D, 16.0D);
	private static final VoxelShape WEST_SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 8.0D, 16.0D, 16.0D);

	/**
	 * 
	 * @param modID
	 * @param name
	 * @param properties
	 */
	public GrateBlock(String modID, String name, Properties properties) {
		super(modID, name, properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(BASE, Direction.UP));
	}

	/**
	 * 
	 * @param modID
	 * @param name
	 * @param material
	 */
//	public GrateBlock(String modID, String name, Material material) {
//		super(modID, name, material);		
//		setSoundType(SoundType.STONE);
//		setBoundingBox(
//				new AxisAlignedBB(0F, 0.5F, 0F, 1F, 1F, 1F),	// NORTH
//				new AxisAlignedBB(0F, 0.5F, 0F, 1F, 1F, 1F),	// EAST
//				new AxisAlignedBB(0F, 0.5F, 0F, 1F, 1F, 1F),	// SOUTH
//				new AxisAlignedBB(0F, 0.5F, 0F, 1F, 1F, 1F));	// WEST
//		setCreativeTab(Dungeons2.DUNGEONS_TAB);
//		this.setDefaultState(blockState.getBaseState().withProperty(BASE, EnumFacing.DOWN));
//	}	

	/**
	 * 
	 */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.get(BASE);

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

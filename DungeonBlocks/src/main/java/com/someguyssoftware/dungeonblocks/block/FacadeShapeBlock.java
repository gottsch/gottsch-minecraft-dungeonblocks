/**
 * 
 */
package com.someguyssoftware.dungeonblocks.block;

import com.someguyssoftware.dungeonblocks.state.properties.FacadeShape;
import com.someguyssoftware.gottschcore.block.FacingBlock;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;

/**
 * @author Mark Gottschling on Mar 25, 2020
 *
 */
public abstract class FacadeShapeBlock extends FacingBlock implements IFacadeShapeBlock {

	/**
	 * 
	 * @param modID
	 * @param name
	 * @param materialIn
	 */
	public FacadeShapeBlock(String modID, String name, Block.Properties properties) {
		super(modID, name, properties);
		this.registerDefaultState(
				this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(SHAPE, FacadeShape.STRAIGHT));
	}

	/**
	 * 
	 */
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(FACING, SHAPE);
	}

	/**
	 * Checks if a block is same as FacadeBlock
	 */
	@Override
	public abstract boolean isBlockInstanceOf(Block block);

}

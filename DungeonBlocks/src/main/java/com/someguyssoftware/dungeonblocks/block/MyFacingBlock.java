/**
 * 
 */
package com.someguyssoftware.dungeonblocks.block;

import com.someguyssoftware.gottschcore.block.FacingBlock;

import net.minecraft.util.Direction;

/**
 * @author Mark Gottschling on Jan 14, 2020
 *
 */
public class MyFacingBlock extends FacingBlock {
	public MyFacingBlock(String modID, String registryName, Properties properties) {
		super(modID, registryName, properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
	}
}

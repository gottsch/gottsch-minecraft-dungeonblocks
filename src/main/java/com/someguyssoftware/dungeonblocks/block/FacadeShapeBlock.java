/*
 * This file is part of  DungeonBlocks.
 * Copyright (c) 2021, Mark Gottschling (gottsch)
 * 
 * All rights reserved.
 *
 * DungeonBlocks is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * DungeonBlocks is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with DungeonBlocks.  If not, see <http://www.gnu.org/licenses/lgpl>.
 */
package com.someguyssoftware.dungeonblocks.block;

import com.someguyssoftware.dungeonblocks.state.properties.FacadeShape;
import com.someguyssoftware.gottschcore.block.FacingBlock;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;

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
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING, SHAPE);
	}

	/**
	 * Checks if a block is same as FacadeBlock
	 */
	@Override
	public abstract boolean isBlockInstanceOf(Block block);

}

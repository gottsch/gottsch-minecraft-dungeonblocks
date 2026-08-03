/*
 * This file is part of  DungeonBlocks.
 * Copyright (c) 2021 Mark Gottschling (gottsch)
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
package mod.gottsch.forge.dungeonblocks.core.block;

import mod.gottsch.forge.dungeonblocks.core.state.properties.FacadeShape;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;

/**
 * @author Mark Gottschling on Mar 25, 2020
 *
 */
public abstract class FacadeShapeBlock extends WaterloggedNonCubeFacingBlock implements IFacadeShapeBlock {

	/**
	 * 
	 * @param properties
	 */
	public FacadeShapeBlock(Properties properties) {
		super(properties);
	}


	/**
	 * 
	 */
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(SHAPE);
	}

	/**
	 * This method returns the state of the block so that the correct entry in the
	 * blockstate.json file can be selected and the corresponding block model
	 * rendered.
	 */
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		BlockState blockState = super.getStateForPlacement(context);
		// custom method to get block state
		BlockState placementBlockState = getBlockStateForPlacement(context.getLevel(), blockState, context.getClickedPos());

		return placementBlockState;
	}

	@Override
	public BlockState updateShape(BlockState blockState, Direction direction, BlockState blockState2, LevelAccessor level, BlockPos blockPos, BlockPos blockPos2) {
		BlockState placementBlockState = super.updateShape(blockState, direction, blockState2, level, blockPos, blockPos2);
		// custom method to get block state
		placementBlockState = getBlockStateForPlacement(level, placementBlockState, blockPos);
		return placementBlockState;
	}
	
	/*
	 * NOTE rotate() is inherited unchanged from FacingBlock, which turns FACING and
	 * leaves SHAPE alone. That is correct precisely because LEFT/RIGHT are relative
	 * to FACING - a rotated corner is still the same corner.
	 */

	/**
	 * A mirror reverses handedness, so on top of flipping FACING every corner has to
	 * swap left for right.
	 */
	@Override
	public BlockState mirror(BlockState state, Mirror mirror) {
		BlockState mirrored = state.setValue(FACING, mirror.mirror(state.getValue(FACING)));
		if (mirror == Mirror.NONE || state.getValue(FACING).getAxis().isVertical()) {
			return mirrored;
		}

		return switch (state.getValue(SHAPE)) {
		case INNER_LEFT -> mirrored.setValue(SHAPE, FacadeShape.INNER_RIGHT);
		case INNER_RIGHT -> mirrored.setValue(SHAPE, FacadeShape.INNER_LEFT);
		case OUTER_LEFT -> mirrored.setValue(SHAPE, FacadeShape.OUTER_RIGHT);
		case OUTER_RIGHT -> mirrored.setValue(SHAPE, FacadeShape.OUTER_LEFT);
		default -> mirrored;
		};
	}

	/**
	 * Checks if a block is same as FacadeBlock
	 */
	@Override
	public abstract boolean isBlockInstanceOf(Block block);

	@Override
	public void onPlace(BlockState state, Level level, BlockPos pos, BlockState state2, boolean flag) {
		level.neighborChanged(pos, state.getBlock(), pos);
	}

	@Override
	public void onRemove(BlockState state, Level level, BlockPos pos, BlockState state2, boolean flag) {
		level.neighborChanged(pos, state.getBlock(), pos);
	}


	@Override
	public boolean useShapeForLightOcclusion(BlockState state) {
		return true;
	}
}

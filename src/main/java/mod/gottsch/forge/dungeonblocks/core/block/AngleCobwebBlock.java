/*
 * This file is part of  DungeonBlocks.
 * Copyright (c) 2026 Mark Gottschling (gottsch)
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

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

/**
 * A purely decorative, walk-through corner cobweb. No collision (see
 * {@code Properties.noCollission()} at registration) and no vanilla cobweb slowdown/break behavior -
 * it is a plain {@link Block} dressed up with a custom model, mounted flush against whichever
 * surface (wall, floor or ceiling) is behind it, like {@link PlateBracketBlock}.
 *
 * @author Mark Gottschling on Aug 1, 2026
 */
public class AngleCobwebBlock extends NonCubeFacingBlock {

	/**
	 * FACING alone only gives a wall mount four distinct yaws - UP and DOWN are single fixed values,
	 * so a floor/ceiling mount would always render the same way regardless of which way the player
	 * was facing when they placed it. ROTATION (0-3, one of the four horizontal quarter-turns) is
	 * read only when FACING is UP or DOWN; it's a harmless no-op for the four wall orientations.
	 */
	public static final IntegerProperty ROTATION = IntegerProperty.create("rotation", 0, 3);

	public AngleCobwebBlock(Properties properties) {
		super(properties);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(ROTATION);
	}

	/**
	 * {@link NonCubeFacingBlock#getStateForPlacement} only ever resolves FACING to one of the four
	 * horizontal directions, so this would never mount to a floor or ceiling. Use the nearest of all
	 * six directions instead, same as {@link PlateBracketBlock}/{@link WallRingBlock}. ROTATION is
	 * always taken from the player's horizontal look, independent of FACING/pitch, so a floor or
	 * ceiling mount still remembers which way they were facing.
	 */
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState()
				.setValue(FACING, context.getNearestLookingDirection().getOpposite())
				.setValue(ROTATION, context.getHorizontalDirection().get2DDataValue());
	}

	@Override
	public BlockState updateShape(BlockState state, Direction direction, BlockState state2, LevelAccessor level, BlockPos pos, BlockPos pos2) {
		return direction.getOpposite() == state.getValue(FACING) && !state.canSurvive(level, pos) ? Blocks.AIR.defaultBlockState() : state;
	}

	@Override
	public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
		Direction direction = state.getValue(FACING);
		BlockPos blockpos = pos.relative(direction.getOpposite());
		BlockState blockstate = level.getBlockState(blockpos);
		return blockstate.isFaceSturdy(level, blockpos, direction);
	}
}

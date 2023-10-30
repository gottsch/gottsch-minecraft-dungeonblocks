/*
 * This file is part of  DungeonBlocks.
 * Copyright (c) 2023 Mark Gottschling (gottsch)
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
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

/**
 * 
 * @author Mark Gottschling on Oct 27, 2023
 *
 */
public class WallRingBlock extends WaterloggedNonCubeFacingBlock {

	// size = 6x9x6
	private static final VoxelShape UP_SHAPE = Block.box(0.0D, 0D, 0.0D, 16D, 4D, 16D);
	private static final VoxelShape DOWN_SHAPE = Block.box(0.0D, 4D, 0.0D, 16D, 16D, 16D);
	private static final VoxelShape NORTH_SHAPE = Block.box(3.5D, 3D, 14D, 12.5D, 12D, 16D);
	private static final VoxelShape EAST_SHAPE = Block.box(0D, 3D, 3.5D, 2D, 12D, 12.5D);
	private static final VoxelShape SOUTH_SHAPE = Block.box(3.5D, 3D, 0D, 12.5D, 12D, 2D);
	private static final VoxelShape WEST_SHAPE = Block.box(14D, 3D, 3.5D, 16D, 12D, 12.5D);

	public WallRingBlock(Properties properties) {
		super(properties);
	}

	/**
	 * 
	 */
	@Override
	public @NotNull VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
		Direction direction = state.getValue(FACING);

		return switch (direction) {
			case UP -> UP_SHAPE;
            case NORTH -> NORTH_SHAPE;
			case SOUTH -> SOUTH_SHAPE;
			case EAST -> EAST_SHAPE;
			case WEST -> WEST_SHAPE;
			default -> DOWN_SHAPE;
		};
	}
}

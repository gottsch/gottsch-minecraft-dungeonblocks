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

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * @author Mark Gottschling on Jan 18, 2020
 *
 */
public class PillarBlock extends NonCubeBasedBlock {
	
	// Voxels are like the bounding boxes (AABBs) NF= North Facing, SF = South Facing, etc
	private static final VoxelShape NORTH_SOUTH_AABB = Block.box(3.0D, 3.0D, 0.0D, 13.0D, 13.0D, 16.0D);
	private static final VoxelShape EAST_WEST_AABB = Block.box(0.0D, 3.0D, 3.0D, 16.0D, 13.0D, 13.0D);	
	private static final VoxelShape UP_DOWN_AABB = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 16.0D, 13.0D);
	
	public PillarBlock(Properties properties) {
		super(properties);
	}
	
	@Deprecated
	public PillarBlock(String modID, String name, Properties properties) {
		super(modID, name, properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(BASE, Direction.UP));
	}

	/**
	 * 
	 */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
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

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

import com.someguyssoftware.gottschcore.block.ModBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * @author Mark Gottschling on Jan 17, 2020
 *
 */
public class FlutedBlock extends ModBlock {

	// Voxels are like the bounding boxes (AABBs)
	private static final VoxelShape MAIN_PART = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);
	private static final VoxelShape NW_PART = Block.box(0.0D, 0.0D, 0.0D, 4.0D, 16.0D, 4.0D);
	private static final VoxelShape NE_PART = Block.box(12.0D, 0.0D, 0.0D, 16.0D, 16.0D, 4.0D);
	private static final VoxelShape SW_PART = Block.box(0.0D, 0.0D, 12.0D, 4.0D, 16.0D, 16.0D);
	private static final VoxelShape SE_PART = Block.box(12.0D, 0.0D, 12.0D, 16.0D, 16.0D, 16.0D);
	private static final VoxelShape AABB = Shapes.or(MAIN_PART, NW_PART, NE_PART, SW_PART, SE_PART);
	
	public FlutedBlock(String modID, String name, Properties properties) {
		super(modID, name, properties);
	}

	/**
	 * 
	 */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
		return AABB;
	}
}

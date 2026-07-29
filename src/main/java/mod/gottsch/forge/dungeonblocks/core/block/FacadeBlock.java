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

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * @author Mark Gottschling on Jan 15, 2020
 *
 */
public class FacadeBlock extends FacadeShapeBlock {

	/*
	 * Voxels are like the bounding boxes (AABBs). All canonical geometry is authored
	 * for a NORTH-facing block - ie the orientation the models are drawn in at
	 * y-rotation 0. The other three facings, and both handednesses of each corner,
	 * are turned out of these.
	 */
	private static final VoxelShape STRAIGHT_SHAPE = Block.box(0.0D, 0.0D, 8.0D, 16.0D, 16.0D, 16.0D);

	private static final VoxelShape INNER_SHAPE = Shapes.or(STRAIGHT_SHAPE,
			Block.box(8.0D, 0D, 0D, 16.0D, 16.0D, 8.0D));

	private static final VoxelShape OUTER_SHAPE = Block.box(8.0D, 0D, 8.0D, 16.0D, 16.0D, 16.0D);

	private static final VoxelShape[] VOXEL_SHAPES =
			IFacadeShapeBlock.buildShapeTable(STRAIGHT_SHAPE, INNER_SHAPE, OUTER_SHAPE);

	/**
	 * 
	 * @param properties
	 */
	public FacadeBlock(Properties properties) {
		super(properties);
	}

	/**
	 * Returns the VoxelShape (ie bounding box) of the block in the correct position.
	 */
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
		int shapeIndex = getBlockShapeIndex(state, getter, pos, context);
		return VOXEL_SHAPES[shapeIndex];
	}

	/**
	 * Checks if a block is same as FacadeBlock
	 */
	@Override
	public boolean isBlockInstanceOf(Block block) {
		return block instanceof FacadeBlock;
	}

}

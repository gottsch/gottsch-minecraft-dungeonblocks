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
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * @author Mark Gottschling on Jan 18, 2020
 *
 */
public class CrownMoldingBlock extends FacadeShapeBlock {
	/*
	 * Voxels are like the bounding boxes (AABBs). All canonical geometry is authored
	 * for a NORTH-facing block - ie the orientation the models are drawn in at
	 * y-rotation 0. The other three facings, and both handednesses of each corner,
	 * are turned out of these.
	 */
	private static final VoxelShape STRAIGHT_SHAPE = Shapes.or(
			Block.box(0.0D, 0.0D, 12.0D, 16.0D, 3.0D, 16.0D), // bottom (16x3x4)
			Block.box(0.0D, 9.0D, 10.0D, 16.0D, 16.0D, 16.0D), // top (16x7x6)
			Block.box(0.0D, 8.0D, 12.0D, 16.0D, 9.0D, 14.0D), // notch (16x1x2)
			Block.box(0.0D, 3.0D, 14.0D, 16.0D, 9.0D, 16.0D)); // middle (16x6x2)

	private static final VoxelShape INNER_SHAPE = Shapes.or(STRAIGHT_SHAPE,
			Block.box(10, 9, 0, 16, 16, 10), Block.box(14, 3, 0, 16, 9, 14),
			Block.box(12, 8, 0, 16, 9, 12), Block.box(12, 0, 0, 16, 3, 12));

	private static final VoxelShape OUTER_SHAPE = Shapes.or(Block.box(10, 9, 10, 16, 16, 16), // top
			Block.box(14, 3, 14, 16, 9, 16), // middle
			Block.box(12, 8, 12, 16, 9, 14), // notch
			Block.box(12, 8, 14, 14, 9, 16), // notch2
			Block.box(12, 0, 12, 16, 3, 16)); // bottom - 4x4, matching the model element

	private static final VoxelShape[] VOXEL_SHAPES =
			IFacadeShapeBlock.buildShapeTable(STRAIGHT_SHAPE, INNER_SHAPE, OUTER_SHAPE);

	/**
	 * 
	 * @param properties
	 */
	public CrownMoldingBlock(Properties properties) {
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
		return block instanceof CrownMoldingBlock;
	}
}

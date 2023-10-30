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
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

// TODO changed to NonCubeFacingBlock
/**
 * @author Mark Gottschling on Oct 27, 2023
 */
public class SewerBlock extends NonCubeFacingBlock {
    /*
     * set the boundaries of the block slightly smaller than full
     * so that it is not a full block and other block faces around it
     * will render. i'm sure there is an actual property for this
     * but i haven't found it yet. forceSolidOff() doesn't seem to work.
     */
    private static final VoxelShape AABB = Block.box(0.0D, 0.0D, 0.0D, 15.99D, 15.99D, 15.99D);

    private static final VoxelShape BOTTOM = Block.box(0D, 0D, 0D, 16D, 11D, 16D);
    private static final VoxelShape NORTH_SOUTH_SHAPE = Shapes.or(
            BOTTOM,
            Block.box(13, 0, 0, 16, 16, 16), //east
            Block.box(0, 0, 0, 3, 16, 16) // west
    );
    private static final VoxelShape EAST_WEST_SHAPE = Shapes.or(
            BOTTOM,
            Block.box(0, 0, 13, 16, 16, 16), //east
            Block.box(0, 0, 0, 16, 16, 3) // west
    );
    public SewerBlock(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
//        return AABB;
        Direction direction = state.getValue(FACING);

        return switch (direction) {
            case NORTH, SOUTH -> NORTH_SOUTH_SHAPE;
            case EAST, WEST -> EAST_WEST_SHAPE;
            default -> AABB;
        };
    }

    @Override
    public VoxelShape getVisualShape(BlockState state, BlockGetter getter, BlockPos pos_, CollisionContext context) {
        return Shapes.empty();
    }
}

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
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.ArrayList;
import java.util.List;
import java.util.function.ToIntFunction;

/**
 * Four pillar candles of mixed heights in one cell, burnt down unevenly, the tallest at the back. A
 * group of them in one block, for where a scatter of Large Candles would take a whole floor.
 *
 * <p>The model is blockbench/candle_cluster.bbmodel; CANDLES must match CANDLE_CLUSTER in
 * tools/gen_bbmodels.py.
 *
 * @author Mark Gottschling on 10/22/2026
 */
public class CandleClusterBlock extends CandlePropBlock {
    /** Each candle: centre x, centre z, width, height, wick height, in pixels. */
    private static final int[][] CANDLES = {{4, 10, 4, 12, 2}, {11, 11, 4, 8, 2}, {8, 5, 4, 5, 1}, {12, 4, 2, 3, 1}};
    public static final ToIntFunction<BlockState> LIGHT_EMISSION = state -> state.getValue(LIT) ? 13 : 0;

    private static final VoxelShape SHAPE;
    private static final List<Vec3> FLAMES = new ArrayList<>();

    static {
        VoxelShape shape = Shapes.empty();
        for (int[] c : CANDLES) {
            double half = c[2] / 2.0;
            shape = Shapes.or(shape, Block.box(c[0] - half, 0, c[1] - half, c[0] + half, c[3], c[1] + half));
            FLAMES.add(new Vec3(c[0] / 16.0, (c[3] + c[4] + 1) / 16.0, c[1] / 16.0));
        }
        SHAPE = shape;
    }

    public CandleClusterBlock(Properties properties) {
        super(properties);
        registerDefaultState(stateDefinition.any().setValue(LIT, false).setValue(WATERLOGGED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LIT, WATERLOGGED);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return placed(defaultBlockState(), context);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected Iterable<Vec3> getParticleOffsets(BlockState state) {
        return FLAMES;
    }
}

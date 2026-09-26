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

import mod.gottsch.forge.dungeonblocks.core.blockentity.SarcophagusBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * A two-block stone sarcophagus with a carved effigy on its lid. Right-click and the lid grinds
 * aside to show the tomb; right-click again and it slides back. A prop: it holds nothing.
 *
 * <p>The two-block placement and breaking are the slab table's, reused as they are: FOOT where the
 * player clicked, HEAD one block further in the direction they faced, and whichever half breaks
 * takes the other with it.
 *
 * <p>THE LID is drawn the way a chest's is: never baked into the block, always by
 * {@code SarcophagusRenderer}. The block's model is the body alone. A click only flips OPEN; each
 * client sees the change and animates the lid to its new position, from wherever it is, so a
 * click mid-slide reverses it smoothly. Nothing ticks, on either side.
 *
 * <p>Two earlier designs were rejected in game. Stepping through five baked lid frames on
 * scheduled ticks read as choppy. Baking the lid in at rest and handing it to the renderer only
 * while it moved flickered at both hand-offs: the renderer starts and stops drawing on the very
 * frame the state changes, but the chunk re-mesh that adds or removes the baked lid lands a frame
 * or more later.
 */
public class SarcophagusBlock extends SlabTableBlock implements EntityBlock {
    public static final BooleanProperty OPEN = BlockStateProperties.OPEN;
    /** How long the lid takes to slide, in ticks. */
    public static final int MOVE_TICKS = 12;

    private static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 14, 16);

    public SarcophagusBlock(Properties properties) {
        super(properties);
        // Explicitly closed. The slab table's constructor builds the default from
        // stateDefinition.any(), which takes every property's FIRST value - and a boolean's first
        // value is true, so left to that every sarcophagus would be placed open.
        registerDefaultState(defaultBlockState().setValue(OPEN, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(OPEN);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new SarcophagusBlockEntity(pos, state);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide) {
            boolean open = !state.getValue(OPEN);
            level.setBlock(pos, state.setValue(OPEN, open), 2);
            BlockPos otherPos = pos.relative(towardOtherHalf(state));
            BlockState other = level.getBlockState(otherPos);
            if (other.is(this)) {
                level.setBlock(otherPos, other.setValue(OPEN, open), 2);
            }
            level.playSound(null, pos, SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS, 0.8F, 0.5F);
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
    }
}

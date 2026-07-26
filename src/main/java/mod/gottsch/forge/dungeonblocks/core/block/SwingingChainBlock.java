/*
 * This file is part of  DungeonBlocks.
 * Copyright (c) 2026 Mark Gottschling (gottsch)
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

import mod.gottsch.forge.dungeonblocks.core.blockentity.ModBlockEntityTypes;
import mod.gottsch.forge.dungeonblocks.core.blockentity.SwingingChainBlockEntity;
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
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

/**
 * A decorative chain that hangs from this block and sways — gently on its own, and properly when
 * something walks through it.
 *
 * <p><b>One anchor, many segments.</b> The whole chain is this single block plus its
 * {@link SwingingChainBlockEntity}; {@link #LENGTH} says how many blocks it hangs down, and the
 * renderer draws that many segments. The blocks below stay empty. That keeps the chain to one
 * BlockEntity, one collision scan and one piece of swing state no matter how long it is, and lets a
 * structure place a whole chain with a single {@code dungeonblocks:swinging_chain[length=5]} — no
 * BlockEntity NBT required.
 *
 * <p>The trade-off is that only the anchor block is targetable: the lower segments are visual only,
 * so you break and select the chain at the top.
 *
 * <p>Right-click to cycle the length.
 *
 * @author Mark Gottschling on Jul 26, 2026
 */
public class SwingingChainBlock extends Block implements EntityBlock {

	public static final int MIN_LENGTH = 1;
	public static final int MAX_LENGTH = 8;
	public static final IntegerProperty LENGTH = IntegerProperty.create("length", MIN_LENGTH, MAX_LENGTH);

	private static final int DEFAULT_LENGTH = 3;

	// matches vanilla chain's 3px-wide core, so the highlight box sits on the links
	private static final VoxelShape SHAPE = Block.box(6.5D, 0.0D, 6.5D, 9.5D, 16.0D, 9.5D);

	public SwingingChainBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(LENGTH, DEFAULT_LENGTH));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(LENGTH);
	}

	/**
	 * The chain is drawn entirely by {@code SwingingChainRenderer} — it swings, so it can't be baked
	 * into the chunk mesh. Same approach vanilla takes for the end gateway.
	 */
	@Override
	public RenderShape getRenderShape(BlockState state) {
		return RenderShape.INVISIBLE;
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return SHAPE;
	}

	/** Walk-through: you're meant to be able to push through a chain, which is what makes it swing. */
	@Override
	public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return net.minecraft.world.phys.shapes.Shapes.empty();
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter level, BlockPos pos) {
		return true;
	}

	@Override
	public boolean isPathfindable(BlockState state, BlockGetter level, BlockPos pos, PathComputationType type) {
		return true;
	}

	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand,
			BlockHitResult hit) {
		int next = state.getValue(LENGTH) + 1;
		if (next > MAX_LENGTH) {
			next = MIN_LENGTH;
		}
		if (!level.isClientSide) {
			level.setBlock(pos, state.setValue(LENGTH, next), Block.UPDATE_ALL);
			level.playSound(null, pos, SoundEvents.CHAIN_PLACE, SoundSource.BLOCKS,
					0.6F, 0.9F + level.getRandom().nextFloat() * 0.2F);
		}
		return InteractionResult.sidedSuccess(level.isClientSide);
	}

	@Nullable
	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new SwingingChainBlockEntity(pos, state);
	}

	@Nullable
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state,
			net.minecraft.world.level.block.entity.BlockEntityType<T> type) {
		// server only: the client never runs the collision scan, it just renders from the synced impulse
		if (level.isClientSide) {
			return null;
		}
		return createTickerHelper(type, ModBlockEntityTypes.SWINGING_CHAIN.get(),
				SwingingChainBlockEntity::serverTick);
	}

	@SuppressWarnings("unchecked")
	@Nullable
	private static <E extends BlockEntity, A extends BlockEntity> BlockEntityTicker<A> createTickerHelper(
			net.minecraft.world.level.block.entity.BlockEntityType<A> actual,
			net.minecraft.world.level.block.entity.BlockEntityType<E> expected,
			BlockEntityTicker<? super E> ticker) {
		return expected == actual ? (BlockEntityTicker<A>) ticker : null;
	}
}

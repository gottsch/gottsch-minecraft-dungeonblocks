package mod.gottsch.forge.dungeonblocks.core.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.function.ToIntFunction;

public class BrazierBlock extends Block implements SimpleWaterloggedBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    /**
     * Which fire is burning. Only meaningful while {@link #LIT}; an unlit brazier is always
     * soul=false so there is exactly one canonical unlit state.
     */
    public static final BooleanProperty SOUL = BooleanProperty.create("soul");

    public static final ToIntFunction<BlockState> LIGHT_EMISSION = (state) -> {
        if (!state.getValue(LIT)) {
            return 0;
        }
        return state.getValue(SOUL) ? 10 : 15;
    };

    protected static final VoxelShape AABB = Block.box(2D, 4D, 2D, 14D, 15D, 14D);

    public BrazierBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(LIT, Boolean.valueOf(false)).setValue(SOUL, Boolean.valueOf(false))
                .setValue(WATERLOGGED, Boolean.valueOf(false)));

    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition((builder));
        builder.add(LIT).add(SOUL).add(WATERLOGGED);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockPos = context.getClickedPos();
        FluidState fluidState = context.getLevel().getFluidState(blockPos);

        return this.defaultBlockState()
                .setValue(LIT, Boolean.valueOf(false))
                .setValue(SOUL, Boolean.valueOf(false))
                .setValue(WATERLOGGED, Boolean.valueOf(fluidState.getType() == Fluids.WATER));
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (player.getAbilities().mayBuild && player.getItemInHand(hand).isEmpty() && state.getValue(LIT)) {
            extinguish(player, state, level, pos);
            return InteractionResult.sidedSuccess(level.isClientSide);
        } else if (player.getAbilities().mayBuild &&
                (player.getItemInHand(hand).is(Blocks.TORCH.asItem()) ||
                        player.getItemInHand(hand).is(Blocks.SOUL_TORCH.asItem()) ||
                        player.getItemInHand(hand).is(Items.FLINT_AND_STEEL))
                && !state.getValue(LIT)
                && !state.getValue(WATERLOGGED)
        ) {
            // the igniter decides the fire: only a soul torch burns soul fire.
            boolean soul = player.getItemInHand(hand).is(Blocks.SOUL_TORCH.asItem());
            setLit(level, state, pos, true, soul);
            level.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
            if (player.getItemInHand(hand).is(Items.FLINT_AND_STEEL)) {
                player.getItemInHand(hand).hurtAndBreak(1, player, (p) -> {
                    p.broadcastBreakEvent(hand);
                });
            }
            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            return InteractionResult.PASS;
        }
    }

    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        if (state.getValue(LIT)) {
            if (random.nextInt(10) == 0) {
                level.playLocalSound((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, SoundEvents.CAMPFIRE_CRACKLE, SoundSource.BLOCKS, 0.5F + random.nextFloat(), random.nextFloat() * 0.7F + 0.6F, false);
                level.addParticle(ParticleTypes.SMOKE, (double)pos.getX() + 0.5D + random.nextDouble() / 4.0D * (double)(random.nextBoolean() ? 1 : -1), (double)pos.getY() + 0.4D, (double)pos.getZ() + 0.5D + random.nextDouble() / 4.0D * (double)(random.nextBoolean() ? 1 : -1), 0.0D, 0.005D, 0.0D);
            }

            if (random.nextInt(5) == 0) {
                for(int i = 0; i < random.nextInt(1) + 1; ++i) {
                    if (state.getValue(SOUL)) {
                        // soul flames rise in place instead of arcing outward like lava spits
                        level.addParticle(ParticleTypes.SOUL_FIRE_FLAME, (double)pos.getX() + 0.5D + (random.nextDouble() - 0.5D) / 3.0D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D + (random.nextDouble() - 0.5D) / 3.0D, 0.0D, 5.0E-5D, 0.0D);
                    } else {
                        level.addParticle(ParticleTypes.LAVA, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, (double)(random.nextFloat() / 2.0F), 5.0E-5D, (double)(random.nextFloat() / 2.0F));
                    }
                }
            }

        }
    }

    public VoxelShape getShape(BlockState p_153474_, BlockGetter p_153475_, BlockPos p_153476_, CollisionContext p_153477_) {
        return AABB;
    }

    @Override
    public boolean placeLiquid(LevelAccessor level, BlockPos pos, BlockState state, FluidState fluidState) {
        if (!state.getValue(WATERLOGGED) && fluidState.getType() == Fluids.WATER) {
            boolean wasLit = state.getValue(LIT);
            // one setBlock carries the waterlogging and the drowning of the fire together
            level.setBlock(pos, state.setValue(WATERLOGGED, Boolean.valueOf(true))
                    .setValue(LIT, Boolean.valueOf(false))
                    .setValue(SOUL, Boolean.valueOf(false)), 3);
            level.scheduleTick(pos, fluidState.getType(), fluidState.getType().getTickDelay(level));
            if (wasLit) {
                level.playSound((Player)null, pos, SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS, 1.0F, 1.0F);
                level.gameEvent((Entity)null, GameEvent.BLOCK_CHANGE, pos);
            }
            return true;
        }
        return false;
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) {
            level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }
        return super.updateShape(state, direction, neighborState, level, pos, neighborPos);
    }

    @Override
    public FluidState getFluidState(BlockState blockState) {
        return blockState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
    }

    public static boolean isLit(BlockState state) {
        return state.hasProperty(LIT) && state.getValue(LIT);
    }

    protected boolean canBeLit(BlockState state) {
        return state.hasProperty(LIT) && !state.getValue(LIT);
    }

    public static void extinguish(@Nullable Player player, BlockState state, LevelAccessor level, BlockPos pos) {
        setLit(level, state, pos, false, false);
        level.playSound((Player)null, pos, SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS, 1.0F, 1.0F);
        level.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
    }

    private static void setLit(LevelAccessor level, BlockState state, BlockPos pos, boolean isLit, boolean isSoul) {
        level.setBlock(pos, state.setValue(LIT, Boolean.valueOf(isLit)).setValue(SOUL, Boolean.valueOf(isSoul)), 11);
    }
}

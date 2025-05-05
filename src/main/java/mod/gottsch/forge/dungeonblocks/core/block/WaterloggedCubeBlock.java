package mod.gottsch.forge.dungeonblocks.core.block;

import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class WaterloggedCubeBlock extends Block implements SimpleWaterloggedBlock {
   public static final BooleanProperty WATERLOGGED;
   private static final VoxelShape DEFAULT_SHAPE;

   public WaterloggedCubeBlock(Properties properties) {
      super(properties);
      this.registerDefaultState((BlockState)this.defaultBlockState().setValue(WATERLOGGED, false));
   }

   public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
      return DEFAULT_SHAPE;
   }

   @Nullable
   public BlockState getStateForPlacement(BlockPlaceContext p_311201_) {
      FluidState fluidstate = p_311201_.getLevel().getFluidState(p_311201_.getClickedPos());
      return (BlockState)super.getStateForPlacement(p_311201_).setValue(WATERLOGGED, fluidstate.is(Fluids.WATER));
   }

   public BlockState updateShape(BlockState state, Direction direction, BlockState state1, LevelAccessor levelAccessor, BlockPos p_310038_, BlockPos p_309617_) {
      if ((Boolean)state.getValue(WATERLOGGED)) {
         levelAccessor.scheduleTick(p_310038_, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
      }

      return super.updateShape(state, direction, state1, levelAccessor, p_310038_, p_309617_);
   }

   public FluidState getFluidState(BlockState state) {
      return (Boolean)state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
   }

   protected void createBlockStateDefinition(Builder<Block, BlockState> stateBuilder) {
      stateBuilder.add(new Property[]{WATERLOGGED});
   }

   static {
      WATERLOGGED = BlockStateProperties.WATERLOGGED;
      DEFAULT_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 15.99D, 15.99D, 15.99D);
   }
}

package mod.gottsch.forge.dungeonblocks.core.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.WeatheringCopper.WeatherState;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class WeatheringCopperTrapDoorBlock extends TrapDoorBlock implements WeatheringCopper {
   private final WeatherState weatherState;

   public WeatheringCopperTrapDoorBlock(WeatherState weatherState, Properties properties) {
      super(properties, BlockSetType.DARK_OAK);
      this.weatherState = weatherState;
   }

   public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource randomSource) {
      this.onRandomTick(state, level, pos, randomSource);
   }

   public boolean isRandomlyTicking(BlockState state) {
      return WeatheringCopper.getNext(state.getBlock()).isPresent();
   }

   public WeatherState getAge() {
      return this.weatherState;
   }
}

package mod.gottsch.forge.dungeonblocks.core.block;

import mod.gottsch.forge.gottschcore.block.FacingBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * @author Mark Gottschling on Nov 6, 2023
 *
 */
public class KeystoneBlock extends FacingBlock {

    public KeystoneBlock(Properties properties) {
        super(properties);
    }

}

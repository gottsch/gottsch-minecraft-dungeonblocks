/**
 * 
 */
package com.someguyssoftware.dungeonblocks.block;

import java.util.Random;

import com.someguyssoftware.gottschcore.block.FacingBlock;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * @author Mark Gottschling on Jan 18, 2020
 *
 */
public class SconceBlock extends FacingBlock {

	private static final VoxelShape NORTH_FACING_SHAPE = Block
			.makeCuboidShape(2.0D, 2.0D, 9.0D, 14.0D, 15.0D, 15.9999D);
	private static final VoxelShape EAST_FACING_SHAPE = Block
			.makeCuboidShape(0.0001D, 2.0D, 2.0D, 6.0D, 15.0D, 14.0D);
	private static final VoxelShape SOUTH_FACING_SHAPE = Block
			.makeCuboidShape(2.0D, 2.0D, 0.0001D, 14.0D, 15.0D, 6.0D);
	private static final VoxelShape WEST_FACING_SHAPE = Block
			.makeCuboidShape(9.0D, 2.0D, 2.0D, 15.9999D, 15.0D, 14.0D);

	public SconceBlock(String modID, String name, Properties properties) {
		super(modID, name, properties);
	}

	/**
	 * Called periodically clientside on blocks near the player to show effects
	 * (like furnace fire particles). Note that this method is unrelated to
	 * {@link randomTick} and {@link #needsRandomTick}, and will always be
	 * called regardless of whether the block can receive random update ticks
	 */
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState state, World worldIn, BlockPos pos,
			Random rand) {
		Direction direction = state.get(FACING);
		double d0 = (double) pos.getX() + 0.5D;
		double d1 = (double) pos.getY() + 0.7D;
		double d2 = (double) pos.getZ() + 0.5D;
		double d3 = 0.30D; // y offset
		double d4 = 0.22D; // horizontal offset middle
		double d5 = (double) pos.getX() + 0.25D;
		double d6 = (double) pos.getZ() + 0.25D;
		double d7 = (double) pos.getX() + 0.75D;
		double d8 = (double) pos.getZ() + 0.75D;
		double d9 = 0.27D; // horizontal offset for side torches

		if (direction.getAxis().isHorizontal()) {
			Direction directionFacing = direction.getOpposite();
			// middle
			worldIn.addParticle(ParticleTypes.SMOKE,
					d0 + d4 * (double) directionFacing.getXOffset(), d1 + d3,
					d2 + d4 * (double) directionFacing.getZOffset(), 0.0D, 0.0D,
					0.0D);
			worldIn.addParticle(ParticleTypes.FLAME,
					d0 + d4 * (double) directionFacing.getXOffset(), d1 + d3,
					d2 + d4 * (double) directionFacing.getZOffset(), 0.0D, 0.0D,
					0.0D);

			// right
			if (directionFacing.getXOffset() != 0) {
				worldIn.addParticle(ParticleTypes.SMOKE,
						d0 + d9 * (double) directionFacing.getXOffset(),
						d1 + d3,
						d6 + d9 * (double) directionFacing.getZOffset(), 0.0D,
						0.0D, 0.0D);
				worldIn.addParticle(ParticleTypes.FLAME,
						d0 + d9 * (double) directionFacing.getXOffset(),
						d1 + d3,
						d6 + d9 * (double) directionFacing.getZOffset(), 0.0D,
						0.0D, 0.0D);
			} else {
				worldIn.addParticle(ParticleTypes.SMOKE,
						d5 + d9 * (double) directionFacing.getXOffset(),
						d1 + d3,
						d2 + d9 * (double) directionFacing.getZOffset(), 0.0D,
						0.0D, 0.0D);
				worldIn.addParticle(ParticleTypes.FLAME,
						d5 + d9 * (double) directionFacing.getXOffset(),
						d1 + d3,
						d2 + d9 * (double) directionFacing.getZOffset(), 0.0D,
						0.0D, 0.0D);
			}

			// left
			if (directionFacing.getXOffset() != 0) {
				worldIn.addParticle(ParticleTypes.SMOKE,
						d0 + d4 * (double) directionFacing.getXOffset(),
						d1 + d3,
						d8 + d4 * (double) directionFacing.getZOffset(), 0.0D,
						0.0D, 0.0D);
				worldIn.addParticle(ParticleTypes.FLAME,
						d0 + d4 * (double) directionFacing.getXOffset(),
						d1 + d3,
						d8 + d4 * (double) directionFacing.getZOffset(), 0.0D,
						0.0D, 0.0D);
			} else {
				worldIn.addParticle(ParticleTypes.SMOKE,
						d7 + d4 * (double) directionFacing.getXOffset(),
						d1 + d3,
						d2 + d4 * (double) directionFacing.getZOffset(), 0.0D,
						0.0D, 0.0D);
				worldIn.addParticle(ParticleTypes.FLAME,
						d7 + d4 * (double) directionFacing.getXOffset(),
						d1 + d3,
						d2 + d4 * (double) directionFacing.getZOffset(), 0.0D,
						0.0D, 0.0D);
			}
		}
	}

	/**
	 * 
	 */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn,
			BlockPos pos, ISelectionContext context) {
		Direction direction = state.get(FACING);

		switch (direction) {
			case NORTH :
			default :
				return NORTH_FACING_SHAPE;
			case EAST :
				return EAST_FACING_SHAPE;
			case SOUTH :
				return SOUTH_FACING_SHAPE;
			case WEST :
				return WEST_FACING_SHAPE;
		}
	}
}

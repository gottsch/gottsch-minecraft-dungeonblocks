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
package mod.gottsch.forge.dungeonblocks.core.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

/**
 * A sarcophagus half's block entity, for SarcophagusRenderer to draw the lid from. It does not tick
 * and saves nothing.
 *
 * <p>Its fields are the client's animation state, and live on the client alone. The renderer
 * compares the block's OPEN with {@link #shownOpen} each frame; when they differ, a slide starts
 * from wherever the lid is drawn now. So nothing is synced beyond the ordinary block update that
 * carries OPEN.
 */
public class SarcophagusBlockEntity extends BlockEntity {
    /** Client only: the OPEN value the lid is animating toward; null until first drawn. */
    public Boolean shownOpen;
    /** Client only: where the current slide started, 0 (closed) to 1 (open). */
    public float slideFrom;
    /** Client only: game time (with partial tick) the current slide started. */
    public double moveStart = Double.NEGATIVE_INFINITY;
    /** Client only: where the lid was drawn last frame, 0 (closed) to 1 (open). */
    public float slide;

    public SarcophagusBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.SARCOPHAGUS.get(), pos, state);
    }

    /** The lid slides 10px aside, over the block's edge, so draw beyond the block's own bounds. */
    @Override
    public AABB getRenderBoundingBox() {
        return new AABB(worldPosition).inflate(1);
    }
}

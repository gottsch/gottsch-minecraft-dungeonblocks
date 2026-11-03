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

import mod.gottsch.forge.dungeonblocks.core.block.GiantChainAnchorBlock;
import mod.gottsch.forge.dungeonblocks.core.blockentity.client.GiantChainRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.LongTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/**
 * The chains fixed to a giant chain anchor: at most one running out to another anchor, and any
 * number arriving from others. Both ends know of a chain, so either can take it down when broken,
 * and either can draw it while the other is out of the loaded world. It does not tick, and has no
 * block entity renderer: {@link GiantChainRenderer} draws every chain in one pass.
 *
 * <p><b>Offsets, not positions, in the anchor's own frame.</b> A structure rotates and mirrors block
 * states but copies block entity data as it is, so a stored world offset would point the wrong way
 * in a turned room. Each offset is stored in the frame of the anchor's FACING and MIRRORED
 * properties, which the structure does turn, and turned to world space on reading
 * ({@link GiantChainAnchorBlock#toWorld}).
 *
 * @author Mark Gottschling on 11/03/2026
 */
public class GiantChainAnchorBlockEntity extends BlockEntity {
    /** The chain running out of this anchor, as an offset in the anchor's frame; null for none. */
    @Nullable
    private BlockPos out;
    /** The anchors whose chains end here, as offsets in this anchor's frame. */
    private final List<BlockPos> in = new ArrayList<>();

    public GiantChainAnchorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.GIANT_CHAIN_ANCHOR.get(), pos, state);
    }

    /** Where this anchor's own chain ends, in the world; null for none. */
    @Nullable
    public BlockPos getTarget() {
        return out == null ? null : worldPosition.offset(GiantChainAnchorBlock.toWorld(getBlockState(), out));
    }

    /** The anchors whose chains end here, in the world. */
    public List<BlockPos> getSources() {
        List<BlockPos> sources = new ArrayList<>(in.size());
        for (BlockPos offset : in) {
            sources.add(worldPosition.offset(GiantChainAnchorBlock.toWorld(getBlockState(), offset)));
        }
        return sources;
    }

    public boolean hasChains() {
        return out != null || !in.isEmpty();
    }

    public void setTarget(@Nullable BlockPos target) {
        out = target == null ? null : GiantChainAnchorBlock.toLocal(getBlockState(), target.subtract(worldPosition));
        changed();
    }

    public void addSource(BlockPos source) {
        BlockPos offset = GiantChainAnchorBlock.toLocal(getBlockState(), source.subtract(worldPosition));
        if (!in.contains(offset)) {
            in.add(offset);
            changed();
        }
    }

    public void removeSource(BlockPos source) {
        if (in.remove(GiantChainAnchorBlock.toLocal(getBlockState(), source.subtract(worldPosition)))) {
            changed();
        }
    }

    private void changed() {
        setChanged();
        if (level != null) {
            level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), Block.UPDATE_CLIENTS);
        }
    }

    @Override
    public void onLoad() {
        super.onLoad();
        if (level == null) {
            return;
        }
        if (level.isClientSide) {
            DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> GiantChainRenderer.add(worldPosition));
        } else if (hasChains()) {
            // checked a tick later, by the block: the other end of a chain may have gone while this
            // one was unloaded, or a structure may have placed only half of one
            level.scheduleTick(worldPosition, getBlockState().getBlock(), 1);
        }
    }

    @Override
    public void setRemoved() {
        super.setRemoved();
        if (level != null && level.isClientSide) {
            DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> GiantChainRenderer.remove(worldPosition));
        }
    }

    @Override
    public void onChunkUnloaded() {
        super.onChunkUnloaded();
        if (level != null && level.isClientSide) {
            DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> GiantChainRenderer.remove(worldPosition));
        }
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        out = tag.contains("Out", Tag.TAG_LONG) ? BlockPos.of(tag.getLong("Out")) : null;
        in.clear();
        for (Tag offset : tag.getList("In", Tag.TAG_LONG)) {
            in.add(BlockPos.of(((LongTag) offset).getAsLong()));
        }
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        writeChains(tag);
    }

    private void writeChains(CompoundTag tag) {
        if (out != null) {
            tag.putLong("Out", out.asLong());
        }
        if (!in.isEmpty()) {
            ListTag list = new ListTag();
            in.forEach(offset -> list.add(LongTag.valueOf(offset.asLong())));
            tag.put("In", list);
        }
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    /** Both lists, always, so the client hears when a chain is gone. */
    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag tag = new CompoundTag();
        writeChains(tag);
        return tag;
    }
}

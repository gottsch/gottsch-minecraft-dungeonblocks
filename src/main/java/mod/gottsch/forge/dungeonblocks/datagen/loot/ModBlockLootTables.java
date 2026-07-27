/*
 * This file is part of  DungeonBlocks.
 * Copyright (c) 2023 Mark Gottschling (gottsch)
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
package mod.gottsch.forge.dungeonblocks.datagen.loot;

import mod.gottsch.forge.dungeonblocks.core.block.ModBlocks;
import mod.gottsch.forge.dungeonblocks.core.block.SkeletonBlock;
import mod.gottsch.forge.dungeonblocks.core.block.SlabTableBlock;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;
import java.util.stream.Stream;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        // every registered block-item drops itself. ModBlocks.MAP already excludes
        // blocks that are handled specially (mold, lichen, skeleton).
        ModBlocks.MAP.keySet().forEach(block -> {
            Block b = block.get();
            if (b instanceof SlabTableBlock) {
                // two blocks, one item: only the HEAD half carries the drop, exactly as vanilla beds
                // do. Breaking either half destroys the other, and the destroyed FOOT fails this
                // condition, so the pair yields exactly one table whichever end is broken.
                add(b, createSinglePropConditionTable(b, SlabTableBlock.PART, BedPart.HEAD));
            } else {
                dropSelf(b);
            }
        });

        // The skeleton is not in ModBlocks.MAP (its BlockItem is registered by hand as
        // ModItems.SKELETON), so the sweep above never reached it and it had no table at all -
        // placing one was a one-way trip. Same two-blocks-one-item shape as the slab table.
        Block skeleton = ModBlocks.SKELETON.get();
        add(skeleton, createSinglePropConditionTable(skeleton, SkeletonBlock.PART,
                SkeletonBlock.EnumPartType.BOTTOM));
    }

//    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
//        return createSilkTouchDispatchTable(pBlock,
//                this.applyExplosionDecay(pBlock,
//                        LootItem.lootTableItem(item)
//                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
//                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
//    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        // must match exactly the set of blocks handled in generate()
        return Stream.concat(
                ModBlocks.MAP.keySet().stream().map(RegistryObject::get),
                Stream.of(ModBlocks.SKELETON.get()))::iterator;
    }
}
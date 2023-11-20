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
import mod.gottsch.forge.dungeonblocks.core.setup.Registration;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    List<String> names = Arrays.asList(
            "barred_window",
            "brazier",
            "corbel",
//            "cornice",
//            "crown_molding",
//            "double_sill",
            "door",
            "lantern",
//            "facade",
//            "fluted",
            "grate",
            "keystone",
            "ledge",
            "plate_bracket",
//            "pillar",
//            "quarter",
            "sconce",
            "sewer",
//            "sill",
            "hay",
            "wall_ring");

    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        ModBlocks.MAP.forEach((k, v) -> {
            String name = k.getId().getPath();
            for(String n : names) {
                if (name.contains(n)) {
                    dropSelf(k.get());
                    break;
                }
            }
        });

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
        return Registration.BLOCKS.getEntries().stream()
                // only process these block
                .filter(b -> {
                    String name = b.getId().getPath();
                    for(String n : names) {
                        if (name.contains(n)) {
                            return true;
                        }
                    }
                    return false;
                    })
                .map(RegistryObject::get)::iterator;
    }
}
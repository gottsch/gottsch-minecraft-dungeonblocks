/*
 * This file is part of  Dungeon Blocks.
 * Copyright (c) 2023 Mark Gottschling (gottsch)
 *
 * All rights reserved.
 *
 * Dungeon Blocks is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Dungeon Blocks is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Dungeon Blocks.  If not, see <http://www.gnu.org/licenses/lgpl>.
 */
package mod.gottsch.forge.dungeonblocks.datagen;

import mod.gottsch.forge.dungeonblocks.DungeonBlocks;
import mod.gottsch.forge.dungeonblocks.core.block.KeystoneBlocks;
import mod.gottsch.forge.dungeonblocks.core.block.ModBlocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.RegistryObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  Requires instantiation as to not occupy memory when it is only used during data generation.
 * @author Mark Gottschling on Nov 17, 2023
 *
 */
public class DataGenMaps {
    // TODO make non-static
    public static Map<Block, List<RegistryObject<Block>>> m = new HashMap<>();
    public Map<Block, ResourceLocation> t = new HashMap<>();

    public DataGenMaps() {
        t.put(Blocks.STONE, mcLoc("block/stone"));
        t.put(Blocks.SMOOTH_STONE, mcLoc("block/smooth_stone"));
        t.put(Blocks.COBBLESTONE, mcLoc("block/cobblestone"));
        t.put(Blocks.MOSSY_COBBLESTONE, mcLoc("block/mossy_cobblestone"));
        t.put(Blocks.BRICKS, mcLoc("block/bricks"));
        t.put(Blocks.STONE_BRICKS, mcLoc("block/stone_bricks"));
        t.put(Blocks.MOSSY_STONE_BRICKS, mcLoc("block/mossy_stone_bricks"));
        t.put(Blocks.CRACKED_STONE_BRICKS, mcLoc("block/cracked_stone_bricks"));
        t.put(Blocks.CHISELED_STONE_BRICKS, mcLoc("block/chiseled_stone_bricks"));
        t.put(Blocks.OBSIDIAN, mcLoc("block/obsidian"));
        t.put(Blocks.LIGHT_GRAY_CONCRETE, mcLoc("block/stone"));

        t.put(Blocks.POLISHED_DIORITE, mcLoc("block/polished_diorite"));
    }

    public ResourceLocation modLoc(String name) {
        return new ResourceLocation(DungeonBlocks.MOD_ID, name);
    }

    public ResourceLocation mcLoc(String name) {
        return new ResourceLocation(name);
    }

    // TODO put into constructor
    static {
        m.put(Blocks.STONE, Arrays.asList(
                ModBlocks.STONE_GREEK_BLOCK,
                KeystoneBlocks.STONE_KEYSTONE,
                KeystoneBlocks.STONE_KEYSTONE_SLAB
//					ModBlocks.STONE_CORNICE
        ));
        m.put(Blocks.SMOOTH_STONE, Arrays.asList(
//					ModBlocks.SMOOTH_STONE_CORNICE
                KeystoneBlocks.SMOOTH_STONE_KEYSTONE,
                KeystoneBlocks.SMOOTH_STONE_KEYSTONE_SLAB
        ));
        m.put(Blocks.COBBLESTONE, Arrays.asList(
                KeystoneBlocks.COBBLESTONE_KEYSTONE,
                KeystoneBlocks.COBBLESTONE_KEYSTONE_SLAB
        ));
        m.put(Blocks.MOSSY_COBBLESTONE, Arrays.asList(
                KeystoneBlocks.MOSSY_COBBLESTONE_KEYSTONE,
                KeystoneBlocks.MOSSY_COBBLESTONE_KEYSTONE_SLAB
        ));
        m.put(Blocks.BRICKS, Arrays.asList(
                KeystoneBlocks.BRICKS_KEYSTONE,
                KeystoneBlocks.BRICKS_KEYSTONE_SLAB
        ));
        m.put(Blocks.STONE_BRICKS, Arrays.asList(
                KeystoneBlocks.STONE_BRICKS_KEYSTONE,
                KeystoneBlocks.STONE_BRICKS_KEYSTONE_SLAB
        ));
        m.put(Blocks.MOSSY_STONE_BRICKS, Arrays.asList(
                KeystoneBlocks.MOSSY_STONE_BRICKS_KEYSTONE,
                KeystoneBlocks.MOSSY_STONE_BRICKS_KEYSTONE_SLAB
        ));
        m.put(Blocks.CRACKED_STONE_BRICKS, Arrays.asList(
                KeystoneBlocks.CRACKED_STONE_BRICKS_KEYSTONE,
                KeystoneBlocks.CRACKED_STONE_BRICKS_KEYSTONE_SLAB
        ));
        m.put(Blocks.CHISELED_STONE_BRICKS, Arrays.asList(
                KeystoneBlocks.CHISELED_STONE_BRICKS_KEYSTONE,
                KeystoneBlocks.CHISELED_STONE_BRICKS_KEYSTONE_SLAB
        ));
        m.put(Blocks.OBSIDIAN, Arrays.asList(
                KeystoneBlocks.OBSIDIAN_KEYSTONE,
                KeystoneBlocks.OBSIDIAN_KEYSTONE_SLAB
        ));


        m.put(Blocks.ANDESITE, Arrays.asList(
                ModBlocks.ANDESITE_GREEK_BLOCK
        ));
        m.put(Blocks.POLISHED_DIORITE, Arrays.asList(
                KeystoneBlocks.POLISHED_DIORITE_KEYSTONE,
                KeystoneBlocks.POLISHED_DIORITE_KEYSTONE_SLAB
        ));

        // one-offs
        m.put(Blocks.TERRACOTTA, Arrays.asList(
                ModBlocks.TERRACOTTA_SEWER
        ));
        m.put(Blocks.POLISHED_BASALT, Arrays.asList(
                ModBlocks.POLISHED_BASALT_GREEK_BLOCK
        ));
        m.put(Blocks.LIGHT_GRAY_CONCRETE, Arrays.asList(
                KeystoneBlocks.LIGHT_GRAY_CONCRETE_KEYSTONE,
                KeystoneBlocks.LIGHT_GRAY_CONCRETE_KEYSTONE_SLAB
        ));
    }
}

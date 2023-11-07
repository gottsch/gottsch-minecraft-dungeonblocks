/*
 * This file is part of  DungeonBlocks.
 * Copyright (c) 2021 Mark Gottschling (gottsch)
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
package mod.gottsch.forge.dungeonblocks.core.block;

import mod.gottsch.forge.dungeonblocks.core.setup.Registration;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;

/**
 * @author Mark Gottschling on Nov 11, 2023
 */
public class KeystoneBlocks {

    public static RegistryObject<Block> POLISHED_DIORITE_KEYSTONE = Registration.BLOCKS.register("polished_diorite_keystone_block",
            () -> new KeystoneSlabBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_DIORITE)));

    public static RegistryObject<Block> STONE_KEYSTONE_SLAB = Registration.BLOCKS.register("stone_keystone_slab_block",
            () -> new KeystoneSlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)));
    public static RegistryObject<Block> SMOOTH_STONE_KEYSTONE_SLAB = Registration.BLOCKS.register("smooth_stone_keystone_slab_block",
            () -> new KeystoneSlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)));
    public static RegistryObject<Block> COBBLESTONE_KEYSTONE_SLAB = Registration.BLOCKS.register("cobblestone_keystone_slab_block",
            () -> new KeystoneSlabBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
    public static RegistryObject<Block> MOSSY_COBBLESTONE_KEYSTONE_SLAB = Registration.BLOCKS.register("mossy_cobblestone_keystone_slab_block",
            () -> new KeystoneSlabBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_COBBLESTONE)));
    public static RegistryObject<Block> BRICKS_KEYSTONE_SLAB = Registration.BLOCKS.register("bricks_keystone_slab_block",
            () -> new KeystoneSlabBlock(BlockBehaviour.Properties.copy(Blocks.BRICKS)));
    public static RegistryObject<Block> STONE_BRICKS_KEYSTONE_SLAB = Registration.BLOCKS.register("stone_bricks_keystone_slab_block",
            () -> new KeystoneSlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)));
    public static RegistryObject<Block> MOSSY_STONE_BRICKS_KEYSTONE_SLAB = Registration.BLOCKS.register("mossy_stone_bricks_keystone_slab_block",
            () -> new KeystoneSlabBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICKS)));
    public static RegistryObject<Block> LIGHT_GRAY_CONCRETE_KEYSTONE_SLAB = Registration.BLOCKS.register("light_gray_concrete_keystone_slab_block",
            () -> new KeystoneSlabBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_CONCRETE)));

}
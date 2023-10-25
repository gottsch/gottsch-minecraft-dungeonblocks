/*
 * This file is part of  DungeonBlocks.
 * Copyright (c) 2021, Mark Gottschling (gottsch)
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

import java.util.Map;

import com.google.common.collect.Maps;

import mod.gottsch.forge.dungeonblocks.core.config.DungeonBlocksConfig.BlockID;
import mod.gottsch.forge.dungeonblocks.core.setup.Registration;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.RegistryObject;

/**
 * @author Mark Gottschling on Jan 12, 2020
 *
 */
public class ModBlocks {

	/*
	 * blocks
	 */
	// facade blocks
	public static final RegistryObject<Block> STONE_FACADE;
	public static final RegistryObject<Block> SMOOTH_STONE_FACADE;
	public static final RegistryObject<Block> COBBLESTONE_FACADE;
	public static final RegistryObject<Block> MOSSY_COBBLESTONE_FACADE;
	public static final RegistryObject<Block> BRICKS_FACADE;
	public static final RegistryObject<Block> STONE_BRICKS_FACADE;
	public static final RegistryObject<Block> MOSSY_STONE_BRICKS_FACADE;
	public static final RegistryObject<Block> CRACKED_STONE_BRICKS_FACADE;
	public static final RegistryObject<Block> CHISELED_STONE_BRICKS_FACADE;
	public static final RegistryObject<Block> OBSIDIAN_FACADE;
	public static final RegistryObject<Block> SANDSTONE_FACADE;
	public static final RegistryObject<Block> SMOOTH_SANDSTONE_FACADE;
	public static final RegistryObject<Block> CHISELED_SANDSTONE_FACADE;
	public static final RegistryObject<Block> CUT_SANDSTONE_FACADE;
	public static final RegistryObject<Block> RED_SANDSTONE_FACADE;
	public static final RegistryObject<Block> SMOOTH_RED_SANDSTONE_FACADE;
	public static final RegistryObject<Block> CHISELED_RED_SANDSTONE_FACADE;
	public static final RegistryObject<Block> CUT_RED_SANDSTONE_FACADE;
	public static final RegistryObject<Block> GRANITE_FACADE;
	public static final RegistryObject<Block> POLISHED_GRANITE_FACADE;
	public static final RegistryObject<Block> DIORITE_FACADE;
	public static final RegistryObject<Block> POLISHED_DIORITE_FACADE;
	public static final RegistryObject<Block> ANDESITE_FACADE;
	public static final RegistryObject<Block> POLISHED_ANDESITE_FACADE;
	// 1.16/1.17/1.18
	public static final RegistryObject<Block> BLACKSTONE_FACADE;
	public static final RegistryObject<Block> POLISHED_BLACKSTONE_FACADE;
	public static final RegistryObject<Block> CHISELED_POLISHED_BLACKSTONE_FACADE;
	public static final RegistryObject<Block> GILDED_BLACKSTONE_FACADE;
	public static final RegistryObject<Block> POLISHED_BLACKSTONE_BRICKS_FACADE;
	public static final RegistryObject<Block> CRACKED_POLISHED_BLACKSTONE_BRICKS_FACADE;

	public static final RegistryObject<Block> DEEPSLATE_FACADE;
	public static final RegistryObject<Block> DEEPSLATE_BRICKS_FACADE;
	public static final RegistryObject<Block> CRACKED_DEEPSLATE_BRICKS_FACADE;
	public static final RegistryObject<Block> COBBLED_DEEPSLATE_FACADE;
	public static final RegistryObject<Block> POLISHED_DEEPSLATE_FACADE;
	public static final RegistryObject<Block> CHISELED_DEEPSLATE_FACADE;
	public static final RegistryObject<Block> DEEPSLATE_TILES_FACADE;
	public static final RegistryObject<Block> CRACKED_DEEPSLATE_TILES_FACADE;

	//	public static final RegistryObject<Block> TUFF_FACADE;
	//	public static final RegistryObject<Block> CALCITE;


	// quarter facade
	public static final RegistryObject<Block> STONE_QUARTER_FACADE;
	public static final RegistryObject<Block> SMOOTH_STONE_QUARTER_FACADE;
	public static final RegistryObject<Block> COBBLESTONE_QUARTER_FACADE;
	public static final RegistryObject<Block> MOSSY_COBBLESTONE_QUARTER_FACADE;
	public static final RegistryObject<Block> BRICKS_QUARTER_FACADE;
	public static final RegistryObject<Block> STONE_BRICKS_QUARTER_FACADE;
	public static final RegistryObject<Block> MOSSY_STONE_BRICKS_QUARTER_FACADE;
	public static final RegistryObject<Block> CRACKED_STONE_BRICKS_QUARTER_FACADE;
	public static final RegistryObject<Block> CHISELED_STONE_BRICKS_QUARTER_FACADE;
	public static final RegistryObject<Block> OBSIDIAN_QUARTER_FACADE;
	public static final RegistryObject<Block> SANDSTONE_QUARTER_FACADE;
	public static final RegistryObject<Block> SMOOTH_SANDSTONE_QUARTER_FACADE;
	public static final RegistryObject<Block> CHISELED_SANDSTONE_QUARTER_FACADE;
	public static final RegistryObject<Block> CUT_SANDSTONE_QUARTER_FACADE;
	public static final RegistryObject<Block> RED_SANDSTONE_QUARTER_FACADE;
	public static final RegistryObject<Block> SMOOTH_RED_SANDSTONE_QUARTER_FACADE;
	public static final RegistryObject<Block> CHISELED_RED_SANDSTONE_QUARTER_FACADE;
	public static final RegistryObject<Block> CUT_RED_SANDSTONE_QUARTER_FACADE;
	public static final RegistryObject<Block> GRANITE_QUARTER_FACADE;
	public static final RegistryObject<Block> POLISHED_GRANITE_QUARTER_FACADE;
	public static final RegistryObject<Block> DIORITE_QUARTER_FACADE;
	public static final RegistryObject<Block> POLISHED_DIORITE_QUARTER_FACADE;
	public static final RegistryObject<Block> ANDESITE_QUARTER_FACADE;
	public static final RegistryObject<Block> POLISHED_ANDESITE_QUARTER_FACADE;
	public static final RegistryObject<Block> BLACKSTONE_QUARTER_FACADE;
	public static final RegistryObject<Block> POLISHED_BLACKSTONE_QUARTER_FACADE;
	public static final RegistryObject<Block> CHISELED_POLISHED_BLACKSTONE_QUARTER_FACADE;
	public static final RegistryObject<Block> GILDED_BLACKSTONE_QUARTER_FACADE;
	public static final RegistryObject<Block> POLISHED_BLACKSTONE_BRICKS_QUARTER_FACADE;
	public static final RegistryObject<Block> CRACKED_POLISHED_BLACKSTONE_BRICKS_QUARTER_FACADE;
	public static final RegistryObject<Block> DEEPSLATE_QUARTER_FACADE;
	public static final RegistryObject<Block> DEEPSLATE_BRICKS_QUARTER_FACADE;
	public static final RegistryObject<Block> CRACKED_DEEPSLATE_BRICKS_QUARTER_FACADE;
	public static final RegistryObject<Block> COBBLED_DEEPSLATE_QUARTER_FACADE;
	public static final RegistryObject<Block> POLISHED_DEEPSLATE_QUARTER_FACADE;
	public static final RegistryObject<Block> CHISELED_DEEPSLATE_QUARTER_FACADE;
	public static final RegistryObject<Block> DEEPSLATE_TILES_QUARTER_FACADE;
	public static final RegistryObject<Block> CRACKED_DEEPSLATE_TILES_QUARTER_FACADE;

	// fluted
	public static final RegistryObject<Block> STONE_FLUTED;
	public static final RegistryObject<Block> SMOOTH_STONE_FLUTED;
	public static final RegistryObject<Block> COBBLESTONE_FLUTED;
	public static final RegistryObject<Block> MOSSY_COBBLESTONE_FLUTED;
	public static final RegistryObject<Block> BRICKS_FLUTED;
	public static final RegistryObject<Block> STONE_BRICKS_FLUTED;
	public static final RegistryObject<Block> MOSSY_STONE_BRICKS_FLUTED;
	public static final RegistryObject<Block> CRACKED_STONE_BRICKS_FLUTED;
	public static final RegistryObject<Block> CHISELED_STONE_BRICKS_FLUTED;
	public static final RegistryObject<Block> OBSIDIAN_FLUTED;
	public static final RegistryObject<Block> SANDSTONE_FLUTED;
	public static final RegistryObject<Block> SMOOTH_SANDSTONE_FLUTED;
	public static final RegistryObject<Block> CHISELED_SANDSTONE_FLUTED;
	public static final RegistryObject<Block> CUT_SANDSTONE_FLUTED;
	public static final RegistryObject<Block> RED_SANDSTONE_FLUTED;
	public static final RegistryObject<Block> SMOOTH_RED_SANDSTONE_FLUTED;
	public static final RegistryObject<Block> CHISELED_RED_SANDSTONE_FLUTED;
	public static final RegistryObject<Block> CUT_RED_SANDSTONE_FLUTED;
	public static final RegistryObject<Block> GRANITE_FLUTED;
	public static final RegistryObject<Block> POLISHED_GRANITE_FLUTED;
	public static final RegistryObject<Block> DIORITE_FLUTED;
	public static final RegistryObject<Block> POLISHED_DIORITE_FLUTED;
	public static final RegistryObject<Block> ANDESITE_FLUTED;
	public static final RegistryObject<Block> POLISHED_ANDESITE_FLUTED;
	public static final RegistryObject<Block> BLACKSTONE_FLUTED;
	public static final RegistryObject<Block> POLISHED_BLACKSTONE_FLUTED;
	public static final RegistryObject<Block> CHISELED_POLISHED_BLACKSTONE_FLUTED;
	public static final RegistryObject<Block> GILDED_BLACKSTONE_FLUTED;
	public static final RegistryObject<Block> POLISHED_BLACKSTONE_BRICKS_FLUTED;
	public static final RegistryObject<Block> CRACKED_POLISHED_BLACKSTONE_BRICKS_FLUTED;
	public static final RegistryObject<Block> DEEPSLATE_FLUTED;
	public static final RegistryObject<Block> DEEPSLATE_BRICKS_FLUTED;
	public static final RegistryObject<Block> CRACKED_DEEPSLATE_BRICKS_FLUTED;
	public static final RegistryObject<Block> COBBLED_DEEPSLATE_FLUTED;
	public static final RegistryObject<Block> POLISHED_DEEPSLATE_FLUTED;
	public static final RegistryObject<Block> CHISELED_DEEPSLATE_FLUTED;
	public static final RegistryObject<Block> DEEPSLATE_TILES_FLUTED;
	public static final RegistryObject<Block> CRACKED_DEEPSLATE_TILES_FLUTED;

	// fluted facade
	public static final RegistryObject<Block> STONE_FLUTED_FACADE;
	public static final RegistryObject<Block> SMOOTH_STONE_FLUTED_FACADE;
	public static final RegistryObject<Block> COBBLESTONE_FLUTED_FACADE;
	public static final RegistryObject<Block> MOSSY_COBBLESTONE_FLUTED_FACADE;
	public static final RegistryObject<Block> BRICKS_FLUTED_FACADE;
	public static final RegistryObject<Block> STONE_BRICKS_FLUTED_FACADE;
	public static final RegistryObject<Block> MOSSY_STONE_BRICKS_FLUTED_FACADE;
	public static final RegistryObject<Block> CRACKED_STONE_BRICKS_FLUTED_FACADE;
	public static final RegistryObject<Block> CHISELED_STONE_BRICKS_FLUTED_FACADE;
	public static final RegistryObject<Block> OBSIDIAN_FLUTED_FACADE;
	public static final RegistryObject<Block> SANDSTONE_FLUTED_FACADE;
	public static final RegistryObject<Block> SMOOTH_SANDSTONE_FLUTED_FACADE;
	public static final RegistryObject<Block> CHISELED_SANDSTONE_FLUTED_FACADE;
	public static final RegistryObject<Block> CUT_SANDSTONE_FLUTED_FACADE;
	public static final RegistryObject<Block> RED_SANDSTONE_FLUTED_FACADE;
	public static final RegistryObject<Block> SMOOTH_RED_SANDSTONE_FLUTED_FACADE;
	public static final RegistryObject<Block> CHISELED_RED_SANDSTONE_FLUTED_FACADE;
	public static final RegistryObject<Block> CUT_RED_SANDSTONE_FLUTED_FACADE;
	public static final RegistryObject<Block> GRANITE_FLUTED_FACADE;
	public static final RegistryObject<Block> POLISHED_GRANITE_FLUTED_FACADE;
	public static final RegistryObject<Block> DIORITE_FLUTED_FACADE;
	public static final RegistryObject<Block> POLISHED_DIORITE_FLUTED_FACADE;
	public static final RegistryObject<Block> ANDESITE_FLUTED_FACADE;
	public static final RegistryObject<Block> POLISHED_ANDESITE_FLUTED_FACADE;
	public static final RegistryObject<Block> BLACKSTONE_FLUTED_FACADE;
	public static final RegistryObject<Block> POLISHED_BLACKSTONE_FLUTED_FACADE;
	public static final RegistryObject<Block> CHISELED_POLISHED_BLACKSTONE_FLUTED_FACADE;
	public static final RegistryObject<Block> GILDED_BLACKSTONE_FLUTED_FACADE;
	public static final RegistryObject<Block> POLISHED_BLACKSTONE_BRICKS_FLUTED_FACADE;
	public static final RegistryObject<Block> CRACKED_POLISHED_BLACKSTONE_BRICKS_FLUTED_FACADE;
	public static final RegistryObject<Block> DEEPSLATE_FLUTED_FACADE;
	public static final RegistryObject<Block> DEEPSLATE_BRICKS_FLUTED_FACADE;
	public static final RegistryObject<Block> CRACKED_DEEPSLATE_BRICKS_FLUTED_FACADE;
	public static final RegistryObject<Block> COBBLED_DEEPSLATE_FLUTED_FACADE;
	public static final RegistryObject<Block> POLISHED_DEEPSLATE_FLUTED_FACADE;
	public static final RegistryObject<Block> CHISELED_DEEPSLATE_FLUTED_FACADE;
	public static final RegistryObject<Block> DEEPSLATE_TILES_FLUTED_FACADE;
	public static final RegistryObject<Block> CRACKED_DEEPSLATE_TILES_FLUTED_FACADE;


	// sill
	public static final RegistryObject<Block> STONE_SILL;
	public static final RegistryObject<Block> SMOOTH_STONE_SILL;
	public static final RegistryObject<Block> COBBLESTONE_SILL;
	public static final RegistryObject<Block> MOSSY_COBBLESTONE_SILL;
	public static final RegistryObject<Block> BRICKS_SILL;
	public static final RegistryObject<Block> STONE_BRICKS_SILL;
	public static final RegistryObject<Block> MOSSY_STONE_BRICKS_SILL;
	public static final RegistryObject<Block> CRACKED_STONE_BRICKS_SILL;
	public static final RegistryObject<Block> CHISELED_STONE_BRICKS_SILL;
	public static final RegistryObject<Block> OBSIDIAN_SILL;
	public static final RegistryObject<Block> SANDSTONE_SILL;
	public static final RegistryObject<Block> SMOOTH_SANDSTONE_SILL;
	public static final RegistryObject<Block> CHISELED_SANDSTONE_SILL;
	public static final RegistryObject<Block> CUT_SANDSTONE_SILL;
	public static final RegistryObject<Block> RED_SANDSTONE_SILL;
	public static final RegistryObject<Block> SMOOTH_RED_SANDSTONE_SILL;
	public static final RegistryObject<Block> CHISELED_RED_SANDSTONE_SILL;
	public static final RegistryObject<Block> CUT_RED_SANDSTONE_SILL;
	public static final RegistryObject<Block> GRANITE_SILL;
	public static final RegistryObject<Block> POLISHED_GRANITE_SILL;
	public static final RegistryObject<Block> DIORITE_SILL;
	public static final RegistryObject<Block> POLISHED_DIORITE_SILL;
	public static final RegistryObject<Block> ANDESITE_SILL;
	public static final RegistryObject<Block> POLISHED_ANDESITE_SILL;
	public static final RegistryObject<Block> BLACKSTONE_SILL;
	public static final RegistryObject<Block> POLISHED_BLACKSTONE_SILL;
	public static final RegistryObject<Block> CHISELED_POLISHED_BLACKSTONE_SILL;
	public static final RegistryObject<Block> GILDED_BLACKSTONE_SILL;
	public static final RegistryObject<Block> POLISHED_BLACKSTONE_BRICKS_SILL;
	public static final RegistryObject<Block> CRACKED_POLISHED_BLACKSTONE_BRICKS_SILL;
	public static final RegistryObject<Block> DEEPSLATE_SILL;
	public static final RegistryObject<Block> DEEPSLATE_BRICKS_SILL;
	public static final RegistryObject<Block> CRACKED_DEEPSLATE_BRICKS_SILL;
	public static final RegistryObject<Block> COBBLED_DEEPSLATE_SILL;
	public static final RegistryObject<Block> POLISHED_DEEPSLATE_SILL;
	public static final RegistryObject<Block> CHISELED_DEEPSLATE_SILL;
	public static final RegistryObject<Block> DEEPSLATE_TILES_SILL;
	public static final RegistryObject<Block> CRACKED_DEEPSLATE_TILES_SILL;

	// double sill
	public static final RegistryObject<Block> STONE_DOUBLE_SILL;
	public static final RegistryObject<Block> SMOOTH_STONE_DOUBLE_SILL;
	public static final RegistryObject<Block> COBBLESTONE_DOUBLE_SILL;
	public static final RegistryObject<Block> MOSSY_COBBLESTONE_DOUBLE_SILL;
	public static final RegistryObject<Block> BRICKS_DOUBLE_SILL;
	public static final RegistryObject<Block> STONE_BRICKS_DOUBLE_SILL;
	public static final RegistryObject<Block> MOSSY_STONE_BRICKS_DOUBLE_SILL;
	public static final RegistryObject<Block> CRACKED_STONE_BRICKS_DOUBLE_SILL;
	public static final RegistryObject<Block> CHISELED_STONE_BRICKS_DOUBLE_SILL;
	public static final RegistryObject<Block> OBSIDIAN_DOUBLE_SILL;
	public static final RegistryObject<Block> SANDSTONE_DOUBLE_SILL;
	public static final RegistryObject<Block> SMOOTH_SANDSTONE_DOUBLE_SILL;
	public static final RegistryObject<Block> CHISELED_SANDSTONE_DOUBLE_SILL;
	public static final RegistryObject<Block> CUT_SANDSTONE_DOUBLE_SILL;
	public static final RegistryObject<Block> RED_SANDSTONE_DOUBLE_SILL;
	public static final RegistryObject<Block> SMOOTH_RED_SANDSTONE_DOUBLE_SILL;
	public static final RegistryObject<Block> CHISELED_RED_SANDSTONE_DOUBLE_SILL;
	public static final RegistryObject<Block> CUT_RED_SANDSTONE_DOUBLE_SILL;
	public static final RegistryObject<Block> GRANITE_DOUBLE_SILL;
	public static final RegistryObject<Block> POLISHED_GRANITE_DOUBLE_SILL;
	public static final RegistryObject<Block> DIORITE_DOUBLE_SILL;
	public static final RegistryObject<Block> POLISHED_DIORITE_DOUBLE_SILL;
	public static final RegistryObject<Block> ANDESITE_DOUBLE_SILL;
	public static final RegistryObject<Block> POLISHED_ANDESITE_DOUBLE_SILL;
	public static final RegistryObject<Block> BLACKSTONE_DOUBLE_SILL;
	public static final RegistryObject<Block> POLISHED_BLACKSTONE_DOUBLE_SILL;
	public static final RegistryObject<Block> CHISELED_POLISHED_BLACKSTONE_DOUBLE_SILL;
	public static final RegistryObject<Block> GILDED_BLACKSTONE_DOUBLE_SILL;
	public static final RegistryObject<Block> POLISHED_BLACKSTONE_BRICKS_DOUBLE_SILL;
	public static final RegistryObject<Block> CRACKED_POLISHED_BLACKSTONE_BRICKS_DOUBLE_SILL;
	public static final RegistryObject<Block> DEEPSLATE_DOUBLE_SILL;
	public static final RegistryObject<Block> DEEPSLATE_BRICKS_DOUBLE_SILL;
	public static final RegistryObject<Block> CRACKED_DEEPSLATE_BRICKS_DOUBLE_SILL;
	public static final RegistryObject<Block> COBBLED_DEEPSLATE_DOUBLE_SILL;
	public static final RegistryObject<Block> POLISHED_DEEPSLATE_DOUBLE_SILL;
	public static final RegistryObject<Block> CHISELED_DEEPSLATE_DOUBLE_SILL;
	public static final RegistryObject<Block> DEEPSLATE_TILES_DOUBLE_SILL;
	public static final RegistryObject<Block> CRACKED_DEEPSLATE_TILES_DOUBLE_SILL;

	// cornice
	public static final RegistryObject<Block> STONE_CORNICE;
	public static final RegistryObject<Block> SMOOTH_STONE_CORNICE;
	public static final RegistryObject<Block> COBBLESTONE_CORNICE;
	public static final RegistryObject<Block> MOSSY_COBBLESTONE_CORNICE;
	public static final RegistryObject<Block> BRICKS_CORNICE;
	public static final RegistryObject<Block> STONE_BRICKS_CORNICE;
	public static final RegistryObject<Block> MOSSY_STONE_BRICKS_CORNICE;
	public static final RegistryObject<Block> CRACKED_STONE_BRICKS_CORNICE;
	public static final RegistryObject<Block> CHISELED_STONE_BRICKS_CORNICE;
	public static final RegistryObject<Block> OBSIDIAN_CORNICE;
	public static final RegistryObject<Block> SANDSTONE_CORNICE;
	public static final RegistryObject<Block> SMOOTH_SANDSTONE_CORNICE;
	public static final RegistryObject<Block> CHISELED_SANDSTONE_CORNICE;
	public static final RegistryObject<Block> CUT_SANDSTONE_CORNICE;
	public static final RegistryObject<Block> RED_SANDSTONE_CORNICE;
	public static final RegistryObject<Block> SMOOTH_RED_SANDSTONE_CORNICE;
	public static final RegistryObject<Block> CHISELED_RED_SANDSTONE_CORNICE;
	public static final RegistryObject<Block> CUT_RED_SANDSTONE_CORNICE;
	public static final RegistryObject<Block> GRANITE_CORNICE;
	public static final RegistryObject<Block> POLISHED_GRANITE_CORNICE;
	public static final RegistryObject<Block> DIORITE_CORNICE;
	public static final RegistryObject<Block> POLISHED_DIORITE_CORNICE;
	public static final RegistryObject<Block> ANDESITE_CORNICE;
	public static final RegistryObject<Block> POLISHED_ANDESITE_CORNICE;
	public static final RegistryObject<Block> BLACKSTONE_CORNICE;
	public static final RegistryObject<Block> POLISHED_BLACKSTONE_CORNICE;
	public static final RegistryObject<Block> CHISELED_POLISHED_BLACKSTONE_CORNICE;
	public static final RegistryObject<Block> GILDED_BLACKSTONE_CORNICE;
	public static final RegistryObject<Block> POLISHED_BLACKSTONE_BRICKS_CORNICE;
	public static final RegistryObject<Block> CRACKED_POLISHED_BLACKSTONE_BRICKS_CORNICE;
	public static final RegistryObject<Block> DEEPSLATE_CORNICE;
	public static final RegistryObject<Block> DEEPSLATE_BRICKS_CORNICE;
	public static final RegistryObject<Block> CRACKED_DEEPSLATE_BRICKS_CORNICE;
	public static final RegistryObject<Block> COBBLED_DEEPSLATE_CORNICE;
	public static final RegistryObject<Block> POLISHED_DEEPSLATE_CORNICE;
	public static final RegistryObject<Block> CHISELED_DEEPSLATE_CORNICE;
	public static final RegistryObject<Block> DEEPSLATE_TILES_CORNICE;
	public static final RegistryObject<Block> CRACKED_DEEPSLATE_TILES_CORNICE;

	// crown molding
	public static final RegistryObject<Block> STONE_CROWN_MOLDING;
	public static final RegistryObject<Block> SMOOTH_STONE_CROWN_MOLDING;
	public static final RegistryObject<Block> COBBLESTONE_CROWN_MOLDING;
	public static final RegistryObject<Block> MOSSY_COBBLESTONE_CROWN_MOLDING;
	public static final RegistryObject<Block> BRICKS_CROWN_MOLDING;
	public static final RegistryObject<Block> STONE_BRICKS_CROWN_MOLDING;
	public static final RegistryObject<Block> MOSSY_STONE_BRICKS_CROWN_MOLDING;
	public static final RegistryObject<Block> CRACKED_STONE_BRICKS_CROWN_MOLDING;
	public static final RegistryObject<Block> CHISELED_STONE_BRICKS_CROWN_MOLDING;
	public static final RegistryObject<Block> OBSIDIAN_CROWN_MOLDING;
	public static final RegistryObject<Block> SANDSTONE_CROWN_MOLDING;
	public static final RegistryObject<Block> SMOOTH_SANDSTONE_CROWN_MOLDING;
	public static final RegistryObject<Block> CHISELED_SANDSTONE_CROWN_MOLDING;
	public static final RegistryObject<Block> CUT_SANDSTONE_CROWN_MOLDING;
	public static final RegistryObject<Block> RED_SANDSTONE_CROWN_MOLDING;
	public static final RegistryObject<Block> SMOOTH_RED_SANDSTONE_CROWN_MOLDING;
	public static final RegistryObject<Block> CHISELED_RED_SANDSTONE_CROWN_MOLDING;
	public static final RegistryObject<Block> CUT_RED_SANDSTONE_CROWN_MOLDING;
	public static final RegistryObject<Block> GRANITE_CROWN_MOLDING;
	public static final RegistryObject<Block> POLISHED_GRANITE_CROWN_MOLDING;
	public static final RegistryObject<Block> DIORITE_CROWN_MOLDING;
	public static final RegistryObject<Block> POLISHED_DIORITE_CROWN_MOLDING;
	public static final RegistryObject<Block> ANDESITE_CROWN_MOLDING;
	public static final RegistryObject<Block> POLISHED_ANDESITE_CROWN_MOLDING;
	public static final RegistryObject<Block> BLACKSTONE_CROWN_MOLDING;
	public static final RegistryObject<Block> POLISHED_BLACKSTONE_CROWN_MOLDING;
	public static final RegistryObject<Block> CHISELED_POLISHED_BLACKSTONE_CROWN_MOLDING;
	public static final RegistryObject<Block> GILDED_BLACKSTONE_CROWN_MOLDING;
	public static final RegistryObject<Block> POLISHED_BLACKSTONE_BRICKS_CROWN_MOLDING;
	public static final RegistryObject<Block> CRACKED_POLISHED_BLACKSTONE_BRICKS_CROWN_MOLDING;
	public static final RegistryObject<Block> DEEPSLATE_CROWN_MOLDING;
	public static final RegistryObject<Block> DEEPSLATE_BRICKS_CROWN_MOLDING;
	public static final RegistryObject<Block> CRACKED_DEEPSLATE_BRICKS_CROWN_MOLDING;
	public static final RegistryObject<Block> COBBLED_DEEPSLATE_CROWN_MOLDING;
	public static final RegistryObject<Block> POLISHED_DEEPSLATE_CROWN_MOLDING;
	public static final RegistryObject<Block> CHISELED_DEEPSLATE_CROWN_MOLDING;
	public static final RegistryObject<Block> DEEPSLATE_TILES_CROWN_MOLDING;
	public static final RegistryObject<Block> CRACKED_DEEPSLATE_TILES_CROWN_MOLDING;

	// pillar base
	public static final RegistryObject<Block> STONE_PILLAR_BASE;
	public static final RegistryObject<Block> SMOOTH_STONE_PILLAR_BASE;
	public static final RegistryObject<Block> COBBLESTONE_PILLAR_BASE;
	public static final RegistryObject<Block> MOSSY_COBBLESTONE_PILLAR_BASE;
	public static final RegistryObject<Block> BRICKS_PILLAR_BASE;
	public static final RegistryObject<Block> STONE_BRICKS_PILLAR_BASE;
	public static final RegistryObject<Block> MOSSY_STONE_BRICKS_PILLAR_BASE;
	public static final RegistryObject<Block> CRACKED_STONE_BRICKS_PILLAR_BASE;
	public static final RegistryObject<Block> CHISELED_STONE_BRICKS_PILLAR_BASE;
	public static final RegistryObject<Block> OBSIDIAN_PILLAR_BASE;
	public static final RegistryObject<Block> SANDSTONE_PILLAR_BASE;
	public static final RegistryObject<Block> SMOOTH_SANDSTONE_PILLAR_BASE;
	public static final RegistryObject<Block> CHISELED_SANDSTONE_PILLAR_BASE;
	public static final RegistryObject<Block> CUT_SANDSTONE_PILLAR_BASE;
	public static final RegistryObject<Block> RED_SANDSTONE_PILLAR_BASE;
	public static final RegistryObject<Block> SMOOTH_RED_SANDSTONE_PILLAR_BASE;
	public static final RegistryObject<Block> CHISELED_RED_SANDSTONE_PILLAR_BASE;
	public static final RegistryObject<Block> CUT_RED_SANDSTONE_PILLAR_BASE;
	public static final RegistryObject<Block> GRANITE_PILLAR_BASE;
	public static final RegistryObject<Block> POLISHED_GRANITE_PILLAR_BASE;
	public static final RegistryObject<Block> DIORITE_PILLAR_BASE;
	public static final RegistryObject<Block> POLISHED_DIORITE_PILLAR_BASE;
	public static final RegistryObject<Block> ANDESITE_PILLAR_BASE;
	public static final RegistryObject<Block> POLISHED_ANDESITE_PILLAR_BASE;
	public static final RegistryObject<Block> BLACKSTONE_PILLAR_BASE;
	public static final RegistryObject<Block> POLISHED_BLACKSTONE_PILLAR_BASE;
	public static final RegistryObject<Block> CHISELED_POLISHED_BLACKSTONE_PILLAR_BASE;
	public static final RegistryObject<Block> GILDED_BLACKSTONE_PILLAR_BASE;
	public static final RegistryObject<Block> POLISHED_BLACKSTONE_BRICKS_PILLAR_BASE;
	public static final RegistryObject<Block> CRACKED_POLISHED_BLACKSTONE_BRICKS_PILLAR_BASE;
	public static final RegistryObject<Block> DEEPSLATE_PILLAR_BASE;
	public static final RegistryObject<Block> DEEPSLATE_BRICKS_PILLAR_BASE;
	public static final RegistryObject<Block> CRACKED_DEEPSLATE_BRICKS_PILLAR_BASE;
	public static final RegistryObject<Block> COBBLED_DEEPSLATE_PILLAR_BASE;
	public static final RegistryObject<Block> POLISHED_DEEPSLATE_PILLAR_BASE;
	public static final RegistryObject<Block> CHISELED_DEEPSLATE_PILLAR_BASE;
	public static final RegistryObject<Block> DEEPSLATE_TILES_PILLAR_BASE;
	public static final RegistryObject<Block> CRACKED_DEEPSLATE_TILES_PILLAR_BASE;

	// pillar
	public static final RegistryObject<Block> STONE_PILLAR;
	public static final RegistryObject<Block> SMOOTH_STONE_PILLAR;
	public static final RegistryObject<Block> COBBLESTONE_PILLAR;
	public static final RegistryObject<Block> MOSSY_COBBLESTONE_PILLAR;
	public static final RegistryObject<Block> BRICKS_PILLAR;
	public static final RegistryObject<Block> STONE_BRICKS_PILLAR;
	public static final RegistryObject<Block> MOSSY_STONE_BRICKS_PILLAR;
	public static final RegistryObject<Block> CRACKED_STONE_BRICKS_PILLAR;
	public static final RegistryObject<Block> CHISELED_STONE_BRICKS_PILLAR;
	public static final RegistryObject<Block> OBSIDIAN_PILLAR;
	public static final RegistryObject<Block> SANDSTONE_PILLAR;
	public static final RegistryObject<Block> SMOOTH_SANDSTONE_PILLAR;
	public static final RegistryObject<Block> CHISELED_SANDSTONE_PILLAR;
	public static final RegistryObject<Block> CUT_SANDSTONE_PILLAR;
	public static final RegistryObject<Block> RED_SANDSTONE_PILLAR;
	public static final RegistryObject<Block> SMOOTH_RED_SANDSTONE_PILLAR;
	public static final RegistryObject<Block> CHISELED_RED_SANDSTONE_PILLAR;
	public static final RegistryObject<Block> CUT_RED_SANDSTONE_PILLAR;
	public static final RegistryObject<Block> GRANITE_PILLAR;
	public static final RegistryObject<Block> POLISHED_GRANITE_PILLAR;
	public static final RegistryObject<Block> DIORITE_PILLAR;
	public static final RegistryObject<Block> POLISHED_DIORITE_PILLAR;
	public static final RegistryObject<Block> ANDESITE_PILLAR;
	public static final RegistryObject<Block> POLISHED_ANDESITE_PILLAR;
	public static final RegistryObject<Block> BLACKSTONE_PILLAR;
	public static final RegistryObject<Block> POLISHED_BLACKSTONE_PILLAR;
	public static final RegistryObject<Block> CHISELED_POLISHED_BLACKSTONE_PILLAR;
	public static final RegistryObject<Block> GILDED_BLACKSTONE_PILLAR;
	public static final RegistryObject<Block> POLISHED_BLACKSTONE_BRICKS_PILLAR;
	public static final RegistryObject<Block> CRACKED_POLISHED_BLACKSTONE_BRICKS_PILLAR;
	public static final RegistryObject<Block> DEEPSLATE_PILLAR;
	public static final RegistryObject<Block> DEEPSLATE_BRICKS_PILLAR;
	public static final RegistryObject<Block> CRACKED_DEEPSLATE_BRICKS_PILLAR;
	public static final RegistryObject<Block> COBBLED_DEEPSLATE_PILLAR;
	public static final RegistryObject<Block> POLISHED_DEEPSLATE_PILLAR;
	public static final RegistryObject<Block> CHISELED_DEEPSLATE_PILLAR;
	public static final RegistryObject<Block> DEEPSLATE_TILES_PILLAR;
	public static final RegistryObject<Block> CRACKED_DEEPSLATE_TILES_PILLAR;

	// wall sconce
	public static final RegistryObject<Block> STONE_WALL_SCONCE;
	public static final RegistryObject<Block> SMOOTH_STONE_WALL_SCONCE;
	public static final RegistryObject<Block> COBBLESTONE_WALL_SCONCE;
	public static final RegistryObject<Block> MOSSY_COBBLESTONE_WALL_SCONCE;
	public static final RegistryObject<Block> BRICKS_WALL_SCONCE;
	public static final RegistryObject<Block> STONE_BRICKS_WALL_SCONCE;
	public static final RegistryObject<Block> MOSSY_STONE_BRICKS_WALL_SCONCE;
	public static final RegistryObject<Block> CRACKED_STONE_BRICKS_WALL_SCONCE;
	public static final RegistryObject<Block> CHISELED_STONE_BRICKS_WALL_SCONCE;
	public static final RegistryObject<Block> OBSIDIAN_WALL_SCONCE;
	public static final RegistryObject<Block> SANDSTONE_WALL_SCONCE;
	public static final RegistryObject<Block> SMOOTH_SANDSTONE_WALL_SCONCE;
	public static final RegistryObject<Block> CHISELED_SANDSTONE_WALL_SCONCE;
	public static final RegistryObject<Block> CUT_SANDSTONE_WALL_SCONCE;
	public static final RegistryObject<Block> RED_SANDSTONE_WALL_SCONCE;
	public static final RegistryObject<Block> SMOOTH_RED_SANDSTONE_WALL_SCONCE;
	public static final RegistryObject<Block> CHISELED_RED_SANDSTONE_WALL_SCONCE;
	public static final RegistryObject<Block> CUT_RED_SANDSTONE_WALL_SCONCE;
	public static final RegistryObject<Block> GRANITE_WALL_SCONCE;
	public static final RegistryObject<Block> POLISHED_GRANITE_WALL_SCONCE;
	public static final RegistryObject<Block> DIORITE_WALL_SCONCE;
	public static final RegistryObject<Block> POLISHED_DIORITE_WALL_SCONCE;
	public static final RegistryObject<Block> ANDESITE_WALL_SCONCE;
	public static final RegistryObject<Block> POLISHED_ANDESITE_WALL_SCONCE;
	public static final RegistryObject<Block> BLACKSTONE_WALL_SCONCE;
	public static final RegistryObject<Block> POLISHED_BLACKSTONE_WALL_SCONCE;
	public static final RegistryObject<Block> CHISELED_POLISHED_BLACKSTONE_WALL_SCONCE;
	public static final RegistryObject<Block> GILDED_BLACKSTONE_WALL_SCONCE;
	public static final RegistryObject<Block> POLISHED_BLACKSTONE_BRICKS_WALL_SCONCE;
	public static final RegistryObject<Block> CRACKED_POLISHED_BLACKSTONE_BRICKS_WALL_SCONCE;
	public static final RegistryObject<Block> DEEPSLATE_WALL_SCONCE;
	public static final RegistryObject<Block> DEEPSLATE_BRICKS_WALL_SCONCE;
	public static final RegistryObject<Block> CRACKED_DEEPSLATE_BRICKS_WALL_SCONCE;
	public static final RegistryObject<Block> COBBLED_DEEPSLATE_WALL_SCONCE;
	public static final RegistryObject<Block> POLISHED_DEEPSLATE_WALL_SCONCE;
	public static final RegistryObject<Block> CHISELED_DEEPSLATE_WALL_SCONCE;
	public static final RegistryObject<Block> DEEPSLATE_TILES_WALL_SCONCE;
	public static final RegistryObject<Block> CRACKED_DEEPSLATE_TILES_WALL_SCONCE;

	// grate
	public static final RegistryObject<Block> GRATE = Registration.BLOCKS.register(BlockID.GRATE_ID, () -> new GrateBlock(Properties.of().mapColor(MapColor.METAL).strength(1.5F, 6.0F)));

	// FUTURE
	// BARRED_WINDOW
	// BARRED_WINDOW_FACADE
	// WALL_RING

	public static final Map<RegistryObject<Block>, RegistryObject<Item>> MAP = Maps.newHashMap();
	
	static {
		// facade
		STONE_FACADE = Registration.BLOCKS.register(BlockID.STONE_FACADE_ID,	() -> new FacadeBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		SMOOTH_STONE_FACADE = Registration.BLOCKS.register(BlockID.SMOOTH_STONE_FACADE_ID,
				() -> new FacadeBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		COBBLESTONE_FACADE = Registration.BLOCKS.register(BlockID.COBBLESTONE_FACADE_ID,
				() -> new FacadeBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		MOSSY_COBBLESTONE_FACADE = Registration.BLOCKS.register(BlockID.MOSSY_COBBLESTONE_FACADE_ID,
				() -> new FacadeBlock(Properties.of().mapColor(MapColor.STONE).strength(2.0F, 6.0F)));
		BRICKS_FACADE = Registration.BLOCKS.register(BlockID.BRICKS_FACADE_ID,
				() -> new FacadeBlock(Properties.of().mapColor(MapColor.COLOR_RED).strength(2.0F, 6.0F)));
		STONE_BRICKS_FACADE = Registration.BLOCKS.register(BlockID.STONE_BRICKS_FACADE_ID,
				() -> new FacadeBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		MOSSY_STONE_BRICKS_FACADE = Registration.BLOCKS.register(BlockID.MOSSY_STONE_BRICKS_FACADE_ID,
				() -> new FacadeBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		CRACKED_STONE_BRICKS_FACADE = Registration.BLOCKS.register(BlockID.CRACKED_STONE_BRICKS_FACADE_ID,
				() -> new FacadeBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		CHISELED_STONE_BRICKS_FACADE = Registration.BLOCKS.register(BlockID.CHISELED_STONE_BRICKS_FACADE_ID,
				() -> new FacadeBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		OBSIDIAN_FACADE = Registration.BLOCKS.register(BlockID.OBSIDIAN_FACADE_ID,
				() -> new FacadeBlock(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN)));

		SANDSTONE_FACADE = Registration.BLOCKS.register(BlockID.SANDSTONE_FACADE_ID,
				() -> new FacadeBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		SMOOTH_SANDSTONE_FACADE = Registration.BLOCKS.register(BlockID.SMOOTH_SANDSTONE_FACADE_ID,
				() -> new FacadeBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		CHISELED_SANDSTONE_FACADE = Registration.BLOCKS.register(BlockID.CHISELED_SANDSTONE_FACADE_ID,
				() -> new FacadeBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		CUT_SANDSTONE_FACADE = Registration.BLOCKS.register(BlockID.CUT_SANDSTONE_FACADE_ID,
				() -> new FacadeBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		RED_SANDSTONE_FACADE = Registration.BLOCKS.register(BlockID.RED_SANDSTONE_FACADE_ID,
				() -> new FacadeBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		SMOOTH_RED_SANDSTONE_FACADE = Registration.BLOCKS.register(BlockID.SMOOTH_RED_SANDSTONE_FACADE_ID,
				() -> new FacadeBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		CHISELED_RED_SANDSTONE_FACADE = Registration.BLOCKS.register(BlockID.CHISELED_RED_SANDSTONE_FACADE_ID,
				() -> new FacadeBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		CUT_RED_SANDSTONE_FACADE = Registration.BLOCKS.register(BlockID.CUT_RED_SANDSTONE_FACADE_ID,
				() -> new FacadeBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));

		GRANITE_FACADE = Registration.BLOCKS.register(BlockID.GRANITE_FACADE_ID,
				() -> new FacadeBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		POLISHED_GRANITE_FACADE = Registration.BLOCKS.register(BlockID.POLISHED_GRANITE_FACADE_ID,
				() -> new FacadeBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		DIORITE_FACADE = Registration.BLOCKS.register(BlockID.DIORITE_FACADE_ID,
				() -> new FacadeBlock(Properties.of().mapColor(MapColor.QUARTZ).strength(1.5F, 6.0F)));
		POLISHED_DIORITE_FACADE = Registration.BLOCKS.register(BlockID.POLISHED_DIORITE_FACADE_ID,
				() -> new FacadeBlock(BlockBehaviour.Properties.copy(Blocks.DIORITE)));
		ANDESITE_FACADE = Registration.BLOCKS.register(BlockID.ANDESITE_FACADE_ID,
				() -> new FacadeBlock(BlockBehaviour.Properties.copy(Blocks.ANDESITE)));
		POLISHED_ANDESITE_FACADE = Registration.BLOCKS.register(BlockID.POLISHED_ANDESITE_FACADE_ID,
				() -> new FacadeBlock(BlockBehaviour.Properties.copy(Blocks.ANDESITE)));

		BLACKSTONE_FACADE = Registration.BLOCKS.register(BlockID.BLACKSTONE_FACADE_ID,
				() -> new FacadeBlock(BlockBehaviour.Properties.copy(Blocks.BLACKSTONE)));	
		POLISHED_BLACKSTONE_FACADE = Registration.BLOCKS.register(BlockID.POLISHED_BLACKSTONE_FACADE_ID,
				() -> new FacadeBlock(BlockBehaviour.Properties.copy(Blocks.BLACKSTONE)));	
		CHISELED_POLISHED_BLACKSTONE_FACADE = Registration.BLOCKS.register(BlockID.CHISELED_POLISHED_BLACKSTONE_FACADE_ID,
				() -> new FacadeBlock(BlockBehaviour.Properties.copy(Blocks.BLACKSTONE)));	
		GILDED_BLACKSTONE_FACADE = Registration.BLOCKS.register(BlockID.GILDED_BLACKSTONE_FACADE_ID,
				() -> new FacadeBlock(BlockBehaviour.Properties.copy(Blocks.GILDED_BLACKSTONE)));	
		POLISHED_BLACKSTONE_BRICKS_FACADE = Registration.BLOCKS.register(BlockID.POLISHED_BLACKSTONE_BRICKS_FACADE_ID,
				() -> new FacadeBlock(BlockBehaviour.Properties.copy(Blocks.BLACKSTONE)));	
		CRACKED_POLISHED_BLACKSTONE_BRICKS_FACADE = Registration.BLOCKS.register(BlockID.CRACKED_POLISHED_BLACKSTONE_BRICKS_FACADE_ID,
				() -> new FacadeBlock(BlockBehaviour.Properties.copy(Blocks.BLACKSTONE)));			

		DEEPSLATE_FACADE = Registration.BLOCKS.register(BlockID.DEEPSLATE_FACADE_ID,
				() -> new FacadeBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));
		DEEPSLATE_BRICKS_FACADE = Registration.BLOCKS.register(BlockID.DEEPSLATE_BRICKS_FACADE_ID,
				() -> new FacadeBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));
		CRACKED_DEEPSLATE_BRICKS_FACADE = Registration.BLOCKS.register(BlockID.CRACKED_DEEPSLATE_BRICKS_FACADE_ID,
				() -> new FacadeBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));
		COBBLED_DEEPSLATE_FACADE = Registration.BLOCKS.register(BlockID.COBBLED_DEEPSLATE_FACADE_ID,
				() -> new FacadeBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));
		POLISHED_DEEPSLATE_FACADE = Registration.BLOCKS.register(BlockID.POLISHED_DEEPSLATE_FACADE_ID,
				() -> new FacadeBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));
		CHISELED_DEEPSLATE_FACADE = Registration.BLOCKS.register(BlockID.CHISELED_DEEPSLATE_FACADE_ID,
				() -> new FacadeBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));
		DEEPSLATE_TILES_FACADE = Registration.BLOCKS.register(BlockID.DEEPSLATE_TILES_FACADE_ID,
				() -> new FacadeBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));
		CRACKED_DEEPSLATE_TILES_FACADE = Registration.BLOCKS.register(BlockID.CRACKED_DEEPSLATE_TILES_FACADE_ID,
				() -> new FacadeBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));

		// quarter facade
		STONE_QUARTER_FACADE = Registration.BLOCKS.register(BlockID.STONE_QUARTER_FACADE_ID,
				() -> new QuarterFacadeBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));
		SMOOTH_STONE_QUARTER_FACADE = Registration.BLOCKS.register(BlockID.SMOOTH_STONE_QUARTER_FACADE_ID,
				() -> new QuarterFacadeBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		COBBLESTONE_QUARTER_FACADE = Registration.BLOCKS.register(BlockID.COBBLESTONE_QUARTER_FACADE_ID,
				() -> new QuarterFacadeBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		MOSSY_COBBLESTONE_QUARTER_FACADE = Registration.BLOCKS.register(BlockID.MOSSY_COBBLESTONE_QUARTER_FACADE_ID,
				() -> new QuarterFacadeBlock(Properties.of().mapColor(MapColor.STONE).strength(2.0F, 6.0F)));
		BRICKS_QUARTER_FACADE = Registration.BLOCKS.register(BlockID.BRICKS_QUARTER_FACADE_ID,
				() -> new QuarterFacadeBlock(Properties.of().mapColor(MapColor.COLOR_RED).strength(2.0F, 6.0F)));
		STONE_BRICKS_QUARTER_FACADE = Registration.BLOCKS.register(BlockID.STONE_BRICKS_QUARTER_FACADE_ID,
				() -> new QuarterFacadeBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		MOSSY_STONE_BRICKS_QUARTER_FACADE = Registration.BLOCKS.register(BlockID.MOSSY_STONE_BRICKS_QUARTER_FACADE_ID,
				() -> new QuarterFacadeBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		CRACKED_STONE_BRICKS_QUARTER_FACADE = Registration.BLOCKS.register(BlockID.CRACKED_STONE_BRICKS_QUARTER_FACADE_ID,
				() -> new QuarterFacadeBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		CHISELED_STONE_BRICKS_QUARTER_FACADE = Registration.BLOCKS.register(BlockID.CHISELED_STONE_BRICKS_QUARTER_FACADE_ID,
				() -> new QuarterFacadeBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		OBSIDIAN_QUARTER_FACADE = Registration.BLOCKS.register(BlockID.OBSIDIAN_QUARTER_FACADE_ID,
				() -> new QuarterFacadeBlock(Properties.of().mapColor(MapColor.STONE).strength(50.0F, 1200.0F)));

		SANDSTONE_QUARTER_FACADE = Registration.BLOCKS.register(BlockID.SANDSTONE_QUARTER_FACADE_ID,
				() -> new QuarterFacadeBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		SMOOTH_SANDSTONE_QUARTER_FACADE = Registration.BLOCKS.register(BlockID.SMOOTH_SANDSTONE_QUARTER_FACADE_ID,
				() -> new QuarterFacadeBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		CHISELED_SANDSTONE_QUARTER_FACADE = Registration.BLOCKS.register(BlockID.CHISELED_SANDSTONE_QUARTER_FACADE_ID,
				() -> new QuarterFacadeBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		CUT_SANDSTONE_QUARTER_FACADE = Registration.BLOCKS.register(BlockID.CUT_SANDSTONE_QUARTER_FACADE_ID,
				() -> new QuarterFacadeBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		RED_SANDSTONE_QUARTER_FACADE = Registration.BLOCKS.register(BlockID.RED_SANDSTONE_QUARTER_FACADE_ID,
				() -> new QuarterFacadeBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		SMOOTH_RED_SANDSTONE_QUARTER_FACADE = Registration.BLOCKS.register(BlockID.SMOOTH_RED_SANDSTONE_QUARTER_FACADE_ID,
				() -> new QuarterFacadeBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		CHISELED_RED_SANDSTONE_QUARTER_FACADE = Registration.BLOCKS.register(BlockID.CHISELED_RED_SANDSTONE_QUARTER_FACADE_ID,
				() -> new QuarterFacadeBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		CUT_RED_SANDSTONE_QUARTER_FACADE = Registration.BLOCKS.register(BlockID.CUT_RED_SANDSTONE_QUARTER_FACADE_ID,
				() -> new QuarterFacadeBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));

		GRANITE_QUARTER_FACADE = Registration.BLOCKS.register(BlockID.GRANITE_QUARTER_FACADE_ID,
				() -> new QuarterFacadeBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		POLISHED_GRANITE_QUARTER_FACADE = Registration.BLOCKS.register(BlockID.POLISHED_GRANITE_QUARTER_FACADE_ID,
				() -> new QuarterFacadeBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		DIORITE_QUARTER_FACADE = Registration.BLOCKS.register(BlockID.DIORITE_QUARTER_FACADE_ID,
				() -> new QuarterFacadeBlock(Properties.of().mapColor(MapColor.QUARTZ).strength(1.5F, 6.0F)));
		POLISHED_DIORITE_QUARTER_FACADE = Registration.BLOCKS.register(BlockID.POLISHED_DIORITE_QUARTER_FACADE_ID,
				() -> new QuarterFacadeBlock(Properties.of().mapColor(MapColor.QUARTZ).strength(1.5F, 6.0F)));
		ANDESITE_QUARTER_FACADE = Registration.BLOCKS.register(BlockID.ANDESITE_QUARTER_FACADE_ID,
				() -> new QuarterFacadeBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		POLISHED_ANDESITE_QUARTER_FACADE = Registration.BLOCKS.register(BlockID.POLISHED_ANDESITE_QUARTER_FACADE_ID,
				() -> new QuarterFacadeBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		BLACKSTONE_QUARTER_FACADE = Registration.BLOCKS.register(
				BlockID.BLACKSTONE_QUARTER_FACADE_ID, 
				() -> new QuarterFacadeBlock(BlockBehaviour.Properties.copy(Blocks.BLACKSTONE)));
		POLISHED_BLACKSTONE_QUARTER_FACADE = Registration.BLOCKS.register(
				BlockID.POLISHED_BLACKSTONE_QUARTER_FACADE_ID, 
				() -> new QuarterFacadeBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE)));
		CHISELED_POLISHED_BLACKSTONE_QUARTER_FACADE = Registration.BLOCKS.register(
				BlockID.CHISELED_POLISHED_BLACKSTONE_QUARTER_FACADE_ID, 
				() -> new QuarterFacadeBlock(BlockBehaviour.Properties.copy(Blocks.CHISELED_POLISHED_BLACKSTONE)));
		GILDED_BLACKSTONE_QUARTER_FACADE = Registration.BLOCKS.register(
				BlockID.GILDED_BLACKSTONE_QUARTER_FACADE_ID, 
				() -> new QuarterFacadeBlock(BlockBehaviour.Properties.copy(Blocks.GILDED_BLACKSTONE)));
		POLISHED_BLACKSTONE_BRICKS_QUARTER_FACADE = Registration.BLOCKS.register(
				BlockID.POLISHED_BLACKSTONE_BRICKS_QUARTER_FACADE_ID, 
				() -> new QuarterFacadeBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE_BRICKS)));
		CRACKED_POLISHED_BLACKSTONE_BRICKS_QUARTER_FACADE = Registration.BLOCKS.register(
				BlockID.CRACKED_POLISHED_BLACKSTONE_BRICKS_QUARTER_FACADE_ID, 
				() -> new QuarterFacadeBlock(BlockBehaviour.Properties.copy(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS)));
		DEEPSLATE_QUARTER_FACADE = Registration.BLOCKS.register(
				BlockID.DEEPSLATE_QUARTER_FACADE_ID, 
				() -> new QuarterFacadeBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));
		DEEPSLATE_BRICKS_QUARTER_FACADE = Registration.BLOCKS.register(
				BlockID.DEEPSLATE_BRICKS_QUARTER_FACADE_ID, 
				() -> new QuarterFacadeBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICKS)));
		CRACKED_DEEPSLATE_BRICKS_QUARTER_FACADE = Registration.BLOCKS.register(
				BlockID.CRACKED_DEEPSLATE_BRICKS_QUARTER_FACADE_ID, 
				() -> new QuarterFacadeBlock(BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_BRICKS)));
		COBBLED_DEEPSLATE_QUARTER_FACADE = Registration.BLOCKS.register(
				BlockID.COBBLED_DEEPSLATE_QUARTER_FACADE_ID, 
				() -> new QuarterFacadeBlock(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE)));
		POLISHED_DEEPSLATE_QUARTER_FACADE = Registration.BLOCKS.register(
				BlockID.POLISHED_DEEPSLATE_QUARTER_FACADE_ID, 
				() -> new QuarterFacadeBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_DEEPSLATE)));
		CHISELED_DEEPSLATE_QUARTER_FACADE = Registration.BLOCKS.register(
				BlockID.CHISELED_DEEPSLATE_QUARTER_FACADE_ID, 
				() -> new QuarterFacadeBlock(BlockBehaviour.Properties.copy(Blocks.CHISELED_DEEPSLATE)));
		DEEPSLATE_TILES_QUARTER_FACADE = Registration.BLOCKS.register(
				BlockID.DEEPSLATE_TILES_QUARTER_FACADE_ID, 
				() -> new QuarterFacadeBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_TILES)));
		CRACKED_DEEPSLATE_TILES_QUARTER_FACADE = Registration.BLOCKS.register(
				BlockID.CRACKED_DEEPSLATE_TILES_QUARTER_FACADE_ID, 
				() -> new QuarterFacadeBlock(BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_TILES)));

		// fluted
		STONE_FLUTED = Registration.BLOCKS.register(BlockID.STONE_FLUTED_ID,
				() -> new FlutedBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		SMOOTH_STONE_FLUTED = Registration.BLOCKS.register(BlockID.SMOOTH_STONE_FLUTED_ID,
				() -> new FlutedBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		COBBLESTONE_FLUTED = Registration.BLOCKS.register(BlockID.COBBLESTONE_FLUTED_ID,
				() -> new FlutedBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		MOSSY_COBBLESTONE_FLUTED = Registration.BLOCKS.register(BlockID.MOSSY_COBBLESTONE_FLUTED_ID,
				() -> new FlutedBlock(Properties.of().mapColor(MapColor.STONE).strength(2.0F, 6.0F)));
		BRICKS_FLUTED = Registration.BLOCKS.register(BlockID.BRICKS_FLUTED_ID,
				() -> new FlutedBlock(Properties.of().mapColor(MapColor.COLOR_RED).strength(2.0F, 6.0F)));
		STONE_BRICKS_FLUTED = Registration.BLOCKS.register(BlockID.STONE_BRICKS_FLUTED_ID,
				() -> new FlutedBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		MOSSY_STONE_BRICKS_FLUTED = Registration.BLOCKS.register(BlockID.MOSSY_STONE_BRICKS_FLUTED_ID,
				() -> new FlutedBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		CRACKED_STONE_BRICKS_FLUTED = Registration.BLOCKS.register(BlockID.CRACKED_STONE_BRICKS_FLUTED_ID,
				() -> new FlutedBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		CHISELED_STONE_BRICKS_FLUTED = Registration.BLOCKS.register(BlockID.CHISELED_STONE_BRICKS_FLUTED_ID,
				() -> new FlutedBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		OBSIDIAN_FLUTED = Registration.BLOCKS.register(BlockID.OBSIDIAN_FLUTED_ID,
				() -> new FlutedBlock(Properties.of().mapColor(MapColor.STONE).strength(50.0F, 1200.0F)));

		SANDSTONE_FLUTED = Registration.BLOCKS.register(BlockID.SANDSTONE_FLUTED_ID,
				() -> new FlutedBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		SMOOTH_SANDSTONE_FLUTED = Registration.BLOCKS.register(BlockID.SMOOTH_SANDSTONE_FLUTED_ID,
				() -> new FlutedBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		CHISELED_SANDSTONE_FLUTED = Registration.BLOCKS.register(BlockID.CHISELED_SANDSTONE_FLUTED_ID,
				() -> new FlutedBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		CUT_SANDSTONE_FLUTED = Registration.BLOCKS.register(BlockID.CUT_SANDSTONE_FLUTED_ID,
				() -> new FlutedBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		RED_SANDSTONE_FLUTED = Registration.BLOCKS.register(BlockID.RED_SANDSTONE_FLUTED_ID,
				() -> new FlutedBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		SMOOTH_RED_SANDSTONE_FLUTED = Registration.BLOCKS.register(BlockID.SMOOTH_RED_SANDSTONE_FLUTED_ID,
				() -> new FlutedBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		CHISELED_RED_SANDSTONE_FLUTED = Registration.BLOCKS.register(BlockID.CHISELED_RED_SANDSTONE_FLUTED_ID,
				() -> new FlutedBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		CUT_RED_SANDSTONE_FLUTED = Registration.BLOCKS.register(BlockID.CUT_RED_SANDSTONE_FLUTED_ID,
				() -> new FlutedBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));

		GRANITE_FLUTED = Registration.BLOCKS.register(BlockID.GRANITE_FLUTED_ID,
				() -> new FlutedBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		POLISHED_GRANITE_FLUTED = Registration.BLOCKS.register(BlockID.POLISHED_GRANITE_FLUTED_ID,
				() -> new FlutedBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		DIORITE_FLUTED = Registration.BLOCKS.register(BlockID.DIORITE_FLUTED_ID,
				() -> new FlutedBlock(Properties.of().mapColor(MapColor.QUARTZ).strength(1.5F, 6.0F)));
		POLISHED_DIORITE_FLUTED = Registration.BLOCKS.register(BlockID.POLISHED_DIORITE_FLUTED_ID,
				() -> new FlutedBlock(Properties.of().mapColor(MapColor.QUARTZ).strength(1.5F, 6.0F)));
		ANDESITE_FLUTED = Registration.BLOCKS.register(BlockID.ANDESITE_FLUTED_ID,
				() -> new FlutedBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		POLISHED_ANDESITE_FLUTED = Registration.BLOCKS.register(BlockID.POLISHED_ANDESITE_FLUTED_ID,
				() -> new FlutedBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));

		BLACKSTONE_FLUTED = Registration.BLOCKS.register(
				BlockID.BLACKSTONE_FLUTED_ID, 
				() -> new FlutedBlock(BlockBehaviour.Properties.copy(Blocks.BLACKSTONE)));
		POLISHED_BLACKSTONE_FLUTED = Registration.BLOCKS.register(
				BlockID.POLISHED_BLACKSTONE_FLUTED_ID, 
				() -> new FlutedBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE)));
		CHISELED_POLISHED_BLACKSTONE_FLUTED = Registration.BLOCKS.register(
				BlockID.CHISELED_POLISHED_BLACKSTONE_FLUTED_ID, 
				() -> new FlutedBlock(BlockBehaviour.Properties.copy(Blocks.CHISELED_POLISHED_BLACKSTONE)));
		GILDED_BLACKSTONE_FLUTED = Registration.BLOCKS.register(
				BlockID.GILDED_BLACKSTONE_FLUTED_ID, 
				() -> new FlutedBlock(BlockBehaviour.Properties.copy(Blocks.GILDED_BLACKSTONE)));
		POLISHED_BLACKSTONE_BRICKS_FLUTED = Registration.BLOCKS.register(
				BlockID.POLISHED_BLACKSTONE_BRICKS_FLUTED_ID, 
				() -> new FlutedBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE_BRICKS)));
		CRACKED_POLISHED_BLACKSTONE_BRICKS_FLUTED = Registration.BLOCKS.register(
				BlockID.CRACKED_POLISHED_BLACKSTONE_BRICKS_FLUTED_ID, 
				() -> new FlutedBlock(BlockBehaviour.Properties.copy(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS)));
		DEEPSLATE_FLUTED = Registration.BLOCKS.register(
				BlockID.DEEPSLATE_FLUTED_ID, 
				() -> new FlutedBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));
		DEEPSLATE_BRICKS_FLUTED = Registration.BLOCKS.register(
				BlockID.DEEPSLATE_BRICKS_FLUTED_ID, 
				() -> new FlutedBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICKS)));
		CRACKED_DEEPSLATE_BRICKS_FLUTED = Registration.BLOCKS.register(
				BlockID.CRACKED_DEEPSLATE_BRICKS_FLUTED_ID, 
				() -> new FlutedBlock(BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_BRICKS)));
		COBBLED_DEEPSLATE_FLUTED = Registration.BLOCKS.register(
				BlockID.COBBLED_DEEPSLATE_FLUTED_ID, 
				() -> new FlutedBlock(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE)));
		POLISHED_DEEPSLATE_FLUTED = Registration.BLOCKS.register(
				BlockID.POLISHED_DEEPSLATE_FLUTED_ID, 
				() -> new FlutedBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_DEEPSLATE)));
		CHISELED_DEEPSLATE_FLUTED = Registration.BLOCKS.register(
				BlockID.CHISELED_DEEPSLATE_FLUTED_ID, 
				() -> new FlutedBlock(BlockBehaviour.Properties.copy(Blocks.CHISELED_DEEPSLATE)));
		DEEPSLATE_TILES_FLUTED = Registration.BLOCKS.register(
				BlockID.DEEPSLATE_TILES_FLUTED_ID, 
				() -> new FlutedBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_TILES)));
		CRACKED_DEEPSLATE_TILES_FLUTED = Registration.BLOCKS.register(
				BlockID.CRACKED_DEEPSLATE_TILES_FLUTED_ID, 
				() -> new FlutedBlock(BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_TILES)));

		// fluted facade
		STONE_FLUTED_FACADE = Registration.BLOCKS.register(BlockID.STONE_FLUTED_FACADE_ID,
				() -> new FlutedFacadeBlock(BlockBehaviour.Properties.copy(STONE_FLUTED.get())));
		SMOOTH_STONE_FLUTED_FACADE = Registration.BLOCKS.register(BlockID.SMOOTH_STONE_FLUTED_FACADE_ID,
				() -> new FlutedFacadeBlock(BlockBehaviour.Properties.copy(SMOOTH_STONE_FLUTED.get())));
		COBBLESTONE_FLUTED_FACADE = Registration.BLOCKS.register(BlockID.COBBLESTONE_FLUTED_FACADE_ID,
				() -> new FlutedFacadeBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		MOSSY_COBBLESTONE_FLUTED_FACADE = Registration.BLOCKS.register(
				BlockID.MOSSY_COBBLESTONE_FLUTED_FACADE_ID,
				() -> new FlutedFacadeBlock(Properties.of().mapColor(MapColor.STONE).strength(2.0F, 6.0F)));
		BRICKS_FLUTED_FACADE = Registration.BLOCKS.register(BlockID.BRICKS_FLUTED_FACADE_ID,
				() -> new FlutedFacadeBlock(Properties.of().mapColor(MapColor.COLOR_RED).strength(2.0F, 6.0F)));
		STONE_BRICKS_FLUTED_FACADE = Registration.BLOCKS.register(BlockID.STONE_BRICKS_FLUTED_FACADE_ID,
				() -> new FlutedFacadeBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		MOSSY_STONE_BRICKS_FLUTED_FACADE = Registration.BLOCKS.register(
				BlockID.MOSSY_STONE_BRICKS_FLUTED_FACADE_ID,
				() -> new FlutedFacadeBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		CRACKED_STONE_BRICKS_FLUTED_FACADE = Registration.BLOCKS.register(
				BlockID.CRACKED_STONE_BRICKS_FLUTED_FACADE_ID,
				() -> new FlutedFacadeBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		CHISELED_STONE_BRICKS_FLUTED_FACADE = Registration.BLOCKS.register(
				BlockID.CHISELED_STONE_BRICKS_FLUTED_FACADE_ID,
				() -> new FlutedFacadeBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		OBSIDIAN_FLUTED_FACADE = Registration.BLOCKS.register(BlockID.OBSIDIAN_FLUTED_FACADE_ID,
				() -> new FlutedFacadeBlock(Properties.of().mapColor(MapColor.STONE).strength(50.0F, 1200.0F)));

		SANDSTONE_FLUTED_FACADE = Registration.BLOCKS.register(BlockID.SANDSTONE_FLUTED_FACADE_ID,
				() -> new FlutedFacadeBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		SMOOTH_SANDSTONE_FLUTED_FACADE = Registration.BLOCKS.register(
				BlockID.SMOOTH_SANDSTONE_FLUTED_FACADE_ID,
				() -> new FlutedFacadeBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		CHISELED_SANDSTONE_FLUTED_FACADE = Registration.BLOCKS.register(
				BlockID.CHISELED_SANDSTONE_FLUTED_FACADE_ID,
				() -> new FlutedFacadeBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		CUT_SANDSTONE_FLUTED_FACADE = Registration.BLOCKS.register(
				BlockID.CUT_SANDSTONE_FLUTED_FACADE_ID,
				() -> new FlutedFacadeBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		RED_SANDSTONE_FLUTED_FACADE = Registration.BLOCKS.register(
				BlockID.RED_SANDSTONE_FLUTED_FACADE_ID,
				() -> new FlutedFacadeBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		SMOOTH_RED_SANDSTONE_FLUTED_FACADE = Registration.BLOCKS.register(
				BlockID.SMOOTH_RED_SANDSTONE_FLUTED_FACADE_ID,
				() -> new FlutedFacadeBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		CHISELED_RED_SANDSTONE_FLUTED_FACADE = Registration.BLOCKS.register(
				BlockID.CHISELED_RED_SANDSTONE_FLUTED_FACADE_ID,
				() -> new FlutedFacadeBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		CUT_RED_SANDSTONE_FLUTED_FACADE = Registration.BLOCKS.register(
				BlockID.CUT_RED_SANDSTONE_FLUTED_FACADE_ID,
				() -> new FlutedFacadeBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));

		GRANITE_FLUTED_FACADE = Registration.BLOCKS.register(BlockID.GRANITE_FLUTED_FACADE_ID,
				() -> new FlutedFacadeBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		POLISHED_GRANITE_FLUTED_FACADE = Registration.BLOCKS.register(
				BlockID.POLISHED_GRANITE_FLUTED_FACADE_ID,
				() -> new FlutedFacadeBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		DIORITE_FLUTED_FACADE = Registration.BLOCKS.register(BlockID.DIORITE_FLUTED_FACADE_ID,
				() -> new FlutedFacadeBlock(Properties.of().mapColor(MapColor.QUARTZ).strength(1.5F, 6.0F)));
		POLISHED_DIORITE_FLUTED_FACADE = Registration.BLOCKS.register(
				BlockID.POLISHED_DIORITE_FLUTED_FACADE_ID,
				() -> new FlutedFacadeBlock(Properties.of().mapColor(MapColor.QUARTZ).strength(1.5F, 6.0F)));
		ANDESITE_FLUTED_FACADE = Registration.BLOCKS.register(BlockID.ANDESITE_FLUTED_FACADE_ID,
				() -> new FlutedFacadeBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		POLISHED_ANDESITE_FLUTED_FACADE = Registration.BLOCKS.register(
				BlockID.POLISHED_ANDESITE_FLUTED_FACADE_ID,
				() -> new FlutedFacadeBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));

		BLACKSTONE_FLUTED_FACADE = Registration.BLOCKS.register(
				BlockID.BLACKSTONE_FLUTED_FACADE_ID, 
				() -> new FlutedFacadeBlock(BlockBehaviour.Properties.copy(Blocks.BLACKSTONE)));
		POLISHED_BLACKSTONE_FLUTED_FACADE = Registration.BLOCKS.register(
				BlockID.POLISHED_BLACKSTONE_FLUTED_FACADE_ID, 
				() -> new FlutedFacadeBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE)));
		CHISELED_POLISHED_BLACKSTONE_FLUTED_FACADE = Registration.BLOCKS.register(
				BlockID.CHISELED_POLISHED_BLACKSTONE_FLUTED_FACADE_ID, 
				() -> new FlutedFacadeBlock(BlockBehaviour.Properties.copy(Blocks.CHISELED_POLISHED_BLACKSTONE)));
		GILDED_BLACKSTONE_FLUTED_FACADE = Registration.BLOCKS.register(
				BlockID.GILDED_BLACKSTONE_FLUTED_FACADE_ID, 
				() -> new FlutedFacadeBlock(BlockBehaviour.Properties.copy(Blocks.GILDED_BLACKSTONE)));
		POLISHED_BLACKSTONE_BRICKS_FLUTED_FACADE = Registration.BLOCKS.register(
				BlockID.POLISHED_BLACKSTONE_BRICKS_FLUTED_FACADE_ID, 
				() -> new FlutedFacadeBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE_BRICKS)));
		CRACKED_POLISHED_BLACKSTONE_BRICKS_FLUTED_FACADE = Registration.BLOCKS.register(
				BlockID.CRACKED_POLISHED_BLACKSTONE_BRICKS_FLUTED_FACADE_ID, 
				() -> new FlutedFacadeBlock(BlockBehaviour.Properties.copy(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS)));
		DEEPSLATE_FLUTED_FACADE = Registration.BLOCKS.register(
				BlockID.DEEPSLATE_FLUTED_FACADE_ID, 
				() -> new FlutedFacadeBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));
		DEEPSLATE_BRICKS_FLUTED_FACADE = Registration.BLOCKS.register(
				BlockID.DEEPSLATE_BRICKS_FLUTED_FACADE_ID, 
				() -> new FlutedFacadeBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICKS)));
		CRACKED_DEEPSLATE_BRICKS_FLUTED_FACADE = Registration.BLOCKS.register(
				BlockID.CRACKED_DEEPSLATE_BRICKS_FLUTED_FACADE_ID, 
				() -> new FlutedFacadeBlock(BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_BRICKS)));
		COBBLED_DEEPSLATE_FLUTED_FACADE = Registration.BLOCKS.register(
				BlockID.COBBLED_DEEPSLATE_FLUTED_FACADE_ID, 
				() -> new FlutedFacadeBlock(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE)));
		POLISHED_DEEPSLATE_FLUTED_FACADE = Registration.BLOCKS.register(
				BlockID.POLISHED_DEEPSLATE_FLUTED_FACADE_ID, 
				() -> new FlutedFacadeBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_DEEPSLATE)));
		CHISELED_DEEPSLATE_FLUTED_FACADE = Registration.BLOCKS.register(
				BlockID.CHISELED_DEEPSLATE_FLUTED_FACADE_ID, 
				() -> new FlutedFacadeBlock(BlockBehaviour.Properties.copy(Blocks.CHISELED_DEEPSLATE)));
		DEEPSLATE_TILES_FLUTED_FACADE = Registration.BLOCKS.register(
				BlockID.DEEPSLATE_TILES_FLUTED_FACADE_ID, 
				() -> new FlutedFacadeBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_TILES)));
		CRACKED_DEEPSLATE_TILES_FLUTED_FACADE = Registration.BLOCKS.register(
				BlockID.CRACKED_DEEPSLATE_TILES_FLUTED_FACADE_ID, 
				() -> new FlutedFacadeBlock(BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_TILES)));

		// sill
		STONE_SILL = Registration.BLOCKS.register(BlockID.STONE_SILL_ID,
				() -> new SillBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		SMOOTH_STONE_SILL = Registration.BLOCKS.register(BlockID.SMOOTH_STONE_SILL_ID,
				() -> new SillBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		COBBLESTONE_SILL = Registration.BLOCKS.register(BlockID.COBBLESTONE_SILL_ID,
				() -> new SillBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		MOSSY_COBBLESTONE_SILL = Registration.BLOCKS.register(BlockID.MOSSY_COBBLESTONE_SILL_ID,
				() -> new SillBlock(Properties.of().mapColor(MapColor.STONE).strength(2.0F, 6.0F)));
		BRICKS_SILL = Registration.BLOCKS.register(BlockID.BRICKS_SILL_ID,
				() -> new SillBlock(Properties.of().mapColor(MapColor.COLOR_RED).strength(2.0F, 6.0F)));
		STONE_BRICKS_SILL = Registration.BLOCKS.register(BlockID.STONE_BRICKS_SILL_ID,
				() -> new SillBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		MOSSY_STONE_BRICKS_SILL = Registration.BLOCKS.register(BlockID.MOSSY_STONE_BRICKS_SILL_ID,
				() -> new SillBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		CRACKED_STONE_BRICKS_SILL = Registration.BLOCKS.register(BlockID.CRACKED_STONE_BRICKS_SILL_ID,
				() -> new SillBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		CHISELED_STONE_BRICKS_SILL = Registration.BLOCKS.register(BlockID.CHISELED_STONE_BRICKS_SILL_ID,
				() -> new SillBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		OBSIDIAN_SILL = Registration.BLOCKS.register(BlockID.OBSIDIAN_SILL_ID,
				() -> new SillBlock(Properties.of().mapColor(MapColor.STONE).strength(50.0F, 1200.0F)));

		SANDSTONE_SILL = Registration.BLOCKS.register(BlockID.SANDSTONE_SILL_ID,
				() -> new SillBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		SMOOTH_SANDSTONE_SILL = Registration.BLOCKS.register(BlockID.SMOOTH_SANDSTONE_SILL_ID,
				() -> new SillBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		CHISELED_SANDSTONE_SILL = Registration.BLOCKS.register(BlockID.CHISELED_SANDSTONE_SILL_ID,
				() -> new SillBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		CUT_SANDSTONE_SILL = Registration.BLOCKS.register(BlockID.CUT_SANDSTONE_SILL_ID,
				() -> new SillBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		RED_SANDSTONE_SILL = Registration.BLOCKS.register(BlockID.RED_SANDSTONE_SILL_ID,
				() -> new SillBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		SMOOTH_RED_SANDSTONE_SILL = Registration.BLOCKS.register(BlockID.SMOOTH_RED_SANDSTONE_SILL_ID,
				() -> new SillBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		CHISELED_RED_SANDSTONE_SILL = Registration.BLOCKS.register(BlockID.CHISELED_RED_SANDSTONE_SILL_ID,
				() -> new SillBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		CUT_RED_SANDSTONE_SILL = Registration.BLOCKS.register(BlockID.CUT_RED_SANDSTONE_SILL_ID,
				() -> new SillBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));

		GRANITE_SILL = Registration.BLOCKS.register(BlockID.GRANITE_SILL_ID,
				() -> new SillBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		POLISHED_GRANITE_SILL = Registration.BLOCKS.register(BlockID.POLISHED_GRANITE_SILL_ID,
				() -> new SillBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		DIORITE_SILL = Registration.BLOCKS.register(BlockID.DIORITE_SILL_ID,
				() -> new SillBlock(Properties.of().mapColor(MapColor.QUARTZ).strength(1.5F, 6.0F)));
		POLISHED_DIORITE_SILL = Registration.BLOCKS.register(BlockID.POLISHED_DIORITE_SILL_ID,
				() -> new SillBlock(Properties.of().mapColor(MapColor.QUARTZ).strength(1.5F, 6.0F)));
		ANDESITE_SILL = Registration.BLOCKS.register(BlockID.ANDESITE_SILL_ID,
				() -> new SillBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		POLISHED_ANDESITE_SILL = Registration.BLOCKS.register(BlockID.POLISHED_ANDESITE_SILL_ID,
				() -> new SillBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		BLACKSTONE_SILL = Registration.BLOCKS.register(
				BlockID.BLACKSTONE_SILL_ID, 
				() -> new SillBlock(BlockBehaviour.Properties.copy(Blocks.BLACKSTONE)));
		POLISHED_BLACKSTONE_SILL = Registration.BLOCKS.register(
				BlockID.POLISHED_BLACKSTONE_SILL_ID, 
				() -> new SillBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE)));
		CHISELED_POLISHED_BLACKSTONE_SILL = Registration.BLOCKS.register(
				BlockID.CHISELED_POLISHED_BLACKSTONE_SILL_ID, 
				() -> new SillBlock(BlockBehaviour.Properties.copy(Blocks.CHISELED_POLISHED_BLACKSTONE)));
		GILDED_BLACKSTONE_SILL = Registration.BLOCKS.register(
				BlockID.GILDED_BLACKSTONE_SILL_ID, 
				() -> new SillBlock(BlockBehaviour.Properties.copy(Blocks.GILDED_BLACKSTONE)));
		POLISHED_BLACKSTONE_BRICKS_SILL = Registration.BLOCKS.register(
				BlockID.POLISHED_BLACKSTONE_BRICKS_SILL_ID, 
				() -> new SillBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE_BRICKS)));
		CRACKED_POLISHED_BLACKSTONE_BRICKS_SILL = Registration.BLOCKS.register(
				BlockID.CRACKED_POLISHED_BLACKSTONE_BRICKS_SILL_ID, 
				() -> new SillBlock(BlockBehaviour.Properties.copy(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS)));
		DEEPSLATE_SILL = Registration.BLOCKS.register(
				BlockID.DEEPSLATE_SILL_ID, 
				() -> new SillBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));
		DEEPSLATE_BRICKS_SILL = Registration.BLOCKS.register(
				BlockID.DEEPSLATE_BRICKS_SILL_ID, 
				() -> new SillBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICKS)));
		CRACKED_DEEPSLATE_BRICKS_SILL = Registration.BLOCKS.register(
				BlockID.CRACKED_DEEPSLATE_BRICKS_SILL_ID, 
				() -> new SillBlock(BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_BRICKS)));
		COBBLED_DEEPSLATE_SILL = Registration.BLOCKS.register(
				BlockID.COBBLED_DEEPSLATE_SILL_ID, 
				() -> new SillBlock(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE)));
		POLISHED_DEEPSLATE_SILL = Registration.BLOCKS.register(
				BlockID.POLISHED_DEEPSLATE_SILL_ID, 
				() -> new SillBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_DEEPSLATE)));
		CHISELED_DEEPSLATE_SILL = Registration.BLOCKS.register(
				BlockID.CHISELED_DEEPSLATE_SILL_ID, 
				() -> new SillBlock(BlockBehaviour.Properties.copy(Blocks.CHISELED_DEEPSLATE)));
		DEEPSLATE_TILES_SILL = Registration.BLOCKS.register(
				BlockID.DEEPSLATE_TILES_SILL_ID, 
				() -> new SillBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_TILES)));
		CRACKED_DEEPSLATE_TILES_SILL = Registration.BLOCKS.register(
				BlockID.CRACKED_DEEPSLATE_TILES_SILL_ID, 
				() -> new SillBlock(BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_TILES)));

		// double sill
		STONE_DOUBLE_SILL = Registration.BLOCKS.register(BlockID.STONE_DOUBLE_SILL_ID,
				() -> new DoubleSillBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		SMOOTH_STONE_DOUBLE_SILL = Registration.BLOCKS.register(BlockID.SMOOTH_STONE_DOUBLE_SILL_ID,
				() -> new DoubleSillBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		COBBLESTONE_DOUBLE_SILL = Registration.BLOCKS.register(BlockID.COBBLESTONE_DOUBLE_SILL_ID,
				() -> new DoubleSillBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		MOSSY_COBBLESTONE_DOUBLE_SILL = Registration.BLOCKS.register(
				BlockID.MOSSY_COBBLESTONE_DOUBLE_SILL_ID,
				() -> new DoubleSillBlock(Properties.of().mapColor(MapColor.STONE).strength(2.0F, 6.0F)));
		BRICKS_DOUBLE_SILL = Registration.BLOCKS.register(BlockID.BRICKS_DOUBLE_SILL_ID,
				() -> new DoubleSillBlock(Properties.of().mapColor(MapColor.COLOR_RED).strength(2.0F, 6.0F)));
		STONE_BRICKS_DOUBLE_SILL = Registration.BLOCKS.register(BlockID.STONE_BRICKS_DOUBLE_SILL_ID,
				() -> new DoubleSillBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		MOSSY_STONE_BRICKS_DOUBLE_SILL = Registration.BLOCKS.register(
				BlockID.MOSSY_STONE_BRICKS_DOUBLE_SILL_ID,
				() -> new DoubleSillBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		CRACKED_STONE_BRICKS_DOUBLE_SILL = Registration.BLOCKS.register(
				BlockID.CRACKED_STONE_BRICKS_DOUBLE_SILL_ID,
				() -> new DoubleSillBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		CHISELED_STONE_BRICKS_DOUBLE_SILL = Registration.BLOCKS.register(
				BlockID.CHISELED_STONE_BRICKS_DOUBLE_SILL_ID,
				() -> new DoubleSillBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		OBSIDIAN_DOUBLE_SILL = Registration.BLOCKS.register(BlockID.OBSIDIAN_DOUBLE_SILL_ID,
				() -> new DoubleSillBlock(Properties.of().mapColor(MapColor.STONE).strength(50.0F, 1200.0F)));

		SANDSTONE_DOUBLE_SILL = Registration.BLOCKS.register(BlockID.SANDSTONE_DOUBLE_SILL_ID,
				() -> new DoubleSillBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		SMOOTH_SANDSTONE_DOUBLE_SILL = Registration.BLOCKS.register(
				BlockID.SMOOTH_SANDSTONE_DOUBLE_SILL_ID,
				() -> new DoubleSillBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		CHISELED_SANDSTONE_DOUBLE_SILL = Registration.BLOCKS.register(
				BlockID.CHISELED_SANDSTONE_DOUBLE_SILL_ID,
				() -> new DoubleSillBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		CUT_SANDSTONE_DOUBLE_SILL = Registration.BLOCKS.register(BlockID.CUT_SANDSTONE_DOUBLE_SILL_ID,
				() -> new DoubleSillBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		RED_SANDSTONE_DOUBLE_SILL = Registration.BLOCKS.register(BlockID.RED_SANDSTONE_DOUBLE_SILL_ID,
				() -> new DoubleSillBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		SMOOTH_RED_SANDSTONE_DOUBLE_SILL = Registration.BLOCKS.register(
				BlockID.SMOOTH_RED_SANDSTONE_DOUBLE_SILL_ID,
				() -> new DoubleSillBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		CHISELED_RED_SANDSTONE_DOUBLE_SILL = Registration.BLOCKS.register(
				BlockID.CHISELED_RED_SANDSTONE_DOUBLE_SILL_ID,
				() -> new DoubleSillBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		CUT_RED_SANDSTONE_DOUBLE_SILL = Registration.BLOCKS.register(
				BlockID.CUT_RED_SANDSTONE_DOUBLE_SILL_ID,
				() -> new DoubleSillBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));

		GRANITE_DOUBLE_SILL = Registration.BLOCKS.register(BlockID.GRANITE_DOUBLE_SILL_ID,
				() -> new DoubleSillBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		POLISHED_GRANITE_DOUBLE_SILL = Registration.BLOCKS.register(
				BlockID.POLISHED_GRANITE_DOUBLE_SILL_ID,
				() -> new DoubleSillBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		DIORITE_DOUBLE_SILL = Registration.BLOCKS.register(BlockID.DIORITE_DOUBLE_SILL_ID,
				() -> new DoubleSillBlock(Properties.of().mapColor(MapColor.QUARTZ).strength(1.5F, 6.0F)));
		POLISHED_DIORITE_DOUBLE_SILL = Registration.BLOCKS.register(
				BlockID.POLISHED_DIORITE_DOUBLE_SILL_ID,
				() -> new DoubleSillBlock(Properties.of().mapColor(MapColor.QUARTZ).strength(1.5F, 6.0F)));
		ANDESITE_DOUBLE_SILL = Registration.BLOCKS.register(BlockID.ANDESITE_DOUBLE_SILL_ID,
				() -> new DoubleSillBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		POLISHED_ANDESITE_DOUBLE_SILL = Registration.BLOCKS.register(
				BlockID.POLISHED_ANDESITE_DOUBLE_SILL_ID,
				() -> new DoubleSillBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		BLACKSTONE_DOUBLE_SILL = Registration.BLOCKS.register(
				BlockID.BLACKSTONE_DOUBLE_SILL_ID, 
				() -> new DoubleSillBlock(BlockBehaviour.Properties.copy(Blocks.BLACKSTONE)));
		POLISHED_BLACKSTONE_DOUBLE_SILL = Registration.BLOCKS.register(
				BlockID.POLISHED_BLACKSTONE_DOUBLE_SILL_ID, 
				() -> new DoubleSillBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE)));
		CHISELED_POLISHED_BLACKSTONE_DOUBLE_SILL = Registration.BLOCKS.register(
				BlockID.CHISELED_POLISHED_BLACKSTONE_DOUBLE_SILL_ID, 
				() -> new DoubleSillBlock(BlockBehaviour.Properties.copy(Blocks.CHISELED_POLISHED_BLACKSTONE)));
		GILDED_BLACKSTONE_DOUBLE_SILL = Registration.BLOCKS.register(
				BlockID.GILDED_BLACKSTONE_DOUBLE_SILL_ID, 
				() -> new DoubleSillBlock(BlockBehaviour.Properties.copy(Blocks.GILDED_BLACKSTONE)));
		POLISHED_BLACKSTONE_BRICKS_DOUBLE_SILL = Registration.BLOCKS.register(
				BlockID.POLISHED_BLACKSTONE_BRICKS_DOUBLE_SILL_ID, 
				() -> new DoubleSillBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE_BRICKS)));
		CRACKED_POLISHED_BLACKSTONE_BRICKS_DOUBLE_SILL = Registration.BLOCKS.register(
				BlockID.CRACKED_POLISHED_BLACKSTONE_BRICKS_DOUBLE_SILL_ID, 
				() -> new DoubleSillBlock(BlockBehaviour.Properties.copy(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS)));
		DEEPSLATE_DOUBLE_SILL = Registration.BLOCKS.register(
				BlockID.DEEPSLATE_DOUBLE_SILL_ID, 
				() -> new DoubleSillBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));
		DEEPSLATE_BRICKS_DOUBLE_SILL = Registration.BLOCKS.register(
				BlockID.DEEPSLATE_BRICKS_DOUBLE_SILL_ID, 
				() -> new DoubleSillBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICKS)));
		CRACKED_DEEPSLATE_BRICKS_DOUBLE_SILL = Registration.BLOCKS.register(
				BlockID.CRACKED_DEEPSLATE_BRICKS_DOUBLE_SILL_ID, 
				() -> new DoubleSillBlock(BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_BRICKS)));
		COBBLED_DEEPSLATE_DOUBLE_SILL = Registration.BLOCKS.register(
				BlockID.COBBLED_DEEPSLATE_DOUBLE_SILL_ID, 
				() -> new DoubleSillBlock(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE)));
		POLISHED_DEEPSLATE_DOUBLE_SILL = Registration.BLOCKS.register(
				BlockID.POLISHED_DEEPSLATE_DOUBLE_SILL_ID, 
				() -> new DoubleSillBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_DEEPSLATE)));
		CHISELED_DEEPSLATE_DOUBLE_SILL = Registration.BLOCKS.register(
				BlockID.CHISELED_DEEPSLATE_DOUBLE_SILL_ID, 
				() -> new DoubleSillBlock(BlockBehaviour.Properties.copy(Blocks.CHISELED_DEEPSLATE)));
		DEEPSLATE_TILES_DOUBLE_SILL = Registration.BLOCKS.register(
				BlockID.DEEPSLATE_TILES_DOUBLE_SILL_ID, 
				() -> new DoubleSillBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_TILES)));
		CRACKED_DEEPSLATE_TILES_DOUBLE_SILL = Registration.BLOCKS.register(
				BlockID.CRACKED_DEEPSLATE_TILES_DOUBLE_SILL_ID, 
				() -> new DoubleSillBlock(BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_TILES)));

		// Cornice
		STONE_CORNICE = Registration.BLOCKS.register(BlockID.STONE_CORNICE_ID,
				() -> new CorniceBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		SMOOTH_STONE_CORNICE = Registration.BLOCKS.register(BlockID.SMOOTH_STONE_CORNICE_ID,
				() -> new CorniceBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		COBBLESTONE_CORNICE = Registration.BLOCKS.register(BlockID.COBBLESTONE_CORNICE_ID,
				() -> new CorniceBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		MOSSY_COBBLESTONE_CORNICE = Registration.BLOCKS.register(BlockID.MOSSY_COBBLESTONE_CORNICE_ID,
				() -> new CorniceBlock(Properties.of().mapColor(MapColor.STONE).strength(2.0F, 6.0F)));
		BRICKS_CORNICE = Registration.BLOCKS.register(BlockID.BRICKS_CORNICE_ID,
				() -> new CorniceBlock(Properties.of().mapColor(MapColor.COLOR_RED).strength(2.0F, 6.0F)));
		STONE_BRICKS_CORNICE = Registration.BLOCKS.register(BlockID.STONE_BRICKS_CORNICE_ID,
				() -> new CorniceBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		MOSSY_STONE_BRICKS_CORNICE = Registration.BLOCKS.register(BlockID.MOSSY_STONE_BRICKS_CORNICE_ID,
				() -> new CorniceBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		CRACKED_STONE_BRICKS_CORNICE = Registration.BLOCKS.register(BlockID.CRACKED_STONE_BRICKS_CORNICE_ID,
				() -> new CorniceBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		CHISELED_STONE_BRICKS_CORNICE = Registration.BLOCKS.register(BlockID.CHISELED_STONE_BRICKS_CORNICE_ID,
				() -> new CorniceBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		OBSIDIAN_CORNICE = Registration.BLOCKS.register(BlockID.OBSIDIAN_CORNICE_ID,
				() -> new CorniceBlock(Properties.of().mapColor(MapColor.STONE).strength(50.0F, 1200.0F)));

		SANDSTONE_CORNICE = Registration.BLOCKS.register(BlockID.SANDSTONE_CORNICE_ID,
				() -> new CorniceBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		SMOOTH_SANDSTONE_CORNICE = Registration.BLOCKS.register(BlockID.SMOOTH_SANDSTONE_CORNICE_ID,
				() -> new CorniceBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		CHISELED_SANDSTONE_CORNICE = Registration.BLOCKS.register(BlockID.CHISELED_SANDSTONE_CORNICE_ID,
				() -> new CorniceBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		CUT_SANDSTONE_CORNICE = Registration.BLOCKS.register(BlockID.CUT_SANDSTONE_CORNICE_ID,
				() -> new CorniceBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		RED_SANDSTONE_CORNICE = Registration.BLOCKS.register(BlockID.RED_SANDSTONE_CORNICE_ID,
				() -> new CorniceBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		SMOOTH_RED_SANDSTONE_CORNICE = Registration.BLOCKS.register(BlockID.SMOOTH_RED_SANDSTONE_CORNICE_ID,
				() -> new CorniceBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		CHISELED_RED_SANDSTONE_CORNICE = Registration.BLOCKS.register(BlockID.CHISELED_RED_SANDSTONE_CORNICE_ID,
				() -> new CorniceBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		CUT_RED_SANDSTONE_CORNICE = Registration.BLOCKS.register(BlockID.CUT_RED_SANDSTONE_CORNICE_ID,
				() -> new CorniceBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));

		GRANITE_CORNICE = Registration.BLOCKS.register(BlockID.GRANITE_CORNICE_ID,
				() -> new CorniceBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		POLISHED_GRANITE_CORNICE = Registration.BLOCKS.register(BlockID.POLISHED_GRANITE_CORNICE_ID,
				() -> new CorniceBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		DIORITE_CORNICE = Registration.BLOCKS.register(BlockID.DIORITE_CORNICE_ID,
				() -> new CorniceBlock(Properties.of().mapColor(MapColor.QUARTZ).strength(1.5F, 6.0F)));
		POLISHED_DIORITE_CORNICE = Registration.BLOCKS.register(BlockID.POLISHED_DIORITE_CORNICE_ID,
				() -> new CorniceBlock(Properties.of().mapColor(MapColor.QUARTZ).strength(1.5F, 6.0F)));
		ANDESITE_CORNICE = Registration.BLOCKS.register(BlockID.ANDESITE_CORNICE_ID,
				() -> new CorniceBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		POLISHED_ANDESITE_CORNICE = Registration.BLOCKS.register(BlockID.POLISHED_ANDESITE_CORNICE_ID,
				() -> new CorniceBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		BLACKSTONE_CORNICE = Registration.BLOCKS.register(
				BlockID.BLACKSTONE_CORNICE_ID, 
				() -> new CorniceBlock(BlockBehaviour.Properties.copy(Blocks.BLACKSTONE)));
		POLISHED_BLACKSTONE_CORNICE = Registration.BLOCKS.register(
				BlockID.POLISHED_BLACKSTONE_CORNICE_ID, 
				() -> new CorniceBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE)));
		CHISELED_POLISHED_BLACKSTONE_CORNICE = Registration.BLOCKS.register(
				BlockID.CHISELED_POLISHED_BLACKSTONE_CORNICE_ID, 
				() -> new CorniceBlock(BlockBehaviour.Properties.copy(Blocks.CHISELED_POLISHED_BLACKSTONE)));
		GILDED_BLACKSTONE_CORNICE = Registration.BLOCKS.register(
				BlockID.GILDED_BLACKSTONE_CORNICE_ID, 
				() -> new CorniceBlock(BlockBehaviour.Properties.copy(Blocks.GILDED_BLACKSTONE)));
		POLISHED_BLACKSTONE_BRICKS_CORNICE = Registration.BLOCKS.register(
				BlockID.POLISHED_BLACKSTONE_BRICKS_CORNICE_ID, 
				() -> new CorniceBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE_BRICKS)));
		CRACKED_POLISHED_BLACKSTONE_BRICKS_CORNICE = Registration.BLOCKS.register(
				BlockID.CRACKED_POLISHED_BLACKSTONE_BRICKS_CORNICE_ID, 
				() -> new CorniceBlock(BlockBehaviour.Properties.copy(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS)));
		DEEPSLATE_CORNICE = Registration.BLOCKS.register(
				BlockID.DEEPSLATE_CORNICE_ID, 
				() -> new CorniceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));
		DEEPSLATE_BRICKS_CORNICE = Registration.BLOCKS.register(
				BlockID.DEEPSLATE_BRICKS_CORNICE_ID, 
				() -> new CorniceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICKS)));
		CRACKED_DEEPSLATE_BRICKS_CORNICE = Registration.BLOCKS.register(
				BlockID.CRACKED_DEEPSLATE_BRICKS_CORNICE_ID, 
				() -> new CorniceBlock(BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_BRICKS)));
		COBBLED_DEEPSLATE_CORNICE = Registration.BLOCKS.register(
				BlockID.COBBLED_DEEPSLATE_CORNICE_ID, 
				() -> new CorniceBlock(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE)));
		POLISHED_DEEPSLATE_CORNICE = Registration.BLOCKS.register(
				BlockID.POLISHED_DEEPSLATE_CORNICE_ID, 
				() -> new CorniceBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_DEEPSLATE)));
		CHISELED_DEEPSLATE_CORNICE = Registration.BLOCKS.register(
				BlockID.CHISELED_DEEPSLATE_CORNICE_ID, 
				() -> new CorniceBlock(BlockBehaviour.Properties.copy(Blocks.CHISELED_DEEPSLATE)));
		DEEPSLATE_TILES_CORNICE = Registration.BLOCKS.register(
				BlockID.DEEPSLATE_TILES_CORNICE_ID, 
				() -> new CorniceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_TILES)));
		CRACKED_DEEPSLATE_TILES_CORNICE = Registration.BLOCKS.register(
				BlockID.CRACKED_DEEPSLATE_TILES_CORNICE_ID, 
				() -> new CorniceBlock(BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_TILES)));

		// crown molding
		STONE_CROWN_MOLDING = Registration.BLOCKS.register(BlockID.STONE_CROWN_MOLDING_ID,
				() -> new CrownMoldingBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		SMOOTH_STONE_CROWN_MOLDING = Registration.BLOCKS.register(BlockID.SMOOTH_STONE_CROWN_MOLDING_ID,
				() -> new CrownMoldingBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		COBBLESTONE_CROWN_MOLDING = Registration.BLOCKS.register(BlockID.COBBLESTONE_CROWN_MOLDING_ID,
				() -> new CrownMoldingBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		MOSSY_COBBLESTONE_CROWN_MOLDING = Registration.BLOCKS.register(
				BlockID.MOSSY_COBBLESTONE_CROWN_MOLDING_ID,
				() -> new CrownMoldingBlock(Properties.of().mapColor(MapColor.STONE).strength(2.0F, 6.0F)));
		BRICKS_CROWN_MOLDING = Registration.BLOCKS.register(BlockID.BRICKS_CROWN_MOLDING_ID,
				() -> new CrownMoldingBlock(Properties.of().mapColor(MapColor.COLOR_RED).strength(2.0F, 6.0F)));
		STONE_BRICKS_CROWN_MOLDING = Registration.BLOCKS.register(BlockID.STONE_BRICKS_CROWN_MOLDING_ID,
				() -> new CrownMoldingBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		MOSSY_STONE_BRICKS_CROWN_MOLDING = Registration.BLOCKS.register(
				BlockID.MOSSY_STONE_BRICKS_CROWN_MOLDING_ID,
				() -> new CrownMoldingBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		CRACKED_STONE_BRICKS_CROWN_MOLDING = Registration.BLOCKS.register(
				BlockID.CRACKED_STONE_BRICKS_CROWN_MOLDING_ID,
				() -> new CrownMoldingBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		CHISELED_STONE_BRICKS_CROWN_MOLDING = Registration.BLOCKS.register(
				BlockID.CHISELED_STONE_BRICKS_CROWN_MOLDING_ID,
				() -> new CrownMoldingBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		OBSIDIAN_CROWN_MOLDING = Registration.BLOCKS.register(BlockID.OBSIDIAN_CROWN_MOLDING_ID,
				() -> new CrownMoldingBlock(Properties.of().mapColor(MapColor.STONE).strength(50.0F, 1200.0F)));

		SANDSTONE_CROWN_MOLDING = Registration.BLOCKS.register(BlockID.SANDSTONE_CROWN_MOLDING_ID,
				() -> new CrownMoldingBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		SMOOTH_SANDSTONE_CROWN_MOLDING = Registration.BLOCKS.register(
				BlockID.SMOOTH_SANDSTONE_CROWN_MOLDING_ID,
				() -> new CrownMoldingBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		CHISELED_SANDSTONE_CROWN_MOLDING = Registration.BLOCKS.register(
				BlockID.CHISELED_SANDSTONE_CROWN_MOLDING_ID,
				() -> new CrownMoldingBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		CUT_SANDSTONE_CROWN_MOLDING = Registration.BLOCKS.register(
				BlockID.CUT_SANDSTONE_CROWN_MOLDING_ID,
				() -> new CrownMoldingBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		RED_SANDSTONE_CROWN_MOLDING = Registration.BLOCKS.register(
				BlockID.RED_SANDSTONE_CROWN_MOLDING_ID,
				() -> new CrownMoldingBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		SMOOTH_RED_SANDSTONE_CROWN_MOLDING = Registration.BLOCKS.register(
				BlockID.SMOOTH_RED_SANDSTONE_CROWN_MOLDING_ID,
				() -> new CrownMoldingBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		CHISELED_RED_SANDSTONE_CROWN_MOLDING = Registration.BLOCKS.register(
				BlockID.CHISELED_RED_SANDSTONE_CROWN_MOLDING_ID,
				() -> new CrownMoldingBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		CUT_RED_SANDSTONE_CROWN_MOLDING = Registration.BLOCKS.register(
				BlockID.CUT_RED_SANDSTONE_CROWN_MOLDING_ID,
				() -> new CrownMoldingBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));

		GRANITE_CROWN_MOLDING = Registration.BLOCKS.register(BlockID.GRANITE_CROWN_MOLDING_ID,
				() -> new CrownMoldingBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		POLISHED_GRANITE_CROWN_MOLDING = Registration.BLOCKS.register(
				BlockID.POLISHED_GRANITE_CROWN_MOLDING_ID,
				() -> new CrownMoldingBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		DIORITE_CROWN_MOLDING = Registration.BLOCKS.register(BlockID.DIORITE_CROWN_MOLDING_ID,
				() -> new CrownMoldingBlock(Properties.of().mapColor(MapColor.QUARTZ).strength(1.5F, 6.0F)));
		POLISHED_DIORITE_CROWN_MOLDING = Registration.BLOCKS.register(
				BlockID.POLISHED_DIORITE_CROWN_MOLDING_ID,
				() -> new CrownMoldingBlock(Properties.of().mapColor(MapColor.QUARTZ).strength(1.5F, 6.0F)));
		ANDESITE_CROWN_MOLDING = Registration.BLOCKS.register(BlockID.ANDESITE_CROWN_MOLDING_ID,
				() -> new CrownMoldingBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		POLISHED_ANDESITE_CROWN_MOLDING = Registration.BLOCKS.register(
				BlockID.POLISHED_ANDESITE_CROWN_MOLDING_ID,
				() -> new CrownMoldingBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		BLACKSTONE_CROWN_MOLDING = Registration.BLOCKS.register(
				BlockID.BLACKSTONE_CROWN_MOLDING_ID, 
				() -> new CrownMoldingBlock(BlockBehaviour.Properties.copy(Blocks.BLACKSTONE)));
		POLISHED_BLACKSTONE_CROWN_MOLDING = Registration.BLOCKS.register(
				BlockID.POLISHED_BLACKSTONE_CROWN_MOLDING_ID, 
				() -> new CrownMoldingBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE)));
		CHISELED_POLISHED_BLACKSTONE_CROWN_MOLDING = Registration.BLOCKS.register(
				BlockID.CHISELED_POLISHED_BLACKSTONE_CROWN_MOLDING_ID, 
				() -> new CrownMoldingBlock(BlockBehaviour.Properties.copy(Blocks.CHISELED_POLISHED_BLACKSTONE)));
		GILDED_BLACKSTONE_CROWN_MOLDING = Registration.BLOCKS.register(
				BlockID.GILDED_BLACKSTONE_CROWN_MOLDING_ID, 
				() -> new CrownMoldingBlock(BlockBehaviour.Properties.copy(Blocks.GILDED_BLACKSTONE)));
		POLISHED_BLACKSTONE_BRICKS_CROWN_MOLDING = Registration.BLOCKS.register(
				BlockID.POLISHED_BLACKSTONE_BRICKS_CROWN_MOLDING_ID, 
				() -> new CrownMoldingBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE_BRICKS)));
		CRACKED_POLISHED_BLACKSTONE_BRICKS_CROWN_MOLDING = Registration.BLOCKS.register(
				BlockID.CRACKED_POLISHED_BLACKSTONE_BRICKS_CROWN_MOLDING_ID, 
				() -> new CrownMoldingBlock(BlockBehaviour.Properties.copy(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS)));
		DEEPSLATE_CROWN_MOLDING = Registration.BLOCKS.register(
				BlockID.DEEPSLATE_CROWN_MOLDING_ID, 
				() -> new CrownMoldingBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));
		DEEPSLATE_BRICKS_CROWN_MOLDING = Registration.BLOCKS.register(
				BlockID.DEEPSLATE_BRICKS_CROWN_MOLDING_ID, 
				() -> new CrownMoldingBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICKS)));
		CRACKED_DEEPSLATE_BRICKS_CROWN_MOLDING = Registration.BLOCKS.register(
				BlockID.CRACKED_DEEPSLATE_BRICKS_CROWN_MOLDING_ID, 
				() -> new CrownMoldingBlock(BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_BRICKS)));
		COBBLED_DEEPSLATE_CROWN_MOLDING = Registration.BLOCKS.register(
				BlockID.COBBLED_DEEPSLATE_CROWN_MOLDING_ID, 
				() -> new CrownMoldingBlock(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE)));
		POLISHED_DEEPSLATE_CROWN_MOLDING = Registration.BLOCKS.register(
				BlockID.POLISHED_DEEPSLATE_CROWN_MOLDING_ID, 
				() -> new CrownMoldingBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_DEEPSLATE)));
		CHISELED_DEEPSLATE_CROWN_MOLDING = Registration.BLOCKS.register(
				BlockID.CHISELED_DEEPSLATE_CROWN_MOLDING_ID, 
				() -> new CrownMoldingBlock(BlockBehaviour.Properties.copy(Blocks.CHISELED_DEEPSLATE)));
		DEEPSLATE_TILES_CROWN_MOLDING = Registration.BLOCKS.register(
				BlockID.DEEPSLATE_TILES_CROWN_MOLDING_ID, 
				() -> new CrownMoldingBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_TILES)));
		CRACKED_DEEPSLATE_TILES_CROWN_MOLDING = Registration.BLOCKS.register(
				BlockID.CRACKED_DEEPSLATE_TILES_CROWN_MOLDING_ID, 
				() -> new CrownMoldingBlock(BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_TILES)));

		// pillar base
		STONE_PILLAR_BASE = Registration.BLOCKS.register(BlockID.STONE_PILLAR_BASE_ID,
				() -> new PillarBaseBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		SMOOTH_STONE_PILLAR_BASE = Registration.BLOCKS.register(BlockID.SMOOTH_STONE_PILLAR_BASE_ID,
				() -> new PillarBaseBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		COBBLESTONE_PILLAR_BASE = Registration.BLOCKS.register(BlockID.COBBLESTONE_PILLAR_BASE_ID,
				() -> new PillarBaseBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		MOSSY_COBBLESTONE_PILLAR_BASE = Registration.BLOCKS.register(
				BlockID.MOSSY_COBBLESTONE_PILLAR_BASE_ID,
				() -> new PillarBaseBlock(Properties.of().mapColor(MapColor.STONE).strength(2.0F, 6.0F)));
		BRICKS_PILLAR_BASE = Registration.BLOCKS.register(BlockID.BRICKS_PILLAR_BASE_ID,
				() -> new PillarBaseBlock(Properties.of().mapColor(MapColor.COLOR_RED).strength(2.0F, 6.0F)));
		STONE_BRICKS_PILLAR_BASE = Registration.BLOCKS.register(BlockID.STONE_BRICKS_PILLAR_BASE_ID,
				() -> new PillarBaseBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		MOSSY_STONE_BRICKS_PILLAR_BASE = Registration.BLOCKS.register(
				BlockID.MOSSY_STONE_BRICKS_PILLAR_BASE_ID,
				() -> new PillarBaseBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		CRACKED_STONE_BRICKS_PILLAR_BASE = Registration.BLOCKS.register(
				BlockID.CRACKED_STONE_BRICKS_PILLAR_BASE_ID,
				() -> new PillarBaseBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		CHISELED_STONE_BRICKS_PILLAR_BASE = Registration.BLOCKS.register(
				BlockID.CHISELED_STONE_BRICKS_PILLAR_BASE_ID,
				() -> new PillarBaseBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		OBSIDIAN_PILLAR_BASE = Registration.BLOCKS.register(BlockID.OBSIDIAN_PILLAR_BASE_ID,
				() -> new PillarBaseBlock(Properties.of().mapColor(MapColor.STONE).strength(50.0F, 1200.0F)));

		SANDSTONE_PILLAR_BASE = Registration.BLOCKS.register(BlockID.SANDSTONE_PILLAR_BASE_ID,
				() -> new PillarBaseBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		SMOOTH_SANDSTONE_PILLAR_BASE = Registration.BLOCKS.register(
				BlockID.SMOOTH_SANDSTONE_PILLAR_BASE_ID,
				() -> new PillarBaseBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		CHISELED_SANDSTONE_PILLAR_BASE = Registration.BLOCKS.register(
				BlockID.CHISELED_SANDSTONE_PILLAR_BASE_ID,
				() -> new PillarBaseBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		CUT_SANDSTONE_PILLAR_BASE = Registration.BLOCKS.register(BlockID.CUT_SANDSTONE_PILLAR_BASE_ID,
				() -> new PillarBaseBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		RED_SANDSTONE_PILLAR_BASE = Registration.BLOCKS.register(BlockID.RED_SANDSTONE_PILLAR_BASE_ID,
				() -> new PillarBaseBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		SMOOTH_RED_SANDSTONE_PILLAR_BASE = Registration.BLOCKS.register(
				BlockID.SMOOTH_RED_SANDSTONE_PILLAR_BASE_ID,
				() -> new PillarBaseBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		CHISELED_RED_SANDSTONE_PILLAR_BASE = Registration.BLOCKS.register(
				BlockID.CHISELED_RED_SANDSTONE_PILLAR_BASE_ID,
				() -> new PillarBaseBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		CUT_RED_SANDSTONE_PILLAR_BASE = Registration.BLOCKS.register(
				BlockID.CUT_RED_SANDSTONE_PILLAR_BASE_ID,
				() -> new PillarBaseBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));

		GRANITE_PILLAR_BASE = Registration.BLOCKS.register(BlockID.GRANITE_PILLAR_BASE_ID,
				() -> new PillarBaseBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		POLISHED_GRANITE_PILLAR_BASE = Registration.BLOCKS.register(
				BlockID.POLISHED_GRANITE_PILLAR_BASE_ID,
				() -> new PillarBaseBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		DIORITE_PILLAR_BASE = Registration.BLOCKS.register(BlockID.DIORITE_PILLAR_BASE_ID,
				() -> new PillarBaseBlock(Properties.of().mapColor(MapColor.QUARTZ).strength(1.5F, 6.0F)));
		POLISHED_DIORITE_PILLAR_BASE = Registration.BLOCKS.register(
				BlockID.POLISHED_DIORITE_PILLAR_BASE_ID,
				() -> new PillarBaseBlock(Properties.of().mapColor(MapColor.QUARTZ).strength(1.5F, 6.0F)));
		ANDESITE_PILLAR_BASE = Registration.BLOCKS.register(BlockID.ANDESITE_PILLAR_BASE_ID,
				() -> new PillarBaseBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		POLISHED_ANDESITE_PILLAR_BASE = Registration.BLOCKS.register(
				BlockID.POLISHED_ANDESITE_PILLAR_BASE_ID,
				() -> new PillarBaseBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		BLACKSTONE_PILLAR_BASE = Registration.BLOCKS.register(
				BlockID.BLACKSTONE_PILLAR_BASE_ID, 
				() -> new PillarBaseBlock(BlockBehaviour.Properties.copy(Blocks.BLACKSTONE)));
		POLISHED_BLACKSTONE_PILLAR_BASE = Registration.BLOCKS.register(
				BlockID.POLISHED_BLACKSTONE_PILLAR_BASE_ID, 
				() -> new PillarBaseBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE)));
		CHISELED_POLISHED_BLACKSTONE_PILLAR_BASE = Registration.BLOCKS.register(
				BlockID.CHISELED_POLISHED_BLACKSTONE_PILLAR_BASE_ID, 
				() -> new PillarBaseBlock(BlockBehaviour.Properties.copy(Blocks.CHISELED_POLISHED_BLACKSTONE)));
		GILDED_BLACKSTONE_PILLAR_BASE = Registration.BLOCKS.register(
				BlockID.GILDED_BLACKSTONE_PILLAR_BASE_ID, 
				() -> new PillarBaseBlock(BlockBehaviour.Properties.copy(Blocks.GILDED_BLACKSTONE)));
		POLISHED_BLACKSTONE_BRICKS_PILLAR_BASE = Registration.BLOCKS.register(
				BlockID.POLISHED_BLACKSTONE_BRICKS_PILLAR_BASE_ID, 
				() -> new PillarBaseBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE_BRICKS)));
		CRACKED_POLISHED_BLACKSTONE_BRICKS_PILLAR_BASE = Registration.BLOCKS.register(
				BlockID.CRACKED_POLISHED_BLACKSTONE_BRICKS_PILLAR_BASE_ID, 
				() -> new PillarBaseBlock(BlockBehaviour.Properties.copy(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS)));
		DEEPSLATE_PILLAR_BASE = Registration.BLOCKS.register(
				BlockID.DEEPSLATE_PILLAR_BASE_ID, 
				() -> new PillarBaseBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));
		DEEPSLATE_BRICKS_PILLAR_BASE = Registration.BLOCKS.register(
				BlockID.DEEPSLATE_BRICKS_PILLAR_BASE_ID, 
				() -> new PillarBaseBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICKS)));
		CRACKED_DEEPSLATE_BRICKS_PILLAR_BASE = Registration.BLOCKS.register(
				BlockID.CRACKED_DEEPSLATE_BRICKS_PILLAR_BASE_ID, 
				() -> new PillarBaseBlock(BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_BRICKS)));
		COBBLED_DEEPSLATE_PILLAR_BASE = Registration.BLOCKS.register(
				BlockID.COBBLED_DEEPSLATE_PILLAR_BASE_ID, 
				() -> new PillarBaseBlock(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE)));
		POLISHED_DEEPSLATE_PILLAR_BASE = Registration.BLOCKS.register(
				BlockID.POLISHED_DEEPSLATE_PILLAR_BASE_ID, 
				() -> new PillarBaseBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_DEEPSLATE)));
		CHISELED_DEEPSLATE_PILLAR_BASE = Registration.BLOCKS.register(
				BlockID.CHISELED_DEEPSLATE_PILLAR_BASE_ID, 
				() -> new PillarBaseBlock(BlockBehaviour.Properties.copy(Blocks.CHISELED_DEEPSLATE)));
		DEEPSLATE_TILES_PILLAR_BASE = Registration.BLOCKS.register(
				BlockID.DEEPSLATE_TILES_PILLAR_BASE_ID, 
				() -> new PillarBaseBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_TILES)));
		CRACKED_DEEPSLATE_TILES_PILLAR_BASE = Registration.BLOCKS.register(
				BlockID.CRACKED_DEEPSLATE_TILES_PILLAR_BASE_ID, 
				() -> new PillarBaseBlock(BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_TILES)));

		// pillar
		STONE_PILLAR = Registration.BLOCKS.register(BlockID.STONE_PILLAR_ID,
				() -> new PillarBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		SMOOTH_STONE_PILLAR = Registration.BLOCKS.register(BlockID.SMOOTH_STONE_PILLAR_ID,
				() -> new PillarBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		COBBLESTONE_PILLAR = Registration.BLOCKS.register(BlockID.COBBLESTONE_PILLAR_ID,
				() -> new PillarBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		MOSSY_COBBLESTONE_PILLAR = Registration.BLOCKS.register(BlockID.MOSSY_COBBLESTONE_PILLAR_ID,
				() -> new PillarBlock(Properties.of().mapColor(MapColor.STONE).strength(2.0F, 6.0F)));
		BRICKS_PILLAR = Registration.BLOCKS.register(BlockID.BRICKS_PILLAR_ID,
				() -> new PillarBlock(Properties.of().mapColor(MapColor.COLOR_RED).strength(2.0F, 6.0F)));
		STONE_BRICKS_PILLAR = Registration.BLOCKS.register(BlockID.STONE_BRICKS_PILLAR_ID,
				() -> new PillarBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		MOSSY_STONE_BRICKS_PILLAR = Registration.BLOCKS.register(BlockID.MOSSY_STONE_BRICKS_PILLAR_ID,
				() -> new PillarBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		CRACKED_STONE_BRICKS_PILLAR = Registration.BLOCKS.register(BlockID.CRACKED_STONE_BRICKS_PILLAR_ID,
				() -> new PillarBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		CHISELED_STONE_BRICKS_PILLAR = Registration.BLOCKS.register(BlockID.CHISELED_STONE_BRICKS_PILLAR_ID,
				() -> new PillarBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		OBSIDIAN_PILLAR = Registration.BLOCKS.register(BlockID.OBSIDIAN_PILLAR_ID,
				() -> new PillarBlock(Properties.of().mapColor(MapColor.STONE).strength(50.0F, 1200.0F)));

		SANDSTONE_PILLAR = Registration.BLOCKS.register(BlockID.SANDSTONE_PILLAR_ID,
				() -> new PillarBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		SMOOTH_SANDSTONE_PILLAR = Registration.BLOCKS.register(BlockID.SMOOTH_SANDSTONE_PILLAR_ID,
				() -> new PillarBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		CHISELED_SANDSTONE_PILLAR = Registration.BLOCKS.register(BlockID.CHISELED_SANDSTONE_PILLAR_ID,
				() -> new PillarBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		CUT_SANDSTONE_PILLAR = Registration.BLOCKS.register(BlockID.CUT_SANDSTONE_PILLAR_ID,
				() -> new PillarBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		RED_SANDSTONE_PILLAR = Registration.BLOCKS.register(BlockID.RED_SANDSTONE_PILLAR_ID,
				() -> new PillarBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		SMOOTH_RED_SANDSTONE_PILLAR = Registration.BLOCKS.register(BlockID.SMOOTH_RED_SANDSTONE_PILLAR_ID,
				() -> new PillarBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		CHISELED_RED_SANDSTONE_PILLAR = Registration.BLOCKS.register(BlockID.CHISELED_RED_SANDSTONE_PILLAR_ID,
				() -> new PillarBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));
		CUT_RED_SANDSTONE_PILLAR = Registration.BLOCKS.register(BlockID.CUT_RED_SANDSTONE_PILLAR_ID,
				() -> new PillarBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)));

		GRANITE_PILLAR = Registration.BLOCKS.register(BlockID.GRANITE_PILLAR_ID,
				() -> new PillarBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		POLISHED_GRANITE_PILLAR = Registration.BLOCKS.register(BlockID.POLISHED_GRANITE_PILLAR_ID,
				() -> new PillarBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		DIORITE_PILLAR = Registration.BLOCKS.register(BlockID.DIORITE_PILLAR_ID,
				() -> new PillarBlock(Properties.of().mapColor(MapColor.QUARTZ).strength(1.5F, 6.0F)));
		POLISHED_DIORITE_PILLAR = Registration.BLOCKS.register(BlockID.POLISHED_DIORITE_PILLAR_ID,
				() -> new PillarBlock(Properties.of().mapColor(MapColor.QUARTZ).strength(1.5F, 6.0F)));
		ANDESITE_PILLAR = Registration.BLOCKS.register(BlockID.ANDESITE_PILLAR_ID,
				() -> new PillarBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		POLISHED_ANDESITE_PILLAR = Registration.BLOCKS.register(BlockID.POLISHED_ANDESITE_PILLAR_ID,
				() -> new PillarBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
		BLACKSTONE_PILLAR = Registration.BLOCKS.register(
				BlockID.BLACKSTONE_PILLAR_ID, 
				() -> new PillarBlock(BlockBehaviour.Properties.copy(Blocks.BLACKSTONE)));
		POLISHED_BLACKSTONE_PILLAR = Registration.BLOCKS.register(
				BlockID.POLISHED_BLACKSTONE_PILLAR_ID, 
				() -> new PillarBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE)));
		CHISELED_POLISHED_BLACKSTONE_PILLAR = Registration.BLOCKS.register(
				BlockID.CHISELED_POLISHED_BLACKSTONE_PILLAR_ID, 
				() -> new PillarBlock(BlockBehaviour.Properties.copy(Blocks.CHISELED_POLISHED_BLACKSTONE)));
		GILDED_BLACKSTONE_PILLAR = Registration.BLOCKS.register(
				BlockID.GILDED_BLACKSTONE_PILLAR_ID, 
				() -> new PillarBlock(BlockBehaviour.Properties.copy(Blocks.GILDED_BLACKSTONE)));
		POLISHED_BLACKSTONE_BRICKS_PILLAR = Registration.BLOCKS.register(
				BlockID.POLISHED_BLACKSTONE_BRICKS_PILLAR_ID, 
				() -> new PillarBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE_BRICKS)));
		CRACKED_POLISHED_BLACKSTONE_BRICKS_PILLAR = Registration.BLOCKS.register(
				BlockID.CRACKED_POLISHED_BLACKSTONE_BRICKS_PILLAR_ID, 
				() -> new PillarBlock(BlockBehaviour.Properties.copy(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS)));
		DEEPSLATE_PILLAR = Registration.BLOCKS.register(
				BlockID.DEEPSLATE_PILLAR_ID, 
				() -> new PillarBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));
		DEEPSLATE_BRICKS_PILLAR = Registration.BLOCKS.register(
				BlockID.DEEPSLATE_BRICKS_PILLAR_ID, 
				() -> new PillarBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICKS)));
		CRACKED_DEEPSLATE_BRICKS_PILLAR = Registration.BLOCKS.register(
				BlockID.CRACKED_DEEPSLATE_BRICKS_PILLAR_ID, 
				() -> new PillarBlock(BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_BRICKS)));
		COBBLED_DEEPSLATE_PILLAR = Registration.BLOCKS.register(
				BlockID.COBBLED_DEEPSLATE_PILLAR_ID, 
				() -> new PillarBlock(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE)));
		POLISHED_DEEPSLATE_PILLAR = Registration.BLOCKS.register(
				BlockID.POLISHED_DEEPSLATE_PILLAR_ID, 
				() -> new PillarBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_DEEPSLATE)));
		CHISELED_DEEPSLATE_PILLAR = Registration.BLOCKS.register(
				BlockID.CHISELED_DEEPSLATE_PILLAR_ID, 
				() -> new PillarBlock(BlockBehaviour.Properties.copy(Blocks.CHISELED_DEEPSLATE)));
		DEEPSLATE_TILES_PILLAR = Registration.BLOCKS.register(
				BlockID.DEEPSLATE_TILES_PILLAR_ID, 
				() -> new PillarBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_TILES)));
		CRACKED_DEEPSLATE_TILES_PILLAR = Registration.BLOCKS.register(
				BlockID.CRACKED_DEEPSLATE_TILES_PILLAR_ID, 
				() -> new PillarBlock(BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_TILES)));

		// wall sconce
		STONE_WALL_SCONCE = Registration.BLOCKS.register(BlockID.STONE_WALL_SCONCE_ID,
				() -> new SconceBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)
				.noCollission().lightLevel((light)->{return  14;}).sound(SoundType.WOOD)));
		SMOOTH_STONE_WALL_SCONCE = Registration.BLOCKS.register(BlockID.SMOOTH_STONE_WALL_SCONCE_ID,
				() -> new SconceBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)
				.noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD)));
		COBBLESTONE_WALL_SCONCE = Registration.BLOCKS.register(BlockID.COBBLESTONE_WALL_SCONCE_ID,
				() -> new SconceBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)
				.noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD)));
		MOSSY_COBBLESTONE_WALL_SCONCE = Registration.BLOCKS.register(BlockID.MOSSY_COBBLESTONE_WALL_SCONCE_ID,
				() -> new SconceBlock(Properties.of().mapColor(MapColor.STONE).strength(2.0F, 6.0F).noCollission()
				.lightLevel((light)->{return 14;}).sound(SoundType.WOOD)));
		BRICKS_WALL_SCONCE = Registration.BLOCKS.register(BlockID.BRICKS_WALL_SCONCE_ID,
				() -> new SconceBlock(Properties.of().mapColor(MapColor.COLOR_RED).strength(2.0F, 6.0F)
				.noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD)));
		STONE_BRICKS_WALL_SCONCE = Registration.BLOCKS.register(BlockID.STONE_BRICKS_WALL_SCONCE_ID,
				() -> new SconceBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F).noCollission()
				.lightLevel((light)->{return 14;}).sound(SoundType.WOOD)));
		MOSSY_STONE_BRICKS_WALL_SCONCE = Registration.BLOCKS.register(
				BlockID.MOSSY_STONE_BRICKS_WALL_SCONCE_ID, 
				() -> new SconceBlock(Properties.of().mapColor(MapColor.STONE)
				.strength(1.5F, 6.0F).noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD)));
		CRACKED_STONE_BRICKS_WALL_SCONCE = Registration.BLOCKS.register(
				BlockID.CRACKED_STONE_BRICKS_WALL_SCONCE_ID, 
				() -> new SconceBlock(Properties.of().mapColor(MapColor.STONE)
				.strength(1.5F, 6.0F).noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD)));
		CHISELED_STONE_BRICKS_WALL_SCONCE = Registration.BLOCKS.register(
				BlockID.CHISELED_STONE_BRICKS_WALL_SCONCE_ID, 
				() -> new SconceBlock(Properties.of().mapColor(MapColor.STONE)
				.strength(1.5F, 6.0F).noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD)));
		OBSIDIAN_WALL_SCONCE = Registration.BLOCKS.register(BlockID.OBSIDIAN_WALL_SCONCE_ID,
				() -> new SconceBlock(Properties.of().mapColor(MapColor.STONE).strength(50.0F, 1200.0F)
				.noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD)));

		SANDSTONE_WALL_SCONCE = Registration.BLOCKS.register(BlockID.SANDSTONE_WALL_SCONCE_ID,
				() -> new SconceBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)
				.noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD)));
		SMOOTH_SANDSTONE_WALL_SCONCE = Registration.BLOCKS.register(BlockID.SMOOTH_SANDSTONE_WALL_SCONCE_ID,
				() -> new SconceBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)
				.noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD)));
		CHISELED_SANDSTONE_WALL_SCONCE = Registration.BLOCKS.register(
				BlockID.CHISELED_SANDSTONE_WALL_SCONCE_ID, 
				() -> new SconceBlock(Properties.of().mapColor(MapColor.SAND)
				.strength(0.8F).noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD)));
		CUT_SANDSTONE_WALL_SCONCE = Registration.BLOCKS.register(BlockID.CUT_SANDSTONE_WALL_SCONCE_ID,
				() -> new SconceBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)
				.noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD)));
		RED_SANDSTONE_WALL_SCONCE = Registration.BLOCKS.register(BlockID.RED_SANDSTONE_WALL_SCONCE_ID,
				() -> new SconceBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)
				.noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD)));
		SMOOTH_RED_SANDSTONE_WALL_SCONCE = Registration.BLOCKS.register(
				BlockID.SMOOTH_RED_SANDSTONE_WALL_SCONCE_ID, 
				() -> new SconceBlock(Properties.of().mapColor(MapColor.SAND)
				.strength(0.8F).noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD)));
		CHISELED_RED_SANDSTONE_WALL_SCONCE = Registration.BLOCKS.register(
				BlockID.CHISELED_RED_SANDSTONE_WALL_SCONCE_ID,
				() -> new SconceBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)
				.noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD)));
		CUT_RED_SANDSTONE_WALL_SCONCE = Registration.BLOCKS.register(BlockID.CUT_RED_SANDSTONE_WALL_SCONCE_ID,
				() -> new SconceBlock(Properties.of().mapColor(MapColor.SAND).strength(0.8F)
				.noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD)));

		GRANITE_WALL_SCONCE = Registration.BLOCKS.register(BlockID.GRANITE_WALL_SCONCE_ID,
				() -> new SconceBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)
				.noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD)));
		POLISHED_GRANITE_WALL_SCONCE = Registration.BLOCKS.register(BlockID.POLISHED_GRANITE_WALL_SCONCE_ID,
				() -> new SconceBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)
				.noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD)));
		DIORITE_WALL_SCONCE = Registration.BLOCKS.register(BlockID.DIORITE_WALL_SCONCE_ID,
				() -> new SconceBlock(Properties.of().mapColor(MapColor.QUARTZ).strength(1.5F, 6.0F)
				.noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD)));
		POLISHED_DIORITE_WALL_SCONCE = Registration.BLOCKS.register(BlockID.POLISHED_DIORITE_WALL_SCONCE_ID,
				() -> new SconceBlock(Properties.of().mapColor(MapColor.QUARTZ).strength(1.5F, 6.0F)
				.noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD)));
		ANDESITE_WALL_SCONCE = Registration.BLOCKS.register(BlockID.ANDESITE_WALL_SCONCE_ID,
				() -> new SconceBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)
				.noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD)));
		POLISHED_ANDESITE_WALL_SCONCE = Registration.BLOCKS.register(BlockID.POLISHED_ANDESITE_WALL_SCONCE_ID,
				() -> new SconceBlock(Properties.of().mapColor(MapColor.STONE).strength(1.5F, 6.0F)
				.noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD)));
		BLACKSTONE_WALL_SCONCE = Registration.BLOCKS.register(
				BlockID.BLACKSTONE_WALL_SCONCE_ID, 
				() -> new SconceBlock(BlockBehaviour.Properties.copy(Blocks.BLACKSTONE)));
		POLISHED_BLACKSTONE_WALL_SCONCE = Registration.BLOCKS.register(
				BlockID.POLISHED_BLACKSTONE_WALL_SCONCE_ID, 
				() -> new SconceBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE)));
		CHISELED_POLISHED_BLACKSTONE_WALL_SCONCE = Registration.BLOCKS.register(
				BlockID.CHISELED_POLISHED_BLACKSTONE_WALL_SCONCE_ID, 
				() -> new SconceBlock(BlockBehaviour.Properties.copy(Blocks.CHISELED_POLISHED_BLACKSTONE)));
		GILDED_BLACKSTONE_WALL_SCONCE = Registration.BLOCKS.register(
				BlockID.GILDED_BLACKSTONE_WALL_SCONCE_ID, 
				() -> new SconceBlock(BlockBehaviour.Properties.copy(Blocks.GILDED_BLACKSTONE)));
		POLISHED_BLACKSTONE_BRICKS_WALL_SCONCE = Registration.BLOCKS.register(
				BlockID.POLISHED_BLACKSTONE_BRICKS_WALL_SCONCE_ID, 
				() -> new SconceBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE_BRICKS)));
		CRACKED_POLISHED_BLACKSTONE_BRICKS_WALL_SCONCE = Registration.BLOCKS.register(
				BlockID.CRACKED_POLISHED_BLACKSTONE_BRICKS_WALL_SCONCE_ID, 
				() -> new SconceBlock(BlockBehaviour.Properties.copy(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS)));
		DEEPSLATE_WALL_SCONCE = Registration.BLOCKS.register(
				BlockID.DEEPSLATE_WALL_SCONCE_ID, 
				() -> new SconceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));
		DEEPSLATE_BRICKS_WALL_SCONCE = Registration.BLOCKS.register(
				BlockID.DEEPSLATE_BRICKS_WALL_SCONCE_ID, 
				() -> new SconceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICKS)));
		CRACKED_DEEPSLATE_BRICKS_WALL_SCONCE = Registration.BLOCKS.register(
				BlockID.CRACKED_DEEPSLATE_BRICKS_WALL_SCONCE_ID, 
				() -> new SconceBlock(BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_BRICKS)));
		COBBLED_DEEPSLATE_WALL_SCONCE = Registration.BLOCKS.register(
				BlockID.COBBLED_DEEPSLATE_WALL_SCONCE_ID, 
				() -> new SconceBlock(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE)));
		POLISHED_DEEPSLATE_WALL_SCONCE = Registration.BLOCKS.register(
				BlockID.POLISHED_DEEPSLATE_WALL_SCONCE_ID, 
				() -> new SconceBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_DEEPSLATE)));
		CHISELED_DEEPSLATE_WALL_SCONCE = Registration.BLOCKS.register(
				BlockID.CHISELED_DEEPSLATE_WALL_SCONCE_ID, 
				() -> new SconceBlock(BlockBehaviour.Properties.copy(Blocks.CHISELED_DEEPSLATE)));
		DEEPSLATE_TILES_WALL_SCONCE = Registration.BLOCKS.register(
				BlockID.DEEPSLATE_TILES_WALL_SCONCE_ID, 
				() -> new SconceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_TILES)));
		CRACKED_DEEPSLATE_TILES_WALL_SCONCE = Registration.BLOCKS.register(
				BlockID.CRACKED_DEEPSLATE_TILES_WALL_SCONCE_ID, 
				() -> new SconceBlock(BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_TILES)));
	}

	/**
	 * 
	 */
	public static void register() {
		Registration.registerBlocks();
	}

}


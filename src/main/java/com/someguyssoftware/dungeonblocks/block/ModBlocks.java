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
package com.someguyssoftware.dungeonblocks.block;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.common.base.Preconditions;
import com.someguyssoftware.dungeonblocks.DungeonBlocks;
import com.someguyssoftware.dungeonblocks.config.DungeonBlocksConfig.BlockID;
import com.someguyssoftware.dungeonblocks.item.ModItemGroups;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.IForgeRegistry;

/**
 * @author Mark Gottschling on Jan 12, 2020
 *
 */
public class ModBlocks {

	/*
	 * blocks
	 */
	// facade blocks
	public static  Block STONE_FACADE;
	public static  Block SMOOTH_STONE_FACADE;
	public static  Block COBBLESTONE_FACADE;
	public static  Block MOSSY_COBBLESTONE_FACADE;
	public static  Block BRICKS_FACADE;
	public static  Block STONE_BRICKS_FACADE;
	public static  Block MOSSY_STONE_BRICKS_FACADE;
	public static  Block CRACKED_STONE_BRICKS_FACADE;
	public static  Block CHISELED_STONE_BRICKS_FACADE;
	public static  Block OBSIDIAN_FACADE;
	public static  Block SANDSTONE_FACADE;
	public static  Block SMOOTH_SANDSTONE_FACADE;
	public static  Block CHISELED_SANDSTONE_FACADE;
	public static  Block CUT_SANDSTONE_FACADE;
	public static  Block RED_SANDSTONE_FACADE;
	public static  Block SMOOTH_RED_SANDSTONE_FACADE;
	public static  Block CHISELED_RED_SANDSTONE_FACADE;
	public static  Block CUT_RED_SANDSTONE_FACADE;
	public static  Block GRANITE_FACADE;
	public static  Block POLISHED_GRANITE_FACADE;
	public static  Block DIORITE_FACADE;
	public static  Block POLISHED_DIORITE_FACADE;
	public static  Block ANDESITE_FACADE;
	public static  Block POLISHED_ANDESITE_FACADE;
	// 1.16/1.17/1.18
	public static  Block BLACKSTONE_FACADE;
	public static Block POLISHED_BLACKSTONE_FACADE;
	public static Block CHISELED_POLISHED_BLACKSTONE_FACADE;
	public static Block GILDED_BLACKSTONE_FACADE;
	public static Block POLISHED_BLACKSTONE_BRICKS_FACADE;
	public static Block CRACKED_POLISHED_BLACKSTONE_BRICKS_FACADE;
	
	public static  Block DEEPSLATE_FACADE;
	public static  Block DEEPSLATE_BRICKS_FACADE;
	public static  Block CRACKED_DEEPSLATE_BRICKS_FACADE;
	public static  Block COBBLED_DEEPSLATE_FACADE;
	public static  Block POLISHED_DEEPSLATE_FACADE;
	public static  Block CHISELED_DEEPSLATE_FACADE;
	public static  Block DEEPSLATE_TILES_FACADE;
	public static  Block CRACKED_DEEPSLATE_TILES_FACADE;
	
//	public static Block TUFF_FACADE;
//	public static Block CALCITE;
	
	
	// quarter facade
	public static  Block STONE_QUARTER_FACADE;
	public static  Block SMOOTH_STONE_QUARTER_FACADE;
	public static  Block COBBLESTONE_QUARTER_FACADE;
	public static  Block MOSSY_COBBLESTONE_QUARTER_FACADE;
	public static  Block BRICKS_QUARTER_FACADE;
	public static  Block STONE_BRICKS_QUARTER_FACADE;
	public static  Block MOSSY_STONE_BRICKS_QUARTER_FACADE;
	public static  Block CRACKED_STONE_BRICKS_QUARTER_FACADE;
	public static  Block CHISELED_STONE_BRICKS_QUARTER_FACADE;
	public static  Block OBSIDIAN_QUARTER_FACADE;
	public static  Block SANDSTONE_QUARTER_FACADE;
	public static  Block SMOOTH_SANDSTONE_QUARTER_FACADE;
	public static  Block CHISELED_SANDSTONE_QUARTER_FACADE;
	public static  Block CUT_SANDSTONE_QUARTER_FACADE;
	public static  Block RED_SANDSTONE_QUARTER_FACADE;
	public static  Block SMOOTH_RED_SANDSTONE_QUARTER_FACADE;
	public static  Block CHISELED_RED_SANDSTONE_QUARTER_FACADE;
	public static  Block CUT_RED_SANDSTONE_QUARTER_FACADE;
	public static  Block GRANITE_QUARTER_FACADE;
	public static  Block POLISHED_GRANITE_QUARTER_FACADE;
	public static  Block DIORITE_QUARTER_FACADE;
	public static  Block POLISHED_DIORITE_QUARTER_FACADE;
	public static  Block ANDESITE_QUARTER_FACADE;
	public static  Block POLISHED_ANDESITE_QUARTER_FACADE;
	public static  Block BLACKSTONE_QUARTER_FACADE;
	public static  Block POLISHED_BLACKSTONE_QUARTER_FACADE;
	public static  Block CHISELED_POLISHED_BLACKSTONE_QUARTER_FACADE;
	public static  Block GILDED_BLACKSTONE_QUARTER_FACADE;
	public static  Block POLISHED_BLACKSTONE_BRICKS_QUARTER_FACADE;
	public static  Block CRACKED_POLISHED_BLACKSTONE_BRICKS_QUARTER_FACADE;
	public static  Block DEEPSLATE_QUARTER_FACADE;
	public static  Block DEEPSLATE_BRICKS_QUARTER_FACADE;
	public static  Block CRACKED_DEEPSLATE_BRICKS_QUARTER_FACADE;
	public static  Block COBBLED_DEEPSLATE_QUARTER_FACADE;
	public static  Block POLISHED_DEEPSLATE_QUARTER_FACADE;
	public static  Block CHISELED_DEEPSLATE_QUARTER_FACADE;
	public static  Block DEEPSLATE_TILES_QUARTER_FACADE;
	public static  Block CRACKED_DEEPSLATE_TILES_QUARTER_FACADE;
	
	// fluted
	public static  Block STONE_FLUTED;
	public static  Block SMOOTH_STONE_FLUTED;
	public static  Block COBBLESTONE_FLUTED;
	public static  Block MOSSY_COBBLESTONE_FLUTED;
	public static  Block BRICKS_FLUTED;
	public static  Block STONE_BRICKS_FLUTED;
	public static  Block MOSSY_STONE_BRICKS_FLUTED;
	public static  Block CRACKED_STONE_BRICKS_FLUTED;
	public static  Block CHISELED_STONE_BRICKS_FLUTED;
	public static  Block OBSIDIAN_FLUTED;
	public static  Block SANDSTONE_FLUTED;
	public static  Block SMOOTH_SANDSTONE_FLUTED;
	public static  Block CHISELED_SANDSTONE_FLUTED;
	public static  Block CUT_SANDSTONE_FLUTED;
	public static  Block RED_SANDSTONE_FLUTED;
	public static  Block SMOOTH_RED_SANDSTONE_FLUTED;
	public static  Block CHISELED_RED_SANDSTONE_FLUTED;
	public static  Block CUT_RED_SANDSTONE_FLUTED;
	public static  Block GRANITE_FLUTED;
	public static  Block POLISHED_GRANITE_FLUTED;
	public static  Block DIORITE_FLUTED;
	public static  Block POLISHED_DIORITE_FLUTED;
	public static  Block ANDESITE_FLUTED;
	public static  Block POLISHED_ANDESITE_FLUTED;
	public static Block BLACKSTONE_FLUTED;
	public static Block POLISHED_BLACKSTONE_FLUTED;
	public static Block CHISELED_POLISHED_BLACKSTONE_FLUTED;
	public static Block GILDED_BLACKSTONE_FLUTED;
	public static Block POLISHED_BLACKSTONE_BRICKS_FLUTED;
	public static Block CRACKED_POLISHED_BLACKSTONE_BRICKS_FLUTED;
	public static Block DEEPSLATE_FLUTED;
	public static Block DEEPSLATE_BRICKS_FLUTED;
	public static Block CRACKED_DEEPSLATE_BRICKS_FLUTED;
	public static Block COBBLED_DEEPSLATE_FLUTED;
	public static Block POLISHED_DEEPSLATE_FLUTED;
	public static Block CHISELED_DEEPSLATE_FLUTED;
	public static Block DEEPSLATE_TILES_FLUTED;
	public static Block CRACKED_DEEPSLATE_TILES_FLUTED;

	// fluted facade
	public static  Block STONE_FLUTED_FACADE;
	public static  Block SMOOTH_STONE_FLUTED_FACADE;
	public static  Block COBBLESTONE_FLUTED_FACADE;
	public static  Block MOSSY_COBBLESTONE_FLUTED_FACADE;
	public static  Block BRICKS_FLUTED_FACADE;
	public static  Block STONE_BRICKS_FLUTED_FACADE;
	public static  Block MOSSY_STONE_BRICKS_FLUTED_FACADE;
	public static  Block CRACKED_STONE_BRICKS_FLUTED_FACADE;
	public static  Block CHISELED_STONE_BRICKS_FLUTED_FACADE;
	public static  Block OBSIDIAN_FLUTED_FACADE;
	public static  Block SANDSTONE_FLUTED_FACADE;
	public static  Block SMOOTH_SANDSTONE_FLUTED_FACADE;
	public static  Block CHISELED_SANDSTONE_FLUTED_FACADE;
	public static  Block CUT_SANDSTONE_FLUTED_FACADE;
	public static  Block RED_SANDSTONE_FLUTED_FACADE;
	public static  Block SMOOTH_RED_SANDSTONE_FLUTED_FACADE;
	public static  Block CHISELED_RED_SANDSTONE_FLUTED_FACADE;
	public static  Block CUT_RED_SANDSTONE_FLUTED_FACADE;
	public static  Block GRANITE_FLUTED_FACADE;
	public static  Block POLISHED_GRANITE_FLUTED_FACADE;
	public static  Block DIORITE_FLUTED_FACADE;
	public static  Block POLISHED_DIORITE_FLUTED_FACADE;
	public static  Block ANDESITE_FLUTED_FACADE;
	public static  Block POLISHED_ANDESITE_FLUTED_FACADE;
	public static Block BLACKSTONE_FLUTED_FACADE;
	public static Block POLISHED_BLACKSTONE_FLUTED_FACADE;
	public static Block CHISELED_POLISHED_BLACKSTONE_FLUTED_FACADE;
	public static Block GILDED_BLACKSTONE_FLUTED_FACADE;
	public static Block POLISHED_BLACKSTONE_BRICKS_FLUTED_FACADE;
	public static Block CRACKED_POLISHED_BLACKSTONE_BRICKS_FLUTED_FACADE;
	public static Block DEEPSLATE_FLUTED_FACADE;
	public static Block DEEPSLATE_BRICKS_FLUTED_FACADE;
	public static Block CRACKED_DEEPSLATE_BRICKS_FLUTED_FACADE;
	public static Block COBBLED_DEEPSLATE_FLUTED_FACADE;
	public static Block POLISHED_DEEPSLATE_FLUTED_FACADE;
	public static Block CHISELED_DEEPSLATE_FLUTED_FACADE;
	public static Block DEEPSLATE_TILES_FLUTED_FACADE;
	public static Block CRACKED_DEEPSLATE_TILES_FLUTED_FACADE;

	
	// sill
	public static  Block STONE_SILL;
	public static  Block SMOOTH_STONE_SILL;
	public static  Block COBBLESTONE_SILL;
	public static  Block MOSSY_COBBLESTONE_SILL;
	public static  Block BRICKS_SILL;
	public static  Block STONE_BRICKS_SILL;
	public static  Block MOSSY_STONE_BRICKS_SILL;
	public static  Block CRACKED_STONE_BRICKS_SILL;
	public static  Block CHISELED_STONE_BRICKS_SILL;
	public static  Block OBSIDIAN_SILL;
	public static  Block SANDSTONE_SILL;
	public static  Block SMOOTH_SANDSTONE_SILL;
	public static  Block CHISELED_SANDSTONE_SILL;
	public static  Block CUT_SANDSTONE_SILL;
	public static  Block RED_SANDSTONE_SILL;
	public static  Block SMOOTH_RED_SANDSTONE_SILL;
	public static  Block CHISELED_RED_SANDSTONE_SILL;
	public static  Block CUT_RED_SANDSTONE_SILL;
	public static  Block GRANITE_SILL;
	public static  Block POLISHED_GRANITE_SILL;
	public static  Block DIORITE_SILL;
	public static  Block POLISHED_DIORITE_SILL;
	public static  Block ANDESITE_SILL;
	public static  Block POLISHED_ANDESITE_SILL;
	public static Block BLACKSTONE_SILL;
	public static Block POLISHED_BLACKSTONE_SILL;
	public static Block CHISELED_POLISHED_BLACKSTONE_SILL;
	public static Block GILDED_BLACKSTONE_SILL;
	public static Block POLISHED_BLACKSTONE_BRICKS_SILL;
	public static Block CRACKED_POLISHED_BLACKSTONE_BRICKS_SILL;
	public static Block DEEPSLATE_SILL;
	public static Block DEEPSLATE_BRICKS_SILL;
	public static Block CRACKED_DEEPSLATE_BRICKS_SILL;
	public static Block COBBLED_DEEPSLATE_SILL;
	public static Block POLISHED_DEEPSLATE_SILL;
	public static Block CHISELED_DEEPSLATE_SILL;
	public static Block DEEPSLATE_TILES_SILL;
	public static Block CRACKED_DEEPSLATE_TILES_SILL;

	// double sill
	public static  Block STONE_DOUBLE_SILL;
	public static  Block SMOOTH_STONE_DOUBLE_SILL;
	public static  Block COBBLESTONE_DOUBLE_SILL;
	public static  Block MOSSY_COBBLESTONE_DOUBLE_SILL;
	public static  Block BRICKS_DOUBLE_SILL;
	public static  Block STONE_BRICKS_DOUBLE_SILL;
	public static  Block MOSSY_STONE_BRICKS_DOUBLE_SILL;
	public static  Block CRACKED_STONE_BRICKS_DOUBLE_SILL;
	public static  Block CHISELED_STONE_BRICKS_DOUBLE_SILL;
	public static  Block OBSIDIAN_DOUBLE_SILL;
	public static  Block SANDSTONE_DOUBLE_SILL;
	public static  Block SMOOTH_SANDSTONE_DOUBLE_SILL;
	public static  Block CHISELED_SANDSTONE_DOUBLE_SILL;
	public static  Block CUT_SANDSTONE_DOUBLE_SILL;
	public static  Block RED_SANDSTONE_DOUBLE_SILL;
	public static  Block SMOOTH_RED_SANDSTONE_DOUBLE_SILL;
	public static  Block CHISELED_RED_SANDSTONE_DOUBLE_SILL;
	public static  Block CUT_RED_SANDSTONE_DOUBLE_SILL;
	public static  Block GRANITE_DOUBLE_SILL;
	public static  Block POLISHED_GRANITE_DOUBLE_SILL;
	public static  Block DIORITE_DOUBLE_SILL;
	public static  Block POLISHED_DIORITE_DOUBLE_SILL;
	public static  Block ANDESITE_DOUBLE_SILL;
	public static  Block POLISHED_ANDESITE_DOUBLE_SILL;
	public static Block BLACKSTONE_DOUBLE_SILL;
	public static Block POLISHED_BLACKSTONE_DOUBLE_SILL;
	public static Block CHISELED_POLISHED_BLACKSTONE_DOUBLE_SILL;
	public static Block GILDED_BLACKSTONE_DOUBLE_SILL;
	public static Block POLISHED_BLACKSTONE_BRICKS_DOUBLE_SILL;
	public static Block CRACKED_POLISHED_BLACKSTONE_BRICKS_DOUBLE_SILL;
	public static Block DEEPSLATE_DOUBLE_SILL;
	public static Block DEEPSLATE_BRICKS_DOUBLE_SILL;
	public static Block CRACKED_DEEPSLATE_BRICKS_DOUBLE_SILL;
	public static Block COBBLED_DEEPSLATE_DOUBLE_SILL;
	public static Block POLISHED_DEEPSLATE_DOUBLE_SILL;
	public static Block CHISELED_DEEPSLATE_DOUBLE_SILL;
	public static Block DEEPSLATE_TILES_DOUBLE_SILL;
	public static Block CRACKED_DEEPSLATE_TILES_DOUBLE_SILL;

	// cornice
	public static  Block STONE_CORNICE;
	public static  Block SMOOTH_STONE_CORNICE;
	public static  Block COBBLESTONE_CORNICE;
	public static  Block MOSSY_COBBLESTONE_CORNICE;
	public static  Block BRICKS_CORNICE;
	public static  Block STONE_BRICKS_CORNICE;
	public static  Block MOSSY_STONE_BRICKS_CORNICE;
	public static  Block CRACKED_STONE_BRICKS_CORNICE;
	public static  Block CHISELED_STONE_BRICKS_CORNICE;
	public static  Block OBSIDIAN_CORNICE;
	public static  Block SANDSTONE_CORNICE;
	public static  Block SMOOTH_SANDSTONE_CORNICE;
	public static  Block CHISELED_SANDSTONE_CORNICE;
	public static  Block CUT_SANDSTONE_CORNICE;
	public static  Block RED_SANDSTONE_CORNICE;
	public static  Block SMOOTH_RED_SANDSTONE_CORNICE;
	public static  Block CHISELED_RED_SANDSTONE_CORNICE;
	public static  Block CUT_RED_SANDSTONE_CORNICE;
	public static  Block GRANITE_CORNICE;
	public static  Block POLISHED_GRANITE_CORNICE;
	public static  Block DIORITE_CORNICE;
	public static  Block POLISHED_DIORITE_CORNICE;
	public static  Block ANDESITE_CORNICE;
	public static  Block POLISHED_ANDESITE_CORNICE;
	public static Block BLACKSTONE_CORNICE;
	public static Block POLISHED_BLACKSTONE_CORNICE;
	public static Block CHISELED_POLISHED_BLACKSTONE_CORNICE;
	public static Block GILDED_BLACKSTONE_CORNICE;
	public static Block POLISHED_BLACKSTONE_BRICKS_CORNICE;
	public static Block CRACKED_POLISHED_BLACKSTONE_BRICKS_CORNICE;
	public static Block DEEPSLATE_CORNICE;
	public static Block DEEPSLATE_BRICKS_CORNICE;
	public static Block CRACKED_DEEPSLATE_BRICKS_CORNICE;
	public static Block COBBLED_DEEPSLATE_CORNICE;
	public static Block POLISHED_DEEPSLATE_CORNICE;
	public static Block CHISELED_DEEPSLATE_CORNICE;
	public static Block DEEPSLATE_TILES_CORNICE;
	public static Block CRACKED_DEEPSLATE_TILES_CORNICE;

	// crown molding
	public static  Block STONE_CROWN_MOLDING;
	public static  Block SMOOTH_STONE_CROWN_MOLDING;
	public static  Block COBBLESTONE_CROWN_MOLDING;
	public static  Block MOSSY_COBBLESTONE_CROWN_MOLDING;
	public static  Block BRICKS_CROWN_MOLDING;
	public static  Block STONE_BRICKS_CROWN_MOLDING;
	public static  Block MOSSY_STONE_BRICKS_CROWN_MOLDING;
	public static  Block CRACKED_STONE_BRICKS_CROWN_MOLDING;
	public static  Block CHISELED_STONE_BRICKS_CROWN_MOLDING;
	public static  Block OBSIDIAN_CROWN_MOLDING;
	public static  Block SANDSTONE_CROWN_MOLDING;
	public static  Block SMOOTH_SANDSTONE_CROWN_MOLDING;
	public static  Block CHISELED_SANDSTONE_CROWN_MOLDING;
	public static  Block CUT_SANDSTONE_CROWN_MOLDING;
	public static  Block RED_SANDSTONE_CROWN_MOLDING;
	public static  Block SMOOTH_RED_SANDSTONE_CROWN_MOLDING;
	public static  Block CHISELED_RED_SANDSTONE_CROWN_MOLDING;
	public static  Block CUT_RED_SANDSTONE_CROWN_MOLDING;
	public static  Block GRANITE_CROWN_MOLDING;
	public static  Block POLISHED_GRANITE_CROWN_MOLDING;
	public static  Block DIORITE_CROWN_MOLDING;
	public static  Block POLISHED_DIORITE_CROWN_MOLDING;
	public static  Block ANDESITE_CROWN_MOLDING;
	public static  Block POLISHED_ANDESITE_CROWN_MOLDING;
	public static Block BLACKSTONE_CROWN_MOLDING;
	public static Block POLISHED_BLACKSTONE_CROWN_MOLDING;
	public static Block CHISELED_POLISHED_BLACKSTONE_CROWN_MOLDING;
	public static Block GILDED_BLACKSTONE_CROWN_MOLDING;
	public static Block POLISHED_BLACKSTONE_BRICKS_CROWN_MOLDING;
	public static Block CRACKED_POLISHED_BLACKSTONE_BRICKS_CROWN_MOLDING;
	public static Block DEEPSLATE_CROWN_MOLDING;
	public static Block DEEPSLATE_BRICKS_CROWN_MOLDING;
	public static Block CRACKED_DEEPSLATE_BRICKS_CROWN_MOLDING;
	public static Block COBBLED_DEEPSLATE_CROWN_MOLDING;
	public static Block POLISHED_DEEPSLATE_CROWN_MOLDING;
	public static Block CHISELED_DEEPSLATE_CROWN_MOLDING;
	public static Block DEEPSLATE_TILES_CROWN_MOLDING;
	public static Block CRACKED_DEEPSLATE_TILES_CROWN_MOLDING;

	// pillar base
	public static  Block STONE_PILLAR_BASE;
	public static  Block SMOOTH_STONE_PILLAR_BASE;
	public static  Block COBBLESTONE_PILLAR_BASE;
	public static  Block MOSSY_COBBLESTONE_PILLAR_BASE;
	public static  Block BRICKS_PILLAR_BASE;
	public static  Block STONE_BRICKS_PILLAR_BASE;
	public static  Block MOSSY_STONE_BRICKS_PILLAR_BASE;
	public static  Block CRACKED_STONE_BRICKS_PILLAR_BASE;
	public static  Block CHISELED_STONE_BRICKS_PILLAR_BASE;
	public static  Block OBSIDIAN_PILLAR_BASE;
	public static  Block SANDSTONE_PILLAR_BASE;
	public static  Block SMOOTH_SANDSTONE_PILLAR_BASE;
	public static  Block CHISELED_SANDSTONE_PILLAR_BASE;
	public static  Block CUT_SANDSTONE_PILLAR_BASE;
	public static  Block RED_SANDSTONE_PILLAR_BASE;
	public static  Block SMOOTH_RED_SANDSTONE_PILLAR_BASE;
	public static  Block CHISELED_RED_SANDSTONE_PILLAR_BASE;
	public static  Block CUT_RED_SANDSTONE_PILLAR_BASE;
	public static  Block GRANITE_PILLAR_BASE;
	public static  Block POLISHED_GRANITE_PILLAR_BASE;
	public static  Block DIORITE_PILLAR_BASE;
	public static  Block POLISHED_DIORITE_PILLAR_BASE;
	public static  Block ANDESITE_PILLAR_BASE;
	public static  Block POLISHED_ANDESITE_PILLAR_BASE;
	public static Block BLACKSTONE_PILLAR_BASE;
	public static Block POLISHED_BLACKSTONE_PILLAR_BASE;
	public static Block CHISELED_POLISHED_BLACKSTONE_PILLAR_BASE;
	public static Block GILDED_BLACKSTONE_PILLAR_BASE;
	public static Block POLISHED_BLACKSTONE_BRICKS_PILLAR_BASE;
	public static Block CRACKED_POLISHED_BLACKSTONE_BRICKS_PILLAR_BASE;
	public static Block DEEPSLATE_PILLAR_BASE;
	public static Block DEEPSLATE_BRICKS_PILLAR_BASE;
	public static Block CRACKED_DEEPSLATE_BRICKS_PILLAR_BASE;
	public static Block COBBLED_DEEPSLATE_PILLAR_BASE;
	public static Block POLISHED_DEEPSLATE_PILLAR_BASE;
	public static Block CHISELED_DEEPSLATE_PILLAR_BASE;
	public static Block DEEPSLATE_TILES_PILLAR_BASE;
	public static Block CRACKED_DEEPSLATE_TILES_PILLAR_BASE;

	// pillar
	public static  Block STONE_PILLAR;
	public static  Block SMOOTH_STONE_PILLAR;
	public static  Block COBBLESTONE_PILLAR;
	public static  Block MOSSY_COBBLESTONE_PILLAR;
	public static  Block BRICKS_PILLAR;
	public static  Block STONE_BRICKS_PILLAR;
	public static  Block MOSSY_STONE_BRICKS_PILLAR;
	public static  Block CRACKED_STONE_BRICKS_PILLAR;
	public static  Block CHISELED_STONE_BRICKS_PILLAR;
	public static  Block OBSIDIAN_PILLAR;
	public static  Block SANDSTONE_PILLAR;
	public static  Block SMOOTH_SANDSTONE_PILLAR;
	public static  Block CHISELED_SANDSTONE_PILLAR;
	public static  Block CUT_SANDSTONE_PILLAR;
	public static  Block RED_SANDSTONE_PILLAR;
	public static  Block SMOOTH_RED_SANDSTONE_PILLAR;
	public static  Block CHISELED_RED_SANDSTONE_PILLAR;
	public static  Block CUT_RED_SANDSTONE_PILLAR;
	public static  Block GRANITE_PILLAR;
	public static  Block POLISHED_GRANITE_PILLAR;
	public static  Block DIORITE_PILLAR;
	public static  Block POLISHED_DIORITE_PILLAR;
	public static  Block ANDESITE_PILLAR;
	public static  Block POLISHED_ANDESITE_PILLAR;
	public static Block BLACKSTONE_PILLAR;
	public static Block POLISHED_BLACKSTONE_PILLAR;
	public static Block CHISELED_POLISHED_BLACKSTONE_PILLAR;
	public static Block GILDED_BLACKSTONE_PILLAR;
	public static Block POLISHED_BLACKSTONE_BRICKS_PILLAR;
	public static Block CRACKED_POLISHED_BLACKSTONE_BRICKS_PILLAR;
	public static Block DEEPSLATE_PILLAR;
	public static Block DEEPSLATE_BRICKS_PILLAR;
	public static Block CRACKED_DEEPSLATE_BRICKS_PILLAR;
	public static Block COBBLED_DEEPSLATE_PILLAR;
	public static Block POLISHED_DEEPSLATE_PILLAR;
	public static Block CHISELED_DEEPSLATE_PILLAR;
	public static Block DEEPSLATE_TILES_PILLAR;
	public static Block CRACKED_DEEPSLATE_TILES_PILLAR;

	// wall sconce
	public static  Block STONE_WALL_SCONCE;
	public static  Block SMOOTH_STONE_WALL_SCONCE;
	public static  Block COBBLESTONE_WALL_SCONCE;
	public static  Block MOSSY_COBBLESTONE_WALL_SCONCE;
	public static  Block BRICKS_WALL_SCONCE;
	public static  Block STONE_BRICKS_WALL_SCONCE;
	public static  Block MOSSY_STONE_BRICKS_WALL_SCONCE;
	public static  Block CRACKED_STONE_BRICKS_WALL_SCONCE;
	public static  Block CHISELED_STONE_BRICKS_WALL_SCONCE;
	public static  Block OBSIDIAN_WALL_SCONCE;
	public static  Block SANDSTONE_WALL_SCONCE;
	public static  Block SMOOTH_SANDSTONE_WALL_SCONCE;
	public static  Block CHISELED_SANDSTONE_WALL_SCONCE;
	public static  Block CUT_SANDSTONE_WALL_SCONCE;
	public static  Block RED_SANDSTONE_WALL_SCONCE;
	public static  Block SMOOTH_RED_SANDSTONE_WALL_SCONCE;
	public static  Block CHISELED_RED_SANDSTONE_WALL_SCONCE;
	public static  Block CUT_RED_SANDSTONE_WALL_SCONCE;
	public static  Block GRANITE_WALL_SCONCE;
	public static  Block POLISHED_GRANITE_WALL_SCONCE;
	public static  Block DIORITE_WALL_SCONCE;
	public static  Block POLISHED_DIORITE_WALL_SCONCE;
	public static  Block ANDESITE_WALL_SCONCE;
	public static  Block POLISHED_ANDESITE_WALL_SCONCE;
	public static Block BLACKSTONE_WALL_SCONCE;
	public static Block POLISHED_BLACKSTONE_WALL_SCONCE;
	public static Block CHISELED_POLISHED_BLACKSTONE_WALL_SCONCE;
	public static Block GILDED_BLACKSTONE_WALL_SCONCE;
	public static Block POLISHED_BLACKSTONE_BRICKS_WALL_SCONCE;
	public static Block CRACKED_POLISHED_BLACKSTONE_BRICKS_WALL_SCONCE;
	public static Block DEEPSLATE_WALL_SCONCE;
	public static Block DEEPSLATE_BRICKS_WALL_SCONCE;
	public static Block CRACKED_DEEPSLATE_BRICKS_WALL_SCONCE;
	public static Block COBBLED_DEEPSLATE_WALL_SCONCE;
	public static Block POLISHED_DEEPSLATE_WALL_SCONCE;
	public static Block CHISELED_DEEPSLATE_WALL_SCONCE;
	public static Block DEEPSLATE_TILES_WALL_SCONCE;
	public static Block CRACKED_DEEPSLATE_TILES_WALL_SCONCE;

	public static  Block GRATE;

	public static List<Block> BLOCKS = new ArrayList<>(100);

	static {

	}

	@Mod.EventBusSubscriber(modid = DungeonBlocks.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
	public static class RegistrationHandler {
		
		public static  Set<BlockItem> ITEM_BLOCKS = new HashSet<>();

		@SubscribeEvent
		public static void registerBlocks(RegistryEvent.Register<Block> event) {
			// facade
			STONE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.STONE_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			SMOOTH_STONE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.SMOOTH_STONE_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			COBBLESTONE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.COBBLESTONE_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			MOSSY_COBBLESTONE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.MOSSY_COBBLESTONE_FACADE_ID,
					Block.Properties.of(Material.STONE).strength(2.0F, 6.0F));
			BRICKS_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.BRICKS_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_RED).strength(2.0F, 6.0F));
			STONE_BRICKS_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.STONE_BRICKS_FACADE_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			MOSSY_STONE_BRICKS_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.MOSSY_STONE_BRICKS_FACADE_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			CRACKED_STONE_BRICKS_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.CRACKED_STONE_BRICKS_FACADE_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			CHISELED_STONE_BRICKS_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.CHISELED_STONE_BRICKS_FACADE_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			OBSIDIAN_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.OBSIDIAN_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(50.0F, 1200.0F));

			SANDSTONE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.SANDSTONE_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			SMOOTH_SANDSTONE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.SMOOTH_SANDSTONE_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CHISELED_SANDSTONE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.CHISELED_SANDSTONE_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CUT_SANDSTONE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.CUT_SANDSTONE_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			RED_SANDSTONE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.RED_SANDSTONE_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			SMOOTH_RED_SANDSTONE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.SMOOTH_RED_SANDSTONE_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CHISELED_RED_SANDSTONE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.CHISELED_RED_SANDSTONE_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CUT_RED_SANDSTONE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.CUT_RED_SANDSTONE_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));

			GRANITE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.GRANITE_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			POLISHED_GRANITE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.POLISHED_GRANITE_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			DIORITE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.DIORITE_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.QUARTZ).strength(1.5F, 6.0F));
			POLISHED_DIORITE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.POLISHED_DIORITE_FACADE_ID,
					BlockBehaviour.Properties.copy(Blocks.DIORITE));
			ANDESITE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.ANDESITE_FACADE_ID,
					BlockBehaviour.Properties.copy(Blocks.ANDESITE));
			POLISHED_ANDESITE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.POLISHED_ANDESITE_FACADE_ID,
					BlockBehaviour.Properties.copy(Blocks.ANDESITE));

			BLACKSTONE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.BLACKSTONE_FACADE_ID,
					BlockBehaviour.Properties.copy(Blocks.BLACKSTONE));	
			POLISHED_BLACKSTONE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.POLISHED_BLACKSTONE_FACADE_ID,
					BlockBehaviour.Properties.copy(Blocks.BLACKSTONE));	
			CHISELED_POLISHED_BLACKSTONE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.CHISELED_POLISHED_BLACKSTONE_FACADE_ID,
					BlockBehaviour.Properties.copy(Blocks.BLACKSTONE));	
			GILDED_BLACKSTONE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.GILDED_BLACKSTONE_FACADE_ID,
					BlockBehaviour.Properties.copy(Blocks.GILDED_BLACKSTONE));	
			POLISHED_BLACKSTONE_BRICKS_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.POLISHED_BLACKSTONE_BRICKS_FACADE_ID,
					BlockBehaviour.Properties.copy(Blocks.BLACKSTONE));	
			CRACKED_POLISHED_BLACKSTONE_BRICKS_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.CRACKED_POLISHED_BLACKSTONE_BRICKS_FACADE_ID,
					BlockBehaviour.Properties.copy(Blocks.BLACKSTONE));			

			DEEPSLATE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.DEEPSLATE_FACADE_ID,
					BlockBehaviour.Properties.copy(Blocks.DEEPSLATE));
			DEEPSLATE_BRICKS_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.DEEPSLATE_BRICKS_FACADE_ID,
					BlockBehaviour.Properties.copy(Blocks.DEEPSLATE));
			CRACKED_DEEPSLATE_BRICKS_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.CRACKED_DEEPSLATE_BRICKS_FACADE_ID,
					BlockBehaviour.Properties.copy(Blocks.DEEPSLATE));
			COBBLED_DEEPSLATE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.COBBLED_DEEPSLATE_FACADE_ID,
					BlockBehaviour.Properties.copy(Blocks.DEEPSLATE));
			POLISHED_DEEPSLATE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.POLISHED_DEEPSLATE_FACADE_ID,
					BlockBehaviour.Properties.copy(Blocks.DEEPSLATE));
			CHISELED_DEEPSLATE_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.CHISELED_DEEPSLATE_FACADE_ID,
					BlockBehaviour.Properties.copy(Blocks.DEEPSLATE));
			DEEPSLATE_TILES_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.DEEPSLATE_TILES_FACADE_ID,
					BlockBehaviour.Properties.copy(Blocks.DEEPSLATE));
			CRACKED_DEEPSLATE_TILES_FACADE = new FacadeBlock(DungeonBlocks.MOD_ID, BlockID.CRACKED_DEEPSLATE_TILES_FACADE_ID,
					BlockBehaviour.Properties.copy(Blocks.DEEPSLATE));

			// quarter facade
			STONE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID, BlockID.STONE_QUARTER_FACADE_ID,
					BlockBehaviour.Properties.copy(Blocks.STONE));
			SMOOTH_STONE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.SMOOTH_STONE_QUARTER_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			COBBLESTONE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID, BlockID.COBBLESTONE_QUARTER_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			MOSSY_COBBLESTONE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.MOSSY_COBBLESTONE_QUARTER_FACADE_ID,
					Block.Properties.of(Material.STONE).strength(2.0F, 6.0F));
			BRICKS_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID, BlockID.BRICKS_QUARTER_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_RED).strength(2.0F, 6.0F));
			STONE_BRICKS_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.STONE_BRICKS_QUARTER_FACADE_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			MOSSY_STONE_BRICKS_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.MOSSY_STONE_BRICKS_QUARTER_FACADE_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			CRACKED_STONE_BRICKS_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.CRACKED_STONE_BRICKS_QUARTER_FACADE_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			CHISELED_STONE_BRICKS_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.CHISELED_STONE_BRICKS_QUARTER_FACADE_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			OBSIDIAN_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID, BlockID.OBSIDIAN_QUARTER_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(50.0F, 1200.0F));

			SANDSTONE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID, BlockID.SANDSTONE_QUARTER_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			SMOOTH_SANDSTONE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.SMOOTH_SANDSTONE_QUARTER_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CHISELED_SANDSTONE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.CHISELED_SANDSTONE_QUARTER_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CUT_SANDSTONE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.CUT_SANDSTONE_QUARTER_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			RED_SANDSTONE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.RED_SANDSTONE_QUARTER_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			SMOOTH_RED_SANDSTONE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.SMOOTH_RED_SANDSTONE_QUARTER_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CHISELED_RED_SANDSTONE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.CHISELED_RED_SANDSTONE_QUARTER_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CUT_RED_SANDSTONE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.CUT_RED_SANDSTONE_QUARTER_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));

			GRANITE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID, BlockID.GRANITE_QUARTER_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			POLISHED_GRANITE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.POLISHED_GRANITE_QUARTER_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			DIORITE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID, BlockID.DIORITE_QUARTER_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.QUARTZ).strength(1.5F, 6.0F));
			POLISHED_DIORITE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.POLISHED_DIORITE_QUARTER_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.QUARTZ).strength(1.5F, 6.0F));
			ANDESITE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID, BlockID.ANDESITE_QUARTER_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 6.0F));
			POLISHED_ANDESITE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.POLISHED_ANDESITE_QUARTER_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 6.0F));
			BLACKSTONE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID, 
					BlockID.BLACKSTONE_QUARTER_FACADE_ID, 
					BlockBehaviour.Properties.copy(Blocks.BLACKSTONE));
			POLISHED_BLACKSTONE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID, 
					BlockID.POLISHED_BLACKSTONE_QUARTER_FACADE_ID, 
					BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE));
			CHISELED_POLISHED_BLACKSTONE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID, 
					BlockID.CHISELED_POLISHED_BLACKSTONE_QUARTER_FACADE_ID, 
					BlockBehaviour.Properties.copy(Blocks.CHISELED_POLISHED_BLACKSTONE));
			GILDED_BLACKSTONE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID, 
					BlockID.GILDED_BLACKSTONE_QUARTER_FACADE_ID, 
					BlockBehaviour.Properties.copy(Blocks.GILDED_BLACKSTONE));
			POLISHED_BLACKSTONE_BRICKS_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID, 
					BlockID.POLISHED_BLACKSTONE_BRICKS_QUARTER_FACADE_ID, 
					BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE_BRICKS));
			CRACKED_POLISHED_BLACKSTONE_BRICKS_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID, 
					BlockID.CRACKED_POLISHED_BLACKSTONE_BRICKS_QUARTER_FACADE_ID, 
					BlockBehaviour.Properties.copy(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS));
			DEEPSLATE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID, 
					BlockID.DEEPSLATE_QUARTER_FACADE_ID, 
					BlockBehaviour.Properties.copy(Blocks.DEEPSLATE));
			DEEPSLATE_BRICKS_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID, 
					BlockID.DEEPSLATE_BRICKS_QUARTER_FACADE_ID, 
					BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICKS));
			CRACKED_DEEPSLATE_BRICKS_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID, 
					BlockID.CRACKED_DEEPSLATE_BRICKS_QUARTER_FACADE_ID, 
					BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_BRICKS));
			COBBLED_DEEPSLATE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID, 
					BlockID.COBBLED_DEEPSLATE_QUARTER_FACADE_ID, 
					BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE));
			POLISHED_DEEPSLATE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID, 
					BlockID.POLISHED_DEEPSLATE_QUARTER_FACADE_ID, 
					BlockBehaviour.Properties.copy(Blocks.POLISHED_DEEPSLATE));
			CHISELED_DEEPSLATE_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID, 
					BlockID.CHISELED_DEEPSLATE_QUARTER_FACADE_ID, 
					BlockBehaviour.Properties.copy(Blocks.CHISELED_DEEPSLATE));
			DEEPSLATE_TILES_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID, 
					BlockID.DEEPSLATE_TILES_QUARTER_FACADE_ID, 
					BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_TILES));
			CRACKED_DEEPSLATE_TILES_QUARTER_FACADE = new QuarterFacadeBlock(DungeonBlocks.MOD_ID, 
					BlockID.CRACKED_DEEPSLATE_TILES_QUARTER_FACADE_ID, 
					BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_TILES));
			
			// fluted
			STONE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.STONE_FLUTED_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			SMOOTH_STONE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.SMOOTH_STONE_FLUTED_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			COBBLESTONE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.COBBLESTONE_FLUTED_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			MOSSY_COBBLESTONE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.MOSSY_COBBLESTONE_FLUTED_ID,
					Block.Properties.of(Material.STONE).strength(2.0F, 6.0F));
			BRICKS_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.BRICKS_FLUTED_ID,
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_RED).strength(2.0F, 6.0F));
			STONE_BRICKS_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.STONE_BRICKS_FLUTED_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			MOSSY_STONE_BRICKS_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.MOSSY_STONE_BRICKS_FLUTED_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			CRACKED_STONE_BRICKS_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.CRACKED_STONE_BRICKS_FLUTED_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			CHISELED_STONE_BRICKS_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.CHISELED_STONE_BRICKS_FLUTED_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			OBSIDIAN_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.OBSIDIAN_FLUTED_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(50.0F, 1200.0F));

			SANDSTONE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.SANDSTONE_FLUTED_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			SMOOTH_SANDSTONE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.SMOOTH_SANDSTONE_FLUTED_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CHISELED_SANDSTONE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.CHISELED_SANDSTONE_FLUTED_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CUT_SANDSTONE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.CUT_SANDSTONE_FLUTED_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			RED_SANDSTONE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.RED_SANDSTONE_FLUTED_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			SMOOTH_RED_SANDSTONE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.SMOOTH_RED_SANDSTONE_FLUTED_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CHISELED_RED_SANDSTONE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.CHISELED_RED_SANDSTONE_FLUTED_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CUT_RED_SANDSTONE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.CUT_RED_SANDSTONE_FLUTED_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));

			GRANITE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.GRANITE_FLUTED_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			POLISHED_GRANITE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.POLISHED_GRANITE_FLUTED_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			DIORITE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.DIORITE_FLUTED_ID,
					Block.Properties.of(Material.STONE, MaterialColor.QUARTZ).strength(1.5F, 6.0F));
			POLISHED_DIORITE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.POLISHED_DIORITE_FLUTED_ID,
					Block.Properties.of(Material.STONE, MaterialColor.QUARTZ).strength(1.5F, 6.0F));
			ANDESITE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.ANDESITE_FLUTED_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 6.0F));
			POLISHED_ANDESITE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, BlockID.POLISHED_ANDESITE_FLUTED_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 6.0F));

			BLACKSTONE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, 
					BlockID.BLACKSTONE_FLUTED_ID, 
					BlockBehaviour.Properties.copy(Blocks.BLACKSTONE));
			POLISHED_BLACKSTONE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, 
					BlockID.POLISHED_BLACKSTONE_FLUTED_ID, 
					BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE));
			CHISELED_POLISHED_BLACKSTONE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, 
					BlockID.CHISELED_POLISHED_BLACKSTONE_FLUTED_ID, 
					BlockBehaviour.Properties.copy(Blocks.CHISELED_POLISHED_BLACKSTONE));
			GILDED_BLACKSTONE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, 
					BlockID.GILDED_BLACKSTONE_FLUTED_ID, 
					BlockBehaviour.Properties.copy(Blocks.GILDED_BLACKSTONE));
			POLISHED_BLACKSTONE_BRICKS_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, 
					BlockID.POLISHED_BLACKSTONE_BRICKS_FLUTED_ID, 
					BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE_BRICKS));
			CRACKED_POLISHED_BLACKSTONE_BRICKS_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, 
					BlockID.CRACKED_POLISHED_BLACKSTONE_BRICKS_FLUTED_ID, 
					BlockBehaviour.Properties.copy(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS));
			DEEPSLATE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, 
					BlockID.DEEPSLATE_FLUTED_ID, 
					BlockBehaviour.Properties.copy(Blocks.DEEPSLATE));
			DEEPSLATE_BRICKS_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, 
					BlockID.DEEPSLATE_BRICKS_FLUTED_ID, 
					BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICKS));
			CRACKED_DEEPSLATE_BRICKS_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, 
					BlockID.CRACKED_DEEPSLATE_BRICKS_FLUTED_ID, 
					BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_BRICKS));
			COBBLED_DEEPSLATE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, 
					BlockID.COBBLED_DEEPSLATE_FLUTED_ID, 
					BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE));
			POLISHED_DEEPSLATE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, 
					BlockID.POLISHED_DEEPSLATE_FLUTED_ID, 
					BlockBehaviour.Properties.copy(Blocks.POLISHED_DEEPSLATE));
			CHISELED_DEEPSLATE_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, 
					BlockID.CHISELED_DEEPSLATE_FLUTED_ID, 
					BlockBehaviour.Properties.copy(Blocks.CHISELED_DEEPSLATE));
			DEEPSLATE_TILES_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, 
					BlockID.DEEPSLATE_TILES_FLUTED_ID, 
					BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_TILES));
			CRACKED_DEEPSLATE_TILES_FLUTED = new FlutedBlock(DungeonBlocks.MOD_ID, 
					BlockID.CRACKED_DEEPSLATE_TILES_FLUTED_ID, 
					BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_TILES));

			// fluted facade
			STONE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, BlockID.STONE_FLUTED_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			SMOOTH_STONE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, BlockID.SMOOTH_STONE_FLUTED_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			COBBLESTONE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, BlockID.COBBLESTONE_FLUTED_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			MOSSY_COBBLESTONE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.MOSSY_COBBLESTONE_FLUTED_FACADE_ID,
					Block.Properties.of(Material.STONE).strength(2.0F, 6.0F));
			BRICKS_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, BlockID.BRICKS_FLUTED_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_RED).strength(2.0F, 6.0F));
			STONE_BRICKS_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, BlockID.STONE_BRICKS_FLUTED_FACADE_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			MOSSY_STONE_BRICKS_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.MOSSY_STONE_BRICKS_FLUTED_FACADE_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			CRACKED_STONE_BRICKS_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.CRACKED_STONE_BRICKS_FLUTED_FACADE_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			CHISELED_STONE_BRICKS_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.CHISELED_STONE_BRICKS_FLUTED_FACADE_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			OBSIDIAN_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, BlockID.OBSIDIAN_FLUTED_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(50.0F, 1200.0F));

			SANDSTONE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, BlockID.SANDSTONE_FLUTED_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			SMOOTH_SANDSTONE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.SMOOTH_SANDSTONE_FLUTED_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CHISELED_SANDSTONE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.CHISELED_SANDSTONE_FLUTED_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CUT_SANDSTONE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.CUT_SANDSTONE_FLUTED_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			RED_SANDSTONE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.RED_SANDSTONE_FLUTED_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			SMOOTH_RED_SANDSTONE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.SMOOTH_RED_SANDSTONE_FLUTED_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CHISELED_RED_SANDSTONE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.CHISELED_RED_SANDSTONE_FLUTED_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CUT_RED_SANDSTONE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.CUT_RED_SANDSTONE_FLUTED_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));

			GRANITE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, BlockID.GRANITE_FLUTED_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			POLISHED_GRANITE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.POLISHED_GRANITE_FLUTED_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			DIORITE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, BlockID.DIORITE_FLUTED_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.QUARTZ).strength(1.5F, 6.0F));
			POLISHED_DIORITE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.POLISHED_DIORITE_FLUTED_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.QUARTZ).strength(1.5F, 6.0F));
			ANDESITE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, BlockID.ANDESITE_FLUTED_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 6.0F));
			POLISHED_ANDESITE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID,
					BlockID.POLISHED_ANDESITE_FLUTED_FACADE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 6.0F));

			BLACKSTONE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, 
					BlockID.BLACKSTONE_FLUTED_FACADE_ID, 
					BlockBehaviour.Properties.copy(Blocks.BLACKSTONE));
			POLISHED_BLACKSTONE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, 
					BlockID.POLISHED_BLACKSTONE_FLUTED_FACADE_ID, 
					BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE));
			CHISELED_POLISHED_BLACKSTONE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, 
					BlockID.CHISELED_POLISHED_BLACKSTONE_FLUTED_FACADE_ID, 
					BlockBehaviour.Properties.copy(Blocks.CHISELED_POLISHED_BLACKSTONE));
			GILDED_BLACKSTONE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, 
					BlockID.GILDED_BLACKSTONE_FLUTED_FACADE_ID, 
					BlockBehaviour.Properties.copy(Blocks.GILDED_BLACKSTONE));
			POLISHED_BLACKSTONE_BRICKS_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, 
					BlockID.POLISHED_BLACKSTONE_BRICKS_FLUTED_FACADE_ID, 
					BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE_BRICKS));
			CRACKED_POLISHED_BLACKSTONE_BRICKS_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, 
					BlockID.CRACKED_POLISHED_BLACKSTONE_BRICKS_FLUTED_FACADE_ID, 
					BlockBehaviour.Properties.copy(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS));
			DEEPSLATE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, 
					BlockID.DEEPSLATE_FLUTED_FACADE_ID, 
					BlockBehaviour.Properties.copy(Blocks.DEEPSLATE));
			DEEPSLATE_BRICKS_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, 
					BlockID.DEEPSLATE_BRICKS_FLUTED_FACADE_ID, 
					BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICKS));
			CRACKED_DEEPSLATE_BRICKS_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, 
					BlockID.CRACKED_DEEPSLATE_BRICKS_FLUTED_FACADE_ID, 
					BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_BRICKS));
			COBBLED_DEEPSLATE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, 
					BlockID.COBBLED_DEEPSLATE_FLUTED_FACADE_ID, 
					BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE));
			POLISHED_DEEPSLATE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, 
					BlockID.POLISHED_DEEPSLATE_FLUTED_FACADE_ID, 
					BlockBehaviour.Properties.copy(Blocks.POLISHED_DEEPSLATE));
			CHISELED_DEEPSLATE_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, 
					BlockID.CHISELED_DEEPSLATE_FLUTED_FACADE_ID, 
					BlockBehaviour.Properties.copy(Blocks.CHISELED_DEEPSLATE));
			DEEPSLATE_TILES_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, 
					BlockID.DEEPSLATE_TILES_FLUTED_FACADE_ID, 
					BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_TILES));
			CRACKED_DEEPSLATE_TILES_FLUTED_FACADE = new FlutedFacadeBlock(DungeonBlocks.MOD_ID, 
					BlockID.CRACKED_DEEPSLATE_TILES_FLUTED_FACADE_ID, 
					BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_TILES));
			
			// sill
			STONE_SILL = new SillBlock(DungeonBlocks.MOD_ID, BlockID.STONE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			SMOOTH_STONE_SILL = new SillBlock(DungeonBlocks.MOD_ID, BlockID.SMOOTH_STONE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			COBBLESTONE_SILL = new SillBlock(DungeonBlocks.MOD_ID, BlockID.COBBLESTONE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			MOSSY_COBBLESTONE_SILL = new SillBlock(DungeonBlocks.MOD_ID, BlockID.MOSSY_COBBLESTONE_SILL_ID,
					Block.Properties.of(Material.STONE).strength(2.0F, 6.0F));
			BRICKS_SILL = new SillBlock(DungeonBlocks.MOD_ID, BlockID.BRICKS_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_RED).strength(2.0F, 6.0F));
			STONE_BRICKS_SILL = new SillBlock(DungeonBlocks.MOD_ID, BlockID.STONE_BRICKS_SILL_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			MOSSY_STONE_BRICKS_SILL = new SillBlock(DungeonBlocks.MOD_ID, BlockID.MOSSY_STONE_BRICKS_SILL_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			CRACKED_STONE_BRICKS_SILL = new SillBlock(DungeonBlocks.MOD_ID, BlockID.CRACKED_STONE_BRICKS_SILL_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			CHISELED_STONE_BRICKS_SILL = new SillBlock(DungeonBlocks.MOD_ID, BlockID.CHISELED_STONE_BRICKS_SILL_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			OBSIDIAN_SILL = new SillBlock(DungeonBlocks.MOD_ID, BlockID.OBSIDIAN_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(50.0F, 1200.0F));

			SANDSTONE_SILL = new SillBlock(DungeonBlocks.MOD_ID, BlockID.SANDSTONE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			SMOOTH_SANDSTONE_SILL = new SillBlock(DungeonBlocks.MOD_ID, BlockID.SMOOTH_SANDSTONE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CHISELED_SANDSTONE_SILL = new SillBlock(DungeonBlocks.MOD_ID, BlockID.CHISELED_SANDSTONE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CUT_SANDSTONE_SILL = new SillBlock(DungeonBlocks.MOD_ID, BlockID.CUT_SANDSTONE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			RED_SANDSTONE_SILL = new SillBlock(DungeonBlocks.MOD_ID, BlockID.RED_SANDSTONE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			SMOOTH_RED_SANDSTONE_SILL = new SillBlock(DungeonBlocks.MOD_ID, BlockID.SMOOTH_RED_SANDSTONE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CHISELED_RED_SANDSTONE_SILL = new SillBlock(DungeonBlocks.MOD_ID, BlockID.CHISELED_RED_SANDSTONE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CUT_RED_SANDSTONE_SILL = new SillBlock(DungeonBlocks.MOD_ID, BlockID.CUT_RED_SANDSTONE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));

			GRANITE_SILL = new SillBlock(DungeonBlocks.MOD_ID, BlockID.GRANITE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			POLISHED_GRANITE_SILL = new SillBlock(DungeonBlocks.MOD_ID, BlockID.POLISHED_GRANITE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			DIORITE_SILL = new SillBlock(DungeonBlocks.MOD_ID, BlockID.DIORITE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.QUARTZ).strength(1.5F, 6.0F));
			POLISHED_DIORITE_SILL = new SillBlock(DungeonBlocks.MOD_ID, BlockID.POLISHED_DIORITE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.QUARTZ).strength(1.5F, 6.0F));
			ANDESITE_SILL = new SillBlock(DungeonBlocks.MOD_ID, BlockID.ANDESITE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 6.0F));
			POLISHED_ANDESITE_SILL = new SillBlock(DungeonBlocks.MOD_ID, BlockID.POLISHED_ANDESITE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 6.0F));
			BLACKSTONE_SILL = new SillBlock(DungeonBlocks.MOD_ID, 
					BlockID.BLACKSTONE_SILL_ID, 
					BlockBehaviour.Properties.copy(Blocks.BLACKSTONE));
			POLISHED_BLACKSTONE_SILL = new SillBlock(DungeonBlocks.MOD_ID, 
					BlockID.POLISHED_BLACKSTONE_SILL_ID, 
					BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE));
			CHISELED_POLISHED_BLACKSTONE_SILL = new SillBlock(DungeonBlocks.MOD_ID, 
					BlockID.CHISELED_POLISHED_BLACKSTONE_SILL_ID, 
					BlockBehaviour.Properties.copy(Blocks.CHISELED_POLISHED_BLACKSTONE));
			GILDED_BLACKSTONE_SILL = new SillBlock(DungeonBlocks.MOD_ID, 
					BlockID.GILDED_BLACKSTONE_SILL_ID, 
					BlockBehaviour.Properties.copy(Blocks.GILDED_BLACKSTONE));
			POLISHED_BLACKSTONE_BRICKS_SILL = new SillBlock(DungeonBlocks.MOD_ID, 
					BlockID.POLISHED_BLACKSTONE_BRICKS_SILL_ID, 
					BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE_BRICKS));
			CRACKED_POLISHED_BLACKSTONE_BRICKS_SILL = new SillBlock(DungeonBlocks.MOD_ID, 
					BlockID.CRACKED_POLISHED_BLACKSTONE_BRICKS_SILL_ID, 
					BlockBehaviour.Properties.copy(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS));
			DEEPSLATE_SILL = new SillBlock(DungeonBlocks.MOD_ID, 
					BlockID.DEEPSLATE_SILL_ID, 
					BlockBehaviour.Properties.copy(Blocks.DEEPSLATE));
			DEEPSLATE_BRICKS_SILL = new SillBlock(DungeonBlocks.MOD_ID, 
					BlockID.DEEPSLATE_BRICKS_SILL_ID, 
					BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICKS));
			CRACKED_DEEPSLATE_BRICKS_SILL = new SillBlock(DungeonBlocks.MOD_ID, 
					BlockID.CRACKED_DEEPSLATE_BRICKS_SILL_ID, 
					BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_BRICKS));
			COBBLED_DEEPSLATE_SILL = new SillBlock(DungeonBlocks.MOD_ID, 
					BlockID.COBBLED_DEEPSLATE_SILL_ID, 
					BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE));
			POLISHED_DEEPSLATE_SILL = new SillBlock(DungeonBlocks.MOD_ID, 
					BlockID.POLISHED_DEEPSLATE_SILL_ID, 
					BlockBehaviour.Properties.copy(Blocks.POLISHED_DEEPSLATE));
			CHISELED_DEEPSLATE_SILL = new SillBlock(DungeonBlocks.MOD_ID, 
					BlockID.CHISELED_DEEPSLATE_SILL_ID, 
					BlockBehaviour.Properties.copy(Blocks.CHISELED_DEEPSLATE));
			DEEPSLATE_TILES_SILL = new SillBlock(DungeonBlocks.MOD_ID, 
					BlockID.DEEPSLATE_TILES_SILL_ID, 
					BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_TILES));
			CRACKED_DEEPSLATE_TILES_SILL = new SillBlock(DungeonBlocks.MOD_ID, 
					BlockID.CRACKED_DEEPSLATE_TILES_SILL_ID, 
					BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_TILES));

			// double sill
			STONE_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID, BlockID.STONE_DOUBLE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			SMOOTH_STONE_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID, BlockID.SMOOTH_STONE_DOUBLE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			COBBLESTONE_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID, BlockID.COBBLESTONE_DOUBLE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			MOSSY_COBBLESTONE_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID,
					BlockID.MOSSY_COBBLESTONE_DOUBLE_SILL_ID,
					Block.Properties.of(Material.STONE).strength(2.0F, 6.0F));
			BRICKS_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID, BlockID.BRICKS_DOUBLE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_RED).strength(2.0F, 6.0F));
			STONE_BRICKS_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID, BlockID.STONE_BRICKS_DOUBLE_SILL_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			MOSSY_STONE_BRICKS_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID,
					BlockID.MOSSY_STONE_BRICKS_DOUBLE_SILL_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			CRACKED_STONE_BRICKS_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID,
					BlockID.CRACKED_STONE_BRICKS_DOUBLE_SILL_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			CHISELED_STONE_BRICKS_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID,
					BlockID.CHISELED_STONE_BRICKS_DOUBLE_SILL_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			OBSIDIAN_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID, BlockID.OBSIDIAN_DOUBLE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(50.0F, 1200.0F));

			SANDSTONE_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID, BlockID.SANDSTONE_DOUBLE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			SMOOTH_SANDSTONE_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID,
					BlockID.SMOOTH_SANDSTONE_DOUBLE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CHISELED_SANDSTONE_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID,
					BlockID.CHISELED_SANDSTONE_DOUBLE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CUT_SANDSTONE_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID, BlockID.CUT_SANDSTONE_DOUBLE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			RED_SANDSTONE_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID, BlockID.RED_SANDSTONE_DOUBLE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			SMOOTH_RED_SANDSTONE_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID,
					BlockID.SMOOTH_RED_SANDSTONE_DOUBLE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CHISELED_RED_SANDSTONE_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID,
					BlockID.CHISELED_RED_SANDSTONE_DOUBLE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CUT_RED_SANDSTONE_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID,
					BlockID.CUT_RED_SANDSTONE_DOUBLE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));

			GRANITE_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID, BlockID.GRANITE_DOUBLE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			POLISHED_GRANITE_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID,
					BlockID.POLISHED_GRANITE_DOUBLE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			DIORITE_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID, BlockID.DIORITE_DOUBLE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.QUARTZ).strength(1.5F, 6.0F));
			POLISHED_DIORITE_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID,
					BlockID.POLISHED_DIORITE_DOUBLE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.QUARTZ).strength(1.5F, 6.0F));
			ANDESITE_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID, BlockID.ANDESITE_DOUBLE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 6.0F));
			POLISHED_ANDESITE_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID,
					BlockID.POLISHED_ANDESITE_DOUBLE_SILL_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 6.0F));
			BLACKSTONE_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID, 
					BlockID.BLACKSTONE_DOUBLE_SILL_ID, 
					BlockBehaviour.Properties.copy(Blocks.BLACKSTONE));
			POLISHED_BLACKSTONE_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID, 
					BlockID.POLISHED_BLACKSTONE_DOUBLE_SILL_ID, 
					BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE));
			CHISELED_POLISHED_BLACKSTONE_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID, 
					BlockID.CHISELED_POLISHED_BLACKSTONE_DOUBLE_SILL_ID, 
					BlockBehaviour.Properties.copy(Blocks.CHISELED_POLISHED_BLACKSTONE));
			GILDED_BLACKSTONE_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID, 
					BlockID.GILDED_BLACKSTONE_DOUBLE_SILL_ID, 
					BlockBehaviour.Properties.copy(Blocks.GILDED_BLACKSTONE));
			POLISHED_BLACKSTONE_BRICKS_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID, 
					BlockID.POLISHED_BLACKSTONE_BRICKS_DOUBLE_SILL_ID, 
					BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE_BRICKS));
			CRACKED_POLISHED_BLACKSTONE_BRICKS_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID, 
					BlockID.CRACKED_POLISHED_BLACKSTONE_BRICKS_DOUBLE_SILL_ID, 
					BlockBehaviour.Properties.copy(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS));
			DEEPSLATE_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID, 
					BlockID.DEEPSLATE_DOUBLE_SILL_ID, 
					BlockBehaviour.Properties.copy(Blocks.DEEPSLATE));
			DEEPSLATE_BRICKS_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID, 
					BlockID.DEEPSLATE_BRICKS_DOUBLE_SILL_ID, 
					BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICKS));
			CRACKED_DEEPSLATE_BRICKS_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID, 
					BlockID.CRACKED_DEEPSLATE_BRICKS_DOUBLE_SILL_ID, 
					BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_BRICKS));
			COBBLED_DEEPSLATE_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID, 
					BlockID.COBBLED_DEEPSLATE_DOUBLE_SILL_ID, 
					BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE));
			POLISHED_DEEPSLATE_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID, 
					BlockID.POLISHED_DEEPSLATE_DOUBLE_SILL_ID, 
					BlockBehaviour.Properties.copy(Blocks.POLISHED_DEEPSLATE));
			CHISELED_DEEPSLATE_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID, 
					BlockID.CHISELED_DEEPSLATE_DOUBLE_SILL_ID, 
					BlockBehaviour.Properties.copy(Blocks.CHISELED_DEEPSLATE));
			DEEPSLATE_TILES_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID, 
					BlockID.DEEPSLATE_TILES_DOUBLE_SILL_ID, 
					BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_TILES));
			CRACKED_DEEPSLATE_TILES_DOUBLE_SILL = new DoubleSillBlock(DungeonBlocks.MOD_ID, 
					BlockID.CRACKED_DEEPSLATE_TILES_DOUBLE_SILL_ID, 
					BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_TILES));

			// Cornice
			STONE_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, BlockID.STONE_CORNICE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			SMOOTH_STONE_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, BlockID.SMOOTH_STONE_CORNICE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			COBBLESTONE_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, BlockID.COBBLESTONE_CORNICE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			MOSSY_COBBLESTONE_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, BlockID.MOSSY_COBBLESTONE_CORNICE_ID,
					Block.Properties.of(Material.STONE).strength(2.0F, 6.0F));
			BRICKS_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, BlockID.BRICKS_CORNICE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_RED).strength(2.0F, 6.0F));
			STONE_BRICKS_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, BlockID.STONE_BRICKS_CORNICE_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			MOSSY_STONE_BRICKS_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, BlockID.MOSSY_STONE_BRICKS_CORNICE_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			CRACKED_STONE_BRICKS_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, BlockID.CRACKED_STONE_BRICKS_CORNICE_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			CHISELED_STONE_BRICKS_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, BlockID.CHISELED_STONE_BRICKS_CORNICE_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			OBSIDIAN_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, BlockID.OBSIDIAN_CORNICE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(50.0F, 1200.0F));

			SANDSTONE_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, BlockID.SANDSTONE_CORNICE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			SMOOTH_SANDSTONE_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, BlockID.SMOOTH_SANDSTONE_CORNICE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CHISELED_SANDSTONE_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, BlockID.CHISELED_SANDSTONE_CORNICE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CUT_SANDSTONE_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, BlockID.CUT_SANDSTONE_CORNICE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			RED_SANDSTONE_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, BlockID.RED_SANDSTONE_CORNICE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			SMOOTH_RED_SANDSTONE_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, BlockID.SMOOTH_RED_SANDSTONE_CORNICE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CHISELED_RED_SANDSTONE_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID,
					BlockID.CHISELED_RED_SANDSTONE_CORNICE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CUT_RED_SANDSTONE_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, BlockID.CUT_RED_SANDSTONE_CORNICE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));

			GRANITE_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, BlockID.GRANITE_CORNICE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			POLISHED_GRANITE_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, BlockID.POLISHED_GRANITE_CORNICE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			DIORITE_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, BlockID.DIORITE_CORNICE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.QUARTZ).strength(1.5F, 6.0F));
			POLISHED_DIORITE_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, BlockID.POLISHED_DIORITE_CORNICE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.QUARTZ).strength(1.5F, 6.0F));
			ANDESITE_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, BlockID.ANDESITE_CORNICE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 6.0F));
			POLISHED_ANDESITE_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, BlockID.POLISHED_ANDESITE_CORNICE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 6.0F));
			BLACKSTONE_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, 
					BlockID.BLACKSTONE_CORNICE_ID, 
					BlockBehaviour.Properties.copy(Blocks.BLACKSTONE));
			POLISHED_BLACKSTONE_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, 
					BlockID.POLISHED_BLACKSTONE_CORNICE_ID, 
					BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE));
			CHISELED_POLISHED_BLACKSTONE_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, 
					BlockID.CHISELED_POLISHED_BLACKSTONE_CORNICE_ID, 
					BlockBehaviour.Properties.copy(Blocks.CHISELED_POLISHED_BLACKSTONE));
			GILDED_BLACKSTONE_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, 
					BlockID.GILDED_BLACKSTONE_CORNICE_ID, 
					BlockBehaviour.Properties.copy(Blocks.GILDED_BLACKSTONE));
			POLISHED_BLACKSTONE_BRICKS_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, 
					BlockID.POLISHED_BLACKSTONE_BRICKS_CORNICE_ID, 
					BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE_BRICKS));
			CRACKED_POLISHED_BLACKSTONE_BRICKS_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, 
					BlockID.CRACKED_POLISHED_BLACKSTONE_BRICKS_CORNICE_ID, 
					BlockBehaviour.Properties.copy(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS));
			DEEPSLATE_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, 
					BlockID.DEEPSLATE_CORNICE_ID, 
					BlockBehaviour.Properties.copy(Blocks.DEEPSLATE));
			DEEPSLATE_BRICKS_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, 
					BlockID.DEEPSLATE_BRICKS_CORNICE_ID, 
					BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICKS));
			CRACKED_DEEPSLATE_BRICKS_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, 
					BlockID.CRACKED_DEEPSLATE_BRICKS_CORNICE_ID, 
					BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_BRICKS));
			COBBLED_DEEPSLATE_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, 
					BlockID.COBBLED_DEEPSLATE_CORNICE_ID, 
					BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE));
			POLISHED_DEEPSLATE_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, 
					BlockID.POLISHED_DEEPSLATE_CORNICE_ID, 
					BlockBehaviour.Properties.copy(Blocks.POLISHED_DEEPSLATE));
			CHISELED_DEEPSLATE_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, 
					BlockID.CHISELED_DEEPSLATE_CORNICE_ID, 
					BlockBehaviour.Properties.copy(Blocks.CHISELED_DEEPSLATE));
			DEEPSLATE_TILES_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, 
					BlockID.DEEPSLATE_TILES_CORNICE_ID, 
					BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_TILES));
			CRACKED_DEEPSLATE_TILES_CORNICE = new CorniceBlock(DungeonBlocks.MOD_ID, 
					BlockID.CRACKED_DEEPSLATE_TILES_CORNICE_ID, 
					BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_TILES));

			// crown molding
			STONE_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID, BlockID.STONE_CROWN_MOLDING_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			SMOOTH_STONE_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID, BlockID.SMOOTH_STONE_CROWN_MOLDING_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			COBBLESTONE_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID, BlockID.COBBLESTONE_CROWN_MOLDING_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			MOSSY_COBBLESTONE_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID,
					BlockID.MOSSY_COBBLESTONE_CROWN_MOLDING_ID,
					Block.Properties.of(Material.STONE).strength(2.0F, 6.0F));
			BRICKS_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID, BlockID.BRICKS_CROWN_MOLDING_ID,
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_RED).strength(2.0F, 6.0F));
			STONE_BRICKS_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID, BlockID.STONE_BRICKS_CROWN_MOLDING_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			MOSSY_STONE_BRICKS_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID,
					BlockID.MOSSY_STONE_BRICKS_CROWN_MOLDING_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			CRACKED_STONE_BRICKS_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID,
					BlockID.CRACKED_STONE_BRICKS_CROWN_MOLDING_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			CHISELED_STONE_BRICKS_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID,
					BlockID.CHISELED_STONE_BRICKS_CROWN_MOLDING_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			OBSIDIAN_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID, BlockID.OBSIDIAN_CROWN_MOLDING_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(50.0F, 1200.0F));

			SANDSTONE_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID, BlockID.SANDSTONE_CROWN_MOLDING_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			SMOOTH_SANDSTONE_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID,
					BlockID.SMOOTH_SANDSTONE_CROWN_MOLDING_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CHISELED_SANDSTONE_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID,
					BlockID.CHISELED_SANDSTONE_CROWN_MOLDING_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CUT_SANDSTONE_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID,
					BlockID.CUT_SANDSTONE_CROWN_MOLDING_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			RED_SANDSTONE_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID,
					BlockID.RED_SANDSTONE_CROWN_MOLDING_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			SMOOTH_RED_SANDSTONE_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID,
					BlockID.SMOOTH_RED_SANDSTONE_CROWN_MOLDING_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CHISELED_RED_SANDSTONE_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID,
					BlockID.CHISELED_RED_SANDSTONE_CROWN_MOLDING_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CUT_RED_SANDSTONE_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID,
					BlockID.CUT_RED_SANDSTONE_CROWN_MOLDING_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));

			GRANITE_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID, BlockID.GRANITE_CROWN_MOLDING_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			POLISHED_GRANITE_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID,
					BlockID.POLISHED_GRANITE_CROWN_MOLDING_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			DIORITE_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID, BlockID.DIORITE_CROWN_MOLDING_ID,
					Block.Properties.of(Material.STONE, MaterialColor.QUARTZ).strength(1.5F, 6.0F));
			POLISHED_DIORITE_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID,
					BlockID.POLISHED_DIORITE_CROWN_MOLDING_ID,
					Block.Properties.of(Material.STONE, MaterialColor.QUARTZ).strength(1.5F, 6.0F));
			ANDESITE_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID, BlockID.ANDESITE_CROWN_MOLDING_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 6.0F));
			POLISHED_ANDESITE_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID,
					BlockID.POLISHED_ANDESITE_CROWN_MOLDING_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 6.0F));
			BLACKSTONE_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID, 
					BlockID.BLACKSTONE_CROWN_MOLDING_ID, 
					BlockBehaviour.Properties.copy(Blocks.BLACKSTONE));
			POLISHED_BLACKSTONE_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID, 
					BlockID.POLISHED_BLACKSTONE_CROWN_MOLDING_ID, 
					BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE));
			CHISELED_POLISHED_BLACKSTONE_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID, 
					BlockID.CHISELED_POLISHED_BLACKSTONE_CROWN_MOLDING_ID, 
					BlockBehaviour.Properties.copy(Blocks.CHISELED_POLISHED_BLACKSTONE));
			GILDED_BLACKSTONE_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID, 
					BlockID.GILDED_BLACKSTONE_CROWN_MOLDING_ID, 
					BlockBehaviour.Properties.copy(Blocks.GILDED_BLACKSTONE));
			POLISHED_BLACKSTONE_BRICKS_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID, 
					BlockID.POLISHED_BLACKSTONE_BRICKS_CROWN_MOLDING_ID, 
					BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE_BRICKS));
			CRACKED_POLISHED_BLACKSTONE_BRICKS_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID, 
					BlockID.CRACKED_POLISHED_BLACKSTONE_BRICKS_CROWN_MOLDING_ID, 
					BlockBehaviour.Properties.copy(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS));
			DEEPSLATE_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID, 
					BlockID.DEEPSLATE_CROWN_MOLDING_ID, 
					BlockBehaviour.Properties.copy(Blocks.DEEPSLATE));
			DEEPSLATE_BRICKS_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID, 
					BlockID.DEEPSLATE_BRICKS_CROWN_MOLDING_ID, 
					BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICKS));
			CRACKED_DEEPSLATE_BRICKS_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID, 
					BlockID.CRACKED_DEEPSLATE_BRICKS_CROWN_MOLDING_ID, 
					BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_BRICKS));
			COBBLED_DEEPSLATE_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID, 
					BlockID.COBBLED_DEEPSLATE_CROWN_MOLDING_ID, 
					BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE));
			POLISHED_DEEPSLATE_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID, 
					BlockID.POLISHED_DEEPSLATE_CROWN_MOLDING_ID, 
					BlockBehaviour.Properties.copy(Blocks.POLISHED_DEEPSLATE));
			CHISELED_DEEPSLATE_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID, 
					BlockID.CHISELED_DEEPSLATE_CROWN_MOLDING_ID, 
					BlockBehaviour.Properties.copy(Blocks.CHISELED_DEEPSLATE));
			DEEPSLATE_TILES_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID, 
					BlockID.DEEPSLATE_TILES_CROWN_MOLDING_ID, 
					BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_TILES));
			CRACKED_DEEPSLATE_TILES_CROWN_MOLDING = new CrownMoldingBlock(DungeonBlocks.MOD_ID, 
					BlockID.CRACKED_DEEPSLATE_TILES_CROWN_MOLDING_ID, 
					BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_TILES));

			// pillar base
			STONE_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID, BlockID.STONE_PILLAR_BASE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			SMOOTH_STONE_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID, BlockID.SMOOTH_STONE_PILLAR_BASE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			COBBLESTONE_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID, BlockID.COBBLESTONE_PILLAR_BASE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			MOSSY_COBBLESTONE_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID,
					BlockID.MOSSY_COBBLESTONE_PILLAR_BASE_ID,
					Block.Properties.of(Material.STONE).strength(2.0F, 6.0F));
			BRICKS_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID, BlockID.BRICKS_PILLAR_BASE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_RED).strength(2.0F, 6.0F));
			STONE_BRICKS_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID, BlockID.STONE_BRICKS_PILLAR_BASE_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			MOSSY_STONE_BRICKS_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID,
					BlockID.MOSSY_STONE_BRICKS_PILLAR_BASE_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			CRACKED_STONE_BRICKS_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID,
					BlockID.CRACKED_STONE_BRICKS_PILLAR_BASE_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			CHISELED_STONE_BRICKS_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID,
					BlockID.CHISELED_STONE_BRICKS_PILLAR_BASE_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			OBSIDIAN_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID, BlockID.OBSIDIAN_PILLAR_BASE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(50.0F, 1200.0F));

			SANDSTONE_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID, BlockID.SANDSTONE_PILLAR_BASE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			SMOOTH_SANDSTONE_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID,
					BlockID.SMOOTH_SANDSTONE_PILLAR_BASE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CHISELED_SANDSTONE_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID,
					BlockID.CHISELED_SANDSTONE_PILLAR_BASE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CUT_SANDSTONE_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID, BlockID.CUT_SANDSTONE_PILLAR_BASE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			RED_SANDSTONE_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID, BlockID.RED_SANDSTONE_PILLAR_BASE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			SMOOTH_RED_SANDSTONE_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID,
					BlockID.SMOOTH_RED_SANDSTONE_PILLAR_BASE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CHISELED_RED_SANDSTONE_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID,
					BlockID.CHISELED_RED_SANDSTONE_PILLAR_BASE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CUT_RED_SANDSTONE_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID,
					BlockID.CUT_RED_SANDSTONE_PILLAR_BASE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));

			GRANITE_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID, BlockID.GRANITE_PILLAR_BASE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			POLISHED_GRANITE_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID,
					BlockID.POLISHED_GRANITE_PILLAR_BASE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			DIORITE_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID, BlockID.DIORITE_PILLAR_BASE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.QUARTZ).strength(1.5F, 6.0F));
			POLISHED_DIORITE_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID,
					BlockID.POLISHED_DIORITE_PILLAR_BASE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.QUARTZ).strength(1.5F, 6.0F));
			ANDESITE_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID, BlockID.ANDESITE_PILLAR_BASE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 6.0F));
			POLISHED_ANDESITE_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID,
					BlockID.POLISHED_ANDESITE_PILLAR_BASE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 6.0F));
			BLACKSTONE_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID, 
					BlockID.BLACKSTONE_PILLAR_BASE_ID, 
					BlockBehaviour.Properties.copy(Blocks.BLACKSTONE));
			POLISHED_BLACKSTONE_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID, 
					BlockID.POLISHED_BLACKSTONE_PILLAR_BASE_ID, 
					BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE));
			CHISELED_POLISHED_BLACKSTONE_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID, 
					BlockID.CHISELED_POLISHED_BLACKSTONE_PILLAR_BASE_ID, 
					BlockBehaviour.Properties.copy(Blocks.CHISELED_POLISHED_BLACKSTONE));
			GILDED_BLACKSTONE_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID, 
					BlockID.GILDED_BLACKSTONE_PILLAR_BASE_ID, 
					BlockBehaviour.Properties.copy(Blocks.GILDED_BLACKSTONE));
			POLISHED_BLACKSTONE_BRICKS_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID, 
					BlockID.POLISHED_BLACKSTONE_BRICKS_PILLAR_BASE_ID, 
					BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE_BRICKS));
			CRACKED_POLISHED_BLACKSTONE_BRICKS_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID, 
					BlockID.CRACKED_POLISHED_BLACKSTONE_BRICKS_PILLAR_BASE_ID, 
					BlockBehaviour.Properties.copy(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS));
			DEEPSLATE_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID, 
					BlockID.DEEPSLATE_PILLAR_BASE_ID, 
					BlockBehaviour.Properties.copy(Blocks.DEEPSLATE));
			DEEPSLATE_BRICKS_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID, 
					BlockID.DEEPSLATE_BRICKS_PILLAR_BASE_ID, 
					BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICKS));
			CRACKED_DEEPSLATE_BRICKS_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID, 
					BlockID.CRACKED_DEEPSLATE_BRICKS_PILLAR_BASE_ID, 
					BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_BRICKS));
			COBBLED_DEEPSLATE_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID, 
					BlockID.COBBLED_DEEPSLATE_PILLAR_BASE_ID, 
					BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE));
			POLISHED_DEEPSLATE_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID, 
					BlockID.POLISHED_DEEPSLATE_PILLAR_BASE_ID, 
					BlockBehaviour.Properties.copy(Blocks.POLISHED_DEEPSLATE));
			CHISELED_DEEPSLATE_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID, 
					BlockID.CHISELED_DEEPSLATE_PILLAR_BASE_ID, 
					BlockBehaviour.Properties.copy(Blocks.CHISELED_DEEPSLATE));
			DEEPSLATE_TILES_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID, 
					BlockID.DEEPSLATE_TILES_PILLAR_BASE_ID, 
					BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_TILES));
			CRACKED_DEEPSLATE_TILES_PILLAR_BASE = new PillarBaseBlock(DungeonBlocks.MOD_ID, 
					BlockID.CRACKED_DEEPSLATE_TILES_PILLAR_BASE_ID, 
					BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_TILES));

			// pillar
			STONE_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, BlockID.STONE_PILLAR_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			SMOOTH_STONE_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, BlockID.SMOOTH_STONE_PILLAR_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			COBBLESTONE_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, BlockID.COBBLESTONE_PILLAR_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			MOSSY_COBBLESTONE_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, BlockID.MOSSY_COBBLESTONE_PILLAR_ID,
					Block.Properties.of(Material.STONE).strength(2.0F, 6.0F));
			BRICKS_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, BlockID.BRICKS_PILLAR_ID,
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_RED).strength(2.0F, 6.0F));
			STONE_BRICKS_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, BlockID.STONE_BRICKS_PILLAR_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			MOSSY_STONE_BRICKS_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, BlockID.MOSSY_STONE_BRICKS_PILLAR_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			CRACKED_STONE_BRICKS_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, BlockID.CRACKED_STONE_BRICKS_PILLAR_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			CHISELED_STONE_BRICKS_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, BlockID.CHISELED_STONE_BRICKS_PILLAR_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F));
			OBSIDIAN_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, BlockID.OBSIDIAN_PILLAR_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(50.0F, 1200.0F));

			SANDSTONE_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, BlockID.SANDSTONE_PILLAR_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			SMOOTH_SANDSTONE_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, BlockID.SMOOTH_SANDSTONE_PILLAR_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CHISELED_SANDSTONE_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, BlockID.CHISELED_SANDSTONE_PILLAR_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CUT_SANDSTONE_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, BlockID.CUT_SANDSTONE_PILLAR_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			RED_SANDSTONE_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, BlockID.RED_SANDSTONE_PILLAR_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			SMOOTH_RED_SANDSTONE_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, BlockID.SMOOTH_RED_SANDSTONE_PILLAR_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CHISELED_RED_SANDSTONE_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, BlockID.CHISELED_RED_SANDSTONE_PILLAR_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));
			CUT_RED_SANDSTONE_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, BlockID.CUT_RED_SANDSTONE_PILLAR_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F));

			GRANITE_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, BlockID.GRANITE_PILLAR_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			POLISHED_GRANITE_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, BlockID.POLISHED_GRANITE_PILLAR_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F));
			DIORITE_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, BlockID.DIORITE_PILLAR_ID,
					Block.Properties.of(Material.STONE, MaterialColor.QUARTZ).strength(1.5F, 6.0F));
			POLISHED_DIORITE_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, BlockID.POLISHED_DIORITE_PILLAR_ID,
					Block.Properties.of(Material.STONE, MaterialColor.QUARTZ).strength(1.5F, 6.0F));
			ANDESITE_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, BlockID.ANDESITE_PILLAR_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 6.0F));
			POLISHED_ANDESITE_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, BlockID.POLISHED_ANDESITE_PILLAR_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 6.0F));
			BLACKSTONE_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, 
					BlockID.BLACKSTONE_PILLAR_ID, 
					BlockBehaviour.Properties.copy(Blocks.BLACKSTONE));
			POLISHED_BLACKSTONE_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, 
					BlockID.POLISHED_BLACKSTONE_PILLAR_ID, 
					BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE));
			CHISELED_POLISHED_BLACKSTONE_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, 
					BlockID.CHISELED_POLISHED_BLACKSTONE_PILLAR_ID, 
					BlockBehaviour.Properties.copy(Blocks.CHISELED_POLISHED_BLACKSTONE));
			GILDED_BLACKSTONE_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, 
					BlockID.GILDED_BLACKSTONE_PILLAR_ID, 
					BlockBehaviour.Properties.copy(Blocks.GILDED_BLACKSTONE));
			POLISHED_BLACKSTONE_BRICKS_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, 
					BlockID.POLISHED_BLACKSTONE_BRICKS_PILLAR_ID, 
					BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE_BRICKS));
			CRACKED_POLISHED_BLACKSTONE_BRICKS_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, 
					BlockID.CRACKED_POLISHED_BLACKSTONE_BRICKS_PILLAR_ID, 
					BlockBehaviour.Properties.copy(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS));
			DEEPSLATE_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, 
					BlockID.DEEPSLATE_PILLAR_ID, 
					BlockBehaviour.Properties.copy(Blocks.DEEPSLATE));
			DEEPSLATE_BRICKS_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, 
					BlockID.DEEPSLATE_BRICKS_PILLAR_ID, 
					BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICKS));
			CRACKED_DEEPSLATE_BRICKS_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, 
					BlockID.CRACKED_DEEPSLATE_BRICKS_PILLAR_ID, 
					BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_BRICKS));
			COBBLED_DEEPSLATE_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, 
					BlockID.COBBLED_DEEPSLATE_PILLAR_ID, 
					BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE));
			POLISHED_DEEPSLATE_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, 
					BlockID.POLISHED_DEEPSLATE_PILLAR_ID, 
					BlockBehaviour.Properties.copy(Blocks.POLISHED_DEEPSLATE));
			CHISELED_DEEPSLATE_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, 
					BlockID.CHISELED_DEEPSLATE_PILLAR_ID, 
					BlockBehaviour.Properties.copy(Blocks.CHISELED_DEEPSLATE));
			DEEPSLATE_TILES_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, 
					BlockID.DEEPSLATE_TILES_PILLAR_ID, 
					BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_TILES));
			CRACKED_DEEPSLATE_TILES_PILLAR = new PillarBlock(DungeonBlocks.MOD_ID, 
					BlockID.CRACKED_DEEPSLATE_TILES_PILLAR_ID, 
					BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_TILES));

			// wall sconce
			STONE_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID, BlockID.STONE_WALL_SCONCE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F)
							.noCollission().lightLevel((light)->{return  14;}).sound(SoundType.WOOD));
			SMOOTH_STONE_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID, BlockID.SMOOTH_STONE_WALL_SCONCE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F)
							.noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD));
			COBBLESTONE_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID, BlockID.COBBLESTONE_WALL_SCONCE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F)
							.noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD));
			MOSSY_COBBLESTONE_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID, BlockID.MOSSY_COBBLESTONE_WALL_SCONCE_ID,
					Block.Properties.of(Material.STONE).strength(2.0F, 6.0F).noCollission()
							.lightLevel((light)->{return 14;}).sound(SoundType.WOOD));
			BRICKS_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID, BlockID.BRICKS_WALL_SCONCE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.COLOR_RED).strength(2.0F, 6.0F)
							.noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD));
			STONE_BRICKS_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID, BlockID.STONE_BRICKS_WALL_SCONCE_ID,
					Block.Properties.of(Material.STONE).strength(1.5F, 6.0F).noCollission()
							.lightLevel((light)->{return 14;}).sound(SoundType.WOOD));
			MOSSY_STONE_BRICKS_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID,
					BlockID.MOSSY_STONE_BRICKS_WALL_SCONCE_ID, Block.Properties.of(Material.STONE)
							.strength(1.5F, 6.0F).noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD));
			CRACKED_STONE_BRICKS_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID,
					BlockID.CRACKED_STONE_BRICKS_WALL_SCONCE_ID, Block.Properties.of(Material.STONE)
							.strength(1.5F, 6.0F).noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD));
			CHISELED_STONE_BRICKS_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID,
					BlockID.CHISELED_STONE_BRICKS_WALL_SCONCE_ID, Block.Properties.of(Material.STONE)
							.strength(1.5F, 6.0F).noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD));
			OBSIDIAN_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID, BlockID.OBSIDIAN_WALL_SCONCE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(50.0F, 1200.0F)
							.noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD));

			SANDSTONE_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID, BlockID.SANDSTONE_WALL_SCONCE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F)
							.noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD));
			SMOOTH_SANDSTONE_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID, BlockID.SMOOTH_SANDSTONE_WALL_SCONCE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F)
							.noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD));
			CHISELED_SANDSTONE_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID,
					BlockID.CHISELED_SANDSTONE_WALL_SCONCE_ID, Block.Properties.of(Material.STONE, MaterialColor.SAND)
							.strength(0.8F).noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD));
			CUT_SANDSTONE_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID, BlockID.CUT_SANDSTONE_WALL_SCONCE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F)
							.noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD));
			RED_SANDSTONE_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID, BlockID.RED_SANDSTONE_WALL_SCONCE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F)
							.noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD));
			SMOOTH_RED_SANDSTONE_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID,
					BlockID.SMOOTH_RED_SANDSTONE_WALL_SCONCE_ID, Block.Properties.of(Material.STONE, MaterialColor.SAND)
							.strength(0.8F).noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD));
			CHISELED_RED_SANDSTONE_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID,
					BlockID.CHISELED_RED_SANDSTONE_WALL_SCONCE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F)
							.noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD));
			CUT_RED_SANDSTONE_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID, BlockID.CUT_RED_SANDSTONE_WALL_SCONCE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(0.8F)
							.noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD));

			GRANITE_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID, BlockID.GRANITE_WALL_SCONCE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F)
							.noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD));
			POLISHED_GRANITE_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID, BlockID.POLISHED_GRANITE_WALL_SCONCE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.5F, 6.0F)
							.noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD));
			DIORITE_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID, BlockID.DIORITE_WALL_SCONCE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.QUARTZ).strength(1.5F, 6.0F)
							.noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD));
			POLISHED_DIORITE_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID, BlockID.POLISHED_DIORITE_WALL_SCONCE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.QUARTZ).strength(1.5F, 6.0F)
							.noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD));
			ANDESITE_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID, BlockID.ANDESITE_WALL_SCONCE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 6.0F)
							.noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD));
			POLISHED_ANDESITE_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID, BlockID.POLISHED_ANDESITE_WALL_SCONCE_ID,
					Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 6.0F)
							.noCollission().lightLevel((light)->{return 14;}).sound(SoundType.WOOD));
			BLACKSTONE_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID, 
					BlockID.BLACKSTONE_WALL_SCONCE_ID, 
					BlockBehaviour.Properties.copy(Blocks.BLACKSTONE));
			POLISHED_BLACKSTONE_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID, 
					BlockID.POLISHED_BLACKSTONE_WALL_SCONCE_ID, 
					BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE));
			CHISELED_POLISHED_BLACKSTONE_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID, 
					BlockID.CHISELED_POLISHED_BLACKSTONE_WALL_SCONCE_ID, 
					BlockBehaviour.Properties.copy(Blocks.CHISELED_POLISHED_BLACKSTONE));
			GILDED_BLACKSTONE_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID, 
					BlockID.GILDED_BLACKSTONE_WALL_SCONCE_ID, 
					BlockBehaviour.Properties.copy(Blocks.GILDED_BLACKSTONE));
			POLISHED_BLACKSTONE_BRICKS_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID, 
					BlockID.POLISHED_BLACKSTONE_BRICKS_WALL_SCONCE_ID, 
					BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE_BRICKS));
			CRACKED_POLISHED_BLACKSTONE_BRICKS_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID, 
					BlockID.CRACKED_POLISHED_BLACKSTONE_BRICKS_WALL_SCONCE_ID, 
					BlockBehaviour.Properties.copy(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS));
			DEEPSLATE_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID, 
					BlockID.DEEPSLATE_WALL_SCONCE_ID, 
					BlockBehaviour.Properties.copy(Blocks.DEEPSLATE));
			DEEPSLATE_BRICKS_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID, 
					BlockID.DEEPSLATE_BRICKS_WALL_SCONCE_ID, 
					BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICKS));
			CRACKED_DEEPSLATE_BRICKS_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID, 
					BlockID.CRACKED_DEEPSLATE_BRICKS_WALL_SCONCE_ID, 
					BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_BRICKS));
			COBBLED_DEEPSLATE_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID, 
					BlockID.COBBLED_DEEPSLATE_WALL_SCONCE_ID, 
					BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE));
			POLISHED_DEEPSLATE_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID, 
					BlockID.POLISHED_DEEPSLATE_WALL_SCONCE_ID, 
					BlockBehaviour.Properties.copy(Blocks.POLISHED_DEEPSLATE));
			CHISELED_DEEPSLATE_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID, 
					BlockID.CHISELED_DEEPSLATE_WALL_SCONCE_ID, 
					BlockBehaviour.Properties.copy(Blocks.CHISELED_DEEPSLATE));
			DEEPSLATE_TILES_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID, 
					BlockID.DEEPSLATE_TILES_WALL_SCONCE_ID, 
					BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_TILES));
			CRACKED_DEEPSLATE_TILES_WALL_SCONCE = new SconceBlock(DungeonBlocks.MOD_ID, 
					BlockID.CRACKED_DEEPSLATE_TILES_WALL_SCONCE_ID, 
					BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_TILES));

			GRATE = new GrateBlock(DungeonBlocks.MOD_ID, BlockID.GRATE_ID,
					Block.Properties.of(Material.METAL, MaterialColor.STONE).strength(1.5F, 6.0F));

			/*
			 * setup array
			 */

			// facades
			BLOCKS.add(STONE_FACADE);
			BLOCKS.add(SMOOTH_STONE_FACADE);
			BLOCKS.add(COBBLESTONE_FACADE);
			BLOCKS.add(MOSSY_COBBLESTONE_FACADE);
			BLOCKS.add(BRICKS_FACADE);
			BLOCKS.add(STONE_BRICKS_FACADE);
			BLOCKS.add(MOSSY_STONE_BRICKS_FACADE);
			BLOCKS.add(CRACKED_STONE_BRICKS_FACADE);
			BLOCKS.add(CHISELED_STONE_BRICKS_FACADE);
			BLOCKS.add(OBSIDIAN_FACADE);
			BLOCKS.add(SANDSTONE_FACADE);
			BLOCKS.add(SMOOTH_SANDSTONE_FACADE);
			BLOCKS.add(CHISELED_SANDSTONE_FACADE);
			BLOCKS.add(CUT_SANDSTONE_FACADE);
			BLOCKS.add(RED_SANDSTONE_FACADE);
			BLOCKS.add(SMOOTH_RED_SANDSTONE_FACADE);
			BLOCKS.add(CHISELED_RED_SANDSTONE_FACADE);
			BLOCKS.add(CUT_RED_SANDSTONE_FACADE);
			BLOCKS.add(GRANITE_FACADE);
			BLOCKS.add(POLISHED_GRANITE_FACADE);
			BLOCKS.add(DIORITE_FACADE);
			BLOCKS.add(POLISHED_DIORITE_FACADE);
			BLOCKS.add(ANDESITE_FACADE);
			BLOCKS.add(POLISHED_ANDESITE_FACADE);
			
			BLOCKS.add(BLACKSTONE_FACADE);
			BLOCKS.add(POLISHED_BLACKSTONE_FACADE);
			BLOCKS.add(CHISELED_POLISHED_BLACKSTONE_FACADE);
			BLOCKS.add(GILDED_BLACKSTONE_FACADE);
			BLOCKS.add(POLISHED_BLACKSTONE_BRICKS_FACADE);
			BLOCKS.add(CRACKED_POLISHED_BLACKSTONE_BRICKS_FACADE);
			BLOCKS.add(DEEPSLATE_FACADE);
			BLOCKS.add(DEEPSLATE_BRICKS_FACADE);
			BLOCKS.add(CRACKED_DEEPSLATE_BRICKS_FACADE);
			BLOCKS.add(COBBLED_DEEPSLATE_FACADE);
			BLOCKS.add(POLISHED_DEEPSLATE_FACADE);
			BLOCKS.add(CHISELED_DEEPSLATE_FACADE);
			BLOCKS.add(DEEPSLATE_TILES_FACADE);
			BLOCKS.add(CRACKED_DEEPSLATE_TILES_FACADE);

			// quarter facades
			BLOCKS.add(STONE_QUARTER_FACADE);
			BLOCKS.add(SMOOTH_STONE_QUARTER_FACADE);
			BLOCKS.add(COBBLESTONE_QUARTER_FACADE);
			BLOCKS.add(MOSSY_COBBLESTONE_QUARTER_FACADE);
			BLOCKS.add(BRICKS_QUARTER_FACADE);
			BLOCKS.add(STONE_BRICKS_QUARTER_FACADE);
			BLOCKS.add(MOSSY_STONE_BRICKS_QUARTER_FACADE);
			BLOCKS.add(CRACKED_STONE_BRICKS_QUARTER_FACADE);
			BLOCKS.add(CHISELED_STONE_BRICKS_QUARTER_FACADE);
			BLOCKS.add(OBSIDIAN_QUARTER_FACADE);
			BLOCKS.add(SANDSTONE_QUARTER_FACADE);
			BLOCKS.add(SMOOTH_SANDSTONE_QUARTER_FACADE);
			BLOCKS.add(CHISELED_SANDSTONE_QUARTER_FACADE);
			BLOCKS.add(CUT_SANDSTONE_QUARTER_FACADE);
			BLOCKS.add(RED_SANDSTONE_QUARTER_FACADE);
			BLOCKS.add(SMOOTH_RED_SANDSTONE_QUARTER_FACADE);
			BLOCKS.add(CHISELED_RED_SANDSTONE_QUARTER_FACADE);
			BLOCKS.add(CUT_RED_SANDSTONE_QUARTER_FACADE);
			BLOCKS.add(GRANITE_QUARTER_FACADE);
			BLOCKS.add(POLISHED_GRANITE_QUARTER_FACADE);
			BLOCKS.add(DIORITE_QUARTER_FACADE);
			BLOCKS.add(POLISHED_DIORITE_QUARTER_FACADE);
			BLOCKS.add(ANDESITE_QUARTER_FACADE);
			BLOCKS.add(POLISHED_ANDESITE_QUARTER_FACADE);
			BLOCKS.add(BLACKSTONE_QUARTER_FACADE);
			BLOCKS.add(POLISHED_BLACKSTONE_QUARTER_FACADE);
			BLOCKS.add(CHISELED_POLISHED_BLACKSTONE_QUARTER_FACADE);
			BLOCKS.add(GILDED_BLACKSTONE_QUARTER_FACADE);
			BLOCKS.add(POLISHED_BLACKSTONE_BRICKS_QUARTER_FACADE);
			BLOCKS.add(CRACKED_POLISHED_BLACKSTONE_BRICKS_QUARTER_FACADE);
			BLOCKS.add(DEEPSLATE_QUARTER_FACADE);
			BLOCKS.add(DEEPSLATE_BRICKS_QUARTER_FACADE);
			BLOCKS.add(CRACKED_DEEPSLATE_BRICKS_QUARTER_FACADE);
			BLOCKS.add(COBBLED_DEEPSLATE_QUARTER_FACADE);
			BLOCKS.add(POLISHED_DEEPSLATE_QUARTER_FACADE);
			BLOCKS.add(CHISELED_DEEPSLATE_QUARTER_FACADE);
			BLOCKS.add(DEEPSLATE_TILES_QUARTER_FACADE);
			BLOCKS.add(CRACKED_DEEPSLATE_TILES_QUARTER_FACADE);
			
			// fluted
			BLOCKS.add(STONE_FLUTED);
			BLOCKS.add(SMOOTH_STONE_FLUTED);
			BLOCKS.add(COBBLESTONE_FLUTED);
			BLOCKS.add(MOSSY_COBBLESTONE_FLUTED);
			BLOCKS.add(BRICKS_FLUTED);
			BLOCKS.add(STONE_BRICKS_FLUTED);
			BLOCKS.add(MOSSY_STONE_BRICKS_FLUTED);
			BLOCKS.add(CRACKED_STONE_BRICKS_FLUTED);
			BLOCKS.add(CHISELED_STONE_BRICKS_FLUTED);
			BLOCKS.add(OBSIDIAN_FLUTED);
			BLOCKS.add(SANDSTONE_FLUTED);
			BLOCKS.add(SMOOTH_SANDSTONE_FLUTED);
			BLOCKS.add(CHISELED_SANDSTONE_FLUTED);
			BLOCKS.add(CUT_SANDSTONE_FLUTED);
			BLOCKS.add(RED_SANDSTONE_FLUTED);
			BLOCKS.add(SMOOTH_RED_SANDSTONE_FLUTED);
			BLOCKS.add(CHISELED_RED_SANDSTONE_FLUTED);
			BLOCKS.add(CUT_RED_SANDSTONE_FLUTED);
			BLOCKS.add(GRANITE_FLUTED);
			BLOCKS.add(POLISHED_GRANITE_FLUTED);
			BLOCKS.add(DIORITE_FLUTED);
			BLOCKS.add(POLISHED_DIORITE_FLUTED);
			BLOCKS.add(ANDESITE_FLUTED);
			BLOCKS.add(POLISHED_ANDESITE_FLUTED);
			BLOCKS.add(BLACKSTONE_FLUTED);
			BLOCKS.add(POLISHED_BLACKSTONE_FLUTED);
			BLOCKS.add(CHISELED_POLISHED_BLACKSTONE_FLUTED);
			BLOCKS.add(GILDED_BLACKSTONE_FLUTED);
			BLOCKS.add(POLISHED_BLACKSTONE_BRICKS_FLUTED);
			BLOCKS.add(CRACKED_POLISHED_BLACKSTONE_BRICKS_FLUTED);
			BLOCKS.add(DEEPSLATE_FLUTED);
			BLOCKS.add(DEEPSLATE_BRICKS_FLUTED);
			BLOCKS.add(CRACKED_DEEPSLATE_BRICKS_FLUTED);
			BLOCKS.add(COBBLED_DEEPSLATE_FLUTED);
			BLOCKS.add(POLISHED_DEEPSLATE_FLUTED);
			BLOCKS.add(CHISELED_DEEPSLATE_FLUTED);
			BLOCKS.add(DEEPSLATE_TILES_FLUTED);
			BLOCKS.add(CRACKED_DEEPSLATE_TILES_FLUTED);

			// fluted facade
			BLOCKS.add(STONE_FLUTED_FACADE);
			BLOCKS.add(SMOOTH_STONE_FLUTED_FACADE);
			BLOCKS.add(COBBLESTONE_FLUTED_FACADE);
			BLOCKS.add(MOSSY_COBBLESTONE_FLUTED_FACADE);
			BLOCKS.add(BRICKS_FLUTED_FACADE);
			BLOCKS.add(STONE_BRICKS_FLUTED_FACADE);
			BLOCKS.add(MOSSY_STONE_BRICKS_FLUTED_FACADE);
			BLOCKS.add(CRACKED_STONE_BRICKS_FLUTED_FACADE);
			BLOCKS.add(CHISELED_STONE_BRICKS_FLUTED_FACADE);
			BLOCKS.add(OBSIDIAN_FLUTED_FACADE);
			BLOCKS.add(SANDSTONE_FLUTED_FACADE);
			BLOCKS.add(SMOOTH_SANDSTONE_FLUTED_FACADE);
			BLOCKS.add(CHISELED_SANDSTONE_FLUTED_FACADE);
			BLOCKS.add(CUT_SANDSTONE_FLUTED_FACADE);
			BLOCKS.add(RED_SANDSTONE_FLUTED_FACADE);
			BLOCKS.add(SMOOTH_RED_SANDSTONE_FLUTED_FACADE);
			BLOCKS.add(CHISELED_RED_SANDSTONE_FLUTED_FACADE);
			BLOCKS.add(CUT_RED_SANDSTONE_FLUTED_FACADE);
			BLOCKS.add(GRANITE_FLUTED_FACADE);
			BLOCKS.add(POLISHED_GRANITE_FLUTED_FACADE);
			BLOCKS.add(DIORITE_FLUTED_FACADE);
			BLOCKS.add(POLISHED_DIORITE_FLUTED_FACADE);
			BLOCKS.add(ANDESITE_FLUTED_FACADE);
			BLOCKS.add(POLISHED_ANDESITE_FLUTED_FACADE);
			BLOCKS.add(BLACKSTONE_FLUTED_FACADE);
			BLOCKS.add(POLISHED_BLACKSTONE_FLUTED_FACADE);
			BLOCKS.add(CHISELED_POLISHED_BLACKSTONE_FLUTED_FACADE);
			BLOCKS.add(GILDED_BLACKSTONE_FLUTED_FACADE);
			BLOCKS.add(POLISHED_BLACKSTONE_BRICKS_FLUTED_FACADE);
			BLOCKS.add(CRACKED_POLISHED_BLACKSTONE_BRICKS_FLUTED_FACADE);
			BLOCKS.add(DEEPSLATE_FLUTED_FACADE);
			BLOCKS.add(DEEPSLATE_BRICKS_FLUTED_FACADE);
			BLOCKS.add(CRACKED_DEEPSLATE_BRICKS_FLUTED_FACADE);
			BLOCKS.add(COBBLED_DEEPSLATE_FLUTED_FACADE);
			BLOCKS.add(POLISHED_DEEPSLATE_FLUTED_FACADE);
			BLOCKS.add(CHISELED_DEEPSLATE_FLUTED_FACADE);
			BLOCKS.add(DEEPSLATE_TILES_FLUTED_FACADE);
			BLOCKS.add(CRACKED_DEEPSLATE_TILES_FLUTED_FACADE);

			// sill
			BLOCKS.add(STONE_SILL);
			BLOCKS.add(SMOOTH_STONE_SILL);
			BLOCKS.add(COBBLESTONE_SILL);
			BLOCKS.add(MOSSY_COBBLESTONE_SILL);
			BLOCKS.add(BRICKS_SILL);
			BLOCKS.add(STONE_BRICKS_SILL);
			BLOCKS.add(MOSSY_STONE_BRICKS_SILL);
			BLOCKS.add(CRACKED_STONE_BRICKS_SILL);
			BLOCKS.add(CHISELED_STONE_BRICKS_SILL);
			BLOCKS.add(OBSIDIAN_SILL);
			BLOCKS.add(SANDSTONE_SILL);
			BLOCKS.add(SMOOTH_SANDSTONE_SILL);
			BLOCKS.add(CHISELED_SANDSTONE_SILL);
			BLOCKS.add(CUT_SANDSTONE_SILL);
			BLOCKS.add(RED_SANDSTONE_SILL);
			BLOCKS.add(SMOOTH_RED_SANDSTONE_SILL);
			BLOCKS.add(CHISELED_RED_SANDSTONE_SILL);
			BLOCKS.add(CUT_RED_SANDSTONE_SILL);
			BLOCKS.add(GRANITE_SILL);
			BLOCKS.add(POLISHED_GRANITE_SILL);
			BLOCKS.add(DIORITE_SILL);
			BLOCKS.add(POLISHED_DIORITE_SILL);
			BLOCKS.add(ANDESITE_SILL);
			BLOCKS.add(POLISHED_ANDESITE_SILL);
			BLOCKS.add(BLACKSTONE_SILL);
			BLOCKS.add(POLISHED_BLACKSTONE_SILL);
			BLOCKS.add(CHISELED_POLISHED_BLACKSTONE_SILL);
			BLOCKS.add(GILDED_BLACKSTONE_SILL);
			BLOCKS.add(POLISHED_BLACKSTONE_BRICKS_SILL);
			BLOCKS.add(CRACKED_POLISHED_BLACKSTONE_BRICKS_SILL);
			BLOCKS.add(DEEPSLATE_SILL);
			BLOCKS.add(DEEPSLATE_BRICKS_SILL);
			BLOCKS.add(CRACKED_DEEPSLATE_BRICKS_SILL);
			BLOCKS.add(COBBLED_DEEPSLATE_SILL);
			BLOCKS.add(POLISHED_DEEPSLATE_SILL);
			BLOCKS.add(CHISELED_DEEPSLATE_SILL);
			BLOCKS.add(DEEPSLATE_TILES_SILL);
			BLOCKS.add(CRACKED_DEEPSLATE_TILES_SILL);

			// double sill
			BLOCKS.add(STONE_DOUBLE_SILL);
			BLOCKS.add(SMOOTH_STONE_DOUBLE_SILL);
			BLOCKS.add(COBBLESTONE_DOUBLE_SILL);
			BLOCKS.add(MOSSY_COBBLESTONE_DOUBLE_SILL);
			BLOCKS.add(BRICKS_DOUBLE_SILL);
			BLOCKS.add(STONE_BRICKS_DOUBLE_SILL);
			BLOCKS.add(MOSSY_STONE_BRICKS_DOUBLE_SILL);
			BLOCKS.add(CRACKED_STONE_BRICKS_DOUBLE_SILL);
			BLOCKS.add(CHISELED_STONE_BRICKS_DOUBLE_SILL);
			BLOCKS.add(OBSIDIAN_DOUBLE_SILL);
			BLOCKS.add(SANDSTONE_DOUBLE_SILL);
			BLOCKS.add(SMOOTH_SANDSTONE_DOUBLE_SILL);
			BLOCKS.add(CHISELED_SANDSTONE_DOUBLE_SILL);
			BLOCKS.add(CUT_SANDSTONE_DOUBLE_SILL);
			BLOCKS.add(RED_SANDSTONE_DOUBLE_SILL);
			BLOCKS.add(SMOOTH_RED_SANDSTONE_DOUBLE_SILL);
			BLOCKS.add(CHISELED_RED_SANDSTONE_DOUBLE_SILL);
			BLOCKS.add(CUT_RED_SANDSTONE_DOUBLE_SILL);
			BLOCKS.add(GRANITE_DOUBLE_SILL);
			BLOCKS.add(POLISHED_GRANITE_DOUBLE_SILL);
			BLOCKS.add(DIORITE_DOUBLE_SILL);
			BLOCKS.add(POLISHED_DIORITE_DOUBLE_SILL);
			BLOCKS.add(ANDESITE_DOUBLE_SILL);
			BLOCKS.add(POLISHED_ANDESITE_DOUBLE_SILL);
			BLOCKS.add(BLACKSTONE_DOUBLE_SILL);
			BLOCKS.add(POLISHED_BLACKSTONE_DOUBLE_SILL);
			BLOCKS.add(CHISELED_POLISHED_BLACKSTONE_DOUBLE_SILL);
			BLOCKS.add(GILDED_BLACKSTONE_DOUBLE_SILL);
			BLOCKS.add(POLISHED_BLACKSTONE_BRICKS_DOUBLE_SILL);
			BLOCKS.add(CRACKED_POLISHED_BLACKSTONE_BRICKS_DOUBLE_SILL);
			BLOCKS.add(DEEPSLATE_DOUBLE_SILL);
			BLOCKS.add(DEEPSLATE_BRICKS_DOUBLE_SILL);
			BLOCKS.add(CRACKED_DEEPSLATE_BRICKS_DOUBLE_SILL);
			BLOCKS.add(COBBLED_DEEPSLATE_DOUBLE_SILL);
			BLOCKS.add(POLISHED_DEEPSLATE_DOUBLE_SILL);
			BLOCKS.add(CHISELED_DEEPSLATE_DOUBLE_SILL);
			BLOCKS.add(DEEPSLATE_TILES_DOUBLE_SILL);
			BLOCKS.add(CRACKED_DEEPSLATE_TILES_DOUBLE_SILL);

			// cornice
			BLOCKS.add(STONE_CORNICE);
			BLOCKS.add(SMOOTH_STONE_CORNICE);
			BLOCKS.add(COBBLESTONE_CORNICE);
			BLOCKS.add(MOSSY_COBBLESTONE_CORNICE);
			BLOCKS.add(BRICKS_CORNICE);
			BLOCKS.add(STONE_BRICKS_CORNICE);
			BLOCKS.add(MOSSY_STONE_BRICKS_CORNICE);
			BLOCKS.add(CRACKED_STONE_BRICKS_CORNICE);
			BLOCKS.add(CHISELED_STONE_BRICKS_CORNICE);
			BLOCKS.add(OBSIDIAN_CORNICE);
			BLOCKS.add(SANDSTONE_CORNICE);
			BLOCKS.add(SMOOTH_SANDSTONE_CORNICE);
			BLOCKS.add(CHISELED_SANDSTONE_CORNICE);
			BLOCKS.add(CUT_SANDSTONE_CORNICE);
			BLOCKS.add(RED_SANDSTONE_CORNICE);
			BLOCKS.add(SMOOTH_RED_SANDSTONE_CORNICE);
			BLOCKS.add(CHISELED_RED_SANDSTONE_CORNICE);
			BLOCKS.add(CUT_RED_SANDSTONE_CORNICE);
			BLOCKS.add(GRANITE_CORNICE);
			BLOCKS.add(POLISHED_GRANITE_CORNICE);
			BLOCKS.add(DIORITE_CORNICE);
			BLOCKS.add(POLISHED_DIORITE_CORNICE);
			BLOCKS.add(ANDESITE_CORNICE);
			BLOCKS.add(POLISHED_ANDESITE_CORNICE);
			BLOCKS.add(BLACKSTONE_CORNICE);
			BLOCKS.add(POLISHED_BLACKSTONE_CORNICE);
			BLOCKS.add(CHISELED_POLISHED_BLACKSTONE_CORNICE);
			BLOCKS.add(GILDED_BLACKSTONE_CORNICE);
			BLOCKS.add(POLISHED_BLACKSTONE_BRICKS_CORNICE);
			BLOCKS.add(CRACKED_POLISHED_BLACKSTONE_BRICKS_CORNICE);
			BLOCKS.add(DEEPSLATE_CORNICE);
			BLOCKS.add(DEEPSLATE_BRICKS_CORNICE);
			BLOCKS.add(CRACKED_DEEPSLATE_BRICKS_CORNICE);
			BLOCKS.add(COBBLED_DEEPSLATE_CORNICE);
			BLOCKS.add(POLISHED_DEEPSLATE_CORNICE);
			BLOCKS.add(CHISELED_DEEPSLATE_CORNICE);
			BLOCKS.add(DEEPSLATE_TILES_CORNICE);
			BLOCKS.add(CRACKED_DEEPSLATE_TILES_CORNICE);

			// crown molding
			BLOCKS.add(STONE_CROWN_MOLDING);
			BLOCKS.add(SMOOTH_STONE_CROWN_MOLDING);
			BLOCKS.add(COBBLESTONE_CROWN_MOLDING);
			BLOCKS.add(MOSSY_COBBLESTONE_CROWN_MOLDING);
			BLOCKS.add(BRICKS_CROWN_MOLDING);
			BLOCKS.add(STONE_BRICKS_CROWN_MOLDING);
			BLOCKS.add(MOSSY_STONE_BRICKS_CROWN_MOLDING);
			BLOCKS.add(CRACKED_STONE_BRICKS_CROWN_MOLDING);
			BLOCKS.add(CHISELED_STONE_BRICKS_CROWN_MOLDING);
			BLOCKS.add(OBSIDIAN_CROWN_MOLDING);
			BLOCKS.add(SANDSTONE_CROWN_MOLDING);
			BLOCKS.add(SMOOTH_SANDSTONE_CROWN_MOLDING);
			BLOCKS.add(CHISELED_SANDSTONE_CROWN_MOLDING);
			BLOCKS.add(CUT_SANDSTONE_CROWN_MOLDING);
			BLOCKS.add(RED_SANDSTONE_CROWN_MOLDING);
			BLOCKS.add(SMOOTH_RED_SANDSTONE_CROWN_MOLDING);
			BLOCKS.add(CHISELED_RED_SANDSTONE_CROWN_MOLDING);
			BLOCKS.add(CUT_RED_SANDSTONE_CROWN_MOLDING);
			BLOCKS.add(GRANITE_CROWN_MOLDING);
			BLOCKS.add(POLISHED_GRANITE_CROWN_MOLDING);
			BLOCKS.add(DIORITE_CROWN_MOLDING);
			BLOCKS.add(POLISHED_DIORITE_CROWN_MOLDING);
			BLOCKS.add(ANDESITE_CROWN_MOLDING);
			BLOCKS.add(POLISHED_ANDESITE_CROWN_MOLDING);
			BLOCKS.add(BLACKSTONE_CROWN_MOLDING);
			BLOCKS.add(POLISHED_BLACKSTONE_CROWN_MOLDING);
			BLOCKS.add(CHISELED_POLISHED_BLACKSTONE_CROWN_MOLDING);
			BLOCKS.add(GILDED_BLACKSTONE_CROWN_MOLDING);
			BLOCKS.add(POLISHED_BLACKSTONE_BRICKS_CROWN_MOLDING);
			BLOCKS.add(CRACKED_POLISHED_BLACKSTONE_BRICKS_CROWN_MOLDING);
			BLOCKS.add(DEEPSLATE_CROWN_MOLDING);
			BLOCKS.add(DEEPSLATE_BRICKS_CROWN_MOLDING);
			BLOCKS.add(CRACKED_DEEPSLATE_BRICKS_CROWN_MOLDING);
			BLOCKS.add(COBBLED_DEEPSLATE_CROWN_MOLDING);
			BLOCKS.add(POLISHED_DEEPSLATE_CROWN_MOLDING);
			BLOCKS.add(CHISELED_DEEPSLATE_CROWN_MOLDING);
			BLOCKS.add(DEEPSLATE_TILES_CROWN_MOLDING);
			BLOCKS.add(CRACKED_DEEPSLATE_TILES_CROWN_MOLDING);

			// pillar base
			BLOCKS.add(STONE_PILLAR_BASE);
			BLOCKS.add(SMOOTH_STONE_PILLAR_BASE);
			BLOCKS.add(COBBLESTONE_PILLAR_BASE);
			BLOCKS.add(MOSSY_COBBLESTONE_PILLAR_BASE);
			BLOCKS.add(BRICKS_PILLAR_BASE);
			BLOCKS.add(STONE_BRICKS_PILLAR_BASE);
			BLOCKS.add(MOSSY_STONE_BRICKS_PILLAR_BASE);
			BLOCKS.add(CRACKED_STONE_BRICKS_PILLAR_BASE);
			BLOCKS.add(CHISELED_STONE_BRICKS_PILLAR_BASE);
			BLOCKS.add(OBSIDIAN_PILLAR_BASE);
			BLOCKS.add(SANDSTONE_PILLAR_BASE);
			BLOCKS.add(SMOOTH_SANDSTONE_PILLAR_BASE);
			BLOCKS.add(CHISELED_SANDSTONE_PILLAR_BASE);
			BLOCKS.add(CUT_SANDSTONE_PILLAR_BASE);
			BLOCKS.add(RED_SANDSTONE_PILLAR_BASE);
			BLOCKS.add(SMOOTH_RED_SANDSTONE_PILLAR_BASE);
			BLOCKS.add(CHISELED_RED_SANDSTONE_PILLAR_BASE);
			BLOCKS.add(CUT_RED_SANDSTONE_PILLAR_BASE);
			BLOCKS.add(GRANITE_PILLAR_BASE);
			BLOCKS.add(POLISHED_GRANITE_PILLAR_BASE);
			BLOCKS.add(DIORITE_PILLAR_BASE);
			BLOCKS.add(POLISHED_DIORITE_PILLAR_BASE);
			BLOCKS.add(ANDESITE_PILLAR_BASE);
			BLOCKS.add(POLISHED_ANDESITE_PILLAR_BASE);
			BLOCKS.add(BLACKSTONE_PILLAR_BASE);
			BLOCKS.add(POLISHED_BLACKSTONE_PILLAR_BASE);
			BLOCKS.add(CHISELED_POLISHED_BLACKSTONE_PILLAR_BASE);
			BLOCKS.add(GILDED_BLACKSTONE_PILLAR_BASE);
			BLOCKS.add(POLISHED_BLACKSTONE_BRICKS_PILLAR_BASE);
			BLOCKS.add(CRACKED_POLISHED_BLACKSTONE_BRICKS_PILLAR_BASE);
			BLOCKS.add(DEEPSLATE_PILLAR_BASE);
			BLOCKS.add(DEEPSLATE_BRICKS_PILLAR_BASE);
			BLOCKS.add(CRACKED_DEEPSLATE_BRICKS_PILLAR_BASE);
			BLOCKS.add(COBBLED_DEEPSLATE_PILLAR_BASE);
			BLOCKS.add(POLISHED_DEEPSLATE_PILLAR_BASE);
			BLOCKS.add(CHISELED_DEEPSLATE_PILLAR_BASE);
			BLOCKS.add(DEEPSLATE_TILES_PILLAR_BASE);
			BLOCKS.add(CRACKED_DEEPSLATE_TILES_PILLAR_BASE);

			// pillar
			BLOCKS.add(STONE_PILLAR);
			BLOCKS.add(SMOOTH_STONE_PILLAR);
			BLOCKS.add(COBBLESTONE_PILLAR);
			BLOCKS.add(MOSSY_COBBLESTONE_PILLAR);
			BLOCKS.add(BRICKS_PILLAR);
			BLOCKS.add(STONE_BRICKS_PILLAR);
			BLOCKS.add(MOSSY_STONE_BRICKS_PILLAR);
			BLOCKS.add(CRACKED_STONE_BRICKS_PILLAR);
			BLOCKS.add(CHISELED_STONE_BRICKS_PILLAR);
			BLOCKS.add(OBSIDIAN_PILLAR);
			BLOCKS.add(SANDSTONE_PILLAR);
			BLOCKS.add(SMOOTH_SANDSTONE_PILLAR);
			BLOCKS.add(CHISELED_SANDSTONE_PILLAR);
			BLOCKS.add(CUT_SANDSTONE_PILLAR);
			BLOCKS.add(RED_SANDSTONE_PILLAR);
			BLOCKS.add(SMOOTH_RED_SANDSTONE_PILLAR);
			BLOCKS.add(CHISELED_RED_SANDSTONE_PILLAR);
			BLOCKS.add(CUT_RED_SANDSTONE_PILLAR);
			BLOCKS.add(GRANITE_PILLAR);
			BLOCKS.add(POLISHED_GRANITE_PILLAR);
			BLOCKS.add(DIORITE_PILLAR);
			BLOCKS.add(POLISHED_DIORITE_PILLAR);
			BLOCKS.add(ANDESITE_PILLAR);
			BLOCKS.add(POLISHED_ANDESITE_PILLAR);
			BLOCKS.add(BLACKSTONE_PILLAR);
			BLOCKS.add(POLISHED_BLACKSTONE_PILLAR);
			BLOCKS.add(CHISELED_POLISHED_BLACKSTONE_PILLAR);
			BLOCKS.add(GILDED_BLACKSTONE_PILLAR);
			BLOCKS.add(POLISHED_BLACKSTONE_BRICKS_PILLAR);
			BLOCKS.add(CRACKED_POLISHED_BLACKSTONE_BRICKS_PILLAR);
			BLOCKS.add(DEEPSLATE_PILLAR);
			BLOCKS.add(DEEPSLATE_BRICKS_PILLAR);
			BLOCKS.add(CRACKED_DEEPSLATE_BRICKS_PILLAR);
			BLOCKS.add(COBBLED_DEEPSLATE_PILLAR);
			BLOCKS.add(POLISHED_DEEPSLATE_PILLAR);
			BLOCKS.add(CHISELED_DEEPSLATE_PILLAR);
			BLOCKS.add(DEEPSLATE_TILES_PILLAR);
			BLOCKS.add(CRACKED_DEEPSLATE_TILES_PILLAR);

			// wall sconce
			BLOCKS.add(STONE_WALL_SCONCE);
			BLOCKS.add(SMOOTH_STONE_WALL_SCONCE);
			BLOCKS.add(COBBLESTONE_WALL_SCONCE);
			BLOCKS.add(MOSSY_COBBLESTONE_WALL_SCONCE);
			BLOCKS.add(BRICKS_WALL_SCONCE);
			BLOCKS.add(STONE_BRICKS_WALL_SCONCE);
			BLOCKS.add(MOSSY_STONE_BRICKS_WALL_SCONCE);
			BLOCKS.add(CRACKED_STONE_BRICKS_WALL_SCONCE);
			BLOCKS.add(CHISELED_STONE_BRICKS_WALL_SCONCE);
			BLOCKS.add(OBSIDIAN_WALL_SCONCE);
			BLOCKS.add(SANDSTONE_WALL_SCONCE);
			BLOCKS.add(SMOOTH_SANDSTONE_WALL_SCONCE);
			BLOCKS.add(CHISELED_SANDSTONE_WALL_SCONCE);
			BLOCKS.add(CUT_SANDSTONE_WALL_SCONCE);
			BLOCKS.add(RED_SANDSTONE_WALL_SCONCE);
			BLOCKS.add(SMOOTH_RED_SANDSTONE_WALL_SCONCE);
			BLOCKS.add(CHISELED_RED_SANDSTONE_WALL_SCONCE);
			BLOCKS.add(CUT_RED_SANDSTONE_WALL_SCONCE);
			BLOCKS.add(GRANITE_WALL_SCONCE);
			BLOCKS.add(POLISHED_GRANITE_WALL_SCONCE);
			BLOCKS.add(DIORITE_WALL_SCONCE);
			BLOCKS.add(POLISHED_DIORITE_WALL_SCONCE);
			BLOCKS.add(ANDESITE_WALL_SCONCE);
			BLOCKS.add(POLISHED_ANDESITE_WALL_SCONCE);
			BLOCKS.add(BLACKSTONE_WALL_SCONCE);
			BLOCKS.add(POLISHED_BLACKSTONE_WALL_SCONCE);
			BLOCKS.add(CHISELED_POLISHED_BLACKSTONE_WALL_SCONCE);
			BLOCKS.add(GILDED_BLACKSTONE_WALL_SCONCE);
			BLOCKS.add(POLISHED_BLACKSTONE_BRICKS_WALL_SCONCE);
			BLOCKS.add(CRACKED_POLISHED_BLACKSTONE_BRICKS_WALL_SCONCE);
			BLOCKS.add(DEEPSLATE_WALL_SCONCE);
			BLOCKS.add(DEEPSLATE_BRICKS_WALL_SCONCE);
			BLOCKS.add(CRACKED_DEEPSLATE_BRICKS_WALL_SCONCE);
			BLOCKS.add(COBBLED_DEEPSLATE_WALL_SCONCE);
			BLOCKS.add(POLISHED_DEEPSLATE_WALL_SCONCE);
			BLOCKS.add(CHISELED_DEEPSLATE_WALL_SCONCE);
			BLOCKS.add(DEEPSLATE_TILES_WALL_SCONCE);
			BLOCKS.add(CRACKED_DEEPSLATE_TILES_WALL_SCONCE);

			// grate
			BLOCKS.add(GRATE);
			
			 IForgeRegistry<Block> registry = event.getRegistry();
			for (Block b : BLOCKS) {
				registry.register(b);
			}
		}

		/**
		 * Register this mod's {@link ItemBlock}s.
		 *
		 * @param event The event
		 */
		@SubscribeEvent
		public static void registerItemBlocks( RegistryEvent.Register<Item> event) {
			 IForgeRegistry<Item> registry = event.getRegistry();
			for (Block b : BLOCKS) {
				BlockItem itemBlock = new BlockItem(b, new Item.Properties().tab(ModItemGroups.MOD_ITEM_GROUP));
				 ResourceLocation registryName = Preconditions.checkNotNull(b.getRegistryName(),
						"Block %s has null registry name", b);
				registry.register(itemBlock.setRegistryName(registryName));
				ITEM_BLOCKS.add(itemBlock);
			}
		}
	}
}

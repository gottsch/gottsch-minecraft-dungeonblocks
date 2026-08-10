/*
 * This file is part of  Treasure2.
 * Copyright (c) 2022 Mark Gottschling (gottsch)
 *
 * Treasure2 is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Treasure2 is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Treasure2.  If not, see <http://www.gnu.org/licenses/lgpl>.
 */
package mod.gottsch.forge.dungeonblocks.datagen;

import mod.gottsch.forge.dungeonblocks.DungeonBlocks;
import mod.gottsch.forge.dungeonblocks.core.block.ModBlocks;
import mod.gottsch.forge.dungeonblocks.core.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import org.apache.commons.lang3.text.WordUtils;

/**
 * 
 * @author Mark Gottschling on Oct 26, 2023
 *
 */
public class LanguageGen extends LanguageProvider {

    public LanguageGen(PackOutput output, String locale) {
        super(output, DungeonBlocks.MOD_ID, locale);
    }
    
    @Override
    protected void addTranslations() {
    	// tabs
        add("itemGroup." + DungeonBlocks.MOD_ID, "DungeonBlocks");
        add("itemGroup." + DungeonBlocks.MOD_ID + ".entities", "DungeonBlocks Entities");

        ModBlocks.MAP.forEach((k, v) -> {
            // these are given custom display names below
            if (k == ModBlocks.ROOTS || k == ModBlocks.ROOTS_BODY) {
                return;
            }
            String s = k.getId().getPath().replace("_block", "").replace("_", " ").trim();
            s = WordUtils.capitalizeFully(s);
            add(k.get(), s);
        });

        // unmapped resources
        add(ModBlocks.MOLD.get(), "Mold");
        add(ModBlocks.LICHEN.get(), "Lichen");
        add(ModItems.SKELETON.get(), "Skeleton");

        add(ModBlocks.ROOTS.get(), "Roots");
        add(ModBlocks.ROOTS_BODY.get(), "Roots");

        // every clay pot shape shares one display name - the shapes are a visual variation of the
        // same prop, not three things a player needs to tell apart by name.
        add(ModItems.POT.get(), "Terracotta Pot");
        add(ModItems.SQUAT_CLAY_POT.get(), "Terracotta Pot");
        add(ModItems.THIN_CLAY_POT.get(), "Terracotta Pot");
        add("entity." + DungeonBlocks.MOD_ID + ".pot", "Terracotta Pot");
        add("entity." + DungeonBlocks.MOD_ID + ".squat_clay_pot", "Terracotta Pot");
        add("entity." + DungeonBlocks.MOD_ID + ".thin_clay_pot", "Terracotta Pot");
        add(ModItems.STONE_POT.get(), "Stone Pot");
        add(ModItems.SQUAT_STONE_POT.get(), "Stone Pot");
        add(ModItems.THIN_STONE_POT.get(), "Stone Pot");
        add("entity." + DungeonBlocks.MOD_ID + ".stone_pot", "Stone Pot");
        add("entity." + DungeonBlocks.MOD_ID + ".squat_stone_pot", "Stone Pot");
        add("entity." + DungeonBlocks.MOD_ID + ".thin_stone_pot", "Stone Pot");

        add(ModItems.RED_POT.get(), "Red Pot");
        add(ModItems.SQUAT_RED_POT.get(), "Red Pot");
        add(ModItems.THIN_RED_POT.get(), "Red Pot");
        add("entity." + DungeonBlocks.MOD_ID + ".red_pot", "Red Pot");
        add("entity." + DungeonBlocks.MOD_ID + ".squat_red_pot", "Red Pot");
        add("entity." + DungeonBlocks.MOD_ID + ".thin_red_pot", "Red Pot");

        add(ModItems.BLUE_POT.get(), "Blue Pot");
        add(ModItems.SQUAT_BLUE_POT.get(), "Blue Pot");
        add(ModItems.THIN_BLUE_POT.get(), "Blue Pot");
        add("entity." + DungeonBlocks.MOD_ID + ".blue_pot", "Blue Pot");
        add("entity." + DungeonBlocks.MOD_ID + ".squat_blue_pot", "Blue Pot");
        add("entity." + DungeonBlocks.MOD_ID + ".thin_blue_pot", "Blue Pot");

        add("entity." + DungeonBlocks.MOD_ID + ".pot_shard", "Pot Shard");

    }
}

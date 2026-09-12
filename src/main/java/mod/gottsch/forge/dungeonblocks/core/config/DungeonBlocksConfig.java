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
package mod.gottsch.forge.dungeonblocks.core.config;

import mod.gottsch.forge.dungeonblocks.DungeonBlocks;
import mod.gottsch.forge.gottschcore.config.AbstractConfig;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

/**
 * 
 * @author Mark Gottschling on Jan 5, 2020
 *
 */
@EventBusSubscriber(modid = DungeonBlocks.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class DungeonBlocksConfig extends AbstractConfig {
	protected static final ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
	protected static final ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();

	public static ForgeConfigSpec COMMON_CONFIG;
	public static ForgeConfigSpec CLIENT_CONFIG;

	public static DungeonBlocksConfig instance = new DungeonBlocksConfig();

	/**
	 * Purely visual settings, so they live in the CLIENT spec: a player who wants still banners gets
	 * them without anything having to agree with the server about it.
	 */
	public static final class Visuals {
		public final ForgeConfigSpec.BooleanValue animateBanners;

		Visuals(ForgeConfigSpec.Builder builder) {
			builder.comment("Visual settings. These affect only your own client.").push("visuals");
			animateBanners = builder
					.comment("Master switch for Dungeon Banner cloth movement. Each banner also has its own",
							"animated blockstate, toggled in-world with an empty hand; this setting can turn",
							"all of them off, but cannot animate a banner that was deliberately stilled.")
					.define("animateBanners", true);
			builder.pop();
		}
	}

	public static Visuals VISUALS;

	static {
		COMMON_CONFIG = COMMON_BUILDER.build();
		VISUALS = new Visuals(CLIENT_BUILDER);
		CLIENT_CONFIG = CLIENT_BUILDER.build();
	}

	/**
	 * 
	 * @param mod
	 */
	public DungeonBlocksConfig() {
	}
}

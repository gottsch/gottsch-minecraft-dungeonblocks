/*
 * This file is part of  DungeonBlocks.
 * Copyright (c) 2026 Mark Gottschling (gottsch)
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
package mod.gottsch.forge.dungeonblocks.core.state.properties;

import net.minecraft.util.StringRepresentable;

/**
 * What, if anything, hangs off the bottom of a swinging chain.
 *
 * <p>Every value here is rendered from an <em>existing</em> block model via
 * {@code BlockRenderDispatcher#renderSingleBlock}, so a fixture costs no new geometry and inherits
 * the player's resource pack. Adding one is an entry here plus a case in the renderer's state
 * mapping and in the block's item mapping — manacles will slot in that way once modelled.
 *
 * @author Mark Gottschling on Jul 26, 2026
 */
public enum ChainFixture implements StringRepresentable {

	NONE("none"),
	LANTERN("lantern"),
	SOUL_LANTERN("soul_lantern"),
	DUNGEON_LANTERN("dungeon_lantern");

	private final String name;

	ChainFixture(String name) {
		this.name = name;
	}

	@Override
	public String getSerializedName() {
		return this.name;
	}

	public boolean isPresent() {
		return this != NONE;
	}

	/**
	 * A fixture heavy enough to change how the chain swings. A mass concentrated at the free end
	 * makes a distributed-mass chain behave more like a simple pendulum — slightly longer period —
	 * and raises inertia relative to damping, so it keeps swinging noticeably longer.
	 */
	public boolean isWeighted() {
		return this != NONE;
	}

	/**
	 * True for fixtures that can be lit and extinguished. The mod's own dungeon lantern is placed
	 * unlit and lit with a torch or flint and steel ({@code DungeonLanternBlock#use}); the chain
	 * mirrors that rather than silently forcing it alight.
	 */
	public boolean isLightable() {
		return this == DUNGEON_LANTERN;
	}

	/** Block light emitted while attached. Matches each source's own vanilla/mod value. */
	public int lightLevel(boolean lit) {
		return switch (this) {
			case LANTERN -> 15;
			case SOUL_LANTERN -> 10;
			case DUNGEON_LANTERN -> lit ? 15 : 0;
			case NONE -> 0;
		};
	}
}

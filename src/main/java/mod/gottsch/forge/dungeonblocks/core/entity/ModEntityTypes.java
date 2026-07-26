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
package mod.gottsch.forge.dungeonblocks.core.entity;

import mod.gottsch.forge.dungeonblocks.core.setup.Registration;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;

/**
 * @author Mark Gottschling on Jul 25, 2026
 */
public class ModEntityTypes {

	// both pot shapes share PotEntity — only geometry, texture and hitbox differ, so they are
	// distinct EntityTypes (separate renderer + default loot table) over one behaviour class.
	public static final RegistryObject<EntityType<PotEntity>> POT = Registration.ENTITY_TYPES.register("pot",
			() -> EntityType.Builder.of(PotEntity::new, MobCategory.MISC)
					.sized(0.5F, 0.6F)
					.clientTrackingRange(10)
					.updateInterval(1)
					.build("pot"));

	public static final RegistryObject<EntityType<PotEntity>> SQUAT_CLAY_POT = Registration.ENTITY_TYPES.register("squat_clay_pot",
			() -> EntityType.Builder.of(PotEntity::new, MobCategory.MISC)
					// 10px wide x 10px tall modeled -> 0.625 blocks square
					.sized(0.625F, 0.625F)
					.clientTrackingRange(10)
					.updateInterval(1)
					.build("squat_clay_pot"));

	public static final RegistryObject<EntityType<PotEntity>> THIN_CLAY_POT = Registration.ENTITY_TYPES.register("thin_clay_pot",
			() -> EntityType.Builder.of(PotEntity::new, MobCategory.MISC)
					// 6px wide x 12px tall modeled
					.sized(0.375F, 0.75F)
					.clientTrackingRange(10)
					.updateInterval(1)
					.build("thin_clay_pot"));

	public static final RegistryObject<EntityType<PotShardEntity>> POT_SHARD = Registration.ENTITY_TYPES.register("pot_shard",
			() -> EntityType.Builder.<PotShardEntity>of(PotShardEntity::new, MobCategory.MISC)
					.sized(0.25F, 0.25F)
					.clientTrackingRange(6)
					.updateInterval(1)
					.build("pot_shard"));

	public static void register(IEventBus bus) {
		Registration.registerEntityTypes(bus);
	}
}

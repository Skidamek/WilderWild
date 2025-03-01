/*
 * Copyright 2022-2023 FrozenBlock
 * This file is part of Wilder Wild.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, see <https://www.gnu.org/licenses/>.
 */

package net.frozenblock.wilderwild.tag;

import net.frozenblock.wilderwild.misc.WilderSharedConstants;
import net.minecraft.core.Registry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public final class WilderEntityTags {
	private WilderEntityTags() {
		throw new UnsupportedOperationException("WilderEntityTags contains only static declarations.");
	}

    public static final TagKey<EntityType<?>> CAN_SWIM_IN_ALGAE = bind("can_swim_in_algae");
    public static final TagKey<EntityType<?>> STAYS_IN_MESOGLEA = bind("stays_in_mesoglea");
    public static final TagKey<EntityType<?>> ANCIENT_HORN_IMMUNE = bind("ancient_horn_immune");
    public static final TagKey<EntityType<?>> JELLYFISH_CANT_STING = bind("jellyfish_cant_sting");
	public static final TagKey<EntityType<?>> COCONUT_CANT_BONK = bind("coconut_cant_bonk");
	public static final TagKey<EntityType<?>> COCONUT_CANT_SPLIT = bind("coconut_cant_split");

    private static TagKey<EntityType<?>> bind(String path) {
        return TagKey.create(Registry.ENTITY_TYPE_REGISTRY, WilderSharedConstants.id(path));
    }
}

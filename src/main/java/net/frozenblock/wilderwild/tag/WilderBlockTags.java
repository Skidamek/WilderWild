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
import net.minecraft.world.level.block.Block;

public final class WilderBlockTags {
	private WilderBlockTags() {
		throw new UnsupportedOperationException("WilderBlockTags contains only static declarations.");
	}

    public static final TagKey<Block> ANCIENT_CITY_BLOCKS = bind("ancient_city_blocks");
    public static final TagKey<Block> SCULK_SLAB_REPLACEABLE_WORLDGEN = bind("sculk_slab_replaceable_worldgen");
    public static final TagKey<Block> SCULK_STAIR_REPLACEABLE_WORLDGEN = bind("sculk_stair_replaceable_worldgen");
    public static final TagKey<Block> SCULK_WALL_REPLACEABLE_WORLDGEN = bind("sculk_wall_replaceable_worldgen");
    public static final TagKey<Block> SCULK_SLAB_REPLACEABLE = bind("sculk_slab_replaceable");
    public static final TagKey<Block> SCULK_STAIR_REPLACEABLE = bind("sculk_stair_replaceable");
    public static final TagKey<Block> SCULK_WALL_REPLACEABLE = bind("sculk_wall_replaceable");
    public static final TagKey<Block> SCULK_VEIN_REMOVE = bind("sculk_vein_removed_on");
    public static final TagKey<Block> ANCIENT_HORN_NON_COLLIDE = bind("ancient_horn_vibration_non_collide");
    public static final TagKey<Block> KILLS_TERMITE = bind("kills_termite");
    public static final TagKey<Block> TERMITE_BREAKABLE = bind("termite_breakable");
    public static final TagKey<Block> BLOCKS_TERMITE = bind("blocks_termite");
    public static final TagKey<Block> FIREFLY_HIDEABLE_BLOCKS = bind("firefly_hideable_blocks");
    public static final TagKey<Block> PACKED_MUD_REPLACEABLE = bind("packed_mud_replaceable");
	public static final TagKey<Block> STRIPPED_HOLLOWED_LOGS = bind("stripped_hollowed_logs");
	public static final TagKey<Block> BUSH_MAY_PLACE_ON = bind("bush_may_place_on");
	public static final TagKey<Block> SAND_POOL_REPLACEABLE = bind("sand_pool_replaceable");
	public static final TagKey<Block> SMALL_SPONGE_GROWS_ON = bind("small_sponge_grows_on");
	public static final TagKey<Block> BASIN_REPLACEABLE = bind("basin_replaceable");
	public static final TagKey<Block> SPLITS_COCONUT = bind("splits_coconut");
	public static final TagKey<Block> STOPS_TUMBLEWEED = bind("stops_tumbleweed");
	public static final TagKey<Block> STONE_TRANSITION_REPLACEABLE = bind("red_sand_transition_replaceable");
	public static final TagKey<Block> STONE_TRANSITION_PLACEABLE = bind("stone_transition_placeable");
	public static final TagKey<Block> SMALL_SAND_TRANSITION_REPLACEABLE = bind("small_sand_transition_replaceable");
	public static final TagKey<Block> GRAVEL_TRANSITION_REPLACEABLE = bind("gravel_transition_replaceable");
	public static final TagKey<Block> GRAVEL_TRANSITION_PLACEABLE = bind("gravel_transition_placeable");
	public static final TagKey<Block> SAND_TRANSITION_REPLACEABLE = bind("sand_transition_replaceable");
	public static final TagKey<Block> SAND_TRANSITION_PLACEABLE = bind("sand_transition_placeable");
	public static final TagKey<Block> RED_SAND_TRANSITION_REPLACEABLE = bind("red_sand_transition_replaceable");
	public static final TagKey<Block> RED_SAND_TRANSITION_PLACEABLE = bind("red_sand_transition_placeable");
	public static final TagKey<Block> MUD_TRANSITION_REPLACEABLE = bind("mud_transition_replaceable");
	public static final TagKey<Block> MUD_TRANSITION_PLACEABLE = bind("mud_transition_placeable");
	public static final TagKey<Block> MUD_PATH_REPLACEABLE = bind("mud_path_replaceable");
	public static final TagKey<Block> COARSE_PATH_REPLACEABLE = bind("coarse_path_replaceable");
	public static final TagKey<Block> UNDER_WATER_SAND_PATH_REPLACEABLE = bind("under_water_sand_path_replaceable");
	public static final TagKey<Block> UNDER_WATER_GRAVEL_PATH_REPLACEABLE = bind("under_water_gravel_path_replaceable");
	public static final TagKey<Block> UNDER_WATER_CLAY_PATH_REPLACEABLE = bind("under_water_clay_path_replaceable");
	public static final TagKey<Block> BEACH_CLAY_PATH_REPLACEABLE = bind("beach_clay_path_replaceable");
	public static final TagKey<Block> RIVER_GRAVEL_PATH_REPLACEABLE = bind("river_gravel_path_replaceable");
	public static final TagKey<Block> PACKED_MUD_PATH_REPLACEABLE = bind("packed_mud_path_replaceable");
	public static final TagKey<Block> MOSS_PATH_REPLACEABLE = bind("moss_path_replaceable");
	public static final TagKey<Block> SANDSTONE_PATH_REPLACEABLE = bind("sandstone_path_replaceable");
	public static final TagKey<Block> SMALL_COARSE_DIRT_PATH_REPLACEABLE = bind("small_coarse_dirt_path_replaceable");
	public static final TagKey<Block> PACKED_MUD_PATH_BADLANDS_REPLACEABLE = bind("packed_mud_path_badlands_replaceable");

	private static TagKey<Block> bind(String path) {
		return TagKey.create(Registry.BLOCK_REGISTRY, WilderSharedConstants.id(path));
	}
}

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

package net.frozenblock.wilderwild.world.additions.feature;

import java.util.List;
import net.frozenblock.lib.worldgen.feature.api.FrozenPlacedFeature;
import net.frozenblock.lib.worldgen.feature.api.placementmodifier.LowerHeightmapPlacement;
import net.frozenblock.wilderwild.misc.WilderSharedConstants;
import net.frozenblock.wilderwild.tag.WilderBlockTags;
import static net.frozenblock.wilderwild.world.additions.feature.WilderPlacementUtils.register;
import net.minecraft.core.Direction;
import net.minecraft.data.worldgen.features.CaveFeatures;
import net.minecraft.data.worldgen.features.MiscOverworldFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.EnvironmentScanPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RandomOffsetPlacement;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraft.world.level.levelgen.placement.SurfaceRelativeThresholdFilter;

public final class WilderMiscPlaced {
	private WilderMiscPlaced() {
		throw new UnsupportedOperationException("WilderMiscPlaced contains only static declarations.");
	}
	// SWAMP
	public static final FrozenPlacedFeature DISK_MUD = register("disk_mud");

	public static final FrozenPlacedFeature MUD_PATH = register("mud_path");

	public static final FrozenPlacedFeature MUD_TRANSITION = register("mud_transition");

	// TAIGA
	public static final FrozenPlacedFeature COARSE_PATH = register("coarse_dirt_path");

	public static final FrozenPlacedFeature COARSE_PATH_5 = register("coarse_dirt_path_5");

	public static final FrozenPlacedFeature FOREST_ROCK_TAIGA = register("forest_rock_taiga");

	// CYPRESS WETLANDS
	public static final FrozenPlacedFeature UNDER_WATER_SAND_PATH = register("under_water_sand_path");

	public static final FrozenPlacedFeature UNDER_WATER_GRAVEL_PATH = register("under_water_gravel_path");

	public static final FrozenPlacedFeature UNDER_WATER_CLAY_PATH = register("under_water_clay_path");

	// BEACH AND RIVER
	public static final FrozenPlacedFeature UNDER_WATER_CLAY_PATH_BEACH = register("under_water_clay_path_beach");

	public static final FrozenPlacedFeature UNDER_WATER_GRAVEL_PATH_RIVER = register("under_water_gravel_path_river");

	public static final FrozenPlacedFeature STONE_TRANSITION = register("stone_transition");

	public static final FrozenPlacedFeature SMALL_SAND_TRANSITION = register("small_sand_transition");

	public static final FrozenPlacedFeature BETA_BEACH_SAND_TRANSITION = register("beta_beach_sand_transition");

	public static final FrozenPlacedFeature SMALL_GRAVEL_TRANSITION = register("small_gravel_transition");

	// SAVANNA
	public static final FrozenPlacedFeature PACKED_MUD_PATH = register("packed_mud_path");

	// JUNGLE
	public static final FrozenPlacedFeature MOSS_PATH = register("moss_path");

	// DESERT
	public static final FrozenPlacedFeature ORE_PACKED_MUD = register("ore_packed_mud");

	public static final FrozenPlacedFeature SANDSTONE_PATH = register("sandstone_path");

	public static final FrozenPlacedFeature SCORCHED_SAND = register("scorched_sand");

	public static final FrozenPlacedFeature SCORCHED_SAND_HUGE = register("scorched_sand_huge");

	public static final FrozenPlacedFeature SAND_TRANSITION = register("sand_transition");

	// BADLANDS
	public static final FrozenPlacedFeature COARSE_DIRT_PATH_SMALL = register("coarse_dirt_path_small");

	public static final FrozenPlacedFeature PACKED_MUD_PATH_BADLANDS = register("packed_mud_path_badlands");

	public static final FrozenPlacedFeature SCORCHED_RED_SAND = register("scorched_red_sand");

	public static final FrozenPlacedFeature SCORCHED_RED_SAND_HUGE = register("scorched_red_sand_huge");

	public static final FrozenPlacedFeature RED_SAND_TRANSITION = register("red_sand_transition");

	// JELLYFISH CAVES
	public static final FrozenPlacedFeature EXTRA_GLOW_LICHEN = register("extra_glow_lichen");

	public static final FrozenPlacedFeature STONE_POOL = register("stone_pool");

	public static final FrozenPlacedFeature DEEPSLATE_POOL = register("deepslate_pool");

	public static final FrozenPlacedFeature ORE_CALCITE = register("ore_calcite");

	public static final BlockPredicate ONLY_IN_WATER_PREDICATE = BlockPredicate.matchesBlocks(Blocks.WATER);

	public static final FrozenPlacedFeature JELLYFISH_DEEPSLATE_POOL = register("jellyfish_deepslate_pool");

	public static final FrozenPlacedFeature JELLYFISH_STONE_POOL = register("jellyfish_stone_pool");

	public static final FrozenPlacedFeature MESOGLEA_PILLAR = register("blue_mesoglea_pillar");

	public static final FrozenPlacedFeature PURPLE_MESOGLEA_PILLAR = register("purple_mesoglea_pillar");

	public static final FrozenPlacedFeature BLUE_MESOGLEA_PATH = register("blue_mesoglea_path");

	public static final FrozenPlacedFeature PURPLE_MESOGLEA_PATH = register("purple_mesoglea_path");

	// OASIS
	public static final FrozenPlacedFeature SAND_POOL = register("sand_pool");

	public static final FrozenPlacedFeature MESSY_SAND_POOL = register("messy_sand_pool");

	public static final FrozenPlacedFeature GRASS_PATH = register("grass_path");

	public static final FrozenPlacedFeature MOSS_PATH_OASIS = register("moss_path_oasis");

	public static final FrozenPlacedFeature DESERT_WELL = register("desert_well");

	// BIRCH TAIGA
	public static final FrozenPlacedFeature COARSE_PATH_10 = register("coarse_dirt_path_10");

	// ARID SAVANNA
	public static final FrozenPlacedFeature GRASS_PATH_RARE = register("grass_path_rare");

	public static final FrozenPlacedFeature ARID_COARSE_PATH = register("arid_coarse_dirt_path");

	// OLD GROWTH SNOWY TAIGA
	public static final FrozenPlacedFeature PILE_SNOW = register("pile_snow");

	// TEMPERATE RAINFOREST & RAINFOREST
	public static final FrozenPlacedFeature MOSS_PILE = register("moss_pile");

	public static final FrozenPlacedFeature BASIN_PODZOL = register("basin_podzol");

	public static final FrozenPlacedFeature BASIN_MOSS = register("basin_moss");

	public static final FrozenPlacedFeature MOSS_LAKE = register("moss_lake");

	public static final FrozenPlacedFeature MOSS_LAKE_RARE = register("moss_lake_rare");

	//SNOW
	public static final FrozenPlacedFeature SNOW_BLANKET = register("snow_blanket");

	public static final FrozenPlacedFeature SNOW_AND_ICE_TRANSITION = register("snow_and_freeze_transition");

	static {
		registerMiscPlaced();
	}

	public static void init() {
	}

	public static void registerMiscPlaced() {

		WilderSharedConstants.logWild("Registering WilderMiscPlaced for", true);

		// SWAMP

		DISK_MUD.makeAndSetHolder(WilderMiscConfigured.DISK_MUD.getHolder(),
				CountPlacement.of(1),
				InSquarePlacement.spread(),
				PlacementUtils.HEIGHTMAP_TOP_SOLID,
				RandomOffsetPlacement.vertical(ConstantInt.of(-1)),
				BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlocks(Blocks.GRASS_BLOCK, Blocks.DIRT)),
				BiomeFilter.biome()
		);

		MUD_PATH.makeAndSetHolder(WilderMiscConfigured.MUD_PATH.getHolder(),
				RarityFilter.onAverageOnceEvery(3),
				InSquarePlacement.spread(),
				PlacementUtils.HEIGHTMAP_TOP_SOLID,
				BiomeFilter.biome()
		);

		MUD_TRANSITION.makeAndSetHolder(WilderMiscConfigured.MUD_TRANSITION_DISK.getHolder(),
				CountPlacement.of(8),
				InSquarePlacement.spread(),
				LowerHeightmapPlacement.HEIGHTMAP_TOP_SOLID,
				BlockPredicateFilter.forPredicate(BlockPredicate.matchesTag(WilderBlockTags.MUD_TRANSITION_PLACEABLE)),
				BiomeFilter.biome()
		);

		// TAIGA

		COARSE_PATH.makeAndSetHolder( WilderMiscConfigured.COARSE_PATH.getHolder(),
				RarityFilter.onAverageOnceEvery(3),
				InSquarePlacement.spread(),
				PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
				BiomeFilter.biome()
		);

		COARSE_PATH_5.makeAndSetHolder(WilderMiscConfigured.COARSE_PATH.getHolder(),
				RarityFilter.onAverageOnceEvery(5),
				InSquarePlacement.spread(),
				PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
				BiomeFilter.biome()
		);

		FOREST_ROCK_TAIGA.makeAndSetHolder(MiscOverworldFeatures.FOREST_ROCK,
				RarityFilter.onAverageOnceEvery(7),
				InSquarePlacement.spread(),
				PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
				BiomeFilter.biome()
		);

		// CYPRESS WETLANDS

		UNDER_WATER_SAND_PATH.makeAndSetHolder(WilderMiscConfigured.UNDER_WATER_SAND_PATH.getHolder(),
				InSquarePlacement.spread(),
				PlacementUtils.HEIGHTMAP_TOP_SOLID,
				BiomeFilter.biome()
		);

		UNDER_WATER_GRAVEL_PATH.makeAndSetHolder(WilderMiscConfigured.UNDER_WATER_GRAVEL_PATH.getHolder(),
				InSquarePlacement.spread(),
				PlacementUtils.HEIGHTMAP_TOP_SOLID,
				BiomeFilter.biome()
		);

		UNDER_WATER_CLAY_PATH.makeAndSetHolder(WilderMiscConfigured.UNDER_WATER_CLAY_PATH.getHolder(),
				InSquarePlacement.spread(),
				PlacementUtils.HEIGHTMAP_TOP_SOLID,
				BiomeFilter.biome()
		);

		// BEACH AND RIVER

		UNDER_WATER_CLAY_PATH_BEACH.makeAndSetHolder(WilderMiscConfigured.UNDER_WATER_CLAY_PATH_BEACH.getHolder(),
				RarityFilter.onAverageOnceEvery(3),
				InSquarePlacement.spread(),
				PlacementUtils.HEIGHTMAP_TOP_SOLID,
				BiomeFilter.biome()
		);

		UNDER_WATER_GRAVEL_PATH_RIVER.makeAndSetHolder(WilderMiscConfigured.UNDER_WATER_GRAVEL_PATH_RIVER.getHolder(),
				RarityFilter.onAverageOnceEvery(5),
				InSquarePlacement.spread(),
				PlacementUtils.HEIGHTMAP_TOP_SOLID,
				BiomeFilter.biome()
		);

		STONE_TRANSITION.makeAndSetHolder(WilderMiscConfigured.STONE_TRANSITION_DISK.getHolder(),
				CountPlacement.of(6),
				InSquarePlacement.spread(),
				LowerHeightmapPlacement.HEIGHTMAP_TOP_SOLID,
				BlockPredicateFilter.forPredicate(BlockPredicate.matchesTag(WilderBlockTags.STONE_TRANSITION_PLACEABLE)),
				BiomeFilter.biome()
		);

		SMALL_SAND_TRANSITION.makeAndSetHolder(WilderMiscConfigured.SMALL_SAND_TRANSITION_DISK.getHolder(),
				CountPlacement.of(6),
				InSquarePlacement.spread(),
				LowerHeightmapPlacement.HEIGHTMAP_TOP_SOLID,
				BlockPredicateFilter.forPredicate(BlockPredicate.matchesTag(WilderBlockTags.SAND_TRANSITION_PLACEABLE)),
				BiomeFilter.biome()
		);

		BETA_BEACH_SAND_TRANSITION.makeAndSetHolder(WilderMiscConfigured.BETA_BEACH_SAND_TRANSITION_DISK.getHolder(),
				CountPlacement.of(8),
				InSquarePlacement.spread(),
				LowerHeightmapPlacement.HEIGHTMAP_TOP_SOLID,
				BlockPredicateFilter.forPredicate(BlockPredicate.matchesTag(WilderBlockTags.SAND_TRANSITION_PLACEABLE)),
				BiomeFilter.biome()
		);

		SMALL_GRAVEL_TRANSITION.makeAndSetHolder(WilderMiscConfigured.SMALL_GRAVEL_TRANSITION_DISK.getHolder(),
				CountPlacement.of(8),
				InSquarePlacement.spread(),
				LowerHeightmapPlacement.HEIGHTMAP_TOP_SOLID,
				BlockPredicateFilter.forPredicate(BlockPredicate.matchesTag(WilderBlockTags.GRAVEL_TRANSITION_PLACEABLE)),

				BiomeFilter.biome()
		);

		// SAVANNA

		PACKED_MUD_PATH.makeAndSetHolder(WilderMiscConfigured.PACKED_MUD_PATH.getHolder(),
				RarityFilter.onAverageOnceEvery(8),
				InSquarePlacement.spread(),
				PlacementUtils.HEIGHTMAP_TOP_SOLID,
				BiomeFilter.biome()
		);

		// JUNGLE

		MOSS_PATH.makeAndSetHolder(WilderMiscConfigured.MOSS_PATH.getHolder(),
				RarityFilter.onAverageOnceEvery(3),
				InSquarePlacement.spread(),
				PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
				BiomeFilter.biome()
		);

		// DESERT

		ORE_PACKED_MUD.makeAndSetHolder(WilderMiscConfigured.ORE_PACKED_MUD.getHolder(),
				modifiersWithCount(5, HeightRangePlacement.uniform(VerticalAnchor.absolute(42), VerticalAnchor.absolute(250)))
		);

		SANDSTONE_PATH.makeAndSetHolder(WilderMiscConfigured.SANDSTONE_PATH.getHolder(),
				RarityFilter.onAverageOnceEvery(3),
				InSquarePlacement.spread(),
				PlacementUtils.HEIGHTMAP_TOP_SOLID,
				BiomeFilter.biome()
		);

		SCORCHED_SAND.makeAndSetHolder(WilderMiscConfigured.SCORCHED_SAND_DISK.getHolder(),
				RarityFilter.onAverageOnceEvery(64),
				InSquarePlacement.spread(),
				PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
				BiomeFilter.biome()
		);

		SCORCHED_SAND_HUGE.makeAndSetHolder(WilderMiscConfigured.SCORCHED_SAND_DISK_HUGE.getHolder(),
				CountPlacement.of(UniformInt.of(0, 1)),
				RarityFilter.onAverageOnceEvery(226),
				InSquarePlacement.spread(),
				PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
				BiomeFilter.biome()
		);

		SAND_TRANSITION.makeAndSetHolder(WilderMiscConfigured.SAND_TRANSITION_DISK.getHolder(),
				CountPlacement.of(4),
				InSquarePlacement.spread(),
				LowerHeightmapPlacement.HEIGHTMAP_TOP_SOLID,
				BlockPredicateFilter.forPredicate(BlockPredicate.matchesTag(WilderBlockTags.SAND_TRANSITION_PLACEABLE)),
				BiomeFilter.biome()
		);

		// BADLANDS

		COARSE_DIRT_PATH_SMALL.makeAndSetHolder(WilderMiscConfigured.COARSE_DIRT_PATH_SMALL.getHolder(),
				RarityFilter.onAverageOnceEvery(6),
				InSquarePlacement.spread(),
				PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
				BiomeFilter.biome()
		);

		PACKED_MUD_PATH_BADLANDS.makeAndSetHolder(WilderMiscConfigured.PACKED_MUD_PATH_BADLANDS.getHolder(),
				RarityFilter.onAverageOnceEvery(8),
				InSquarePlacement.spread(),
				PlacementUtils.HEIGHTMAP_TOP_SOLID,
				BiomeFilter.biome()
		);

		SCORCHED_RED_SAND.makeAndSetHolder(WilderMiscConfigured.SCORCHED_RED_SAND_DISK.getHolder(),
				RarityFilter.onAverageOnceEvery(64),
				InSquarePlacement.spread(),
				PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
				BiomeFilter.biome()
		);

		SCORCHED_RED_SAND_HUGE.makeAndSetHolder(WilderMiscConfigured.SCORCHED_RED_SAND_DISK_HUGE.getHolder(),
				RarityFilter.onAverageOnceEvery(226),
				InSquarePlacement.spread(),
				PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
				BiomeFilter.biome()
		);

		RED_SAND_TRANSITION.makeAndSetHolder(WilderMiscConfigured.RED_SAND_TRANSITION_DISK.getHolder(),
				CountPlacement.of(4),
				InSquarePlacement.spread(),
				LowerHeightmapPlacement.HEIGHTMAP_TOP_SOLID,
				BlockPredicateFilter.forPredicate(BlockPredicate.matchesTag(WilderBlockTags.RED_SAND_TRANSITION_PLACEABLE)),
				BiomeFilter.biome()
		);

		// JELLYFISH CAVES

		EXTRA_GLOW_LICHEN.makeAndSetHolder(CaveFeatures.GLOW_LICHEN,
				CountPlacement.of(UniformInt.of(104, 157)),
				PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
				InSquarePlacement.spread(),
				SurfaceRelativeThresholdFilter.of(Heightmap.Types.OCEAN_FLOOR_WG, Integer.MIN_VALUE, -13),
				BiomeFilter.biome()
		);

		STONE_POOL.makeAndSetHolder(WilderMiscConfigured.STONE_POOL.getHolder(),
				RarityFilter.onAverageOnceEvery(13),
				InSquarePlacement.spread(),
				HeightRangePlacement.uniform(VerticalAnchor.absolute(5), VerticalAnchor.aboveBottom(108)),
				EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12),
				RandomOffsetPlacement.vertical(ConstantInt.of(1)),
				BiomeFilter.biome()
		);

		DEEPSLATE_POOL.makeAndSetHolder(WilderMiscConfigured.DEEPSLATE_POOL.getHolder(),
				RarityFilter.onAverageOnceEvery(13),
				InSquarePlacement.spread(),
				HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(6), VerticalAnchor.absolute(5)),
				EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12),
				RandomOffsetPlacement.vertical(ConstantInt.of(1)),
				BiomeFilter.biome()
		);

		ORE_CALCITE.makeAndSetHolder(WilderMiscConfigured.ORE_CALCITE.getHolder(),
				modifiersWithCount(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(-54), VerticalAnchor.absolute(64)))
		);

		JELLYFISH_DEEPSLATE_POOL.makeAndSetHolder(WilderMiscConfigured.DEEPSLATE_POOL.getHolder(),
				CountPlacement.of(30),
				InSquarePlacement.spread(),
				HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(67)),
				EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12),
				RandomOffsetPlacement.vertical(ConstantInt.of(1)),
				BiomeFilter.biome()
		);

		JELLYFISH_STONE_POOL.makeAndSetHolder(WilderMiscConfigured.STONE_POOL.getHolder(),
				CountPlacement.of(30),
				InSquarePlacement.spread(),
				HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(68), VerticalAnchor.top()),
				EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12),
				RandomOffsetPlacement.vertical(ConstantInt.of(1)),
				BiomeFilter.biome()
		);

		MESOGLEA_PILLAR.makeAndSetHolder(WilderMiscConfigured.UPWARDS_MESOGLEA_PILLAR.getHolder(),
				CountPlacement.of(7),
				InSquarePlacement.spread(),
				HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top()),
				EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), ONLY_IN_WATER_PREDICATE, 12),
				RandomOffsetPlacement.vertical(ConstantInt.of(1)),
				BiomeFilter.biome()
		);

		PURPLE_MESOGLEA_PILLAR.makeAndSetHolder(WilderMiscConfigured.PURPLE_MESOGLEA_PILLAR.getHolder(),
				CountPlacement.of(7),
				InSquarePlacement.spread(),
				HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top()),
				EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), ONLY_IN_WATER_PREDICATE, 12),
				RandomOffsetPlacement.vertical(ConstantInt.of(1)),
				BiomeFilter.biome()
		);

		BLUE_MESOGLEA_PATH.makeAndSetHolder(WilderMiscConfigured.BLUE_MESOGLEA_PATH.getHolder(),
				CountPlacement.of(24),
				InSquarePlacement.spread(),
				HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top()),
				BiomeFilter.biome()
		);

		PURPLE_MESOGLEA_PATH.makeAndSetHolder(WilderMiscConfigured.PURPLE_MESOGLEA_PATH.getHolder(),
				CountPlacement.of(24),
				InSquarePlacement.spread(),
				HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top()),
				BiomeFilter.biome()
		);

		// OASIS

		SAND_POOL.makeAndSetHolder(WilderMiscConfigured.SAND_POOL.getHolder(),
				CountPlacement.of(1),
				InSquarePlacement.spread(),
				PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
				HeightRangePlacement.uniform(VerticalAnchor.absolute(63), VerticalAnchor.aboveBottom(256)),
				EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12),
				RandomOffsetPlacement.vertical(ConstantInt.of(1)),
				BiomeFilter.biome()
		);

		MESSY_SAND_POOL.makeAndSetHolder(WilderMiscConfigured.MESSY_SAND_POOL.getHolder(),
				CountPlacement.of(2),
				InSquarePlacement.spread(),
				PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
				HeightRangePlacement.uniform(VerticalAnchor.absolute(63), VerticalAnchor.aboveBottom(256)),
				EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12),
				RandomOffsetPlacement.vertical(ConstantInt.of(1)),
				BiomeFilter.biome()
		);

		GRASS_PATH.makeAndSetHolder(WilderMiscConfigured.GRASS_PATH.getHolder(),
				CountPlacement.of(4),
				InSquarePlacement.spread(),
				PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
				BiomeFilter.biome()
		);

		MOSS_PATH_OASIS.makeAndSetHolder(WilderMiscConfigured.MOSS_PATH_OASIS.getHolder(),
				RarityFilter.onAverageOnceEvery(4),
				InSquarePlacement.spread(),
				PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
				BiomeFilter.biome()
		);

		DESERT_WELL.makeAndSetHolder(MiscOverworldFeatures.DESERT_WELL,
				RarityFilter.onAverageOnceEvery(1000),
				InSquarePlacement.spread(),
				PlacementUtils.HEIGHTMAP,
				BiomeFilter.biome()
		);

		// BIRCH TAIGA

		COARSE_PATH_10.makeAndSetHolder(WilderMiscConfigured.COARSE_PATH.getHolder(),
				RarityFilter.onAverageOnceEvery(10),
				InSquarePlacement.spread(),
				PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
				BiomeFilter.biome()
		);

		// ARID SAVANNA

		GRASS_PATH_RARE.makeAndSetHolder(WilderMiscConfigured.GRASS_PATH.getHolder(),
				CountPlacement.of(1),
				InSquarePlacement.spread(),
				PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
				BiomeFilter.biome()
		);

		ARID_COARSE_PATH.makeAndSetHolder(WilderMiscConfigured.ARID_COARSE_PATH.getHolder(),
				RarityFilter.onAverageOnceEvery(5),
				InSquarePlacement.spread(),
				PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
				BiomeFilter.biome()
		);

		// OLD GROWTH SNOWY TAIGA

		PILE_SNOW.makeAndSetHolder(WilderMiscConfigured.SNOW.getHolder(),
				RarityFilter.onAverageOnceEvery(10),
				InSquarePlacement.spread(),
				PlacementUtils.HEIGHTMAP,
				BiomeFilter.biome()
		);

		// TEMPERATE RAINFOREST & RAINFOREST

		MOSS_PILE.makeAndSetHolder(WilderMiscConfigured.MOSS_PILE.getHolder(),
				RarityFilter.onAverageOnceEvery(9),
				InSquarePlacement.spread(),
				PlacementUtils.HEIGHTMAP,
				BiomeFilter.biome()
		);

		BASIN_PODZOL.makeAndSetHolder(WilderMiscConfigured.BASIN_PODZOL.getHolder(),
				RarityFilter.onAverageOnceEvery(5),
				InSquarePlacement.spread(),
				PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
				EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12),
				RandomOffsetPlacement.vertical(ConstantInt.of(1)),
				BiomeFilter.biome()
		);

		BASIN_MOSS.makeAndSetHolder(WilderMiscConfigured.BASIN_MOSS.getHolder(),
				RarityFilter.onAverageOnceEvery(5),
				InSquarePlacement.spread(),
				PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
				EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12),
				RandomOffsetPlacement.vertical(ConstantInt.of(1)),
				BiomeFilter.biome()
		);

		MOSS_LAKE.makeAndSetHolder(WilderMiscConfigured.MOSS_LAKE.getHolder(),
				CountPlacement.of(1),
				RarityFilter.onAverageOnceEvery(1),
				InSquarePlacement.spread(),
				PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
				PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING),
				BiomeFilter.biome()
		);

		MOSS_LAKE_RARE.makeAndSetHolder(WilderMiscConfigured.MOSS_LAKE.getHolder(),
				CountPlacement.of(1),
				RarityFilter.onAverageOnceEvery(10),
				InSquarePlacement.spread(),
				PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
				PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING),
				BiomeFilter.biome()
		);

		// SNOW

		SNOW_BLANKET.makeAndSetHolder(WilderMiscConfigured.SNOW_BLANKET.getHolder(),
				CountPlacement.of(1),
				PlacementUtils.HEIGHTMAP,
				BiomeFilter.biome()
		);

		SNOW_AND_ICE_TRANSITION.makeAndSetHolder(WilderMiscConfigured.SNOW_AND_ICE_TRANSITION_DISK.getHolder(),
				CountPlacement.of(6),
				InSquarePlacement.spread(),
				PlacementUtils.HEIGHTMAP,
				BiomeFilter.biome()
		);
	}

	private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, InSquarePlacement.spread(), heightModifier, BiomeFilter.biome());
    }

    private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacement.of(count), heightModifier);
    }

}

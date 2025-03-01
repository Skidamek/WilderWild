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

package net.frozenblock.wilderwild.world.generation;

import net.frozenblock.lib.worldgen.biome.api.parameters.Continentalness;
import net.frozenblock.lib.worldgen.biome.api.parameters.Erosion;
import net.frozenblock.lib.worldgen.biome.api.parameters.Humidity;
import net.frozenblock.lib.worldgen.biome.api.parameters.Temperature;
import net.frozenblock.lib.worldgen.biome.api.parameters.Weirdness;
import net.frozenblock.lib.worldgen.surface.FrozenSurfaceRules;
import static net.frozenblock.lib.worldgen.surface.FrozenSurfaceRules.*;
import net.frozenblock.lib.worldgen.surface.impl.BiomeTagConditionSource;
import net.frozenblock.wilderwild.misc.WilderSharedConstants;
import net.frozenblock.wilderwild.registry.RegisterWorldgen;
import net.frozenblock.wilderwild.tag.WilderBiomeTags;
import net.frozenblock.wilderwild.world.generation.conditionsource.BetaBeachConditionSource;
import net.frozenblock.wilderwild.world.generation.noise.WilderNoise;
import net.minecraft.data.worldgen.biome.OverworldBiomes;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;

/**
 * Contains Wilder Wild's worldgen data.
 */
public final class WilderSharedWorldgen {

	// DEPTHS
	public static final Climate.Parameter BOTTOM_DEPTH = Climate.Parameter.point(1.1F);
	public static final Climate.Parameter DEEP_DEPTH = Climate.Parameter.span(0.65F, 1.1F);
	public static final Climate.Parameter SEMI_DEEP_DEPTH = Climate.Parameter.span(0.4F, 1.0F);
	public static final Climate.Parameter SURFACE_DEPTH = Climate.Parameter.span(0.0F, 1.0F);

	// MODDED BIOME PARAMETERS

    public static final class CypressWetlands {
        public static final Climate.Parameter TEMPERATURE = Climate.Parameter.span(Temperature.COOL, Temperature.WARM);
        public static final Climate.Parameter HUMIDITY = Climate.Parameter.span(Humidity.NEUTRAL, Humidity.HUMID);
        public static final Climate.Parameter CONTINENTALNESS = Climate.Parameter.span(-0.200F, 0.500F);
        public static final Climate.Parameter EROSION = Climate.Parameter.span(0.500F, 1.000F);
        public static final float OFFSET = 0.000F;

		public static float TEMP = 0.6F;
		public static float DOWNFALL = 0.7F;
		public static int WATER_COLOR = 4552818;
		public static int WATER_FOG_COLOR = 4552818;
		public static int FOG_COLOR = 12638463;
		public static int SKY_COLOR = OverworldBiomes.calculateSkyColor(0.8F);
		public static int FOLIAGE_COLOR = 5877296;
		public static int GRASS_COLOR = 7979098;
    }

    public static final class MixedForest {
        public static final Climate.Parameter TEMPERATURE = Climate.Parameter.span(-0.450F, -0.140F);
        public static final Climate.Parameter HUMIDITY = Climate.Parameter.span(0.050F, 0.150F);

		public static float TEMP = 0.5F;
		public static float DOWNFALL = 0.7F;
		public static int WATER_COLOR = 4159204;
		public static int WATER_FOG_COLOR = 329011;
		public static int FOG_COLOR = 12638463;
		public static int SKY_COLOR = OverworldBiomes.calculateSkyColor(TEMP);
    }

	public static final class BirchJungle {
		public static final Climate.Parameter TEMPERATURE = Climate.Parameter.span(0.175F, 0.225F);
		public static final Climate.Parameter HUMIDITY_A = Humidity.FOUR;
		public static final Climate.Parameter HUMIDITY_B = Climate.Parameter.span(0.250F, 0.350F);

		public static float TEMP = 0.825F;
		public static float DOWNFALL = 0.85F;
		public static int WATER_COLOR = 4159204;
		public static int WATER_FOG_COLOR = 329011;
		public static int FOG_COLOR = 12638463;
		public static int SKY_COLOR = OverworldBiomes.calculateSkyColor(TEMP);
	}

	public static final class FlowerField {
		public static final Climate.Parameter TEMPERATURE_A = Climate.Parameter.span(-0.200F, -0.075F);
		public static final Climate.Parameter HUMIDITY_A = Humidity.ONE;
		public static final Climate.Parameter TEMPERATURE_B = Temperature.THREE;
		public static final Climate.Parameter HUMIDITY_B = Climate.Parameter.span(-0.400F, -0.300F);
		public static final Climate.Parameter HUMIDITY_AB = Climate.Parameter.span(-0.3675F, -0.3125F);

		public static float TEMP = 0.8F;
		public static float DOWNFALL = 0.5F;
		public static int WATER_COLOR = 4159204;
		public static int WATER_FOG_COLOR = 329011;
		public static int FOG_COLOR = 12638463;
		public static int SKY_COLOR = OverworldBiomes.calculateSkyColor(TEMP);
		public static int FOLIAGE_COLOR = 5877296;
	}

	public static final class AridSavanna {
		public static final Climate.Parameter TEMPERATURE = Climate.Parameter.span(0.525F, 0.575F);
		public static final Climate.Parameter HUMIDITY = Climate.Parameter.span(-1.000F, -0.125F);

		public static float TEMP = 2.0F;
		public static float DOWNFALL = 0.0F;
		public static int WATER_COLOR = 4159204;
		public static int WATER_FOG_COLOR = 329011;
		public static int FOG_COLOR = 12638463;
		public static int SKY_COLOR = OverworldBiomes.calculateSkyColor(TEMP);
	}

	public static final class ParchedForest {
		public static final Climate.Parameter TEMPERATURE_A = Temperature.FOUR;
		public static final Climate.Parameter TEMPERATURE_B = Climate.Parameter.span(0.175F, 0.225F);
		public static final Climate.Parameter HUMIDITY = Climate.Parameter.span(-0.150F, -0.050F);

		public static float TEMP = 1.35F;
		public static float DOWNFALL = 0.2F;
		public static int WATER_COLOR = 4159204;
		public static int WATER_FOG_COLOR = 329011;
		public static int FOG_COLOR = 12638463;
		public static int SKY_COLOR = OverworldBiomes.calculateSkyColor(TEMP);
	}

	public static final class AridForest {
		public static final Climate.Parameter TEMPERATURE = Climate.Parameter.span(0.530F, 0.570F);
		public static final Climate.Parameter HUMIDITY = WilderSharedConstants.config().modifyJunglePlacement() ? Climate.Parameter.span(-0.095F, 0.1F) : Climate.Parameter.span(-0.095F, 0.15F);

		public static float TEMP = 1.75F;
		public static float DOWNFALL = 0.05F;
		public static int WATER_COLOR = 4159204;
		public static int WATER_FOG_COLOR = 329011;
		public static int FOG_COLOR = 12638463;
		public static int SKY_COLOR = OverworldBiomes.calculateSkyColor(TEMP);
	}

	public static final class OldGrowthSnowySpruceTaiga {
		public static final Climate.Parameter TEMPERATURE = Temperature.ONE;
		public static final Climate.Parameter HUMIDITY = Humidity.FIVE;

		public static float TEMP = -0.5F;
		public static float DOWNFALL = 0.4F;
		public static int WATER_COLOR = 4020182;
		public static int WATER_FOG_COLOR = 329011;
		public static int FOG_COLOR = 12638463;
		public static int SKY_COLOR = OverworldBiomes.calculateSkyColor(TEMP);
		public static int GRASS_COLOR = 8434839;
		public static int FOLIAGE_COLOR = 6332795;
	}

	public static final class BirchTaiga {
		public static final Climate.Parameter TEMPERATURE = Climate.Parameter.span(-0.175F, -0.125F);
		public static final Climate.Parameter HUMIDITY = Climate.Parameter.span(0.100F, 0.325F);
		public static final Climate.Parameter HUMIDITY_B = Humidity.FOUR;

		public static float TEMP = 0.45F;
		public static float DOWNFALL = 0.8F;
		public static int WATER_COLOR = 4159204;
		public static int WATER_FOG_COLOR = 329011;
		public static int FOG_COLOR = 12638463;
		public static int SKY_COLOR = OverworldBiomes.calculateSkyColor(TEMP);
	}

	public static final class DarkTaiga {
		public static final Climate.Parameter TEMPERATURE = Climate.Parameter.span(-0.175F, -0.125F);
		public static final Climate.Parameter HUMIDITY = Climate.Parameter.span(0.275F, 0.325F);
		public static final Climate.Parameter HUMIDITY_B = Humidity.FIVE;

		public static float TEMP = 0.45F;
		public static float DOWNFALL = 0.5F;
		public static int WATER_COLOR = 4159204;
		public static int WATER_FOG_COLOR = 329011;
		public static int FOG_COLOR = 12638463;
		public static int SKY_COLOR = OverworldBiomes.calculateSkyColor(TEMP);
	}

	public static final class DarkBirchForest {
		public static final Climate.Parameter TEMPERATURE = Climate.Parameter.span(-0.125F, 0.2F);
		public static final Climate.Parameter HUMIDITY = Climate.Parameter.span(0.275F, 0.325F);

		public static float TEMP = 0.65F;
		public static float DOWNFALL = 0.7F;
		public static int WATER_COLOR = 4159204;
		public static int WATER_FOG_COLOR = 329011;
		public static int FOG_COLOR = 12638463;
		public static int SKY_COLOR = OverworldBiomes.calculateSkyColor(TEMP);
	}

	public static final class OldGrowthDarkForest {
		public static final Climate.Parameter TEMPERATURE = Climate.Parameter.span(-0.200F, 0.200F);
		public static final Climate.Parameter HUMIDITY = Climate.Parameter.span(0.350F, 1.000F);

		public static float TEMP = 0.7F;
		public static float DOWNFALL = 0.8F;
		public static int WATER_COLOR = 4159204;
		public static int WATER_FOG_COLOR = 329011;
		public static int FOG_COLOR = 12638463;
		public static int SKY_COLOR = OverworldBiomes.calculateSkyColor(TEMP);
	}

	public static final class SemiBirchForest {
		public static final Climate.Parameter TEMPERATURE_A = Temperature.THREE;
		public static final Climate.Parameter HUMIDITY = Climate.Parameter.span(0.050F, 0.150F);
		public static final Climate.Parameter TEMPERATURE_B = Climate.Parameter.span(-0.140F, -0.100F);

		public static float TEMP = 0.65F;
		public static float DOWNFALL = 0.7F;
		public static int WATER_COLOR = 4159204;
		public static int WATER_FOG_COLOR = 329011;
		public static int FOG_COLOR = 12638463;
		public static int SKY_COLOR = OverworldBiomes.calculateSkyColor(TEMP);
	}

	public static final class TemperateRainforest {
		public static final Climate.Parameter TEMPERATURE = Climate.Parameter.span(-0.250F, -0.050F);
		public static final Climate.Parameter HUMIDITY = Climate.Parameter.span(0.250F, 1.0F);
		public static final Climate.Parameter EROSION = Climate.Parameter.span(Erosion.EROSION_0, Erosion.EROSION_3);

		public static float TEMP = 0.7F;
		public static float DOWNFALL = 0.8F;
		public static int WATER_COLOR = 4159204;
		public static int WATER_FOG_COLOR = 329011;
		public static int FOG_COLOR = 12638463;
		public static int SKY_COLOR = OverworldBiomes.calculateSkyColor(TEMP);
		public static int FOLIAGE_COLOR = 4896834;
	}

	public static final class Rainforest {
		public static final Climate.Parameter TEMPERATURE_A = Climate.Parameter.span(Temperature.THREE, Temperature.FOUR);
		public static final Climate.Parameter HUMIDITY_A = Humidity.THREE;
		public static final Climate.Parameter CONTINENTALNESS_A = Climate.Parameter.span(Continentalness.INLAND, Continentalness.FAR_INLAND);
		public static final Climate.Parameter EROSION_A = Climate.Parameter.span(Erosion.EROSION_0, Erosion.EROSION_3);
		public static final Climate.Parameter WEIRDNESS_A = Climate.Parameter.span(-1.000F, 0.050F);

		public static final Climate.Parameter TEMPERATURE_B = Temperature.FOUR;
		public static final Climate.Parameter HUMIDITY_B = Climate.Parameter.span(0.075F, 0.225F);

		public static final Climate.Parameter TEMPERATURE_C = Climate.Parameter.span(0.175F, 0.250F);
		public static final Climate.Parameter HUMIDITY_C = Climate.Parameter.span(0.075F, 0.225F);

		public static float TEMP = 0.7F;
		public static float DOWNFALL = 0.8F;
		public static int WATER_COLOR = 4159204;
		public static int WATER_FOG_COLOR = 329011;
		public static int FOG_COLOR = 12638463;
		public static int SKY_COLOR = OverworldBiomes.calculateSkyColor(TEMP);
		public static int FOLIAGE_COLOR = 4896834;
	}

	public static final class JellyfishCaves {
        public static final Climate.Parameter TEMPERATURE = Temperature.FULL_RANGE;
        public static final Climate.Parameter HUMIDITY = Climate.Parameter.span(Humidity.DRY, Humidity.HUMID);
        public static final Climate.Parameter CONTINENTALNESS = Climate.Parameter.span(-1.200F, -0.749F);
        public static final Climate.Parameter EROSION = Climate.Parameter.span(Erosion.EROSION_4, Erosion.EROSION_6);
		public static final Climate.Parameter WEIRDNESS = Weirdness.FULL_RANGE;
        public static final float OFFSET = 0.000F;

		public static float TEMP = 0.4F;
		public static float DOWNFALL = 0.4F;
		public static int WATER_COLOR = 9817343;
		public static int WATER_FOG_COLOR = 6069471;
		public static int FOG_COLOR = 0;
		public static int SKY_COLOR = OverworldBiomes.calculateSkyColor(0.0F);
    }

	public static final class WarmRiver {
		public static final Climate.Parameter WARM_RANGE = Climate.Parameter.span(0.550F, 1.000F);
		public static final Climate.Parameter UNFROZEN_NOT_WARM_RANGE = Climate.Parameter.span(0.000F, 0.200F);
		public static final Climate.Parameter HUMIDITY_TO_TWO = Climate.Parameter.span(-0.100F, 0.000F);
		public static final Climate.Parameter HUMIDITY_TO_THREE = Climate.Parameter.span(0.000F, 0.100F);
		public static final Climate.Parameter HUMIDITY = Climate.Parameter.span(-0.100F, 0.100F);

		public static float TEMP = 1.5F;
		public static float DOWNFALL = 0.15F;
		public static int WATER_COLOR = 4566514;
		public static int WATER_FOG_COLOR = 267827;
		public static int FOG_COLOR = 12638463;
		public static int SKY_COLOR = OverworldBiomes.calculateSkyColor(TEMP);
		public static int FOLIAGE_COLOR = 11445290;
		public static int GRASS_COLOR = 12564309;
	}

	public static final class Oasis {
		public static final Climate.Parameter TEMPERATURE = Temperature.HOT;
		public static final Climate.Parameter HUMIDITY = Climate.Parameter.span(Humidity.THREE, Humidity.FIVE);
		public static final Climate.Parameter CONTINENTALNESS = Climate.Parameter.span(Continentalness.COAST, Continentalness.FAR_INLAND);
		public static final Climate.Parameter EROSION = Climate.Parameter.span(Erosion.EROSION_3, Erosion.EROSION_4);
		public static final float OFFSET = 0.000F;

		public static float TEMP = 2.0F;
		public static float DOWNFALL = 0.5F;
		public static int WATER_COLOR = 3981763;
		public static int WATER_FOG_COLOR = 270131;
		public static int FOG_COLOR = 12638463;
		public static int SKY_COLOR = OverworldBiomes.calculateSkyColor(TEMP);
		public static int FOLIAGE_COLOR = 3193611;
		public static int GRASS_COLOR = 8569413;
	}

    public static final class Swamp {
        public static final Climate.Parameter HUMIDITY = Climate.Parameter.span(Climate.Parameter.span(-0.200F, 0.100F), Humidity.WET);
        public static final Climate.Parameter TEMPERATURE = Climate.Parameter.span(Temperature.COOL, Temperature.WARM);

	}

	public static final class MangroveSwamp {
		public static final Climate.Parameter TEMPERATURE = Climate.Parameter.span(Temperature.NEUTRAL, Temperature.HOT);
		public static final Climate.Parameter HUMIDITY = Climate.Parameter.span(Climate.Parameter.span(0.050F, 0.100F), Humidity.HUMID);
	}

    // SURFACE RULES

    public static SurfaceRules.RuleSource cypressSurfaceRules() {
        return SurfaceRules.ifTrue(
				SurfaceRules.isBiome(RegisterWorldgen.CYPRESS_WETLANDS),
				SurfaceRules.ifTrue(
						SurfaceRules.ON_FLOOR,
						SurfaceRules.ifTrue(
								SurfaceRules.yBlockCheck(VerticalAnchor.absolute(60), 0),
								SurfaceRules.ifTrue(
										SurfaceRules.not(SurfaceRules.yBlockCheck(VerticalAnchor.absolute(63), 0)),
										SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0), WATER)
								)
						)
				)
        );
    }

	public static SurfaceRules.RuleSource warmRiverRules() {
		return SurfaceRules.ifTrue(
				SurfaceRules.isBiome(RegisterWorldgen.WARM_RIVER),
				SurfaceRules.ifTrue(
						SurfaceRules.yBlockCheck(VerticalAnchor.absolute(32), 0),
						SurfaceRules.sequence(
								SurfaceRules.ifTrue(
										SurfaceRules.DEEP_UNDER_FLOOR,
										SAND
								),
								SANDSTONE
						)
				)
		);
	}

	public static SurfaceRules.RuleSource oasisRules() {
		return SurfaceRules.ifTrue(
				SurfaceRules.isBiome(RegisterWorldgen.OASIS),
				SurfaceRules.sequence(
						SurfaceRules.ifTrue(
								SurfaceRules.ON_FLOOR,
								SurfaceRules.ifTrue(
										SurfaceRules.waterBlockCheck(-1, 0),
										SurfaceRules.sequence(
												SurfaceRules.ifTrue(
														SurfaceRules.ON_CEILING,
														SANDSTONE
												),
												SAND
										)
								)
						),
						SurfaceRules.ifTrue(
								SurfaceRules.waterStartCheck(-6, -1),
								SurfaceRules.sequence(
										SurfaceRules.ifTrue(
												SurfaceRules.UNDER_FLOOR,
												SurfaceRules.sequence(
														SurfaceRules.ifTrue(
																SurfaceRules.ON_CEILING,
																SANDSTONE
														),
														SAND
												)
										),
										SurfaceRules.ifTrue(
												SurfaceRules.VERY_DEEP_UNDER_FLOOR,
												SANDSTONE
										)
								)
						)
				)
		);
	}
	public static SurfaceRules.RuleSource aridGrass() {
		return SurfaceRules.ifTrue(
				SurfaceRules.isBiome(RegisterWorldgen.ARID_SAVANNA, RegisterWorldgen.ARID_FOREST),
				SurfaceRules.sequence(
						SurfaceRules.ifTrue(
								SurfaceRules.ON_FLOOR,
								SurfaceRules.ifTrue(
										SurfaceRules.noiseCondition(Noises.SURFACE, 0.155, 0.3666),
										SurfaceRules.sequence(
												SurfaceRules.ifTrue(
														SurfaceRules.ON_CEILING,
														DIRT
												),
												GRASS_BLOCK
										)
								)
						),
						SurfaceRules.ifTrue(
								SurfaceRules.noiseCondition(Noises.SURFACE, 0.155, 0.3666),
								SurfaceRules.sequence(
										SurfaceRules.ifTrue(
												SurfaceRules.UNDER_FLOOR,
												SurfaceRules.sequence(
														SurfaceRules.ifTrue(
																SurfaceRules.ON_CEILING,
																DIRT
														),
														DIRT
												)
										),
										SurfaceRules.ifTrue(
												SurfaceRules.DEEP_UNDER_FLOOR,
												DIRT
										)
								)
						)
				)
		);
	}

	public static SurfaceRules.RuleSource aridRules() {
		return SurfaceRules.ifTrue(
				SurfaceRules.isBiome(RegisterWorldgen.ARID_SAVANNA, RegisterWorldgen.ARID_FOREST),
				SurfaceRules.sequence(
						SurfaceRules.ifTrue(
								SurfaceRules.ON_FLOOR,
								SurfaceRules.ifTrue(
										SurfaceRules.waterBlockCheck(-1, 0),
										SurfaceRules.sequence(
												SurfaceRules.ifTrue(
														SurfaceRules.ON_CEILING,
														SANDSTONE
												),
												SAND
										)
								)
						),
						SurfaceRules.ifTrue(
								SurfaceRules.waterStartCheck(-6, -1),
								SurfaceRules.sequence(
										SurfaceRules.ifTrue(
												SurfaceRules.UNDER_FLOOR,
												SurfaceRules.sequence(
														SurfaceRules.ifTrue(
																SurfaceRules.ON_CEILING,
																SANDSTONE
														),
														SAND
												)
										),
										SurfaceRules.ifTrue(
												SurfaceRules.VERY_DEEP_UNDER_FLOOR,
												SANDSTONE
										)
								)
						)
				)
		);
	}

	public static SurfaceRules.RuleSource oldGrowthSnowyTaigaRules() {
		return SurfaceRules.ifTrue(
				SurfaceRules.isBiome(RegisterWorldgen.SNOWY_OLD_GROWTH_PINE_TAIGA),
				SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
						SurfaceRules.ifTrue(
								SurfaceRules.waterBlockCheck(-1, 0),
								SurfaceRules.sequence(
										SurfaceRules.ifTrue(
												SurfaceRules.noiseCondition(Noises.SURFACE, 1.75D / 8.25D, Double.MAX_VALUE),
												COARSE_DIRT
										),
										SurfaceRules.ifTrue(
												SurfaceRules.noiseCondition(Noises.SURFACE, -0.95D / 8.25D, Double.MAX_VALUE),
												PODZOL
										),
										SurfaceRules.ifTrue(
												SurfaceRules.noiseCondition(Noises.SURFACE, 0.0222, 0.055),
												POWDER_SNOW
										),
										SurfaceRules.ifTrue(
												SurfaceRules.noiseCondition(Noises.SURFACE, 0.065, 0.12),
												SNOW_BLOCK
										)
								)
						)
				)
		);
	}
	public static SurfaceRules.RuleSource oldGrowthDarkForestRules() {
		return SurfaceRules.ifTrue(
				SurfaceRules.isBiome(RegisterWorldgen.OLD_GROWTH_DARK_FOREST),
				SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
						SurfaceRules.ifTrue(
								SurfaceRules.waterBlockCheck(-1, 0),
								SurfaceRules.sequence(
										SurfaceRules.ifTrue(
												SurfaceRules.noiseCondition(Noises.SURFACE, -0.0667, 0.04),
												PODZOL
										)
								)
						)
				)
		);
	}

	public static SurfaceRules.RuleSource temperateRainforestRules() {
		return SurfaceRules.ifTrue(
				SurfaceRules.isBiome(RegisterWorldgen.TEMPERATE_RAINFOREST),
				SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
						SurfaceRules.ifTrue(
								SurfaceRules.waterBlockCheck(-1, 0),
								SurfaceRules.sequence(
										SurfaceRules.ifTrue(
												SurfaceRules.noiseCondition(Noises.SURFACE, 0.095, 0.2),
												FrozenSurfaceRules.makeStateRule(Blocks.PODZOL)
										),
										SurfaceRules.ifTrue(
												SurfaceRules.noiseCondition(Noises.POWDER_SNOW, 0.065, 0.15),
												FrozenSurfaceRules.makeStateRule(Blocks.MOSS_BLOCK)
										),
										SurfaceRules.ifTrue(
												SurfaceRules.noiseCondition(Noises.SURFACE_SECONDARY, 0.0667, 0.4),
												COARSE_DIRT
										)
								)
						)
				)
		);
	}

	public static SurfaceRules.RuleSource rainforestRules() {
		return SurfaceRules.ifTrue(
				SurfaceRules.isBiome(RegisterWorldgen.RAINFOREST),
				SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
						SurfaceRules.ifTrue(
								SurfaceRules.waterBlockCheck(-1, 0),
								SurfaceRules.sequence(
										SurfaceRules.ifTrue(
												SurfaceRules.noiseCondition(Noises.POWDER_SNOW, 0.065, 0.15),
												FrozenSurfaceRules.makeStateRule(Blocks.MOSS_BLOCK)
										)
								)
						)
				)
		);
	}

	public static SurfaceRules.RuleSource betaBeaches() {
		return SurfaceRules.ifTrue(
				BetaBeachConditionSource.betaBeachConditionSource(1),
				SurfaceRules.sequence(
						gravelBetaBeaches(),
						sandBetaBeaches(),
						multilayerSandBetaBeaches()
				)
		);
	}

	public static SurfaceRules.RuleSource gravelBetaBeaches() {
		return SurfaceRules.ifTrue(
				BiomeTagConditionSource.isBiomeTag(WilderBiomeTags.GRAVEL_BEACH),
				SurfaceRules.ifTrue(
						SurfaceRules.UNDER_FLOOR,
						SurfaceRules.ifTrue(
								SurfaceRules.yStartCheck(VerticalAnchor.absolute(58), 0),
								SurfaceRules.ifTrue(
										SurfaceRules.not(SurfaceRules.yStartCheck(VerticalAnchor.absolute(65), 0)),
										SurfaceRules.ifTrue(
												SurfaceRules.noiseCondition(WilderNoise.GRAVEL_BEACH_KEY, 0.12, 1.7976931348623157E308),
												GRAVEL
										)
								)
						)
				)
		);
	}

	public static SurfaceRules.RuleSource sandBetaBeaches() {
		return SurfaceRules.ifTrue(
				BiomeTagConditionSource.isBiomeTag(WilderBiomeTags.SAND_BEACHES),
				SurfaceRules.ifTrue(
						SurfaceRules.DEEP_UNDER_FLOOR,
						SurfaceRules.ifTrue(
								SurfaceRules.yStartCheck(VerticalAnchor.absolute(58), 0),
								SurfaceRules.ifTrue(
										SurfaceRules.not(SurfaceRules.yStartCheck(VerticalAnchor.absolute(65), 0)),
										SurfaceRules.ifTrue(
												SurfaceRules.noiseCondition(WilderNoise.SAND_BEACH_KEY, 0.12, 1.7976931348623157E308),
												SAND
										)
								)
						)
				)
		);
	}

	public static SurfaceRules.RuleSource multilayerSandBetaBeaches() {
		return SurfaceRules.ifTrue(
				BiomeTagConditionSource.isBiomeTag(WilderBiomeTags.MULTI_LAYER_SAND_BEACHES),
				SurfaceRules.ifTrue(
						SurfaceRules.DEEP_UNDER_FLOOR,
						SurfaceRules.ifTrue(
								SurfaceRules.yStartCheck(VerticalAnchor.absolute(58), 0),
								SurfaceRules.ifTrue(
										SurfaceRules.not(SurfaceRules.yStartCheck(VerticalAnchor.absolute(64), 0)),
										SurfaceRules.ifTrue(
												SurfaceRules.noiseCondition(WilderNoise.SAND_BEACH_KEY, 0.12, 1.7976931348623157E308),
												SAND
										)
								)
						)
				)
		);
	}

	//SurfaceRules.sequence(new SurfaceRules.RuleSource[]{SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.FOREST, Biomes.FLOWER_FOREST, Biomes.JUNGLE),
	// SurfaceRules.ifTrue(SurfaceRules.yStartCheck(VerticalAnchor.absolute(58), 0),
	// SurfaceRules.sequence(new SurfaceRules.RuleSource[]{SurfaceRules.ifTrue(SurfaceRules.yStartCheck(VerticalAnchor.absolute(65),0),
	// SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.steep()),
	// SurfaceRules.sequence(new SurfaceRules.RuleSource[]{SurfaceRules.ifTrue(SurfaceRules.noiseCondition(WilderNoise.SAND_BEACH, 0.12, 1.7976931348623157E308),
	// SurfaceRules.sequence(new SurfaceRules.RuleSource[]{SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR,
	// SurfaceRules.sequence(new SurfaceRules.RuleSource[]{SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(3, false, CaveSurface.CEILING),SANDSTONE), SAND})),
	// SurfaceRules.ifTrue(SurfaceRules.waterStartCheck(-6, -1),
	// SurfaceRules.sequence(new SurfaceRules.RuleSource[]{SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR,
	// SurfaceRules.sequence(new SurfaceRules.RuleSource[]{SurfaceRules.ifTrue(SurfaceRules.ON_CEILING,
	// SANDSTONE), SAND})), SurfaceRules.ifTrue(SurfaceRules.DEEP_UNDER_FLOOR, SANDSTONE)}))}))})))})))}));

    public static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }

	// PARAMETER POINTS

    public static Climate.ParameterPoint bottomParameters(
            Climate.Parameter temperature,
            Climate.Parameter humidity,
            Climate.Parameter continentalness,
            Climate.Parameter erosion,
            Climate.Parameter weirdness,
            float offset
    ) {
        return Climate.parameters(temperature, humidity, continentalness, erosion, BOTTOM_DEPTH, weirdness, offset);
    }

    public static Climate.ParameterPoint deepParameters(
            Climate.Parameter temperature,
            Climate.Parameter humidity,
            Climate.Parameter continentalness,
            Climate.Parameter erosion,
            Climate.Parameter weirdness,
            float offset
    ) {
        return Climate.parameters(temperature, humidity, continentalness, erosion, DEEP_DEPTH, weirdness, offset);
    }

    public static Climate.ParameterPoint semiDeepParameters(
            Climate.Parameter temperature,
            Climate.Parameter humidity,
            Climate.Parameter continentalness,
            Climate.Parameter erosion,
            Climate.Parameter weirdness,
            float offset
    ) {
        return Climate.parameters(temperature, humidity, continentalness, erosion, SEMI_DEEP_DEPTH, weirdness, offset);
    }

    public static Climate.ParameterPoint surfaceParameters(
            Climate.Parameter temperature,
            Climate.Parameter humidity,
            Climate.Parameter continentalness,
            Climate.Parameter erosion,
            Climate.Parameter weirdness,
            float offset
    ) {
        return Climate.parameters(temperature, humidity, continentalness, erosion, SURFACE_DEPTH, weirdness, offset);
    }
}

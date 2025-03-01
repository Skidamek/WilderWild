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

package net.frozenblock.wilderwild.world.generation.trunk;

import com.google.common.collect.Lists;
import com.mojang.math.Vector3f;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.function.BiConsumer;
import net.frozenblock.wilderwild.WilderWild;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import org.jetbrains.annotations.NotNull;

public class PalmTrunkPlacer extends TrunkPlacer {
	public static final Codec<PalmTrunkPlacer> CODEC = RecordCodecBuilder.create(instance -> PalmTrunkPlacer.trunkPlacerParts(instance).apply(instance, PalmTrunkPlacer::new));

	public PalmTrunkPlacer(int i, int j, int k) {
		super(i, j, k);
	}

	@Override
	protected TrunkPlacerType<?> type() {
		return WilderWild.PALM_TRUNK_PLACER;
	}

	@Override
	public List<FoliagePlacer.FoliageAttachment> placeTrunk(@NotNull LevelSimulatedReader level, @NotNull BiConsumer<BlockPos, BlockState> blockSetter, @NotNull RandomSource random, int freeTreeHeight, BlockPos pos, TreeConfiguration config) {
		int n;
		PalmTrunkPlacer.setDirtAt(level, blockSetter, random, pos.below(), config);
		ArrayList<FoliagePlacer.FoliageAttachment> list = Lists.newArrayList();
		Direction direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);
		Vector3f offset = direction.step();
		int i = freeTreeHeight - random.nextInt(4) - 1;
		int j = 4 - random.nextInt(3);
		BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
		int k = pos.getX();
		int l = pos.getZ();
		OptionalInt optionalInt = OptionalInt.empty();
		for (int m = 0; m < freeTreeHeight; ++m) {
			n = pos.getY() + m;
			if (m >= i && j > 0) {
				k += offset.x();
				l += offset.z();
				--j;
			}
			if (!this.placeLog(level, blockSetter, random, mutableBlockPos.set(k, n, l), config)) continue;
			optionalInt = OptionalInt.of(n + 1);
		}
		if (optionalInt.isPresent()) {
			list.add(new FoliagePlacer.FoliageAttachment(new BlockPos(k, optionalInt.getAsInt(), l), 1, false));
		}
		return list;
	}
}


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

package net.frozenblock.wilderwild.mixin.worldgen.general;

import net.frozenblock.wilderwild.misc.WilderSharedConstants;
import net.frozenblock.wilderwild.misc.interfaces.AbstractTreeGrowerInterface;
import net.frozenblock.wilderwild.tag.WilderBiomeTags;
import net.frozenblock.wilderwild.world.additions.feature.WilderTreeConfigured;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.grower.OakTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = OakTreeGrower.class, priority = 69420)
public class OakTreeGrowerMixin {

    @Inject(method = "getConfiguredFeature", at = @At("RETURN"), cancellable = true)
    public void wilderWild$getConfiguredFeature(RandomSource random, boolean bees, CallbackInfoReturnable<Holder<? extends ConfiguredFeature<?, ?>>> info) {
		if (WilderSharedConstants.config().wildTrees()) {
			AbstractTreeGrowerInterface treeGrowerInterface = (AbstractTreeGrowerInterface) OakTreeGrower.class.cast(this);
			if (treeGrowerInterface.wilderWild$getLevel() != null && treeGrowerInterface.wilderWild$getPos() != null && random.nextFloat() <= 0.4F) {
				Holder<Biome> biome = treeGrowerInterface.wilderWild$getLevel().getBiome(treeGrowerInterface.wilderWild$getPos());
				if (biome.is(WilderBiomeTags.OAK_SAPLINGS_GROW_SWAMP_VARIANT)) {
					info.setReturnValue(WilderTreeConfigured.SWAMP_TREE.getHolder());
					return;
				}
			}
			if (random.nextInt(10) == 0) {
				info.setReturnValue(bees ? WilderTreeConfigured.FANCY_OAK_BEES_0004.getHolder() : WilderTreeConfigured.FANCY_OAK.getHolder());
			} else {
				info.setReturnValue(bees ? WilderTreeConfigured.OAK_BEES_0004.getHolder() : WilderTreeConfigured.OAK.getHolder());
			}
		}
    }

}

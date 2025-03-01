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
import net.frozenblock.wilderwild.world.additions.feature.WilderTreeConfigured;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.SpruceTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = SpruceTreeGrower.class, priority = 69420)
public class SpruceTreeGrowerMixin {

    @Inject(method = "getConfiguredFeature", at = @At("RETURN"), cancellable = true)
    public void wilderWild$getConfiguredFeature(RandomSource random, boolean bees, CallbackInfoReturnable<Holder<? extends ConfiguredFeature<?, ?>>> info) {
		if (WilderSharedConstants.config().wildTrees()) {
			info.setReturnValue(random.nextFloat() < 0.1F ? WilderTreeConfigured.SPRUCE_SHORT.getHolder() : WilderTreeConfigured.SPRUCE.getHolder());
		}
    }

	@Inject(method = "getConfiguredMegaFeature", at = @At("RETURN"), cancellable = true)
	public void wilderWild$getConfiguredMegaFeature(RandomSource random, CallbackInfoReturnable<Holder<? extends ConfiguredFeature<?, ?>>> info) {
		if (WilderSharedConstants.config().wildTrees()) {
			if (random.nextFloat() < 0.25F) {
				info.setReturnValue(WilderTreeConfigured.SHORT_MEGA_SPRUCE.getHolder());
			}
		}
	}

}

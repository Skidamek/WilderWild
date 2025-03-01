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

package net.frozenblock.wilderwild.misc.interfaces;

import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.monster.warden.Warden;

public interface SwimmingWarden {

	default boolean wilderWild$isTouchingWaterOrLava() {
		Warden warden = Warden.class.cast(this);
		return warden.isInWaterOrBubble() || warden.isInLava();
	}

	default boolean wilderWild$isSubmergedInWaterOrLava() {
		Warden warden = Warden.class.cast(this);
		return warden.isEyeInFluid(FluidTags.WATER) || warden.isEyeInFluid(FluidTags.LAVA);
	}

}

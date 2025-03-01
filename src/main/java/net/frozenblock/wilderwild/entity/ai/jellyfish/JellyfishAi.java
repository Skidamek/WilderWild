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

package net.frozenblock.wilderwild.entity.ai.jellyfish;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.mojang.datafixers.util.Pair;
import java.util.List;
import java.util.Optional;
import net.frozenblock.wilderwild.entity.Jellyfish;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.behavior.AnimalPanic;
import net.minecraft.world.entity.ai.behavior.DoNothing;
import net.minecraft.world.entity.ai.behavior.LookAtTargetSink;
import net.minecraft.world.entity.ai.behavior.MoveToTargetSink;
import net.minecraft.world.entity.ai.behavior.RunIf;
import net.minecraft.world.entity.ai.behavior.RunOne;
import net.minecraft.world.entity.ai.behavior.SetEntityLookTarget;
import net.minecraft.world.entity.ai.behavior.SetWalkTargetFromAttackTargetIfTargetOutOfReach;
import net.minecraft.world.entity.ai.behavior.StartAttacking;
import net.minecraft.world.entity.ai.behavior.StopAttackingIfTargetInvalid;
import net.minecraft.world.entity.ai.behavior.TryFindWater;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.minecraft.world.entity.ai.sensing.Sensor;
import net.minecraft.world.entity.ai.sensing.SensorType;
import net.minecraft.world.entity.schedule.Activity;

public class JellyfishAi {

    public static final List<SensorType<? extends Sensor<? super Jellyfish>>> SENSOR_TYPES = List.of(
            SensorType.NEAREST_LIVING_ENTITIES, SensorType.NEAREST_PLAYERS
    );
    public static final List<? extends MemoryModuleType<?>> MEMORY_TYPES = List.of(
            MemoryModuleType.NEAREST_VISIBLE_LIVING_ENTITIES,
            MemoryModuleType.LOOK_TARGET,
            MemoryModuleType.WALK_TARGET,
            MemoryModuleType.CANT_REACH_WALK_TARGET_SINCE,
            MemoryModuleType.PATH,
            MemoryModuleType.ATTACK_TARGET,
            MemoryModuleType.NEAREST_ATTACKABLE,
			MemoryModuleType.IS_PANICKING
    );

    public static Brain<Jellyfish> makeBrain(Jellyfish jellyfish, Brain<Jellyfish> brain) {
        initCoreActivity(brain);
        initIdleActivity(jellyfish, brain);
        initFightActivity(jellyfish, brain);
		brain.setCoreActivities(ImmutableSet.of(Activity.CORE));
		brain.setDefaultActivity(Activity.IDLE);
		brain.useDefaultActivity();
        return brain;
    }

    private static void initCoreActivity(Brain<Jellyfish> brain) {
        brain.addActivity(
                Activity.CORE,
                0,
                ImmutableList.of(
                        new AnimalPanic(2.0F),
                        new LookAtTargetSink(45, 90),
                        new MoveToTargetSink()
                )
        );
    }

    private static void initIdleActivity(Jellyfish jellyfish, Brain<Jellyfish> brain) {
        brain.addActivity(
                Activity.IDLE,
				10,
                ImmutableList.of(
						new StartAttacking<>(JellyfishAi::findNearestValidAttackTarget),
						new TryFindWater(6, 0.15F),
						new RunOne<>(
								ImmutableMap.of(MemoryModuleType.WALK_TARGET, MemoryStatus.VALUE_ABSENT),
								List.of(
										Pair.of(new JellyfishRandomSwim(1.0F), 2),
										Pair.of(new RunIf<>(Entity::isInWaterOrBubble, new DoNothing(30, 60)), 1),
										Pair.of(new RunIf<>(Entity::isOnGround, new DoNothing(200, 400)), 1)
								)
						),
						new JellyfishHide(jellyfish, 1.25D, 8, 3)
				)
        );
    }

    private static void initFightActivity(Jellyfish jellyfish, Brain<Jellyfish> brain) {
        brain.addActivityAndRemoveMemoryWhenStopped(
                Activity.FIGHT,
                10,
                ImmutableList.of(
                        new StopAttackingIfTargetInvalid<>(
                                livingEntity -> !jellyfish.canTargetEntity(livingEntity), JellyfishAi::onTargetInvalid, false
                        ),
                        new SetEntityLookTarget(livingEntity -> isTarget(jellyfish, livingEntity), (float) jellyfish.getAttributeValue(Attributes.FOLLOW_RANGE)),
                        new SetWalkTargetFromAttackTargetIfTargetOutOfReach(JellyfishAi::getSpeedModifierChasing)
                ),
                MemoryModuleType.ATTACK_TARGET
        );
    }

    private static boolean isTarget(Jellyfish jellyfish, LivingEntity livingEntity) {
        return jellyfish.getBrain().getMemory(MemoryModuleType.ATTACK_TARGET).filter(livingEntity2 -> livingEntity2 == livingEntity).isPresent();
    }

    public static void updateActivity(Jellyfish jellyfish) {
        Brain<Jellyfish> brain = jellyfish.getBrain();
        brain.setActiveActivityToFirstValid(List.of(Activity.FIGHT, Activity.IDLE));
    }

    private static float getSpeedModifierChasing(LivingEntity livingEntity) {
		return 2F;
    }

    private static void onTargetInvalid(Jellyfish jellyfish, LivingEntity target) {
        if (jellyfish.getTarget() == target) {
            jellyfish.getBrain().eraseMemory(MemoryModuleType.ATTACK_TARGET);
        }
    }

    private static Optional<? extends LivingEntity> findNearestValidAttackTarget(Jellyfish jellyfish) {
        return jellyfish.getBrain().getMemory(MemoryModuleType.NEAREST_ATTACKABLE);
    }
}

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

package net.frozenblock.wilderwild.entity.render.feature;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import java.util.List;
import net.frozenblock.wilderwild.entity.render.animations.WilderWarden;
import net.minecraft.client.model.WardenModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.WardenEmissiveLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.warden.Warden;
import org.jetbrains.annotations.NotNull;

public class StellaWardenFeatureRenderer<T extends Warden, M extends WardenModel<T>> extends WardenEmissiveLayer<T, M> {
    public StellaWardenFeatureRenderer(RenderLayerParent<T, M> context, ResourceLocation texture, AlphaFunction<T> animationAngleAdjuster, DrawSelector<T, M> modelPartVisibility) {
        super(context, texture, animationAngleAdjuster, modelPartVisibility);
    }

    @Override
    public void render(@NotNull PoseStack matrixStack, @NotNull MultiBufferSource vertexConsumerProvider, int i, T wardenEntity, float f, float g, float partialTick, float j, float k, float l) {
        if (!wardenEntity.isInvisible() && ((WilderWarden) wardenEntity).wilderWild$isStella()) {
            this.onlyDrawSelectedParts();
            VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(RenderType.entityTranslucentEmissive(this.texture));
            this.getParentModel()
                    .renderToBuffer(
                            matrixStack,
                            vertexConsumer,
                            i,
                            LivingEntityRenderer.getOverlayCoords(wardenEntity, 0.0F),
                            1.0F,
                            1.0F,
                            1.0F,
                            this.alphaFunction.apply(wardenEntity, partialTick, j)
                    );
            this.resetDrawForAllParts();
        }
    }

    private void onlyDrawSelectedParts() {
        List<ModelPart> list = this.drawSelector.getPartsToDraw(this.getParentModel());
        this.getParentModel().root().getAllParts().forEach(part -> part.skipDraw = true);
        list.forEach(part -> part.skipDraw = false);
    }

    private void resetDrawForAllParts() {
        this.getParentModel().root().getAllParts().forEach(part -> part.skipDraw = false);
    }
}

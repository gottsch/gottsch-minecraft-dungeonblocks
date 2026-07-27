/*
 * This file is part of  DungeonBlocks.
 * Copyright (c) 2026 Mark Gottschling (gottsch)
 *
 * DungeonBlocks is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * DungeonBlocks is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with DungeonBlocks.  If not, see <http://www.gnu.org/licenses/lgpl>.
 */
package mod.gottsch.forge.dungeonblocks.core.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import mod.gottsch.forge.dungeonblocks.core.entity.PotEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

/**
 * Shared renderer for every pot-shaped prop: the tumble pivot and the
 * Blockbench root-pivot transform are identical across shapes, only the model,
 * texture and modeled height differ — so each registered pot {@code EntityType}
 * supplies those three and reuses this class (see {@code ClientSetup}).
 *
 * @author Mark Gottschling on Jul 25, 2026
 */
public class PotRenderer extends EntityRenderer<PotEntity> {

	private final EntityModel<PotEntity> model;
	private final ResourceLocation texture;
	/**
	 * Height of the pivot the tumble rotates about — half the pot's <em>width</em>, so a fully
	 * tipped pot comes to rest with its body on the floor. See {@link PotVariant#tumblePivot()}.
	 */
	private final double tumblePivot;

	public PotRenderer(EntityRendererProvider.Context context, EntityModel<PotEntity> model,
			ResourceLocation texture, double tumblePivot) {
		super(context);
		this.model = model;
		this.texture = texture;
		this.tumblePivot = tumblePivot;
	}

	@Override
	public ResourceLocation getTextureLocation(PotEntity entity) {
		return this.texture;
	}

	@Override
	public void render(PotEntity entity, float entityYaw, float partialTicks, PoseStack poseStack,
			MultiBufferSource buffer, int packedLight) {
		poseStack.pushPose();
		poseStack.mulPose(Axis.YP.rotationDegrees(180.0F - entityYaw));

		float tumbleProgress = entity.getTumbleProgress(partialTicks);
		if (tumbleProgress > 0.0F) {
			float tipSign = (entity.getId() % 2 == 0) ? 1.0F : -1.0F;
			poseStack.translate(0.0D, this.tumblePivot, 0.0D);
			poseStack.mulPose(Axis.ZP.rotationDegrees(90.0F * tipSign * tumbleProgress));
			poseStack.translate(0.0D, -this.tumblePivot, 0.0D);
		}

		// mirror + drop to match the Blockbench-exported PartPose.offset(0, 24, 0) root pivot
		// convention (the same transform LivingEntityRenderer applies for vanilla mob models).
		poseStack.scale(-1.0F, -1.0F, 1.0F);
		poseStack.translate(0.0D, -1.501D, 0.0D);

		RenderType renderType = this.model.renderType(this.getTextureLocation(entity));
		VertexConsumer vertexConsumer = buffer.getBuffer(renderType);
		this.model.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY,
				1.0F, 1.0F, 1.0F, 1.0F);
		poseStack.popPose();
		super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
	}
}

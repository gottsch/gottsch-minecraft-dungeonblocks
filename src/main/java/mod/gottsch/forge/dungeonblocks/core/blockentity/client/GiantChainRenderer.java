/*
 * This file is part of  DungeonBlocks.
 * Copyright (c) 2026 Mark Gottschling (gottsch)
 *
 * All rights reserved.
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
package mod.gottsch.forge.dungeonblocks.core.blockentity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import mod.gottsch.forge.dungeonblocks.DungeonBlocks;
import mod.gottsch.forge.dungeonblocks.core.blockentity.GiantChainAnchorBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.block.ModelBlockRenderer;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.client.model.data.ModelData;
import net.minecraftforge.event.level.LevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.joml.Quaternionf;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Draws every giant chain, straight and taut from the centre of one anchor to the centre of another,
 * as one link model repeated along the line with every other link turned a quarter about it so
 * they interlock.
 *
 * <p><b>Not a block entity renderer.</b> A block entity renderer is culled by its block's bounding
 * box and dropped past 64 blocks, and a chain is up to 32 long at any angle; it would vanish as its
 * anchor left the screen. This is Claim My Land's border renderer instead: one pass over a client
 * list of loaded anchors at {@code RenderLevelStageEvent}, each link tested against the view frustum,
 * so a long chain costs only what is on screen. Both ends join the list, so a chain is drawn while
 * either is loaded: its start draws it, and its end only while the start is not in the list.
 *
 * <p><b>The stage.</b> {@code AFTER_BLOCK_ENTITIES}, not Claim My Land's
 * {@code AFTER_TRANSLUCENT_BLOCKS}: that suits an overlay, but solid iron drawn after the
 * translucent pass would show in front of the glass or water it is behind. The batch is ended here,
 * since the level ended its own block entity batches just before this stage.
 *
 * <p><b>Light.</b> Sampled per link, as the swinging chain does per segment: a chain can run from a
 * lit hall into a dark shaft. Drawn into the entity cutout sheet, lit by each face's normal, as the
 * swinging chain's links are.
 *
 * @author Mark Gottschling on 11/03/2026
 */
@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = DungeonBlocks.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class GiantChainRenderer {
    /** The link, 16px long and 10 wide, its bar 3px square, lying along y through the block's centre. */
    public static final ResourceLocation LINK_MODEL = new ResourceLocation(DungeonBlocks.MOD_ID, "block/giant_chain_link");

    /** Link to link: the inside length of a link, so each one's end bar sits in the next one's eye. */
    private static final double PITCH = 10.0 / 16.0;
    /** Past this the links are a few pixels wide, and not worth their draw. */
    private static final double MAX_DISTANCE = 128.0;

    /** The anchors loaded on the client, kept by their block entities. */
    private static final Set<BlockPos> ANCHORS = new HashSet<>();

    public static void add(BlockPos pos) {
        ANCHORS.add(pos.immutable());
    }

    public static void remove(BlockPos pos) {
        ANCHORS.remove(pos);
    }

    @SubscribeEvent
    public static void onLevelUnload(LevelEvent.Unload event) {
        if (event.getLevel().isClientSide()) {
            ANCHORS.clear();
        }
    }

    @SubscribeEvent
    public static void onRenderLevelStage(RenderLevelStageEvent event) {
        if (event.getStage() != RenderLevelStageEvent.Stage.AFTER_BLOCK_ENTITIES || ANCHORS.isEmpty()) {
            return;
        }
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel level = minecraft.level;
        if (level == null) {
            return;
        }
        BakedModel link = minecraft.getModelManager().getModel(LINK_MODEL);
        ModelBlockRenderer renderer = minecraft.getBlockRenderer().getModelRenderer();
        MultiBufferSource.BufferSource buffers = minecraft.renderBuffers().bufferSource();
        VertexConsumer consumer = buffers.getBuffer(Sheets.cutoutBlockSheet());
        Vec3 camera = event.getCamera().getPosition();
        Frustum frustum = event.getFrustum();
        PoseStack poseStack = event.getPoseStack();

        Iterator<BlockPos> iterator = ANCHORS.iterator();
        while (iterator.hasNext()) {
            BlockPos pos = iterator.next();
            // a missed unload must not leave a chain hanging in the air
            if (!(level.getBlockEntity(pos) instanceof GiantChainAnchorBlockEntity anchor) || anchor.isRemoved()) {
                iterator.remove();
                continue;
            }
            BlockPos target = anchor.getTarget();
            // a chain to an anchor that is known to be gone is not drawn; one into unloaded ground is
            if (target != null && (!level.isLoaded(target) || level.getBlockEntity(target) instanceof GiantChainAnchorBlockEntity)) {
                drawChain(level, poseStack, consumer, renderer, link, frustum, camera, pos, target);
            }
            for (BlockPos source : anchor.getSources()) {
                if (!ANCHORS.contains(source)) {
                    drawChain(level, poseStack, consumer, renderer, link, frustum, camera, source, pos);
                }
            }
        }
        buffers.endBatch(Sheets.cutoutBlockSheet());
    }

    private static void drawChain(ClientLevel level, PoseStack poseStack, VertexConsumer consumer, ModelBlockRenderer renderer,
                                  BakedModel link, Frustum frustum, Vec3 camera, BlockPos from, BlockPos to) {
        Vec3 start = from.getCenter();
        Vec3 end = to.getCenter();
        AABB whole = new AABB(start, end).inflate(0.5);
        if (!frustum.isVisible(whole)) {
            return;
        }
        Vec3 line = end.subtract(start);
        double length = line.length();
        // evenly spaced, so that a link sits at the centre of each anchor, hidden in its plate
        int links = Math.max(1, (int) Math.round(length / PITCH));
        double step = length / links;
        Vec3 direction = line.scale(1.0 / length);
        // the turn that lays the model's y along the chain, the same for every link
        Quaternionf along = new Quaternionf().rotationTo(0.0F, 1.0F, 0.0F,
                (float) direction.x, (float) direction.y, (float) direction.z);
        BlockPos.MutableBlockPos lightPos = new BlockPos.MutableBlockPos();

        for (int i = 0; i <= links; i++) {
            Vec3 centre = start.add(direction.scale(step * i));
            if (centre.distanceToSqr(camera) > MAX_DISTANCE * MAX_DISTANCE
                    || !frustum.isVisible(new AABB(centre, centre).inflate(0.5))) {
                continue;
            }
            poseStack.pushPose();
            poseStack.translate(centre.x - camera.x, centre.y - camera.y, centre.z - camera.z);
            poseStack.mulPose(along);
            if (i % 2 == 1) {
                poseStack.mulPose(Axis.YP.rotationDegrees(90.0F));
            }
            poseStack.translate(-0.5, -0.5, -0.5);
            renderer.renderModel(poseStack.last(), consumer, null, link, 1.0F, 1.0F, 1.0F,
                    light(level, lightPos, centre, direction, i < links / 2.0 ? 1 : -1),
                    OverlayTexture.NO_OVERLAY, ModelData.EMPTY, RenderType.cutout());
            poseStack.popPose();
        }
    }

    /**
     * The light where the link is. A link whose centre is inside a solid block - the anchor, or a
     * wall the chain passes through - would come out black, so it takes the light half a block
     * further along, towards the middle of the chain.
     */
    private static int light(ClientLevel level, BlockPos.MutableBlockPos pos, Vec3 centre, Vec3 direction, int inwards) {
        pos.set(centre.x, centre.y, centre.z);
        if (level.getBlockState(pos).isSolidRender(level, pos)) {
            Vec3 next = centre.add(direction.scale(0.5 * inwards));
            pos.set(next.x, next.y, next.z);
        }
        return LevelRenderer.getLightColor(level, pos);
    }
}

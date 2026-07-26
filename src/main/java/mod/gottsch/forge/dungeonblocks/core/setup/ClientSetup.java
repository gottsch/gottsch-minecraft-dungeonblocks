package mod.gottsch.forge.dungeonblocks.core.setup;

import mod.gottsch.forge.dungeonblocks.DungeonBlocks;
import mod.gottsch.forge.dungeonblocks.core.block.ModBlocks;
import mod.gottsch.forge.dungeonblocks.core.entity.ModEntityTypes;
import mod.gottsch.forge.dungeonblocks.core.entity.client.PotItemRenderer;
import mod.gottsch.forge.dungeonblocks.core.entity.client.PotModel;
import mod.gottsch.forge.dungeonblocks.core.entity.client.PotRenderer;
import mod.gottsch.forge.dungeonblocks.core.entity.client.PotShardModel;
import mod.gottsch.forge.dungeonblocks.core.entity.client.PotShardRenderer;
import mod.gottsch.forge.dungeonblocks.core.entity.client.PotVariant;
import mod.gottsch.forge.dungeonblocks.core.entity.client.SquatClayPotModel;
import mod.gottsch.forge.dungeonblocks.core.entity.client.ThinClayPotModel;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = DungeonBlocks.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {

    /**
     * The pot shapes, declared once. Layer definitions, the in-world entity renderers and the 3D
     * inventory renderer all read this list, so a new pot shape is one entry here plus its model
     * class — nothing else on the client side needs touching.
     *
     * <p>The float is the total modeled height in blocks (base + neck + lip): 14px, 10px and 12px
     * respectively.
     */
    private static final List<PotVariant> POT_VARIANTS = List.of(
            new PotVariant(ModEntityTypes.POT, PotModel.LAYER_LOCATION, PotModel::new,
                    PotVariant.entityTexture("pot"), 0.875F),
            new PotVariant(ModEntityTypes.SQUAT_CLAY_POT, SquatClayPotModel.LAYER_LOCATION, SquatClayPotModel::new,
                    PotVariant.entityTexture("squat_clay_pot"), 0.625F),
            new PotVariant(ModEntityTypes.THIN_CLAY_POT, ThinClayPotModel.LAYER_LOCATION, ThinClayPotModel::new,
                    PotVariant.entityTexture("thin_clay_pot"), 0.75F));

    /**
     * Register the {@link IBlockColor} handlers.
     *
     * @param event The event
     */
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
        event.register(
                (state, reader, pos, color) -> {
                    return (reader != null && pos != null) ? BiomeColors.getAverageWaterColor(reader, pos)  : 0;
                },
                ModBlocks.WEATHERED_COPPER_SEWER.get(),
                ModBlocks.TERRACOTTA_SEWER.get());
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(PotModel.LAYER_LOCATION, PotModel::createBodyLayer);
        event.registerLayerDefinition(SquatClayPotModel.LAYER_LOCATION, SquatClayPotModel::createBodyLayer);
        event.registerLayerDefinition(ThinClayPotModel.LAYER_LOCATION, ThinClayPotModel::createBodyLayer);
        // hand the shape table to the inventory renderer now that the layers exist
        PotItemRenderer.setVariants(POT_VARIANTS);
        for (int i = 0; i < PotShardModel.LAYERS.length; i++) {
            int variant = i;
            event.registerLayerDefinition(PotShardModel.LAYERS[variant], () -> PotShardModel.createBodyLayer(variant));
        }
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        // PotRenderer is shape-agnostic: each variant supplies its model, texture and the
        // half-height used as the tumble pivot.
        POT_VARIANTS.forEach(variant ->
                event.registerEntityRenderer(variant.entityType().get(),
                        context -> new PotRenderer(context,
                                variant.modelFactory().apply(context.bakeLayer(variant.layer())),
                                variant.texture(), variant.halfHeight())));
        event.registerEntityRenderer(ModEntityTypes.POT_SHARD.get(), PotShardRenderer::new);
    }
}

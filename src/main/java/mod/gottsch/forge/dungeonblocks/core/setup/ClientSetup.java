package mod.gottsch.forge.dungeonblocks.core.setup;

import mod.gottsch.forge.dungeonblocks.DungeonBlocks;
import mod.gottsch.forge.dungeonblocks.core.block.ModBlocks;
import mod.gottsch.forge.dungeonblocks.core.entity.ModEntityTypes;
import mod.gottsch.forge.dungeonblocks.core.entity.client.PotModel;
import mod.gottsch.forge.dungeonblocks.core.entity.client.PotRenderer;
import mod.gottsch.forge.dungeonblocks.core.entity.client.PotShardModel;
import mod.gottsch.forge.dungeonblocks.core.entity.client.PotShardRenderer;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DungeonBlocks.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {

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
        for (int i = 0; i < PotShardModel.LAYERS.length; i++) {
            int variant = i;
            event.registerLayerDefinition(PotShardModel.LAYERS[variant], () -> PotShardModel.createBodyLayer(variant));
        }
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntityTypes.POT.get(), PotRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.POT_SHARD.get(), PotShardRenderer::new);
    }
}

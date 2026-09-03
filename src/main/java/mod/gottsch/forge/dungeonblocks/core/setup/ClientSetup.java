package mod.gottsch.forge.dungeonblocks.core.setup;

import mod.gottsch.forge.dungeonblocks.DungeonBlocks;
import mod.gottsch.forge.dungeonblocks.core.block.ModBlocks;
import mod.gottsch.forge.dungeonblocks.core.blockentity.ModBlockEntityTypes;
import mod.gottsch.forge.dungeonblocks.core.blockentity.client.SwingingChainRenderer;
import mod.gottsch.forge.dungeonblocks.core.entity.ModEntityTypes;
import mod.gottsch.forge.dungeonblocks.core.entity.client.BigRedPotionModel;
import mod.gottsch.forge.dungeonblocks.core.entity.client.PotItemRenderer;
import mod.gottsch.forge.dungeonblocks.core.entity.client.PotModel;
import mod.gottsch.forge.dungeonblocks.core.entity.client.PotRenderer;
import mod.gottsch.forge.dungeonblocks.core.entity.client.PotShardModel;
import mod.gottsch.forge.dungeonblocks.core.entity.client.PotShardRenderer;
import mod.gottsch.forge.dungeonblocks.core.entity.client.PotVariant;
import mod.gottsch.forge.dungeonblocks.core.entity.client.RedFlaskModel;
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
    // heights and widths are the modeled extents in blocks: 14x8, 10x10 and 12x6 pixels.
    // The stone set reuses the terracotta set's geometry outright — a material is purely a
    // reskin, so it is three more entries here against the same three layers, no new model class.
    private static final List<PotVariant> POT_VARIANTS = List.of(
            new PotVariant(ModEntityTypes.POT, PotModel.LAYER_LOCATION, PotModel::new,
                    PotVariant.entityTexture("pot"), 0.875F, 0.5F),
            new PotVariant(ModEntityTypes.SQUAT_CLAY_POT, SquatClayPotModel.LAYER_LOCATION, SquatClayPotModel::new,
                    PotVariant.entityTexture("squat_clay_pot"), 0.625F, 0.625F),
            new PotVariant(ModEntityTypes.THIN_CLAY_POT, ThinClayPotModel.LAYER_LOCATION, ThinClayPotModel::new,
                    PotVariant.entityTexture("thin_clay_pot"), 0.75F, 0.375F),
            new PotVariant(ModEntityTypes.STONE_POT, PotModel.LAYER_LOCATION, PotModel::new,
                    PotVariant.entityTexture("stone_pot"), 0.875F, 0.5F),
            new PotVariant(ModEntityTypes.SQUAT_STONE_POT, SquatClayPotModel.LAYER_LOCATION, SquatClayPotModel::new,
                    PotVariant.entityTexture("squat_stone_pot"), 0.625F, 0.625F),
            new PotVariant(ModEntityTypes.THIN_STONE_POT, ThinClayPotModel.LAYER_LOCATION, ThinClayPotModel::new,
                    PotVariant.entityTexture("thin_stone_pot"), 0.75F, 0.375F),
            new PotVariant(ModEntityTypes.RED_POT, PotModel.LAYER_LOCATION, PotModel::new,
                    PotVariant.entityTexture("red_pot"), 0.875F, 0.5F),
            new PotVariant(ModEntityTypes.SQUAT_RED_POT, SquatClayPotModel.LAYER_LOCATION, SquatClayPotModel::new,
                    PotVariant.entityTexture("squat_red_pot"), 0.625F, 0.625F),
            new PotVariant(ModEntityTypes.THIN_RED_POT, ThinClayPotModel.LAYER_LOCATION, ThinClayPotModel::new,
                    PotVariant.entityTexture("thin_red_pot"), 0.75F, 0.375F),
            new PotVariant(ModEntityTypes.BLUE_POT, PotModel.LAYER_LOCATION, PotModel::new,
                    PotVariant.entityTexture("blue_pot"), 0.875F, 0.5F),
            new PotVariant(ModEntityTypes.SQUAT_BLUE_POT, SquatClayPotModel.LAYER_LOCATION, SquatClayPotModel::new,
                    PotVariant.entityTexture("squat_blue_pot"), 0.625F, 0.625F),
            new PotVariant(ModEntityTypes.THIN_BLUE_POT, ThinClayPotModel.LAYER_LOCATION, ThinClayPotModel::new,
                    PotVariant.entityTexture("thin_blue_pot"), 0.75F, 0.375F),
            // modeled at tall-pot size and halved at render time rather than re-modeled
            new PotVariant(ModEntityTypes.BIG_RED_POTION, BigRedPotionModel.LAYER_LOCATION, BigRedPotionModel::new,
                    PotVariant.entityTexture("big_red_potion"), 0.875F, 0.5F, 0.5F),
            new PotVariant(ModEntityTypes.RED_FLASK, RedFlaskModel.LAYER_LOCATION, RedFlaskModel::new,
                    PotVariant.entityTexture("red_flask"), 0.8125F, 0.4375F, 0.5F),
            // same geometry as the red potion set, reskinned - see ModEntityTypes for the colour list
            new PotVariant(ModEntityTypes.BIG_YELLOW_POTION, BigRedPotionModel.LAYER_LOCATION, BigRedPotionModel::new,
                    PotVariant.entityTexture("big_yellow_potion"), 0.875F, 0.5F, 0.5F),
            new PotVariant(ModEntityTypes.YELLOW_FLASK, RedFlaskModel.LAYER_LOCATION, RedFlaskModel::new,
                    PotVariant.entityTexture("yellow_flask"), 0.8125F, 0.4375F, 0.5F),
            new PotVariant(ModEntityTypes.BIG_BLUE_POTION, BigRedPotionModel.LAYER_LOCATION, BigRedPotionModel::new,
                    PotVariant.entityTexture("big_blue_potion"), 0.875F, 0.5F, 0.5F),
            new PotVariant(ModEntityTypes.BLUE_FLASK, RedFlaskModel.LAYER_LOCATION, RedFlaskModel::new,
                    PotVariant.entityTexture("blue_flask"), 0.8125F, 0.4375F, 0.5F),
            new PotVariant(ModEntityTypes.BIG_GREEN_POTION, BigRedPotionModel.LAYER_LOCATION, BigRedPotionModel::new,
                    PotVariant.entityTexture("big_green_potion"), 0.875F, 0.5F, 0.5F),
            new PotVariant(ModEntityTypes.GREEN_FLASK, RedFlaskModel.LAYER_LOCATION, RedFlaskModel::new,
                    PotVariant.entityTexture("green_flask"), 0.8125F, 0.4375F, 0.5F));

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
        event.registerLayerDefinition(BigRedPotionModel.LAYER_LOCATION, BigRedPotionModel::createBodyLayer);
        event.registerLayerDefinition(RedFlaskModel.LAYER_LOCATION, RedFlaskModel::createBodyLayer);
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
        // PotRenderer is shape-agnostic: each variant supplies its model, texture and tumble pivot.
        POT_VARIANTS.forEach(variant ->
                event.registerEntityRenderer(variant.entityType().get(),
                        context -> new PotRenderer(context,
                                variant.modelFactory().apply(context.bakeLayer(variant.layer())),
                                variant.texture(), variant.tumblePivot(), variant.scale())));
        event.registerEntityRenderer(ModEntityTypes.POT_SHARD.get(), PotShardRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntityTypes.SWINGING_CHAIN.get(), SwingingChainRenderer::new);
    }
}

package mod.gottsch.forge.dungeonblocks.datagen;

import mod.gottsch.forge.dungeonblocks.core.block.ModBlocks;
import mod.gottsch.forge.dungeonblocks.DungeonBlocks;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

/**
 *
 */
public class ModBlockStateProvider extends BlockStateProvider {
    private static EnumProperty<Direction> FACING = EnumProperty.create("facing", Direction.class);
    private static EnumProperty<Direction> BASE = EnumProperty.create("base", Direction.class);
    private static final int DEFAULT_ANGLE_OFFSET = 180;

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, DungeonBlocks.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        barredWindowBlock(ModBlocks.STONE_BARRED_WINDOW, mcLoc("block/stone"));
        barredWindowBlock(ModBlocks.SMOOTH_STONE_BARRED_WINDOW, mcLoc("block/smooth_stone"));
        barredWindowBlock(ModBlocks.COBBLESTONE_BARRED_WINDOW, mcLoc("block/cobblestone"));
        barredWindowBlock(ModBlocks.MOSSY_COBBLESTONE_BARRED_WINDOW, mcLoc("block/mossy_cobblestone"));
        barredWindowBlock(ModBlocks.BRICKS_BARRED_WINDOW, mcLoc("block/bricks"));
        barredWindowBlock(ModBlocks.STONE_BRICKS_BARRED_WINDOW, mcLoc("block/stone_bricks"));
        barredWindowBlock(ModBlocks.MOSSY_STONE_BRICKS_BARRED_WINDOW, mcLoc("block/mossy_stone_bricks"));
        barredWindowBlock(ModBlocks.CRACKED_STONE_BRICKS_BARRED_WINDOW, mcLoc("block/cracked_stone_bricks"));
        barredWindowBlock(ModBlocks.CHISELED_STONE_BRICKS_BARRED_WINDOW, mcLoc("block/chiseled_stone_bricks"));
        barredWindowBlock(ModBlocks.OBSIDIAN_BARRED_WINDOW, mcLoc("block/obsidian"));

        barredWindowBlock(ModBlocks.SANDSTONE_BARRED_WINDOW, mcLoc("block/sandstone"));
        barredWindowBlock(ModBlocks.SMOOTH_SANDSTONE_BARRED_WINDOW, mcLoc("block/sandstone_top"));
        barredWindowBlock(ModBlocks.CHISELED_SANDSTONE_BARRED_WINDOW, mcLoc("block/chiseled_sandstone"));
        barredWindowBlock(ModBlocks.CUT_SANDSTONE_BARRED_WINDOW, mcLoc("block/cut_sandstone"));

        barredWindowBlock(ModBlocks.RED_SANDSTONE_BARRED_WINDOW, mcLoc("block/red_sandstone"));
        barredWindowBlock(ModBlocks.SMOOTH_RED_SANDSTONE_BARRED_WINDOW, mcLoc("block/red_sandstone_top"));
        barredWindowBlock(ModBlocks.CHISELED_RED_SANDSTONE_BARRED_WINDOW, mcLoc("block/chiseled_red_sandstone"));
        barredWindowBlock(ModBlocks.CUT_RED_SANDSTONE_BARRED_WINDOW, mcLoc("block/cut_red_sandstone"));

        barredWindowBlock(ModBlocks.TERRACOTTA_BARRED_WINDOW, mcLoc("block/terracotta"));

        barredWindowFacadeBlock(ModBlocks.STONE_BARRED_WINDOW_FACADE, mcLoc("block/stone"));
        barredWindowFacadeBlock(ModBlocks.SMOOTH_STONE_BARRED_WINDOW_FACADE, mcLoc("block/smooth_stone"));
        barredWindowFacadeBlock(ModBlocks.COBBLESTONE_BARRED_WINDOW_FACADE, mcLoc("block/cobblestone"));
        barredWindowFacadeBlock(ModBlocks.MOSSY_COBBLESTONE_BARRED_WINDOW_FACADE, mcLoc("block/mossy_cobblestone"));
        barredWindowFacadeBlock(ModBlocks.BRICKS_BARRED_WINDOW_FACADE, mcLoc("block/bricks"));
        barredWindowFacadeBlock(ModBlocks.STONE_BRICKS_BARRED_WINDOW_FACADE, mcLoc("block/stone_bricks"));
        barredWindowFacadeBlock(ModBlocks.MOSSY_STONE_BRICKS_BARRED_WINDOW_FACADE, mcLoc("block/mossy_stone_bricks"));
        barredWindowFacadeBlock(ModBlocks.CRACKED_STONE_BRICKS_BARRED_WINDOW_FACADE, mcLoc("block/cracked_stone_bricks"));
        barredWindowFacadeBlock(ModBlocks.CHISELED_STONE_BRICKS_BARRED_WINDOW_FACADE, mcLoc("block/chiseled_stone_bricks"));
        barredWindowFacadeBlock(ModBlocks.OBSIDIAN_BARRED_WINDOW_FACADE, mcLoc("block/obsidian"));

        barredWindowFacadeBlock(ModBlocks.SANDSTONE_BARRED_WINDOW_FACADE, mcLoc("block/sandstone"));
        barredWindowFacadeBlock(ModBlocks.SMOOTH_SANDSTONE_BARRED_WINDOW_FACADE, mcLoc("block/sandstone_top"));
        barredWindowFacadeBlock(ModBlocks.CHISELED_SANDSTONE_BARRED_WINDOW_FACADE, mcLoc("block/chiseled_sandstone"));
        barredWindowFacadeBlock(ModBlocks.CUT_SANDSTONE_BARRED_WINDOW_FACADE, mcLoc("block/cut_sandstone"));

        barredWindowFacadeBlock(ModBlocks.RED_SANDSTONE_BARRED_WINDOW_FACADE, mcLoc("block/red_sandstone"));
        barredWindowFacadeBlock(ModBlocks.SMOOTH_RED_SANDSTONE_BARRED_WINDOW_FACADE, mcLoc("block/red_sandstone_top"));
        barredWindowFacadeBlock(ModBlocks.CHISELED_RED_SANDSTONE_BARRED_WINDOW_FACADE, mcLoc("block/chiseled_red_sandstone"));
        barredWindowFacadeBlock(ModBlocks.CUT_RED_SANDSTONE_BARRED_WINDOW_FACADE, mcLoc("block/cut_red_sandstone"));

        barredWindowFacadeBlock(ModBlocks.TERRACOTTA_BARRED_WINDOW_FACADE, mcLoc("block/terracotta"));


        grateBlock(ModBlocks.DARK_IRON_GRATE, modLoc("block/dark_iron"));
        grateBlock(ModBlocks.WEATHERED_COPPER_GRATE, mcLoc("block/weathered_copper"));
        torchSconceBlock(ModBlocks.TORCH_SCONCE);
        wallRingBlock(ModBlocks.WALL_RING);
        largeWallRingBlock(ModBlocks.LARGE_WALL_RING);
        sewerBlock(ModBlocks.WEATHERED_COPPER_SEWER, modLoc("block/weathered_copper_pipe"), mcLoc("block/weathered_copper"));
        sewerBlock(ModBlocks.TERRACOTTA_SEWER, mcLoc("block/terracotta"), mcLoc("block/terracotta"));

        simpleBlock(ModBlocks.STRAW.get(), models().getExistingFile(modLoc(ModelProvider.BLOCK_FOLDER + "/straw_block")));
        // can't do this as many blocks aren't the same ie. facing etc.
//        ModBlocks.MAP.forEach((k, v) -> {
//            switch(k.getId().getPath()) {
//                case "stone" -> barredWindowBlock(k, mcLoc("block/stone"));
//            }
//        });
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
        simpleBlock(blockRegistryObject.get());
    }

    private BlockModelBuilder barredWindow(String name, ResourceLocation texture) {
        return models().singleTexture(name, modLoc(ModelProvider.BLOCK_FOLDER + "/barred_window_block"), "0", texture);
    }

    public void barredWindowBlock(RegistryObject<Block> block, ResourceLocation texture) {
        barredWindowBlock(block.getId().getPath(), block.get(), texture);
    }

    public void barredWindowBlock(String name, Block block, ResourceLocation texture) {
        ModelFile model = barredWindow(name, texture);
        myHorizontalBlock(block, model);
    }

//    private BlockModelBuilder barredWindowFacade(String name, ResourceLocation texture) {
//        return models().singleTexture(name, modLoc(ModelProvider.BLOCK_FOLDER + "/barred_window_facade_block"), "0", texture);
//    }

//    public void barredWindowFacadeBlock(RegistryObject<Block> block, ResourceLocation texture) {
//        barredWindowFacadeBlock(block.getId().getPath(), block.get(), texture);
//    }

    public void barredWindowFacadeBlock(RegistryObject<Block> block, ResourceLocation texture) {
        ModelFile model = models().singleTexture(block.getId().getPath(), modLoc(ModelProvider.BLOCK_FOLDER + "/barred_window_facade_block"), "0", texture);
        myHorizontalBlock(block.get(), model);
    }

    public void torchSconceBlock(RegistryObject<Block> block) {
        ModelFile model = models().getExistingFile(modLoc(ModelProvider.BLOCK_FOLDER + "/torch_sconce_block"));
        myHorizontalBlock(block.get(), model);
    }

    public void wallRingBlock(RegistryObject<Block> block) {
       ModelFile model = models().getExistingFile(modLoc(ModelProvider.BLOCK_FOLDER + "/wall_ring"));
       // TODO get the extended model

       myHorizontalBlock(block.get(), model);
    }

    public void largeWallRingBlock(RegistryObject<Block> block) {
        ModelFile model = models().getExistingFile(modLoc(ModelProvider.BLOCK_FOLDER + "/large_wall_ring"));
        // TODO get the extended model

        myHorizontalBlock(block.get(), model);
    }

    public void grateBlock(RegistryObject<Block> block, ResourceLocation texture) {
        ModelFile model = models().singleTexture(block.getId().getPath(), modLoc(ModelProvider.BLOCK_FOLDER + "/template_grate_block"), "0", texture);
        myDirectionalBlock(block.get(), model);
    }

    public void sewerBlock(RegistryObject<Block> block, ResourceLocation texture, ResourceLocation texture1) {
        ModelFile model = twoTextures(
                block.getId().getPath(),
                modLoc(ModelProvider.BLOCK_FOLDER + "/template_sewer_block"), "0", texture, "1", texture1);

//        ModelFile model = models().singleTexture(block.getId().getPath(), modLoc(ModelProvider.BLOCK_FOLDER + "/template_sewer_block"), "0", texture);
     //        ModelFile model = models().getExistingFile(modLoc(ModelProvider.BLOCK_FOLDER + "/sewer_block"));
        // TODO get the extended model

        myHorizontalBlock(block.get(), model);
    }

    public void myHorizontalBlock(Block block, ModelFile model) {
        myHorizontalBlock(block, model, DEFAULT_ANGLE_OFFSET);
    }

    public void myHorizontalBlock(Block block, ModelFile model, int angleOffset) {
        myHorizontalBlock(block, $ -> model, angleOffset);
    }

    public void myHorizontalBlock(Block block, Function<BlockState, ModelFile> modelFunc) {
        myHorizontalBlock(block, modelFunc, DEFAULT_ANGLE_OFFSET);
    }

    public void myHorizontalBlock(Block block, Function<BlockState, ModelFile> modelFunc, int angleOffset) {
        getVariantBuilder(block)
                .forAllStates(state -> ConfiguredModel.builder()
                        .modelFile(modelFunc.apply(state))
                        .rotationY(((int) state.getValue(FACING).toYRot() + angleOffset) % 360)
                        .build()
                );
    }

    public void myDirectionalBlock(Block block, ModelFile model) {
        myDirectionalBlock(block, model, DEFAULT_ANGLE_OFFSET);
    }

    public void myDirectionalBlock(Block block, ModelFile model, int angleOffset) {
        myDirectionalBlock(block, $ -> model, angleOffset);
    }

    public void myDirectionalBlock(Block block, Function<BlockState, ModelFile> modelFunc) {
        myDirectionalBlock(block, modelFunc, DEFAULT_ANGLE_OFFSET);
    }

    public void myDirectionalBlock(Block block, Function<BlockState, ModelFile> modelFunc, int angleOffset) {
        getVariantBuilder(block)
                .forAllStates(state -> {
                    Direction dir = state.getValue(BASE);
                    return ConfiguredModel.builder()
                            .modelFile(modelFunc.apply(state))
                            .rotationX(dir == Direction.DOWN ? 180 : dir.getAxis().isHorizontal() ? 90 : 0)
                            .rotationY(dir.getAxis().isVertical() ? 0 : (((int) dir.toYRot()) + angleOffset) % 360)
                            .build();
                });
    }

    public BlockModelBuilder twoTextures(String name, ResourceLocation parent,
                                         String textureKey1, ResourceLocation texture1,
                                         String textureKey2, ResourceLocation texture2) {
        return models().withExistingParent(name, parent)
                .texture(textureKey1, texture1)
                .texture(textureKey2, texture2);
    }
}
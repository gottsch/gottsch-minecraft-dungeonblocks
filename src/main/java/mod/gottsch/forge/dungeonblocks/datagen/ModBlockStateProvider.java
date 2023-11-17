package mod.gottsch.forge.dungeonblocks.datagen;

import mod.gottsch.forge.dungeonblocks.core.block.*;
import mod.gottsch.forge.dungeonblocks.DungeonBlocks;
import mod.gottsch.forge.dungeonblocks.core.state.properties.FacadeShape;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
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
        DataGenMaps maps = new DataGenMaps();

        // barred windows
        barredWindowBlock(ModBlocks.STONE_BARRED_WINDOW, maps.t.get(Blocks.STONE));
        barredWindowBlock(ModBlocks.SMOOTH_STONE_BARRED_WINDOW, maps.t.get(Blocks.SMOOTH_STONE));
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

        // keystones
        String name = ModelProvider.BLOCK_FOLDER + "/keystone_block";
        modelSingleTexture(KeystoneBlocks.STONE_KEYSTONE, modLoc(name), mcLoc("block/stone"));
        modelSingleTexture(KeystoneBlocks.SMOOTH_STONE_KEYSTONE, modLoc(name), mcLoc("block/smooth_stone"));
        modelSingleTexture(KeystoneBlocks.COBBLESTONE_KEYSTONE, modLoc(name), mcLoc("block/cobblestone"));
        modelSingleTexture(KeystoneBlocks.MOSSY_COBBLESTONE_KEYSTONE, modLoc(name), mcLoc("block/mossy_cobblestone"));
        modelSingleTexture(KeystoneBlocks.BRICKS_KEYSTONE, modLoc(name), mcLoc("block/bricks"));
        modelSingleTexture(KeystoneBlocks.STONE_BRICKS_KEYSTONE, modLoc(name), mcLoc("block/stone_bricks"));
        modelSingleTexture(KeystoneBlocks.MOSSY_STONE_BRICKS_KEYSTONE, modLoc(name), mcLoc("block/mossy_stone_bricks"));
        modelSingleTexture(KeystoneBlocks.CRACKED_STONE_BRICKS_KEYSTONE, modLoc(name), mcLoc("block/cracked_stone_bricks"));
        modelSingleTexture(KeystoneBlocks.CHISELED_STONE_BRICKS_KEYSTONE, modLoc(name), mcLoc("block/chiseled_stone_bricks"));
        modelSingleTexture(KeystoneBlocks.OBSIDIAN_KEYSTONE, modLoc(name), mcLoc("block/obsidian"));

        modelSingleTexture(KeystoneBlocks.LIGHT_GRAY_CONCRETE_KEYSTONE, modLoc(name), mcLoc("block/light_gray_concrete"));

        modelSingleTexture(KeystoneBlocks.POLISHED_DIORITE_KEYSTONE, modLoc(ModelProvider.BLOCK_FOLDER + "/keystone_block"), mcLoc("block/polished_diorite"));

        name = ModelProvider.BLOCK_FOLDER + "/keystone_slab_block";
        modelSingleTexture(KeystoneBlocks.STONE_KEYSTONE_SLAB, modLoc(name), mcLoc("block/stone"));
        modelSingleTexture(KeystoneBlocks.SMOOTH_STONE_KEYSTONE_SLAB, modLoc(name), mcLoc("block/smooth_stone"));
        modelSingleTexture(KeystoneBlocks.COBBLESTONE_KEYSTONE_SLAB, modLoc(name), mcLoc("block/cobblestone"));
        modelSingleTexture(KeystoneBlocks.MOSSY_COBBLESTONE_KEYSTONE_SLAB, modLoc(name), mcLoc("block/mossy_cobblestone"));
        modelSingleTexture(KeystoneBlocks.BRICKS_KEYSTONE_SLAB, modLoc(name), mcLoc("block/bricks"));
        modelSingleTexture(KeystoneBlocks.STONE_BRICKS_KEYSTONE_SLAB, modLoc(name), mcLoc("block/stone_bricks"));
        modelSingleTexture(KeystoneBlocks.MOSSY_STONE_BRICKS_KEYSTONE_SLAB, modLoc(name), mcLoc("block/mossy_stone_bricks"));
        modelSingleTexture(KeystoneBlocks.CRACKED_STONE_BRICKS_KEYSTONE_SLAB, modLoc(name), mcLoc("block/cracked_stone_bricks"));
        modelSingleTexture(KeystoneBlocks.CHISELED_STONE_BRICKS_KEYSTONE_SLAB, modLoc(name), mcLoc("block/chiseled_stone_bricks"));
        modelSingleTexture(KeystoneBlocks.OBSIDIAN_KEYSTONE_SLAB, modLoc(name), mcLoc("block/obsidian"));

        modelSingleTexture(KeystoneBlocks.LIGHT_GRAY_CONCRETE_KEYSTONE_SLAB, modLoc(name), mcLoc("block/light_gray_concrete"));
        modelSingleTexture(KeystoneBlocks.POLISHED_DIORITE_KEYSTONE_SLAB, modLoc(name), mcLoc("block/polished_diorite"));

        name = ModelProvider.BLOCK_FOLDER + "/ledge_block";
        ledgeBlock(LedgeBlocks.STONE_LEDGE, maps.t.get(Blocks.STONE));
        ledgeBlock(LedgeBlocks.SMOOTH_STONE_LEDGE, maps.t.get(Blocks.SMOOTH_STONE));
        ledgeBlock(LedgeBlocks.COBBLESTONE_LEDGE, maps.t.get(Blocks.COBBLESTONE));
        ledgeBlock(LedgeBlocks.MOSSY_COBBLESTONE_LEDGE, maps.t.get(Blocks.MOSSY_COBBLESTONE));
        ledgeBlock(LedgeBlocks.BRICKS_LEDGE, maps.t.get(Blocks.BRICKS));
        ledgeBlock(LedgeBlocks.STONE_BRICKS_LEDGE, maps.t.get(Blocks.STONE_BRICKS));
        ledgeBlock(LedgeBlocks.MOSSY_STONE_BRICKS_LEDGE, maps.t.get(Blocks.MOSSY_STONE_BRICKS));

        ledgeBlock(LedgeBlocks.LIGHT_GRAY_CONCRETE_LEDGE, maps.t.get(Blocks.LIGHT_GRAY_CONCRETE));
        ledgeBlock(LedgeBlocks.POLISHED_DIORITE_LEDGE, maps.t.get(Blocks.POLISHED_DIORITE));

        name = ModelProvider.BLOCK_FOLDER + "/corbel_block";
        modelSingleTexture(CorbelBlocks.ACACIA_CORBEL, modLoc(name), mcLoc("block/acacia_planks"));
        modelSingleTexture(CorbelBlocks.BIRCH_CORBEL, modLoc(name), mcLoc("block/birch_planks"));
        modelSingleTexture(CorbelBlocks.CHERRY_CORBEL, modLoc(name), mcLoc("block/cherry_planks"));
        modelSingleTexture(CorbelBlocks.DARK_OAK_CORBEL, modLoc(name), mcLoc("block/dark_oak_planks"));
        modelSingleTexture(CorbelBlocks.JUNGLE_CORBEL, modLoc(name), mcLoc("block/jungle_planks"));
        modelSingleTexture(CorbelBlocks.MANGROVE_CORBEL, modLoc(name), mcLoc("block/mangrove_planks"));
        modelSingleTexture(CorbelBlocks.OAK_CORBEL, modLoc(name), mcLoc("block/oak_planks"));
        modelSingleTexture(CorbelBlocks.SPRUCE_CORBEL, modLoc(name), mcLoc("block/spruce_planks"));

        modelSingleTexture(CorbelBlocks.STRIPPED_ACACIA_CORBEL, modLoc(name), mcLoc("block/stripped_acacia_log"));
        modelSingleTexture(CorbelBlocks.STRIPPED_BIRCH_CORBEL, modLoc(name), mcLoc("block/stripped_birch_log"));
        modelSingleTexture(CorbelBlocks.STRIPPED_CHERRY_CORBEL, modLoc(name), mcLoc("block/stripped_cherry_log"));
        modelSingleTexture(CorbelBlocks.STRIPPED_DARK_OAK_CORBEL, modLoc(name), mcLoc("block/stripped_dark_oak_log"));
        modelSingleTexture(CorbelBlocks.STRIPPED_JUNGLE_CORBEL, modLoc(name), mcLoc("block/stripped_jungle_log"));
        modelSingleTexture(CorbelBlocks.STRIPPED_MANGROVE_CORBEL, modLoc(name), mcLoc("block/stripped_mangrove_log"));
        modelSingleTexture(CorbelBlocks.STRIPPED_OAK_CORBEL, modLoc(name), mcLoc("block/stripped_oak_log"));
        modelSingleTexture(CorbelBlocks.STRIPPED_SPRUCE_CORBEL, modLoc(name), mcLoc("block/stripped_spruce_log"));

        grateTrapDoorBlock(ModBlocks.DARK_IRON_GRATE_TRAPDOOR, modLoc("block/dark_iron"), true);
        grateTrapDoorBlock(ModBlocks.WEATHERED_COPPER_GRATE_TRAPDOOR, mcLoc("block/weathered_copper"), true);

        grateBlock(ModBlocks.DARK_IRON_GRATE, modLoc("block/dark_iron"));
        grateBlock(ModBlocks.WEATHERED_COPPER_GRATE, mcLoc("block/weathered_copper"));
        wallRingBlock(ModBlocks.WALL_RING);
        hayPatchBlock(ModBlocks.HAY_PATCH);
        hayPatchBlock(ModBlocks.DIRTY_HAY_PATCH, modLoc("block/dirty_hay"));
        plateBracketBlock(ModBlocks.PLATE_BRACKET_BLOCK);

        sewerBlock(ModBlocks.WEATHERED_COPPER_SEWER, modLoc("block/weathered_copper_pipe"), mcLoc("block/weathered_copper"));
        sewerBlock(ModBlocks.TERRACOTTA_SEWER, mcLoc("block/terracotta"), mcLoc("block/terracotta"));

        // pattern
        greekBlock(ModBlocks.STONE_GREEK_BLOCK, modLoc("block/stone_greek_block"));
        greekBlock(ModBlocks.ANDESITE_GREEK_BLOCK, modLoc("block/andesite_greek_block"));
        greekBlock(ModBlocks.POLISHED_BASALT_GREEK_BLOCK, modLoc("block/polished_basalt_greek_block"));

        // doors
        dungeonDoorBlock((DoorBlock)ModBlocks.SPRUCE_DUNGEON_DOOR.get(), mcLoc("block/spruce_door_bottom"), mcLoc("block/spruce_door_top"));
        dungeonDoorBlock((DoorBlock)ModBlocks.DARK_OAK_DUNGEON_DOOR.get(), mcLoc("block/dark_oak_door_bottom"), mcLoc("block/dark_oak_door_top"));
        dungeonDoorBlock((DoorBlock)ModBlocks.CRIMSON_DUNGEON_DOOR.get(), mcLoc("block/crimson_door_bottom"), mcLoc("block/crimson_door_top"));
        dungeonDoorBlock((DoorBlock)ModBlocks.MANGROVE_DUNGEON_DOOR.get(), mcLoc("block/mangrove_door_bottom"), mcLoc("block/mangrove_door_top"));

        // light source
        torchSconceBlock(ModBlocks.TORCH_SCONCE);
        candleSconceBlock(ModBlocks.CANDLE_SCONCE);
        brazierBlock(ModBlocks.BRAZIER);

        //        simpleBlock(ModBlocks.STRAW.get(), models().getExistingFile(modLoc(ModelProvider.BLOCK_FOLDER + "/straw_block")));
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

    private void modelSingleTexture(RegistryObject<Block> block, ResourceLocation modelName, ResourceLocation texture) {
        ModelFile model = models().singleTexture(block.getId().getPath(), modelName, "0", texture);
        myHorizontalBlock(block.get(), model);
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

    public void barredWindowFacadeBlock(RegistryObject<Block> block, ResourceLocation texture) {
        ModelFile model = models().singleTexture(block.getId().getPath(), modLoc(ModelProvider.BLOCK_FOLDER + "/barred_window_facade_block"), "0", texture);
        myHorizontalBlock(block.get(), model);
    }

    public void dungeonDoorBlock(DoorBlock block, ResourceLocation bottom, ResourceLocation top) {
        String name = key(block).toString();
        dungeonDoorBlock(block, name, bottom, top);
    }

    public void greekBlock(RegistryObject<Block> block, ResourceLocation texture) {
        ModelFile model = models().cubeAll(block.getId().getPath(), texture);
        myHorizontalBlock(block.get(), model);
    }

    public void torchSconceBlock(RegistryObject<Block> block) {
        ModelFile model = models().getExistingFile(modLoc(ModelProvider.BLOCK_FOLDER + "/torch_sconce_block"));
        myHorizontalBlock(block.get(), model);
    }

    public void candleSconceBlock(RegistryObject<Block> block) {
        ModelFile empty = models().getExistingFile(modLoc(ModelProvider.BLOCK_FOLDER + "/candle_sconce_block"));

        ModelFile one_lit = models().getExistingFile(modLoc(ModelProvider.BLOCK_FOLDER + "/candle_sconce_one_candle_lit_block"));
        ModelFile one_unlit = models().getExistingFile(modLoc(ModelProvider.BLOCK_FOLDER + "/candle_sconce_one_candle_block"));

        ModelFile two_lit = models().getExistingFile(modLoc(ModelProvider.BLOCK_FOLDER + "/candle_sconce_two_candles_lit_block"));
        ModelFile two_unlit = models().getExistingFile(modLoc(ModelProvider.BLOCK_FOLDER + "/candle_sconce_two_candles_block"));

        ModelFile three_lit = models().getExistingFile(modLoc(ModelProvider.BLOCK_FOLDER + "/candle_sconce_three_candles_lit_block"));
        ModelFile three_unlit = models().getExistingFile(modLoc(ModelProvider.BLOCK_FOLDER + "/candle_sconce_three_candles_block"));

        myCandleSconceBlock(block.get(), empty, one_lit, one_unlit, two_lit, two_unlit, three_lit, three_unlit);
    }

    public void ledgeBlock(RegistryObject<Block> block, ResourceLocation texture) {
        String name = block.getId().getPath();
        ModelFile ledge = models().withExistingParent(name, "dungeonblocks:block/ledge_block").texture("0", texture);
        ModelFile inner = models().withExistingParent(name + "_inner", "dungeonblocks:block/" + "ledge_block_inner").texture("0", texture);
        ModelFile outer = models().withExistingParent(name + "_outer", "dungeonblocks:block/" + "ledge_block_outer").texture("0", texture);
        ledgeBlock(block.get(), ledge, inner, outer);
    }

    public void ledgeBlock(Block block, ModelFile ledge, ModelFile inner, ModelFile outer) {
        getVariantBuilder(block)
                .forAllStatesExcept(state -> {
                    Direction facing = state.getValue(LedgeBlock.FACING);
                    FacadeShape shape = state.getValue(IFacadeShapeBlock.SHAPE);
                    int yRot = (int) facing.getOpposite().toYRot();
                    if ((facing == Direction.NORTH && (shape == FacadeShape.OUTER_RIGHT || shape == FacadeShape.INNER_LEFT))
                            || (facing == Direction.SOUTH && (shape == FacadeShape.OUTER_LEFT || shape == FacadeShape.INNER_RIGHT))) {
                        yRot += 90; // Left facing stairs are rotated 90 degrees clockwise
                    }

                    return ConfiguredModel.builder()
                            .modelFile(shape == FacadeShape.STRAIGHT ? ledge : shape == FacadeShape.INNER_LEFT || shape == FacadeShape.INNER_RIGHT ? inner : outer)
                            .rotationY(yRot)
                            .uvLock(true)
                            .build();
                }, LedgeBlock.WATERLOGGED, WaterloggedNonCubeFacingBlock.WATERLOGGED, FacadeShapeBlock.WATERLOGGED);
    }

    public void wallRingBlock(RegistryObject<Block> block) {
       ModelFile model = models().getExistingFile(modLoc(ModelProvider.BLOCK_FOLDER + "/wall_ring"));
       ModelFile openModel = models().getExistingFile(modLoc(ModelProvider.BLOCK_FOLDER + "/wall_ring_open"));
       // TODO get the extended model

        // TODO be more like trapdoor. if down, use the extended model, else use normal
        // also, up and down need special case to rotate x:
//       myHorizontalBlock(block.get(), model);
        wallRingBlock(block.get(), model, openModel);
    }

    public void wallRingBlock(Block block, ModelFile ring, ModelFile ringOpen) {
        getVariantBuilder(block).forAllStatesExcept(state -> {
            ModelFile model = ring;
            int xRot = 0;
            int yRot = 0;
            Direction dir = state.getValue(FACING);
            if (dir == Direction.DOWN) {
                model = ringOpen;
                xRot = 90;
            }
            else if (dir == Direction.UP) {
                xRot = -90;
            } else {
                yRot = ((int) state.getValue(FACING).toYRot() + 180) % 360;
            }

            return ConfiguredModel.builder().modelFile(model)
                    .rotationX(xRot)
                    .rotationY(yRot)
                    .build();
        }, WallRingBlock.WATERLOGGED, WaterloggedNonCubeFacingBlock.WATERLOGGED);
    }

    public void plateBracketBlock(RegistryObject<Block> block) {
        ModelFile model = models().getExistingFile(modLoc(ModelProvider.BLOCK_FOLDER + "/plate_bracket_block"));
        allDirectionBlock(block.get(), model);
    }

    public void allDirectionBlock(Block block, ModelFile model) {
        getVariantBuilder(block).forAllStatesExcept(state -> {
            int xRot = 0;
            int yRot = 0;
            Direction dir = state.getValue(FACING);
            if (dir == Direction.DOWN) {
                xRot = 90;
            }
            else if (dir == Direction.UP) {
                xRot = -90;
            } else {
                yRot = ((int) state.getValue(FACING).toYRot() + 180) % 360;
            }
            return ConfiguredModel.builder().modelFile(model)
                    .rotationX(xRot)
                    .rotationY(yRot)
                    .build();
        }, PlateBracketBlock.WATERLOGGED, WaterloggedNonCubeFacingBlock.WATERLOGGED);
    }

    public void hayPatchBlock(RegistryObject<Block> block) {
        ModelFile model = models().getExistingFile(modLoc(ModelProvider.BLOCK_FOLDER + "/hay_patch_block"));
        simpleBlock(block.get(), model);
    }
    public void hayPatchBlock(RegistryObject<Block> block, ResourceLocation texture) {
        ModelFile model = models().getExistingFile(modLoc(ModelProvider.BLOCK_FOLDER + "/dirty_hay_patch_block"));
        simpleBlock(block.get(), model);
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

    public void brazierBlock(RegistryObject<Block> block) {
        ModelFile brazier_lit = models().getExistingFile(modLoc(ModelProvider.BLOCK_FOLDER + "/brazier_lit_block"));
        ModelFile brazier = models().getExistingFile(modLoc(ModelProvider.BLOCK_FOLDER + "/brazier_block"));
        brazierBlock(block.get(), brazier, brazier_lit);
    }

    public void brazierBlock(Block block, ModelFile brazier, ModelFile brazier_lit) {
        getVariantBuilder(block)
                .partialState().with(BrazierBlock.LIT, true).addModels(new ConfiguredModel(brazier_lit))
                .partialState().with(BrazierBlock.LIT, false).addModels(new ConfiguredModel(brazier));
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

    private void myCandleSconceBlock(Block block, ModelFile empty, ModelFile oneLit, ModelFile oneUnlit, ModelFile twoLit, ModelFile twoUnlit, ModelFile threeLit, ModelFile threeUnlit) {
        getVariantBuilder(block).forAllStatesExcept(state -> {
            ModelFile model = empty;
            boolean isLit = state.getValue(SconceBlock.LIT);
            int candles = state.getValue(SconceBlock.CANDLES);
            Direction facing = state.getValue(SconceBlock.FACING);

            if (candles == 0) {
            }
            else if (candles == 1) {
                model = isLit ? oneLit : oneUnlit;
            } else if (candles == 2) {
                model = isLit ? twoLit : twoUnlit;
            } else if (candles == 3) {
                model = isLit ? threeLit : threeUnlit;
            }
            return ConfiguredModel.builder()
                    .modelFile(model)
                    .rotationY((int) facing.getOpposite().toYRot())
                    .uvLock(true)
                    .build();
        }, SconceBlock.WATERLOGGED);
    }

    private void dungeonDoorBlock(DoorBlock block, String baseName, ResourceLocation bottom, ResourceLocation top) {
        ModelFile bottomLeft = doorBottomLeft(baseName + "_bottom_left", bottom, top);
        ModelFile bottomLeftOpen = doorBottomLeftOpen(baseName + "_bottom_left_open", bottom, top);
        ModelFile bottomRight = doorBottomRight(baseName + "_bottom_right", bottom, top);
        ModelFile bottomRightOpen = doorBottomRightOpen(baseName + "_bottom_right_open", bottom, top);
        ModelFile topLeft = doorTopLeft(baseName + "_top_left", bottom, top);
        ModelFile topLeftOpen = doorTopLeftOpen(baseName + "_top_left_open", bottom, top);
        ModelFile topRight = doorTopRight(baseName + "_top_right", bottom, top);
        ModelFile topRightOpen = doorTopRightOpen(baseName + "_top_right_open", bottom, top);
        doorBlock(block, bottomLeft, bottomLeftOpen, bottomRight, bottomRightOpen, topLeft, topLeftOpen, topRight, topRightOpen);
    }

    private BlockModelBuilder door(String name, String model, ResourceLocation bottom, ResourceLocation top) {
        return models().withExistingParent(name,  "dungeonblocks:block/" + model)
                .texture("bottom", bottom)
                .texture("top", top);
    }

    public BlockModelBuilder doorBottomLeft(String name, ResourceLocation bottom, ResourceLocation top) {
        return door(name, "dungeon_door_bottom_left", bottom, top);
    }

    public BlockModelBuilder doorBottomLeftOpen(String name, ResourceLocation bottom, ResourceLocation top) {
        return door(name, "dungeon_door_bottom_left_open", bottom, top);
    }

    public BlockModelBuilder doorBottomRight(String name, ResourceLocation bottom, ResourceLocation top) {
        return door(name, "dungeon_door_bottom_right", bottom, top);
    }

    public BlockModelBuilder doorBottomRightOpen(String name, ResourceLocation bottom, ResourceLocation top) {
        return door(name, "dungeon_door_bottom_right_open", bottom, top);
    }

    public BlockModelBuilder doorTopLeft(String name, ResourceLocation bottom, ResourceLocation top) {
        return door(name, "dungeon_door_top_left", bottom, top);
    }

    public BlockModelBuilder doorTopLeftOpen(String name, ResourceLocation bottom, ResourceLocation top) {
        return door(name, "dungeon_door_top_left_open", bottom, top);
    }

    public BlockModelBuilder doorTopRight(String name, ResourceLocation bottom, ResourceLocation top) {
        return door(name, "dungeon_door_top_right", bottom, top);
    }

    public BlockModelBuilder doorTopRightOpen(String name, ResourceLocation bottom, ResourceLocation top) {
        return door(name, "dungeon_door_top_right_open", bottom, top);
    }

    public void grateTrapDoorBlock(RegistryObject<Block> block, ResourceLocation texture, boolean orientable) {
        myTrapdoorBlockInternal((TrapDoorBlock) block.get(), block.getId().getPath(), texture, orientable);
    }

    private void myTrapdoorBlockInternal(TrapDoorBlock block, String baseName, ResourceLocation texture, boolean orientable) {
        ModelFile bottom = orientable ? myTrapdoorBottom(baseName + "_bottom", texture) : myTrapdoorBottom(baseName + "_bottom", texture);
        ModelFile top = orientable ? myTrapdoorTop(baseName + "_top", texture) : myTrapdoorTop(baseName + "_top", texture);
        ModelFile open = orientable ? myTrapdoorOpen(baseName + "_open", texture) : myTrapdoorOpen(baseName + "_open", texture);
        trapdoorBlock(block, bottom, top, open, orientable);
    }

    public BlockModelBuilder myTrapdoorBottom(String name, ResourceLocation texture) {
        return models().singleTexture(name, modLoc(ModelProvider.BLOCK_FOLDER + "/template_grate_trapdoor_block_bottom"), "1", texture);
    }

    public BlockModelBuilder myTrapdoorTop(String name, ResourceLocation texture) {
        return models().singleTexture(name, modLoc(ModelProvider.BLOCK_FOLDER + "/template_grate_trapdoor_block_top"), "1", texture);
    }

    public BlockModelBuilder myTrapdoorOpen(String name, ResourceLocation texture) {
        return models().singleTexture(name, modLoc(ModelProvider.BLOCK_FOLDER + "/template_grate_trapdoor_block_open"), "1", texture);
    }

    public BlockModelBuilder twoTextures(String name, ResourceLocation parent,
                                         String textureKey1, ResourceLocation texture1,
                                         String textureKey2, ResourceLocation texture2) {
        return models().withExistingParent(name, parent)
                .texture(textureKey1, texture1)
                .texture(textureKey2, texture2);
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }
}
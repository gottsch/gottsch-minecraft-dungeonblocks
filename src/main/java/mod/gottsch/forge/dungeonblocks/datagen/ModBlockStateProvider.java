package mod.gottsch.forge.dungeonblocks.datagen;

import mod.gottsch.forge.dungeonblocks.core.block.*;
import mod.gottsch.forge.dungeonblocks.DungeonBlocks;
import mod.gottsch.forge.dungeonblocks.core.setup.Registration;
import mod.gottsch.forge.dungeonblocks.core.state.properties.FacadeShape;
import mod.gottsch.forge.gottschcore.block.IFacingBlock;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
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

        Registration.BLOCKS.getEntries().stream()
                .filter(b -> {
                    for(String n : maps.names) {
                        if (b.getId().getPath().contains(n)) {
                            return true;
                        }
                    }
                    return false;
                })
                .forEach(b -> {
                    String name = b.getId().getPath();
                    String material;
                    if (name.contains("barred_window_block")) {
                        material = b.getId().getPath().split("_barred_window_block")[0];
                        barredWindowBlock(b, maps.t2.get(material));
                    } else if (name.contains("barred_window_facade")) {
                        material = b.getId().getPath().split("_barred_window_facade_block")[0];
//                        DungeonBlocks.LOGGER.info("barred window facade processing material ->{} to texture ->{} ", material, maps.t2.get(material));
                        barredWindowFacadeBlock(b, maps.t2.get(material));
                    } else if (name.contains("corbel")) {
                        material = b.getId().getPath().split("_corbel_block")[0];
//                        DungeonBlocks.LOGGER.info("corbel processing material ->{} to texture ->{} ", material, maps.t2.get(material));
                        horizontalSingleTexture(b, modLoc(ModelProvider.BLOCK_FOLDER + "/corbel_block"), maps.t2.get(material));
                    } else if (name.contains("double_sill")) {
                        material = b.getId().getPath().split("_double_sill_block")[0];
//                        DungeonBlocks.LOGGER.info("double sill processing material ->{} to texture ->{} ", material, maps.t2.get(material));
                        horizontalSingleTexture(b, modLoc("block/double_sill_block_base"), (ResourceLocation)maps.t2.get(material));
                    } else if (name.contains("sill") && !name.contains("double")) {
                        material = b.getId().getPath().split("_sill_block")[0];
                        horizontalSingleTexture(b, modLoc("block/sill_block_base"), (ResourceLocation)maps.t2.get(material));
                    } else if (name.contains("fluted_facade")) {
                        material = b.getId().getPath().split("_fluted_facade_block")[0];
                        flutedFacadeBlock(b, (ResourceLocation)maps.t2.get(material));
                    } else if (name.contains("fluted") && !name.contains("facade")) {
                        material = b.getId().getPath().split("_fluted_block")[0];
                        simpleSingleTexture(b, modLoc("block/fluted_block_base"), (ResourceLocation)maps.t2.get(material));
                    } else if (name.contains("ledge")) {
                        material = b.getId().getPath().split("_ledge_block")[0];
//                        DungeonBlocks.LOGGER.info("ledge processing material ->{} to texture ->{} ", material, maps.t2.get(material));
                        ledgeBlock(b, maps.t2.get(material));
                    } else if (name.contains("keystone_block")) {
                        material = b.getId().getPath().split("_keystone_block")[0];
                        horizontalSingleTexture(b, modLoc(name), maps.t2.get(material));
                     } else if (name.contains("keystone_slab")) {
                        material = b.getId().getPath().split("_keystone_slab_block")[0];
                        horizontalSingleTexture(b, modLoc(name), maps.t2.get(material));
                    }
                    // else do all the other types
                });

        heavyTrapDoorBlock(ModBlocks.DARK_IRON_HEAVY_TRAPDOOR, modLoc("block/dark_iron"), true);
        heavyTrapDoorBlock(ModBlocks.COPPER_HEAVY_TRAPDOOR, mcLoc("block/copper_block"), true);
        heavyTrapDoorBlock(ModBlocks.EXPOSED_COPPER_HEAVY_TRAPDOOR, mcLoc("block/exposed_copper"), true);
        heavyTrapDoorBlock(ModBlocks.WEATHERED_COPPER_HEAVY_TRAPDOOR, mcLoc("block/weathered_copper"), true);
        heavyTrapDoorBlock(ModBlocks.OXIDIZED_COPPER_HEAVY_TRAPDOOR, mcLoc("block/oxidized_copper"), true);
        
        heavyTrapDoorBlock(ModBlocks.WAXED_COPPER_HEAVY_TRAPDOOR, mcLoc("block/copper_block"), true);
        heavyTrapDoorBlock(ModBlocks.WAXED_EXPOSED_COPPER_HEAVY_TRAPDOOR, mcLoc("block/exposed_copper"), true);
        heavyTrapDoorBlock(ModBlocks.WAXED_WEATHERED_COPPER_HEAVY_TRAPDOOR, mcLoc("block/weathered_copper"), true);
        heavyTrapDoorBlock(ModBlocks.WAXED_OXIDIZED_COPPER_HEAVY_TRAPDOOR, mcLoc("block/oxidized_copper"), true);

        simpleSingleTexture(ModBlocks.COPPER_GRATE, modLoc("block/template_cube_cutout"), modLoc("block/copper_grate"));
        simpleSingleTexture(ModBlocks.EXPOSED_COPPER_GRATE, modLoc("block/template_cube_cutout"), modLoc("block/exposed_copper_grate"));
        simpleSingleTexture(ModBlocks.WEATHERED_COPPER_GRATE, modLoc("block/template_cube_cutout"), modLoc("block/weathered_copper_grate"));
        simpleSingleTexture(ModBlocks.OXIDIZED_COPPER_GRATE, modLoc("block/template_cube_cutout"), modLoc("block/oxidized_copper_grate"));
        simpleSingleTexture(ModBlocks.WAXED_COPPER_GRATE, modLoc("block/template_cube_cutout"), modLoc("block/copper_grate"));
        simpleSingleTexture(ModBlocks.WAXED_EXPOSED_COPPER_GRATE, modLoc("block/template_cube_cutout"), modLoc("block/exposed_copper_grate"));
        simpleSingleTexture(ModBlocks.WAXED_WEATHERED_COPPER_GRATE, modLoc("block/template_cube_cutout"), modLoc("block/weathered_copper_grate"));
        simpleSingleTexture(ModBlocks.WAXED_OXIDIZED_COPPER_GRATE, modLoc("block/template_cube_cutout"), modLoc("block/oxidized_copper_grate"));
        heavyGrateBlock(ModBlocks.DARK_IRON_GRATE, modLoc("block/dark_iron"));

        heavyGrateBlock(ModBlocks.COPPER_HEAVY_GRATE, mcLoc("block/copper_block"));
        heavyGrateBlock(ModBlocks.EXPOSED_COPPER_HEAVY_GRATE, mcLoc("block/exposed_copper"));
        heavyGrateBlock(ModBlocks.WEATHERED_COPPER_HEAVY_GRATE, mcLoc("block/weathered_copper"));
        heavyGrateBlock(ModBlocks.OXIDIZED_COPPER_HEAVY_GRATE, mcLoc("block/oxidized_copper"));
        heavyGrateBlock(ModBlocks.WAXED_COPPER_HEAVY_GRATE, mcLoc("block/copper_block"));
        heavyGrateBlock(ModBlocks.WAXED_EXPOSED_COPPER_HEAVY_GRATE, mcLoc("block/exposed_copper"));
        heavyGrateBlock(ModBlocks.WAXED_WEATHERED_COPPER_HEAVY_GRATE, mcLoc("block/weathered_copper"));
        heavyGrateBlock(ModBlocks.WAXED_OXIDIZED_COPPER_HEAVY_GRATE, mcLoc("block/oxidized_copper"));

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

        simpleBlock(ModBlocks.SQUARE_STONE_BRICK.get());
        simpleBlock(ModBlocks.MOSSY_SQUARE_STONE_BRICK.get());
        rectangleLeftHorizontalBlock(ModBlocks.LEFT_LARGE_STONE_BRICK, ModBlocks.RIGHT_LARGE_STONE_BRICK);
        rectangleRightHorizontalBlock(ModBlocks.RIGHT_LARGE_STONE_BRICK, ModBlocks.LEFT_LARGE_STONE_BRICK);
        simpleBlock(ModBlocks.MOSSY_BRICKS.get());
        simpleBlock(ModBlocks.LARGE_BRICKS.get());
        simpleBlock(ModBlocks.MOSSY_LARGE_BRICKS.get());
        simpleBlock(ModBlocks.SQUARE_BRICK.get());
        simpleBlock(ModBlocks.MOSSY_SQUARE_BRICK.get());
        rectangleLeftHorizontalBlock(ModBlocks.LEFT_LARGE_BRICK, ModBlocks.RIGHT_LARGE_BRICK);
        rectangleRightHorizontalBlock(ModBlocks.RIGHT_LARGE_BRICK, ModBlocks.LEFT_LARGE_BRICK);

    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
        simpleBlock(blockRegistryObject.get());
    }

    private void simpleSingleTexture(RegistryObject<Block> block, ResourceLocation modelName, ResourceLocation texture) {
        ModelFile model = models().singleTexture(block.getId().getPath(), modelName, "0", texture);
        simpleBlock((Block)block.get(), model);
    }

    private void horizontalSingleTexture(RegistryObject<Block> block, ResourceLocation modelName, ResourceLocation texture) {
        ModelFile model = models().singleTexture(block.getId().getPath(), modelName, "0", texture);
        myHorizontalBlock((Block)block.get(), (ModelFile)model);
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

    public void flutedFacadeBlock(RegistryObject<Block> block, ResourceLocation texture) {
        String name = block.getId().getPath();
        ModelFile normal = ((BlockModelBuilder)models().withExistingParent(name, "dungeonblocks:block/fluted_facade_block_base")).texture("0", texture);
        ModelFile inner = ((BlockModelBuilder)models().withExistingParent(name + "_inner", "dungeonblocks:block/fluted_facade_inner_block_base")).texture("0", texture);
        ModelFile outer = ((BlockModelBuilder)models().withExistingParent(name + "_outer", "dungeonblocks:block/fluted_facade_outer_block_base")).texture("0", texture);
        facadeBlock((Block)block.get(), normal, inner, outer);
    }

    public void ledgeBlock(RegistryObject<Block> block, ResourceLocation texture) {
        String name = block.getId().getPath();
        ModelFile ledge = models().withExistingParent(name, "dungeonblocks:block/ledge_block").texture("0", texture);
        ModelFile inner = models().withExistingParent(name + "_inner", "dungeonblocks:block/" + "ledge_block_inner").texture("0", texture);
        ModelFile outer = models().withExistingParent(name + "_outer", "dungeonblocks:block/" + "ledge_block_outer").texture("0", texture);
        facadeBlock(block.get(), ledge, inner, outer);
    }

    public void facadeBlock(Block block, ModelFile normal, ModelFile inner, ModelFile outer) {
        getVariantBuilder(block).forAllStatesExcept((state) -> {
            Direction facing = (Direction)state.getValue(IFacingBlock.FACING);
            FacadeShape shape = (FacadeShape)state.getValue(IFacadeShapeBlock.SHAPE);
            int yRot = (int)facing.getOpposite().toYRot();
            if (facing == Direction.NORTH && (shape == FacadeShape.OUTER_RIGHT || shape == FacadeShape.INNER_LEFT) || facing == Direction.SOUTH && (shape == FacadeShape.OUTER_LEFT || shape == FacadeShape.INNER_RIGHT)) {
                yRot += 90;
            }

            return ConfiguredModel.builder().modelFile(shape == FacadeShape.STRAIGHT ? normal : (shape != FacadeShape.INNER_LEFT && shape != FacadeShape.INNER_RIGHT ? outer : inner)).rotationY(yRot).uvLock(true).build();
        }, new Property[]{WaterloggedNonCubeFacingBlock.WATERLOGGED, FacadeShapeBlock.WATERLOGGED});
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

    public void heavyGrateBlock(RegistryObject<Block> block, ResourceLocation texture) {
        ModelFile model = models().singleTexture(block.getId().getPath(), modLoc("block/template_heavy_grate_block"), "0", texture);
        myDirectionalBlock((Block)block.get(), (ModelFile)model);
    }

    @Deprecated
    public void _sewerBlock(RegistryObject<Block> block, ResourceLocation texture, ResourceLocation texture1) {
        ModelFile model = twoTextures(
                block.getId().getPath(),
                modLoc(ModelProvider.BLOCK_FOLDER + "/template_sewer_block"), "0", texture, "1", texture1);

//        ModelFile model = models().singleTexture(block.getId().getPath(), modLoc(ModelProvider.BLOCK_FOLDER + "/template_sewer_block"), "0", texture);
     //        ModelFile model = models().getExistingFile(modLoc(ModelProvider.BLOCK_FOLDER + "/sewer_block"));
        // TODO get the extended model

        myHorizontalBlock(block.get(), model);
    }

    public void sewerBlock(RegistryObject<Block> block, ResourceLocation texture, ResourceLocation texture1) {
        String name = block.getId().getPath();
        ModelFile model = twoTextures(name, modLoc(ModelProvider.BLOCK_FOLDER + "/template_sewer_block"), "0", texture, "1", texture1);
        ModelFile corner = twoTextures(name + "_corner", modLoc(ModelProvider.BLOCK_FOLDER + "/template_sewer_block_corner"), "0", texture, "1", texture1);

        sewerBlock(block.get(), model, corner);
    }

    public void sewerBlock(Block block, ModelFile sewer, ModelFile corner) {
        getVariantBuilder(block)
                .forAllStates(state -> {
                    Direction facing = state.getValue(LedgeBlock.FACING);
                    SewerBlock.SewerShape shape = state.getValue(SewerBlock.SHAPE);
                    int yRot = ((int) state.getValue(FACING).toYRot() + DEFAULT_ANGLE_OFFSET) % 360;
                   yRot = switch(shape) {
                       case STRAIGHT -> yRot;
                       case TOP_LEFT -> 180;
                       case BOTTOM_LEFT -> 90;
                       case TOP_RIGHT -> 270;
                       case BOTTOM_RIGHT -> 0;
                   };

                    return ConfiguredModel.builder()
                            .modelFile(shape == SewerBlock.SewerShape.STRAIGHT ? sewer : corner)
                            .rotationY(yRot)
                            .uvLock(true)
                            .build();
                });
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

    public ModelFile rectangleLeft(String name, ResourceLocation texture, ResourceLocation texture2) {
        return ((BlockModelBuilder)((BlockModelBuilder)models().withExistingParent(name, modLoc("block/rectangle_left"))).texture("left", texture)).texture("right", texture2);
    }

    public ModelFile rectangleRight(String name, ResourceLocation texture, ResourceLocation texture2) {
        return ((BlockModelBuilder)((BlockModelBuilder)models().withExistingParent(name, modLoc("block/rectangle_right"))).texture("right", texture)).texture("left", texture2);
    }

    public void rectangleLeftHorizontalBlock(RegistryObject<Block> block, RegistryObject<Block> block2) {
        ModelFile model = rectangleLeft(block.getId().getPath(), modLoc("block/" + block.getId().getPath()), modLoc("block/" + block2.getId().getPath()));
        myHorizontalBlock((Block)block.get(), model);
    }

    public void rectangleRightHorizontalBlock(RegistryObject<Block> block, RegistryObject<Block> block2) {
        ModelFile model = rectangleRight(block.getId().getPath(), modLoc("block/" + block.getId().getPath()), modLoc("block/" + block2.getId().getPath()));
        myHorizontalBlock((Block)block.get(), model);
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

    public void heavyTrapDoorBlock(RegistryObject<Block> block, ResourceLocation texture, boolean orientable) {
        myTrapdoorBlockInternal((TrapDoorBlock)block.get(), block.getId().getPath(), texture, orientable);
    }

    private void myTrapdoorBlockInternal(TrapDoorBlock block, String baseName, ResourceLocation texture, boolean orientable) {
        ModelFile bottom = orientable ? myTrapdoorBottom(baseName + "_bottom", texture) : myTrapdoorBottom(baseName + "_bottom", texture);
        ModelFile top = orientable ? myTrapdoorTop(baseName + "_top", texture) : myTrapdoorTop(baseName + "_top", texture);
        ModelFile open = orientable ? myTrapdoorOpen(baseName + "_open", texture) : myTrapdoorOpen(baseName + "_open", texture);
        trapdoorBlock(block, bottom, top, open, orientable);
    }

    public BlockModelBuilder myTrapdoorBottom(String name, ResourceLocation texture) {
        return models().singleTexture(name, modLoc(ModelProvider.BLOCK_FOLDER + "/template_heavy_trapdoor_block_bottom"), "1", texture);
    }

    public BlockModelBuilder myTrapdoorTop(String name, ResourceLocation texture) {
        return models().singleTexture(name, modLoc(ModelProvider.BLOCK_FOLDER + "/template_heavy_trapdoor_block_top"), "1", texture);
    }

    public BlockModelBuilder myTrapdoorOpen(String name, ResourceLocation texture) {
        return models().singleTexture(name, modLoc(ModelProvider.BLOCK_FOLDER + "/template_heavy_trapdoor_block_open"), "1", texture);
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
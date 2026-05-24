package com.kalyptien.wlgyl.datagen;

import com.kalyptien.wlgyl.WhenLifeGivesYouLemonsMod;
import com.kalyptien.wlgyl.block.ModBlocks;
import com.kalyptien.wlgyl.block.custom.CitrusLeavesBlock;
import com.kalyptien.wlgyl.util.ModModelProvider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.generators.*;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, WhenLifeGivesYouLemonsMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        saplingBlock(ModBlocks.LEMON_SAPLING);
        saplingBlock(ModBlocks.ORANGE_SAPLING);
        saplingBlock(ModBlocks.BLOOD_ORANGE_SAPLING);
        saplingBlock(ModBlocks.BUDDHA_HAND_SAPLING);
        saplingBlock(ModBlocks.LIME_SAPLING);
        saplingBlock(ModBlocks.GRAPEFRUIT_SAPLING);
        saplingBlock(ModBlocks.CAVIAR_LEMON_SAPLING);

        makeGrowLeaves(((CitrusLeavesBlock) ModBlocks.LEMON_LEAVES.get()), "lemon_leaves_age_");
        makeGrowLeaves(((CitrusLeavesBlock) ModBlocks.ORANGE_LEAVES.get()), "orange_leaves_age_");
        makeGrowLeaves(((CitrusLeavesBlock) ModBlocks.GRAPEFRUIT_LEAVES.get()), "grapefruit_leaves_age_");
        makeGrowLeaves(((CitrusLeavesBlock) ModBlocks.BLOOD_ORANGE_LEAVES.get()), "blood_orange_leaves_age_");
        makeGrowLeaves(((CitrusLeavesBlock) ModBlocks.LIME_LEAVES.get()), "lime_leaves_age_");
        makeGrowLeaves(((CitrusLeavesBlock) ModBlocks.CAVIAR_LEMON_LEAVES.get()), "caviar_lemon_leaves_age_");
        makeGrowLeaves(((CitrusLeavesBlock) ModBlocks.BUDDHA_HAND_LEAVES.get()), "buddha_hand_leaves_age_");

        logBlock(((RotatedPillarBlock) ModBlocks.CITRUS_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.CITRUS_WOOD.get()), blockTexture(ModBlocks.CITRUS_LOG.get()), blockTexture(ModBlocks.CITRUS_LOG.get()));
        logBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_CITRUS_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_CITRUS_WOOD.get()), blockTexture(ModBlocks.STRIPPED_CITRUS_LOG.get()), blockTexture(ModBlocks.STRIPPED_CITRUS_LOG.get()));

        blockItem(ModBlocks.CITRUS_LOG);
        blockItem(ModBlocks.CITRUS_WOOD);
        blockItem(ModBlocks.STRIPPED_CITRUS_LOG);
        blockItem(ModBlocks.STRIPPED_CITRUS_WOOD);

        blockWithItem(ModBlocks.CITRUS_PLANKS);

        stairsBlock(ModBlocks.CITRUS_STAIRS.get(), blockTexture(ModBlocks.CITRUS_PLANKS.get()));
        slabBlock(ModBlocks.CITRUS_SLAB.get(), blockTexture(ModBlocks.CITRUS_PLANKS.get()), blockTexture(ModBlocks.CITRUS_PLANKS.get()));

        buttonBlock(ModBlocks.CITRUS_BUTTON.get(), blockTexture(ModBlocks.CITRUS_PLANKS.get()));
        pressurePlateBlock(ModBlocks.CITRUS_PRESSURE_PLATE.get(), blockTexture(ModBlocks.CITRUS_PLANKS.get()));

        fenceBlock(ModBlocks.CITRUS_FENCE.get(), blockTexture(ModBlocks.CITRUS_PLANKS.get()));
        fenceGateBlock(ModBlocks.CITRUS_FENCE_GATE.get(), blockTexture(ModBlocks.CITRUS_PLANKS.get()));

        doorBlockWithRenderType(ModBlocks.CITRUS_DOOR.get(), modLoc("block/citrus_door_bottom"), modLoc("block/citrus_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.CITRUS_TRAPDOOR.get(), modLoc("block/citrus_trapdoor"), true, "cutout");

        blockItem(ModBlocks.CITRUS_STAIRS);
        blockItem(ModBlocks.CITRUS_SLAB);
        blockItem(ModBlocks.CITRUS_PRESSURE_PLATE);
        blockItem(ModBlocks.CITRUS_FENCE_GATE);
        blockItem(ModBlocks.CITRUS_TRAPDOOR, "_bottom");
    }

    private void saplingBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(
                        BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(),
                        blockTexture(blockRegistryObject.get())
                ).renderType("cutout")
        );
    }

    public void makeGrowLeaves(CitrusLeavesBlock block, String modelName) {
        Function<BlockState, ConfiguredModel[]> function = state -> generateCrops(state, block, modelName);

        getVariantBuilder(block).forAllStatesExcept(function, CitrusLeavesBlock.DISTANCE, CitrusLeavesBlock.PERSISTENT, CitrusLeavesBlock.WATERLOGGED);
    }

    private ConfiguredModel[] generateCrops(BlockState state, CitrusLeavesBlock block, String modelName) {
        ConfiguredModel[] models = new ConfiguredModel[1];

        ResourceLocation baseTexture = ResourceLocation.fromNamespaceAndPath(
                WhenLifeGivesYouLemonsMod.MOD_ID, "block/agrumes_leaves");

        ResourceLocation upperTexture;

        if(state.getValue(((CitrusLeavesBlock) block).getAgeProperty()) == 3){
            upperTexture = ResourceLocation.fromNamespaceAndPath(
                    WhenLifeGivesYouLemonsMod.MOD_ID, "block/" +  modelName + "3");
        }
        else{
             upperTexture = ResourceLocation.fromNamespaceAndPath(
                    WhenLifeGivesYouLemonsMod.MOD_ID, "block/leaves_age_" + state.getValue(((CitrusLeavesBlock) block).getAgeProperty()));
        }

        models[0] = new ConfiguredModel(ModModelProvider.growLeaveBlock(
                models(),
                modelName + state.getValue(((CitrusLeavesBlock) block).getAgeProperty()),
                baseTexture,
                upperTexture
        ).renderType("cutout"));

        return models;
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("wlgyl:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("wlgyl:block/" + deferredBlock.getId().getPath() + appendix));
    }
}

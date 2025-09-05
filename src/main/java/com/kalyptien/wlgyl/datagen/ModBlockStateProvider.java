package com.kalyptien.wlgyl.datagen;

import com.kalyptien.wlgyl.WhenLifeGivesYouLemonsMod;
import com.kalyptien.wlgyl.block.ModBlocks;
import com.kalyptien.wlgyl.block.custom.AgrumeLeavesBlock;
import com.kalyptien.wlgyl.util.ModModelProvider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
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
        saplingBlock(ModBlocks.BOUDDHA_HAND_SAPLING);
        saplingBlock(ModBlocks.LIME_SAPLING);
        saplingBlock(ModBlocks.GRAPEFRUIT_SAPLING);
        saplingBlock(ModBlocks.CAVIAR_LEMON_SAPLING);

        makeGrowLeaves(((AgrumeLeavesBlock) ModBlocks.LEMON_LEAVES.get()), "lemon_leaves_stage", "lemon_leaves_stage");
        makeGrowLeaves(((AgrumeLeavesBlock) ModBlocks.ORANGE_LEAVES.get()), "orange_leaves_stage", "orange_leaves_stage");
        makeGrowLeaves(((AgrumeLeavesBlock) ModBlocks.GRAPEFRUIT_LEAVES.get()), "grapefruit_leaves_stage", "grapefruit_leaves_stage");
        makeGrowLeaves(((AgrumeLeavesBlock) ModBlocks.BLOOD_ORANGE_LEAVES.get()), "blood_orange_leaves_stage", "blood_orange_leaves_stage");
        makeGrowLeaves(((AgrumeLeavesBlock) ModBlocks.LIME_LEAVES.get()), "lime_leaves_stage", "lime_leaves_stage");
        makeGrowLeaves(((AgrumeLeavesBlock) ModBlocks.CAVIAR_LEMON_LEAVES.get()), "caviar_lemon_leaves_stage", "caviar_lemon_leaves_stage");
        makeGrowLeaves(((AgrumeLeavesBlock) ModBlocks.BOUDDHA_HAND_LEAVES.get()), "bouddha_hand_leaves_stage", "bouddha_hand_leaves_stage");
    }

    private void saplingBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(
                        BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(),
                        blockTexture(blockRegistryObject.get())
                ).renderType("cutout")
        );
    }

    public void makeGrowLeaves(AgrumeLeavesBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> generateCrops(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] generateCrops(BlockState state, AgrumeLeavesBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];

        ResourceLocation baseTexture = ResourceLocation.fromNamespaceAndPath(
                WhenLifeGivesYouLemonsMod.MOD_ID, "block/agrumes_leaves");

        ResourceLocation upperTexture;

        if(state.getValue(((AgrumeLeavesBlock) block).getAgeProperty()) == 0){
            upperTexture = baseTexture;
        }
        else{
            upperTexture = ResourceLocation.fromNamespaceAndPath(
                    WhenLifeGivesYouLemonsMod.MOD_ID, "block/" + textureName + state.getValue(((AgrumeLeavesBlock) block).getAgeProperty()));
        }

        models[0] = new ConfiguredModel(ModModelProvider.growLeaves(
                models(),
                modelName + state.getValue(((AgrumeLeavesBlock) block).getAgeProperty()),
                baseTexture,
                upperTexture
        ).renderType("cutout"));

        return models;
    }
}

package com.kalyptien.wlgyl.datagen;

import com.kalyptien.wlgyl.block.ModBlocks;
import com.kalyptien.wlgyl.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

public class ModDataMapProvider extends DataMapProvider {
    protected ModDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather(HolderLookup.Provider provider) {
        this.builder(NeoForgeDataMaps.COMPOSTABLES)
                .add(ModItems.LEMON.getId(), new Compostable(0.3f), false)
                .add(ModItems.GRAPEFRUIT.getId(), new Compostable(0.3f), false)
                .add(ModItems.BUDDHA_HAND.getId(), new Compostable(0.3f), false)
                .add(ModItems.BLOOD_ORANGE.getId(), new Compostable(0.3f), false)
                .add(ModItems.LIME.getId(), new Compostable(0.3f), false)
                .add(ModItems.CAVIAR_LEMON.getId(), new Compostable(0.3f), false)
                .add(ModItems.ORANGE.getId(), new Compostable(0.3f), false)

                .add(ModBlocks.ORANGE_SAPLING.getId(), new Compostable(0.3f), false)
                .add(ModBlocks.LEMON_SAPLING.getId(), new Compostable(0.3f), false)
                .add(ModBlocks.GRAPEFRUIT_SAPLING.getId(), new Compostable(0.3f), false)
                .add(ModBlocks.BLOOD_ORANGE_SAPLING.getId(), new Compostable(0.3f), false)
                .add(ModBlocks.LIME_SAPLING.getId(), new Compostable(0.3f), false)
                .add(ModBlocks.CAVIAR_LEMON_SAPLING.getId(), new Compostable(0.3f), false)
                .add(ModBlocks.BUDDHA_HAND_SAPLING.getId(), new Compostable(0.3f), false)

                .add(ModBlocks.ORANGE_LEAVES.getId(), new Compostable(0.5f), false)
                .add(ModBlocks.LEMON_LEAVES.getId(), new Compostable(0.5f), false)
                .add(ModBlocks.GRAPEFRUIT_LEAVES.getId(), new Compostable(0.5f), false)
                .add(ModBlocks.LIME_LEAVES.getId(), new Compostable(0.5f), false)
                .add(ModBlocks.CAVIAR_LEMON_LEAVES.getId(), new Compostable(0.5f), false)
                .add(ModBlocks.BUDDHA_HAND_LEAVES.getId(), new Compostable(0.5f), false)
                .add(ModBlocks.BLOOD_ORANGE_LEAVES.getId(), new Compostable(0.5f), false)
        ;
    }
}

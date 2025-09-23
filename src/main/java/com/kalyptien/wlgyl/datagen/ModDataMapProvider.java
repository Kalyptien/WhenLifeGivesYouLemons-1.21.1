package com.kalyptien.wlgyl.datagen;

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
                .add(ModItems.LEMON.getId(), new Compostable(0.5f), false)
                .add(ModItems.GRAPEFRUIT.getId(), new Compostable(0.5f), false)
                .add(ModItems.BUDDHA_HAND.getId(), new Compostable(0.5f), false)
                .add(ModItems.BLOOD_ORANGE.getId(), new Compostable(0.5f), false)
                .add(ModItems.LIME.getId(), new Compostable(0.5f), false)
                .add(ModItems.CAVIAR_LEMON.getId(), new Compostable(0.5f), false)
                .add(ModItems.ORANGE.getId(), new Compostable(0.5f), false);
    }
}

package com.kalyptien.wlgyl.util;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.BlockModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.function.BiFunction;
import java.util.function.Function;

public class ModModelProvider extends ModelProvider {

    public ModModelProvider(PackOutput output, String modid, String folder, BiFunction builderFromModId, ExistingFileHelper existingFileHelper) {
        super(output, modid, folder, builderFromModId, existingFileHelper);
    }

    public ModModelProvider(PackOutput output, String modid, String folder, Function factory, ExistingFileHelper existingFileHelper) {
        super(output, modid, folder, factory, existingFileHelper);
    }

    public static ModelBuilder growLeaves(BlockModelProvider provider, String name, ResourceLocation texture0, ResourceLocation texture1) {
        return twoTextureLeaves(provider, name, ResourceLocation.parse("wlgyl:block/agrume_leaves_base"), texture0, texture1);
    }

    public static ModelBuilder twoTextureLeaves(BlockModelProvider provider, String name, ResourceLocation parent, ResourceLocation texture0, ResourceLocation texture1) {
        return provider.withExistingParent(name, parent)
                .texture("all", texture0)
                .texture("agrume", texture1);
    }

    @Override
    protected void registerModels() {

    }

    @Override
    public String getName() {
        return "Mod Block Models: " + this.modid;
    }
}

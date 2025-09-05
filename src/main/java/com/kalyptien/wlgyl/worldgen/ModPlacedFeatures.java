package com.kalyptien.wlgyl.worldgen;

import com.kalyptien.wlgyl.WhenLifeGivesYouLemonsMod;
import com.kalyptien.wlgyl.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.Arrays;
import java.util.List;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> LEMON_TREE_PLACED_KEY = registerKey("lemon_tree_placed");
    public static final ResourceKey<PlacedFeature> ORANGE_TREE_PLACED_KEY = registerKey("orange_tree_placed");
    public static final ResourceKey<PlacedFeature> BLOOD_ORANGE_TREE_PLACED_KEY = registerKey("blood_orange_tree_placed");
    public static final ResourceKey<PlacedFeature> CAVIAR_LEMON_TREE_PLACED_KEY = registerKey("caviar_lemon_tree_placed");
    public static final ResourceKey<PlacedFeature> GRAPEFRUIT_TREE_PLACED_KEY = registerKey("grapefruit_tree_placed");
    public static final ResourceKey<PlacedFeature> LIME_TREE_PLACED_KEY = registerKey("lime_tree_placed");
    public static final ResourceKey<PlacedFeature> BOUDDHA_HAND_TREE_PLACED_KEY = registerKey("bouddha_hand_tree_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, LEMON_TREE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LEMON_TREE_KEY),
                Arrays.stream(new PlacementModifier[]{
                        RarityFilter.onAverageOnceEvery(600),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()}).toList());

        register(context, ORANGE_TREE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ORANGE_TREE_KEY),
                Arrays.stream(new PlacementModifier[]{
                        RarityFilter.onAverageOnceEvery(600),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()}).toList());

        register(context, BLOOD_ORANGE_TREE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BLOOD_ORANGE_TREE_KEY),
                Arrays.stream(new PlacementModifier[]{
                        RarityFilter.onAverageOnceEvery(600),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()}).toList());

        register(context, GRAPEFRUIT_TREE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.GRAPEFRUIT_TREE_KEY),
                Arrays.stream(new PlacementModifier[]{
                        RarityFilter.onAverageOnceEvery(600),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()}).toList());

        register(context, LIME_TREE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LIME_TREE_KEY),
                Arrays.stream(new PlacementModifier[]{
                        RarityFilter.onAverageOnceEvery(600),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()}).toList());

        register(context, BOUDDHA_HAND_TREE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BOUDDHA_HAND_TREE_KEY),
                Arrays.stream(new PlacementModifier[]{
                        RarityFilter.onAverageOnceEvery(200),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()}).toList());

        register(context, CAVIAR_LEMON_TREE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CAVIAR_LEMON_TREE_KEY),
                Arrays.stream(new PlacementModifier[]{
                        RarityFilter.onAverageOnceEvery(500),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()}).toList());
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(WhenLifeGivesYouLemonsMod.MOD_ID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}

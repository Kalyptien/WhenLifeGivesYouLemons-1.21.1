package com.kalyptien.wlgyl.worldgen;

import com.kalyptien.wlgyl.WhenLifeGivesYouLemonsMod;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModBiomeModifiers {

    public static final ResourceKey<BiomeModifier> ADD_TREE_LEMON_TREE = registerKey("add_tree_lemon_tree");
    public static final ResourceKey<BiomeModifier> ADD_TREE_ORANGE_TREE = registerKey("add_tree_orange_tree");
    public static final ResourceKey<BiomeModifier> ADD_TREE_CAVIAR_LEMON_TREE = registerKey("add_tree_caviar_lemon_tree");
    public static final ResourceKey<BiomeModifier> ADD_TREE_GRAPEFRUIT_TREE = registerKey("add_tree_grapefruit_tree");
    public static final ResourceKey<BiomeModifier> ADD_TREE_BLOOD_ORANGE_TREE = registerKey("add_tree_blood_orange_tree");
    public static final ResourceKey<BiomeModifier> ADD_TREE_LIME_TREE = registerKey("add_tree_lime_tree");
    public static final ResourceKey<BiomeModifier> ADD_TREE_BUDDHA_HAND_TREE = registerKey("add_tree_buddha_hand_tree");
    
    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        // CF -> PF -> BM
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_TREE_LEMON_TREE, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(
                        biomes.getOrThrow(Biomes.FOREST),
                        biomes.getOrThrow(Biomes.BIRCH_FOREST),
                        biomes.getOrThrow(Biomes.FLOWER_FOREST),
                        biomes.getOrThrow(Biomes.OLD_GROWTH_BIRCH_FOREST)),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.LEMON_TREE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_TREE_ORANGE_TREE, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(
                        biomes.getOrThrow(Biomes.FOREST),
                        biomes.getOrThrow(Biomes.BIRCH_FOREST),
                        biomes.getOrThrow(Biomes.FLOWER_FOREST),
                        biomes.getOrThrow(Biomes.OLD_GROWTH_BIRCH_FOREST)),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.ORANGE_TREE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_TREE_BLOOD_ORANGE_TREE, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.BADLANDS), biomes.getOrThrow(Biomes.DARK_FOREST)),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.BLOOD_ORANGE_TREE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_TREE_BUDDHA_HAND_TREE, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.BAMBOO_JUNGLE), biomes.getOrThrow(Biomes.SPARSE_JUNGLE), biomes.getOrThrow(Biomes.JUNGLE)),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.BUDDHA_HAND_TREE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_TREE_LIME_TREE, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(
                        biomes.getOrThrow(Biomes.FOREST),
                        biomes.getOrThrow(Biomes.BIRCH_FOREST),
                        biomes.getOrThrow(Biomes.FLOWER_FOREST),
                        biomes.getOrThrow(Biomes.OLD_GROWTH_BIRCH_FOREST)),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.LIME_TREE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_TREE_GRAPEFRUIT_TREE, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.DESERT), biomes.getOrThrow(Biomes.SAVANNA)),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.GRAPEFRUIT_TREE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_TREE_CAVIAR_LEMON_TREE, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.MANGROVE_SWAMP), biomes.getOrThrow(Biomes.SWAMP)),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.CAVIAR_LEMON_TREE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(WhenLifeGivesYouLemonsMod.MOD_ID, name));
    }
}

package com.kalyptien.wlgyl.worldgen;

import com.kalyptien.wlgyl.WhenLifeGivesYouLemonsMod;
import com.kalyptien.wlgyl.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> LEMON_TREE_KEY = registerKey("lemon_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_TREE_KEY = registerKey("orange_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLOOD_ORANGE_TREE_KEY = registerKey("blood_orange_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GRAPEFRUIT_TREE_KEY = registerKey("grapefruit_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LIME_TREE_KEY = registerKey("lime_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BUDDHA_HAND_TREE_KEY = registerKey("buddha_hand_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CAVIAR_LEMON_TREE_KEY = registerKey("caviar_lemon_tree");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {


        register(context, LEMON_TREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(Blocks.OAK_LOG),
                new ForkingTrunkPlacer(1, 2, 2),

                BlockStateProvider.simple(ModBlocks.LEMON_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(2), 3),

                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, ORANGE_TREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(Blocks.OAK_LOG),
                new ForkingTrunkPlacer(1, 2, 2),

                BlockStateProvider.simple(ModBlocks.ORANGE_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(2), 3),

                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, BLOOD_ORANGE_TREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(Blocks.OAK_LOG),
                new ForkingTrunkPlacer(1, 2, 2),

                BlockStateProvider.simple(ModBlocks.BLOOD_ORANGE_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(2), 3),

                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, CAVIAR_LEMON_TREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(Blocks.OAK_LOG),
                new ForkingTrunkPlacer(1, 2, 2),

                BlockStateProvider.simple(ModBlocks.CAVIAR_LEMON_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(2), 3),

                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, BUDDHA_HAND_TREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(Blocks.OAK_LOG),
                new ForkingTrunkPlacer(1, 2, 2),

                BlockStateProvider.simple(ModBlocks.BUDDHA_HAND_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(2), 3),

                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, LIME_TREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(Blocks.OAK_LOG),
                new ForkingTrunkPlacer(1, 2, 2),

                BlockStateProvider.simple(ModBlocks.LIME_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(2), 3),

                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, GRAPEFRUIT_TREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(Blocks.OAK_LOG),
                new ForkingTrunkPlacer(1, 2, 2),

                BlockStateProvider.simple(ModBlocks.GRAPEFRUIT_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(2), 3),

                new TwoLayersFeatureSize(1, 0, 2)).build());

    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(WhenLifeGivesYouLemonsMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}

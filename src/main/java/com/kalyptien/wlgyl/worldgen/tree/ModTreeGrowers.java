package com.kalyptien.wlgyl.worldgen.tree;

import com.kalyptien.wlgyl.WhenLifeGivesYouLemonsMod;
import com.kalyptien.wlgyl.worldgen.ModConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower LEMON_TREE = new TreeGrower(WhenLifeGivesYouLemonsMod.MOD_ID + ":lemon_tree",
            Optional.empty(), Optional.of(ModConfiguredFeatures.LEMON_TREE_KEY), Optional.empty());

    public static final TreeGrower ORANGE_TREE = new TreeGrower(WhenLifeGivesYouLemonsMod.MOD_ID + ":orange_tree",
            Optional.empty(), Optional.of(ModConfiguredFeatures.ORANGE_TREE_KEY), Optional.empty());

    public static final TreeGrower CAVIAR_LEMON_TREE = new TreeGrower(WhenLifeGivesYouLemonsMod.MOD_ID + ":caviar_lemon_tree",
            Optional.empty(), Optional.of(ModConfiguredFeatures.CAVIAR_LEMON_TREE_KEY), Optional.empty());

    public static final TreeGrower BLOOD_ORANGE_TREE = new TreeGrower(WhenLifeGivesYouLemonsMod.MOD_ID + ":blood_orange_tree",
            Optional.empty(), Optional.of(ModConfiguredFeatures.BLOOD_ORANGE_TREE_KEY), Optional.empty());

    public static final TreeGrower GRAPEFRUIT_TREE = new TreeGrower(WhenLifeGivesYouLemonsMod.MOD_ID + ":grapefruit_tree",
            Optional.empty(), Optional.of(ModConfiguredFeatures.GRAPEFRUIT_TREE_KEY), Optional.empty());

    public static final TreeGrower BOUDDHA_HAND_TREE = new TreeGrower(WhenLifeGivesYouLemonsMod.MOD_ID + ":bouddha_hand_tree",
            Optional.empty(), Optional.of(ModConfiguredFeatures.BOUDDHA_HAND_TREE_KEY), Optional.empty());

    public static final TreeGrower LIME_TREE = new TreeGrower(WhenLifeGivesYouLemonsMod.MOD_ID + ":lime_tree",
            Optional.empty(), Optional.of(ModConfiguredFeatures.LIME_TREE_KEY), Optional.empty());

}

package com.kalyptien.wlgyl.worldgen.tree;

import com.kalyptien.wlgyl.WhenLifeGivesYouLemonsMod;
import com.kalyptien.wlgyl.worldgen.ModConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower LEMON_TREE = new TreeGrower(WhenLifeGivesYouLemonsMod.MOD_ID + ":lemon_tree",
            Optional.empty(), Optional.of(ModConfiguredFeatures.LEMON_TREE_KEY), Optional.empty());

}

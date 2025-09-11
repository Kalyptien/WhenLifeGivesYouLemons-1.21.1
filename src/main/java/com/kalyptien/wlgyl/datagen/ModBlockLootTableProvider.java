package com.kalyptien.wlgyl.datagen;

import com.kalyptien.wlgyl.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {

    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {

        dropSelf(ModBlocks.SQUEEZER.get());
        dropSelf(ModBlocks.BREWING_BARREL.get());
        dropSelf(ModBlocks.INDUSTRIAL_BREWING_BARREL.get());

        dropSelf(ModBlocks.LEMON_SAPLING.get());
        dropSelf(ModBlocks.ORANGE_SAPLING.get());
        dropSelf(ModBlocks.BLOOD_ORANGE_SAPLING.get());
        dropSelf(ModBlocks.BOUDDHA_HAND_SAPLING.get());
        dropSelf(ModBlocks.LIME_SAPLING.get());
        dropSelf(ModBlocks.GRAPEFRUIT_SAPLING.get());
        dropSelf(ModBlocks.CAVIAR_LEMON_SAPLING.get());

        add(ModBlocks.LEMON_LEAVES.get(),
                block -> createLeavesDrops(ModBlocks.LEMON_LEAVES.get(), ModBlocks.LEMON_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        add(ModBlocks.ORANGE_LEAVES.get(),
                block -> createLeavesDrops(ModBlocks.ORANGE_LEAVES.get(), ModBlocks.ORANGE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        add(ModBlocks.BLOOD_ORANGE_LEAVES.get(),
                block -> createLeavesDrops(ModBlocks.BLOOD_ORANGE_LEAVES.get(), ModBlocks.BLOOD_ORANGE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        add(ModBlocks.BOUDDHA_HAND_LEAVES.get(),
                block -> createLeavesDrops(ModBlocks.BOUDDHA_HAND_LEAVES.get(), ModBlocks.BOUDDHA_HAND_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        add(ModBlocks.LIME_LEAVES.get(),
                block -> createLeavesDrops(ModBlocks.LIME_LEAVES.get(), ModBlocks.LIME_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        add(ModBlocks.GRAPEFRUIT_LEAVES.get(),
                block -> createLeavesDrops(ModBlocks.GRAPEFRUIT_LEAVES.get(), ModBlocks.GRAPEFRUIT_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        add(ModBlocks.CAVIAR_LEMON_LEAVES.get(),
                block -> createLeavesDrops(ModBlocks.CAVIAR_LEMON_LEAVES.get(), ModBlocks.CAVIAR_LEMON_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}

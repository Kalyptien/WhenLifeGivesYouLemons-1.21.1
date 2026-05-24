package com.kalyptien.wlgyl.datagen;

import com.kalyptien.wlgyl.WhenLifeGivesYouLemonsMod;
import com.kalyptien.wlgyl.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {

    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, WhenLifeGivesYouLemonsMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.LEAVES)
                .add(ModBlocks.ORANGE_LEAVES.get())
                .add(ModBlocks.BLOOD_ORANGE_LEAVES.get())
                .add(ModBlocks.BUDDHA_HAND_LEAVES.get())
                .add(ModBlocks.CAVIAR_LEMON_LEAVES.get())
                .add(ModBlocks.GRAPEFRUIT_LEAVES.get())
                .add(ModBlocks.LIME_LEAVES.get())
                .add(ModBlocks.LEMON_LEAVES.get());

        tag(BlockTags.SAPLINGS)
                .add(ModBlocks.LEMON_SAPLING.get())
                .add(ModBlocks.ORANGE_LEAVES.get())
                .add(ModBlocks.BLOOD_ORANGE_SAPLING.get())
                .add(ModBlocks.BUDDHA_HAND_SAPLING.get())
                .add(ModBlocks.LIME_SAPLING.get())
                .add(ModBlocks.CAVIAR_LEMON_SAPLING.get())
                .add(ModBlocks.GRAPEFRUIT_SAPLING.get());

        tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.CITRUS_LOG.get())
                .add(ModBlocks.CITRUS_WOOD.get())
                .add(ModBlocks.STRIPPED_CITRUS_LOG.get())
                .add(ModBlocks.STRIPPED_CITRUS_WOOD.get());

        tag(BlockTags.FENCES).add(ModBlocks.CITRUS_FENCE.get());

        tag(BlockTags.FENCE_GATES).add(ModBlocks.CITRUS_FENCE_GATE.get());

    }
}

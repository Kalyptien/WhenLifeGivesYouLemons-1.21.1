package com.kalyptien.wlgyl.datagen;

import com.kalyptien.wlgyl.WhenLifeGivesYouLemonsMod;
import com.kalyptien.wlgyl.item.ModItems;
import com.kalyptien.wlgyl.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {

    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, WhenLifeGivesYouLemonsMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.AGRUMES)
                .add(ModItems.LEMON.get())
                .add(ModItems.LIME.get())
                .add(ModItems.ORANGE.get())
                .add(ModItems.BLOOD_ORANGE.get())
                .add(ModItems.GRAPEFRUIT.get())
                .add(ModItems.CAVIAR_LEMON.get())
                .add(ModItems.BUDDHA_HAND.get());

        tag(ModTags.Items.FRUITS)
                .add(Items.APPLE)
                .add(Items.GLOW_BERRIES)
                .add(Items.SWEET_BERRIES)
                .add(ModItems.LEMON.get())
                .add(ModItems.LIME.get())
                .add(ModItems.ORANGE.get())
                .add(ModItems.BLOOD_ORANGE.get())
                .add(ModItems.GRAPEFRUIT.get())
                .add(ModItems.CAVIAR_LEMON.get())
                .add(ModItems.BUDDHA_HAND.get());

        tag(ModTags.Items.BERRYS)
                .add(Items.GLOW_BERRIES)
                .add(Items.SWEET_BERRIES);
    }
}

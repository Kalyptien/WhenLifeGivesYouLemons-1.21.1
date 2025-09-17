package com.kalyptien.wlgyl.datagen;

import com.kalyptien.wlgyl.WhenLifeGivesYouLemonsMod;
import com.kalyptien.wlgyl.block.ModBlocks;
import com.kalyptien.wlgyl.item.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModItemModelProvider  extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, WhenLifeGivesYouLemonsMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.LEMON.get());
        basicItem(ModItems.ORANGE.get());
        basicItem(ModItems.BOUDDHA_HAND.get());
        basicItem(ModItems.LIME.get());
        basicItem(ModItems.BLOOD_ORANGE.get());
        basicItem(ModItems.CAVRIAR_LEMON.get());
        basicItem(ModItems.GRAPEFRUIT.get());

        bottleItem(ModItems.LEMON_JUICE.get());
        bottleItem(ModItems.ORANGE_JUICE.get());
        bottleItem(ModItems.BLOOD_ORANGE_JUICE.get());
        bottleItem(ModItems.BOUDDHA_HAND_JUICE.get());
        bottleItem(ModItems.CAVRIAR_LEMON_JUICE.get());
        bottleItem(ModItems.LIME_JUICE.get());
        bottleItem(ModItems.GRAPEFRUIT_JUICE.get());
        bottleItem(ModItems.APPLE_JUICE.get());
        bottleItem(ModItems.SWEET_BERRIES_JUICE.get());
        bottleItem(ModItems.GLOW_BERRIES_JUICE.get());

        bottleItem(ModItems.LEMON_LEMONADE.get());
        bottleItem(ModItems.ORANGE_LEMONADE.get());
        bottleItem(ModItems.BLOOD_ORANGE_LEMONADE.get());
        bottleItem(ModItems.BOUDDHA_HAND_LEMONADE.get());
        bottleItem(ModItems.GRAPEFRUIT_LEMONADE.get());
        bottleItem(ModItems.LIME_LEMONADE.get());
        bottleItem(ModItems.CAVRIAR_LEMON_LEMONADE.get());

        saplingItem(ModBlocks.LEMON_SAPLING);
        saplingItem(ModBlocks.ORANGE_SAPLING);
        saplingItem(ModBlocks.BLOOD_ORANGE_SAPLING);
        saplingItem(ModBlocks.GRAPEFRUIT_SAPLING);
        saplingItem(ModBlocks.BOUDDHA_HAND_SAPLING);
        saplingItem(ModBlocks.CAVIAR_LEMON_SAPLING);
        saplingItem(ModBlocks.LIME_SAPLING);

        leavesItem(ModBlocks.LEMON_LEAVES);
        leavesItem(ModBlocks.ORANGE_LEAVES);
        leavesItem(ModBlocks.BLOOD_ORANGE_LEAVES);
        leavesItem(ModBlocks.BOUDDHA_HAND_LEAVES);
        leavesItem(ModBlocks.GRAPEFRUIT_LEAVES);
        leavesItem(ModBlocks.LIME_LEAVES);
        leavesItem(ModBlocks.CAVIAR_LEMON_LEAVES);

        withExistingParent(ModItems.KIWI_NORMAL_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }

    private ItemModelBuilder saplingItem(DeferredBlock<Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(WhenLifeGivesYouLemonsMod.MOD_ID,"block/" + item.getId().getPath()));
    }

    private ItemModelBuilder leavesItem(DeferredBlock<Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse(WhenLifeGivesYouLemonsMod.MOD_ID + ":block/" + item.getId().getPath() + "_stage3"));
    }

    private ItemModelBuilder bottleItem(Item item) {
        return (ItemModelBuilder)((ItemModelBuilder)((ItemModelBuilder)
                this.getBuilder(item.toString())).parent(
                        new ModelFile.UncheckedModelFile("item/generated")))
                            .texture("layer0", ResourceLocation.fromNamespaceAndPath("minecraft", "item/potion"))
                            .texture("layer1", ResourceLocation.fromNamespaceAndPath(WhenLifeGivesYouLemonsMod.MOD_ID, "item/" + BuiltInRegistries.ITEM.getKey(item).toString().replace(WhenLifeGivesYouLemonsMod.MOD_ID + ":", ""))
                        );
    }
}

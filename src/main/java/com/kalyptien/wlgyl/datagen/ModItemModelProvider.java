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
        basicItem(ModItems.BUDDHA_HAND.get());
        basicItem(ModItems.LIME.get());
        basicItem(ModItems.BLOOD_ORANGE.get());
        basicItem(ModItems.CAVIAR_LEMON.get());
        basicItem(ModItems.GRAPEFRUIT.get());
        basicItem(ModItems.KIWI_BUCKET.get());

        bottleJuice(ModItems.LEMON_JUICE.get());
        bottleJuice(ModItems.ORANGE_JUICE.get());
        bottleJuice(ModItems.BLOOD_ORANGE_JUICE.get());
        bottleJuice(ModItems.BUDDHA_HAND_JUICE.get());
        bottleJuice(ModItems.CAVIAR_LEMON_JUICE.get());
        bottleJuice(ModItems.LIME_JUICE.get());
        bottleJuice(ModItems.GRAPEFRUIT_JUICE.get());

        bottleJuice(ModItems.APPLE_JUICE.get());
        bottleJuice(ModItems.MELON_JUICE.get());
        bottleJuice(ModItems.SWEET_BERRIES_JUICE.get());
        bottleJuice(ModItems.GLOW_BERRIES_JUICE.get());

        bottleLimonade(ModItems.LEMON_LEMONADE.get());
        bottleLimonade(ModItems.ORANGE_LEMONADE.get());
        bottleLimonade(ModItems.LIME_LEMONADE.get());
        bottleLimonade(ModItems.BLOOD_ORANGE_LEMONADE.get());
        bottleLimonade(ModItems.BUDDHA_HAND_LEMONADE.get());
        bottleLimonade(ModItems.GRAPEFRUIT_LEMONADE.get());
        bottleLimonade(ModItems.CAVIAR_LEMON_LEMONADE.get());

        bottleLimonade(ModItems.BLOOD_ORANGE_LEMONADE_STRONG.get());
        bottleLimonade(ModItems.BUDDHA_HAND_LEMONADE_STRONG.get());
        bottleLimonade(ModItems.GRAPEFRUIT_LEMONADE_STRONG.get());
        bottleLimonade(ModItems.CAVIAR_LEMON_LEMONADE_STRONG.get());

        bottleLimonade(ModItems.BLOOD_ORANGE_LEMONADE_LONG.get());
        bottleLimonade(ModItems.BUDDHA_HAND_LEMONADE_LONG.get());
        bottleLimonade(ModItems.GRAPEFRUIT_LEMONADE_LONG.get());
        bottleLimonade(ModItems.CAVIAR_LEMON_LEMONADE_LONG.get());

        saplingItem(ModBlocks.LEMON_SAPLING);
        saplingItem(ModBlocks.ORANGE_SAPLING);
        saplingItem(ModBlocks.BLOOD_ORANGE_SAPLING);
        saplingItem(ModBlocks.GRAPEFRUIT_SAPLING);
        saplingItem(ModBlocks.BUDDHA_HAND_SAPLING);
        saplingItem(ModBlocks.CAVIAR_LEMON_SAPLING);
        saplingItem(ModBlocks.LIME_SAPLING);

        leavesItem(ModBlocks.LEMON_LEAVES);
        leavesItem(ModBlocks.ORANGE_LEAVES);
        leavesItem(ModBlocks.BLOOD_ORANGE_LEAVES);
        leavesItem(ModBlocks.BUDDHA_HAND_LEAVES);
        leavesItem(ModBlocks.GRAPEFRUIT_LEAVES);
        leavesItem(ModBlocks.LIME_LEAVES);
        leavesItem(ModBlocks.CAVIAR_LEMON_LEAVES);

        withExistingParent(ModItems.KIWI_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }

    private ItemModelBuilder saplingItem(DeferredBlock<Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(WhenLifeGivesYouLemonsMod.MOD_ID,"block/" + item.getId().getPath()));
    }

    private ItemModelBuilder leavesItem(DeferredBlock<Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse(WhenLifeGivesYouLemonsMod.MOD_ID + ":block/" + item.getId().getPath() + "_age_3"));
    }

    private ItemModelBuilder bottleJuice(Item item) {
        return (ItemModelBuilder)((ItemModelBuilder)((ItemModelBuilder)
                this.getBuilder(item.toString())).parent(
                        new ModelFile.UncheckedModelFile("item/generated")))
                            .texture("layer0", ResourceLocation.fromNamespaceAndPath("minecraft", "item/potion"))
                            .texture("layer1", ResourceLocation.fromNamespaceAndPath("minecraft", "item/potion_overlay"));
    }

    private ItemModelBuilder bottleLimonade(Item item) {
        return (ItemModelBuilder)((ItemModelBuilder)((ItemModelBuilder)
                this.getBuilder(item.toString())).parent(
                new ModelFile.UncheckedModelFile("item/generated")))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath("minecraft", "item/potion"))
                .texture("layer1", ResourceLocation.fromNamespaceAndPath(WhenLifeGivesYouLemonsMod.MOD_ID, "item/lemonade_overlay"));
    }
}

package com.kalyptien.wlgyl.item;

import com.kalyptien.wlgyl.WhenLifeGivesYouLemonsMod;
import com.kalyptien.wlgyl.entity.ModEntities;
import com.kalyptien.wlgyl.entity.custom.KiwiEntity;
import com.kalyptien.wlgyl.item.custom.JuiceBottleItem;
import com.kalyptien.wlgyl.item.custom.LemonadeBottleItem;
import com.kalyptien.wlgyl.util.AgrumesVariant;
import com.kalyptien.wlgyl.util.EffectsVariant;
import com.kalyptien.wlgyl.util.FruitsVariant;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.MobBucketItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(WhenLifeGivesYouLemonsMod.MOD_ID);

    // AGRUMES
    public static final DeferredItem<Item> LEMON = ITEMS.register("lemon",
            () -> new Item(new Item.Properties().food(ModFoodProperties.AGRUMES)));
    public static final DeferredItem<Item> ORANGE = ITEMS.register("orange",
            () -> new Item(new Item.Properties().food(ModFoodProperties.AGRUMES)));
    public static final DeferredItem<Item> BLOOD_ORANGE = ITEMS.register("blood_orange",
            () -> new Item(new Item.Properties().food(ModFoodProperties.AGRUMES)));
    public static final DeferredItem<Item> GRAPEFRUIT = ITEMS.register("grapefruit",
            () -> new Item(new Item.Properties().food(ModFoodProperties.AGRUMES)));
    public static final DeferredItem<Item> LIME = ITEMS.register("lime",
            () -> new Item(new Item.Properties().food(ModFoodProperties.AGRUMES)));
    public static final DeferredItem<Item> CAVIAR_LEMON = ITEMS.register("caviar_lemon",
            () -> new Item(new Item.Properties().food(ModFoodProperties.AGRUMES)));
    public static final DeferredItem<Item> BUDDHA_HAND = ITEMS.register("buddha_hand",
            () -> new Item(new Item.Properties().food(ModFoodProperties.AGRUMES)));

    // JUICES
    public static final DeferredItem<Item> LEMON_JUICE = ITEMS.register("lemon_juice",
            () -> new JuiceBottleItem(new Item.Properties().food(ModFoodProperties.JUICE).stacksTo(16), FruitsVariant.LEMON));
    public static final DeferredItem<Item> ORANGE_JUICE = ITEMS.register("orange_juice",
            () -> new JuiceBottleItem(new Item.Properties().food(ModFoodProperties.JUICE).stacksTo(16), FruitsVariant.ORANGE));
    public static final DeferredItem<Item> BLOOD_ORANGE_JUICE = ITEMS.register("blood_orange_juice",
            () -> new JuiceBottleItem(new Item.Properties().food(ModFoodProperties.JUICE).stacksTo(16), FruitsVariant.BLOOD_ORANGE));
    public static final DeferredItem<Item> GRAPEFRUIT_JUICE = ITEMS.register("grapefruit_juice",
            () -> new JuiceBottleItem(new Item.Properties().food(ModFoodProperties.JUICE).stacksTo(16), FruitsVariant.GRAPEFRUIT));
    public static final DeferredItem<Item> LIME_JUICE = ITEMS.register("lime_juice",
            () -> new JuiceBottleItem(new Item.Properties().food(ModFoodProperties.JUICE).stacksTo(16), FruitsVariant.LIME));
    public static final DeferredItem<Item> CAVIAR_LEMON_JUICE = ITEMS.register("caviar_lemon_juice",
            () -> new JuiceBottleItem(new Item.Properties().food(ModFoodProperties.JUICE).stacksTo(16), FruitsVariant.CAVIAR_LEMON));
    public static final DeferredItem<Item> BUDDHA_HAND_JUICE = ITEMS.register("buddha_hand_juice",
            () -> new JuiceBottleItem(new Item.Properties().food(ModFoodProperties.JUICE_CLARITY).stacksTo(16), FruitsVariant.BUDDHA_HAND) {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.wlgyl.buddha_hand_juice.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> APPLE_JUICE = ITEMS.register("apple_juice",
            () -> new JuiceBottleItem(new Item.Properties().food(ModFoodProperties.JUICE).stacksTo(16), FruitsVariant.APPLE));
    public static final DeferredItem<Item> MELON_JUICE = ITEMS.register("melon_juice",
            () -> new JuiceBottleItem(new Item.Properties().food(ModFoodProperties.JUICE).stacksTo(16), FruitsVariant.MELON_SLICE));
    public static final DeferredItem<Item> GLOW_BERRIES_JUICE = ITEMS.register("glow_berries_juice",
            () -> new JuiceBottleItem(new Item.Properties().food(ModFoodProperties.JUICE_GLOW).stacksTo(16), FruitsVariant.GLOW_BERRIES){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.wlgyl.glow_berries_juice.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> SWEET_BERRIES_JUICE = ITEMS.register("sweet_berries_juice",
            () -> new JuiceBottleItem(new Item.Properties().food(ModFoodProperties.JUICE_SWEET).stacksTo(16), FruitsVariant.SWEET_BERRIES));

    //LEMONADE (TIER 1)
    public static final DeferredItem<Item> LEMON_LEMONADE = ITEMS.register("lemon_lemonade",
            () -> new LemonadeBottleItem(new Item.Properties().food(ModFoodProperties.LEMONADE).stacksTo(16) , EffectsVariant.NONE, FruitsVariant.LEMON));
    public static final DeferredItem<Item> ORANGE_LEMONADE = ITEMS.register("orange_lemonade",
            () -> new LemonadeBottleItem(new Item.Properties().food(ModFoodProperties.LEMONADE).stacksTo(16), EffectsVariant.NONE, FruitsVariant.ORANGE));
    public static final DeferredItem<Item> LIME_LEMONADE = ITEMS.register("lime_lemonade",
            () -> new LemonadeBottleItem(new Item.Properties().food(ModFoodProperties.LEMONADE).stacksTo(16), EffectsVariant.NONE, FruitsVariant.LIME));
    public static final DeferredItem<Item> BLOOD_ORANGE_LEMONADE = ITEMS.register("blood_orange_lemonade",
            () -> new LemonadeBottleItem(new Item.Properties().food(ModFoodProperties.LEMONADE_LEECH).stacksTo(16), EffectsVariant.NONE, FruitsVariant.BLOOD_ORANGE){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.wlgyl.blood_orange_lemonade.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> GRAPEFRUIT_LEMONADE = ITEMS.register("grapefruit_lemonade",
            () -> new LemonadeBottleItem(new Item.Properties().food(ModFoodProperties.LEMONADE_ACID).stacksTo(16), EffectsVariant.NONE, FruitsVariant.GRAPEFRUIT){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.wlgyl.grapefruit_lemonade.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> CAVIAR_LEMON_LEMONADE = ITEMS.register("caviar_lemon_lemonade",
            () -> new LemonadeBottleItem(new Item.Properties().food(ModFoodProperties.LEMONADE_BUBBLY).stacksTo(16), EffectsVariant.NONE, FruitsVariant.CAVIAR_LEMON){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.wlgyl.caviar_lemon_lemonade.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> BUDDHA_HAND_LEMONADE = ITEMS.register("buddha_hand_lemonade",
            () -> new LemonadeBottleItem(new Item.Properties().food(ModFoodProperties.LEMONADE_BENEDICTION).stacksTo(16), EffectsVariant.NONE, FruitsVariant.BUDDHA_HAND){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.wlgyl.buddha_hand_lemonade.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    // LEMONADE (TIER 2)
    public static final DeferredItem<Item> BLOOD_ORANGE_LEMONADE_STRONG = ITEMS.register("blood_orange_lemonade_strong",
            () -> new LemonadeBottleItem(new Item.Properties().food(ModFoodProperties.LEMONADE_LEECH_STRONG).stacksTo(16), EffectsVariant.STRONG, FruitsVariant.BLOOD_ORANGE){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.wlgyl.blood_orange_lemonade_strong.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> GRAPEFRUIT_LEMONADE_STRONG = ITEMS.register("grapefruit_lemonade_strong",
            () -> new LemonadeBottleItem(new Item.Properties().food(ModFoodProperties.LEMONADE_ACID_STRONG).stacksTo(16), EffectsVariant.STRONG, FruitsVariant.GRAPEFRUIT){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.wlgyl.grapefruit_lemonade_strong.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> CAVIAR_LEMON_LEMONADE_STRONG = ITEMS.register("caviar_lemon_lemonade_strong",
            () -> new LemonadeBottleItem(new Item.Properties().food(ModFoodProperties.LEMONADE_BUBBLY_STRONG).stacksTo(16), EffectsVariant.STRONG, FruitsVariant.CAVIAR_LEMON){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.wlgyl.caviar_lemon_lemonade_strong.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> BUDDHA_HAND_LEMONADE_STRONG = ITEMS.register("buddha_hand_lemonade_strong",
            () -> new LemonadeBottleItem(new Item.Properties().food(ModFoodProperties.LEMONADE_BENEDICTION_STRONG).stacksTo(16), EffectsVariant.STRONG, FruitsVariant.BUDDHA_HAND){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.wlgyl.buddha_hand_lemonade_strong.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    // LEMONADE (TIER 1 LONG)
    public static final DeferredItem<Item> BLOOD_ORANGE_LEMONADE_LONG = ITEMS.register("blood_orange_lemonade_long",
            () -> new LemonadeBottleItem(new Item.Properties().food(ModFoodProperties.LEMONADE_LEECH_LONG).stacksTo(16), EffectsVariant.LONG, FruitsVariant.BLOOD_ORANGE){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.wlgyl.blood_orange_lemonade_long.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> GRAPEFRUIT_LEMONADE_LONG = ITEMS.register("grapefruit_lemonade_long",
            () -> new LemonadeBottleItem(new Item.Properties().food(ModFoodProperties.LEMONADE_ACID_LONG).stacksTo(16), EffectsVariant.LONG, FruitsVariant.GRAPEFRUIT){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.wlgyl.grapefruit_lemonade_long.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> CAVIAR_LEMON_LEMONADE_LONG = ITEMS.register("caviar_lemon_lemonade_long",
            () -> new LemonadeBottleItem(new Item.Properties().food(ModFoodProperties.LEMONADE_BUBBLY_LONG).stacksTo(16), EffectsVariant.LONG, FruitsVariant.CAVIAR_LEMON){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.wlgyl.caviar_lemon_lemonade_long.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> BUDDHA_HAND_LEMONADE_LONG = ITEMS.register("buddha_hand_lemonade_long",
            () -> new LemonadeBottleItem(new Item.Properties().food(ModFoodProperties.LEMONADE_BENEDICTION_LONG).stacksTo(16), EffectsVariant.LONG, FruitsVariant.BUDDHA_HAND){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.wlgyl.buddha_hand_lemonade_long.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    // MISC

    public static final DeferredItem<Item> KIWI_SPAWN_EGG = ITEMS.register("kiwi_spawn_egg",
            () -> new DeferredSpawnEggItem(ModEntities.KIWI, 0xdfff12, 0x6efc58,
                    new Item.Properties()));

    public static final DeferredItem<Item> KIWI_BUCKET = ITEMS.register("kiwi_bucket",
            () -> new MobBucketItem(ModEntities.KIWI.get(), Fluids.WATER, SoundEvents.BUCKET_EMPTY_POWDER_SNOW, (new Item.Properties()).stacksTo(1).component(DataComponents.BUCKET_ENTITY_DATA, CustomData.EMPTY)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

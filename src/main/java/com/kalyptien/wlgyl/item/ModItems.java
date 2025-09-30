package com.kalyptien.wlgyl.item;

import com.kalyptien.wlgyl.WhenLifeGivesYouLemonsMod;
import com.kalyptien.wlgyl.entity.ModEntities;
import com.kalyptien.wlgyl.item.custom.JuiceBottleItem;
import com.kalyptien.wlgyl.item.custom.LemonadeBottleItem;
import com.kalyptien.wlgyl.util.AgrumesVariant;
import com.kalyptien.wlgyl.util.EffectsVariant;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

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
            () -> new JuiceBottleItem(new Item.Properties().food(ModFoodProperties.JUICE).stacksTo(16)));
    public static final DeferredItem<Item> ORANGE_JUICE = ITEMS.register("orange_juice",
            () -> new JuiceBottleItem(new Item.Properties().food(ModFoodProperties.JUICE).stacksTo(16)));
    public static final DeferredItem<Item> BLOOD_ORANGE_JUICE = ITEMS.register("blood_orange_juice",
            () -> new JuiceBottleItem(new Item.Properties().food(ModFoodProperties.JUICE).stacksTo(16)));
    public static final DeferredItem<Item> GRAPEFRUIT_JUICE = ITEMS.register("grapefruit_juice",
            () -> new JuiceBottleItem(new Item.Properties().food(ModFoodProperties.JUICE).stacksTo(16)));
    public static final DeferredItem<Item> LIME_JUICE = ITEMS.register("lime_juice",
            () -> new JuiceBottleItem(new Item.Properties().food(ModFoodProperties.JUICE).stacksTo(16)));
    public static final DeferredItem<Item> CAVIAR_LEMON_JUICE = ITEMS.register("caviar_lemon_juice",
            () -> new JuiceBottleItem(new Item.Properties().food(ModFoodProperties.JUICE).stacksTo(16)));
    public static final DeferredItem<Item> BUDDHA_HAND_JUICE = ITEMS.register("buddha_hand_juice",
            () -> new JuiceBottleItem(new Item.Properties().food(ModFoodProperties.JUICE_CLARITY).stacksTo(16)) {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.wlgyl.buddha_hand_juice.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> APPLE_JUICE = ITEMS.register("apple_juice",
            () -> new JuiceBottleItem(new Item.Properties().food(ModFoodProperties.JUICE).stacksTo(16)));
    public static final DeferredItem<Item> GLOW_BERRIES_JUICE = ITEMS.register("glow_berries_juice",
            () -> new JuiceBottleItem(new Item.Properties().food(ModFoodProperties.JUICE_GLOW).stacksTo(16)){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.wlgyl.glow_berries_juice.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> SWEET_BERRIES_JUICE = ITEMS.register("sweet_berries_juice",
            () -> new JuiceBottleItem(new Item.Properties().food(ModFoodProperties.JUICE_SWEET).stacksTo(16)));

    //LEMONADE (TIER 1)
    public static final DeferredItem<Item> LEMON_LEMONADE = ITEMS.register("lemon_lemonade",
            () -> new LemonadeBottleItem(new Item.Properties().food(ModFoodProperties.LEMONADE).stacksTo(16), AgrumesVariant.LEMON, EffectsVariant.NONE));
    public static final DeferredItem<Item> ORANGE_LEMONADE = ITEMS.register("orange_lemonade",
            () -> new LemonadeBottleItem(new Item.Properties().food(ModFoodProperties.LEMONADE).stacksTo(16), AgrumesVariant.ORANGE, EffectsVariant.NONE));
    public static final DeferredItem<Item> LIME_LEMONADE = ITEMS.register("lime_lemonade",
            () -> new LemonadeBottleItem(new Item.Properties().food(ModFoodProperties.LEMONADE).stacksTo(16), AgrumesVariant.LIME, EffectsVariant.NONE));
    public static final DeferredItem<Item> BLOOD_ORANGE_LEMONADE = ITEMS.register("blood_orange_lemonade",
            () -> new LemonadeBottleItem(new Item.Properties().food(ModFoodProperties.LEMONADE_LEECH).stacksTo(16), AgrumesVariant.BLOOD_ORANGE, EffectsVariant.NONE){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.wlgyl.blood_orange_lemonade.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> GRAPEFRUIT_LEMONADE = ITEMS.register("grapefruit_lemonade",
            () -> new LemonadeBottleItem(new Item.Properties().food(ModFoodProperties.LEMONADE_ACID).stacksTo(16), AgrumesVariant.GRAPEFRUIT, EffectsVariant.NONE){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.wlgyl.grapefruit_lemonade.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> CAVIAR_LEMON_LEMONADE = ITEMS.register("caviar_lemon_lemonade",
            () -> new LemonadeBottleItem(new Item.Properties().food(ModFoodProperties.LEMONADE_BUBBLY).stacksTo(16), AgrumesVariant.CAVIAR_LEMON, EffectsVariant.NONE){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.wlgyl.caviar_lemon_lemonade.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> BUDDHA_HAND_LEMONADE = ITEMS.register("buddha_hand_lemonade",
            () -> new LemonadeBottleItem(new Item.Properties().food(ModFoodProperties.LEMONADE_BENEDICTION).stacksTo(16), AgrumesVariant.BUDDHA_HAND, EffectsVariant.NONE){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.wlgyl.buddha_hand_lemonade.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    // LEMONADE (TIER 2)
    public static final DeferredItem<Item> BLOOD_ORANGE_LEMONADE_STRONG = ITEMS.register("blood_orange_lemonade_strong",
            () -> new LemonadeBottleItem(new Item.Properties().food(ModFoodProperties.LEMONADE_LEECH_STRONG).stacksTo(16), AgrumesVariant.BLOOD_ORANGE, EffectsVariant.STRONG){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.wlgyl.blood_orange_lemonade_strong.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> GRAPEFRUIT_LEMONADE_STRONG = ITEMS.register("grapefruit_lemonade_strong",
            () -> new LemonadeBottleItem(new Item.Properties().food(ModFoodProperties.LEMONADE_ACID_STRONG).stacksTo(16), AgrumesVariant.GRAPEFRUIT, EffectsVariant.STRONG){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.wlgyl.grapefruit_lemonade_strong.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> CAVIAR_LEMON_LEMONADE_STRONG = ITEMS.register("caviar_lemon_lemonade_strong",
            () -> new LemonadeBottleItem(new Item.Properties().food(ModFoodProperties.LEMONADE_BUBBLY_STRONG).stacksTo(16), AgrumesVariant.CAVIAR_LEMON, EffectsVariant.STRONG){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.wlgyl.caviar_lemon_lemonade_strong.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> BUDDHA_HAND_LEMONADE_STRONG = ITEMS.register("buddha_hand_lemonade_strong",
            () -> new LemonadeBottleItem(new Item.Properties().food(ModFoodProperties.LEMONADE_BENEDICTION_STRONG).stacksTo(16), AgrumesVariant.BUDDHA_HAND, EffectsVariant.STRONG){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.wlgyl.buddha_hand_lemonade_strong.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    // LEMONADE (TIER 1 LONG)
    public static final DeferredItem<Item> BLOOD_ORANGE_LEMONADE_LONG = ITEMS.register("blood_orange_lemonade_long",
            () -> new LemonadeBottleItem(new Item.Properties().food(ModFoodProperties.LEMONADE_LEECH_LONG).stacksTo(16), AgrumesVariant.BLOOD_ORANGE, EffectsVariant.LONG){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.wlgyl.blood_orange_lemonade_long.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> GRAPEFRUIT_LEMONADE_LONG = ITEMS.register("grapefruit_lemonade_long",
            () -> new LemonadeBottleItem(new Item.Properties().food(ModFoodProperties.LEMONADE_ACID_LONG).stacksTo(16), AgrumesVariant.GRAPEFRUIT, EffectsVariant.LONG){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.wlgyl.grapefruit_lemonade_long.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> CAVIAR_LEMON_LEMONADE_LONG = ITEMS.register("caviar_lemon_lemonade_long",
            () -> new LemonadeBottleItem(new Item.Properties().food(ModFoodProperties.LEMONADE_BUBBLY_LONG).stacksTo(16), AgrumesVariant.CAVIAR_LEMON, EffectsVariant.LONG){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.wlgyl.caviar_lemon_lemonade_long.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> BUDDHA_HAND_LEMONADE_LONG = ITEMS.register("buddha_hand_lemonade_long",
            () -> new LemonadeBottleItem(new Item.Properties().food(ModFoodProperties.LEMONADE_BENEDICTION_LONG).stacksTo(16), AgrumesVariant.BUDDHA_HAND, EffectsVariant.LONG){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.wlgyl.buddha_hand_lemonade_long.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    public static final DeferredItem<Item> KIWI_NORMAL_SPAWN_EGG = ITEMS.register("kiwi_normal_spawn_egg",
            () -> new DeferredSpawnEggItem(ModEntities.KIWI_NORMAL, 0xdfff12, 0x6efc58,
                    new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

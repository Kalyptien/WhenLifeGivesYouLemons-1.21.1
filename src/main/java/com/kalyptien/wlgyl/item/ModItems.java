package com.kalyptien.wlgyl.item;

import com.kalyptien.wlgyl.WhenLifeGivesYouLemonsMod;
import com.kalyptien.wlgyl.entity.ModEntities;
import com.kalyptien.wlgyl.item.custom.JuiceBottleItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(WhenLifeGivesYouLemonsMod.MOD_ID);

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
    public static final DeferredItem<Item> CAVRIAR_LEMON = ITEMS.register("caviar_lemon",
            () -> new Item(new Item.Properties().food(ModFoodProperties.AGRUMES)));
    public static final DeferredItem<Item> BOUDDHA_HAND = ITEMS.register("bouddha_hand",
            () -> new Item(new Item.Properties().food(ModFoodProperties.AGRUMES)));

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
    public static final DeferredItem<Item> CAVRIAR_LEMON_JUICE = ITEMS.register("caviar_lemon_juice",
            () -> new JuiceBottleItem(new Item.Properties().food(ModFoodProperties.JUICE).stacksTo(16)));
    public static final DeferredItem<Item> BOUDDHA_HAND_JUICE = ITEMS.register("bouddha_hand_juice",
            () -> new JuiceBottleItem(new Item.Properties().food(ModFoodProperties.JUICE_CLARITY).stacksTo(16)));

    public static final DeferredItem<Item> APPLE_JUICE = ITEMS.register("apple_juice",
            () -> new JuiceBottleItem(new Item.Properties().food(ModFoodProperties.JUICE).stacksTo(16)));
    public static final DeferredItem<Item> GLOW_BERRIES_JUICE = ITEMS.register("glow_berries_juice",
            () -> new JuiceBottleItem(new Item.Properties().food(ModFoodProperties.JUICE_GLOW).stacksTo(16)));
    public static final DeferredItem<Item> SWEET_BERRIES_JUICE = ITEMS.register("sweet_berries_juice",
            () -> new JuiceBottleItem(new Item.Properties().food(ModFoodProperties.JUICE_SWEET).stacksTo(16)));


    public static final DeferredItem<Item> LEMON_LEMONADE = ITEMS.register("lemon_lemonade",
            () -> new JuiceBottleItem(new Item.Properties().food(ModFoodProperties.LEMONADE).stacksTo(16)));
    public static final DeferredItem<Item> ORANGE_LEMONADE = ITEMS.register("orange_lemonade",
            () -> new JuiceBottleItem(new Item.Properties().food(ModFoodProperties.LEMONADE).stacksTo(16)));
    public static final DeferredItem<Item> LIME_LEMONADE = ITEMS.register("lime_lemonade",
            () -> new JuiceBottleItem(new Item.Properties().food(ModFoodProperties.LEMONADE).stacksTo(16)));
    public static final DeferredItem<Item> BLOOD_ORANGE_LEMONADE = ITEMS.register("blood_orange_lemonade",
            () -> new JuiceBottleItem(new Item.Properties().food(ModFoodProperties.LEMONADE_LEECH).stacksTo(16)));
    public static final DeferredItem<Item> GRAPEFRUIT_LEMONADE = ITEMS.register("grapefruit_lemonade",
            () -> new JuiceBottleItem(new Item.Properties().food(ModFoodProperties.LEMONADE_ACID).stacksTo(16)));
    public static final DeferredItem<Item> CAVRIAR_LEMON_LEMONADE = ITEMS.register("caviar_lemon_lemonade",
            () -> new JuiceBottleItem(new Item.Properties().food(ModFoodProperties.LEMONADE).stacksTo(16)));
    public static final DeferredItem<Item> BOUDDHA_HAND_LEMONADE = ITEMS.register("bouddha_hand_lemonade",
            () -> new JuiceBottleItem(new Item.Properties().food(ModFoodProperties.LEMONADE_BENEDICTION).stacksTo(16)));

    public static final DeferredItem<Item> KIWI_NORMAL_SPAWN_EGG = ITEMS.register("kiwi_normal_spawn_egg",
            () -> new DeferredSpawnEggItem(ModEntities.KIWI_NORMAL, 0xdfff12, 0x6efc58,
                    new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

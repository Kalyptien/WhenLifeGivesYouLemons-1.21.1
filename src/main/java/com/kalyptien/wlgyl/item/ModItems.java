package com.kalyptien.wlgyl.item;

import com.kalyptien.wlgyl.WhenLifeGivesYouLemonsMod;
import com.kalyptien.wlgyl.item.custom.JuiceBottleItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(WhenLifeGivesYouLemonsMod.MOD_ID);

    public static final DeferredItem<Item> LEMON = ITEMS.register("lemon",
            () -> new Item(new Item.Properties().food(ModFoodProperties.AGRUMES)));
    public static final DeferredItem<Item> ORANGE = ITEMS.register("orange",
            () -> new Item(new Item.Properties().food(ModFoodProperties.AGRUMES)));

    public static final DeferredItem<Item> LEMON_JUICE = ITEMS.register("lemon_juice",
            () -> new JuiceBottleItem(new Item.Properties().food(ModFoodProperties.JUICE)));
    public static final DeferredItem<Item> ORANGE_JUICE = ITEMS.register("orange_juice",
            () -> new JuiceBottleItem(new Item.Properties().food(ModFoodProperties.JUICE)));

    public static final DeferredItem<Item> LEMON_LEMONADE = ITEMS.register("lemon_lemonade",
            () -> new JuiceBottleItem(new Item.Properties().food(ModFoodProperties.LEMONADE)));
    public static final DeferredItem<Item> ORANGE_LEMONADE = ITEMS.register("orange_lemonade",
            () -> new JuiceBottleItem(new Item.Properties().food(ModFoodProperties.LEMONADE)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

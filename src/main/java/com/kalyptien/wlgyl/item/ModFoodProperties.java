package com.kalyptien.wlgyl.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties AGRUMES = new FoodProperties.Builder().nutrition(1).saturationModifier(0.2f).build();

    public static final FoodProperties JUICE = new FoodProperties.Builder().nutrition(2).saturationModifier(0.25f).build();

    public static final FoodProperties LEMONADE = new FoodProperties.Builder().nutrition(2).saturationModifier(0.3f).alwaysEdible().build();
}

package com.kalyptien.wlgyl.item;

import com.kalyptien.wlgyl.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {

    public static final FoodProperties AGRUMES = new FoodProperties.Builder().nutrition(1).saturationModifier(0.2f).build();

    public static final FoodProperties JUICE = new FoodProperties.Builder().nutrition(2).saturationModifier(0.25f).alwaysEdible().build();

    public static final FoodProperties JUICE_SWEET = new FoodProperties.Builder().nutrition(2).saturationModifier(0.25f).alwaysEdible()
            .effect(() -> new MobEffectInstance(MobEffects.HEAL, 1), 1f).build();

    public static final FoodProperties JUICE_GLOW = new FoodProperties.Builder().nutrition(2).saturationModifier(0.25f).alwaysEdible()
            .effect(() -> new MobEffectInstance(MobEffects.GLOWING, 400), 1f).build();

    public static final FoodProperties JUICE_CLARITY = new FoodProperties.Builder().nutrition(2).saturationModifier(0.25f).alwaysEdible()
            .effect(() -> new MobEffectInstance(ModEffects.CLARITY_EFFECT, 2400), 1f).build();

    public static final FoodProperties LEMONADE = new FoodProperties.Builder().nutrition(2).saturationModifier(0.3f).alwaysEdible().build();

    public static final FoodProperties LEMONADE_LEECH = new FoodProperties.Builder().nutrition(2).saturationModifier(0.3f).alwaysEdible()
            .effect(() -> new MobEffectInstance(ModEffects.LEECH_EFFECT, 2400), 1f).build();

    public static final FoodProperties LEMONADE_ACID = new FoodProperties.Builder().nutrition(2).saturationModifier(0.3f).alwaysEdible()
            .effect(() -> new MobEffectInstance(ModEffects.ACID_EFFECT, 2400), 1f).build();

    public static final FoodProperties LEMONADE_BENEDICTION = new FoodProperties.Builder().nutrition(2).saturationModifier(0.3f).alwaysEdible()
            .effect(() -> new MobEffectInstance(ModEffects.BENEDICTION_EFFECT, 2400), 1f).build();
}

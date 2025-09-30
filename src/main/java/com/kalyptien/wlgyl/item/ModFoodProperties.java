package com.kalyptien.wlgyl.item;

import com.kalyptien.wlgyl.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {

    public static final FoodProperties AGRUMES = new FoodProperties.Builder().nutrition(1).saturationModifier(0.2f).build();

    // JUICE
    public static final FoodProperties JUICE = new FoodProperties.Builder().nutrition(2).saturationModifier(0.25f).alwaysEdible().build();

    public static final FoodProperties JUICE_SWEET = new FoodProperties.Builder().nutrition(2).saturationModifier(0.25f).alwaysEdible()
            .effect(() -> new MobEffectInstance(MobEffects.HEAL, 1), 1f).build();

    public static final FoodProperties JUICE_GLOW = new FoodProperties.Builder().nutrition(2).saturationModifier(0.25f).alwaysEdible()
            .effect(() -> new MobEffectInstance(MobEffects.GLOWING, 600), 1f).build();

    public static final FoodProperties JUICE_CLARITY = new FoodProperties.Builder().nutrition(2).saturationModifier(0.25f).alwaysEdible()
            .effect(() -> new MobEffectInstance(ModEffects.IMMUTABLE_EFFECT, 1200), 1f).build();

    // LEMONADE
    public static final FoodProperties LEMONADE = new FoodProperties.Builder().nutrition(2).saturationModifier(0.3f).alwaysEdible().build();

    public static final FoodProperties LEMONADE_LEECH = new FoodProperties.Builder().nutrition(2).saturationModifier(0.3f).alwaysEdible()
            .effect(() -> new MobEffectInstance(ModEffects.LEECH_EFFECT, 1200), 1f).build();

    public static final FoodProperties LEMONADE_ACID = new FoodProperties.Builder().nutrition(2).saturationModifier(0.3f).alwaysEdible()
            .effect(() -> new MobEffectInstance(ModEffects.ACID_EFFECT, 1200), 1f).build();

    public static final FoodProperties LEMONADE_BUBBLY = new FoodProperties.Builder().nutrition(2).saturationModifier(0.3f).alwaysEdible()
            .effect(() -> new MobEffectInstance(ModEffects.BUBBLY_EFFECT, 1200), 1f).build();

    public static final FoodProperties LEMONADE_BENEDICTION = new FoodProperties.Builder().nutrition(2).saturationModifier(0.3f).alwaysEdible()
            .effect(() -> new MobEffectInstance(ModEffects.BENEDICTION_EFFECT, 600, 1), 1f).build();

    // STRONG
    public static final FoodProperties LEMONADE_LEECH_STRONG = new FoodProperties.Builder().nutrition(2).saturationModifier(0.3f).alwaysEdible()
            .effect(() -> new MobEffectInstance(ModEffects.LEECH_EFFECT, 1200, 1), 1f).build();

    public static final FoodProperties LEMONADE_ACID_STRONG = new FoodProperties.Builder().nutrition(2).saturationModifier(0.3f).alwaysEdible()
            .effect(() -> new MobEffectInstance(ModEffects.ACID_EFFECT, 1200, 1), 1f).build();

    public static final FoodProperties LEMONADE_BUBBLY_STRONG = new FoodProperties.Builder().nutrition(2).saturationModifier(0.3f).alwaysEdible()
            .effect(() -> new MobEffectInstance(ModEffects.BUBBLY_EFFECT, 1200, 1), 1f).build();

    public static final FoodProperties LEMONADE_BENEDICTION_STRONG = new FoodProperties.Builder().nutrition(2).saturationModifier(0.3f).alwaysEdible()
            .effect(() -> new MobEffectInstance(ModEffects.BENEDICTION_EFFECT, 600, 2), 1f).build();

    // LONG
    public static final FoodProperties LEMONADE_LEECH_LONG = new FoodProperties.Builder().nutrition(2).saturationModifier(0.3f).alwaysEdible()
            .effect(() -> new MobEffectInstance(ModEffects.LEECH_EFFECT, 2400), 1f).build();

    public static final FoodProperties LEMONADE_ACID_LONG = new FoodProperties.Builder().nutrition(2).saturationModifier(0.3f).alwaysEdible()
            .effect(() -> new MobEffectInstance(ModEffects.ACID_EFFECT, 2400), 1f).build();

    public static final FoodProperties LEMONADE_BUBBLY_LONG = new FoodProperties.Builder().nutrition(2).saturationModifier(0.3f).alwaysEdible()
            .effect(() -> new MobEffectInstance(ModEffects.BUBBLY_EFFECT, 2400), 1f).build();

    public static final FoodProperties LEMONADE_BENEDICTION_LONG = new FoodProperties.Builder().nutrition(2).saturationModifier(0.3f).alwaysEdible()
            .effect(() -> new MobEffectInstance(ModEffects.BENEDICTION_EFFECT, 1200, 1), 1f).build();


}

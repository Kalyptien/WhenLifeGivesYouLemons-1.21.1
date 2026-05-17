package com.kalyptien.wlgyl.effect;

import com.kalyptien.wlgyl.WhenLifeGivesYouLemonsMod;
import com.kalyptien.wlgyl.util.FruitsVariant;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, WhenLifeGivesYouLemonsMod.MOD_ID);

    public static final Holder<MobEffect> BENEDICTION_EFFECT = MOB_EFFECTS.register("benediction",
            () -> new BenedictionEffect(MobEffectCategory.BENEFICIAL, FruitsVariant.BUDDHA_HAND.getColor()));

    public static final Holder<MobEffect> IMMUTABLE_EFFECT = MOB_EFFECTS.register("immutable",
            () -> new ImmutableEffect(MobEffectCategory.NEUTRAL, FruitsVariant.BUDDHA_HAND.getColor()));

    public static final Holder<MobEffect> LEECH_EFFECT = MOB_EFFECTS.register("leech",
            () -> new LeechEffect(MobEffectCategory.BENEFICIAL, FruitsVariant.BLOOD_ORANGE.getColor()));

    public static final Holder<MobEffect> ACID_EFFECT = MOB_EFFECTS.register("acid",
            () -> new AcidEffect(MobEffectCategory.BENEFICIAL, FruitsVariant.GRAPEFRUIT.getColor()));

    public static final Holder<MobEffect> BUBBLY_EFFECT = MOB_EFFECTS.register("bubbly",
            () -> new BubblyEffect(MobEffectCategory.NEUTRAL, FruitsVariant.CAVIAR_LEMON.getColor()));


    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}

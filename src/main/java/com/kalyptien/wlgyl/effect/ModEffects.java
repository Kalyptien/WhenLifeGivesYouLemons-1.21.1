package com.kalyptien.wlgyl.effect;

import com.kalyptien.wlgyl.WhenLifeGivesYouLemonsMod;
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
            () -> new BenedictionEffect(MobEffectCategory.BENEFICIAL, 0xc48a25));

    public static final Holder<MobEffect> CLARITY_EFFECT = MOB_EFFECTS.register("clarity",
            () -> new ClarityEffect(MobEffectCategory.NEUTRAL, 0x424242));

    public static final Holder<MobEffect> LEECH_EFFECT = MOB_EFFECTS.register("leech",
            () -> new LeechEffect(MobEffectCategory.BENEFICIAL, 0x520000));

    public static final Holder<MobEffect> ACID_EFFECT = MOB_EFFECTS.register("acid",
            () -> new AcidEffect(MobEffectCategory.BENEFICIAL, 0x8fc425));


    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}

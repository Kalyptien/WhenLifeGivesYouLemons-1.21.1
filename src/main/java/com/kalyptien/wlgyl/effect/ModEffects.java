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

    public static final Holder<MobEffect> BOUDDHA_EFFECT = MOB_EFFECTS.register("bouddha",
            () -> new BouddhaEffect(MobEffectCategory.BENEFICIAL, 0xfeffeb));

    public static final Holder<MobEffect> CLARITY_EFFECT = MOB_EFFECTS.register("clarity",
            () -> new ClarityEffect(MobEffectCategory.NEUTRAL, 0xfeffeb));

    public static final Holder<MobEffect> LICH_EFFECT = MOB_EFFECTS.register("lich",
            () -> new LichEffect(MobEffectCategory.BENEFICIAL, 0xff0000));

    public static final Holder<MobEffect> ACID_EFFECT = MOB_EFFECTS.register("acid",
            () -> new AcidEffect(MobEffectCategory.BENEFICIAL, 0x00ff00));


    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}

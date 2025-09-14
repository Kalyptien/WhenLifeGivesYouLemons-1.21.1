package com.kalyptien.wlgyl.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BouddhaEffect extends MobEffect {
    public BouddhaEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {

        List<MobEffectInstance> currentCollection = livingEntity.getActiveEffects().stream().toList();

        if(!currentCollection.isEmpty()){
            for (int i = 0; i < currentCollection.size(); i++) {
                MobEffectInstance currentEffect = currentCollection.get(i);
                if(currentEffect.getEffect() != ModEffects.BOUDDHA_EFFECT && currentEffect.getAmplifier() < amplifier){
                    livingEntity.addEffect(new MobEffectInstance(currentEffect.getEffect(),
                            currentEffect.getDuration(),
                            currentEffect.getAmplifier() + amplifier,
                            currentEffect.isAmbient(),
                            currentEffect.isVisible(),
                            currentEffect.showIcon()));
                }
            }
        }

        return super.applyEffectTick(livingEntity, amplifier);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}

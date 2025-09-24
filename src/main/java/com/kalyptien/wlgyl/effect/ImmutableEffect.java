package com.kalyptien.wlgyl.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;

import java.util.List;

public class ImmutableEffect extends MobEffect {
    public ImmutableEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {

        List<MobEffectInstance> currentCollection = livingEntity.getActiveEffects().stream().toList();

        if(currentCollection.size() > 1){
            for (int i = 0; i < currentCollection.size(); i++) {
                MobEffectInstance currentEffect = currentCollection.get(i);
                if(currentEffect.getEffect() != ModEffects.IMMUTABLE_EFFECT){
                    livingEntity.addEffect(new MobEffectInstance(
                            currentEffect.getEffect(),
                            1,
                            currentEffect.getAmplifier() + 1,
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

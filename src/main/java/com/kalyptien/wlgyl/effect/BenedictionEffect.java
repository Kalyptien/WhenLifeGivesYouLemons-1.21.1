package com.kalyptien.wlgyl.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

import java.util.List;

public class BenedictionEffect extends MobEffect {
    public BenedictionEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {

        List<MobEffectInstance> effectList = livingEntity.getActiveEffects().stream().toList();

        if(!effectList.isEmpty() && effectList.size() > 1){
            for (int i = 0; i < effectList.size(); i++) {
                MobEffectInstance currentEffect = effectList.get(i);
                if(currentEffect.getEffect().getKey() != ModEffects.BENEDICTION_EFFECT.getKey() && currentEffect.getAmplifier() < amplifier){
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
    public void onMobRemoved(LivingEntity livingEntity, int amplifier, Entity.RemovalReason reason) {
        List<MobEffectInstance> effectList = livingEntity.getActiveEffects().stream().toList();

        if(!effectList.isEmpty() && effectList.size() > 1){
            for (int i = 0; i < effectList.size(); i++) {
                MobEffectInstance currentEffect = effectList.get(i);
                if(currentEffect.getEffect() != ModEffects.BENEDICTION_EFFECT && currentEffect.getAmplifier() < amplifier){
                    livingEntity.addEffect(new MobEffectInstance(currentEffect.getEffect(),
                            currentEffect.getDuration(),
                            currentEffect.getAmplifier() - amplifier,
                            currentEffect.isAmbient(),
                            currentEffect.isVisible(),
                            currentEffect.showIcon()));
                }
            }
        }
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}

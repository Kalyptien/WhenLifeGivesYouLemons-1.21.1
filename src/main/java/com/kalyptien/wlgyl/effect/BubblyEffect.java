package com.kalyptien.wlgyl.effect;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;

import java.util.List;

public class BubblyEffect extends MobEffect {

    public BubblyEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    public void onEffectStarted(LivingEntity livingEntity, int amplifier) {
        livingEntity.setAirSupply(0);
    }

    public void onMobHurt(LivingEntity livingEntity, int amplifier, DamageSource damageSource, float amount) {

        if(livingEntity.getAirSupply() == livingEntity.getMaxAirSupply()){

            List<MobEffectInstance> effectList = livingEntity.getActiveEffects().stream().toList();
            float distance = 3 + Math.round((livingEntity.getAirSupply()/100) * (amplifier));

            List<LivingEntity> entityList = livingEntity.level()
                    .getNearbyEntities(LivingEntity.class,
                            TargetingConditions.forCombat().range(distance), livingEntity,
                            livingEntity.getBoundingBox().inflate(distance, distance/4, distance));

            if(!entityList.isEmpty() && !effectList.isEmpty() && effectList.size() > 1){
                for (int i = 0; i < entityList.size(); i++) {

                    LivingEntity currentEntity = entityList.get(i);
                    System.out.println(currentEntity.getActiveEffects().stream().toList());

                    for (int j = 0; j < effectList.size(); j++) {
                        MobEffectInstance currentEffect = effectList.get(j);

                        if(currentEffect.getEffect() != ModEffects.BUBBLY_EFFECT){
                            currentEntity.addEffect(new MobEffectInstance(currentEffect.getEffect(),
                                    currentEffect.getDuration() / (4/amplifier),
                                    currentEffect.getAmplifier(),
                                    currentEffect.isAmbient(),
                                    currentEffect.isVisible(),
                                    currentEffect.showIcon()));
                        }
                    }

                }
            }
        }

        livingEntity.setAirSupply(0);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}

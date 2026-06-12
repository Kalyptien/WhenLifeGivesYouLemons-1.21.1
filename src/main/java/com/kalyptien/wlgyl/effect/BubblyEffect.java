package com.kalyptien.wlgyl.effect;

import com.kalyptien.wlgyl.sound.ModSounds;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
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

        //Distance of effect
        float distance = Math.round((livingEntity.getAirSupply()/100) * (amplifier + 1));

        //Burp
        livingEntity.level().playSound(null, livingEntity.blockPosition(), SoundEvents.PLAYER_BURP, SoundSource.PLAYERS, 1f, 0.9f);

        //Bubble ring animation
        //TODO : Dont work
        for(int i = 0; i < 25; ++i) {
            double d0 = livingEntity.getRandom().nextGaussian() * 0.02;
            double d1 = livingEntity.getRandom().nextGaussian() * 0.02;
            double d2 = livingEntity.getRandom().nextGaussian() * 0.02;
            ((ServerLevel) livingEntity.level()).addParticle(ParticleTypes.ANGRY_VILLAGER,
                    livingEntity.getRandomX(1.0), livingEntity.getRandomY() + 0.5, livingEntity.getRandomZ(1.0),
                    d0, d1, d2);
        }
        //TODO : Dont work

        // If enough air
        if(livingEntity.getAirSupply() >= 100){

            // Get effectList of the player
            List<MobEffectInstance> effectList = livingEntity.getActiveEffects().stream().toList();

            //Get all mobs and players nerby
            List<LivingEntity> entityList = livingEntity.level()
                    .getNearbyEntities(LivingEntity.class,
                            TargetingConditions.forCombat().range(distance), livingEntity,
                            livingEntity.getBoundingBox().inflate(distance, distance/4, distance));

            //If there is an entity and other effect than "bubbly"
            if(!entityList.isEmpty() && !effectList.isEmpty() && effectList.size() > 1){

                //For each entity and each potion : Give the effect with a shorter length
                for (int i = 0; i < entityList.size(); i++) {

                    LivingEntity currentEntity = entityList.get(i);

                    for (int j = 0; j < effectList.size(); j++) {
                        MobEffectInstance currentEffect = effectList.get(j);

                        if(currentEffect.getEffect().getKey() != ModEffects.BUBBLY_EFFECT.getKey()){
                            currentEntity.addEffect(new MobEffectInstance(currentEffect.getEffect(),
                                    currentEffect.getDuration() / (4/(amplifier + 1)),
                                    currentEffect.getAmplifier(),
                                    currentEffect.isAmbient(),
                                    currentEffect.isVisible(),
                                    currentEffect.showIcon()));
                        }
                    }

                }
            }
        }

        //Reset the air
        livingEntity.setAirSupply(0);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}

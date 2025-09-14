package com.kalyptien.wlgyl.effect;

import com.kalyptien.wlgyl.WhenLifeGivesYouLemonsMod;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.damagesource.DamageContainer;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

@EventBusSubscriber(modid = WhenLifeGivesYouLemonsMod.MOD_ID)
public class AcidEffect extends MobEffect {
    public AcidEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @SubscribeEvent
    public static void acidEffect(LivingDamageEvent.Pre event) {
        if(event.getEntity() instanceof LivingEntity entity && event.getSource().getDirectEntity() instanceof Player player) {
            if (player.hasEffect(ModEffects.ACID_EFFECT)) {
                float dmgOriginal = event.getOriginalDamage();
                float dmgNew = event.getNewDamage();
                if(dmgOriginal != dmgNew){
                    float dmgAcid = (dmgOriginal * player.getEffect(ModEffects.ACID_EFFECT).getAmplifier() / 5.0f);
                    if(dmgNew + dmgAcid > dmgOriginal){
                        event.setNewDamage(dmgOriginal);
                    }
                    else{
                        event.setNewDamage(dmgNew + dmgAcid);
                    }
                }
            }
        }
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}

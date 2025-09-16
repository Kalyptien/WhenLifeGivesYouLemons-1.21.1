package com.kalyptien.wlgyl.effect;

import com.kalyptien.wlgyl.WhenLifeGivesYouLemonsMod;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

@EventBusSubscriber(modid = WhenLifeGivesYouLemonsMod.MOD_ID)
public class LeechEffect extends MobEffect {
    public LeechEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @SubscribeEvent
    public static void leechEffect(LivingDamageEvent.Pre event) {
        if(event.getSource().getDirectEntity() instanceof Player player) {
            if (player.hasEffect(ModEffects.LEECH_EFFECT)) {
                player.heal(
                        event.getNewDamage() > 0 && event.getNewDamage() * (player.getEffect(ModEffects.LEECH_EFFECT).getAmplifier() / 4.0f) > 0 ?
                                event.getNewDamage() * (player.getEffect(ModEffects.LEECH_EFFECT).getAmplifier() / 4.0f) :
                                0.5f
                );
            }
        }
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}

package com.kalyptien.wlgyl.effect;

import com.kalyptien.wlgyl.WhenLifeGivesYouLemonsMod;
import com.kalyptien.wlgyl.block.ModBlocks;
import net.minecraft.world.damagesource.CombatTracker;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

@EventBusSubscriber(modid = WhenLifeGivesYouLemonsMod.MOD_ID)
public class LichEffect extends MobEffect {
    public LichEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @SubscribeEvent
    public static void lichEffect(LivingDamageEvent.Pre event) {
        if(event.getSource().getDirectEntity() instanceof Player player) {
            if (player.hasEffect(ModEffects.LICH_EFFECT)) {
                player.heal(event.getNewDamage() * (player.getEffect(ModEffects.LICH_EFFECT).getAmplifier() / 5.0f));
            }
        }
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}

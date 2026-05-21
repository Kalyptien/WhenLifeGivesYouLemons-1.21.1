package com.kalyptien.wlgyl.item.custom;

import com.kalyptien.wlgyl.util.AgrumesVariant;
import com.kalyptien.wlgyl.util.EffectsVariant;
import com.kalyptien.wlgyl.util.FruitsVariant;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.EffectCures;

public class LemonadeBottleItem extends JuiceBottleItem {
    private FruitsVariant fruitvariant;
    private EffectsVariant effect;

    public LemonadeBottleItem(Properties properties, EffectsVariant effect, FruitsVariant variant) {
        super(properties, variant);

        this.fruitvariant = variant;
        this.effect = effect;
    }

    public FruitsVariant getFruit() {
        return fruitvariant;
    }

    public EffectsVariant getEffect() {
        return effect;
    }
}

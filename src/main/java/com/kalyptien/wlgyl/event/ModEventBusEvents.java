package com.kalyptien.wlgyl.event;

import com.kalyptien.wlgyl.entity.ModEntities;
import com.kalyptien.wlgyl.entity.client.KiwiModel;
import com.kalyptien.wlgyl.entity.custom.KiwiEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

import com.kalyptien.wlgyl.WhenLifeGivesYouLemonsMod;

@EventBusSubscriber(modid = WhenLifeGivesYouLemonsMod.MOD_ID)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(KiwiModel.LAYER_LOCATION, KiwiModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.KIWI_NORMAL.get(), KiwiEntity.createAttributes().build());
    }
}

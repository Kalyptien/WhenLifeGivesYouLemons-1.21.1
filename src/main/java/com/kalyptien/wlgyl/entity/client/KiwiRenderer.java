package com.kalyptien.wlgyl.entity.client;

import com.google.common.collect.Maps;
import com.kalyptien.wlgyl.WhenLifeGivesYouLemonsMod;
import com.kalyptien.wlgyl.entity.KiwiVariant;
import com.kalyptien.wlgyl.entity.custom.KiwiEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;

public class KiwiRenderer extends MobRenderer<KiwiEntity, KiwiModel<KiwiEntity>> {

    private static final Map<KiwiVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(KiwiVariant.class), map -> {
                map.put(KiwiVariant.LEMON,
                        ResourceLocation.fromNamespaceAndPath(WhenLifeGivesYouLemonsMod.MOD_ID, "textures/entity/kiwi/kiwi_lemon.png"));
                map.put(KiwiVariant.ORANGE,
                        ResourceLocation.fromNamespaceAndPath(WhenLifeGivesYouLemonsMod.MOD_ID, "textures/entity/kiwi/kiwi_orange.png"));
                map.put(KiwiVariant.LIME,
                        ResourceLocation.fromNamespaceAndPath(WhenLifeGivesYouLemonsMod.MOD_ID, "textures/entity/kiwi/kiwi_lime.png"));
            });

    public KiwiRenderer(EntityRendererProvider.Context context) {
        super(context, new KiwiModel<>(context.bakeLayer(KiwiModel.LAYER_LOCATION)), 0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(KiwiEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }

    @Override
    public void render(KiwiEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.45f, 0.45f, 0.45f);
        } else {
            poseStack.scale(1f, 1f, 1f);
        }

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}

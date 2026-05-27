package com.kalyptien.wlgyl.entity.client;

import com.google.common.collect.Maps;
import com.kalyptien.wlgyl.WhenLifeGivesYouLemonsMod;
import com.kalyptien.wlgyl.entity.custom.KiwiEntity;
import com.kalyptien.wlgyl.util.FruitsVariant;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.LlamaDecorLayer;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;

public class KiwiRenderer extends MobRenderer<KiwiEntity, KiwiModel<KiwiEntity>> {

    private static final Map<FruitsVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(FruitsVariant.class), map -> {
                map.put(FruitsVariant.LEMON,
                        ResourceLocation.fromNamespaceAndPath(WhenLifeGivesYouLemonsMod.MOD_ID, "textures/entity/kiwi/kiwi_lemon.png"));
                map.put(FruitsVariant.ORANGE,
                        ResourceLocation.fromNamespaceAndPath(WhenLifeGivesYouLemonsMod.MOD_ID, "textures/entity/kiwi/kiwi_orange.png"));
                map.put(FruitsVariant.LIME,
                        ResourceLocation.fromNamespaceAndPath(WhenLifeGivesYouLemonsMod.MOD_ID, "textures/entity/kiwi/kiwi_lime.png"));
                map.put(FruitsVariant.BLOOD_ORANGE,
                        ResourceLocation.fromNamespaceAndPath(WhenLifeGivesYouLemonsMod.MOD_ID, "textures/entity/kiwi/kiwi_blood_orange.png"));
                map.put(FruitsVariant.GRAPEFRUIT,
                        ResourceLocation.fromNamespaceAndPath(WhenLifeGivesYouLemonsMod.MOD_ID, "textures/entity/kiwi/kiwi_grapefruit.png"));
                map.put(FruitsVariant.BUDDHA_HAND,
                        ResourceLocation.fromNamespaceAndPath(WhenLifeGivesYouLemonsMod.MOD_ID, "textures/entity/kiwi/kiwi_buddha_hand.png"));
                map.put(FruitsVariant.CAVIAR_LEMON,
                        ResourceLocation.fromNamespaceAndPath(WhenLifeGivesYouLemonsMod.MOD_ID, "textures/entity/kiwi/kiwi_caviar_lemon.png"));

            });

    public KiwiRenderer(EntityRendererProvider.Context context) {
        super(context, new KiwiModel<>(context.bakeLayer(KiwiModel.LAYER_LOCATION)), 0.25f);
        this.addLayer(new KiwiDecorLayer(this, context.getModelSet()));
    }

    @Override
    public ResourceLocation getTextureLocation(KiwiEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }

    @Override
    public void render(KiwiEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        poseStack.scale(1f, 1f, 1f);

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}

package com.kalyptien.wlgyl.entity.client;

import com.kalyptien.wlgyl.WhenLifeGivesYouLemonsMod;
import com.kalyptien.wlgyl.entity.custom.KiwiNormalEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class KiwiRenderer extends MobRenderer<KiwiNormalEntity, KiwiModel<KiwiNormalEntity>> {

    public KiwiRenderer(EntityRendererProvider.Context context) {
        super(context, new KiwiModel<>(context.bakeLayer(KiwiModel.LAYER_LOCATION)), 0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(KiwiNormalEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(WhenLifeGivesYouLemonsMod.MOD_ID, "textures/entity/kiwi/kiwi_lemon.png");
    }

    @Override
    public void render(KiwiNormalEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.45f, 0.45f, 0.45f);
        } else {
            poseStack.scale(1f, 1f, 1f);
        }

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}

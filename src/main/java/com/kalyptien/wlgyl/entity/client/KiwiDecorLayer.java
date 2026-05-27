package com.kalyptien.wlgyl.entity.client;

import com.kalyptien.wlgyl.WhenLifeGivesYouLemonsMod;
import com.kalyptien.wlgyl.entity.custom.KiwiEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;

public class KiwiDecorLayer extends RenderLayer<KiwiEntity, KiwiModel<KiwiEntity>> {
    private static final ResourceLocation[] TEXTURE_LOCATION = new ResourceLocation[]{
            ResourceLocation.fromNamespaceAndPath(WhenLifeGivesYouLemonsMod.MOD_ID,"textures/entity/kiwi/decor/white.png"),
            ResourceLocation.fromNamespaceAndPath(WhenLifeGivesYouLemonsMod.MOD_ID,"textures/entity/kiwi/decor/orange.png"),
            ResourceLocation.fromNamespaceAndPath(WhenLifeGivesYouLemonsMod.MOD_ID,"textures/entity/kiwi/decor/magenta.png"),
            ResourceLocation.fromNamespaceAndPath(WhenLifeGivesYouLemonsMod.MOD_ID,"textures/entity/kiwi/decor/light_blue.png"),
            ResourceLocation.fromNamespaceAndPath(WhenLifeGivesYouLemonsMod.MOD_ID,"textures/entity/kiwi/decor/yellow.png"),
            ResourceLocation.fromNamespaceAndPath(WhenLifeGivesYouLemonsMod.MOD_ID,"textures/entity/kiwi/decor/lime.png"),
            ResourceLocation.fromNamespaceAndPath(WhenLifeGivesYouLemonsMod.MOD_ID,"textures/entity/kiwi/decor/pink.png"),
            ResourceLocation.fromNamespaceAndPath(WhenLifeGivesYouLemonsMod.MOD_ID,"textures/entity/kiwi/decor/gray.png"),
            ResourceLocation.fromNamespaceAndPath(WhenLifeGivesYouLemonsMod.MOD_ID,"textures/entity/kiwi/decor/light_gray.png"),
            ResourceLocation.fromNamespaceAndPath(WhenLifeGivesYouLemonsMod.MOD_ID,"textures/entity/kiwi/decor/cyan.png"),
            ResourceLocation.fromNamespaceAndPath(WhenLifeGivesYouLemonsMod.MOD_ID,"textures/entity/kiwi/decor/purple.png"),
            ResourceLocation.fromNamespaceAndPath(WhenLifeGivesYouLemonsMod.MOD_ID,"textures/entity/kiwi/decor/blue.png"),
            ResourceLocation.fromNamespaceAndPath(WhenLifeGivesYouLemonsMod.MOD_ID,"textures/entity/kiwi/decor/brown.png"),
            ResourceLocation.fromNamespaceAndPath(WhenLifeGivesYouLemonsMod.MOD_ID,"textures/entity/kiwi/decor/green.png"),
            ResourceLocation.fromNamespaceAndPath(WhenLifeGivesYouLemonsMod.MOD_ID,"textures/entity/kiwi/decor/red.png"),
            ResourceLocation.fromNamespaceAndPath(WhenLifeGivesYouLemonsMod.MOD_ID,"textures/entity/kiwi/decor/black.png")};

    private final KiwiModel<KiwiEntity> model;

    public KiwiDecorLayer(RenderLayerParent<KiwiEntity, KiwiModel<KiwiEntity>> renderer, EntityModelSet modelSet) {
        super(renderer);
        this.model = new KiwiModel(modelSet.bakeLayer(KiwiModel.LAYER_LOCATION_DECOR));
    }

    public void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight, KiwiEntity livingEntity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        DyeColor dyecolor = livingEntity.getSwag();
        ResourceLocation resourcelocation;
        if(dyecolor != null){
            resourcelocation = TEXTURE_LOCATION[dyecolor.getId()];
        }
        else{
            resourcelocation =  ResourceLocation.fromNamespaceAndPath(WhenLifeGivesYouLemonsMod.MOD_ID,"textures/entity/kiwi/decor/none.png");
        }


        ((KiwiModel)this.getParentModel()).copyPropertiesTo(this.model);
        this.model.setupAnim(livingEntity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        VertexConsumer vertexconsumer = buffer.getBuffer(RenderType.entityCutoutNoCull(resourcelocation));
        this.model.renderToBuffer(poseStack, vertexconsumer, packedLight, OverlayTexture.NO_OVERLAY);
    }
}

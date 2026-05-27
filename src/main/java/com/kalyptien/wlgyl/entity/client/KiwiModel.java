package com.kalyptien.wlgyl.entity.client;

import com.kalyptien.wlgyl.WhenLifeGivesYouLemonsMod;
import com.kalyptien.wlgyl.entity.custom.KiwiEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

public class KiwiModel<T extends KiwiEntity> extends HierarchicalModel<T> {

    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION =
            new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(WhenLifeGivesYouLemonsMod.MOD_ID, "kiwi"), "main");

    public static final ModelLayerLocation LAYER_LOCATION_DECOR =
            new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(WhenLifeGivesYouLemonsMod.MOD_ID, "kiwi"), "decor");

    private final ModelPart Kiwi;
    private final ModelPart Head;

    public KiwiModel(ModelPart root) {
        this.Kiwi = root.getChild("Kiwi");
        this.Head = this.Kiwi.getChild("Head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition Kiwi = partdefinition.addOrReplaceChild("Kiwi", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition Body = Kiwi.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 13).addBox(-3.0F, -3.25F, 0.5F, 6.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-3.0F, -3.25F, 3.5F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.75F, -2.5F));

        PartDefinition Head = Kiwi.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(18, 0).addBox(-0.5F, -0.25F, -9.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(12, 14).addBox(-2.0F, -2.25F, -4.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.75F, 0.0F));

        PartDefinition cube_r1 = Head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(12, 27).addBox(1.0F, -2.0F, -1.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.45F, -1.25F, -0.05F, 0.0F, -0.829F, 0.0F));

        PartDefinition cube_r2 = Head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(12, 27).addBox(1.0F, -2.0F, -1.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, -1.25F, 1.4F, 0.0F, 0.829F, 0.0F));

        PartDefinition LegL = Kiwi.addOrReplaceChild("LegL", CubeListBuilder.create().texOffs(0, 22).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 4).addBox(-0.5F, 5.0F, 0.5F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(0, 3).addBox(-0.5F, 7.0F, -2.5F, 1.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.75F, -7.0F, 4.0F));

        PartDefinition LegR = Kiwi.addOrReplaceChild("LegR", CubeListBuilder.create().texOffs(0, 3).addBox(-0.5F, 7.0F, -2.5F, 1.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 4).addBox(-0.5F, 5.0F, 0.5F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(0, 22).mirror().addBox(-1.0F, -1.0F, -2.0F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.75F, -7.0F, 4.0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

        this.animateWalk(KiwiAnimation.KIWI_WALK, limbSwing, limbSwingAmount, 10f, 10f);
        this.animate(entity.sitAnimationState, KiwiAnimation.KIWI_SIT, ageInTicks, 1f);
        this.animate(entity.idleAnimationState, KiwiAnimation.KIWI_IDLE, ageInTicks, 1f);
    }


    private void applyHeadRotation(float headYaw, float headPitch) {
        headYaw = Mth.clamp(headYaw, -30f, 30f);
        headPitch = Mth.clamp(headPitch, -25f, 45);

        this.Head.yRot = headYaw * ((float)Math.PI / 180f);
        this.Head.xRot = headPitch *  ((float)Math.PI / 180f);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        Kiwi.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart root() {
        return Kiwi;
    }
}

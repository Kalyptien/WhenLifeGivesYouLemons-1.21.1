package com.kalyptien.wlgyl.entity.client;

import com.kalyptien.wlgyl.WhenLifeGivesYouLemonsMod;
import com.kalyptien.wlgyl.entity.custom.KiwiNormalEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

public class KiwiModel<T extends KiwiNormalEntity> extends HierarchicalModel<T> {

    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION =
            new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(WhenLifeGivesYouLemonsMod.MOD_ID, "kiwi_normal"), "main");

    private final ModelPart Body;
    private final ModelPart Head;
    private final ModelPart LegL;
    private final ModelPart LegR;

    public KiwiModel(ModelPart root) {
        this.Body = root.getChild("Body");
        this.Head = root.getChild("Head");
        this.LegL = root.getChild("LegL");
        this.LegR = root.getChild("LegR");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 12).addBox(-3.0F, -3.25F, 0.5F, 6.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-3.0F, -3.25F, 3.5F, 6.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 17.25F, -2.5F));

        PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(18, 20).addBox(-0.5F, -0.25F, -8.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(18, 12).addBox(-2.0F, -2.25F, -4.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.25F, 0.0F));

        PartDefinition LegL = partdefinition.addOrReplaceChild("LegL", CubeListBuilder.create().texOffs(22, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(22, 8).addBox(-0.5F, 1.0F, 0.5F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(10, 21).addBox(-0.5F, 3.0F, -2.5F, 1.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(1.75F, 21.0F, 3.0F));

        PartDefinition LegR = partdefinition.addOrReplaceChild("LegR", CubeListBuilder.create().texOffs(22, 5).addBox(-0.5F, 3.0F, -2.5F, 1.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(22, 10).addBox(-0.5F, 1.0F, 0.5F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(0, 21).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.75F, 21.0F, 3.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

        this.animateWalk(KiwiAnimation.KIWI_NORMAL_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.animate(entity.sitAnimationState, KiwiAnimation.KIWI_NORMAL_SIT, ageInTicks, 0f);
    }


    private void applyHeadRotation(float headYaw, float headPitch) {
        headYaw = Mth.clamp(headYaw, -30f, 30f);
        headPitch = Mth.clamp(headPitch, -25f, 45);

        this.Head.yRot = headYaw * ((float)Math.PI / 180f);
        this.Head.xRot = headPitch *  ((float)Math.PI / 180f);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        LegL.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        LegR.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart root() {
        return Body;
    }
}

package com.kalyptien.wlgyl.entity.client;

import com.kalyptien.wlgyl.WhenLifeGivesYouLemonsMod;
import com.kalyptien.wlgyl.entity.custom.KiwiEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
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

        PartDefinition Body = Kiwi.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 12).addBox(-3.0F, -3.25F, 0.5F, 6.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-3.0F, -3.25F, 3.5F, 6.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.75F, -2.5F));

        PartDefinition Head = Kiwi.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(18, 20).addBox(-0.5F, -0.25F, -8.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(18, 12).addBox(-2.0F, -2.25F, -4.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.75F, 0.0F));

        PartDefinition LegL = Kiwi.addOrReplaceChild("LegL", CubeListBuilder.create().texOffs(22, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(22, 8).addBox(-0.5F, 1.0F, 0.5F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(10, 21).addBox(-0.5F, 3.0F, -2.5F, 1.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(1.75F, -3.0F, 3.0F));

        PartDefinition LegR = Kiwi.addOrReplaceChild("LegR", CubeListBuilder.create().texOffs(22, 5).addBox(-0.5F, 3.0F, -2.5F, 1.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(22, 10).addBox(-0.5F, 1.0F, 0.5F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(0, 21).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.75F, -3.0F, 3.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
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

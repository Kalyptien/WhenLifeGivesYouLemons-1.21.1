package com.kalyptien.wlgyl.entity.client;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class KiwiAnimation {

    public static final AnimationDefinition KIWI_NORMAL_WALK = AnimationDefinition.Builder.withLength(1.0F).looping()
            .addAnimation("Body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 3.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -3.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("Head", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(0.2F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75F, KeyframeAnimations.posVec(-0.2F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("LegL", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(-20.0F, 0.0F, 5.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75F, KeyframeAnimations.degreeVec(20.0F, 0.0F, -5.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("LegR", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 5.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75F, KeyframeAnimations.degreeVec(-20.0F, 0.0F, -5.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .build();

    public static final AnimationDefinition KIWI_NORMAL_SIT = AnimationDefinition.Builder.withLength(26.0F)
            .addAnimation("Body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5833F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(25.5417F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(25.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(25.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(26.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("Body", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, 4.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5833F, KeyframeAnimations.posVec(0.0F, 7.06F, 6.5F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, 1.76F, 6.5F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(25.375F, KeyframeAnimations.posVec(0.0F, 1.76F, 6.5F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(25.5417F, KeyframeAnimations.posVec(0.0F, 9.06F, 6.5F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(25.7083F, KeyframeAnimations.posVec(0.0F, 3.0F, -2.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(25.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(26.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("Body", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.4167F, KeyframeAnimations.scaleVec(1.0F, 1.3F, 1.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5833F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75F, KeyframeAnimations.scaleVec(1.275F, 1.175F, 1.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(25.375F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(25.5417F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.3F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(25.875F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(26.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("Head", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, 6.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5833F, KeyframeAnimations.posVec(0.0F, 4.0F, 3.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, -1.5F, 3.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, -0.5F, 3.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(25.375F, KeyframeAnimations.posVec(0.0F, -0.5F, 3.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(25.5417F, KeyframeAnimations.posVec(0.0F, 6.0F, 3.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(25.7083F, KeyframeAnimations.posVec(0.0F, 3.0F, -2.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(25.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(26.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("LegL", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.4167F, KeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5833F, KeyframeAnimations.degreeVec(-70.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75F, KeyframeAnimations.degreeVec(-110.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(-90.0F, -25.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.0F, KeyframeAnimations.degreeVec(-100.0F, -25.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(5.0F, KeyframeAnimations.degreeVec(-90.0F, -25.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(7.0F, KeyframeAnimations.degreeVec(-100.0F, -25.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(9.0F, KeyframeAnimations.degreeVec(-90.0F, -25.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(11.0F, KeyframeAnimations.degreeVec(-100.0F, -25.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(13.0F, KeyframeAnimations.degreeVec(-90.0F, -25.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(15.0F, KeyframeAnimations.degreeVec(-100.0F, -25.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(17.0F, KeyframeAnimations.degreeVec(-90.0F, -25.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(19.0F, KeyframeAnimations.degreeVec(-100.0F, -25.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(21.0F, KeyframeAnimations.degreeVec(-90.0F, -25.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(23.0F, KeyframeAnimations.degreeVec(-100.0F, -25.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(25.0F, KeyframeAnimations.degreeVec(-90.0F, -25.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(25.25F, KeyframeAnimations.degreeVec(-60.0F, -25.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(25.375F, KeyframeAnimations.degreeVec(-120.0F, -25.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(25.5417F, KeyframeAnimations.degreeVec(-70.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(25.7083F, KeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(25.875F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(26.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("LegL", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, 3.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5833F, KeyframeAnimations.posVec(0.0F, 4.0F, -3.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, -1.0F, -3.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(25.375F, KeyframeAnimations.posVec(0.0F, -1.0F, -3.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(25.5417F, KeyframeAnimations.posVec(0.0F, 4.0F, -3.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(25.7083F, KeyframeAnimations.posVec(0.0F, 3.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(25.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(26.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("LegR", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.4167F, KeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5833F, KeyframeAnimations.degreeVec(-70.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75F, KeyframeAnimations.degreeVec(-110.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(-90.0F, 25.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.0F, KeyframeAnimations.degreeVec(-80.0F, 25.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(5.0F, KeyframeAnimations.degreeVec(-90.0F, 25.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(7.0F, KeyframeAnimations.degreeVec(-80.0F, 25.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(9.0F, KeyframeAnimations.degreeVec(-90.0F, 25.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(11.0F, KeyframeAnimations.degreeVec(-80.0F, 25.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(13.0F, KeyframeAnimations.degreeVec(-90.0F, 25.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(15.0F, KeyframeAnimations.degreeVec(-80.0F, 25.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(17.0F, KeyframeAnimations.degreeVec(-90.0F, 25.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(19.0F, KeyframeAnimations.degreeVec(-80.0F, 25.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(21.0F, KeyframeAnimations.degreeVec(-90.0F, 25.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(23.0F, KeyframeAnimations.degreeVec(-80.0F, 25.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(25.0F, KeyframeAnimations.degreeVec(-90.0F, 25.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(25.25F, KeyframeAnimations.degreeVec(-60.0F, 25.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(25.375F, KeyframeAnimations.degreeVec(-120.0F, 25.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(25.5417F, KeyframeAnimations.degreeVec(-70.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(25.7083F, KeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(25.875F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(26.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("LegR", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, 3.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5833F, KeyframeAnimations.posVec(0.0F, 4.0F, -3.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, -1.0F, -3.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(25.375F, KeyframeAnimations.posVec(0.0F, -1.0F, -3.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(25.5417F, KeyframeAnimations.posVec(0.0F, 4.0F, -3.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(25.7083F, KeyframeAnimations.posVec(0.0F, 3.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(25.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(26.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .build();
}

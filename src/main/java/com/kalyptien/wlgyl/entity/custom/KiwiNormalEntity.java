package com.kalyptien.wlgyl.entity.custom;


import com.kalyptien.wlgyl.entity.ModEntities;
import com.kalyptien.wlgyl.item.ModItems;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.registries.DeferredItem;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KiwiNormalEntity extends Animal {

    private static final Logger log = LoggerFactory.getLogger(KiwiNormalEntity.class);
    public final AnimationState sitAnimationState = new AnimationState();
    private int sitAnimationTimeout = 0;
    private int timeSitting = 0;
    public DeferredItem<Item> agrume = ModItems.LEMON;

    public KiwiNormalEntity(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));

        this.goalSelector.addGoal(1, new PanicGoal(this, 2.0));
        this.goalSelector.addGoal(2, new TemptGoal(this, 1.25, stack -> stack.is(agrume), false));

        this.goalSelector.addGoal(3, new FollowParentGoal(this, 1.25));

        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 20d)
                .add(Attributes.MOVEMENT_SPEED, 0.15D)
                .add(Attributes.ARMOR, 10d)
                .add(Attributes.FOLLOW_RANGE, 24D);
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return stack.is(agrume.get());
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob otherParent) {
        return ModEntities.KIWI_NORMAL.get().create(level);
    }

    private void setupAnimationStates() {

        if(this.sitAnimationTimeout <= 0) {
            this.sitAnimationTimeout = 5000;
            this.sitAnimationState.start(this.tickCount);
            this.timeSitting = 540;
            this.setPose(Pose.SITTING);
            this.gameEvent(GameEvent.ENTITY_ACTION);
        } else {
            --this.sitAnimationTimeout;
        }

        if(!this.isSitting()){
            this.timeSitting = 0;
            this.sitAnimationState.stop();
            this.setPose(Pose.STANDING);
            this.gameEvent(GameEvent.ENTITY_ACTION);
        }
        else {
            if (this.isSitting()) {
                --this.timeSitting;
            }
        }

        if (isSitting() && this.isInWater()) {
            this.timeSitting = 0;
        }

        if (isSitting() && this.hurtTime > 0) {
            this.timeSitting = 0;
        }

    }

    public void travel(Vec3 travelVector) {
        if (this.sitAnimationState.isStarted() && this.onGround()) {
            this.setDeltaMovement(this.getDeltaMovement().multiply(0.0, 1.0, 0.0));
            travelVector = travelVector.multiply(0.0, 1.0, 0.0);
        }

        super.travel(travelVector);
    }

    public boolean isSitting() {
        return this.timeSitting > 0;
    }

    @Override
    public void tick() {
        super.tick();

        if(this.level().isClientSide()) {
            this.setupAnimationStates();
        }
    }
}

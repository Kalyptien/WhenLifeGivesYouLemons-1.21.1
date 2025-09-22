package com.kalyptien.wlgyl.entity.custom;


import com.kalyptien.wlgyl.entity.KiwiVariant;
import com.kalyptien.wlgyl.entity.ModEntities;
import com.kalyptien.wlgyl.item.ModItems;
import com.kalyptien.wlgyl.sound.ModSounds;
import net.minecraft.Util;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.nbt.Tag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.neoforged.neoforge.registries.DeferredItem;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class KiwiEntity extends Animal {

    private static final Logger log = LoggerFactory.getLogger(KiwiEntity.class);
    public final AnimationState sitAnimationState = new AnimationState();
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public DeferredItem<Item> agrume = ModItems.LEMON;

    private static final EntityDataAccessor<Integer> VARIANT =
            SynchedEntityData.defineId(KiwiEntity.class, EntityDataSerializers.INT);

    public KiwiEntity(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
        this.moveControl = new KiwiEntity.KiwiMoveControl();
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));

        this.goalSelector.addGoal(1, new PanicGoal(this, 2.0));
        this.goalSelector.addGoal(2, new TemptGoal(this, 1.25, stack -> stack.is(agrume), false));

        this.goalSelector.addGoal(3, new FollowParentGoal(this, 1.25));

        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(6, new SitGoal());
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 20d)
                .add(Attributes.MOVEMENT_SPEED, 0.10D)
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
        KiwiVariant variant = Util.getRandom(KiwiVariant.values(), this.random);
        KiwiEntity baby = ModEntities.KIWI_NORMAL.get().create(level);
        baby.setVariant(variant);
        return baby;
    }

    private void setupAnimationStates() {

        if(!this.isSitting()){
            if(this.idleAnimationTimeout <= 0) {
                this.idleAnimationTimeout = (int)Math.round(5000 * Math.random());
                this.idleAnimationState.start(this.tickCount);
            } else {
                --this.idleAnimationTimeout;
            }
        }

        if(isSitting()){
            if(!this.sitAnimationState.isStarted()){
                this.sitAnimationState.start(this.tickCount);
            }
        }
        else{
            if(this.sitAnimationState.isStarted()) {
                this.sitAnimationState.stop();
            }
        }

    }

    void clearStates() {
        this.setSitting(false);
        this.setJumping(true);
    }

    public boolean isSitting() {
        return this.getPose() == Pose.SITTING;
    }

    void setSitting(boolean siting) {
        if(siting){
            this.setPose(Pose.SITTING);
        }
        else{
            this.setPose(Pose.STANDING);
        }
    }

    @Override
    public void tick() {
        super.tick();

        if(this.level().isClientSide()) {
            this.setupAnimationStates();
        }
    }

    /* VARIANT */
    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(VARIANT, 0);
    }

    private int getTypeVariant() {
        return this.entityData.get(VARIANT);
    }

    public KiwiVariant getVariant() {
        return KiwiVariant.byId(this.getTypeVariant() & 255);
    }

    public void setVariant(KiwiVariant variant) {
        this.entityData.set(VARIANT, variant.getId() & 255);
    }

    boolean canMove() {
        return !this.isSitting();
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Variant", this.getTypeVariant());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.entityData.set(VARIANT, compound.getInt("Variant"));
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty,
                                        MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData) {
        if(spawnType == MobSpawnType.SPAWN_EGG){
            KiwiVariant variant = Util.getRandom(KiwiVariant.values(), this.random);
            this.setVariant(variant);
        }
        else{
            this.setVariant(this.getVariant());
        }
        return super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
    }

    protected SoundEvent getAmbientSound() {
        return ModSounds.KIWI_AMBIENT.get();
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.KIWI_DEATH.get();
    }

    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return ModSounds.KIWI_HURT.get();
    }

    //GOAL

    class SitGoal extends Goal {
        private static final int WAIT_TIME_BEFORE_SIT = reducedTickDelay(100);
        private int countdown;
        private int animationDuration;

        public SitGoal() {
            super();
            this.countdown = KiwiEntity.this.random.nextInt(WAIT_TIME_BEFORE_SIT);
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.JUMP));
        }

        public boolean canUse() {
            return KiwiEntity.this.xxa == 0.0F && KiwiEntity.this.yya == 0.0F && KiwiEntity.this.zza == 0.0F ? this.canSit() || KiwiEntity.this.isSitting() : false;
        }

        public boolean canContinueToUse() {
            --this.animationDuration;

            if(animationDuration > 0){
                --this.animationDuration;
                return canSit();
            }
            else{
                return false;
            }
        }

        private boolean canSit() {
            if (this.countdown > 0) {
                --this.countdown;
                return false;
            } else {
                return !KiwiEntity.this.isInPowderSnow && !KiwiEntity.this.isInWater() && !KiwiEntity.this.isInLava();
            }
        }

        public void stop() {
            this.countdown = KiwiEntity.this.random.nextInt(WAIT_TIME_BEFORE_SIT);
            this.animationDuration = 0;
            KiwiEntity.this.clearStates();
        }

        public void start() {
            this.animationDuration = 315;
            KiwiEntity.this.setJumping(false);
            KiwiEntity.this.setSitting(true);
            KiwiEntity.this.getNavigation().stop();
            KiwiEntity.this.getMoveControl().setWantedPosition(KiwiEntity.this.getX(), KiwiEntity.this.getY(), KiwiEntity.this.getZ(), 0.0);
        }
    }

    // CONTROLS

    class KiwiMoveControl extends MoveControl {
        public KiwiMoveControl() {
            super(KiwiEntity.this);
        }

        public void tick() {
            if (KiwiEntity.this.canMove()) {
                super.tick();
            }

        }
    }

}

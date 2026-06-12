package com.kalyptien.wlgyl.entity.custom;


import com.kalyptien.wlgyl.util.FruitsVariant;
import com.kalyptien.wlgyl.item.ModItems;
import com.kalyptien.wlgyl.sound.ModSounds;
import net.minecraft.Util;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Bucketable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WoolCarpetBlock;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.registries.DeferredItem;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;

import static net.minecraft.world.level.block.Block.popResource;

public class KiwiEntity extends Animal implements Bucketable {

    public final AnimationState sitAnimationState = new AnimationState();
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public DeferredItem<Item> agrume = ModItems.LEMON;

    private boolean isWet;
    private float shakeAnim = 0.0F;

    private static final EntityDataAccessor<Integer> VARIANT =
            SynchedEntityData.defineId(KiwiEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> CARPET_DYE =
            SynchedEntityData.defineId(KiwiEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> FROM_BUCKET =
            SynchedEntityData.defineId(KiwiEntity.class, EntityDataSerializers.BOOLEAN);;

    public KiwiEntity(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
        this.moveControl = new KiwiEntity.KiwiMoveControl(this);
    }

    // GOAL

    @Override
    protected void registerGoals() {

        this.goalSelector.addGoal(0, new SitGoal(this));

        this.goalSelector.addGoal(1, new PanicGoal(this, 4.0));
        this.goalSelector.addGoal(2, new TemptGoal(this, 1.25, stack -> stack.is(agrume), false));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 1.0));

        this.goalSelector.addGoal(4, new FloatGoal(this));

        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
    }

    // MISC

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
        return null;
    }

    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    public InteractionResult mobInteract(Player player, InteractionHand hand) {

        if(player.getItemInHand(hand).is(ItemTags.WOOL_CARPETS) ){
            Block block = Block.byItem(player.getItemInHand(hand).getItem());
            DyeColor color = ((WoolCarpetBlock)block).getColor();

            if(this.getCarpetDye() != -1){
                ItemStack carpet = new ItemStack(this.getCarpetBlock(), 1);
                popResource(this.level(), this.blockPosition(), carpet);
            }

            ItemStack stack = player.getItemInHand(hand);
            stack.shrink(1);
            player.setItemInHand(hand, stack);
            this.setCarpetDye(color);

            return InteractionResult.SUCCESS;
        } else if (player.getItemInHand(hand).isEmpty() && player.isCrouching()) {

            ItemStack carpet = new ItemStack(this.getCarpetBlock(), 1);
            popResource(this.level(), this.blockPosition(), carpet);
            this.setCarpetDye(-1);

            return InteractionResult.SUCCESS;
        }
        else{
            return (InteractionResult)Bucketable.bucketMobPickup(player, hand, this).orElse(super.mobInteract(player, hand));
        }
    }

    // ANIM

    private void setupAnimationStates() {

        if(!this.isSitting()){
            if(this.idleAnimationTimeout <= 0) {
                if(!this.idleAnimationState.isStarted()){
                    this.idleAnimationTimeout = (int)Math.round(5000 * Math.random());
                    this.idleAnimationState.start(this.tickCount);
                    this.gameEvent(GameEvent.ENTITY_ACTION);
                }
            } else if (this.isWet && (!this.isInWaterRainOrBubble() && !this.isInWater())) {
                if(!this.idleAnimationState.isStarted()){
                    this.idleAnimationState.start(this.tickCount);
                    this.gameEvent(GameEvent.ENTITY_ACTION);
                }
            } else {
                if(this.idleAnimationState.isStarted()) {
                    this.idleAnimationState.stop();
                }
                --this.idleAnimationTimeout;
            }
        }

        if(isSitting()){
            if(!this.sitAnimationState.isStarted()){
                this.sitAnimationState.start(this.tickCount);
                this.gameEvent(GameEvent.ENTITY_ACTION);
            }
        }
        else{
            if(this.sitAnimationState.isStarted()) {
                this.sitAnimationState.stop();
            }
        }
    }

    // SET & GET

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

    boolean canMove() {
        return !this.isSitting();
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Variant", this.getTypeVariant());
        compound.putBoolean("FromBucket", this.fromBucket());
        compound.putInt("Carpet_Dye", this.getCarpetDye());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.entityData.set(VARIANT, compound.getInt("Variant"));
        this.setFromBucket(compound.getBoolean("FromBucket"));
        this.entityData.set(CARPET_DYE, compound.getInt("Carpet_Dye"));
    }

    // TICK

    @Override
    public void tick() {
        super.tick();

        if(this.level().isClientSide()) {
            if (this.isInWaterRainOrBubble() || this.isInWater()) {
                this.isWet = true;
            }

            if(this.idleAnimationState.isStarted() && this.isWet && (!this.isInWaterRainOrBubble() && !this.isInWater())){
                this.shakeAnim += 0.05F;

                //TODO : Dont work
                if(this.shakeAnim == 0.15F){
                    this.level().playSound(null, this.blockPosition(), ModSounds.KIWI_SHAKE.get(), SoundSource.NEUTRAL, 1f, 0.8f);
                }
                //TODO : Dont work

                if (this.shakeAnim >= 2.0F) {
                    this.isWet = false;
                    this.shakeAnim = 0.0F;
                }

                if (this.shakeAnim > 0.5F) {
                    float f = (float)this.getY();
                    int i = (int)(Mth.sin((this.shakeAnim - 0.4F) * 3.1415927F) * 7.0F);
                    Vec3 vec3 = this.getDeltaMovement();

                    for(int j = 0; j < i; ++j) {
                        float f1 = (this.random.nextFloat() * 2.0F - 1.0F) * this.getBbWidth() * 0.5F;
                        float f2 = (this.random.nextFloat() * 2.0F - 1.0F) * this.getBbWidth() * 0.5F;
                        this.level().addParticle(ParticleTypes.SPLASH, this.getX() + (double)f1, (double)(f + 0.8F), this.getZ() + (double)f2, vec3.x, vec3.y, vec3.z);
                    }
                }
            }

            this.setupAnimationStates();
        }
    }

    // VARIANT

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(VARIANT, FruitsVariant.LEMON.getId());
        builder.define(FROM_BUCKET, false);
        builder.define(CARPET_DYE, -1);
    }

    private int getTypeVariant() {
        return this.entityData.get(VARIANT);
    }

    public FruitsVariant getVariant() {
        return FruitsVariant.byId(this.getTypeVariant());
    }

    public void setVariant(FruitsVariant variant) {
        this.entityData.set(VARIANT, variant.getId());
    }

    // DECOR

    private int getCarpetDye() {
        return this.entityData.get(CARPET_DYE);
    }

    public void setCarpetDye(DyeColor variant) {
        this.entityData.set(CARPET_DYE, variant.getId());
    }

    public void setCarpetDye(int i) {
        this.entityData.set(CARPET_DYE, i);
    }

    @Nullable
    public DyeColor getSwag() {
        if(this.getCarpetDye() != -1){
            return DyeColor.byId(this.getCarpetDye());
        }

        return null;
    }

    public Item getCarpetBlock(){
        int variant = this.getCarpetDye();

        if(variant == DyeColor.RED.getId()){
            return Blocks.RED_CARPET.asItem();
        } else if (variant == DyeColor.BLACK.getId()){
            return Blocks.BLACK_CARPET.asItem();
        } else if (variant == DyeColor.BLUE.getId()){
            return Blocks.BLUE_CARPET.asItem();
        } else if (variant == DyeColor.BROWN.getId()){
            return Blocks.BROWN_CARPET.asItem();
        } else if (variant == DyeColor.CYAN.getId()){
            return Blocks.CYAN_CARPET.asItem();
        } else if (variant == DyeColor.GRAY.getId()){
            return Blocks.GRAY_CARPET.asItem();
        } else if (variant == DyeColor.GREEN.getId()){
            return Blocks.GREEN_CARPET.asItem();
        } else if (variant == DyeColor.LIGHT_BLUE.getId()){
            return Blocks.LIGHT_BLUE_CARPET.asItem();
        } else if (variant == DyeColor.LIGHT_GRAY.getId()){
            return Blocks.LIGHT_GRAY_CARPET.asItem();
        } else if (variant == DyeColor.LIME.getId()){
            return Blocks.LIME_CARPET.asItem();
        } else if (variant == DyeColor.MAGENTA.getId()){
            return Blocks.MAGENTA_CARPET.asItem();
        } else if (variant == DyeColor.ORANGE.getId()){
            return Blocks.ORANGE_CARPET.asItem();
        } else if (variant == DyeColor.PINK.getId()){
            return Blocks.PINK_CARPET.asItem();
        } else if (variant == DyeColor.PURPLE.getId()){
            return Blocks.PURPLE_CARPET.asItem();
        } else if (variant == DyeColor.WHITE.getId()){
            return Blocks.WHITE_CARPET.asItem();
        } else if (variant == DyeColor.YELLOW.getId()){
            return Blocks.YELLOW_CARPET.asItem();
        }

        return null;
    }

    // SPAWN

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty,
                                        MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData) {
        if(spawnType == MobSpawnType.SPAWN_EGG){
            FruitsVariant variant = Util.getRandom(FruitsVariant.values(), this.random);
            while (!variant.getIsAgrume()){
                variant = Util.getRandom(FruitsVariant.values(), this.random);
            }
            this.setVariant(variant);
        } else if (spawnType == MobSpawnType.BUCKET) {
            this.isWet = true;
            return (SpawnGroupData)spawnGroupData;
        }
        return super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
    }

    // SOUND

    protected SoundEvent getAmbientSound() {
        return ModSounds.KIWI_AMBIENT.get();
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.KIWI_DEATH.get();
    }

    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return ModSounds.KIWI_HURT.get();
    }

    // BUCKETABLE

    @Override
    public boolean fromBucket() {
        return (Boolean)this.entityData.get(FROM_BUCKET);
    }

    @Override
    public void setFromBucket(boolean b) {
        this.entityData.set(FROM_BUCKET, b);
    }

    @Override
    public void saveToBucketTag(ItemStack itemStack) {
        Bucketable.saveDefaultDataToBucketTag(this, itemStack);
        CustomData.update(DataComponents.BUCKET_ENTITY_DATA, itemStack, (p_330644_) -> {
            p_330644_.putInt("Variant", this.getVariant().getId());
            p_330644_.putInt("Carpet_Dye", this.getCarpetDye());
        });
    }

    @Override
    public void loadFromBucketTag(CompoundTag compoundTag) {
        Bucketable.loadDefaultDataFromBucketTag(this, compoundTag);
        this.setVariant(FruitsVariant.byId(compoundTag.getInt("Variant")));
        this.setCarpetDye(compoundTag.getInt("Carpet_Dye"));
    }

    @Override
    public ItemStack getBucketItemStack() {
        return new ItemStack(ModItems.KIWI_BUCKET.get());
    }

    @Override
    public SoundEvent getPickupSound() {
        return SoundEvents.BUCKET_FILL_POWDER_SNOW;
    }

    //GOAL

    class SitGoal extends Goal {
        private static final int WAIT_TIME_BEFORE_SIT = reducedTickDelay(400);
        private int countdown;
        private int animationDuration;

        private final KiwiEntity mob;

        public SitGoal(Mob mob) {
            super();
            this.mob = (KiwiEntity) mob; 
            this.countdown = this.mob.random.nextInt(WAIT_TIME_BEFORE_SIT);
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.JUMP));
        }

        public boolean canUse() {
            return this.mob.xxa  == 0.0F && this.mob.yya  == 0.0F && this.mob.zza  == 0.0F ? this.canSit() || this.mob.isSitting() : false;
        }

        public boolean canContinueToUse() {
            if(animationDuration > 0){
                --this.animationDuration;
                return this.canSit();
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
                return !this.mob.isInPowderSnow && !this.mob.isInWater() && !this.mob.isInLava();
            }
        }

        public void stop() {
            this.countdown = this.mob.random.nextInt(WAIT_TIME_BEFORE_SIT);
            this.animationDuration = 0;
            this.mob.clearStates();
        }

        public void start() {
            this.animationDuration = 315;
            this.mob.setJumping(false);
            this.mob.setSitting(true);
            this.mob.getNavigation().stop();
            this.mob.getMoveControl().setWantedPosition(this.mob.getX(), this.mob.getY(), this.mob.getZ(), 0.0);
        }

    }

    // CONTROLS

    class KiwiMoveControl extends MoveControl {

        private final KiwiEntity mob;

        public KiwiMoveControl(Mob mob) {
            super(mob);
            this.mob = (KiwiEntity) mob;
        }

        public void tick() {
            if (this.mob.canMove()) {
                super.tick();
            }
        }
    }
}

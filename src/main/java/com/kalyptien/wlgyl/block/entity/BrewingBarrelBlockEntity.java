package com.kalyptien.wlgyl.block.entity;

import com.kalyptien.wlgyl.item.ModItems;
import com.kalyptien.wlgyl.item.custom.LemonadeBottleItem;
import com.kalyptien.wlgyl.recipe.BrewingBarrelRecipe;
import com.kalyptien.wlgyl.recipe.BrewingBarrelRecipeInput;
import com.kalyptien.wlgyl.recipe.ModRecipes;
import com.kalyptien.wlgyl.screen.custom.BrewingBarrelMenu;
import com.kalyptien.wlgyl.sound.ModSounds;
import com.kalyptien.wlgyl.util.AgrumesVariant;
import com.kalyptien.wlgyl.util.EffectsVariant;
import com.kalyptien.wlgyl.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.crafting.ICustomIngredient;
import net.neoforged.neoforge.items.ItemStackHandler;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Optional;

import static net.minecraft.world.level.block.Block.popResource;

public class BrewingBarrelBlockEntity extends BlockEntity implements MenuProvider {

    public final ItemStackHandler itemHandler = new ItemStackHandler(5) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if(!level.isClientSide()) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 6);
            }
        }

        @Override
        public boolean isItemValid(int slot, ItemStack stack) {
            if(slot == 0) {
                return stack.is(ModTags.Items.AGRUMES);
            }
            if(slot == 1) {
                return stack.getItem() == Items.SUGAR || stack.getItem() == Items.REDSTONE || stack.getItem() == Items.GLOWSTONE_DUST;
            }
            if(slot == 2) {
                return stack.getItem() == Items.WATER_BUCKET || stack.getItem() == Items.POTION || stack.is(ModTags.Items.LEMONADES);
            }
            if(slot == 3) {
                return true;
            }
            if(slot == 4) {
                return stack.getItem() == Items.GLASS_BOTTLE;
            }
            else{
                return true;
            }
        }
    };

    private static final int INPUT_SLOT_AGRUMES = 0;
    private static final int INPUT_SLOT_SUGAR = 1;
    private static final int INPUT_SLOT_WATER = 2;
    private static final int INPUT_SLOT_BOTTLE = 4;
    private static final int OUTPUT_SLOT_BOTTLE = 3;

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 6000;
    private int water = 0;
    private int maxWater = 4;
    private int lemonadeType = 0;
    private int effectType = 0;

    public BrewingBarrelBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.BREWING_BARREL_BE.get(), pos, blockState);
        data = new ContainerData() {
            @Override
            public int get(int i) {
                return switch (i) {
                    case 0 -> BrewingBarrelBlockEntity.this.progress;
                    case 1 -> BrewingBarrelBlockEntity.this.maxProgress;
                    case 2 -> BrewingBarrelBlockEntity.this.water;
                    case 3 -> BrewingBarrelBlockEntity.this.maxWater;
                    case 4 -> BrewingBarrelBlockEntity.this.lemonadeType;
                    case 5 -> BrewingBarrelBlockEntity.this.effectType;
                    default -> 0;
                };
            }

            @Override
            public void set(int i, int value) {
                switch (i) {
                    case 0: BrewingBarrelBlockEntity.this.progress = value;
                    case 1: BrewingBarrelBlockEntity.this.maxProgress = value;
                    case 2: BrewingBarrelBlockEntity.this.water = value;
                    case 3: BrewingBarrelBlockEntity.this.maxWater = value;
                    case 4: BrewingBarrelBlockEntity.this.lemonadeType = value;
                    case 5 : BrewingBarrelBlockEntity.this.effectType = value;
                }
            }

            @Override
            public int getCount() {
                return 6;
            }
        };
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.wlgyl.brewing_barrel");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new BrewingBarrelMenu(i, inventory, this, this.data);
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        pTag.put("inventory", itemHandler.serializeNBT(pRegistries));
        pTag.putInt("brewing_barrel.progress", progress);
        pTag.putInt("brewing_barrel.max_progress", maxProgress);
        pTag.putInt("brewing_barrel.water", water);
        pTag.putInt("brewing_barrel.max_water", maxWater);
        pTag.putInt("brewing_barrel.lemonade_type", lemonadeType);
        pTag.putInt("brewing_barrel.effect_type", effectType);

        super.saveAdditional(pTag, pRegistries);
    }

    @Override
    protected void loadAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        super.loadAdditional(pTag, pRegistries);

        itemHandler.deserializeNBT(pRegistries, pTag.getCompound("inventory"));
        progress = pTag.getInt("brewing_barrel.progress");
        maxProgress = pTag.getInt("brewing_barrel.max_progress");
        water = pTag.getInt("brewing_barrel.water");
        maxWater = pTag.getInt("brewing_barrel.max_water");
        lemonadeType = pTag.getInt("brewing_barrel.lemonade_type");
        effectType = pTag.getInt("brewing_barrel.effect_type");
    }

    public void tick(Level level, BlockPos blockPos, BlockState blockState) {

        if(itemHandler.getStackInSlot(INPUT_SLOT_WATER).getItem() == Items.WATER_BUCKET && this.water != this.maxWater && lemonadeType == 0 && effectType == 0){
            this.water = this.water + 4;
            itemHandler.setStackInSlot(INPUT_SLOT_WATER, new ItemStack(Items.BUCKET, 1));
            level.playSound(null, blockPos, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS, 1f, 1f);
        }

        if(itemHandler.getStackInSlot(INPUT_SLOT_WATER).getItem() == Items.POTION && this.water != this.maxWater && lemonadeType == 0 && effectType == 0){
            this.water = this.water + 1;
            itemHandler.setStackInSlot(INPUT_SLOT_WATER, new ItemStack(Items.GLASS_BOTTLE, 1));
            level.playSound(null, blockPos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1f, 1f);
        }

        if(itemHandler.getStackInSlot(INPUT_SLOT_WATER).is(ModTags.Items.LEMONADES)
                &&
                ((this.water != this.maxWater
                && lemonadeType == ((LemonadeBottleItem)itemHandler.getStackInSlot(INPUT_SLOT_WATER).getItem()).getAgrume().getId()
                && effectType == ((LemonadeBottleItem)itemHandler.getStackInSlot(INPUT_SLOT_WATER).getItem()).getEffect().getId())
                ||
                (this.water == 0
                        && lemonadeType == 0
                        && effectType == 0
                ))
        ){
            this.water = this.water + 1;
            if(lemonadeType == 0 && effectType == 0){
                lemonadeType = ((LemonadeBottleItem)itemHandler.getStackInSlot(INPUT_SLOT_WATER).getItem()).getAgrume().getId();
                effectType = ((LemonadeBottleItem)itemHandler.getStackInSlot(INPUT_SLOT_WATER).getItem()).getEffect().getId();
            }
            itemHandler.extractItem(INPUT_SLOT_WATER, 1, false);
            popResource(level, blockPos, new ItemStack(Items.GLASS_BOTTLE));
            level.playSound(null, blockPos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1f, 1f);
        }

        if(itemHandler.getStackInSlot(INPUT_SLOT_BOTTLE).getItem() == Items.GLASS_BOTTLE && water > 0 && lemonadeType != 0){
            Item itemToGive = this.getLemonadeItem();
            itemHandler.insertItem(OUTPUT_SLOT_BOTTLE, new ItemStack(itemToGive, 1), false);
            itemHandler.extractItem(INPUT_SLOT_BOTTLE, 1, false);
            this.water--;
            level.playSound(null, blockPos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1f, 1f);

            if(water == 0){
                this.lemonadeType = 0;
                this.effectType = 0;
            }
        }

        if(hasRecipe()) {
            increaseCraftingProgress();
            setChanged(level, blockPos, blockState);

            if(Math.random() < 0.005){
                level.playSound(null, blockPos, ModSounds.BARREL_BUBBLE.get(), SoundSource.BLOCKS, 0.5f, 2f);
            }

            if(hasCraftingFinished()) {
                craftItem();
                resetProgress();
                level.playSound(null, blockPos, ModSounds.BARREL_FINISH.get(), SoundSource.BLOCKS, 1f, 0.5f);
            }
        } else {
            resetProgress();
        }
    }

    private void craftItem() {
        Optional<RecipeHolder<BrewingBarrelRecipe>> recipe = getCurrentRecipe();
        ItemStack output = recipe.get().value().output();

        itemHandler.extractItem(INPUT_SLOT_SUGAR, 1, false);
        itemHandler.extractItem(INPUT_SLOT_AGRUMES, 1, false);

        this.lemonadeType = ((LemonadeBottleItem) output.getItem()).getAgrume().getId();
        this.effectType = ((LemonadeBottleItem) output.getItem()).getEffect().getId();

    }

    private Item getLemonadeItem(){
        int currentLemonadeType = this.lemonadeType;
        int currentEffectType = this.effectType;

        if(currentLemonadeType == AgrumesVariant.LEMON.getId()){
            return ModItems.LEMON_LEMONADE.get();
        }
        else if(currentLemonadeType == AgrumesVariant.LIME.getId()){
            return ModItems.LIME_LEMONADE.get();
        }
        else if(currentLemonadeType == AgrumesVariant.ORANGE.getId()){
            return ModItems.ORANGE_LEMONADE.get();
        }
        else if(currentLemonadeType == AgrumesVariant.GRAPEFRUIT.getId()){
            if(currentEffectType == EffectsVariant.STRONG.getId()){
                return ModItems.GRAPEFRUIT_LEMONADE_STRONG.get();
            } else if (currentEffectType == EffectsVariant.LONG.getId()) {
                return ModItems.GRAPEFRUIT_LEMONADE_LONG.get();
            }
            else{
                return ModItems.GRAPEFRUIT_LEMONADE.get();
            }
        }
        else if(currentLemonadeType == AgrumesVariant.CAVIAR_LEMON.getId()){
            if(currentEffectType == EffectsVariant.STRONG.getId()){
                return ModItems.CAVIAR_LEMON_LEMONADE_STRONG.get();
            } else if (currentEffectType == EffectsVariant.LONG.getId()) {
                return ModItems.CAVIAR_LEMON_LEMONADE_LONG.get();
            }
            else{
                return ModItems.CAVIAR_LEMON_LEMONADE.get();
            }
        }
        else if(currentLemonadeType == AgrumesVariant.BLOOD_ORANGE.getId()){
            if(currentEffectType == EffectsVariant.STRONG.getId()){
                return ModItems.BLOOD_ORANGE_LEMONADE_STRONG.get();
            } else if (currentEffectType == EffectsVariant.LONG.getId()) {
                return ModItems.BLOOD_ORANGE_LEMONADE_LONG.get();
            }
            else{
                return ModItems.BLOOD_ORANGE_LEMONADE.get();
            }
        }
        else if(currentLemonadeType == AgrumesVariant.BUDDHA_HAND.getId()){
            if(currentEffectType == EffectsVariant.STRONG.getId()){
                return ModItems.BUDDHA_HAND_LEMONADE_STRONG.get();
            } else if (currentEffectType == EffectsVariant.LONG.getId()) {
                return ModItems.BUDDHA_HAND_LEMONADE_LONG.get();
            }
            else{
                return ModItems.BUDDHA_HAND_LEMONADE.get();
            }
        }

        return Items.WATER_BUCKET;
    }

    private void resetProgress() {
        progress = 0;
        maxProgress = 6000;
    }

    private boolean hasCraftingFinished() {
        return this.progress >= this.maxProgress;
    }

    private void increaseCraftingProgress() {
        progress++;
    }

    private boolean hasRecipe() {

        Optional<RecipeHolder<BrewingBarrelRecipe>> recipe = getCurrentRecipe();
        if(recipe.isEmpty()) {
            return false;
        }

        return  this.water == this.maxWater
                && itemHandler.getStackInSlot(INPUT_SLOT_AGRUMES).getCount() >= 1
                && itemHandler.getStackInSlot(INPUT_SLOT_SUGAR).getCount() >= 1;
    }

    private Optional<RecipeHolder<BrewingBarrelRecipe>> getCurrentRecipe() {
        return this.level.getRecipeManager()
                .getRecipeFor(ModRecipes.BREWING_BARREL_TYPE.get(), new BrewingBarrelRecipeInput(itemHandler.getStackInSlot(INPUT_SLOT_AGRUMES), itemHandler.getStackInSlot(INPUT_SLOT_SUGAR), new ItemStack(this.getLemonadeItem())), level);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider pRegistries) {
        return saveWithoutMetadata(pRegistries);
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
}

package com.kalyptien.wlgyl.block.entity;

import com.kalyptien.wlgyl.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;

import javax.annotation.Nullable;

public class SqueezerBlockEntity extends BlockEntity {

    public final ItemStackHandler inventory = new ItemStackHandler(4) {
        @Override
        protected int getStackLimit(int slot, ItemStack stack) {
            return 1;
        }

        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if(!level.isClientSide()) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        }
    };

    public SqueezerBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.SQUEEZER_BE.get(), pos, blockState);
    }

    public void clearContents() {
        inventory.setStackInSlot(0, ItemStack.EMPTY);
        inventory.setStackInSlot(1, ItemStack.EMPTY);
        inventory.setStackInSlot(2, ItemStack.EMPTY);
        inventory.setStackInSlot(3, ItemStack.EMPTY);
    }

    public int getLastInventoryAvailable(){
        if(inventory.getStackInSlot(0).isEmpty()){
            return 0;
        }
        else if(inventory.getStackInSlot(1).isEmpty()){
            return 1;
        }
        else if(inventory.getStackInSlot(2).isEmpty()){
            return 2;
        }
        else if(inventory.getStackInSlot(3).isEmpty()){
            return 3;
        }

        return 0;
    }

    public ItemStack itemConverter(){
        Item currentItem = inventory.getStackInSlot(0).getItem();
        Item itemToReturn= ModItems.LEMON_JUICE.get();

        if(currentItem == ModItems.LEMON.get()){
            itemToReturn = ModItems.LEMON_JUICE.get();
        }
        else if(currentItem == ModItems.LIME.get()){
            itemToReturn = ModItems.LIME_JUICE.get();
        }
        else if(currentItem == ModItems.GRAPEFRUIT.get()){
            itemToReturn = ModItems.GRAPEFRUIT_JUICE.get();
        }
        else if(currentItem == ModItems.ORANGE.get()){
            itemToReturn = ModItems.ORANGE_JUICE.get();
        }
        else if(currentItem == ModItems.CAVRIAR_LEMON.get()){
            itemToReturn = ModItems.CAVRIAR_LEMON_JUICE.get();
        }
        else if(currentItem == ModItems.BLOOD_ORANGE.get()){
            itemToReturn = ModItems.BLOOD_ORANGE_JUICE.get();
        }
        else if(currentItem == ModItems.BOUDDHA_HAND.get()){
            itemToReturn = ModItems.BOUDDHA_HAND_JUICE.get();
        }
        else if(currentItem == Items.APPLE){
            itemToReturn = ModItems.APPLE_JUICE.get();
        }
        else if(currentItem == Items.GLOW_BERRIES){
            itemToReturn = ModItems.GLOW_BERRIES_JUICE.get();
        }
        else if(currentItem == Items.SWEET_BERRIES){
            itemToReturn = ModItems.SWEET_BERRIES_JUICE.get();
        }

        return new ItemStack(itemToReturn, 1);
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.put("inventory", inventory.serializeNBT(registries));
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        inventory.deserializeNBT(registries, tag.getCompound("inventory"));
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider pRegistries) {
        return saveWithoutMetadata(pRegistries);
    }
}

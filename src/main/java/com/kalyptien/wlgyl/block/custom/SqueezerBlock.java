package com.kalyptien.wlgyl.block.custom;

import com.kalyptien.wlgyl.block.entity.SqueezerBlockEntity;
import com.kalyptien.wlgyl.util.ModTags;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.Properties;


public class SqueezerBlock extends BaseEntityBlock {

    public static final MapCodec<SqueezerBlock> CODEC = simpleCodec(SqueezerBlock::new);
    private static final VoxelShape SHAPE = Block.box(3.0, 0.0, 3.0, 13.0, 4.0, 13.0);

    public SqueezerBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    /* BLOCK ENTITY */

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new SqueezerBlockEntity(blockPos, blockState);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos,
                                              Player player, InteractionHand hand, BlockHitResult hitResult) {
        if(level.getBlockEntity(pos) instanceof SqueezerBlockEntity squeezerBlockEntity) {
            if(squeezerBlockEntity.inventory.getStackInSlot(3).isEmpty() && !stack.isEmpty()) {

                if(!stack.is(ModTags.Items.FRUITS)){
                    return ItemInteractionResult.FAIL;
                }

                if(!squeezerBlockEntity.inventory.getStackInSlot(0).isEmpty()){
                    if(squeezerBlockEntity.inventory.getStackInSlot(0).getItem() != stack.getItem()){
                        return ItemInteractionResult.FAIL;
                    }
                }

                if(stack.is(ModTags.Items.BERRYS)){
                    if(Math.random() <= 0.75){
                        stack.shrink(1);
                        return ItemInteractionResult.CONSUME;
                    }
                }

                int i = squeezerBlockEntity.getLastInventoryAvailable();
                squeezerBlockEntity.inventory.insertItem(i, stack.copy(), false);
                stack.shrink(1);
                level.playSound(player, pos, SoundEvents.COW_MILK, SoundSource.BLOCKS, 1f, 1f);

            } else if(stack.getItem() == Items.GLASS_BOTTLE && !squeezerBlockEntity.inventory.getStackInSlot(3).isEmpty()) {

                ItemStack juice = squeezerBlockEntity.itemConverter();
                stack.shrink(1);
                popResource(level, pos, juice);
                squeezerBlockEntity.clearContents();
                level.playSound(player, pos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1f, 1f);

            } else if(stack.isEmpty() && player.isCrouching()){
                squeezerBlockEntity.clearContents();
                level.playSound(player, pos, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS, 1f, 1.5f);
            }
        }

        return ItemInteractionResult.SUCCESS;
    }

}

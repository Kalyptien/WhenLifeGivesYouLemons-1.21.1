package com.kalyptien.wlgyl.block.custom;

import com.kalyptien.wlgyl.item.ModItems;
import com.kalyptien.wlgyl.sound.ModSounds;
import com.kalyptien.wlgyl.util.FruitsVariant;
import com.kalyptien.wlgyl.util.ModTags;
import com.mojang.serialization.MapCodec;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
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
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;


public class SqueezerBlock extends BaseEntityBlock {

    public static final MapCodec<SqueezerBlock> CODEC = simpleCodec(SqueezerBlock::new);
    private static final VoxelShape SHAPE = Block.box(3.0, 0.0, 3.0, 13.0, 4.0, 13.0);

    public static final IntegerProperty FILL_LVL = IntegerProperty.create("fill_level", 0, 3);
    public static final IntegerProperty FILL_VARIANT = IntegerProperty.create("fill_variant", FruitsVariant.getMin(), FruitsVariant.getMax());

    public SqueezerBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(FILL_LVL, 0).setValue(FILL_VARIANT, 0));
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
        return null;
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos,
                                              Player player, InteractionHand hand, BlockHitResult hitResult) {

        if(!level.isClientSide()) {
            int fillLVL = state.getValue(FILL_LVL);
            int fillVariant = state.getValue(FILL_VARIANT);

            if (fillLVL != 3 && !stack.isEmpty()) {

                if (!stack.is(ModTags.Items.FRUITS)) {
                    return ItemInteractionResult.FAIL;
                }

                if (fillVariant != 0) {
                    if (!FruitsVariant.byId(fillVariant).getName().equals(stack.getItem().getDescriptionId())) {
                        return ItemInteractionResult.FAIL;
                    }
                }

                if (stack.is(ModTags.Items.BERRYS)) {
                    if (Math.random() <= 0.25) {
                        stack.shrink(1);
                        level.playSound(null, pos, ModSounds.SQUEEZER_FILL.get(), SoundSource.BLOCKS, 1f, 2f);
                        return ItemInteractionResult.CONSUME;
                    }
                }

                if (fillVariant == 0) {
                    fillVariant = FruitsVariant.byName(stack.getItem().getDescriptionId()).getId();
                }

                if(fillVariant != 0){
                    stack.shrink(1);
                    level.playSound(null, pos, ModSounds.SQUEEZER_FILL.get(), SoundSource.BLOCKS, 1f, 2f);
                    fillLVL = fillLVL + 1;
                }


            } else if (stack.getItem() == Items.GLASS_BOTTLE && fillLVL == 3) {

                ItemStack juice = new ItemStack(FruitsVariant.getJuiceItemFromId(state.getValue(FILL_VARIANT)), 1);
                stack.shrink(1);
                popResource(level, pos, juice);
                fillVariant = 0;
                fillLVL = 0;
                level.playSound(null, pos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1f, 1f);

            } else if (stack.isEmpty() && player.isCrouching() && fillLVL != 0) {
                fillVariant = 0;
                fillLVL = 0;
                level.playSound(null, pos, ModSounds.SQUEEZER_EMPTY.get(), SoundSource.BLOCKS, 0.8f, 2f);
            }

            level.setBlockAndUpdate(pos, state.setValue(FILL_LVL, fillLVL).setValue(FILL_VARIANT, fillVariant));
        }

        return ItemInteractionResult.SUCCESS;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FILL_LVL);
        builder.add(FILL_VARIANT);
    }
}

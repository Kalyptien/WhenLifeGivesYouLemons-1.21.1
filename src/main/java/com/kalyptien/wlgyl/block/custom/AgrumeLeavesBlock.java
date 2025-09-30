package com.kalyptien.wlgyl.block.custom;

import com.kalyptien.wlgyl.util.AgrumesVariant;
import com.kalyptien.wlgyl.entity.ModEntities;
import com.kalyptien.wlgyl.entity.custom.KiwiEntity;
import com.kalyptien.wlgyl.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.common.CommonHooks;

public class AgrumeLeavesBlock extends LeavesBlock implements BonemealableBlock {

    public static final int MAX_AGE = 3;
    public static final IntegerProperty AGE;

    public AgrumeLeavesBlock(Properties properties) {
        super(properties);
        this.registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue(this.getAgeProperty(), 0));
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if ((Integer)state.getValue(AGE) == MAX_AGE) {

            if(Math.random() > 0.99){
                KiwiEntity kiwi = new KiwiEntity(ModEntities.KIWI_NORMAL.get(), level);
                kiwi.setVariant(this.getVariant());

                if(level.getBlockState(new BlockPos(pos.getX(), pos.getY()-1, pos.getZ())).getBlock() == Blocks.AIR){
                    kiwi.moveTo(pos.getX(), pos.getY()-1, pos.getZ());
                }
                else if(level.getBlockState(new BlockPos(pos.getX(), pos.getY()+1, pos.getZ())).getBlock() == Blocks.AIR){
                    kiwi.moveTo(pos.getX(), pos.getY()+1, pos.getZ());
                }
                if(level.getBlockState(new BlockPos(pos.getX()-1, pos.getY(), pos.getZ())).getBlock() == Blocks.AIR){
                    kiwi.moveTo(pos.getX()-1, pos.getY(), pos.getZ());
                }
                else if(level.getBlockState(new BlockPos(pos.getX()+1, pos.getY(), pos.getZ())).getBlock() == Blocks.AIR){
                    kiwi.moveTo(pos.getX()+1, pos.getY(), pos.getZ());
                }
                if(level.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ()-1)).getBlock() == Blocks.AIR){
                    kiwi.moveTo(pos.getX(), pos.getY(), pos.getZ()-1);
                }
                else if(level.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ()+1)).getBlock() == Blocks.AIR){
                    kiwi.moveTo(pos.getX(), pos.getY(), pos.getZ()+1);
                }
                else{
                    kiwi.moveTo(pos.getX(), pos.getY(), pos.getZ());
                }

                level.addFreshEntity(kiwi);
            }
            else{
                int j = 1 + level.random.nextInt(4);
                popResource(level, pos, new ItemStack(this.getAgrumeProperty(), j));
            }
            level.playSound((Player)null, pos, ModSounds.LEAVES_FORAGE.get(), SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
            BlockState blockstate = (BlockState)state.setValue(AGE, 0);
            level.setBlock(pos, blockstate, 2);
            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, blockstate));
            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            return InteractionResult.PASS;
        }
    }

    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        int i = (Integer)state.getValue(AGE);
        boolean flag = i == 3;
        return !flag && stack.is(Items.BONE_MEAL) ? ItemInteractionResult.SKIP_DEFAULT_BLOCK_INTERACTION : super.useItemOn(stack, state, level, pos, player, hand, hitResult);
    }

    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    public ItemLike getAgrumeProperty() {
        return null;
    }

    public int getMaxAge() {
        return 3;
    }

    public int getAge(BlockState state) {
        return (Integer)state.getValue(this.getAgeProperty());
    }

    public BlockState getStateForAge(int age) {
        return (BlockState)this.defaultBlockState().setValue(this.getAgeProperty(), age).setValue(WATERLOGGED, false);
    }

    public final boolean isMaxAge(BlockState state) {
        return this.getAge(state) >= this.getMaxAge();
    }

    protected boolean isRandomlyTicking(BlockState state) {
        return !this.isMaxAge(state);
    }

    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (level.isAreaLoaded(pos, 1)) {
            int i = this.getAge(state);
            if (i < this.getMaxAge()) {
                float f = 0.1F; //GrowSpeed
                if (CommonHooks.canCropGrow(level, pos, state, random.nextInt((int)(25.0F / f) + 1) == 0)) {
                    level.setBlock(pos, this.getStateForAge(i + 1), 2);
                    CommonHooks.fireCropGrowPost(level, pos, state);
                }
            }
        }
    }

    public void growCrops(Level level, BlockPos pos, BlockState state) {
        int i = this.getAge(state) + this.getBonemealAgeIncrease(level);
        int j = this.getMaxAge();
        if (i > j) {
            i = j;
        }

        level.setBlock(pos, this.getStateForAge(i), 2);
    }

    protected int getBonemealAgeIncrease(Level level) {
        return Mth.nextInt(level.random, 2, 5);
    }

    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
        return !this.isMaxAge(state);
    }

    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        this.growCrops(level, pos, state);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE, DISTANCE, PERSISTENT, WATERLOGGED);
    }

    public AgrumesVariant getVariant(){
        return AgrumesVariant.LEMON;
    }

    static {
        AGE = BlockStateProperties.AGE_3;
    }
}

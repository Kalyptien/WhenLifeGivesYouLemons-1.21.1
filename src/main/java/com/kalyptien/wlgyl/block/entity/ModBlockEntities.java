package com.kalyptien.wlgyl.block.entity;

import com.kalyptien.wlgyl.WhenLifeGivesYouLemonsMod;
import com.kalyptien.wlgyl.block.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, WhenLifeGivesYouLemonsMod.MOD_ID);

    public static final Supplier<BlockEntityType<SqueezerBlockEntity>> SQUEEZER_BE =
            BLOCK_ENTITIES.register("squeezer_be", () -> BlockEntityType.Builder.of(
                    SqueezerBlockEntity::new, ModBlocks.SQUEEZER.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
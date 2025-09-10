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

    public static final Supplier<BlockEntityType<BrewingBarrelBlockEntity>> BREWING_BARREL_BE =
            BLOCK_ENTITIES.register("brewing_barrel_be", () -> BlockEntityType.Builder.of(
                    BrewingBarrelBlockEntity::new, ModBlocks.BREWING_BARREL.get()).build(null));

    public static final Supplier<BlockEntityType<IndustrialBrewingBarrelBlockEntity>> INDUSTRIAL_BREWING_BARREL_BE =
            BLOCK_ENTITIES.register("industrial_brewing_barrel_be", () -> BlockEntityType.Builder.of(
                    IndustrialBrewingBarrelBlockEntity::new, ModBlocks.INDUSTRIAL_BREWING_BARREL.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
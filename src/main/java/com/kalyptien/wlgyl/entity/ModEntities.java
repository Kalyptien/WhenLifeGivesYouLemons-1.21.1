package com.kalyptien.wlgyl.entity;

import com.kalyptien.wlgyl.WhenLifeGivesYouLemonsMod;
import com.kalyptien.wlgyl.entity.custom.KiwiNormalEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, WhenLifeGivesYouLemonsMod.MOD_ID);

    public static final Supplier<EntityType<KiwiNormalEntity>> KIWI_NORMAL =
            ENTITY_TYPES.register("kiwi_normal", () -> EntityType.Builder.of(KiwiNormalEntity::new, MobCategory.CREATURE)
                    .sized(0.6f, 0.6f).build("kiwi_normal"));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}

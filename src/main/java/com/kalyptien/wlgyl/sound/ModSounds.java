package com.kalyptien.wlgyl.sound;

import com.kalyptien.wlgyl.WhenLifeGivesYouLemonsMod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, WhenLifeGivesYouLemonsMod.MOD_ID);

    public static final Supplier<SoundEvent> KIWI_DEATH = registerSoundEvent("kiwi_death");
    public static final Supplier<SoundEvent> KIWI_HURT = registerSoundEvent("kiwi_hurt");
    public static final Supplier<SoundEvent> KIWI_AMBIENT = registerSoundEvent("kiwi_ambient");

    public static final Supplier<SoundEvent> LEAVES_FORAGE = registerSoundEvent("leaves_forage");

    public static final Supplier<SoundEvent> BARREL_BUBBLE = registerSoundEvent("barrel_bubble");
    public static final Supplier<SoundEvent> BARREL_FINISH = registerSoundEvent("barrel_finish");

    public static final Supplier<SoundEvent> SQUEEZER_FILL = registerSoundEvent("squeezer_fill");
    public static final Supplier<SoundEvent> SQUEEZER_EMPTY = registerSoundEvent("squeezer_empty");


    private static Supplier<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(WhenLifeGivesYouLemonsMod.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}

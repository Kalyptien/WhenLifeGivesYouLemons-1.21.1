package com.kalyptien.wlgyl.item;

import com.kalyptien.wlgyl.WhenLifeGivesYouLemonsMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, WhenLifeGivesYouLemonsMod.MOD_ID);

    public static final Supplier<CreativeModeTab> BISMUTH_ITEMS_TAB = CREATIVE_MODE_TAB.register("bismuth_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.LEMON.get()))
                    .title(Component.translatable("creativetab.wlgyl.mod_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.LEMON);
                        output.accept(ModItems.ORANGE);
                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
package com.kalyptien.wlgyl.item;

import com.kalyptien.wlgyl.WhenLifeGivesYouLemonsMod;
import com.kalyptien.wlgyl.block.ModBlocks;
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
                        output.accept(ModItems.LIME);
                        output.accept(ModItems.GRAPEFRUIT);
                        output.accept(ModItems.BLOOD_ORANGE);
                        output.accept(ModItems.BOUDDHA_HAND);
                        output.accept(ModItems.CAVRIAR_LEMON);

                        output.accept(ModItems.LEMON_JUICE);
                        output.accept(ModItems.ORANGE_JUICE);
                        output.accept(ModItems.BLOOD_ORANGE_JUICE);
                        output.accept(ModItems.BOUDDHA_HAND_JUICE);
                        output.accept(ModItems.LIME_JUICE);
                        output.accept(ModItems.GRAPEFRUIT_JUICE);
                        output.accept(ModItems.CAVRIAR_LEMON_JUICE);

                        output.accept(ModItems.LEMON_LEMONADE);
                        output.accept(ModItems.ORANGE_LEMONADE);
                        output.accept(ModItems.BLOOD_ORANGE_LEMONADE);
                        output.accept(ModItems.BOUDDHA_HAND_LEMONADE);
                        output.accept(ModItems.CAVRIAR_LEMON_LEMONADE);
                        output.accept(ModItems.GRAPEFRUIT_LEMONADE);
                        output.accept(ModItems.LIME_LEMONADE);

                        output.accept(ModBlocks.LEMON_LEAVES);
                        output.accept(ModBlocks.LEMON_SAPLING);

                        output.accept(ModBlocks.ORANGE_LEAVES);
                        output.accept(ModBlocks.ORANGE_SAPLING);

                        output.accept(ModBlocks.BLOOD_ORANGE_LEAVES);
                        output.accept(ModBlocks.BLOOD_ORANGE_SAPLING);

                        output.accept(ModBlocks.GRAPEFRUIT_LEAVES);
                        output.accept(ModBlocks.GRAPEFRUIT_SAPLING);

                        output.accept(ModBlocks.BOUDDHA_HAND_LEAVES);
                        output.accept(ModBlocks.BOUDDHA_HAND_SAPLING);

                        output.accept(ModBlocks.CAVIAR_LEMON_LEAVES);
                        output.accept(ModBlocks.CAVIAR_LEMON_SAPLING);

                        output.accept(ModBlocks.LIME_LEAVES);
                        output.accept(ModBlocks.LIME_SAPLING);

                        output.accept(ModBlocks.SQUEEZER);
                        output.accept(ModBlocks.BREWING_BARREL);
                        output.accept(ModBlocks.INDUSTRIAL_BREWING_BARREL);
                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
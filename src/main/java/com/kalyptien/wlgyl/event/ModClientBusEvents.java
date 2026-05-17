package com.kalyptien.wlgyl.event;


import com.kalyptien.wlgyl.WhenLifeGivesYouLemonsMod;
import com.kalyptien.wlgyl.block.ModBlocks;
import com.kalyptien.wlgyl.block.custom.AgrumeLeavesBlock;
import com.kalyptien.wlgyl.item.ModItems;
import com.kalyptien.wlgyl.item.custom.JuiceBottleItem;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

@EventBusSubscriber(value = Dist.CLIENT, modid = WhenLifeGivesYouLemonsMod.MOD_ID)
public class ModClientBusEvents {

    @SubscribeEvent
    public static void registerItemColors(RegisterColorHandlersEvent.Item event){
        // POTIONS
        event.register(JuiceBottleItem::getLiquidColor,
                ModItems.LEMON_JUICE.get(),
                ModItems.ORANGE_JUICE.get(),
                ModItems.GRAPEFRUIT_JUICE.get(),
                ModItems.BLOOD_ORANGE_JUICE.get(),
                ModItems.LIME_JUICE.get(),
                ModItems.BUDDHA_HAND_JUICE.get(),
                ModItems.CAVIAR_LEMON_JUICE.get(),
                ModItems.MELON_JUICE.get(),
                ModItems.APPLE_JUICE.get(),
                ModItems.SWEET_BERRIES_JUICE.get(),
                ModItems.GLOW_BERRIES_JUICE.get(),

                ModItems.LEMON_LEMONADE.get(),
                ModItems.ORANGE_LEMONADE.get(),
                ModItems.LIME_LEMONADE.get(),
                ModItems.GRAPEFRUIT_LEMONADE.get(),
                ModItems.GRAPEFRUIT_LEMONADE_LONG.get(),
                ModItems.GRAPEFRUIT_LEMONADE_STRONG.get(),
                ModItems.BLOOD_ORANGE_LEMONADE.get(),
                ModItems.BLOOD_ORANGE_LEMONADE_LONG.get(),
                ModItems.BLOOD_ORANGE_LEMONADE_STRONG.get(),
                ModItems.BUDDHA_HAND_LEMONADE.get(),
                ModItems.BUDDHA_HAND_LEMONADE_LONG.get(),
                ModItems.BUDDHA_HAND_LEMONADE_STRONG.get(),
                ModItems.CAVIAR_LEMON_LEMONADE.get(),
                ModItems.CAVIAR_LEMON_LEMONADE_LONG.get(),
                ModItems.CAVIAR_LEMON_LEMONADE_STRONG.get());

        event.register(AgrumeLeavesBlock::getLeavesColor,
                ModBlocks.LEMON_LEAVES.asItem(),
                ModBlocks.ORANGE_LEAVES.asItem(),
                ModBlocks.LIME_LEAVES.asItem(),
                ModBlocks.BLOOD_ORANGE_LEAVES.asItem(),
                ModBlocks.GRAPEFRUIT_LEAVES.asItem(),
                ModBlocks.BUDDHA_HAND_LEAVES.asItem(),
                ModBlocks.CAVIAR_LEMON_LEAVES.asItem());
    }

    @SubscribeEvent
    public static void registerBlockColors(RegisterColorHandlersEvent.Block event){
        event.register(AgrumeLeavesBlock::getLeavesColor,
                ModBlocks.LEMON_LEAVES.get(),
                ModBlocks.ORANGE_LEAVES.get(),
                ModBlocks.LIME_LEAVES.get(),
                ModBlocks.BLOOD_ORANGE_LEAVES.get(),
                ModBlocks.GRAPEFRUIT_LEAVES.get(),
                ModBlocks.BUDDHA_HAND_LEAVES.get(),
                ModBlocks.CAVIAR_LEMON_LEAVES.get());
    }
}

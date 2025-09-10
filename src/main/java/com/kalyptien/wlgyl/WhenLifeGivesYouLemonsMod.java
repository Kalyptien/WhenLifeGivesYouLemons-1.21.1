package com.kalyptien.wlgyl;

import com.kalyptien.wlgyl.block.ModBlocks;
import com.kalyptien.wlgyl.block.entity.BrewingBarrelBlockEntity;
import com.kalyptien.wlgyl.block.entity.ModBlockEntities;
import com.kalyptien.wlgyl.item.ModCreativeModeTabs;
import com.kalyptien.wlgyl.item.ModItems;
import com.kalyptien.wlgyl.recipe.ModRecipes;
import com.kalyptien.wlgyl.screen.ModMenuTypes;
import com.kalyptien.wlgyl.screen.custom.BrewingBarrelScreen;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(WhenLifeGivesYouLemonsMod.MOD_ID)
public class WhenLifeGivesYouLemonsMod {
    public static final String MOD_ID = "wlgyl";
    public static final Logger LOGGER = LogUtils.getLogger();


    public WhenLifeGivesYouLemonsMod(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        NeoForge.EVENT_BUS.register(this);

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);

        ModMenuTypes.register(modEventBus);
        ModRecipes.register(modEventBus);

        modEventBus.addListener(this::addCreative);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS){
            event.accept(ModItems.LEMON);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MOD_ID, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void registerScreens(RegisterMenuScreensEvent event) {
            event.register(ModMenuTypes.BREWING_BARREL_MENU.get(), BrewingBarrelScreen::new);
        }
    }
}

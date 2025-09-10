package com.kalyptien.wlgyl.screen;

import com.kalyptien.wlgyl.WhenLifeGivesYouLemonsMod;
import com.kalyptien.wlgyl.screen.custom.BrewingBarrelMenu;
import com.kalyptien.wlgyl.screen.custom.IndustrialBrewingBarrelMenu;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.network.IContainerFactory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(Registries.MENU, WhenLifeGivesYouLemonsMod.MOD_ID);

    public static final DeferredHolder<MenuType<?>, MenuType<BrewingBarrelMenu>> BREWING_BARREL_MENU =
            registerMenuType("brewing_barrel_menu", BrewingBarrelMenu::new);

    public static final DeferredHolder<MenuType<?>, MenuType<IndustrialBrewingBarrelMenu>> INDUSTRIAL_BREWING_BARREL_MENU =
            registerMenuType("industrial_brewing_barrel_menu", IndustrialBrewingBarrelMenu::new);

    private static <T extends AbstractContainerMenu> DeferredHolder<MenuType<?>, MenuType<T>> registerMenuType(String name,
                                                                                                               IContainerFactory<T> factory) {
        return MENUS.register(name, () -> IMenuTypeExtension.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}

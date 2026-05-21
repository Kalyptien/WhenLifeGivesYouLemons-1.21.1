package com.kalyptien.wlgyl.recipe;

import com.kalyptien.wlgyl.WhenLifeGivesYouLemonsMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, WhenLifeGivesYouLemonsMod.MOD_ID);
    public static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, WhenLifeGivesYouLemonsMod.MOD_ID);

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<BrewingBarrelRecipe>> BREWING_BARREL_SERIALIZER =
            SERIALIZERS.register("brewing_barrel", BrewingBarrelRecipe.Serializer::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<BrewingBarrelRecipe>> BREWING_BARREL_TYPE =
            TYPES.register("brewing_barrel", () -> new RecipeType<BrewingBarrelRecipe>() {
                @Override
                public String toString() {
                    return "brewing_barrel";
                }
            });

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<SqueezerRecipe>> SQUEEZER_SERIALIZER =
            SERIALIZERS.register("squeezer", SqueezerRecipe.Serializer::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<SqueezerRecipe>> SQUEEZER_TYPE =
            TYPES.register("squeezer", () -> new RecipeType<SqueezerRecipe>() {
                @Override
                public String toString() {
                    return "squeezer";
                }
            });


    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
        TYPES.register(eventBus);
    }
}

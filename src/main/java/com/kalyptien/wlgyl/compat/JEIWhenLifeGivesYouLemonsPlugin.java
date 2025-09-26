package com.kalyptien.wlgyl.compat;

import com.kalyptien.wlgyl.WhenLifeGivesYouLemonsMod;
import com.kalyptien.wlgyl.block.ModBlocks;
import com.kalyptien.wlgyl.recipe.BrewingBarrelRecipe;
import com.kalyptien.wlgyl.recipe.ModRecipes;
import com.kalyptien.wlgyl.screen.custom.BrewingBarrelScreen;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;

@JeiPlugin
public class JEIWhenLifeGivesYouLemonsPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(WhenLifeGivesYouLemonsMod.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new BrewingBarrelRecipeCategory(
                registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        List<BrewingBarrelRecipe> brewingBarrelRecipes = recipeManager
                .getAllRecipesFor(ModRecipes.BREWING_BARREL_TYPE.get()).stream().map(RecipeHolder::value).toList();
        registration.addRecipes(BrewingBarrelRecipeCategory.BREWING_BARREL_RECIPE_RECIPE_TYPE, brewingBarrelRecipes);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(BrewingBarrelScreen.class, 62, 17, 52, 52,
                BrewingBarrelRecipeCategory.BREWING_BARREL_RECIPE_RECIPE_TYPE);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.BREWING_BARREL.asItem()));
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.INDUSTRIAL_BREWING_BARREL.asItem()));
    }
}
package com.kalyptien.wlgyl.compat;

import com.kalyptien.wlgyl.WhenLifeGivesYouLemonsMod;
import com.kalyptien.wlgyl.block.ModBlocks;
import com.kalyptien.wlgyl.item.custom.LemonadeBottleItem;
import com.kalyptien.wlgyl.recipe.BrewingBarrelRecipe;
import com.kalyptien.wlgyl.util.AgrumesVariant;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class BrewingBarrelRecipeCategory  implements IRecipeCategory<BrewingBarrelRecipe> {
    public static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(WhenLifeGivesYouLemonsMod.MOD_ID, "brewing_barrel");
    public static final ResourceLocation TEXTURE_BG = ResourceLocation.fromNamespaceAndPath(WhenLifeGivesYouLemonsMod.MOD_ID,
            "textures/gui/brewing_barrel_gui.png");

    public static final RecipeType<BrewingBarrelRecipe> BREWING_BARREL_RECIPE_RECIPE_TYPE =
            new RecipeType<>(UID, BrewingBarrelRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;


    public BrewingBarrelRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE_BG,20 ,13, 134, 62);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.BREWING_BARREL));
    }

    @Override
    public RecipeType<BrewingBarrelRecipe> getRecipeType() {
        return BREWING_BARREL_RECIPE_RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.wlgyl.brewing_barrel");
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return icon;
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, BrewingBarrelRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 6, 40).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 6, 4).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.INPUT, 114, 4).addIngredients(recipe.getIngredients().get(2));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 114, 40).addItemStack(recipe.getResultItem(null));
    }

    public String getCurrentLimonade(ItemStack item) {
        int limonadeType = ((LemonadeBottleItem)item.getItem()).getAgrume().getId();

        if(limonadeType == 0){
            return "water";
        }
        else{
            return AgrumesVariant.byId(limonadeType).toString().toLowerCase();

        }
    }

    public String getCurrentEffect(ItemStack item) {
        int effectType = ((LemonadeBottleItem)item.getItem()).getEffect().getId();

        if(effectType == 1){
            return "long";
        }
        else if(effectType == 2){
            return "strong";
        }
        return "none";
    }
}
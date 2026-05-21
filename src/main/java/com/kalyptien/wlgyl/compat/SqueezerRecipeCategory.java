package com.kalyptien.wlgyl.compat;

import com.kalyptien.wlgyl.WhenLifeGivesYouLemonsMod;
import com.kalyptien.wlgyl.block.ModBlocks;
import com.kalyptien.wlgyl.recipe.SqueezerRecipe;
import com.kalyptien.wlgyl.util.ModTags;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class SqueezerRecipeCategory implements IRecipeCategory<SqueezerRecipe> {
    public static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(WhenLifeGivesYouLemonsMod.MOD_ID, "squeezer");
    public static final ResourceLocation TEXTURE_BG = ResourceLocation.fromNamespaceAndPath(WhenLifeGivesYouLemonsMod.MOD_ID,
            "textures/gui/squeezer/squeezer_gui.png");

    public static final ResourceLocation TEXTURE_BG_BERRIES = ResourceLocation.fromNamespaceAndPath(WhenLifeGivesYouLemonsMod.MOD_ID,
            "textures/gui/squeezer/squeezer_gui.png");

    public static final RecipeType<SqueezerRecipe> SQUEEZER_RECIPE_TYPE =
            new RecipeType<>(UID, SqueezerRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;


    public SqueezerRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE_BG,20 ,13, 134, 62);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.SQUEEZER));
    }

    @Override
    public RecipeType<SqueezerRecipe> getRecipeType() {
        return SQUEEZER_RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.wlgyl.squeezer");
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return icon;
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, SqueezerRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 6, 22).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.INPUT, 60, 22).addIngredients(recipe.getIngredients().get(0));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 114, 22).addItemStack(recipe.getResultItem(null));
    }
}
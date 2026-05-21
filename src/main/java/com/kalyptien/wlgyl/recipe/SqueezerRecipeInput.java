package com.kalyptien.wlgyl.recipe;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

public class SqueezerRecipeInput implements RecipeInput {

    private final ItemStack agrume;
    private final ItemStack squeezer;

    public SqueezerRecipeInput(ItemStack agrumeItem, ItemStack squeezerItem) {
        this.agrume = agrumeItem;
        this.squeezer = squeezerItem;
    }

    @Override
    public ItemStack getItem(int index) {
        if(index == 0){
            return agrume;
        }
        else if(index == 1){
            return squeezer;
        }

        return null;
    }

    @Override
    public int size() {
        return 2;
    }
}

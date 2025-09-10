package com.kalyptien.wlgyl.recipe;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.RecipeInput;

import java.util.Iterator;
import java.util.List;

public class BrewingBarrelRecipeInput implements RecipeInput {

    private final ItemStack agrume;
    private final ItemStack sugar;

    public BrewingBarrelRecipeInput(ItemStack agrumeItem, ItemStack sugarItem) {
        this.agrume = agrumeItem;
        this.sugar = sugarItem;
    }

    @Override
    public ItemStack getItem(int index) {
        if(index == 0){
            return agrume;
        }
        else if(index == 1){
            return sugar;
        }

        return null;
    }

    @Override
    public int size() {
        return 2;
    }
}

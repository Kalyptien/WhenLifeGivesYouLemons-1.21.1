package com.kalyptien.wlgyl.datagen;

import com.kalyptien.wlgyl.block.ModBlocks;
import com.kalyptien.wlgyl.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SQUEEZER.get())
                .pattern(" I ")
                .pattern("XIX")
                .pattern("BIB")
                .define('X', Blocks.IRON_BARS)
                .define('B', Items.BUCKET)
                .define('I', Items.IRON_INGOT)
                .unlockedBy("has_iron", has(Items.IRON_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BREWING_BARREL.get())
                .pattern(" I ")
                .pattern("IBI")
                .pattern(" I ")
                .define('B', Blocks.BARREL)
                .define('I', Items.IRON_INGOT)
                .unlockedBy("has_iron", has(Items.IRON_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.INDUSTRIAL_BREWING_BARREL.get())
                .pattern("XIX")
                .pattern("IBI")
                .pattern("XIX")
                .define('B', ModBlocks.BREWING_BARREL)
                .define('X', Items.IRON_INGOT)
                .define('I', Blocks.IRON_BLOCK)
                .unlockedBy("has_iron_block", has(Blocks.IRON_BLOCK))
                .save(recipeOutput);

    }
}

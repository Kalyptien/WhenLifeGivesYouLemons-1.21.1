package com.kalyptien.wlgyl.datagen;

import com.kalyptien.wlgyl.block.ModBlocks;
import com.kalyptien.wlgyl.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.ShapelessRecipe;
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
                .pattern(" X ")
                .pattern("IXI")
                .pattern("IBI")
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

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.CITRUS_PLANKS.get(), 4)
                .requires(ModBlocks.CITRUS_LOG)
                .requires(ModBlocks.CITRUS_WOOD)
                .requires(ModBlocks.STRIPPED_CITRUS_LOG)
                .requires(ModBlocks.STRIPPED_CITRUS_WOOD)
                .unlockedBy("has_citrus", has(ModBlocks.CITRUS_LOG))
                .save(recipeOutput);

        stairBuilder(ModBlocks.CITRUS_STAIRS.get(), Ingredient.of(ModBlocks.CITRUS_PLANKS)).group("citrus")
                .unlockedBy("has_citrus", has(ModBlocks.CITRUS_PLANKS)).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CITRUS_SLAB.get(), ModBlocks.CITRUS_PLANKS.get());

        buttonBuilder(ModBlocks.CITRUS_BUTTON.get(), Ingredient.of(ModBlocks.CITRUS_PLANKS.get())).group("citrus")
                .unlockedBy("has_citrus", has(ModBlocks.CITRUS_PLANKS.get())).save(recipeOutput);
        pressurePlate(recipeOutput, ModBlocks.CITRUS_PRESSURE_PLATE.get(), ModBlocks.CITRUS_PLANKS.get());

        fenceBuilder(ModBlocks.CITRUS_FENCE.get(), Ingredient.of(ModBlocks.CITRUS_PLANKS.get())).group("citrus")
                .unlockedBy("has_citrus", has(ModBlocks.CITRUS_PLANKS.get())).save(recipeOutput);
        fenceGateBuilder(ModBlocks.CITRUS_FENCE_GATE.get(), Ingredient.of(ModBlocks.CITRUS_PLANKS.get())).group("citrus")
                .unlockedBy("has_citrus", has(ModBlocks.CITRUS_PLANKS.get())).save(recipeOutput);

        doorBuilder(ModBlocks.CITRUS_DOOR.get(), Ingredient.of(ModBlocks.CITRUS_PLANKS.get())).group("citrus")
                .unlockedBy("has_citrus", has(ModBlocks.CITRUS_PLANKS.get())).save(recipeOutput);
        trapdoorBuilder(ModBlocks.CITRUS_TRAPDOOR.get(), Ingredient.of(ModBlocks.CITRUS_PLANKS.get())).group("citrus")
                .unlockedBy("has_citrus", has(ModBlocks.CITRUS_PLANKS.get())).save(recipeOutput);
    }
}

package com.kalyptien.wlgyl.recipe;

import com.kalyptien.wlgyl.block.ModBlocks;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

public record BrewingBarrelRecipe(Ingredient sugarItem, Ingredient agrumeItem, Ingredient waterItem, ItemStack output) implements Recipe<BrewingBarrelRecipeInput> {
    // inputItem & output ==> Read From JSON File!
    // brewingBarrelRecipeInput --> INVENTORY of the Block Entity

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(sugarItem);
        list.add(agrumeItem);
        list.add(waterItem);
        return list;
    }

    @Override
    public boolean matches(BrewingBarrelRecipeInput brewingBarrelRecipeInput, Level level) {
        if (level.isClientSide()) {
            return false;
        }

        return agrumeItem.test(brewingBarrelRecipeInput.getItem(0))
                && sugarItem.test(brewingBarrelRecipeInput.getItem(1))
                && waterItem.test(brewingBarrelRecipeInput.getItem(2));
    }

    @Override
    public ItemStack assemble(BrewingBarrelRecipeInput brewingBarrelRecipeInput, HolderLookup.Provider provider) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int i, int i1) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.BREWING_BARREL_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.BREWING_BARREL_TYPE.get();
    }

    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(ModBlocks.BREWING_BARREL);
    }

    public static class Serializer implements RecipeSerializer<BrewingBarrelRecipe> {
        public static final MapCodec<BrewingBarrelRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.CODEC_NONEMPTY.fieldOf("sugar").forGetter(BrewingBarrelRecipe::sugarItem),
                Ingredient.CODEC_NONEMPTY.fieldOf("agrume").forGetter(BrewingBarrelRecipe::agrumeItem),
                Ingredient.CODEC_NONEMPTY.fieldOf("water").forGetter(BrewingBarrelRecipe::waterItem),
                ItemStack.CODEC.fieldOf("result").forGetter(BrewingBarrelRecipe::output)
        ).apply(inst, BrewingBarrelRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, BrewingBarrelRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        Ingredient.CONTENTS_STREAM_CODEC, BrewingBarrelRecipe::sugarItem,
                        Ingredient.CONTENTS_STREAM_CODEC, BrewingBarrelRecipe::agrumeItem,
                        Ingredient.CONTENTS_STREAM_CODEC, BrewingBarrelRecipe::waterItem,
                        ItemStack.STREAM_CODEC, BrewingBarrelRecipe::output,
                        BrewingBarrelRecipe::new);

        @Override
        public MapCodec<BrewingBarrelRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, BrewingBarrelRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}
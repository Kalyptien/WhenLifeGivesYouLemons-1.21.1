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

public record SqueezerRecipe(Ingredient squeezerItem, Ingredient agrumeItem, ItemStack output) implements Recipe<SqueezerRecipeInput> {
    // inputItem & output ==> Read From JSON File!
    // squeezerRecipeInput --> INVENTORY of the Block Entity

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(squeezerItem);
        list.add(agrumeItem);
        return list;
    }

    @Override
    public boolean matches(SqueezerRecipeInput squeezerRecipeInput, Level level) {
        if (level.isClientSide()) {
            return false;
        }

        return agrumeItem.test(squeezerRecipeInput.getItem(0))
                && squeezerItem.test(squeezerRecipeInput.getItem(1));
    }

    @Override
    public ItemStack assemble(SqueezerRecipeInput squeezerRecipeInput, HolderLookup.Provider provider) {
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
        return ModRecipes.SQUEEZER_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.SQUEEZER_TYPE.get();
    }

    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(ModBlocks.SQUEEZER);
    }

    public static class Serializer implements RecipeSerializer<SqueezerRecipe> {
        public static final MapCodec<SqueezerRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.CODEC_NONEMPTY.fieldOf("squeezer").forGetter(SqueezerRecipe::squeezerItem),
                Ingredient.CODEC_NONEMPTY.fieldOf("agrume").forGetter(SqueezerRecipe::agrumeItem),
                ItemStack.CODEC.fieldOf("result").forGetter(SqueezerRecipe::output)
        ).apply(inst, SqueezerRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, SqueezerRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        Ingredient.CONTENTS_STREAM_CODEC, SqueezerRecipe::squeezerItem,
                        Ingredient.CONTENTS_STREAM_CODEC, SqueezerRecipe::agrumeItem,
                        ItemStack.STREAM_CODEC, SqueezerRecipe::output,
                        SqueezerRecipe::new);

        @Override
        public MapCodec<SqueezerRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, SqueezerRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}
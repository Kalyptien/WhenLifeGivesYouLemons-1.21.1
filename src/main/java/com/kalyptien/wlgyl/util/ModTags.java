package com.kalyptien.wlgyl.util;

import com.kalyptien.wlgyl.WhenLifeGivesYouLemonsMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModTags {
    public static class Blocks {
    }

    public static class Items {
        public static final TagKey<Item> AGRUMES = createTag("agrumes");
        public static final TagKey<Item> FRUITS = createTag("fruits");
        public static final TagKey<Item> BERRYS = createTag("berrys");
        public static final TagKey<Item> LEMONADES = createTag("lemonades");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(WhenLifeGivesYouLemonsMod.MOD_ID, name));
        }
    }
}

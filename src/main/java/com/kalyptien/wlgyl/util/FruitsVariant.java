package com.kalyptien.wlgyl.util;

import com.kalyptien.wlgyl.item.ModItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.Arrays;
import java.util.Comparator;

public enum FruitsVariant {
    NONE(0, "none", -1, false),
    LEMON(1, "item.wlgyl.lemon", 0xFFf0f05a, true),
    ORANGE(2, "item.wlgyl.orange", 0xFFffa944, true),
    LIME(3, "item.wlgyl.lime", 0xFF93f764, true),
    GRAPEFRUIT(4, "item.wlgyl.grapefruit", 0xFFcf6049, true),
    BLOOD_ORANGE(5, "item.wlgyl.blood_orange", 0xFFcc4727, true),
    CAVIAR_LEMON(6, "item.wlgyl.caviar_lemon", 0xFF486e66, true),
    BUDDHA_HAND(7, "item.wlgyl.buddha_hand", 0xFFc8c8c8, true),
    APPLE(8, "item.minecraft.apple", 0xFFE8DB8E, false),
    GLOW_BERRIES(9, "item.minecraft.glow_berries", 0xFFE3F24E, false),
    SWEET_BERRIES(10, "item.minecraft.sweet_berries", 0xFF8C0808, false),
    MELON_SLICE(11, "item.minecraft.melon_slice", 0xFFED3434, false);

    private static final FruitsVariant[] BY_ID = Arrays.stream(values()).sorted(
            Comparator.comparingInt(FruitsVariant::getId)).toArray(FruitsVariant[]::new);
    private final int id;
    private final String name;
    private final int color;
    private final boolean isAgrume;

    FruitsVariant(int id, String name, int color, boolean isAgrume) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.isAgrume = isAgrume;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public int getColor() {
        return this.color;
    }

    public boolean getIsAgrume(){
        return this.isAgrume;
    }

    public static int getMin(){
        return 0;
    }

    public static int getMax(){
        return BY_ID.length-1;
    }

    public static FruitsVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }

    public static FruitsVariant byName(String name) {
        for (int i = 0; i < BY_ID.length; i++) {
            if(BY_ID[i].name.equals(name)){
                return BY_ID[i];
            }
        }

        return BY_ID[0];
    }

    public static Item getJuiceItemFromId(int id){
        if (NONE.id == id){
            return  null;
        } else if (LEMON.id == id){
            return  ModItems.LEMON_JUICE.get();
        } else if (ORANGE.id == id){
            return  ModItems.ORANGE_JUICE.get();
        } else if (LIME.id == id){
            return  ModItems.LIME_JUICE.get();
        } else if (GRAPEFRUIT.id == id){
            return  ModItems.GRAPEFRUIT_JUICE.get();
        } else if (CAVIAR_LEMON.id == id){
            return  ModItems.CAVIAR_LEMON_JUICE.get();
        } else if (BUDDHA_HAND.id == id){
            return  ModItems.BUDDHA_HAND_JUICE.get();
        } else if (BLOOD_ORANGE.id == id){
            return  ModItems.BLOOD_ORANGE_JUICE.get();
        } else if (APPLE.id == id){
            return  ModItems.APPLE_JUICE.get();
        } else if (MELON_SLICE.id == id){
            return  ModItems.MELON_JUICE.get();
        } else if (GLOW_BERRIES.id == id){
            return  ModItems.GLOW_BERRIES_JUICE.get();
        } else if (SWEET_BERRIES.id == id){
            return  ModItems.SWEET_BERRIES_JUICE.get();
        }
        return null;
    }

    public static Item getLemonadeFromId(int id, int effectModifier){
        if (NONE.id == id){
            return  Items.WATER_BUCKET;
        } else if (LEMON.id == id){
            return  ModItems.LEMON_LEMONADE.get();
        } else if (ORANGE.id == id){
            return  ModItems.ORANGE_LEMONADE.get();
        } else if (LIME.id == id){
            return  ModItems.LIME_LEMONADE.get();
        } else if (GRAPEFRUIT.id == id){
            if (effectModifier == EffectsVariant.NONE.getId()){
                return  ModItems.GRAPEFRUIT_LEMONADE.get();
            } else if (effectModifier == EffectsVariant.LONG.getId()) {
                return  ModItems.GRAPEFRUIT_LEMONADE_LONG.get();
            } else if (effectModifier == EffectsVariant.STRONG.getId()) {
                return  ModItems.GRAPEFRUIT_LEMONADE_STRONG.get();
            }
        } else if (CAVIAR_LEMON.id == id){
            if (effectModifier == EffectsVariant.NONE.getId()){
                return  ModItems.CAVIAR_LEMON_LEMONADE.get();
            } else if (effectModifier == EffectsVariant.LONG.getId()) {
                return  ModItems.CAVIAR_LEMON_LEMONADE_LONG.get();
            } else if (effectModifier == EffectsVariant.STRONG.getId()) {
                return  ModItems.CAVIAR_LEMON_LEMONADE_STRONG.get();
            }
        } else if (BUDDHA_HAND.id == id){
            if (effectModifier == EffectsVariant.NONE.getId()){
                return  ModItems.BUDDHA_HAND_LEMONADE.get();
            } else if (effectModifier == EffectsVariant.LONG.getId()) {
                return  ModItems.BUDDHA_HAND_LEMONADE_LONG.get();
            } else if (effectModifier == EffectsVariant.STRONG.getId()) {
                return  ModItems.BUDDHA_HAND_LEMONADE_STRONG.get();
            }
        } else if (BLOOD_ORANGE.id == id){
            if (effectModifier == EffectsVariant.NONE.getId()){
                return  ModItems.BLOOD_ORANGE_LEMONADE.get();
            } else if (effectModifier == EffectsVariant.LONG.getId()) {
                return  ModItems.BLOOD_ORANGE_LEMONADE_LONG.get();
            } else if (effectModifier == EffectsVariant.STRONG.getId()) {
                return  ModItems.BLOOD_ORANGE_LEMONADE_STRONG.get();
            }
        } else if (APPLE.id == id){
            return  null;
        } else if (MELON_SLICE.id == id){
            return  null;
        } else if (GLOW_BERRIES.id == id){
            return  null;
        } else if (SWEET_BERRIES.id == id){
            return  null;
        }
        return Items.WATER_BUCKET;
    }
}

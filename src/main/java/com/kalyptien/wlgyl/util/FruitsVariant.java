package com.kalyptien.wlgyl.util;

import com.kalyptien.wlgyl.item.ModItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.Arrays;
import java.util.Comparator;

public enum FruitsVariant {
    NONE(0, "none"),
    LEMON(1, "item.wlgyl.lemon"),
    ORANGE(2, "item.wlgyl.orange"),
    LIME(3, "item.wlgyl.lime"),
    GRAPEFRUIT(4, "item.wlgyl.grapefruit"),
    BLOOD_ORANGE(5, "item.wlgyl.blood_orange"),
    CAVIAR_LEMON(6, "item.wlgyl.caviar_lemon"),
    BUDDHA_HAND(7, "item.wlgyl.buddha_hand"),
    APPLE(8, "item.minecraft.apple"),
    GLOW_BERRIES(9, "item.minecraft.glow_berries"),
    SWEET_BERRIES(10, "item.minecraft.sweet_berries"),
    MELON_SLICE(11, "item.minecraft.melon_slice");

    private static final FruitsVariant[] BY_ID = Arrays.stream(values()).sorted(
            Comparator.comparingInt(FruitsVariant::getId)).toArray(FruitsVariant[]::new);
    private final int id;
    private final String name;

    FruitsVariant(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return this.name;
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
}

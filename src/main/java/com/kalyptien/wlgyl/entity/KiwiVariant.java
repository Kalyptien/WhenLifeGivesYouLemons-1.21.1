package com.kalyptien.wlgyl.entity;

import java.util.Arrays;
import java.util.Comparator;

public enum  KiwiVariant {
    LEMON(0),
    ORANGE(1),
    LIME(2),
    GRAPEFRUIT(2),
    BLOOD_ORANGE(2),
    CAVIAR_LEMON(2),
    BUDDHA_HAND(2);

    private static final KiwiVariant[] BY_ID = Arrays.stream(values()).sorted(
            Comparator.comparingInt(KiwiVariant::getId)).toArray(KiwiVariant[]::new);
    private final int id;

    KiwiVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static KiwiVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}

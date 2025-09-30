package com.kalyptien.wlgyl.util;

import java.util.Arrays;
import java.util.Comparator;

public enum AgrumesVariant {
    NONE(0),
    LEMON(1),
    ORANGE(2),
    LIME(3),
    GRAPEFRUIT(4),
    BLOOD_ORANGE(5),
    CAVIAR_LEMON(6),
    BUDDHA_HAND(7);

    private static final AgrumesVariant[] BY_ID = Arrays.stream(values()).sorted(
            Comparator.comparingInt(AgrumesVariant::getId)).toArray(AgrumesVariant[]::new);
    private final int id;

    AgrumesVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static AgrumesVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}

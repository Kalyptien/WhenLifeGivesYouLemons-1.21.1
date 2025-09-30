package com.kalyptien.wlgyl.util;

import java.util.Arrays;
import java.util.Comparator;

public enum EffectsVariant {
    NONE(0),
    LONG(1),
    STRONG(2);

    private static final EffectsVariant[] BY_ID = Arrays.stream(values()).sorted(
            Comparator.comparingInt(EffectsVariant::getId)).toArray(EffectsVariant[]::new);
    private final int id;

    EffectsVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static EffectsVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}

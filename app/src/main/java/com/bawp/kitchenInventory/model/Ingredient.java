package com.bawp.kitchenInventory.model;

import java.util.Arrays;
import java.util.Objects;

public enum Ingredient {
    BREAD,
    EGGS,
    CHEDDAR_CHEESE,
    MILK,
    SALT,
    BUTTER;

    public static String[] getNames(Class<? extends Enum<?>> e) {
        return Arrays.stream(Objects.requireNonNull(e.getEnumConstants())).map(Enum::name).toArray(String[]::new);
    }
}



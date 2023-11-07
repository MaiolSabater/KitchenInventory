package com.bawp.kitchenInventory.util;

import androidx.room.TypeConverter;

import com.bawp.kitchenInventory.model.Category;
import com.bawp.kitchenInventory.model.Ingredient;
import com.bawp.kitchenInventory.model.Level;

import java.util.Date;

public class Converter {

    @TypeConverter
    public static Date fromTimestamp (Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long dateToTimestamp (Date date) {
        return date == null ? null : date.getTime();
    }

    @TypeConverter
    public static String fromCategory(Category category) {
        return category == null ? null : category.name();
    }

    @TypeConverter
    public static Category toCategory(String measure) {
        return measure == null ? null : Category.valueOf(measure);
    }

    @TypeConverter
    public static String fromLevel(Level level) {
        return level == null ? null : level.name();
    }

    @TypeConverter
    public static Level toLevel(String level) {
        return level == null ? null : Level.valueOf(level);
    }

    @TypeConverter
    public static String fromIngredient(Ingredient ingredient) {
        return ingredient == null ? null : ingredient.name();
    }

    @TypeConverter
    public static Ingredient toIngredient(String ingredient) {
        return ingredient == null ? null : Ingredient.valueOf(ingredient);
    }
}


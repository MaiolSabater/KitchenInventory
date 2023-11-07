package com.bawp.kitchenInventory.data;

import com.bawp.kitchenInventory.model.Ingredient;
import com.bawp.kitchenInventory.model.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeInventory {
    private ArrayList<Ingredient> ingredients;

    private ArrayList<Recipe> recipes;

    public RecipeInventory(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
        this.recipes = new ArrayList<>();
        // Recipe 1: Classic Grilled Cheese Sandwich
        ArrayList<Ingredient> ingredients1 = new ArrayList<>();
        ingredients1.add(Ingredient.BREAD);
        ingredients1.add(Ingredient.CHEDDAR_CHEESE);
        ingredients1.add(Ingredient.BUTTER);
        String recipe1 = "1. Butter one side of each bread slice.\n" +
                "2. Place cheddar cheese between two slices of bread with the buttered side facing out.\n" +
                "3. Heat a skillet over medium heat and grill the sandwich until both sides are golden brown and the cheese is melted.";

        Recipe recipe1Object = new Recipe(1, "Classic Grilled Cheese Sandwich", ingredients1, recipe1);

        // Recipe 2: Cheesy Scrambled Eggs
        ArrayList<Ingredient> ingredients2 = new ArrayList<>();
        ingredients2.add(Ingredient.EGGS);
        ingredients2.add(Ingredient.CHEDDAR_CHEESE);
        ingredients2.add(Ingredient.MILK);
        ingredients2.add(Ingredient.SALT);
        String recipe2 = "1. Whisk eggs, a splash of milk, and a pinch of salt in a bowl.\n" +
                "2. Pour the mixture into a heated, greased skillet.\n" +
                "3. Stir the eggs as they cook and sprinkle cheddar cheese on top until it's melted.";

        Recipe recipe2Object = new Recipe(2, "Cheesy Scrambled Eggs", ingredients2, recipe2);

        // Recipe 3: Cheddar Cheese Toast
        ArrayList<Ingredient> ingredients3 = new ArrayList<>();
        ingredients3.add(Ingredient.BREAD);
        ingredients3.add(Ingredient.CHEDDAR_CHEESE);
        ingredients3.add(Ingredient.BUTTER);
        String recipe3 = "1. Preheat your oven's broiler.\n" +
                "2. Butter one side of each bread slice and sprinkle cheddar cheese on the non-buttered side.\n" +
                "3. Place the slices on a baking sheet and broil until the cheese is bubbly and golden.";

        Recipe recipe3Object = new Recipe(3, "Cheddar Cheese Toast", ingredients3, recipe3);

        // Recipe 4: Cheesy French Toast
        ArrayList<Ingredient> ingredients4 = new ArrayList<>();
        ingredients4.add(Ingredient.BREAD);
        ingredients4.add(Ingredient.EGGS);
        ingredients4.add(Ingredient.CHEDDAR_CHEESE);
        ingredients4.add(Ingredient.MILK);
        ingredients4.add(Ingredient.SALT);
        String recipe4 = "1. Whisk eggs, milk, and a pinch of salt in a bowl.\n" +
                "2. Dip bread slices into the egg mixture.\n" +
                "3. Sprinkle cheddar cheese between two slices and cook in a skillet until both sides are golden brown and the cheese is melted.";

        Recipe recipe4Object = new Recipe(4, "Cheesy French Toast", ingredients4, recipe4);

        // Recipe 5: Cheddar Cheese Omelette
        ArrayList<Ingredient> ingredients5 = new ArrayList<>();
        ingredients5.add(Ingredient.EGGS);
        ingredients5.add(Ingredient.CHEDDAR_CHEESE);
        ingredients5.add(Ingredient.MILK);
        ingredients5.add(Ingredient.SALT);
        String recipe5 = "1. Whisk eggs, a splash of milk, and a pinch of salt in a bowl.\n" +
                "2. Pour the mixture into a heated, greased skillet and let it set.\n" +
                "3. Sprinkle cheddar cheese on one half of the omelette and fold the other half over the cheese. Cook until the cheese is melted.";

        Recipe recipe5Object = new Recipe(5, "Cheddar Cheese Omelette", ingredients5, recipe5);

        recipes.add(recipe1Object);
        recipes.add(recipe2Object);
        recipes.add(recipe3Object);
        recipes.add(recipe4Object);
        recipes.add(recipe5Object);
    }

    public RecipeInventory() {
        this.ingredients = new ArrayList<>();
        this.recipes = new ArrayList<>();
        // Recipe 1: Classic Grilled Cheese Sandwich
        ArrayList<Ingredient> ingredients1 = new ArrayList<>();
        ingredients1.add(Ingredient.BREAD);
        ingredients1.add(Ingredient.CHEDDAR_CHEESE);
        ingredients1.add(Ingredient.BUTTER);
        String recipe1 = "1. Butter one side of each bread slice.\n" +
                "2. Place cheddar cheese between two slices of bread with the buttered side facing out.\n" +
                "3. Heat a skillet over medium heat and grill the sandwich until both sides are golden brown and the cheese is melted.";

        Recipe recipe1Object = new Recipe(1, "Classic Grilled Cheese Sandwich", ingredients1, recipe1);

        // Recipe 2: Cheesy Scrambled Eggs
        ArrayList<Ingredient> ingredients2 = new ArrayList<>();
        ingredients2.add(Ingredient.EGGS);
        ingredients2.add(Ingredient.CHEDDAR_CHEESE);
        ingredients2.add(Ingredient.MILK);
        ingredients2.add(Ingredient.SALT);
        String recipe2 = "1. Whisk eggs, a splash of milk, and a pinch of salt in a bowl.\n" +
                "2. Pour the mixture into a heated, greased skillet.\n" +
                "3. Stir the eggs as they cook and sprinkle cheddar cheese on top until it's melted.";

        Recipe recipe2Object = new Recipe(2, "Cheesy Scrambled Eggs", ingredients2, recipe2);

        // Recipe 3: Cheddar Cheese Toast
        ArrayList<Ingredient> ingredients3 = new ArrayList<>();
        ingredients3.add(Ingredient.BREAD);
        ingredients3.add(Ingredient.CHEDDAR_CHEESE);
        ingredients3.add(Ingredient.BUTTER);
        String recipe3 = "1. Preheat your oven's broiler.\n" +
                "2. Butter one side of each bread slice and sprinkle cheddar cheese on the non-buttered side.\n" +
                "3. Place the slices on a baking sheet and broil until the cheese is bubbly and golden.";

        Recipe recipe3Object = new Recipe(3, "Cheddar Cheese Toast", ingredients3, recipe3);

        // Recipe 4: Cheesy French Toast
        ArrayList<Ingredient> ingredients4 = new ArrayList<>();
        ingredients4.add(Ingredient.BREAD);
        ingredients4.add(Ingredient.EGGS);
        ingredients4.add(Ingredient.CHEDDAR_CHEESE);
        ingredients4.add(Ingredient.MILK);
        ingredients4.add(Ingredient.SALT);
        String recipe4 = "1. Whisk eggs, milk, and a pinch of salt in a bowl.\n" +
                "2. Dip bread slices into the egg mixture.\n" +
                "3. Sprinkle cheddar cheese between two slices and cook in a skillet until both sides are golden brown and the cheese is melted.";

        Recipe recipe4Object = new Recipe(4, "Cheesy French Toast", ingredients4, recipe4);

        // Recipe 5: Cheddar Cheese Omelette
        ArrayList<Ingredient> ingredients5 = new ArrayList<>();
        ingredients5.add(Ingredient.EGGS);
        ingredients5.add(Ingredient.CHEDDAR_CHEESE);
        ingredients5.add(Ingredient.MILK);
        ingredients5.add(Ingredient.SALT);
        String recipe5 = "1. Whisk eggs, a splash of milk, and a pinch of salt in a bowl.\n" +
                "2. Pour the mixture into a heated, greased skillet and let it set.\n" +
                "3. Sprinkle cheddar cheese on one half of the omelette and fold the other half over the cheese. Cook until the cheese is melted.";

        Recipe recipe5Object = new Recipe(5, "Cheddar Cheese Omelette", ingredients5, recipe5);

        recipes.add(recipe1Object);
        recipes.add(recipe2Object);
        recipes.add(recipe3Object);
        recipes.add(recipe4Object);
        recipes.add(recipe5Object);
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void addIngredient(Ingredient ingredient) {
        if(!this.ingredients.contains(ingredient)) {
            this.ingredients.add(ingredient);
        }
    }

    public void removeIngredient(Ingredient ingredient) {
        this.ingredients.remove(ingredient);
    }

    public boolean hasIngredient(Ingredient ingredient) {
        return ingredients.contains(ingredient);
    }

    public boolean hasIngredients(List<Ingredient> ingredients) {
        boolean result = true;
        for(Ingredient i : ingredients) {
            if(!hasIngredient(i)) {
                result = false;
            }
        }
        return result;
    }

    public Recipe generateRecipes() {
        for (Recipe r : recipes) {
            if (hasIngredients(r.getListIngredients())) {
                return r;
            }
        }
        return null;
    }

    public ArrayList<Ingredient> getGroceryList(Recipe recipe) {
        ArrayList<Ingredient> result = new ArrayList<>();
        for (Ingredient i : recipe.getListIngredients()) {
            if (!hasIngredient(i)) {
                result.add(i);
            }
        }
        return result;
    }

    public ArrayList<Ingredient> getGroceryList() {
        ArrayList<Ingredient> allIngredients = new ArrayList<>();
        allIngredients.add(Ingredient.BREAD);
        allIngredients.add(Ingredient.EGGS);
        allIngredients.add(Ingredient.CHEDDAR_CHEESE);
        allIngredients.add(Ingredient.MILK);
        allIngredients.add(Ingredient.SALT);
        allIngredients.add(Ingredient.BUTTER);

        ArrayList<Ingredient> result = new ArrayList<>();

        for (Ingredient i: allIngredients) {
            if (!this.ingredients.contains(i)) {
                result.add(i);
            }
        }
        return result;
    }
}

package com.bawp.kitchenInventory.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.bawp.kitchenInventory.model.Ingredient;
import com.bawp.kitchenInventory.model.Product;
import com.bawp.kitchenInventory.model.Recipe;
import com.bawp.kitchenInventory.util.ProductRoomDatabase;

import java.util.ArrayList;
import java.util.List;

public class InventoryRepository {
    private final ProductDao productDao;
    private final LiveData<List<Product>> allProducts;
    private final LiveData<List<Ingredient>> allIngredients;
    private final ArrayList<Ingredient> ingredients;
    private ArrayList<Recipe> recipes;

    public InventoryRepository(Application application) {
        ProductRoomDatabase database = ProductRoomDatabase.getDatabase(application);
        productDao = database.productDao();
        ingredients = new ArrayList<>();
        recipes = new ArrayList<>();
        allProducts = productDao.getProducts();
        allIngredients = productDao.getIngredients();

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

    public LiveData<List<Product>> getAllProducts() {
        return allProducts;
    }

    public LiveData<List<Ingredient>> getAllIngredients() {
        return allIngredients;
    }

    public ArrayList<Ingredient> getIngredients() {return ingredients;}

    public ArrayList<Recipe> getRecipes() {return recipes;}

    public void insert(Product product) {
        ProductRoomDatabase.databaseWriterExecutor.execute(() -> productDao.insertProduct(product));
        ingredients.add(product.getIngredient());
        System.out.println("A");
        System.out.println(ingredients);
    }

    public LiveData<Product> get(long id) {return productDao.get(id);}

    public void update(Product product) {
        ProductRoomDatabase.databaseWriterExecutor.execute(() -> productDao.update(product));
    }

    public void delete(Product product) {
        ProductRoomDatabase.databaseWriterExecutor.execute(() -> productDao.delete(product));
        ingredients.remove(product.getIngredient());
    }

    /**
     * Checks whether the inventory has a certain ingredient.
     * @param ingredient is the ingredient to check for
     * @return true if the ingredient is in the inventory.
     */
    public boolean hasIngredient(Ingredient ingredient) {
        return ingredients.contains(ingredient);
    }

    /**
     * Checks whether the given list of ingredients is in the inventory.
     * @param ingredients is the list of ingredients to check for.
     * @return true if all the ingredients are in the inventory.
     */
    public boolean hasIngredients(ArrayList<Ingredient> ingredients) {
        boolean result = true;
        for(Ingredient i : ingredients) {
            if(!hasIngredient(i)) {
                result = false;
            }
        }
        return result;
    }

    /**
     * Generates a recipe based on the ingredients in the inventory.
     * @return a recipe if one is possible, null otherwise
     */
    public Recipe generateRecipes() {
        for (Recipe r : recipes) {
            if (hasIngredients(r.getListIngredients())) {
                return r;
            }
        }
        return null;
    }

    /**
     * Creates the grocery list for a certain recipe
     * @param recipe is the recipe to create a list of ingredients for.
     * @return a list of ingredients needed by the recipe that are not in the inventory.
     */
    public ArrayList<Ingredient> getGroceryList(Recipe recipe) {
        ArrayList<Ingredient> result = new ArrayList<>();
        for (Ingredient i : recipe.getListIngredients()) {
            if (!hasIngredient(i)) {
                result.add(i);
            }
        }
        return result;
    }

    /**
     * @return a grocery list from all the possible ingredients in the system that are not in the current inventory.
     * IMPORTANT NOTE TO DEVELOPER, AFTER ADDING AN INGREDIENT TO ENUM IT MUST ALSO BE ADDED HERE.
     */
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

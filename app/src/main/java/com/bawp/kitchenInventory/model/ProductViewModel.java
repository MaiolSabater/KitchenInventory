package com.bawp.kitchenInventory.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.bawp.kitchenInventory.data.InventoryRepository;
import com.bawp.kitchenInventory.data.RecipeInventory;

import java.util.ArrayList;
import java.util.List;

public class ProductViewModel extends AndroidViewModel {
    public static InventoryRepository repository;
    public final LiveData<List<Product>> allProducts;
    public final LiveData<List<Ingredient>> allIngredients;
    public ProductViewModel(@NonNull Application application) {
        super(application);
        repository = new InventoryRepository(application);
        allProducts = repository.getAllProducts();
        allIngredients = repository.getAllIngredients();
    }

    public LiveData<List<Product>> getAllProducts() { return allProducts; }
    public static void insert(Product product) {repository.insert(product);}
    public LiveData<Product> get(long id) {return repository.get(id);}
    public static void update(Product product) {repository.update(product);}
    public static void delete(Product product) {repository.delete(product);}
    public ArrayList<Ingredient> getGroceryList() {return repository.getGroceryList();}
    public ArrayList<Recipe> getRecipes() {return repository.getRecipes();}
    public Recipe getRecipe() {return repository.generateRecipes();}

}

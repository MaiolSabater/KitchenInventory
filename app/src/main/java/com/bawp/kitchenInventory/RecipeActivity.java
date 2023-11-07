package com.bawp.kitchenInventory;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawp.kitchenInventory.adapter.RecipeRecyclerViewAdapter;
import com.bawp.kitchenInventory.adapter.RecyclerViewAdapter;
import com.bawp.kitchenInventory.data.RecipeInventory;
import com.bawp.kitchenInventory.model.Ingredient;
import com.bawp.kitchenInventory.model.ProductViewModel;
import com.bawp.kitchenInventory.model.Recipe;
import com.bawp.kitchenInventory.model.SharedViewModel;

import java.util.ArrayList;

public class RecipeActivity extends AppCompatActivity {
    private ProductViewModel productViewModel;
    private RecyclerView recyclerView;
    private RecipeRecyclerViewAdapter recipeRecyclerViewAdapter;
    private SharedViewModel sharedViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        productViewModel = new ViewModelProvider.AndroidViewModelFactory(
                RecipeActivity.this.getApplication())
                .create(ProductViewModel.class);

        sharedViewModel = new ViewModelProvider(this)
                .get(SharedViewModel.class);

        ArrayList<Recipe> recipes = productViewModel.getRecipes();

        if (recipes != null) {
            recipeRecyclerViewAdapter = new RecipeRecyclerViewAdapter(recipes.get(0));
            recyclerView.setAdapter(recipeRecyclerViewAdapter);
        } else {
            Recipe defaultRecipe = new Recipe(0,"No recipe found for the ingredients you have", new ArrayList<>(),"Buy more ingredients");
            recipeRecyclerViewAdapter = new RecipeRecyclerViewAdapter(defaultRecipe);
            recyclerView.setAdapter(recipeRecyclerViewAdapter);
        }
    }
}

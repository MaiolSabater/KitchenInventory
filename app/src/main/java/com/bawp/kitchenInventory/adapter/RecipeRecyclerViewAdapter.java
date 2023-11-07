package com.bawp.kitchenInventory.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.bawp.kitchenInventory.R;
import com.bawp.kitchenInventory.model.Recipe;


public class RecipeRecyclerViewAdapter extends RecyclerView.Adapter<RecipeRecyclerViewAdapter.ViewHolder>{
    private final Recipe recipe;

    public RecipeRecyclerViewAdapter(Recipe recipe) {
        this.recipe = recipe;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_recipe, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.recipeName.setText(recipe.getName());
        holder.recipeIngredient.setText(recipe.getIngredients());
        holder.recipeSteps.setText(recipe.getSteps());
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public AppCompatTextView recipeName;
        public AppCompatTextView recipeIngredient;
        public AppCompatTextView recipeSteps;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            recipeName = itemView.findViewById(R.id.title);
            recipeIngredient = itemView.findViewById(R.id.ingredients);
            recipeSteps = itemView.findViewById(R.id.method);
        }
    }
}

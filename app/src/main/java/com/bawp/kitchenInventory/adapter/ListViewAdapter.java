package com.bawp.kitchenInventory.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.bawp.kitchenInventory.R;
import com.bawp.kitchenInventory.model.Ingredient;

import java.util.ArrayList;

public class ListViewAdapter  extends RecyclerView.Adapter<ListViewAdapter.ViewHolder> {
    private ArrayList<Ingredient> missingIngredients;

    public ListViewAdapter(ArrayList<Ingredient> missingIngredients) {
        this.missingIngredients = missingIngredients;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StringBuilder r = new StringBuilder();
        for(Ingredient ingredient:missingIngredients) {
            r.append(ingredient.name()).append("\n");
        }
        holder.list.setText(r.toString());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public AppCompatTextView list;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            list = itemView.findViewById(R.id.listView);
        }
    }
}

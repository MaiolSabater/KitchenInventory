package com.bawp.kitchenInventory.adapter;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.bawp.kitchenInventory.R;
import com.bawp.kitchenInventory.model.Product;
import com.bawp.kitchenInventory.util.Utils;
import com.google.android.material.chip.Chip;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private final List<Product> productList;
    private final OnProductClickListener productClickListener;

    public RecyclerViewAdapter(List<Product> productList, OnProductClickListener OnProductClickListener) {
        this.productList = productList;
        this.productClickListener = OnProductClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = productList.get(position);
        String formatted = Utils.formatDate(product.getExpiryDate());
        String category = Utils.formatCategory(product.getCategory());

        ColorStateList colorStateList = new ColorStateList(new int[][]{
                new int[] {-android.R.attr.state_enabled},
                new int[] {android.R.attr.state_enabled}
        }, new int[] {
                Color.LTGRAY, //disabled
                Utils.levelColor(product)
        });

        holder.product.setText(product.getIngredient().toString());
        holder.dateChip.setText(formatted);
        holder.dateChip.setTextColor(Utils.levelColor(product));
        holder.dateChip.setChipIconTint(colorStateList);
        holder.categoryChip.setText(category);
        holder.categoryChip.setTextColor(Utils.levelColor(product));
        holder.categoryChip.setChipIconTint(colorStateList);
        holder.deleteButton.setColorFilter(Utils.levelColor(product));
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public AppCompatImageButton deleteButton;
        public AppCompatTextView product;
        public Chip dateChip;
        public Chip categoryChip;

        OnProductClickListener onProductClickListener;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            deleteButton = itemView.findViewById(R.id.product_delete_button);
            product = itemView.findViewById(R.id.product_row_product);
            dateChip = itemView.findViewById(R.id.product_row_chip);
            categoryChip = itemView.findViewById(R.id.category_row_chip);

            this.onProductClickListener = productClickListener;

            itemView.setOnClickListener(this);
            deleteButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Product currProduct = productList.get(getAdapterPosition());
            int id = v.getId();
            if (id == R.id.product_row_layout) {
                onProductClickListener.onProductClick(currProduct);
            } else if (id == R.id.product_delete_button) {
                onProductClickListener.onProductDeleteButtonClick(currProduct);
            }
        }
    }
}

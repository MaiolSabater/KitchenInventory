package com.bawp.kitchenInventory.adapter;

import com.bawp.kitchenInventory.model.Product;

public interface OnProductClickListener {
    void onProductClick(Product product);
    void onProductDeleteButtonClick(Product product);
}

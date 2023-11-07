package com.bawp.kitchenInventory.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.bawp.kitchenInventory.model.Ingredient;
import com.bawp.kitchenInventory.model.Product;

import java.util.List;

@Dao
public interface ProductDao {

    @Insert
    void insertProduct(Product product);

    @Query("DELETE FROM product_table")
    void deleteAll();

    @Query("SELECT * FROM product_table")
    LiveData<List<Product>> getProducts();

    @Query("SELECT ingredient FROM product_table")
    LiveData<List<Ingredient>> getIngredients();

    @Query("SELECT EXISTS (SELECT 1 FROM product_table WHERE product_table.ingredient = :searchIngredient LIMIT 1)")
    LiveData<Boolean> doesEntityExist(Ingredient searchIngredient);

    @Query("SELECT * FROM product_table WHERE product_table.product_id == :id")
    LiveData<Product> get(long id);

    @Update
    void update(Product product);

    @Delete
    void delete(Product product);
}

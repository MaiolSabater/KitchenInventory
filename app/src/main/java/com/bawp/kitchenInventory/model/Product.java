package com.bawp.kitchenInventory.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "product_table")
public class Product {
    @ColumnInfo(name = "product_id")
    @PrimaryKey(autoGenerate = true)
    public long productId;
    @ColumnInfo(name = "ingredient")
    public Ingredient ingredient;
    public Category category;
    @ColumnInfo(name = "expiry_date")
    public Date expiryDate;
    @ColumnInfo(name = "product_level")
    public Level level;
    @ColumnInfo(name = "added_date")
    public Date addedDate;

    public Product(Ingredient ingredient, Category category, Date expiryDate, Level level, Date addedDate) {
        this.ingredient = ingredient;
        this.category = category;
        this.expiryDate = expiryDate;
        this.level = level;
        this.addedDate = addedDate;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", product='" + ingredient + '\'' +
                ", category=" + category +
                ", expiryDate=" + expiryDate +
                ", level=" + level +
                ", addedDate=" + addedDate +
                '}';
    }
}

package com.bawp.kitchenInventory.model;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private int id;
    private String name;
    private ArrayList<Ingredient> ingredients;
    private String steps;

    public Recipe(int id, String name, ArrayList<Ingredient> ingredients, String steps) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.steps = steps;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Ingredient> getListIngredients() {
        return ingredients;
    }

    public String getIngredients(){
        StringBuilder r = new StringBuilder();
        for(Ingredient ingredient:ingredients) {
            r.append(ingredient.name()).append("\n");
        }
        return r.toString();
    }

    public String getSteps() {
        return steps;
    }
}

package com.bawp.kitchenInventory.util;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.bawp.kitchenInventory.model.Category;
import com.bawp.kitchenInventory.model.Level;
import com.bawp.kitchenInventory.model.Product;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Utils {

    public static String formatDate(Date date) {
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) SimpleDateFormat.getDateInstance();
        simpleDateFormat.applyPattern("d MMM yyyy");
        return  simpleDateFormat.format(date);
    }

    public static String formatCategory(Category category) {
        String name;
        if (category == Category.DAIRYEGG) {name = "Dairy & Eggs";}
        else if (category == Category.DRYGOODS) {name = "Dry Goods";}
        else if (category == Category.SPICEHERB) {name = "Spices & Herbs";}
        else {name = "category";}
        return name;
    }

    public static void hideSoftKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(
                Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(),0);
    }

    public static int levelColor(Product product) {
        int color;
        Date currentDate= new Date();
        long oneDayBeforeDueDateTime = product.getExpiryDate().getTime() - (1000 * 60 * 60 * 24); // Subtract one day in milliseconds
        Date oneDayBeforeDueDate = new Date(oneDayBeforeDueDateTime);
        boolean aboutToExpire = (currentDate.before(product.getExpiryDate()) && currentDate.after(oneDayBeforeDueDate));
        if (product.getLevel() == Level.FULL) {
            color = Color.argb(255,155,179,0);
        } else if (product.getLevel() == Level.EMPTY) {
            color = Color.argb(200,201,21,23);
        } else {
            color = Color.argb(200,251,121,15);
        }
        if (aboutToExpire) {
            color = Color.argb(200,201,21,23);
        }
        return color;
    }

}

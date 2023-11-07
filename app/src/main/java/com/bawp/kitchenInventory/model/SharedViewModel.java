package com.bawp.kitchenInventory.model;

import android.database.Cursor;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private final MutableLiveData<Product> selectedItem = new MutableLiveData<>();
    private boolean isEdit;

    public void selectItem(Product product) {
        selectedItem.setValue(product);
    }

    public LiveData<Product> getSelectedItem() {
        return selectedItem;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }

    public boolean getIsEdit() {
        return isEdit;
    }

}

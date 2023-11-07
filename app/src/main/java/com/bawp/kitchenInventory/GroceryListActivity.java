package com.bawp.kitchenInventory;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawp.kitchenInventory.adapter.ListViewAdapter;
import com.bawp.kitchenInventory.model.ProductViewModel;
import com.bawp.kitchenInventory.model.SharedViewModel;


public class GroceryListActivity extends AppCompatActivity {
    private ProductViewModel productViewModel;
    private RecyclerView recyclerView;
    private ListViewAdapter listViewAdapter;
    private SharedViewModel sharedViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery);

        recyclerView = findViewById(R.id.recycle_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        productViewModel = new ViewModelProvider.AndroidViewModelFactory(
                GroceryListActivity.this.getApplication())
                .create(ProductViewModel.class);

        sharedViewModel = new ViewModelProvider(this)
                .get(SharedViewModel.class);

    }
}

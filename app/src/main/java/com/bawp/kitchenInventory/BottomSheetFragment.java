package com.bawp.kitchenInventory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bawp.kitchenInventory.model.Category;
import com.bawp.kitchenInventory.model.Ingredient;
import com.bawp.kitchenInventory.model.Level;
import com.bawp.kitchenInventory.model.Product;
import com.bawp.kitchenInventory.model.ProductViewModel;
import com.bawp.kitchenInventory.model.SharedViewModel;
import com.bawp.kitchenInventory.util.Utils;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
//import com.google.android.material.chip.Chip;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Group;
import androidx.lifecycle.ViewModelProvider;

import java.util.Calendar;
import java.util.Date;

public class BottomSheetFragment extends BottomSheetDialogFragment implements View.OnClickListener {
    private ImageButton calendarButton;
    private ImageButton categoryButton;
    private RadioGroup categoryRadioGroup;
    private RadioButton selectedRadioButton;
    private int selectedButtonId;
    private ImageButton saveButton;
    private CalendarView calendarView;
    private Group calendarGroup;
    private Date expiryDate;
    Calendar calendar = Calendar.getInstance();
    private SharedViewModel sharedViewModel;
    private ProductViewModel productViewModel;
    private boolean isEdit;
    private Category category;

    //Elements for dropdown menu
    String[] ingredients = Ingredient.getNames(Ingredient.class);
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItems;
    private Ingredient selectedOption;

    public BottomSheetFragment() {
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.bottom_sheet, container, false);
        calendarGroup = view.findViewById(R.id.calendar_group);
        calendarView = view.findViewById(R.id.calendar_view);
        calendarButton = view.findViewById(R.id.today_calendar_button);
        autoCompleteTextView = view.findViewById(R.id.auto_complete_txt);
        saveButton = view.findViewById(R.id.save_product_button);
        categoryButton = view.findViewById(R.id.category_todo_button);
        categoryRadioGroup = view.findViewById(R.id.radioGroup_category);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        adapterItems = new ArrayAdapter<String>(requireContext(),R.layout.list_item,ingredients);
        autoCompleteTextView.setAdapter(adapterItems);

        if (sharedViewModel.getSelectedItem().getValue() != null) {
            isEdit = sharedViewModel.getIsEdit();
            Product product = sharedViewModel.getSelectedItem().getValue();
            //enterProduct.setText(product.getProduct());
            autoCompleteTextView.setText(product.getIngredient().toString());
            adapterItems = new ArrayAdapter<String>(requireContext(),R.layout.list_item,ingredients);
            autoCompleteTextView.setAdapter(adapterItems);
            Log.d("MY", "onViewCreated: " + product.getIngredient());
        }
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sharedViewModel = new ViewModelProvider(requireActivity())
                .get(SharedViewModel.class);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedOption = Ingredient.valueOf(parent.getItemAtPosition(position).toString());
            }
        });

        calendarButton.setOnClickListener(view12 -> {
            calendarGroup.setVisibility(calendarGroup.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
            Utils.hideSoftKeyboard(view12);
        });

        calendarView.setOnDateChangeListener((calendarView, year, month, dayOfMonth) -> {
            calendar.clear();
            calendar.set(year, month, dayOfMonth);
            expiryDate = calendar.getTime();
        });

        categoryButton.setOnClickListener(view13 -> {
            Utils.hideSoftKeyboard(view13);
            calendarGroup.setVisibility(View.GONE);
            categoryRadioGroup.setVisibility(categoryRadioGroup.getVisibility() == View.GONE ? View.VISIBLE : View.GONE
            );
            categoryRadioGroup.setOnCheckedChangeListener((radioGroup, checkedId) -> {
                if (categoryRadioGroup.getVisibility() == View.VISIBLE) {
                    selectedButtonId = checkedId;
                    selectedRadioButton = view.findViewById(selectedButtonId);
                    if (selectedRadioButton.getId() == R.id.radioButton_dairy) {
                        category = Category.DAIRYEGG;
                    } else if (selectedRadioButton.getId() == R.id.radioButton_dry) {
                        category = Category.DRYGOODS;
                    } else if (selectedRadioButton.getId() == R.id.radioButton_spices) {
                        category = Category.SPICEHERB;
                    } else {
                        category = Category.DRYGOODS;
                    }
                } else {
                    category = Category.DRYGOODS;
                }
            });
        });

        saveButton.setOnClickListener(view1 -> {
            Ingredient product = selectedOption;
            if(product!=null && expiryDate != null && category != null) {
                Product myProduct = new Product(product, category,
                        expiryDate, Level.FULL, Calendar.getInstance().getTime());
                if (isEdit) {
                    Product updateProduct = sharedViewModel.getSelectedItem().getValue();
                    assert updateProduct != null;
                    updateProduct.setIngredient(product);
                    updateProduct.setAddedDate(Calendar.getInstance().getTime());
                    updateProduct.setCategory(category);
                    updateProduct.setExpiryDate(expiryDate);
                    ProductViewModel.update(updateProduct);
                    sharedViewModel.setIsEdit(false);
                } else {
                    ProductViewModel.insert(myProduct);
                }
                autoCompleteTextView.setText("");
                //enterProduct.setText("");
                if (this.isVisible()) {
                    this.dismiss();
                }
            } else {
                Snackbar.make(saveButton,R.string.empty_field, Snackbar.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}
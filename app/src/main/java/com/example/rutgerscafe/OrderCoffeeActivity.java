package com.example.rutgerscafe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class OrderCoffeeActivity extends AppCompatActivity {
    private  CafeHandler cafehandler = CafeHandler.getCafeInstace();
    private static final int START_COUNT = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_coffee);





        Spinner coffeeType = findViewById(R.id.CoffeeTypeSpinner);
        if (cafehandler != null) {
            ArrayAdapter coffeeTypeList = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item,cafehandler.getTypesOfCoffeeSize());
            coffeeType.setAdapter(coffeeTypeList);
        }

        Spinner coffeeCount = findViewById(R.id.NumberofCoffeeSpinner);
        if (cafehandler != null) {
            ArrayAdapter coffeeTypeList = ArrayAdapter.createFromResource(this, R.array.count, android.R.layout.simple_spinner_item);
            coffeeTypeList.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            coffeeCount.setAdapter(coffeeTypeList);
        }

        TextView coffeePriceText = findViewById(R.id.coffeePriceValue);

        String typeOfsize = coffeeType.getSelectedItem().toString();
        int count = coffeeCount.getSelectedItemPosition() + START_COUNT;
        cafehandler.selectSizeOfCoffee(typeOfsize, new ArrayList<String>(), count);
        coffeePriceText.setText(cafehandler.getCoffeePrice());



        CheckBox CreamCheckBox =findViewById(R.id.creamCheckBox);
        CreamCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(CreamCheckBox.isChecked()){
                    cafehandler.addAddIn(CreamCheckBox.getText().toString());
                }
                else{
                    cafehandler.removeAddIn(CreamCheckBox.getText().toString());
                }
                coffeePriceText.setText(cafehandler.getCoffeePrice());
            }
        });

        CheckBox MilkCheckBox=findViewById(R.id.milkCheckBox);
        MilkCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MilkCheckBox.isChecked()){
                    cafehandler.addAddIn(MilkCheckBox.getText().toString());
                }
                else{
                    cafehandler.removeAddIn(MilkCheckBox.getText().toString());
                }
                coffeePriceText.setText(cafehandler.getCoffeePrice());
            }
        });

        CheckBox SyrupCheckBox =findViewById(R.id.syrupCheckBox);
        SyrupCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(SyrupCheckBox.isChecked()){
                    cafehandler.addAddIn(SyrupCheckBox.getText().toString());
                }
                else{
                    cafehandler.removeAddIn(SyrupCheckBox.getText().toString());
                }
                coffeePriceText.setText(cafehandler.getCoffeePrice());
            }
        });

        CheckBox WhippedCreamCheckbox=findViewById(R.id.whippedCreamCheckBox);
        WhippedCreamCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(WhippedCreamCheckbox.isChecked()){
                    cafehandler.addAddIn(WhippedCreamCheckbox.getText().toString());
                }
                else{
                    cafehandler.removeAddIn(WhippedCreamCheckbox.getText().toString());
                }
                coffeePriceText.setText(cafehandler.getCoffeePrice());
            }
        });

        CheckBox CaramelCheckBox=findViewById(R.id.caramelCheckBox);
        CaramelCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(CaramelCheckBox.isChecked()){
                    cafehandler.addAddIn(CaramelCheckBox.getText().toString());
                }
                else{
                    cafehandler.removeAddIn(CaramelCheckBox.getText().toString());
                }
                coffeePriceText.setText(cafehandler.getCoffeePrice());
            }
        });




        coffeeType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String typeOfsize = coffeeType.getSelectedItem().toString();
                int count = coffeeCount.getSelectedItemPosition() + START_COUNT;

                ArrayList<String> selectedList = new ArrayList<String>();

                if (WhippedCreamCheckbox.isChecked()) selectedList.add(WhippedCreamCheckbox.getText().toString());
                if (CreamCheckBox.isChecked()) selectedList.add(CreamCheckBox.getText().toString());
                if (MilkCheckBox.isChecked()) selectedList.add(MilkCheckBox.getText().toString());
                if (SyrupCheckBox.isChecked()) selectedList.add(SyrupCheckBox.getText().toString());
                if (CaramelCheckBox.isChecked()) selectedList.add(CaramelCheckBox.getText().toString());

                cafehandler.selectSizeOfCoffee(typeOfsize,selectedList , count);
                coffeePriceText.setText(cafehandler.getCoffeePrice());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        coffeeCount.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int count = coffeeCount.getSelectedItemPosition() + START_COUNT;
                cafehandler.setNumberOfCoffee(count);
                coffeePriceText.setText(cafehandler.getCoffeePrice());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        Button AddToYourOrder  = (Button) findViewById(R.id.AddtoCoffeeYourOrder);
        AddToYourOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if (cafehandler.addToCoffeeOrder()) {
                        String typeOfsize = coffeeType.getSelectedItem().toString();
                        int count = coffeeCount.getSelectedItemPosition() + START_COUNT;

                        WhippedCreamCheckbox.setSelected(false);
                        CreamCheckBox.setSelected(false);
                        MilkCheckBox.setSelected(false);
                        SyrupCheckBox.setSelected(false);
                        CaramelCheckBox.setSelected(false);

                        cafehandler.selectSizeOfCoffee(typeOfsize, new ArrayList<String>(), count);

                        Toast.makeText(OrderCoffeeActivity.this,getResources().getString(R.string.order_added),
                                Toast.LENGTH_SHORT).show();
                    }
                }
        });



    }
}
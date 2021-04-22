package com.example.rutgerscafe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

public class OrderDonutActivity extends AppCompatActivity {
    private  CafeHandler cafehandler = null;
    private static final int START_COUNT = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_donut);


        cafehandler = (CafeHandler) getIntent().getSerializableExtra("handler");



        Spinner donutType = findViewById(R.id.DonutTypeSpinner);
        if (cafehandler != null) {
            ArrayAdapter DonutTypeList = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item,cafehandler.getTypesOfDounts());
            donutType.setAdapter(DonutTypeList);
        }

        donutType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String donutName = donutType.getSelectedItem().toString();
                Spinner donutflavorSpinner = findViewById(R.id.FlavorTypeSpinner);
                if (donutflavorSpinner != null) {
                    ArrayAdapter DonutFlavor = new ArrayAdapter<String>(OrderDonutActivity.this, R.layout.support_simple_spinner_dropdown_item, cafehandler.getDountsFlavor(donutName));
                    donutflavorSpinner.setAdapter(DonutFlavor);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        Spinner donutCount = findViewById(R.id.NumberofDonutSpinner);
        if (cafehandler != null) {
            ArrayAdapter DonutTypeList = ArrayAdapter.createFromResource(this, R.array.count, android.R.layout.simple_spinner_item);
            DonutTypeList.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            donutCount.setAdapter(DonutTypeList);
        }

        Button AddToListButton  = (Button) findViewById(R.id.AddToList);
        AddToListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String donutName = donutType.getSelectedItem().toString();
                Spinner donutflavorSpinner = findViewById(R.id.FlavorTypeSpinner);
                String flavor = donutflavorSpinner.getSelectedItem().toString();
                int count = donutCount.getSelectedItemPosition() + START_COUNT;
                cafehandler.addDounteToList(donutName,flavor,count);

                
            }
        });




    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
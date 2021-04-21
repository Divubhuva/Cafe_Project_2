package com.example.rutgerscafe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class OrderDonutActivity extends AppCompatActivity {
    private  CafeHandler cafehandler = null;

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

    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
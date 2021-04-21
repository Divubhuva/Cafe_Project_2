package com.example.rutgerscafe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class OrderCoffeeActivity extends AppCompatActivity {
    private  CafeHandler cafehandler = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_coffee);

        cafehandler = (CafeHandler) getIntent().getSerializableExtra("handler");
    }
}
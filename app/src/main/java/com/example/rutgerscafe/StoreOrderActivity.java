package com.example.rutgerscafe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class StoreOrderActivity extends AppCompatActivity {
    private  CafeHandler cafehandler = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_order);

        cafehandler = (CafeHandler) getIntent().getSerializableExtra("handler");
    }
}
package com.example.rutgerscafe;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.content.Intent;
import android.view.View;



public class MainActivity extends AppCompatActivity {

    /**
     * This defines the CafeHandler.
     */
    private CafeHandler cafehandler  = new CafeHandler();

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       ImageView donutImageButton = findViewById(R.id.donutImage);
       donutImageButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Intent intent = new Intent(MainActivity.this, OrderDonutActivity.class);
               intent.putExtra("handler",getCafeHandler());
               startActivity(intent);
           }
       });

       ImageView coffeeImageButton = findViewById(R.id.coffeeImage);
       coffeeImageButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Intent intent = new Intent(MainActivity.this, OrderCoffeeActivity.class);

               intent.putExtra("handler",getCafeHandler());
               startActivity(intent);
           }
       });

       ImageView cartImageButton = findViewById(R.id.cartImage);
       cartImageButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Intent intent = new Intent(MainActivity.this, OrderDetailsActivity.class);

               intent.putExtra("handler",getCafeHandler());
               startActivity(intent);
           }
       });

       ImageView storeOrderImageButton = findViewById(R.id.storeOrderImage);
       storeOrderImageButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Intent intent = new Intent(MainActivity.this, StoreOrderActivity.class);
               intent.putExtra("handler",getCafeHandler());
               startActivity(intent);
           }
       });

    }

    /**
     * This gets the CafeHandler of the controller.
     * @return the controller's CafeHandler.
     */
     public  CafeHandler getCafeHandler() {
        return cafehandler;
    }

}
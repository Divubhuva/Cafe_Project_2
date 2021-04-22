package com.example.rutgerscafe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class OrderDetailsActivity extends AppCompatActivity {
    private  CafeHandler cafehandler =  CafeHandler.getCafeInstace();
    private static final int START_COUNT = 1;
    private ArrayList<String> placeOrderList;
    private ArrayAdapter plcaeOrderAdepter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);


        TextView SubtotalText  = findViewById(R.id.SubTotalDetail);
        SubtotalText.setText(cafehandler.getCurrentOderSubTotal());

        TextView SalesTaxText   = findViewById(R.id.SalesTaxDetail);
        SalesTaxText.setText(cafehandler.getCurrentOrderSalesTax());

        TextView TotalText   = findViewById(R.id.YourOrderTotalDetail);
        TotalText.setText(cafehandler.getCurrentOderTotal());

        placeOrderList = new ArrayList<String>();
        placeOrderList.addAll(cafehandler.getCurrentOrderStringList());
        plcaeOrderAdepter = new ArrayAdapter(this,  android.R.layout.simple_spinner_item,placeOrderList);
        ListView orderView = findViewById(R.id.YourOrderDetail);
        orderView.setAdapter(plcaeOrderAdepter);



        orderView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Setting message manually and performing action on button click
                AlertDialog.Builder builder = new AlertDialog.Builder(OrderDetailsActivity.this);

                builder.setMessage("Do you want to remove Selected Item?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                if (cafehandler.RemoveItemFromCurrentOrder(placeOrderList.get(position))){
                                    placeOrderList.clear();
                                    placeOrderList.addAll(cafehandler.getCurrentOrderStringList());
                                    SubtotalText.setText(cafehandler.getCurrentOderSubTotal());
                                    SalesTaxText.setText(cafehandler.getCurrentOrderSalesTax());
                                    TotalText.setText(cafehandler.getCurrentOderTotal());
                                    plcaeOrderAdepter.notifyDataSetChanged();
                                    Toast.makeText(getApplicationContext(),"Item is Removed",
                                            Toast.LENGTH_SHORT).show();
                                    dialog.dismiss();
                                }

                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //  Action for 'NO' Button
                                dialog.cancel();
                                Toast.makeText(getApplicationContext(),"you choose no action for alert box",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                //Creating dialog box
                AlertDialog alert = builder.create();
                //Setting the title manually
                alert.setTitle("Alert");
                alert.show();
            }
        });


        Button AddToStoreOrder  = (Button) findViewById(R.id.PlaceStoreOrder);
        AddToStoreOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cafehandler.placeOrderInStore()){
                    Toast.makeText(OrderDetailsActivity.this,"Place The Store Order.",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(OrderDetailsActivity.this,"Order is not Placed. OrderList may be empty",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
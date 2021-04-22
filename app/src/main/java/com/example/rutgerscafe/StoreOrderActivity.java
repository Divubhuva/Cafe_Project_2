package com.example.rutgerscafe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class StoreOrderActivity extends AppCompatActivity {
    private  CafeHandler cafehandler =  CafeHandler.getCafeInstace();
    private ArrayList<String> storeOrderList;
    private ArrayAdapter storeOrderAdepter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_order);


        storeOrderList = new ArrayList<String>();
        storeOrderList.addAll(cafehandler.getStoreOrderList());
        storeOrderAdepter = new ArrayAdapter (this,  android.R.layout.simple_spinner_item,storeOrderList);
        ListView storeOrderListView = findViewById(R.id.StoreOrdersDetail);
        storeOrderListView.setAdapter(storeOrderAdepter);


        storeOrderListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                AlertDialog.Builder builder = new AlertDialog.Builder(StoreOrderActivity.this);

                builder.setMessage(getResources().getString(R.string.donut_alert_question))
                        .setCancelable(false)
                        .setPositiveButton(getResources().getString(R.string.yes_answer), new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                if (cafehandler.RemoveOrder(position)){
                                    storeOrderList.clear();
                                    storeOrderList.addAll(cafehandler.getStoreOrderList());
                                    storeOrderAdepter.notifyDataSetChanged();
                                    Toast.makeText(getApplicationContext(),getResources().getString(R.string.order_removed),
                                            Toast.LENGTH_SHORT).show();
                                    dialog.dismiss();
                                }

                            }
                        })
                        .setNegativeButton(getResources().getString(R.string.no_answer), new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                dialog.cancel();
                                Toast.makeText(getApplicationContext(),getResources().getString(R.string.selected_no),
                                        Toast.LENGTH_SHORT).show();
                            }
                        });

                AlertDialog alert = builder.create();
                alert.setTitle(getResources().getString(R.string.alert_message));
                alert.show();
            }
        });

    }
}
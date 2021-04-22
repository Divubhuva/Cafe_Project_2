package com.example.rutgerscafe;

import androidx.appcompat.app.AlertDialog;

import android.content.DialogInterface;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class OrderDonutActivity extends AppCompatActivity {
    private  CafeHandler cafehandler = CafeHandler.getCafeInstace();
    private static final int START_COUNT = 1;
    private ArrayList<String> placeDonutOrderList;
    private ArrayAdapter plcaeDonutOrderAdepter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_donut);


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


        placeDonutOrderList = new ArrayList<String>();
        placeDonutOrderList.addAll(cafehandler.getDonutOrderList());
        plcaeDonutOrderAdepter = new ArrayAdapter (this,  android.R.layout.simple_spinner_item,placeDonutOrderList);
        ListView orderDonuteView = findViewById(R.id.DonutList);
        orderDonuteView.setAdapter(plcaeDonutOrderAdepter);

        TextView PriceLabel = findViewById(R.id.PriceValue);
        PriceLabel.setText(cafehandler.getTotalPriceForDonut());

        orderDonuteView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Setting message manually and performing action on button click
                AlertDialog.Builder builder = new AlertDialog.Builder(OrderDonutActivity.this);

                builder.setMessage(getResources().getString(R.string.donut_alert_question))
                        .setCancelable(false)
                        .setPositiveButton(getResources().getString(R.string.yes_answer), new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                if (cafehandler.removeDounteFromList(position)){
                                    placeDonutOrderList.clear();
                                    placeDonutOrderList.addAll(cafehandler.getDonutOrderList());
                                    PriceLabel.setText(cafehandler.getTotalPriceForDonut());
                                    plcaeDonutOrderAdepter.notifyDataSetChanged();
                                    Toast.makeText(getApplicationContext(),getResources().getString(R.string.item_removed),
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




        Button AddToListButton  = (Button) findViewById(R.id.AddToList);
        AddToListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String donutName = donutType.getSelectedItem().toString();
                Spinner donutflavorSpinner = findViewById(R.id.FlavorTypeSpinner);
                String flavor = donutflavorSpinner.getSelectedItem().toString();
                int count = donutCount.getSelectedItemPosition() + START_COUNT;
                cafehandler.addDounteToList(donutName,flavor,count);
                placeDonutOrderList.clear();
                placeDonutOrderList.addAll(cafehandler.getDonutOrderList());
                PriceLabel.setText(cafehandler.getTotalPriceForDonut());
                plcaeDonutOrderAdepter.notifyDataSetChanged();
            }
        });


        Button AddToYourOrder  = (Button) findViewById(R.id.AddDonutToYourOrder);
        AddToYourOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cafehandler.getNumberOfOrderDonuts() == 0){
                    Toast.makeText(OrderDonutActivity.this,getResources().getString(R.string.list_is_empty),
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    if (cafehandler.addToDonutsOrder()) {
                        placeDonutOrderList.clear();
                        placeDonutOrderList.addAll(cafehandler.getDonutOrderList());
                        PriceLabel.setText(cafehandler.getTotalPriceForDonut());
                        plcaeDonutOrderAdepter.notifyDataSetChanged();
                        Toast.makeText(OrderDonutActivity.this,getResources().getString(R.string.order_added),
                                Toast.LENGTH_SHORT).show();
                   }
                }
            }
        });
    }




}
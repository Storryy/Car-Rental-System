package com.example.carrentalsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class DriverSelectActivity extends AppCompatActivity {

    private Spinner driverSelectSpinner;
    private String SelectedDriver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_select);
        String strName = getIntent().getStringExtra("name");
        String emailToText = getIntent().getStringExtra("email");
        String strDate = getIntent().getStringExtra("date");
        String strAddress = getIntent().getStringExtra("address");
        String Car = getIntent().getStringExtra("car");


        driverSelectSpinner = findViewById(R.id.driverSelectSpinner);

        String[] driver ={"Choose Your Driver","Vijay Gupta","Manoj Tiwari","Hrishi Hansora","Gaurav Mehra", "Bhupendra Jogi"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>( getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,driver);

        driverSelectSpinner.setAdapter(adapter);

        driverSelectSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                switch(position){
                    case 1:
                        SelectedDriver = "Vijay Gupta";

                        Intent intent1 = new Intent(DriverSelectActivity.this, PaymentActivity.class);
                        intent1.putExtra("name", strName);
                        intent1.putExtra("email", emailToText);
                        intent1.putExtra("date", strDate);
                        intent1.putExtra("address", strAddress);
                        intent1.putExtra("car", Car);
                        intent1.putExtra("Driver", SelectedDriver);


                        startActivity(intent1);
                        break;

                    case 2:
                        SelectedDriver = "Manoj Tiwari";
                        Intent intent2 = new Intent(DriverSelectActivity.this, PaymentActivity.class);
                        intent2.putExtra("name", strName);
                        intent2.putExtra("email", emailToText);
                        intent2.putExtra("date", strDate);
                        intent2.putExtra("address", strAddress);
                        intent2.putExtra("car", Car);
                        intent2.putExtra("Driver", SelectedDriver);

                        startActivity(intent2);
                        break;

                    case 3:
                        SelectedDriver = "Hrishi Hansora";
                        Intent intent3 = new Intent(DriverSelectActivity.this, PaymentActivity.class);
                        intent3.putExtra("name", strName);
                        intent3.putExtra("email", emailToText);
                        intent3.putExtra("date", strDate);
                        intent3.putExtra("address", strAddress);
                        intent3.putExtra("car", Car);
                        intent3.putExtra("Driver", SelectedDriver);

                        startActivity(intent3);

                        break;

                    case 4:
                        SelectedDriver = "Gaurav Mehra";
                        Intent intent4 = new Intent(DriverSelectActivity.this, PaymentActivity.class);
                        intent4.putExtra("name", strName);
                        intent4.putExtra("email", emailToText);
                        intent4.putExtra("date", strDate);
                        intent4.putExtra("address", strAddress);
                        intent4.putExtra("car", Car);
                        intent4.putExtra("Driver", SelectedDriver);

                        startActivity(intent4);
                        break;

                    case 5:
                        SelectedDriver = "Bhupendra Jogi";
                        Intent intent5 = new Intent(DriverSelectActivity.this, PaymentActivity.class);
                        intent5.putExtra("name", strName);
                        intent5.putExtra("email", emailToText);
                        intent5.putExtra("date", strDate);
                        intent5.putExtra("address", strAddress);
                        intent5.putExtra("car", Car);
                        intent5.putExtra("Driver", SelectedDriver);
                        startActivity(intent5);
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
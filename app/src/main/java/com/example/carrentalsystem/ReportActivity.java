package com.example.carrentalsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class ReportActivity extends AppCompatActivity {
    DatabaseReference name, email, location, driver, car, rentdate;

    TextView nameView, emailView, locationView, driverView, carView, rentDateView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        String id = getIntent().getStringExtra("id");

        nameView = findViewById(R.id.reportname);
        emailView = findViewById(R.id.reportemail);
        locationView = findViewById(R.id.reportlocation);
        driverView = findViewById(R.id.reportdriver);
        carView = findViewById(R.id.reportcar);
        rentDateView = findViewById(R.id.reportrentdate);

        name = FirebaseDatabase.getInstance().getReference().child("Customer").child(id).child("Name");
        email = FirebaseDatabase.getInstance().getReference().child("Customer").child(id).child("Email");
        location = FirebaseDatabase.getInstance().getReference().child("Customer").child(id).child("Location");
        driver = FirebaseDatabase.getInstance().getReference().child("Customer").child(id).child("Driver");
        car = FirebaseDatabase.getInstance().getReference().child("Customer").child(id).child("Car Selected");
        rentdate = FirebaseDatabase.getInstance().getReference().child("Customer").child(id).child("Rent Date");
        name.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String name = snapshot.getValue().toString();
                nameView.setText(name);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        email.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String email = snapshot.getValue().toString();
                emailView.setText(email);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        location.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String location = snapshot.getValue().toString();
                locationView.setText(location);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        driver.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String driver = snapshot.getValue().toString();
                driverView.setText(driver);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        car.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String car = snapshot.getValue().toString();
                carView.setText(car);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        rentdate.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String rentdate = snapshot.getValue().toString();
                rentDateView.setText(rentdate);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}
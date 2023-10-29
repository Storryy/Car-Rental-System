package com.example.carrentalsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class ThankActivity extends AppCompatActivity {

    private Button reportButton;
    private Button anotherBookingButton;
    private Button logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thank);

        logoutButton = findViewById(R.id.logoutButton);
        anotherBookingButton = findViewById(R.id.anotherBookingButton);
        reportButton = findViewById(R.id.reportButton);


        reportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = getIntent().getStringExtra("id");
                Intent intent = new Intent(ThankActivity.this, ReportActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
        anotherBookingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ThankActivity.this, MainActivity.class));
            }
        });

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(ThankActivity.this, "User Successfully Logged Out!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ThankActivity.this, StartActivity.class));

            }
        });
    }
}
package com.example.carrentalsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button Logout_Button;
    private Button Rent_Car;
    private DatePickerDialog datePickerDialog;
    private Button dateButton;
    private EditText Address;
    private EditText fullName;
    private EditText email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Logout_Button = findViewById(R.id.Logout_Button);
        Rent_Car = findViewById(R.id.Rent_Car);
        initDatePicker();
        dateButton = findViewById(R.id.datePickerButton);
        dateButton.setText(getTodaysDate());
        Address = findViewById(R.id.Address);
        fullName = findViewById(R.id.fullName);
        email = findViewById(R.id.email);




        Logout_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(MainActivity.this, "User Successfully Logged Out!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, StartActivity.class));

            }
        });

        Rent_Car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean nameValid = nameIsValid();
                boolean emailValid = emailIsValid();
                boolean addressValid = addressIsValid();

                if(nameValid && emailValid && addressValid){
                    String strDate = dateButton.getText().toString().trim();
                    String strName = fullName.getText().toString().trim();
                    String emailToText = email.getText().toString();
                    String strAddress = Address.getText().toString().trim();
                    Intent intent = new Intent(MainActivity.this, RentCarActivity.class);
                    intent.putExtra("name", strName);
                    intent.putExtra("email", emailToText);
                    intent.putExtra("date", strDate);
                    intent.putExtra("address", strAddress);

                    startActivity(intent);
                }
            }
        });
    }

    private Boolean emailIsValid() {
        String emailToText = email.getText().toString();
        if (!emailToText.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailToText).matches()) {
            return true;
        } else {
            Toast.makeText(this, "Enter valid Email address!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    public Boolean nameIsValid() {
        String strName = fullName.getText().toString().trim();


        if(strName.isEmpty()) {
            Toast.makeText(MainActivity.this, "Name Cannot be empty", Toast.LENGTH_SHORT).show();
            return false;
        }
        else{
            return true;
        }

    }

    private Boolean addressIsValid() {
        String strAddress = Address.getText().toString().trim();


        if(strAddress.isEmpty()) {
            Toast.makeText(MainActivity.this, "Address Cannot be empty", Toast.LENGTH_SHORT).show();
            return false;
        }
        else{
            return true;
        }

    }

    private String getTodaysDate()
    {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day, month, year);
    }

    private void initDatePicker()
    {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day)
            {
                month = month + 1;
                String date = makeDateString(day, month, year);
                dateButton.setText(date);
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);


        datePickerDialog = new DatePickerDialog(this, dateSetListener, year, month, day);
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());

    }

    private String makeDateString(int day, int month, int year)
    {
        return getMonthFormat(month) + " " + day + " " + year;
    }

    private String getMonthFormat(int month)
    {
        if(month == 1)
            return "JAN";
        if(month == 2)
            return "FEB";
        if(month == 3)
            return "MAR";
        if(month == 4)
            return "APR";
        if(month == 5)
            return "MAY";
        if(month == 6)
            return "JUN";
        if(month == 7)
            return "JUL";
        if(month == 8)
            return "AUG";
        if(month == 9)
            return "SEP";
        if(month == 10)
            return "OCT";
        if(month == 11)
            return "NOV";
        if(month == 12)
            return "DEC";

        //default should never happen
        return "JAN";
    }

    public static String randomNumber(){
        Random rand = new Random();
        int selected = rand.nextInt(1000000000);
        String randomNumber = String.valueOf(selected);
        return randomNumber;
    }

    public void openDatePicker(View view)
    {
        datePickerDialog.show();
    }


}
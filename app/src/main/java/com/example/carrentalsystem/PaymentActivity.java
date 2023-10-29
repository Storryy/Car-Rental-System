package com.example.carrentalsystem;

import static com.example.carrentalsystem.MainActivity.randomNumber;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

import java.util.HashMap;

public class PaymentActivity extends AppCompatActivity implements PaymentResultListener {

    private Button paymentbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);


        paymentbutton = findViewById(R.id.paymentbutton);

        Checkout.preload(getApplicationContext());


        paymentbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startPayment();
            }
        });
    }

    private void startPayment(){

        /**
         * Instantiate Checkout
         */
        Checkout checkout = new Checkout();
        checkout.setKeyID("rzp_test_xwUzdSjJvEp8oz");
        /**
         * Set your logo here
         */
        //checkout.setImage(R.drawable.logo);

        /**
         * Reference to current activity
         */
        final Activity activity = this;

        /**
         * Pass your payment options to the Razorpay Checkout as a JSONObject
         */
        try {
            JSONObject options = new JSONObject();

            options.put("name", "PMJ Car Rental Service");
            options.put("description", "Reference No. #123456");
            options.put("image", R.drawable.logo);
            options.put("theme.color", "#3399cc");
            options.put("currency", "INR");
            options.put("amount", "30000");//pass amount in currency subunits
            options.put("prefill.email", "gaurav.kumar@example.com");
            options.put("prefill.contact","9988776655");
            JSONObject retryObj = new JSONObject();
            retryObj.put("enabled", true);
            retryObj.put("max_count", 4);
            options.put("retry", retryObj);

            checkout.open(activity, options);

        } catch(Exception e) {
            Log.e("TAG", "Error in starting Razorpay Checkout", e);
        }
    }

    @Override
    public void onPaymentSuccess (String s) {
        String strName = getIntent().getStringExtra("name");
        String emailToText = getIntent().getStringExtra("email");
        String strDate = getIntent().getStringExtra("date");
        String strAddress = getIntent().getStringExtra("address");
        String Car = getIntent().getStringExtra("car");
        String SelectedDriver = getIntent().getStringExtra("Driver");

        HashMap<String, Object> map = new HashMap<>();
        map.put("Name", strName);
        map.put("Email", emailToText);
        map.put("Rent Date", strDate);
        map.put("Location", strAddress);
        map.put("Car Selected", Car);
        map.put("Driver", SelectedDriver);

        String id = randomNumber();
        FirebaseDatabase.getInstance().getReference().child("Customer").child(id).updateChildren(map);

        Log.d("ONSUCCESS", "onPaymentSuccess: " + s);
        Toast.makeText(PaymentActivity.this, "Payment Is A Success!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(PaymentActivity.this, ThankActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);

    }
    @Override
    public void onPaymentError(int i, String s) {
        Log.d("ONERROR", "onPaymentError: "+s);
        Toast.makeText(PaymentActivity.this, "Payment Is A Failure!", Toast.LENGTH_SHORT).show();

    }

}

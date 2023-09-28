package com.example.carrentalsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText Login_Email;
    private EditText Login_Password;
    private Button Login;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Login_Email = findViewById(R.id.Login_Email);
        Login_Password = findViewById(R.id.Login_Password);
        Login = findViewById(R.id.Login);
        auth = FirebaseAuth.getInstance();

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_Login_Email = Login_Email.getText().toString();
                String txt_Login_Password = Login_Password.getText().toString();
                loginUser(txt_Login_Email, txt_Login_Password);

            }
        });

    }
    private void loginUser(String Login_Email, String Login_Password){
        auth.signInWithEmailAndPassword(Login_Email, Login_Password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(LoginActivity.this, "Login Is Successful!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        });
    }

}
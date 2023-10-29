package com.example.carrentalsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.ktx.Firebase;

import org.w3c.dom.Text;

public class RegisterActivity extends AppCompatActivity {

    private EditText Register_Email;
    private EditText Register_Password;
    private Button Register;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Register_Email = findViewById(R.id.Register_Email);
        Register_Password = findViewById(R.id.Register_Password);
        Register = findViewById(R.id.Register);
        auth = FirebaseAuth.getInstance();

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_Register_Email = Register_Email.getText().toString();
                String txt_Register_Password = Register_Password.getText().toString();

                if (TextUtils.isEmpty(txt_Register_Email) || TextUtils.isEmpty(txt_Register_Password)){
                    Toast.makeText(RegisterActivity.this, "Email cannot be Empty!", Toast.LENGTH_SHORT).show();
                }
                else if (txt_Register_Password.length() <6) {
                    Toast.makeText(RegisterActivity.this, "Password length cannot be lesser than 6", Toast.LENGTH_SHORT).show();
                }
                else {
                    registerUser(txt_Register_Email, txt_Register_Password);
                }
            }
        });

    }

    private void registerUser(String Register_Email, String Register_Password) {
        auth.createUserWithEmailAndPassword(Register_Email, Register_Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(RegisterActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                    finish();
                }
                else {
                    Toast.makeText(RegisterActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
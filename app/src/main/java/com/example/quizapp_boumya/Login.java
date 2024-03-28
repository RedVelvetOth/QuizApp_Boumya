package com.example.quizapp_boumya;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    // Step 1 : declaration
    EditText etLogin, etPassword;
    Button bLogin;
    TextView tvRegister;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Step 2 : Get the ids from layout

        etLogin = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etpassword);
        bLogin = findViewById(R.id.bLogin);
        tvRegister = findViewById(R.id.tvRegister);
        mAuth = FirebaseAuth.getInstance();

        // Step 3 : Associate the IDs

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Step 4 : Implement
//                if (etLogin.getText().toString().equals("David") && etPassword.getText().toString().equals("David")){
//                    startActivity(new Intent(Login.this, Quiz1.class));
//                }
//                else {
//                    Toast.makeText(getApplicationContext(), "Login or Password Incorrect", Toast.LENGTH_SHORT).show();
//                }
                 signIn(etLogin.getText().toString(), etPassword.getText().toString());
            }
        });
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Step 4 : Implement
                startActivity(new Intent(Login.this, Register.class));
            }
        });

    }

    private void signIn(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                    startActivity(new Intent(Login.this, Quiz1.class));
                }
                else {
                    Toast.makeText(getApplicationContext(), "Login or Password Incorrect", Toast.LENGTH_SHORT).show();
                }
                    }
                }
        );
    }
}
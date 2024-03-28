package com.example.quizapp_boumya;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    EditText etMail, etName, etPassw, etConPassw;
    Button btRegister;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etMail = findViewById(R.id.etEmail);
        etName = findViewById(R.id.etName);
        etPassw = findViewById(R.id.etPassword);
        etConPassw = findViewById(R.id.etconfirm_password);
        btRegister = findViewById(R.id.btRegister);
        mAuth = FirebaseAuth.getInstance();

        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = etMail.getText().toString();
                String password = etPassw.getText().toString();
                String cPassword = etConPassw.getText().toString();
                if (TextUtils.isEmpty(mail)){
                    Toast.makeText(getApplicationContext(), "Please Fill in the Required Fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(getApplicationContext(), "Please Fill in the Required Fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(cPassword)){
                    Toast.makeText(getApplicationContext(), "Please Fill in the Required Fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(getApplicationContext(), "Please Confirm Your Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.length() < 6){
                    Toast.makeText(getApplicationContext(), "Password Must Be 6 characters or longer", Toast.LENGTH_SHORT).show();
                    return;
                }
                signUp(mail, password);

            }
        });

    }

    private void signUp(String mail, String password) {
        mAuth.createUserWithEmailAndPassword(mail, password).addOnCompleteListener(
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Registered!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Register.this, Login.class));
                            finish();
                        } else {
                            Toast.makeText(getApplicationContext(),"Authentication failed.", Toast.LENGTH_SHORT).show();                        }
                    }
                }
        );
    }
}
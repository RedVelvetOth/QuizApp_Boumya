package com.example.quizapp_boumya;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class Result extends AppCompatActivity {

    Button bLogout, bTry;
    ProgressBar progressBar;
    TextView tvScore;
    int score;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);

        tvScore = findViewById(R.id.tvScore);
        progressBar = findViewById(R.id.progressBar);
        bLogout = findViewById(R.id.btLogout);
        bTry = findViewById(R.id.btTryAgain);
        score = getIntent().getIntExtra("score",0);
        progressBar.setProgress(100 * score / 5);
        tvScore.setText(100*score/5 + " %");

        bLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Thank you for participating", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        bTry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Result.this, Quiz1.class));
            }
        });

    }
}
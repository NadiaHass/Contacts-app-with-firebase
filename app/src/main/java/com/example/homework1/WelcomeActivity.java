package com.example.homework1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {
    Button joinNowButton;
    TextView loginTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        joinNowButton = findViewById(R.id.button);
        loginTextView = findViewById(R.id.tv_login);

        joinNowButton.setOnClickListener(v->{
            startActivity(new Intent(this , SignUpActivity.class));
        });

        loginTextView.setOnClickListener(v->{
            startActivity(new Intent(this , LoginActivity.class));

        });
    }
}
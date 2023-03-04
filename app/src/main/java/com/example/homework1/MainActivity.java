package com.example.homework1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();

        TextView textView = findViewById(R.id.tv_data);
        Button goToContactsButton = findViewById(R.id.btn_contacts);
        Button signOutButton = findViewById(R.id.btn_sign_out);

        textView.setText("Hello ");


        goToContactsButton.setOnClickListener(v -> {
            startActivity(new Intent(this , ContactsActivity.class));
        });

        signOutButton.setOnClickListener(v->{
            firebaseAuth.signOut();
            startActivity(new Intent(this , WelcomeActivity.class));
            finish();
        });

    }
}
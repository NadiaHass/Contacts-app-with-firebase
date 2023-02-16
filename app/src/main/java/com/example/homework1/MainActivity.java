package com.example.homework1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.tv_data);

        String fullName = getIntent().getStringExtra("name");
        String email = getIntent().getStringExtra("email");
        String password = getIntent().getStringExtra("password");

        if(fullName == null || email == null|| password == null){
            textView.setText("Hello ");
        }else{
            textView.setText("Hello " + fullName + " !\n" +
                    "Email = " + email + "\n" + "Password = " + password + "\n");
        }

        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name", fullName);
        editor.putString("email" , email);
        editor.putString("password" , password);
        editor.apply();

    }
}
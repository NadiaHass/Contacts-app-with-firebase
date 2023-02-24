package com.example.homework1;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    Button loginButton ;
    EditText editTextEmail, editTextPassword;
    LinearLayout facebook, google;
    TextView textViewLogin ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = findViewById(R.id.btn_sign_in);
        editTextEmail = findViewById(R.id.et_address);
        editTextPassword = findViewById(R.id.et_password);
        facebook = findViewById(R.id.layout_facebook);
        google = findViewById(R.id.layout_google);
        textViewLogin = findViewById(R.id.tv_sign_up);

        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        String savedEmail = sharedPreferences.getString("email" , "empty");
        String savedPassword = sharedPreferences.getString("password" , "empty");

        loginButton.setOnClickListener(v->{
            String email = editTextEmail.getText().toString();
            String password = editTextPassword.getText().toString();

            if (email.equals("") || password.equals("")){
                AlertDialog alertDialog = new AlertDialog.Builder(this).create();
                alertDialog.setTitle("Alert");
                alertDialog.setMessage("Complete all your data !");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        (dialog, which) -> dialog.dismiss());
                alertDialog.show();
            } else if(email.equals(savedEmail) && password.equals(savedPassword)){
                startActivity(new Intent(this , MainActivity.class));
                finish();
            }else{
                Toast.makeText(this , "Wrong email or password !" , Toast.LENGTH_LONG).show();
            }
        });

        facebook.setOnClickListener(v->{
            Toast.makeText(this , "Login win Facebook" , Toast.LENGTH_LONG).show();
        });

        google.setOnClickListener(v->{
            Toast.makeText(this , "Login win Google" , Toast.LENGTH_LONG).show();
        });

        textViewLogin.setOnClickListener(v -> {
            startActivity(new Intent(this , SignUpActivity.class));

        });
    }
}
package com.example.homework1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    Button signUpButton ;
    CheckBox checkBox;
    EditText editTextName , editTextEmail, editTextPassword;
    LinearLayout facebook, google;
    TextView textViewLogin ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signUpButton = findViewById(R.id.btn_sign_up);
        checkBox = findViewById(R.id.checkBox);
        editTextName = findViewById(R.id.et_name);
        editTextEmail = findViewById(R.id.et_address);
        editTextPassword = findViewById(R.id.et_password);
        facebook = findViewById(R.id.layout_facebook);
        google = findViewById(R.id.layout_google);
        textViewLogin = findViewById(R.id.tv_login);

        textViewLogin.setOnClickListener(v->{
            startActivity(new Intent(this , LoginActivity.class));
        });

        signUpButton.setOnClickListener(v->{
            String fullName = editTextName.getText().toString();
            String email = editTextEmail.getText().toString();
            String password = editTextPassword.getText().toString();
            boolean isChecked = checkBox.isChecked();

            if (!isChecked || fullName.equals("") || email.equals("") || password.equals("")) {

                AlertDialog alertDialog = new AlertDialog.Builder(this).create();
                alertDialog.setTitle("Alert");
                alertDialog.setMessage("Complete all your data !");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        (dialog, which) -> dialog.dismiss());
                alertDialog.show();

            }else{
                Intent intent = new Intent(this , MainActivity.class);
                intent.putExtra("name" , fullName);
                intent.putExtra("email" , email);
                intent.putExtra("password" , password);
                startActivity(intent);
                finish();
            }
        });

        facebook.setOnClickListener(v->{
            Toast.makeText(this , "Login win Facebook" , Toast.LENGTH_LONG).show();
        });

        google.setOnClickListener(v->{
            Toast.makeText(this , "Login win Google" , Toast.LENGTH_LONG).show();
        });
    }
}
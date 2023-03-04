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

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {
    Button loginButton ;
    EditText editTextEmail, editTextPassword;
    LinearLayout facebook, google;
    TextView textViewLogin ;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();

        loginButton = findViewById(R.id.btn_sign_in);
        editTextEmail = findViewById(R.id.et_address);
        editTextPassword = findViewById(R.id.et_password);
        facebook = findViewById(R.id.layout_facebook);
        google = findViewById(R.id.layout_google);
        textViewLogin = findViewById(R.id.tv_sign_up);

        loginButton.setOnClickListener(v->{
            String email = editTextEmail.getText().toString();
            String password = editTextPassword.getText().toString();

            if (email.equals("") || password.equals("")){
                showAlertDialog("Alert" ,"Complete all your data !" );
            } else {
                signInUser(email , password);
            }
        });

        facebook.setOnClickListener(v->{
            showToast("Login win Facebook");
        });

        google.setOnClickListener(v->{
            showToast("Login win Google");
        });

        textViewLogin.setOnClickListener(v -> {
            startActivity(new Intent(this , SignUpActivity.class));

        });
    }

    private void signInUser(String email, String password) {
        firebaseAuth.signInWithEmailAndPassword(email , password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    openMainActivity();
                }else{
                    showToast(Objects.requireNonNull(task.getException()).toString());
                }
            }
        });
    }

    private void openMainActivity() {
        startActivity(new Intent(this , MainActivity.class));
        finish();
    }

    private void showToast(String message) {
        Toast.makeText(this , message , Toast.LENGTH_LONG).show();
    }

    private void showAlertDialog(String title , String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                (dialog, which) -> dialog.dismiss());
        alertDialog.show();

    }
}
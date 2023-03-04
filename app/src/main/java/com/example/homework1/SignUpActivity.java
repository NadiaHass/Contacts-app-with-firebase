package com.example.homework1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {
    Button signUpButton ;
    CheckBox checkBox;
    EditText editTextName , editTextEmail, editTextPassword;
    LinearLayout facebook, google;
    TextView textViewLogin ;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        firebaseAuth = FirebaseAuth.getInstance();

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
                showAlertDialog("Alert" ,"Complete all your data !" );
            }else{
                signUpNewUser(email , password);
            }
        });

        facebook.setOnClickListener(v->{
            showToast("Login win Facebook");
        });

        google.setOnClickListener(v->{
            showToast("Login win Google");
        });
    }



    private void showToast(String message) {
        Toast.makeText(this , message , Toast.LENGTH_LONG).show();
    }


    private void signUpNewUser(String email, String password) {
        firebaseAuth.createUserWithEmailAndPassword(email , password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    startMainActivity();
                }else{
                    showToast("Can't sign up");
                }
            }
        });
    }

    private void startMainActivity() {
        Intent intent = new Intent(this , LoginActivity.class);
        startActivity(intent);
        finish();
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
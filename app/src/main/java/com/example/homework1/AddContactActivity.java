package com.example.homework1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.homework1.models.Contact;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

public class AddContactActivity extends AppCompatActivity {
    EditText editTextName , editTextNumber;
    Button buttonAddContacts;
    RadioGroup radioGroup;
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        db = FirebaseFirestore.getInstance();

        editTextName = findViewById(R.id.editTextTextPersonName);
        editTextNumber = findViewById(R.id.editTextTextPersonNumber);
        buttonAddContacts = findViewById(R.id.btn_add);
        radioGroup = findViewById(R.id.radioGroup);

        buttonAddContacts.setOnClickListener(v->{
            String name = editTextName.getText().toString();
            String number = editTextNumber.getText().toString();
            String image = getCheckedRadioButton();

            if (name.equals("") || image.equals("")|| number.equals("")){
                showAlertDialog("Alert" , "Complete all contact's data");
            }else{
                addContactToFirestoreDb(new Contact(name , image , number));
            }
        });
    }

    private void addContactToFirestoreDb(Contact contact) {
        db.collection("contacts").document().set(contact).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                showToast("Contact is added successfully");
                openContactsActivity();
            }
        });
    }

    private void openContactsActivity() {
        startActivity(new Intent(this , ContactsActivity.class));
    }

    private String getCheckedRadioButton() {
        int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();

            if (checkedRadioButtonId == R.id.radioButtonWoman) {
                return "female";
            }else if(checkedRadioButtonId == R.id.radioButtonMan){
                return "male";
            }else{
                return "";
            }

    }


    private void showAlertDialog(String title , String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                (dialog, which) -> dialog.dismiss());
        alertDialog.show();

    }


    private void showToast(String message) {
        Toast.makeText(this , message , Toast.LENGTH_LONG).show();
    }
}
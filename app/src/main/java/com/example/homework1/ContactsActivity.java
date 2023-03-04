package com.example.homework1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.homework1.adapters.ContactsAdapter;
import com.example.homework1.models.Contact;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class ContactsActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        FloatingActionButton actionButton = findViewById(R.id.floatingActionButton);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        actionButton.setOnClickListener(v -> {
            startActivity(new Intent(this , AddContactActivity.class));
        });

        recyclerView = findViewById(R.id.rv_contacts);

        db.collection("contacts")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        ArrayList<Contact> contacts = new ArrayList<>();

                        for(QueryDocumentSnapshot document : task.getResult()){
                            Contact contact = document.toObject(Contact.class);
                            contacts.add(contact);
                            setupRecyclerView(contacts);
                        }
                    }
                });


    }

    private void setupRecyclerView(ArrayList<Contact> contacts) {
        ContactsAdapter contactsAdapter = new ContactsAdapter(contacts , this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this , RecyclerView.VERTICAL , false));
        recyclerView.setAdapter(contactsAdapter);
        progressBar.setVisibility(View.GONE);
    }
}
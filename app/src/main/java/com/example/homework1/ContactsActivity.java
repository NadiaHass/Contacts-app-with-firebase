package com.example.homework1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.homework1.adapters.ContactsAdapter;

import java.util.ArrayList;
import java.util.List;

public class ContactsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        RecyclerView recyclerView = findViewById(R.id.rv_contacts);

        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Nadia" , "female"));
        contacts.add(new Contact("Amira" , "female"));
        contacts.add(new Contact("Dorsaf" , "female"));
        contacts.add(new Contact("Sihem" , "female"));
        contacts.add(new Contact("Chaima" , "female"));
        contacts.add(new Contact("Sara" , "female"));
        contacts.add(new Contact("Hoda" , "female"));
        contacts.add(new Contact("Hadjer" , "female"));
        contacts.add(new Contact("Akram" , "male"));
        contacts.add(new Contact("Ilyes" , "male"));
        contacts.add(new Contact("Djamel" , "male"));

        ContactsAdapter contactsAdapter = new ContactsAdapter(contacts , this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this , RecyclerView.VERTICAL , false));
        recyclerView.setAdapter(contactsAdapter);

    }
}
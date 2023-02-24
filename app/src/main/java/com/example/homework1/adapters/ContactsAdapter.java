package com.example.homework1.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homework1.Contact;
import com.example.homework1.R;

import java.util.ArrayList;
import java.util.Objects;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactViewHolder> {
    private ArrayList<Contact> contacts;
    private Context context;

    public ContactsAdapter(ArrayList<Contact> contacts, Context context) {
        this.contacts = contacts;
        this.context = context;
    }


    @NonNull
    @Override
    public ContactsAdapter.ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ContactsAdapter.ContactViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_rv_item , parent , false));
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsAdapter.ContactViewHolder holder, int position) {
        holder.nameTextView.setText(contacts.get(position).getName());

        if (Objects.equals(contacts.get(position).getImage(), "male")){
            holder.contactImageView.setImageDrawable(context.getDrawable(R.drawable.avatar));

        }else{
            holder.contactImageView.setImageDrawable(context.getDrawable(R.drawable.woman));

        }

        holder.itemView.setOnClickListener(v -> {
            Toast.makeText(context , "You clicked this item" ,Toast.LENGTH_LONG ).show();
        });
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder{
        public TextView nameTextView;
        public ImageView contactImageView;
        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTextView = itemView.findViewById(R.id.tv_contact);
            contactImageView = itemView.findViewById(R.id.iv_contact);
        }
    }
}

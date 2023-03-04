package com.example.homework1.models;

public class Contact {
    String name;
    String number;
    String image;

    public Contact() {
    }

    public Contact(String name, String image , String number) {
        this.name = name;
        this.image = image;
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

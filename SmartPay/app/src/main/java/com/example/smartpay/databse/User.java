package com.example.smartpay.databse;

public class User {
    public String fullname, email, phoneno, address;

    public User() {

    }

    public User(String fullname, String email, String phoneno, String address) {
        this.fullname = fullname;
        this.email = email;

        this.phoneno = phoneno;
        this.address = address;
    }
}

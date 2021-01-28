package com.example.smartpay.databse;

public class User {
    public String fullname, email, password, phoneno, address;

    public User() {

    }

    public User(String fullname, String email, String password, String phoneno, String address) {
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.phoneno = phoneno;
        this.address = address;
    }
}

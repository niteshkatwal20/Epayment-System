package com.example.smartpay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartpay.databse.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private TextView SignIn, CreateAccount;

    private EditText Userfullname, Useremail, Userpassword, Userphoneno, Useraddress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();

        SignIn = findViewById(R.id.btnSignIn);
        CreateAccount = findViewById(R.id.btnSignUp);

        Userfullname = findViewById(R.id.txtUserName);
        Useremail = findViewById(R.id.txtUserEmail);
        Userpassword = findViewById(R.id.txtUserPassword);
        Userphoneno = findViewById(R.id.txtUserphoneno);
        Useraddress = findViewById(R.id.txtUseraddress);

        CreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegisterUser();
            }

        });

        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp.this, SignIn.class);
                startActivity(intent);
            }
        });
    }

    private void RegisterUser() {
        String fullname = Userfullname.getText().toString().trim();
        String email = Useremail.getText().toString().trim();
        String password = Userpassword.getText().toString().trim();
        String phoneno = Userphoneno.getText().toString().trim();
        String address = Useraddress.getText().toString().trim();

        if (fullname.isEmpty()) {
            Userfullname.setError("Full name is required !");
            Userfullname.requestFocus();
            return;
        }
        if (email.isEmpty()) {
            Useremail.setError("Email is required !");
            Useremail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Useremail.setError("Please provide the valid email!");
            Useremail.requestFocus();
            return;

        }
        if (password.isEmpty()) {
            Userpassword.setError("Password is required !");
            Userpassword.requestFocus();
            return;
        }
        if (password.length() < 6) {
            Userpassword.setError("Password should be more than 6 characters !");
            Userpassword.requestFocus();
            return;
        }
        if (phoneno.isEmpty()) {
            Userphoneno.setError("Phone Number is required !");
            Userphoneno.requestFocus();
            return;
        }
        if (phoneno.length() < 10) {
            Userphoneno.setError("Mobile Number should be 10 digits");
            Userphoneno.requestFocus();
            return;
        }
        if (address.isEmpty()) {
            Useraddress.setError("Address is required !");
            Useraddress.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            User user = new User(fullname, email, password, phoneno, address);

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(SignUp.this, "User has been registered sucessfully", Toast.LENGTH_LONG)
                                                .show();
                                        Intent intent = new Intent(SignUp.this, SignIn.class);
                                        startActivity(intent);
                                    } else {
                                        Toast.makeText(SignUp.this, "Failed to register", Toast.LENGTH_SHORT)
                                                .show();
                                    }
                                }
                            });

                        } else {
                            Toast.makeText(SignUp.this, "Failed to register", Toast.LENGTH_SHORT)
                                    .show();
                        }
                    }
                });

    }
}
package com.example.smartpay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignIn extends AppCompatActivity {

    private TextView UserSignUp, forgetPassword, UserSignIn;
    private EditText Email, Password;

    private FirebaseAuth mAuth;
    private ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        UserSignUp = findViewById(R.id.SigUp);
        forgetPassword = findViewById(R.id.forgotpass);
        UserSignIn = findViewById(R.id.UserSignIn);
        Email = findViewById(R.id.edtemail);
        Password = findViewById(R.id.edtPassword);

        mAuth = FirebaseAuth.getInstance();
        progress = findViewById(R.id.ProgressbarSignIn);

        UserSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserLogin();

            }
        });
        forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignIn.this,ForgetPassword.class));
            }
        });

        UserSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignIn.this, SignUp.class);
                startActivity(intent);
            }
        });
    }

    private void UserLogin() {
        String email = Email.getText().toString().trim();
        String password = Password.getText().toString().trim();

        if (email.isEmpty()) {
            Email.setError("Email is required!");
            Email.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Email.setError("Please enter valid email");
            Email.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            Password.setError("Password is required");
            Password.requestFocus();
            return;
        }
        if (password.length() < 6) {
            Password.setError("Password must be more than 6 characters");
            Password.requestFocus();
            return;
        }

        progress.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    if (user.isEmailVerified()) {
                        Intent intent = new Intent(SignIn.this, MainActivity.class);
                        startActivity(intent);
                    } else {
                        user.sendEmailVerification();
                        Toast.makeText(SignIn.this, "Check your email to verify your account", Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(SignIn.this, "Email and Password do not match", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
package com.example.smartpay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPassword extends AppCompatActivity {
    private EditText EmailAddress;
    private TextView BtnForgetPassword;
    private ProgressBar ForgetProgressBar;

    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        EmailAddress = findViewById(R.id.Email);
        BtnForgetPassword = findViewById(R.id.ResetPassword);
        ForgetProgressBar = findViewById(R.id.ProgressbarForgetPassword);

        auth = FirebaseAuth.getInstance();

        BtnForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetPassword();
            }
        });

    }

    private void resetPassword() {
        String email = EmailAddress.getText().toString().trim();

        if (email.isEmpty()) {
            EmailAddress.setError("Email is requires");
            EmailAddress.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            EmailAddress.setError("Please enter valid email");
            EmailAddress.requestFocus();
            return;
        }
        ForgetProgressBar.setVisibility(View.VISIBLE);
        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if (task.isSuccessful()) {
                    Toast.makeText(ForgetPassword.this, "Check your email to reset your password", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ForgetPassword.this, "Try again something wrong happened", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
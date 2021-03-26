package com.example.smartpay.user;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartpay.MainActivity;
import com.example.smartpay.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class UserVerification extends AppCompatActivity {

    private EditText inputCode1, inputCode2, inputCode3, inputCode4, inputCode5, inputCode6;

    private TextView ResendCode;

    private LinearLayout CodeSubmitBtn;
    private TextView textMobile;
    private ProgressBar progressBar;

    private String verificationId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_verifaction);

        textMobile = findViewById(R.id.textMobile);
        textMobile.setText(String.format(
                "+977-%s", getIntent().getStringExtra("mobile")
        ));

        inputCode1 = findViewById(R.id.OTPCode1);
        inputCode2 = findViewById(R.id.OTPCode2);
        inputCode3 = findViewById(R.id.OTPCode3);
        inputCode4 = findViewById(R.id.OTPCode4);
        inputCode5 = findViewById(R.id.OTPCode5);
        inputCode6 = findViewById(R.id.OTPCode6);

        progressBar = findViewById(R.id.VerifyProgessBar);
        ResendCode = findViewById(R.id.textResendOTP);

        CodeSubmitBtn = findViewById(R.id.SubmitOTPCodeBtn);

        setupOTP();
        verificationId = getIntent().getStringExtra("verificationId");

        CodeSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inputCode1.getText().toString().trim().isEmpty()
                        || inputCode2.getText().toString().trim().isEmpty()
                        || inputCode3.getText().toString().trim().isEmpty()
                        || inputCode4.getText().toString().trim().isEmpty()
                        || inputCode5.getText().toString().trim().isEmpty()
                        || inputCode6.getText().toString().trim().isEmpty()) {

                    Toast.makeText(UserVerification.this, "Please Enter the Valid Code", Toast.LENGTH_SHORT).show();
                    return;
                }

                String code =
                        inputCode1.getText().toString() +
                                inputCode2.getText().toString() +
                                inputCode3.getText().toString() +
                                inputCode4.getText().toString() +
                                inputCode5.getText().toString() +
                                inputCode6.getText().toString();

                if (verificationId != null) {
                    progressBar.setVisibility(View.VISIBLE);
                    CodeSubmitBtn.setVisibility(View.INVISIBLE);
                    PhoneAuthCredential phoneAuthCredential = PhoneAuthProvider.getCredential(
                            verificationId,
                            code

                    );
                    FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    progressBar.setVisibility(View.GONE);
                                    CodeSubmitBtn.setVisibility(View.VISIBLE);
                                    if (task.isSuccessful()) {
                                        Toast.makeText(UserVerification.this, "Your Transaction is Successful", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                        startActivity(intent);


                                    } else {
                                        Toast.makeText(UserVerification.this, "The Verification You Entered is Invalid", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });
        ResendCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        "+977" + getIntent().getStringExtra("mobile"),
                        60,
                        TimeUnit.SECONDS,
                        UserVerification.this,
                        new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                Toast.makeText(UserVerification.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onCodeSent(@NonNull String newVerificationId, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                          verificationId=newVerificationId;
                                Toast.makeText(UserVerification.this, "OTP Sent", Toast.LENGTH_SHORT).show();
                            }
                        }
                );
            }
        });

    }

    private void setupOTP() {
        inputCode1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int count, int after) {
                if (!s.toString().trim().isEmpty()) {
                    inputCode2.requestFocus();

                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        inputCode2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int count, int after) {
                if (!s.toString().trim().isEmpty()) {
                    inputCode3.requestFocus();

                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        inputCode3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int count, int after) {
                if (!s.toString().trim().isEmpty()) {
                    inputCode4.requestFocus();

                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        inputCode4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int count, int after) {
                if (!s.toString().trim().isEmpty()) {
                    inputCode5.requestFocus();

                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        inputCode5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int count, int after) {
                if (!s.toString().trim().isEmpty()) {
                    inputCode6.requestFocus();

                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}
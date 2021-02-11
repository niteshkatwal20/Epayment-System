package com.example.smartpay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.smartpay.databse.SendMoneyData;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class SendMoney extends AppCompatActivity {
    private ImageView backbtn;
    private EditText edtReceiverEmail, edtSendAmount, edtPurpose, edtRemarks;

    private LinearLayout BtnSubmitSend;

    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_money);
        backbtn = findViewById(R.id.backSender);

        edtPurpose = findViewById(R.id.edtPurpose);
        edtReceiverEmail = findViewById(R.id.edtReceiverEmail);
        edtSendAmount = findViewById(R.id.edtSendAmount);
        edtRemarks = findViewById(R.id.edtRemarks);

        BtnSubmitSend = findViewById(R.id.btnSendMoney);


        database = FirebaseDatabase.getInstance();
        reference = database.getReference("SendMoney");


        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SendMoney.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        BtnSubmitSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SubmitSendMoney();
            }
        });

    }

    private void SubmitSendMoney() {
        String sendEmail = edtReceiverEmail.getText().toString().trim();
        String sendAmount = edtSendAmount.getText().toString().trim();
        String purpose = edtPurpose.getText().toString().trim();
        String remarks = edtRemarks.getText().toString().trim();

        String id = reference.push().getKey();

        if (sendEmail.isEmpty()) {
            edtReceiverEmail.setError("Receiver Email is required!");
            edtReceiverEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(sendEmail).matches()) {
            edtReceiverEmail.setError("Please provide the valid email!");
            edtReceiverEmail.requestFocus();
            return;
        }
        if (sendAmount.isEmpty()) {
            edtSendAmount.setError("Amount is requires!");
            edtSendAmount.requestFocus();
            return;
        }
        if (purpose.isEmpty()) {
            edtPurpose.setError("Purpose of sending is required!");
            edtPurpose.requestFocus();
            return;
        }
        if (remarks.isEmpty()) {
            edtRemarks.setError("Remarks should be empty");
            edtRemarks.requestFocus();
            return;
        }
        if (!TextUtils.isEmpty(sendEmail)) {
            SendMoneyData data = new SendMoneyData(id, sendEmail, sendAmount, purpose, remarks);
            reference.child(id).setValue(data);
            Toast.makeText(this, "Your Transaction has been completed", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(SendMoney.this, MainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }

}
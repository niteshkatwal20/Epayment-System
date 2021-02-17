package com.example.smartpay.tvpayment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.smartpay.MainActivity;
import com.example.smartpay.R;
import com.example.smartpay.schoolfee.SchoolModel;
import com.example.smartpay.schoolfee.Schools;
import com.example.smartpay.user.SendOTPActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Tv extends AppCompatActivity {

    private Button Back;
    private EditText CustomerName, CustomerId, TVAmount, DepositorName, DepositorNumber;
    private LinearLayout BtnSubmit;

    private FirebaseDatabase database;
    private DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv);

        Back = findViewById(R.id.backTv);
        CustomerName = findViewById(R.id.CustomerName);
        CustomerId = findViewById(R.id.CustomerId);
        TVAmount = findViewById(R.id.edtTvamount);
        DepositorName = findViewById(R.id.DepositerName);
        DepositorNumber = findViewById(R.id.DepositerNumber);
        BtnSubmit = findViewById(R.id.PayTvBill);

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("TV");

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tv.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        BtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PaymentTV();
            }
        });
    }

    private void PaymentTV() {

        String customerName = CustomerName.getText().toString().trim();
        String customerId = CustomerId.getText().toString().trim();
        String Tvamount = TVAmount.getText().toString().trim();
        String tvDepositername = DepositorName.getText().toString().trim();
        String tvDepositorNo = DepositorNumber.getText().toString().trim();
        String id = reference.push().getKey();

        if (customerName.isEmpty()) {
            CustomerName.setError("Name is required!");
            CustomerName.requestFocus();
            return;
        }

        if (customerId.isEmpty()) {
            CustomerId.setError("Customer ID is requires!");
            CustomerId.requestFocus();
            return;
        }
        if (Tvamount.isEmpty()) {
            TVAmount.setError("Please enetr the amount!");
            TVAmount.requestFocus();
            return;
        }
        if (tvDepositername.isEmpty()) {
            DepositorName.setError("Please Enter Depositor Name");
            DepositorName.requestFocus();
            return;
        }
        if (tvDepositorNo.isEmpty()) {
            DepositorNumber.setError("Please Enter Depositor Name");
            DepositorNumber.requestFocus();
            return;
        }
        if (tvDepositorNo.length() < 10) {
            DepositorNumber.setError("Mobile Must be 10 digits");
            DepositorNumber.requestFocus();
            return;
        }

        if (tvDepositorNo.length() > 10) {
            DepositorNumber.setError("Mobile Must be 10 digits");
            DepositorNumber.requestFocus();
            return;
        }
        if (!TextUtils.isEmpty(customerId)) {
            TvModel data = new TvModel(id, customerName, customerId, Tvamount, tvDepositername, tvDepositorNo);
            reference.child(id).setValue(data);
            Intent intent = new Intent(Tv.this, SendOTPActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }

}
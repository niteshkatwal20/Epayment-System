package com.example.smartpay.electricitypayment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.smartpay.MainActivity;
import com.example.smartpay.R;
import com.example.smartpay.user.SendOTPActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Electricity extends AppCompatActivity {
    private ImageView Back;
    private EditText ElecCustomerName, ElecCustomerID, ElecAmount, ElecDepName, ElecDepNumber;
    private LinearLayout BtnPayElecBill;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electricity);

        Back = findViewById(R.id.backelectricity);
        ElecCustomerName = findViewById(R.id.edtElecCustomerName);
        ElecCustomerID = findViewById(R.id.edtElecCustomerId);
        ElecAmount = findViewById(R.id.edtelectricityamount);
        ElecDepName = findViewById(R.id.edtElecDepositerNumber);
        ElecDepNumber = findViewById(R.id.edtElecDepositerNumber);

        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference("Electricity");

        BtnPayElecBill = findViewById(R.id.PayEleBill);

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Electricity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        BtnPayElecBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PayElectricityBill();
            }
        });
    }

    private void PayElectricityBill() {
        String eleCustomerName = ElecCustomerName.getText().toString().trim();
        String eLeCustomerId = ElecCustomerID.getText().toString().trim();
        String eleAmount = ElecAmount.getText().toString().trim();
        String eleDepositerName = ElecDepName.getText().toString().trim();
        String eleDepositerNumber = ElecDepNumber.getText().toString().trim();
        String id = reference.push().getKey();

        if (eleCustomerName.isEmpty()) {
            ElecCustomerName.setError("Please Enter the Customer Name");
            ElecCustomerName.requestFocus();
            return;
        }
        if (eLeCustomerId.isEmpty()) {
            ElecCustomerID.setError("Please Enter the Customer ID");
            ElecCustomerName.requestFocus();
            return;
        }
        if (eleAmount.isEmpty()) {
            ElecAmount.setError("Field should not be empty");
            ElecAmount.requestFocus();
            return;
        }
        if (eleDepositerName.isEmpty()) {
            ElecCustomerName.setError("Please Enter the Customer Name");
            ElecCustomerName.requestFocus();
            return;
        }
        if (eleDepositerNumber.isEmpty()) {
            ElecDepNumber.setError("Please Enter the Depositer Mobile Number");
            ElecDepNumber.requestFocus();
            return;
        }
        if (eleDepositerNumber.length() < 10) {
            ElecDepNumber.setError("Mobile Must be 10 digits");
            ElecDepNumber.requestFocus();
            return;
        }

        if (eleDepositerNumber.length() > 10) {
            ElecDepNumber.setError("Mobile Must be 10 digits");
            ElecDepNumber.requestFocus();
            return;
        }

        if (!TextUtils.isEmpty(eleCustomerName)) {
            ElectricityModel electricityModel = new ElectricityModel(id, eleCustomerName, eLeCustomerId, eleAmount, eleDepositerName, eleDepositerNumber);
            reference.child(id).setValue(electricityModel);
            Intent intent = new Intent(Electricity.this, SendOTPActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Something Went Wrong !!!!!!", Toast.LENGTH_SHORT).show();
        }
    }
}
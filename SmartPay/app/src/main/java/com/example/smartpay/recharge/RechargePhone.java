package com.example.smartpay.recharge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.smartpay.MainActivity;
import com.example.smartpay.R;
import com.example.smartpay.user.SendOTPActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RechargePhone extends AppCompatActivity {

    private Button back;

    private EditText MobileNumber, RechargeAmount;

    private LinearLayout btnSubmit;

    private FirebaseDatabase database;
    private DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recharge_phone);

        back = findViewById(R.id.backRecharge);

        MobileNumber = findViewById(R.id.edtRechargeNumber);
        RechargeAmount = findViewById(R.id.edtRechargeamount);

        btnSubmit = findViewById(R.id.Recharge);

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Rechargephone");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RechargePhone.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Recharge();
            }
        });
    }

    private void Recharge() {

        String rechargeMobileNo = MobileNumber.getText().toString().trim();
        String rechageAmount = RechargeAmount.getText().toString().trim();
        String id = reference.push().getKey();

        if (rechargeMobileNo.isEmpty()) {
            MobileNumber.setError("Mobile Number is required!");
            MobileNumber.requestFocus();
            return;
        }

        if (rechargeMobileNo.length() < 10) {
            MobileNumber.setError("Mobile Must be 10 digits");
            MobileNumber.requestFocus();
            return;
        }

        if (rechargeMobileNo.length() > 10) {
            MobileNumber.setError("Mobile Must be 10 digits");
            MobileNumber.requestFocus();
            return;
        }

        if (rechageAmount.isEmpty()) {
            RechargeAmount.setError("Enter Amount!");
            RechargeAmount.requestFocus();
            return;
        }

        if (!TextUtils.isEmpty(rechargeMobileNo)) {
            RechargeModel data = new RechargeModel(id, rechargeMobileNo, rechageAmount);
            reference.child(id).setValue(data);

            Intent intent = new Intent(RechargePhone.this, SendOTPActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }
}
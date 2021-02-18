package com.example.smartpay.hospitalbill;

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

public class Health extends AppCompatActivity {

    private ImageView BtnBack;
    private EditText HospitalName, PatientName, HospitalBillNo, HospitalBillAmount;
    private LinearLayout BtnPayHospitalBill;

    private FirebaseDatabase database;
    private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);

        BtnBack = findViewById(R.id.backHealth);
        HospitalName = findViewById(R.id.edtHospitalName);
        PatientName = findViewById(R.id.edtPatientName);
        HospitalBillNo = findViewById(R.id.edtHospitalBillNo);
        HospitalBillAmount = findViewById(R.id.edtBillAmount);
        BtnPayHospitalBill = findViewById(R.id.PayHospitalBill);

        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("Hospital");

        BtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Health.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        BtnPayHospitalBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PayHospitalBill();

            }
        });

    }

    private void PayHospitalBill() {

        String hospitalname = HospitalName.getText().toString().trim();
        String patientname = PatientName.getText().toString().trim();
        String hospitalbillno = HospitalBillNo.getText().toString().trim();
        String hospitalbillamount = HospitalBillAmount.getText().toString().trim();

        String id = databaseReference.push().getKey();
        if (hospitalname.isEmpty()) {
            HospitalName.setError("Receiver Email is required!");
            HospitalName.requestFocus();
            return;
        }

        if (patientname.isEmpty()) {
            PatientName.setError("Amount is requires!");
            PatientName.requestFocus();
            return;
        }
        if (hospitalbillno.isEmpty()) {
            HospitalBillNo.setError("Purpose of sending is required!");
            HospitalBillNo.requestFocus();
            return;
        }
        if (hospitalbillamount.isEmpty()) {
            HospitalBillNo.setError("Remarks should be empty");
            HospitalBillNo.requestFocus();
            return;
        }
        if (!TextUtils.isEmpty(hospitalname)) {
            HospitalModel data = new HospitalModel(id, hospitalname, patientname, hospitalbillno, hospitalbillamount);
            databaseReference.child(id).setValue(data);

            Intent intent = new Intent(Health.this, SendOTPActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
        }

    }
}
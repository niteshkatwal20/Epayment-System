package com.example.smartpay.internet;

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

public class Internet extends AppCompatActivity {

    private Button btnBack;

    private EditText ISPName, ISPClientName, ISPClientId, InternetBillAmount;
    private LinearLayout linearLayout;

    private FirebaseDatabase database;
    private DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internet);

        btnBack = findViewById(R.id.backInternet);
        ISPName = findViewById(R.id.edtISPName);
        ISPClientId = findViewById(R.id.edtUserId);
        ISPClientName = findViewById(R.id.edtUserName);
        InternetBillAmount = findViewById(R.id.edtInternetAmount);

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Internet");

        linearLayout = findViewById(R.id.PayInternetBill);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Internet.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PayinternetBill();
            }
        });
    }

    private void PayinternetBill() {

        String serviceProvider = ISPName.getText().toString().trim();
        String ispClientName = ISPClientName.getText().toString().trim();
        String ispClientId = ISPClientId.getText().toString().trim();
        String internetBillPayment = InternetBillAmount.getText().toString().trim();

        String id = reference.push().getKey();

        if (serviceProvider.isEmpty()) {
            ISPName.setError("ISP Name is Required");
            ISPName.requestFocus();
            return;
        }

        if (ispClientName.isEmpty()) {
            ISPClientName.setError("Client Name is required");
            ISPClientName.requestFocus();
            return;
        }
        if (ispClientId.isEmpty()) {
            ISPClientId.setError("Client ID is requires");
            ISPClientId.requestFocus();
            return;
        }
        if (ispClientId.isEmpty()) {
            InternetBillAmount.setError("Enter the Amount");
            InternetBillAmount.requestFocus();
            return;
        }
        if (!TextUtils.isEmpty(serviceProvider)) {
            InternetModel data = new InternetModel(id, serviceProvider, ispClientName, ispClientId, ispClientId);
            reference.child(id).setValue(data);

            Intent intent = new Intent(Internet.this, SendOTPActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }
}
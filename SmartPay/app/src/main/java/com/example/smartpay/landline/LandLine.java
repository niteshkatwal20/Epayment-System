package com.example.smartpay.landline;

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
import com.example.smartpay.user.SendOTPActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LandLine extends AppCompatActivity {

    private Button Back;

    private EditText LanLineProvider, ClientName, ClientId, BillAmount;

    private LinearLayout linearLayout;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_land_line);

        Back = findViewById(R.id.backPhone);

        LanLineProvider = findViewById(R.id.edtLandLineName);
        ClientName = findViewById(R.id.edtOwnerName);
        ClientId = findViewById(R.id.edtOwnerId);
        BillAmount = findViewById(R.id.edtPhoneAmount);

        linearLayout=findViewById(R.id.PayPhoneBill);

        firebaseDatabase=FirebaseDatabase.getInstance();
        reference=firebaseDatabase.getReference("Landline");


        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LandLine.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PayLandLine();
            }
        });
    }

    private void PayLandLine() {

        String landLineProvider = LanLineProvider.getText().toString().trim();
        String landLineClientName = ClientName.getText().toString().trim();
        String landLineClientId = ClientId.getText().toString().trim();
        String landLinebillAmount = BillAmount.getText().toString().trim();

        String id = reference.push().getKey();

        if (landLineProvider.isEmpty()) {
            LanLineProvider.setError("Field Must Not be Empty!");
            LanLineProvider.requestFocus();
            return;
        }

        if (landLineClientName.isEmpty()) {
            ClientName.setError("Field Must Not be Empty!");
            ClientName.requestFocus();
            return;
        }
        if (landLineClientId.isEmpty()) {
            ClientName.setError("Field Must Not be Empty!");
            ClientName.requestFocus();
            return;
        }
        if (landLinebillAmount.isEmpty()) {
            BillAmount.setError("Field Must Not be Empty!");
            BillAmount.requestFocus();
            return;
        }
        if (!TextUtils.isEmpty(landLineProvider)) {
            LandlineModel data = new LandlineModel(id, landLineProvider, landLineClientName, landLineClientId, landLinebillAmount);
            reference.child(id).setValue(data);

            Intent intent = new Intent(LandLine.this, SendOTPActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }
}
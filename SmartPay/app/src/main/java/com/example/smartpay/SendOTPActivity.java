package com.example.smartpay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SendOTPActivity extends AppCompatActivity {

   private EditText MobileNumber;
   private TextView GetOTP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_o_t_p);

        MobileNumber = findViewById(R.id.edtEnterMobile);
        GetOTP = findViewById(R.id.btnSendOTP);


        GetOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (MobileNumber.getText().toString().trim().isEmpty()) {
                    Toast.makeText(SendOTPActivity.this, "Enter Mobile Number", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(getApplicationContext(), UserVerification.class);
                intent.putExtra("mobile", MobileNumber.getText().toString());
                startActivity(intent);
            }
        });
    }
}
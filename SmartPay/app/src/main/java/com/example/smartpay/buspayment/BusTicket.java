package com.example.smartpay.buspayment;

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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BusTicket extends AppCompatActivity {
    private EditText edtFrom, edtTo, edtPassengerName, edtBusName, edtTicketNo, edtDepDate, edtPassengerPhone;
    private LinearLayout edtPayBusFare;
    private ImageView btnBackBus;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private EditText edtbusfare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_ticket);

        btnBackBus = findViewById(R.id.backBus);
        edtFrom = findViewById(R.id.edtDepartureAddress);
        edtTo = findViewById(R.id.edtDestinationAddress);
        edtPassengerName = findViewById(R.id.edtPassengerName);
        edtBusName = findViewById(R.id.edtBussName);
        edtTicketNo = findViewById(R.id.edtTicketNo);
        edtDepDate = findViewById(R.id.edtDepartureDate);
        edtPassengerPhone = findViewById(R.id.edtPassangerNumber);
        edtPayBusFare = findViewById(R.id.PayBusBill);
        edtbusfare = findViewById(R.id.edtAmountBus);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("BusFare");

        btnBackBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BusTicket.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        edtPayBusFare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PayBusTicket();
            }
        });
    }

    private void PayBusTicket() {
        String from = edtFrom.getText().toString().trim();
        String to = edtTo.getText().toString().trim();
        String passengername = edtPassengerName.getText().toString().trim();
        String busname = edtBusName.getText().toString().trim();
        String ticketno = edtTicketNo.getText().toString().trim();
        String depdate = edtDepDate.toString().trim();
        String passangerno = edtPassengerPhone.getText().toString().trim();
        String busfare = edtbusfare.getText().toString().trim();
        String id = databaseReference.push().getKey();

        if (from.isEmpty()) {
            edtFrom.setError("Please Enter the Location!");
            edtFrom.requestFocus();
            return;
        }
        if (to.isEmpty()) {
            edtTo.setError("Please Enter the Location!");
            edtTo.requestFocus();
            return;
        }
        if (passengername.isEmpty()) {
            edtPassengerName.setError("Please Enter Passenger Name!");
            edtPassengerName.requestFocus();
            return;
        }
        if (busname.isEmpty()) {
            edtBusName.setError("Please Enter Bus Name");
            edtBusName.requestFocus();
            return;
        }
        if (ticketno.isEmpty()) {
            edtTicketNo.setError("Please Enter the Ticket No");
            edtTicketNo.requestFocus();
            return;
        }
        if (depdate.isEmpty()) {
            edtDepDate.setError("Please Enter the Departure Date");
            edtDepDate.requestFocus();
            return;
        }
        if (passangerno.isEmpty()) {
            edtPassengerPhone.setError("Please Enter the Mobile Number");
            edtPassengerPhone.requestFocus();
            return;
        }
        if (passangerno.length() < 10) {
            edtPassengerPhone.setError("Mobile Number Must be 10 digit");
        }
        if (busfare.isEmpty()) {
            edtbusfare.setError("Enter the amount");
            edtbusfare.requestFocus();
            return;
        }
        if (!TextUtils.isEmpty(passengername)) {
            BusModel busModel = new BusModel(id, from, to, passengername, busname, ticketno, depdate, passangerno, busfare);
            databaseReference.child(id).setValue(busModel);
            Toast.makeText(this, "Your Transaction has been completed ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(BusTicket.this, MainActivity.class);
            startActivity(intent);
        }

    }
}
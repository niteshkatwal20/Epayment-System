package com.example.smartpay.hotelpayment;

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

public class Hotels extends AppCompatActivity {

    private Button btnBack;
    private EditText HotelName, GuestName, HotelBillNo, RoomNo, NoOfGuest, HotelBillAmount, GuestNumber;
    private LinearLayout BtnPay;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels);

        btnBack = findViewById(R.id.backHotel);
        HotelName = findViewById(R.id.edtHotelName);
        GuestName = findViewById(R.id.edtGuestName);
        HotelBillNo = findViewById(R.id.edtBillNumber);
        RoomNo = findViewById(R.id.edtRoomNO);
        NoOfGuest = findViewById(R.id.edtNoOfPerson);
        HotelBillAmount = findViewById(R.id.edtAmount);
        GuestNumber = findViewById(R.id.edtGuestNumber);
        BtnPay = findViewById(R.id.PayHotelBill);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Hotel");

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Hotels.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        BtnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PayHotelBill();
            }
        });
    }

    private void PayHotelBill() {

        String hotelName = HotelName.getText().toString().trim();
        String guestName = GuestName.getText().toString().trim();
        String hotelBillno = HotelBillNo.getText().toString().trim();
        String roomNo = RoomNo.getText().toString().trim();
        String noOfperson = NoOfGuest.getText().toString().trim();
        String hotelBillamount = GuestName.getText().toString().trim();
        String guestNumber = GuestNumber.getText().toString().trim();

        String id = databaseReference.push().getKey();

        if (hotelName.isEmpty()) {
            HotelName.setError("Field Must not be empty !");
            HotelName.requestFocus();
            return;
        }
        if (guestName.isEmpty()) {
            GuestName.setError("Field Must not be empty !");
            GuestName.requestFocus();
            return;
        }
        if (hotelBillno.isEmpty()) {
            HotelBillNo.setError("Remarks should be empty");
            HotelBillNo.requestFocus();
            return;
        }

        if (roomNo.isEmpty()) {
            RoomNo.setError("Field Must not be empty !");
            RoomNo.requestFocus();
            return;
        }
        if (noOfperson.isEmpty()) {
            NoOfGuest.setError("Field Must not be empty !");
            NoOfGuest.requestFocus();
            return;
        }
        if (hotelBillamount.isEmpty()) {
            GuestName.setError("Remarks should be empty");
            GuestName.requestFocus();
            return;
        }

        if (guestNumber.isEmpty()) {
            GuestNumber.setError("Remarks should be empty");
            GuestNumber.requestFocus();
            return;
        }
        if (!TextUtils.isEmpty(hotelName)) {
            HotelModel data = new HotelModel(id, hotelName, guestName, hotelBillno, roomNo, noOfperson, hotelBillamount, guestNumber);
            databaseReference.child(id).setValue(data);
            Intent intent = new Intent(Hotels.this, SendOTPActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Something went wrong !!!!!", Toast.LENGTH_SHORT).show();
        }

    }
}
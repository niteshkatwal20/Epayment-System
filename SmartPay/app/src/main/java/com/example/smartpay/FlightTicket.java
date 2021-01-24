package com.example.smartpay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class FlightTicket extends AppCompatActivity {
    private ImageView back;
    private EditText from,to,date,noofpassanger,price;
    private LinearLayout payflight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_ticket);

        back=findViewById(R.id.backFlight);
        from=findViewById(R.id.edtFrom);
        to=findViewById(R.id.edtTo);
        date=findViewById(R.id.edtDate);
        noofpassanger=findViewById(R.id.edtTraveller);
        price=findViewById(R.id.edtFlightAmount);
        payflight=findViewById(R.id.PayFlightTicket);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FlightTicket.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
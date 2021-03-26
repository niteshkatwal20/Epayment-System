package com.example.smartpay.flightpayment;

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

public class FlightTicket extends AppCompatActivity {
    private ImageView back;
    private EditText Flightfrom, Flightto, Flightdate, noofpassanger, FlightNo, NameofPassenger, Passengerno, TicketNo, price;
    private LinearLayout payflight;

    private FirebaseDatabase database;
    private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_ticket);

        back = findViewById(R.id.backFlight);

        Flightfrom = findViewById(R.id.edtFrom);
        Flightto = findViewById(R.id.edtTo);
        Flightdate = findViewById(R.id.edtDate);
        noofpassanger = findViewById(R.id.edtFlightNoOfPassanger);
        price = findViewById(R.id.edtFlightAmount);
        payflight = findViewById(R.id.PayFlightTicket);
        FlightNo = findViewById(R.id.edtFlightNo);
        NameofPassenger = findViewById(R.id.edtTraveller);
        TicketNo = findViewById(R.id.edtFlightTicketNo);
        Passengerno = findViewById(R.id.edtFlightPassengerNo);

        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("Flight");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FlightTicket.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        payflight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlaneFare();
            }
        });
    }

    private void PlaneFare() {
        String flightFrom = Flightfrom.getText().toString().trim();
        String flightTo = Flightto.getText().toString().trim();
        String flightDate = Flightdate.getText().toString().trim();
        String flightNoofPass = noofpassanger.getText().toString().trim();
        String flightPassangerNo = Passengerno.getText().toString().trim();
        String flightPassangerName = NameofPassenger.getText().toString().trim();
        String flightNo = FlightNo.getText().toString().trim();
        String flightTicketNo = TicketNo.getText().toString().trim();
        String flightAmount = price.getText().toString().trim();

        String id = databaseReference.push().getKey();


        if (flightPassangerNo.isEmpty()) {
            Passengerno.setError("Please Enter the Depositor Number!");
            Passengerno.requestFocus();
            return;

        }
        if (flightPassangerNo.length() < 10) {
            Passengerno.setError("Mobile Must be 10 digits");
            Passengerno.requestFocus();
            return;
        }

        if (flightPassangerNo.length() > 10) {
            Passengerno.setError("Mobile Must be 10 digits");
            Passengerno.requestFocus();
            return;
        }

        if (flightFrom.isEmpty()) {
            Flightfrom.setError("Flied should be empty");
            Flightfrom.requestFocus();
            return;
        }
        if (flightTo.isEmpty()) {
            Flightto.setError("Field should be empty");
            Flightto.requestFocus();
            return;
        }

        if (flightDate.isEmpty()) {
            Flightdate.setError("Flied should be empty");
            Flightdate.requestFocus();
            return;
        }
        if (flightNoofPass.isEmpty()) {
            noofpassanger.setError("Flied should be empty");
            noofpassanger.requestFocus();
            return;
        }
        if (flightPassangerName.isEmpty()) {
            NameofPassenger.setError("Flied should be empty");
            NameofPassenger.requestFocus();
            return;
        }
        if (flightNo.isEmpty()) {
            FlightNo.setError("Flied should be empty");
            FlightNo.requestFocus();
            return;
        }
        if (flightTicketNo.isEmpty()) {
            TicketNo.setError("Flied should be empty");
            TicketNo.requestFocus();
            return;
        }
        if (flightAmount.isEmpty()) {
            price.setError("Flied should be empty");
            price.requestFocus();
            return;
        }

        if (!TextUtils.isEmpty(flightFrom)) {
            FlightModel model = new FlightModel(id, flightFrom, flightTo, flightDate, flightNoofPass, flightPassangerNo, flightPassangerName, flightNo, flightTicketNo, flightAmount);
            databaseReference.child(id).setValue(model);

            Intent intent = new Intent(FlightTicket.this, SendOTPActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Something Went Wrong !!!!!!", Toast.LENGTH_SHORT).show();
        }
    }
}
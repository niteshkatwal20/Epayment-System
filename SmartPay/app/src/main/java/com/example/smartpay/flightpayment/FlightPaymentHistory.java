package com.example.smartpay.flightpayment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.smartpay.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FlightPaymentHistory extends AppCompatActivity {


    private RecyclerView recyclerView;
    private DatabaseReference reference;
    private ArrayList<FlightModel> arrayList;
    private FlightAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_payment_history);

        recyclerView = findViewById(R.id.RycFlightHistory);
        reference = FirebaseDatabase.getInstance().getReference().child("PlaneFare");
        arrayList = new ArrayList<FlightModel>();
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    FlightModel flightModel = dataSnapshot.getValue(FlightModel.class);
                    arrayList.add(flightModel);
                }
                adapter = new FlightAdapter(FlightPaymentHistory.this, arrayList);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(FlightPaymentHistory.this, "Something Went Wrong !!!!!!", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
package com.example.smartpay.electricitypayment;

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

public class ElectricityPaymentHistory extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DatabaseReference reference;
    private ArrayList<ElectricityModel> electricityModelArrayList;
    private ElectricityAdapter electricityAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electricity_payment_history);

        recyclerView = findViewById(R.id.RycElectricityHistory);
        reference = FirebaseDatabase.getInstance().getReference().child("Electricity");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        electricityModelArrayList = new ArrayList<ElectricityModel>();

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot s : snapshot.getChildren()) {
                    ElectricityModel electricityModel = s.getValue(ElectricityModel.class);
                    electricityModelArrayList.add(electricityModel);

                }
                electricityAdapter = new ElectricityAdapter(ElectricityPaymentHistory.this, electricityModelArrayList);
                recyclerView.setAdapter(electricityAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(ElectricityPaymentHistory.this, "Something Went Wrong !!!!!", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
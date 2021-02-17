package com.example.smartpay.buspayment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.smartpay.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;

public class BusHistory extends AppCompatActivity {
    private DatabaseReference databaseReference;
    private RecyclerView busHistory;
    private ArrayList<BusModel> busModels;
    private BusHistoryAdapter busHistoryAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_history);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("BusFare");
        busHistory = findViewById(R.id.RycBusHistory);

        busHistory.setLayoutManager(new LinearLayoutManager(this));
        busModels = new ArrayList<BusModel>();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    BusModel busModel = dataSnapshot.getValue(BusModel.class);
                    busModels.add(busModel);

                }
                busHistoryAdapter = new BusHistoryAdapter(BusHistory.this, busModels);
                busHistory.setAdapter(busHistoryAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(BusHistory.this, "Something Went Wrong!!!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
package com.example.smartpay.hospitalbill;

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

public class HospitalPaymentHistory extends AppCompatActivity {

    private RecyclerView hospitalRecycleView;
    private DatabaseReference reference;

    private ArrayList<HospitalModel> hospitalModelArrayList;
    private HospitalAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_payment_history);

        hospitalRecycleView = findViewById(R.id.RycHospitalHistory);
        reference = FirebaseDatabase.getInstance().getReference().child("Hospital");

        hospitalRecycleView.setLayoutManager(new LinearLayoutManager(this));
        hospitalModelArrayList = new ArrayList<HospitalModel>();

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    HospitalModel model = dataSnapshot.getValue(HospitalModel.class);
                    hospitalModelArrayList.add(model);

                }
                adapter = new HospitalAdapter(HospitalPaymentHistory.this, hospitalModelArrayList);
                hospitalRecycleView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(HospitalPaymentHistory.this, "Something Went Wrong !!!!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
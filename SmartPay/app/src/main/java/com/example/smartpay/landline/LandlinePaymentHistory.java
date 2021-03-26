package com.example.smartpay.landline;

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

public class LandlinePaymentHistory extends AppCompatActivity {

    private RecyclerView recyclerViewLandline;
    private DatabaseReference reference;
    private ArrayList<LandlineModel> landlineModellist;
    private LandlineAdapter landlineAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landline_payment_history);

        recyclerViewLandline = findViewById(R.id.RycLandLineHistory);
        reference = FirebaseDatabase.getInstance().getReference().child("Landline");

        recyclerViewLandline.setLayoutManager(new LinearLayoutManager(this));

        landlineModellist = new ArrayList<LandlineModel>();

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    LandlineModel landlineModel = dataSnapshot.getValue(LandlineModel.class);
                    landlineModellist.add(landlineModel);

                }
                landlineAdapter = new LandlineAdapter(LandlinePaymentHistory.this, landlineModellist);
                recyclerViewLandline.setAdapter(landlineAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(LandlinePaymentHistory.this, "Something Went Wrong !!!!!", Toast.LENGTH_SHORT).show();


            }
        });

    }
}
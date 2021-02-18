package com.example.smartpay.recharge;

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

public class RechargePhoneHistory extends AppCompatActivity {
    private RecyclerView recyclerViewRecharge;
    private DatabaseReference reference;
    private ArrayList<RechargeModel> arrayList;
    private RechargeAdapter rechargeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recharge_phone_history);

        recyclerViewRecharge = findViewById(R.id.RycRechargeHistory);
        reference = FirebaseDatabase.getInstance().getReference().child("Rechargephone");

        recyclerViewRecharge.setLayoutManager(new LinearLayoutManager(this));
        arrayList = new ArrayList<RechargeModel>();

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    RechargeModel rechargeModel = dataSnapshot.getValue(RechargeModel.class);
                    arrayList.add(rechargeModel);

                }
                rechargeAdapter = new RechargeAdapter(RechargePhoneHistory.this, arrayList);
                recyclerViewRecharge.setAdapter(rechargeAdapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(RechargePhoneHistory.this, "Something Went Wrong !!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
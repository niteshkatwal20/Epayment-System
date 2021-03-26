package com.example.smartpay.tvpayment;

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

public class TVBillPaymentHistory extends AppCompatActivity {
    private RecyclerView recyclerViewTV;
    private DatabaseReference reference;
    private ArrayList<TvModel> modelList;
    private TVAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_v_bill_payment_history);

        recyclerViewTV = findViewById(R.id.RycTVHistory);
        reference = FirebaseDatabase.getInstance().getReference().child("TV");

        recyclerViewTV.setLayoutManager(new LinearLayoutManager(this));
        modelList = new ArrayList<TvModel>();

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    TvModel tvModel = dataSnapshot.getValue(TvModel.class);
                    modelList.add(tvModel);

                }
                adapter = new TVAdapter(TVBillPaymentHistory.this, modelList);
                recyclerViewTV.setAdapter(adapter);

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(TVBillPaymentHistory.this, "Something Went Wrong !!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
package com.example.smartpay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.smartpay.Adapter.TransactionAdapter;
import com.example.smartpay.databse.SendMoneyData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SendMoneyHistory extends AppCompatActivity {
    DatabaseReference reference;
    private RecyclerView recyclerView;
    ArrayList<SendMoneyData> list;
    TransactionAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_money_history);

        reference = FirebaseDatabase.getInstance().getReference().child("SendMoney");

        recyclerView = findViewById(R.id.transactionHistory);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<SendMoneyData>();

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    SendMoneyData sendMoneyData = dataSnapshot.getValue(SendMoneyData.class);
                    list.add(sendMoneyData);

                }
                adapter = new TransactionAdapter(SendMoneyHistory.this, list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(SendMoneyHistory.this, "Something wrong happened.Try again later", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
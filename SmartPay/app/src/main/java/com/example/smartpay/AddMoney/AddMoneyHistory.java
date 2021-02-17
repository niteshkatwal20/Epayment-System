package com.example.smartpay.AddMoney;

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

public class AddMoneyHistory extends AppCompatActivity {
    private DatabaseReference historyReference;
    private RecyclerView addMoneyHistory;
    private ArrayList<AddMoneyModel> addMoneyModelArrayList;
    private AddMoneyAdapter addMoneyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_money_history);

        historyReference = FirebaseDatabase.getInstance().getReference().child("AddMoney");
        addMoneyHistory = findViewById(R.id.AddMoneyHistory);

        addMoneyHistory.setLayoutManager(new LinearLayoutManager(this));
        addMoneyModelArrayList = new ArrayList<AddMoneyModel>();

        historyReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    AddMoneyModel addMoneyModel = dataSnapshot.getValue(AddMoneyModel.class);
                    addMoneyModelArrayList.add(addMoneyModel);
                }
                addMoneyAdapter = new AddMoneyAdapter(AddMoneyHistory.this, addMoneyModelArrayList);
                addMoneyHistory.setAdapter(addMoneyAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(AddMoneyHistory.this, "Something Went Wrong ??????????", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
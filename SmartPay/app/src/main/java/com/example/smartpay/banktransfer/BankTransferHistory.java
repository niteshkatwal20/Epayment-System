package com.example.smartpay.banktransfer;

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

public class BankTransferHistory extends AppCompatActivity {

    private RecyclerView bankTransferHistory;
    private DatabaseReference reference;
    ArrayList<BankTransferModel> bankTransferDatalist;
    private BankTransferAdapter bankTransferAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_transfer_history);

        bankTransferHistory = findViewById(R.id.BankTransferHistory);

        reference = FirebaseDatabase.getInstance().getReference().child("BankTransfer");

        bankTransferHistory.setLayoutManager(new LinearLayoutManager(this));
        bankTransferDatalist = new ArrayList<BankTransferModel>();

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    BankTransferModel bankTransferModel = dataSnapshot.getValue(BankTransferModel.class);
                    bankTransferDatalist.add(bankTransferModel);

                }
                bankTransferAdapter = new BankTransferAdapter(BankTransferHistory.this, bankTransferDatalist);
                bankTransferHistory.setAdapter(bankTransferAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(BankTransferHistory.this, "Something Went Wrong !!!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
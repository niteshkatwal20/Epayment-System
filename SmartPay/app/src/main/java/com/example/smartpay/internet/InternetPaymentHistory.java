package com.example.smartpay.internet;

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

public class InternetPaymentHistory extends AppCompatActivity {

    private RecyclerView recycleInternet;
    private DatabaseReference reference;
    private ArrayList<InternetModel> internetModelList;
    private InternetAdapter internetAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internet_payment_history);

        reference = FirebaseDatabase.getInstance().getReference().child("Internet");

        recycleInternet = findViewById(R.id.RycInternetHistory);

        recycleInternet.setLayoutManager(new LinearLayoutManager(this));
        internetModelList = new ArrayList<InternetModel>();

        reference.addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    InternetModel internetModel = dataSnapshot.getValue(InternetModel.class);
                    internetModelList.add(internetModel);

                }
                internetAdapter = new InternetAdapter(InternetPaymentHistory.this, internetModelList);
                recycleInternet.setAdapter(internetAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(InternetPaymentHistory.this, "Something Went Wrong !!!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
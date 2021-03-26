package com.example.smartpay.schoolfee;

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

public class SchoolFeePaymentHisotry extends AppCompatActivity {

    private RecyclerView recyclerViewSchool;
    private DatabaseReference reference;
    private ArrayList<SchoolModel> schoolModelList;
    private SchoolAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_fee_payment_hisotry);

        recyclerViewSchool = findViewById(R.id.RycSchoolFeeHistory);
        reference = FirebaseDatabase.getInstance().getReference().child("SchoolFee");

        recyclerViewSchool.setLayoutManager(new LinearLayoutManager(this));
        schoolModelList = new ArrayList<SchoolModel>();

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    SchoolModel school = dataSnapshot.getValue(SchoolModel.class);
                    schoolModelList.add(school);

                }
                adapter = new SchoolAdapter(SchoolFeePaymentHisotry.this, schoolModelList);
                recyclerViewSchool.setAdapter(adapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(SchoolFeePaymentHisotry.this, "Something Went Wrong !!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
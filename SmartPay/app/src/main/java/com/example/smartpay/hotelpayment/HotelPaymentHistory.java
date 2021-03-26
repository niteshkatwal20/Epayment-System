package com.example.smartpay.hotelpayment;

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

public class HotelPaymentHistory extends AppCompatActivity {

    private RecyclerView recyclerViewHotel;
    private DatabaseReference reference;
    private ArrayList<HotelModel> hotelModelArrayList;
    private HotelAdapter hotelAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_payment_history);

        recyclerViewHotel = findViewById(R.id.RycHotelHistory);
        reference = FirebaseDatabase.getInstance().getReference().child("Hotel");
        recyclerViewHotel.setLayoutManager(new LinearLayoutManager(this));
        hotelModelArrayList = new ArrayList<HotelModel>();

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    HotelModel hotelModel = dataSnapshot.getValue(HotelModel.class);
                    hotelModelArrayList.add(hotelModel);

                }
                hotelAdapter = new HotelAdapter(HotelPaymentHistory.this, hotelModelArrayList);
                recyclerViewHotel.setAdapter(hotelAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(HotelPaymentHistory.this, "Something WEnt Wrong !!!!!!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
package com.example.smartpay.Movie;

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

public class MovieTicketPaymentHistory extends AppCompatActivity {

    private RecyclerView recyclerViewMovie;
    private DatabaseReference reference;
    private ArrayList<MovieModel> movieModelArrayList;
    private MovieAdapter movieAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_ticket_payment_history);

        recyclerViewMovie = findViewById(R.id.RycMovieHistory);
        reference = FirebaseDatabase.getInstance().getReference().child("Movie");

        recyclerViewMovie.setLayoutManager(new LinearLayoutManager(this));

        movieModelArrayList = new ArrayList<MovieModel>();

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    MovieModel movieModel = dataSnapshot.getValue(MovieModel.class);
                    movieModelArrayList.add(movieModel);

                }
                movieAdapter = new MovieAdapter(MovieTicketPaymentHistory.this, movieModelArrayList);
                recyclerViewMovie.setAdapter(movieAdapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(MovieTicketPaymentHistory.this, "Something Went Wrong !!!!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
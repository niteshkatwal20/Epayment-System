package com.example.smartpay.Movie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.smartpay.MainActivity;
import com.example.smartpay.R;
import com.example.smartpay.user.SendOTPActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MovieTicket extends AppCompatActivity {

    private Button btnBack;

    private EditText HallName, MovieName, CustomerName, HallSeatNo, MovieTicketAmount;

    private LinearLayout linearLayout;

    private FirebaseDatabase database;
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_ticket);

        btnBack = findViewById(R.id.backMovie);
        HallName = findViewById(R.id.edtHallName);
        MovieName = findViewById(R.id.edtMovieName);
        CustomerName = findViewById(R.id.Name);
        HallSeatNo = findViewById(R.id.SeatNo);
        MovieTicketAmount = findViewById(R.id.edtTicketAmount);
        linearLayout = findViewById(R.id.PayMovieBill);

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Movie");

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MovieTicket.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PayMovieTicketBill();
            }
        });
    }

    private void PayMovieTicketBill() {
        String hallName = HallName.getText().toString().trim();
        String movieName = MovieName.getText().toString().trim();
        String customerName = CustomerName.getText().toString().trim();
        String noofSeats = HallSeatNo.getText().toString().trim();
        String movieTicketAmount = MovieTicketAmount.getText().toString().trim();
        String id = reference.push().getKey();

        if (hallName.isEmpty()) {
            HallName.setError("Hall Name is required!");
            HallName.requestFocus();
            return;
        }

        if (movieName.isEmpty()) {
            MovieName.setError("Movie Name is requires!");
            MovieName.requestFocus();
            return;
        }
        if (customerName.isEmpty()) {
            CustomerName.setError("Name  is required!");
            CustomerName.requestFocus();
            return;
        }
        if (noofSeats.isEmpty()) {
            HallSeatNo.setError("Please enter Seat No");
            HallSeatNo.requestFocus();
            return;
        }
        if (movieTicketAmount.isEmpty()) {
            MovieTicketAmount.setError("Please enter the amount");
            MovieTicketAmount.requestFocus();
            return;
        }
        if (!TextUtils.isEmpty(movieName)) {
            MovieModel data = new MovieModel(id, hallName, movieName, customerName, noofSeats, movieTicketAmount);
            reference.child(id).setValue(data);

            Intent intent = new Intent(MovieTicket.this, SendOTPActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }
}
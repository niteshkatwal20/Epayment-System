package com.example.smartpay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


   private LinearLayout Recharge,Electricity,Health,FlightTicket,BusTicket,Tv,Internet,Landline,
        MovieTicket,Hotels,School,BankTransfer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

Recharge=findViewById(R.id.Recharge);
Electricity=findViewById(R.id.Electricity);
Health=findViewById(R.id.Health);
FlightTicket=findViewById(R.id.FlightTicket);
BusTicket=findViewById(R.id.Bus);
Tv=findViewById(R.id.Tv);
Internet=findViewById(R.id.Internet);
Landline=findViewById(R.id.Landline);
MovieTicket=findViewById(R.id.MovieTicket);
Hotels=findViewById(R.id.Hotels);
School=findViewById(R.id.School);
BankTransfer=findViewById(R.id.BankTransfer);

Recharge.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        Intent intent=new Intent(MainActivity.this,RechargePhone.class);
        startActivity(intent);
    }
});
Electricity.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

    }
});
Health.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

    }
});
FlightTicket.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

    }
});
BusTicket.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

    }
});
Tv.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

    }
});
Internet.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

    }
});
Landline.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

    }
});
MovieTicket.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

    }
});
Hotels.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

    }
});
School.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

    }
});
BankTransfer.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

    }
});
    }
}
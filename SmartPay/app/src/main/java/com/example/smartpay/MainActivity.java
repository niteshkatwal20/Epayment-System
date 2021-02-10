package com.example.smartpay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private LinearLayout paynow, addmoney, logout, trans;

    private LinearLayout Recharge, Electricity, Health, FlightTicket, BusTicket, Tv, Internet, Landline,
            MovieTicket, Hotels, School, BankTransfer;

//   For online shopping

    private LinearLayout hamrobazar, flipcart, lenscart, alibaba, amazon, ugbazzar, daraz;

    //For Online food delivery
    private LinearLayout Bhoj, foodmario, bhoklago, foodmandu, foodexpress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        paynow = findViewById(R.id.sendmoney);
        addmoney = findViewById(R.id.AddMoney);
        logout = findViewById(R.id.LogOut);
        trans = findViewById(R.id.transactions);

        Recharge = findViewById(R.id.Recharge);
        Electricity = findViewById(R.id.Electricity);
        Health = findViewById(R.id.Health);
        FlightTicket = findViewById(R.id.FlightTicket);
        BusTicket = findViewById(R.id.Bus);
        Tv = findViewById(R.id.Tv);
        Internet = findViewById(R.id.Internet);
        Landline = findViewById(R.id.Landline);
        MovieTicket = findViewById(R.id.MovieTicket);
        Hotels = findViewById(R.id.Hotels);
        School = findViewById(R.id.School);
        BankTransfer = findViewById(R.id.BankTransfer);

        hamrobazar = findViewById(R.id.hamrobazzar);
        flipcart = findViewById(R.id.flipkart);
        lenscart = findViewById(R.id.lenskart);
        alibaba = findViewById(R.id.alibaba);
        amazon = findViewById(R.id.amazon);
        ugbazzar = findViewById(R.id.ugbazzar);
        daraz = findViewById(R.id.daraz);

        Bhoj = findViewById(R.id.bhoj);
        foodmario = findViewById(R.id.foodmario);
        bhoklago = findViewById(R.id.bhoklagyo);
        foodmandu = findViewById(R.id.foodamdu);
        foodexpress = findViewById(R.id.foodexpress);


        // send money event onclicklistener
        paynow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SendMoney.class);
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(MainActivity.this, SignIn.class));
            }
        });
        //main menu onclicklisterner event
        Recharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, RechargePhone.class);
                startActivity(intent);
            }
        });
        Electricity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Electricity.class);
                startActivity(intent);

            }
        });
        Health.setOnClickListener(new View.OnClickListener() {                                          
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Health.class);
                startActivity(intent);
            }
        });
        FlightTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, FlightTicket.class);
                startActivity(intent);
            }
        });
        BusTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BusTicket.class);
                startActivity(intent);

            }
        });
        Tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Tv.class);
                startActivity(intent);
            }
        });
        Internet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Internet.class);
                startActivity(intent);

            }
        });
        Landline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LandLine.class);
                startActivity(intent);
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
                Intent intent = new Intent(MainActivity.this, Hotels.class);
                startActivity(intent);
            }
        });
        School.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Schools.class);
                startActivity(intent);
            }
        });

        BankTransfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BankTransfer.class);
                startActivity(intent);
            }
        });

        //others
        hamrobazar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://hamrobazaar.com/");
            }
        });
        flipcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.flipkart.com/");
            }
        });
        lenscart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.lenskart.com/");
            }
        });
        alibaba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.alibaba.com/");
            }
        });
        amazon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.amazon.com/");
            }
        });
        ugbazzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.ugbazaar.com/");
            }
        });
        daraz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.daraz.com.np/");
            }
        });
        Bhoj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.bhojdeals.com/");
            }
        });
        foodexpress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://911foodexpress.com/");
            }
        });
       foodmandu.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               gotoUrl("https://foodmandu.com/");
           }
       });
       foodmario.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               gotoUrl("https://foodmario.com/");
           }
       });
       bhoklago.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               gotoUrl("http://www.bhoklagyo.com.np/");
           }
       });

    }

    private void gotoUrl(String s) {
        Uri uri=Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}
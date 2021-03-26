package com.example.smartpay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.smartpay.AddMoney.AddMoneyHistory;
import com.example.smartpay.Movie.MovieTicketPaymentHistory;
import com.example.smartpay.SendMoney.SendMoneyHistory;
import com.example.smartpay.banktransfer.BankTransferHistory;
import com.example.smartpay.buspayment.BusHistory;
import com.example.smartpay.electricitypayment.ElectricityPaymentHistory;
import com.example.smartpay.flightpayment.FlightPaymentHistory;
import com.example.smartpay.hospitalbill.HospitalPaymentHistory;
import com.example.smartpay.hotelpayment.HotelPaymentHistory;
import com.example.smartpay.internet.InternetPaymentHistory;
import com.example.smartpay.landline.LandlinePaymentHistory;
import com.example.smartpay.recharge.RechargePhoneHistory;
import com.example.smartpay.schoolfee.SchoolFeePaymentHisotry;
import com.example.smartpay.tvpayment.TVBillPaymentHistory;

public class History extends AppCompatActivity {

    private TextView sendmoneyhistory, addmoneyhistory, bankhistory, phoneRechargeHistory;
    private TextView ElectricityHistory, hospitalBillPaymentHistory;
    private TextView FlightHistory, BusFarePaymentHistory;
    private TextView TVPaymentHistory, InternetHistory, LandLinePaymentHistory, MoviePaymentHistory;
    private TextView HotelBillHistory, SchoolFeeHistory;
    private ImageView btnbackhistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        sendmoneyhistory = findViewById(R.id.SendmoneyHistory);
        btnbackhistory = findViewById(R.id.backHistory);
        addmoneyhistory = findViewById(R.id.txtAddMoneyHistory);
        bankhistory = findViewById(R.id.txtBankTransferHistory);
        phoneRechargeHistory = findViewById(R.id.txtRechargeHistory);
        ElectricityHistory = findViewById(R.id.txtElectricityHistory);
        hospitalBillPaymentHistory = findViewById(R.id.txtHealthHistory);
        FlightHistory = findViewById(R.id.txtFlightHistory);
        BusFarePaymentHistory = findViewById(R.id.txtBusHistory);
        TVPaymentHistory = findViewById(R.id.txtTVHistory);
        InternetHistory = findViewById(R.id.txtInternetHistory);
        LandLinePaymentHistory = findViewById(R.id.txtLandlineHistory);
        MoviePaymentHistory = findViewById(R.id.txtMovieHistory);
        HotelBillHistory = findViewById(R.id.txtHotelHistory);
        SchoolFeeHistory = findViewById(R.id.txtSchoolHistory);


        btnbackhistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(History.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        sendmoneyhistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(History.this, SendMoneyHistory.class);
                startActivity(intent);
            }
        });

        addmoneyhistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(History.this, AddMoneyHistory.class);
                startActivity(intent);
            }
        });
        bankhistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(History.this, BankTransferHistory.class);
                startActivity(intent);
            }
        });
        phoneRechargeHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(History.this, RechargePhoneHistory.class);
                startActivity(intent);
            }
        });
        ElectricityHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(History.this, ElectricityPaymentHistory.class);
                startActivity(intent);
            }
        });

        hospitalBillPaymentHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(History.this, HospitalPaymentHistory.class);
                startActivity(intent);
            }
        });
        FlightHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(History.this, FlightPaymentHistory.class);
                startActivity(intent);
            }
        });
        BusFarePaymentHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(History.this, BusHistory.class);
                startActivity(intent);
            }
        });
        TVPaymentHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(History.this, TVBillPaymentHistory.class);
                startActivity(intent);
            }
        });
        InternetHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(History.this, InternetPaymentHistory.class);
                startActivity(intent);
            }
        });
        LandLinePaymentHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(History.this, LandlinePaymentHistory.class);
                startActivity(intent);
            }
        });
        MoviePaymentHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(History.this, MovieTicketPaymentHistory.class);
                startActivity(intent);
            }
        });
        HotelBillHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(History.this, HotelPaymentHistory.class);
                startActivity(intent);
            }
        });
        SchoolFeeHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(History.this, SchoolFeePaymentHisotry.class);
                startActivity(intent);
            }
        });
    }
}
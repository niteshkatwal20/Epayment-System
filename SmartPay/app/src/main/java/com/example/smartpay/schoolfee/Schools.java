package com.example.smartpay.schoolfee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.smartpay.MainActivity;
import com.example.smartpay.R;

public class Schools extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schools);

        Button btnback = findViewById(R.id.backSchool);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Schools.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
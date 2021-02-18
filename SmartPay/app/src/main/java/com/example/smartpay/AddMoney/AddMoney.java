package com.example.smartpay.AddMoney;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.smartpay.MainActivity;
import com.example.smartpay.R;
import com.example.smartpay.user.SendOTPActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddMoney extends AppCompatActivity {
    private ImageView btnBackAddMoney;
    private EditText AddMoneyBankName, AddMoneyAccountNumber, AddMoneyAmount, AddMoneyRemarks;
    private LinearLayout BtnAddMoney;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_money);
        btnBackAddMoney = findViewById(R.id.backAdd);
        AddMoneyAccountNumber = findViewById(R.id.edtAddBankAccount);
        AddMoneyBankName = findViewById(R.id.edtAddBankName);
        AddMoneyAmount = findViewById(R.id.edtAddAmount);
        AddMoneyRemarks = findViewById(R.id.edtComment);
        BtnAddMoney = findViewById(R.id.AddMoney);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("AddMoney");

        btnBackAddMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddMoney.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        BtnAddMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddMoneySubmit();
            }
        });


    }

    private void AddMoneySubmit() {
        String addMoneyAccount = AddMoneyAccountNumber.getText().toString().trim();
        String addMoneyBankname = AddMoneyBankName.getText().toString().trim();
        String addMoneyAmount = AddMoneyAmount.getText().toString().trim();
        String addMoneyRemarks = AddMoneyRemarks.getText().toString().trim();
        String id = databaseReference.push().getKey();

        if (addMoneyAccount.isEmpty()) {
            AddMoneyAccountNumber.setError("Please Enter the Account Number!");
            AddMoneyAccountNumber.requestFocus();
            return;
        }
        if (addMoneyBankname.isEmpty()) {
            AddMoneyBankName.setError("Please Enter the Bank Name!");
            AddMoneyBankName.requestFocus();
            return;
        }
        if (addMoneyAmount.isEmpty()) {
            AddMoneyAmount.setError("Please Enter the Amount!");
            AddMoneyAmount.requestFocus();
            return;
        }
        if (addMoneyRemarks.isEmpty()) {
            AddMoneyRemarks.setError("Please Enter the Remarks!");
        }
        if (!TextUtils.isEmpty(addMoneyAmount)) {

            AddMoneyModel add = new AddMoneyModel(id, addMoneyAccount, addMoneyBankname, addMoneyAmount, addMoneyRemarks);
            databaseReference.child(id).setValue(add);

            Intent intent = new Intent(AddMoney.this, SendOTPActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }
}

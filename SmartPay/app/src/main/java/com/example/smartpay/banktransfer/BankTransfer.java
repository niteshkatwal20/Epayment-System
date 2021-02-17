package com.example.smartpay.banktransfer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.smartpay.MainActivity;
import com.example.smartpay.R;
import com.example.smartpay.user.SendOTPActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BankTransfer extends AppCompatActivity {

    private ImageView btnBackBank;
    private EditText edtBankName, edtAccountNo, edtBankAmount, edtBankDepositerName, edtBankDepositerPhone;

    private LinearLayout bankTransfer;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_transfer);

        btnBackBank = findViewById(R.id.backbank);
        edtBankName = findViewById(R.id.edtBankName);
        edtAccountNo = findViewById(R.id.edtAccountNo);
        edtBankAmount = findViewById(R.id.edtBankTransferAmount);
        edtBankDepositerName = findViewById(R.id.edtBankDepositerName);
        edtBankDepositerPhone = findViewById(R.id.edtBankDepositerNumber);
        bankTransfer = findViewById(R.id.Transfer);

        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference("BankTransfer");

        btnBackBank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BankTransfer.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        bankTransfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BankTransferSubmit();
            }
        });
    }

    private void BankTransferSubmit() {

        String bankname = edtBankName.getText().toString().trim();
        String bankaccountno = edtAccountNo.getText().toString().trim();
        String bankamount = edtBankAmount.getText().toString().trim();
        String bankdepositername = edtBankDepositerName.getText().toString().trim();
        String bankdepositernumber = edtBankDepositerPhone.getText().toString().trim();
        String id = reference.push().getKey();


        if (bankname.isEmpty()) {
            edtBankName.setError("Please Enter the Bank Name!");
            edtBankName.requestFocus();
            return;
        }
        if (bankaccountno.isEmpty()) {
            edtAccountNo.setError("Please Enter the Account Number!");
            edtAccountNo.requestFocus();
            return;
        }
        if (bankamount.isEmpty()) {
            edtBankAmount.setError("Please Enter the Amount!");
            edtBankAmount.requestFocus();
            return;
        }
        if (bankdepositername.isEmpty()) {
            edtBankDepositerName.setError("Please Enter the Depositor Name!");
            edtBankDepositerName.requestFocus();
            return;

        }
        if (bankdepositernumber.isEmpty()) {
            edtBankDepositerPhone.setError("Please Enter the Depositor Number!");
            edtBankDepositerPhone.requestFocus();
            return;

        }
        if (bankdepositernumber.length() < 10) {
            edtBankDepositerPhone.setError("Mobile Must be 10 digits");
            edtBankDepositerPhone.requestFocus();
            return;
        }

        if (bankdepositernumber.length() > 10) {
            edtBankDepositerPhone.setError("Mobile Must be 10 digits");
            edtBankDepositerPhone.requestFocus();
            return;
        }

        if (!TextUtils.isEmpty(bankname)) {

            BankTransferModel add = new BankTransferModel(id, bankname, bankaccountno, bankamount, bankdepositername, bankdepositernumber);
            reference.child(id).setValue(add);
            Toast.makeText(this, "Your Transaction has been completed", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(BankTransfer.this, SendOTPActivity.class);
            startActivity(intent);

        } else {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }
}
package com.example.smartpay.schoolfee;

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

public class Schools extends AppCompatActivity {

    private EditText SchoolName, StudentName, SchoolClass, StudentBillAmount, FeeDepositor, FeeDepositorNumber;
    private LinearLayout btnPayFee;

    private FirebaseDatabase database;
    private DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schools);

        Button btnback = findViewById(R.id.backSchool);

        SchoolName = findViewById(R.id.edtSchoolName);
        StudentName = findViewById(R.id.edtStudentName);
        SchoolClass = findViewById(R.id.edtClass);
        StudentBillAmount = findViewById(R.id.edtFeeamount);
        FeeDepositor = findViewById(R.id.edtDepositer);
        FeeDepositorNumber = findViewById(R.id.edtDepNumber);
        btnPayFee = findViewById(R.id.PayFee);

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("SchoolFee");

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Schools.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnPayFee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PaySchoolFee();
            }
        });
    }

    private void PaySchoolFee() {
        String schoolName = SchoolName.getText().toString().trim();
        String studentName = StudentName.getText().toString().trim();
        String studentClass = SchoolClass.getText().toString().trim();
        String billAmount = StudentBillAmount.getText().toString().trim();
        String schooldepname = FeeDepositor.getText().toString().trim();
        String schooldepnum = FeeDepositorNumber.getText().toString().trim();
        String id = reference.push().getKey();

        if (schoolName.isEmpty()) {
            SchoolName.setError("School Name is required!");
            SchoolName.requestFocus();
            return;
        }

        if (studentName.isEmpty()) {
            StudentName.setError("Student Name is requires!");
            StudentName.requestFocus();
            return;
        }
        if (studentClass.isEmpty()) {
            SchoolClass.setError("Class of Student  is required!");
            SchoolClass.requestFocus();
            return;
        }
        if (billAmount.isEmpty()) {
            StudentBillAmount.setError("Please enter the amount");
            StudentBillAmount.requestFocus();
            return;
        }
        if (schooldepname.isEmpty()) {
            FeeDepositor.setError("Please Enter Depositor Name");
            FeeDepositor.requestFocus();
            return;
        }
        if (schooldepnum.isEmpty()) {
            FeeDepositorNumber.setError("Please Enter Depositor Name");
            FeeDepositorNumber.requestFocus();
            return;
        }
        if (schooldepnum.length() < 10) {
            FeeDepositorNumber.setError("Mobile Must be 10 digits");
            FeeDepositorNumber.requestFocus();
            return;
        }

        if (schooldepnum.length() > 10) {
            FeeDepositorNumber.setError("Mobile Must be 10 digits");
            FeeDepositorNumber.requestFocus();
            return;
        }
        if (!TextUtils.isEmpty(studentName)) {
            SchoolModel data = new SchoolModel(id, schoolName, studentName, studentClass, billAmount, schooldepname, schooldepnum);
            reference.child(id).setValue(data);
            Intent intent = new Intent(Schools.this, SendOTPActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }
}
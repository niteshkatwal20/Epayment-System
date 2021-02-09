package com.example.smartpay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartpay.databse.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Profile extends AppCompatActivity {
    private TextView UserName, UserEmailAddress, UserPhoneNumber, UserAddress;
    private LinearLayout Logout;
    private ImageView Back;

    private String userID;
    private FirebaseUser user;
    private DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        UserName = findViewById(R.id.NameUSer);
        UserEmailAddress = findViewById(R.id.EmailUser);
        UserPhoneNumber = findViewById(R.id.PhoneNoUSer);
        UserAddress = findViewById(R.id.AddressUSer);
        Logout = findViewById(R.id.Logout);
        Back = findViewById(R.id.backProfile);

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Profile.this, MainActivity.class));
            }
        });

        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(Profile.this, SignIn.class));
            }
        });

        user=FirebaseAuth.getInstance().getCurrentUser();
        reference= FirebaseDatabase.getInstance().getReference("Users");
        userID=user.getUid();

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userprofile=snapshot.getValue(User.class);
                if (userprofile !=null){
                    String fullname=userprofile.fullname;
                    String email=userprofile.email;
                    String phoneno=userprofile.phoneno;
                    String address=userprofile.address;

                    UserName.setText(fullname);
                    UserEmailAddress.setText(email);
                    UserPhoneNumber.setText(phoneno);
                    UserAddress.setText(address);
                    
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Profile.this, "Something wrong happened", Toast.LENGTH_LONG).show();
            }
        });
    }
}
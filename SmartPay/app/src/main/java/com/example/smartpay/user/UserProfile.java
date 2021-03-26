package com.example.smartpay.user;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartpay.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserProfile extends AppCompatActivity {
    private TextView logout, ProfileName, ProfileEmail, ProfileAddress, ProfilePhoneNo;
    private FirebaseUser user;
    private DatabaseReference reference;
    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        logout = findViewById(R.id.btnUserLogout);
        ProfileAddress = findViewById(R.id.ProfileAddress);
        ProfileName = findViewById(R.id.ProfileFullname);
        ProfileEmail = findViewById(R.id.ProfileEmail);
        ProfilePhoneNo = findViewById(R.id.ProfilePhoneno);


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(UserProfile.this, SignIn.class));
            }
        });
        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userID = user.getUid();

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile = snapshot.getValue(User.class);
                if (userProfile != null) {
                    String fullname = userProfile.fullname;
                    String email = userProfile.email;
                    String phoneno = userProfile.phoneno;
                    String address = userProfile.address;

                    ProfileName.setText(fullname);
                    ProfileAddress.setText(address);
                    ProfileEmail.setText(email);
                    ProfilePhoneNo.setText(phoneno);
                    
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UserProfile.this, "SomethingWrong Happened", Toast.LENGTH_LONG).show();
            }
        });
    }

}
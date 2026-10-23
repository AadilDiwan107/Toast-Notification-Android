package com.example.myapplication;

import android.app.NotificationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class ProfileActivity extends AppCompatActivity {

    TextView tvProfileInfo;
    Button btnConfirmProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tvProfileInfo = findViewById(R.id.tvProfileInfo);
        btnConfirmProfile = findViewById(R.id.btnConfirmProfile);

        // Retrieve the data passed from MainActivity
        String name = getIntent().getStringExtra("NAME");
        String mobile = getIntent().getStringExtra("MOBILE");
        String username = getIntent().getStringExtra("USERNAME");

        // Display the data
        String profileText = "Name: " + name + "\nMobile: " + mobile + "\nUsername: " + username;
        tvProfileInfo.setText(profileText);

        btnConfirmProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1. Show the Toast
                Toast.makeText(ProfileActivity.this, "Profile successfully created for " + name + "!", Toast.LENGTH_LONG).show();

                // 2. Show the Notification
                NotificationCompat.Builder mbuilder = new NotificationCompat.Builder(getApplicationContext(), "channel_id")
                        .setSmallIcon(R.drawable.notification)
                        .setContentTitle("Profile Created")
                        .setContentText("Success! Your profile is created for " + username + " is ready.");

                // Use ID 1 here so it doesn't overwrite your test notification from MainActivity
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(1, mbuilder.build());
            }
        });
    }
}
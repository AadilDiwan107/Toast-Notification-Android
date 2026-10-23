package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editName, editMobile, editUsername;
    Button btnGoToProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.editName);
        editMobile = findViewById(R.id.editMobile);
        editUsername = findViewById(R.id.editUsername);
        btnGoToProfile = findViewById(R.id.btnGoToProfile);

        btnGoToProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString();
                String mobile = editMobile.getText().toString();
                String username = editUsername.getText().toString();

                // Intent to move to the new ProfileActivity
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                intent.putExtra("NAME", name);
                intent.putExtra("MOBILE", mobile);
                intent.putExtra("USERNAME", username);
                startActivity(intent);
            }
        });
    }
}
package com.example.app2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class groups extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.groups);

        // Find your buttons by ID
        ImageButton homeButton = findViewById(R.id.home);
        ImageButton searchButton = findViewById(R.id.search);
        ImageButton groupsButton = findViewById(R.id.groups);
        ImageButton notificationButton = findViewById(R.id.notification);
        ImageButton messageButton = findViewById(R.id.message);

        // Set OnClickListener for each button


        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(groups.this, search.class);
                startActivity(intent);
                // Add your code here for the home button action
            }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the SearchActivity
                Intent intent = new Intent(groups.this, search.class);
                startActivity(intent);
            }
        });

        groupsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the GroupsActivity
                Intent intent = new Intent(groups.this, groups.class);
                startActivity(intent);
            }
        });

        notificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the NotificationsActivity
                Intent intent = new Intent(groups.this, notifications.class);
                startActivity(intent);
            }
        });

        messageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the MessageActivity
                Intent intent = new Intent(groups.this, message.class);
                startActivity(intent);
            }
        });
    }


}


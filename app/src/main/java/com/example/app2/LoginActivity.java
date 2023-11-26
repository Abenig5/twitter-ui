package com.example.app2;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private static EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.x_login);
        editText = findViewById(R.id.username);
        findViewById(R.id.close_activity_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        findViewById(R.id.next_to_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredUserName = editText.getText().toString();
                Intent intent = new Intent(LoginActivity.this, LoginPasswordActivity.class);
                intent.putExtra("Username", enteredUserName);
                startActivity(intent);
            }
        });


    }
}
package com.example.app2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginPasswordActivity extends AppCompatActivity {
    private EditText targetEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.x_login_authentication);

        targetEditText = findViewById(R.id.user_name);
        String enteredUserName = getIntent().getStringExtra("Username");
        targetEditText.setText(enteredUserName);

        findViewById(R.id.to_x).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginPasswordActivity.this, twitter.class);
                startActivity(intent);
            }
        });


        findViewById(R.id.close_activity_login_password).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}

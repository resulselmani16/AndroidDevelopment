package com.cacttuseducation_21_22.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.cacttuseducation_21_22.R;

public class TestingActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing);

        textView = findViewById(R.id.testingTx);
        textView.setText("Your country is: " + getIntent().getStringExtra("country"));
    }
}
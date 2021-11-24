package com.cacttuseducation_21_22.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.cacttuseducation_21_22.R;

public class CompanyDetailActivity extends AppCompatActivity {

    TextView tvCompanyDetailName, tvCompanyDetailValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_detail);
        tvCompanyDetailName = findViewById(R.id.tvCompanyDetailName);
        tvCompanyDetailValue = findViewById(R.id.tvCompanyDetailValue);
        Intent intent = getIntent();
        String companyName = intent.getStringExtra("companyName");
        String companyValue = intent.getStringExtra("companyValue");
        tvCompanyDetailName.setText(companyName);
        tvCompanyDetailValue.setText(companyValue);
    }
}
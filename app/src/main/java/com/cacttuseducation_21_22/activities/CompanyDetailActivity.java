package com.cacttuseducation_21_22.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.cacttuseducation_21_22.R;
import com.cacttuseducation_21_22.models.Company;

import java.io.Serializable;

public class CompanyDetailActivity extends AppCompatActivity {
    TextView tvCompanyDetailName, tvCompanyDetailValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_detail);
        tvCompanyDetailName = findViewById(R.id.tvCompanyDetailName);
        tvCompanyDetailValue= findViewById(R.id.tvCompanyDetailValue);
        Intent intent = getIntent();
        Company company = (Company)intent.getSerializableExtra("company");
        tvCompanyDetailName.setText(company.getCompanyName());
        tvCompanyDetailValue.setText(company.getCompanyValue());
    }
}
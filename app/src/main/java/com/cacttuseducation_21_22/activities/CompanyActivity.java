package com.cacttuseducation_21_22.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.cacttuseducation_21_22.R;
import com.cacttuseducation_21_22.adapters.CompanyAdapter;
import com.cacttuseducation_21_22.models.Company;

import java.util.ArrayList;

public class CompanyActivity extends AppCompatActivity {
    GridView gridView;
    ArrayList<Company> arrayList = new ArrayList<>();
    CompanyAdapter companyAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);
        gridView = findViewById(R.id.gridView);
        populateArrayList();
        companyAdapter = new CompanyAdapter(CompanyActivity.this, arrayList);
        gridView.setAdapter(companyAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(CompanyActivity.this, CompanyDetailActivity.class);
                Company company = arrayList.get(i);
                intent.putExtra("companyName", company.getCompanyName());
                intent.putExtra("companyValue", company.getCompanyValue());
                startActivity(intent);
            }
        });
    }


    private void populateArrayList() {
        arrayList.add(new Company(R.mipmap.ic_launcher_round, "Samsung", "$150k"));
        arrayList.add(new Company(R.mipmap.ic_launcher_round, "Apple", "$200k"));
        arrayList.add(new Company(R.mipmap.ic_launcher_round, "Xiaomi", "$120k"));
        arrayList.add(new Company(R.mipmap.ic_launcher_round, "Siemens", "$110k"));
        arrayList.add(new Company(R.mipmap.ic_launcher_round, "Motorola", "$100k"));
        arrayList.add(new Company(R.mipmap.ic_launcher_round, "Lenovo", "$170k"));
        arrayList.add(new Company(R.mipmap.ic_launcher_round, "Huawei", "$150k"));
        arrayList.add(new Company(R.mipmap.ic_launcher_round, "Samsung", "$150k"));
        arrayList.add(new Company(R.mipmap.ic_launcher_round, "Xiaomi", "$120k"));
        arrayList.add(new Company(R.mipmap.ic_launcher_round, "Siemens", "$110k"));


    }
}
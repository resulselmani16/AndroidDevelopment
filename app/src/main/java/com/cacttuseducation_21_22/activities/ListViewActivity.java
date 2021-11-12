package com.cacttuseducation_21_22.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.cacttuseducation_21_22.R;

public class ListViewActivity extends AppCompatActivity {

    ListView listView;
    String countryList[] = {"Kosovo", "Italy", "Germany", "Anglia", "Japonia", "Kosovo",
            "Italy", "Germany", "Anglia", "Japonia",
            "Kosovo", "Italy", "Germany", "Anglia", "Japonia"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        listView = findViewById(R.id.listView);
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countryList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListViewActivity.this, "Shteti qe keni klikuar eshte: " + countryList[i], Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ListViewActivity.this, TestingActivity.class);
                intent.putExtra("country", countryList[i]);
                startActivity(intent);
            }
        });

    }
}
package com.cacttuseducation_21_22.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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

    }
}
package com.cacttuseducation_21_22.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.cacttuseducation_21_22.R;


public class ListViewActivity extends Activity {

    ListView listView;
    String countryList[] = {"Kosova", "Italia", "Gjermania", "Anglia",
            "Kina","Italia", "Gjermania", "Anglia", "Kina","Kina","Italia",
            "Gjermania", "Anglia", "Kina"};

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
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewActivity.this, "Shteti i klikuar eshte: "
                        + countryList[position] , Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ListViewActivity.this, ListViewDetailsActivity.class);
                intent.putExtra("countryKey",countryList[position]);
                startActivity(intent);
            }
        });

    }
}
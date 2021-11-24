package com.cacttuseducation_21_22.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.cacttuseducation_21_22.R;
import com.cacttuseducation_21_22.adapters.WeatherAdapter;
import com.cacttuseducation_21_22.models.Weather;
import com.cacttuseducation_21_22.util.Util;

import java.util.ArrayList;

public class WeatherActivity extends AppCompatActivity {

    ListView weatherListView;
    ArrayList<Weather> weatherArrayList = new ArrayList<>();
    WeatherAdapter weatherAdapter;
    Button btnAddCity, btnSubmit, btnYes, btnNo;
    RelativeLayout popup, relConfirmPopup;
    EditText etCity, etTemperature, etStatus;
    int positionClicked = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        findViews();
        populateArrayList();
        onClicks();
        weatherAdapter = new WeatherAdapter(WeatherActivity.this, weatherArrayList);
        weatherListView.setAdapter(weatherAdapter);
        View headerView = ((LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE)).inflate(R.layout.header, null, false);
        weatherListView.addHeaderView(headerView);
    }

    private void onClicks() {
        btnAddCity.setOnClickListener(v -> {
            popup.setVisibility(View.VISIBLE);
        });

        btnSubmit.setOnClickListener(v ->{
            if(etCity.length() > 0 && etStatus.length() > 0 && etTemperature.length() > 0){
                popup.setVisibility(View.GONE);
                String city = etCity.getText().toString();
                String status = etStatus.getText().toString();
                String temperature = etTemperature.getText().toString() + getString(R.string.grade_celcius);
                weatherArrayList.add(0, new Weather(R.mipmap.ic_launcher, city, status, temperature));

                weatherAdapter.notifyDataSetChanged();

                etCity.getText().clear();
                etTemperature.getText().clear();
                etStatus.getText().clear();

                Util.hideKeyboard(WeatherActivity.this, etCity);
            } else{
                Toast.makeText(WeatherActivity.this, getString(R.string.please_fill_all_the_fields), Toast.LENGTH_SHORT).show();
            }
        });

        weatherListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        weatherListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                relConfirmPopup.setVisibility(View.VISIBLE);
                positionClicked = i - 1;
                return false;
            }
        });

        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                relConfirmPopup.setVisibility(View.GONE);
            }
        });
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                relConfirmPopup.setVisibility(View.GONE);
                weatherArrayList.remove(positionClicked);
                weatherAdapter.notifyDataSetChanged();
            }
        });
    }

    private void populateArrayList() {
        weatherArrayList.add(new Weather(R.mipmap.ic_launcher, "Prishtine", "Raining", "3°C"));
        weatherArrayList.add(new Weather(R.mipmap.ic_launcher, "Mitrovice", "Sunny", "13°C"));
        weatherArrayList.add(new Weather(R.mipmap.ic_launcher, "Peje", "Cloudy", "8°C"));
        weatherArrayList.add(new Weather(R.mipmap.ic_launcher, "Gjilan", "Raining", "4°C"));
        weatherArrayList.add(new Weather(R.mipmap.ic_launcher, "Gjakova", "Raining", "5°C"));
        weatherArrayList.add(new Weather(R.mipmap.ic_launcher, "Decani", "Raining", "3°C"));
        weatherArrayList.add(new Weather(R.mipmap.ic_launcher, "Lipjani", "Cloudy", "5°C"));
        weatherArrayList.add(new Weather(R.mipmap.ic_launcher, "Podujeve", "Raining", "4°C"));
        weatherArrayList.add(new Weather(R.mipmap.ic_launcher, "Drenasi", "Sunny", "10°C"));
        weatherArrayList.add(new Weather(R.mipmap.ic_launcher, "Prizren", "Sunny", "9°C"));

    }

    private void findViews() {
        weatherListView = findViewById(R.id.weatherListView);
        btnAddCity = findViewById(R.id.btnAddCity);
        popup = findViewById(R.id.relAddCityPopup);
        etCity = findViewById(R.id.etCity);
        etTemperature = findViewById(R.id.etTemperature);
        etStatus = findViewById(R.id.etStatus);
        btnSubmit = findViewById(R.id.btnSubmit);
        relConfirmPopup = findViewById(R.id.relConfirmPopup);
        btnYes = findViewById(R.id.btnYes);
        btnNo = findViewById(R.id.btnNo);
    }
}
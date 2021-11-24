package com.cacttuseducation_21_22.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cacttuseducation_21_22.R;
import com.cacttuseducation_21_22.models.Weather;

import java.util.ArrayList;

public class WeatherAdapter extends BaseAdapter {

    Context context;
    ArrayList<Weather> arrayList;
    LayoutInflater inflater;

    public WeatherAdapter(Context context, ArrayList<Weather> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        inflater = (LayoutInflater.from(context));
    }


    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.weather_item, null);

        ImageView ivWeatherIcon = view.findViewById(R.id.weatherIcon);
        TextView tvCity = view.findViewById(R.id.tvCity);
        TextView tvStatus = view.findViewById(R.id.tvStatus);
        TextView tvTemperature = view.findViewById(R.id.tvTemperature);

        Weather weather = arrayList.get(i);

        ivWeatherIcon.setImageResource(weather.getWeatherImage());
        tvCity.setText(weather.getCity());
        tvStatus.setText(weather.getStatus());
        tvTemperature.setText(weather.getTemperature());


        return view;
    }
}

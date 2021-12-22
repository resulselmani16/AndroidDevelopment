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
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.weather_item, null);

        ImageView ivWeatherIcon = convertView.findViewById(R.id.ivWeatherIcon);
        TextView tvCity = convertView.findViewById(R.id.tvCity);
        TextView tvStatus = convertView.findViewById(R.id.tvStatus);
        TextView tvTemperature = convertView.findViewById(R.id.tvTemperature);

        Weather weather = arrayList.get(position);

        ivWeatherIcon.setImageResource(weather.getWeatherImage());
        tvCity.setText(weather.getCity());
        tvStatus.setText(weather.getStatus());
        tvTemperature.setText(weather.getTemperature());

        return convertView;
    }
}

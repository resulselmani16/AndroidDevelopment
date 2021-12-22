package com.cacttuseducation_21_22.models;

public class Weather {
    private int weatherImage;
    private String city;
    private String status;
    private String temperature;

    public Weather(int weatherImage, String city, String status, String temperature) {
        this.weatherImage = weatherImage;
        this.city = city;
        this.status = status;
        this.temperature = temperature;
    }

    public int getWeatherImage() {
        return weatherImage;
    }

    public String getCity() {
        return city;
    }

    public String getStatus() {
        return status;
    }

    public String getTemperature() {
        return temperature;
    }
}

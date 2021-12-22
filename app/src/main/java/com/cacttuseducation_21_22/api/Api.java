package com.cacttuseducation_21_22.api;

import com.cacttuseducation_21_22.models.Hero;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL = "https://simplifiedcoding.net/demos/";

    @GET("marvel")
    Call<ArrayList<Hero>> getHeroes();


}

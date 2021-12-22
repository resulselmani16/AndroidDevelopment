package com.cacttuseducation_21_22.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.cacttuseducation_21_22.R;
import com.cacttuseducation_21_22.adapters.HeroesAdapter;
import com.cacttuseducation_21_22.api.Api;
import com.cacttuseducation_21_22.models.Hero;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HeroesActivity extends AppCompatActivity {

    ListView heroesListView;
    ArrayList<Hero> heroesArrayList = new ArrayList<>();
    HeroesAdapter heroesAdapter;
    ProgressBar progressBar;
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroes);
        heroesListView = findViewById(R.id.heroesListView);
        progressBar = findViewById(R.id.progressBar);
        swipeRefreshLayout = findViewById(R.id.swipeRefresh);


        if (hasInternetConnectivity()) {
            makeApiCallAndLoadDataIntoListView();
        }else {
            progressBar.setVisibility(View.GONE);
            Toast.makeText(HeroesActivity.this, "No internet connection!", Toast.LENGTH_SHORT).show();
        }

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                makeApiCallAndLoadDataIntoListView();
            }
        });
    }

    private void makeApiCallAndLoadDataIntoListView() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<ArrayList<Hero>> call = api.getHeroes();

        call.enqueue(new Callback<ArrayList<Hero>>() {
            @Override
            public void onResponse(Call<ArrayList<Hero>> call, Response<ArrayList<Hero>> response) {

                if (response.body() != null && response.body().size()>0){
                    heroesArrayList = response.body();
                    heroesAdapter = new HeroesAdapter(HeroesActivity.this, heroesArrayList);
                    heroesListView.setAdapter(heroesAdapter);
                    progressBar.setVisibility(View.GONE);
                    swipeRefreshLayout.setRefreshing(false);
                }else {
                    Toast.makeText(HeroesActivity.this, "Datas are null or empty", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Hero>> call, Throwable t) {
                Toast.makeText(HeroesActivity.this,
                        "Something went wrong with error: " + t.getLocalizedMessage(),
                        Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);

            }
        });
    }

    boolean hasInternetConnectivity(){
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnectedOrConnecting());
    }
}
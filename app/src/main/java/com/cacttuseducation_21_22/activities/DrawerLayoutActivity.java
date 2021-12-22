package com.cacttuseducation_21_22.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cacttuseducation_21_22.R;
import com.cacttuseducation_21_22.fragments.FirstFragment;
import com.cacttuseducation_21_22.fragments.SecondFragment;

public class DrawerLayoutActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ImageView ivOpenMenu;
    TextView tvFirstFragment, tvSecondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_layout);
        findViews();
        onClicks();
        loadFragment(new FirstFragment());
    }

    private void onClicks() {
        ivOpenMenu.setOnClickListener(v -> {
            drawerLayout.openDrawer(GravityCompat.START);
        });
        tvFirstFragment.setOnClickListener(v -> {
            loadFragment(new FirstFragment());
            drawerLayout.closeDrawer(GravityCompat.START);
        });
        tvSecondFragment.setOnClickListener(v -> {
            loadFragment(new SecondFragment());
            drawerLayout.closeDrawer(GravityCompat.START);
        });
    }

    private void findViews() {
        drawerLayout = findViewById(R.id.drawerLayout);
        ivOpenMenu = findViewById(R.id.ivMenu);
        tvFirstFragment = findViewById(R.id.tvFirstFragment);
        tvSecondFragment = findViewById(R.id.tvSecondFragment);
    }

    private void loadFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        //fragment transaction for add, replace, remove fragments
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.relFragmentContainer, fragment);
        //save the changes
        fragmentTransaction.commit();
    }
}
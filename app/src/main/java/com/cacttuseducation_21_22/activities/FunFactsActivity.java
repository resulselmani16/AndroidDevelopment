package com.cacttuseducation_21_22.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cacttuseducation_21_22.R;
import com.cacttuseducation_21_22.models.ColorBook;
import com.cacttuseducation_21_22.models.FactBook;

public class FunFactsActivity extends AppCompatActivity {

    TextView fact;
    Button btnShowAnotherFunFact;
    RelativeLayout relBackground;

    FactBook factBook = new FactBook();
    ColorBook colorBook = new ColorBook();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);
        findViews();
        onClickListeners();
}

    private void onClickListeners() {

        btnShowAnotherFunFact.setOnClickListener(v -> {
            String newFact = factBook.getFact();
            fact.setText(newFact);

            int color = colorBook.getColor();
            relBackground.setBackgroundColor(color);
            btnShowAnotherFunFact.setTextColor(color);
        });
    }

    private void findViews() {
        fact = findViewById(R.id.fact);
        btnShowAnotherFunFact = findViewById(R.id.btnShowAnotherFunFact);
        relBackground = findViewById(R.id.relBackground);
    }
}
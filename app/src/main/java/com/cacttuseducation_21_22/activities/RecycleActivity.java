package com.cacttuseducation_21_22.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.cacttuseducation_21_22.R;
import com.cacttuseducation_21_22.adapters.RvAdapter;
import com.cacttuseducation_21_22.models.RvModel;

public class RecycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);

        RvModel[] myListData = new RvModel[] {
                new RvModel("Email", android.R.drawable.ic_dialog_email),
                new RvModel("Info", android.R.drawable.ic_dialog_info),
                new RvModel("Delete", android.R.drawable.ic_delete),
                new RvModel("Dialer", android.R.drawable.ic_dialog_dialer),
                new RvModel("Alert", android.R.drawable.ic_dialog_alert),
                new RvModel("Map", android.R.drawable.ic_dialog_map),
                new RvModel("Email", android.R.drawable.ic_dialog_email),
                new RvModel("Info", android.R.drawable.ic_dialog_info),
                new RvModel("Delete", android.R.drawable.ic_delete),
                new RvModel("Dialer", android.R.drawable.ic_dialog_dialer),
                new RvModel("Alert", android.R.drawable.ic_dialog_alert),
                new RvModel("Map", android.R.drawable.ic_dialog_map),
        };

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RvAdapter adapter = new RvAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);
    }
}
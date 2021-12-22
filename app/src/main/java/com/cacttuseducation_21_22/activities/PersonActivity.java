package com.cacttuseducation_21_22.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.cacttuseducation_21_22.R;
import com.cacttuseducation_21_22.adapters.PersonAdapter;
import com.cacttuseducation_21_22.models.Person;

import java.util.ArrayList;

public class PersonActivity extends Activity {

    ListView personListView;
    ArrayList<Person> arrayList = new ArrayList<>();
    PersonAdapter personAdapter;
    ImageView ivBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        personListView = findViewById(R.id.personListView);
        ivBack = findViewById(R.id.ivBack);

        populateArrayList();
        personAdapter = new PersonAdapter(PersonActivity.this,arrayList);
        personListView.setAdapter(personAdapter);

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void populateArrayList() {
        arrayList.add(new Person("Viktor Ahmeti",1,22,R.mipmap.ic_launcher));
        arrayList.add(new Person("Benjamin Mustafa",2,20,R.mipmap.ic_launcher));
        arrayList.add(new Person("Resul Selmani",3,20,R.mipmap.ic_launcher));
        arrayList.add(new Person("Dion Bajraktari",4,20,R.mipmap.ic_launcher));
        arrayList.add(new Person("En Gashi",5,20,R.mipmap.ic_launcher));
        arrayList.add(new Person("Rrezarta Krasniqi",6,20,R.mipmap.ic_launcher));
        arrayList.add(new Person("Rion Hasolli",7,20,R.mipmap.ic_launcher));
        arrayList.add(new Person("Elona Beka",8,20,R.mipmap.ic_launcher));
        arrayList.add(new Person("Bleart Berisha",9,20,R.mipmap.ic_launcher));
        arrayList.add(new Person("Hasan Bajrami",10,20,R.mipmap.ic_launcher));
        arrayList.add(new Person("Shkelqim Hoxha",11,20,R.mipmap.ic_launcher));
        arrayList.add(new Person("Ensar Hoxha",12,20,R.mipmap.ic_launcher));
    }
}
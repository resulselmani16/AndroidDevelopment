package com.cacttuseducation_21_22.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.cacttuseducation_21_22.R;
import com.cacttuseducation_21_22.adapters.PersonAdapter;
import com.cacttuseducation_21_22.models.Person;

import java.util.ArrayList;

public class PersonActivity extends Activity {
    ListView personListView;
    ArrayList<Person> arrayList = new ArrayList<>();
    PersonAdapter personAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        personListView = findViewById(R.id.personListView);
        
        populateArrayList();
        personAdapter = new PersonAdapter(PersonActivity.this, arrayList);
        personListView.setAdapter(personAdapter);
    }

    private void populateArrayList() {
        arrayList.add(new Person("Resul Selmani", 1, 19, R.mipmap.ic_launcher));
        arrayList.add(new Person("Benjamin Mustafa", 2, 28, R.mipmap.ic_launcher));
        arrayList.add(new Person("Rion Hasolli", 3, 19, R.mipmap.ic_launcher));
        arrayList.add(new Person("Rezarta Krasniqi", 4, 19, R.mipmap.ic_launcher));
        arrayList.add(new Person("Elona Beka", 5, 19, R.mipmap.ic_launcher));
        arrayList.add(new Person("Ensar Hoxha", 6, 19, R.mipmap.ic_launcher));
        arrayList.add(new Person("Viktor Ahmeti", 7, 20, R.mipmap.ic_launcher));
        arrayList.add(new Person("Dion Bajraktari", 8, 20, R.mipmap.ic_launcher));
        arrayList.add(new Person("Bleart Berisha", 9, 20, R.mipmap.ic_launcher));
        arrayList.add(new Person("Hasan Bajrami", 10, 20, R.mipmap.ic_launcher));
        arrayList.add(new Person("Shkelqim Hoxha", 11, 23, R.mipmap.ic_launcher));
    }
}
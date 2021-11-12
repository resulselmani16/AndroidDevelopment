package com.cacttuseducation_21_22.adapters;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cacttuseducation_21_22.R;
import com.cacttuseducation_21_22.models.Person;

import java.util.ArrayList;

public class PersonAdapter extends BaseAdapter {

    Context context;
    ArrayList<Person> personArrayList = new ArrayList<Person>();
    LayoutInflater inflater;

    public PersonAdapter(Context context, ArrayList<Person> arrayList){
        this.context = context;
        this.personArrayList = arrayList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return personArrayList.size();
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
        view = inflater.inflate(R.layout.person_item, null);

        TextView tvPersonName = view.findViewById(R.id.tvPersonName);
        TextView tvId = view.findViewById(R.id.tvPersonId);
        TextView tvAge = view.findViewById(R.id.tvPersonAge);
        ImageView ivPerson = view.findViewById(R.id.ivPerson);
        Person person = personArrayList.get(i);

        tvPersonName.setText(person.getName());
        tvId.setText("ID: " + person.getId());
        tvAge.setText("Age: " + person.getAge());
        ivPerson.setImageResource(person.getImage());
        return view;
    }
}

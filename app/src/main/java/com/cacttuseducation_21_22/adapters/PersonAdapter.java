package com.cacttuseducation_21_22.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cacttuseducation_21_22.R;
import com.cacttuseducation_21_22.models.Person;

import java.util.ArrayList;

public class PersonAdapter extends BaseAdapter {
    Context context;
    ArrayList<Person> personArrayList = new ArrayList<>();
    LayoutInflater inflater;

    public PersonAdapter(Context context, ArrayList<Person> arrayList){
        this.context = context;
        this.personArrayList = arrayList;
        inflater = (LayoutInflater.from(context));
    }


    @Override
    public int getCount() {
        return personArrayList.size();
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
        convertView = inflater.inflate(R.layout.person_item,null);

        TextView tvPersonName = convertView.findViewById(R.id.tvPersonName);
        TextView tvId = convertView.findViewById(R.id.tvPersonId);
        TextView tvAge = convertView.findViewById(R.id.tvPersonAge);
        ImageView ivPerson = convertView.findViewById(R.id.ivPerson);

        Person person = personArrayList.get(position);

        tvPersonName.setText(person.getName());
        tvId.setText("ID: " + person.getId() + "");
        tvAge.setText("Age: " + person.getAge() + "");
        ivPerson.setImageResource(person.getImage());

        return convertView;
    }
}

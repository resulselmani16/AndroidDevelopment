package com.cacttuseducation_21_22.fragments;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cacttuseducation_21_22.R;
import com.cacttuseducation_21_22.models.Hero;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HeroesAdapter extends BaseAdapter {

    Context context;
    ArrayList<Hero> arrayList;
    LayoutInflater layoutInflater;

    public HeroesAdapter(Context context, ArrayList<Hero> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return arrayList.size();
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
        view = layoutInflater.inflate(R.layout.hero_item, null);

        ImageView ivHero = view.findViewById(R.id.ivHero);
        TextView tvHeroName = view.findViewById(R.id.tvHeroName);
        TextView tvHeroRealName = view.findViewById(R.id.tvHeroRealName);

        Hero hero = arrayList.get(i);

        Picasso.get().load(hero.getImageurl()).placeholder(R.mipmap.ic_launcher).into(ivHero);

        tvHeroName.setText("Name: " + hero.getName());
        tvHeroRealName.setText("Real Name: " + hero.getRealname());


        return view;
    }
}

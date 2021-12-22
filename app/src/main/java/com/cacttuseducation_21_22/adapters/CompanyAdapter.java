package com.cacttuseducation_21_22.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cacttuseducation_21_22.R;
import com.cacttuseducation_21_22.models.Company;

import java.util.ArrayList;

public class CompanyAdapter extends BaseAdapter {

    Context context;
    ArrayList<Company> arrayList;
    LayoutInflater inflater;

    public CompanyAdapter(Context context, ArrayList<Company> arrayList){
        this.context = context;
        this.arrayList = arrayList;
        inflater = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return arrayList.size();
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
        convertView = inflater.inflate(R.layout.item_company,null);

        ImageView ivCompany = convertView.findViewById(R.id.ivCompany);
        TextView tvCompanyName = convertView.findViewById(R.id.tvCompanyName);
        TextView tvCompanyValue = convertView.findViewById(R.id.tvCompanyValue);

        Company company = arrayList.get(position);

        ivCompany.setImageResource(company.getCompanyImage());
        tvCompanyName.setText(company.getCompanyName());
        tvCompanyValue.setText(company.getCompanyValue());

        return convertView;
    }
}

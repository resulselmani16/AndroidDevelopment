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

import org.w3c.dom.Text;

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
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.item_company, null);
        ImageView ivCompany = view.findViewById(R.id.ivCompany);
        TextView tvCompanyName = view.findViewById(R.id.tvCompanyName);
        TextView tvCompanyValue = view.findViewById(R.id.tvCompanyValue);

        Company company = arrayList.get(i);
        ivCompany.setImageResource(company.getCompanyImage());
        tvCompanyName.setText(company.getCompanyName());
        tvCompanyValue.setText(company.getCompanyValue());
        return view;
    }
}

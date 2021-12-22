package com.cacttuseducation_21_22.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cacttuseducation_21_22.R;
import com.cacttuseducation_21_22.models.RvModel;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder> {

    private RvModel[] listdata;

    public RvAdapter(RvModel[] listdata) {
        this.listdata = listdata;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.recyclerview_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final RvModel myListData = listdata[position];
        holder.textView.setText(listdata[position].getTitle());
        holder.imageView.setImageResource(listdata[position].getImage());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"click on item: "+myListData.getTitle(),Toast.LENGTH_LONG).show();
            }
        });

        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return listdata.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.ivIcon);
            this.textView = (TextView) itemView.findViewById(R.id.tvTitle);
        }
    }
}

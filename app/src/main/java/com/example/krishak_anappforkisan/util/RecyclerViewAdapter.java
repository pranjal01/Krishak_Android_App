package com.example.krishak_anappforkisan.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.example.krishak_anappforkisan.R;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context context;
    private List<ItemRow> itemList;

    public RecyclerViewAdapter(List<ItemRow> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ItemRow item = itemList.get(position);
        holder.title.setText(item.getTitle());
        holder.id.setText(item.getDesc());
        holder.price.setText("Replacement of " + "\"" + item.getConnectedWith().toUpperCase() + "\"");
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, id, price;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            id = (TextView) view.findViewById(R.id.ids);
            price = (TextView) view.findViewById(R.id.price);
        }
    }
}
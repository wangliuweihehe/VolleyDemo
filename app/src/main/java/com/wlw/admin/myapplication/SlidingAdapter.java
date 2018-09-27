package com.wlw.admin.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SlidingAdapter extends RecyclerView.Adapter<SlidingAdapter.SlidingHolder> {
    private List<String> data;

    public SlidingAdapter() {
        this.data = new ArrayList<>();
        for (int i = 0; i < 16; i++)
            data.add("item" + i + "name");
    }

    @NonNull
    @Override
    public SlidingHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new SlidingHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_card, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SlidingHolder slidingHolder, int i) {
        slidingHolder.itemName.setText(data.get(i));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class SlidingHolder extends RecyclerView.ViewHolder {
        private TextView itemName;

        public SlidingHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.tv_item_name);
        }
    }
}

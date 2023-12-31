package com.gambelingapp.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gambelingapp.R;

import java.util.ArrayList;

class itemAdapter extends RecyclerView.Adapter<itemHolder>{
    ArrayList<String> itemNames;
    ArrayList<Integer> itemImages;
    ArrayList<String> itemPrices;

    public itemAdapter(ArrayList<String> itemNames, ArrayList<Integer> itemImages, ArrayList<String> itemPrices) {
        this.itemNames=itemNames;
        this.itemImages=itemImages;
        this.itemPrices=itemPrices;
    }

    @NonNull
    @Override
    public itemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pizza_item, parent, false);
        return new itemHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull itemHolder holder, int position) {
        int realPos = position % itemImages.size();
        holder.namesList.setText(itemNames.get(realPos));
        holder.imagesList.setImageResource(itemImages.get(realPos));
        holder.pricesList.setText(itemPrices.get(realPos));
    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }
}
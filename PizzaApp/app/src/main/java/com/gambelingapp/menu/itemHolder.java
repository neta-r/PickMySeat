package com.gambelingapp.menu;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gambelingapp.R;

class itemHolder extends RecyclerView.ViewHolder{
    TextView namesList;
    ImageView imagesList;

    TextView pricesList;

    public itemHolder(@NonNull View itemView) {
        super(itemView);
        this.namesList =itemView.findViewById(R.id.itemName);
        this.imagesList = itemView.findViewById(R.id.itemImage);
        this.pricesList = itemView.findViewById(R.id.itemPrice);
    }
}
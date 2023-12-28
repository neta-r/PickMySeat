package com.gambelingapp.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gambelingapp.R;

import java.util.ArrayList;

class pizzaAdapter extends RecyclerView.Adapter<pizzaAdapter.pizzaHolder>{
    ArrayList<String> pizzaNames;
    ArrayList<Integer> pizzaImages;
    public pizzaAdapter(ArrayList<String> pizzaNames, ArrayList<Integer> pizzaImages) {
        this.pizzaNames=pizzaNames;
        this.pizzaImages=pizzaImages;
    }

    @NonNull
    @Override
    public pizzaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pizza_item, parent, false);
        return new pizzaHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull pizzaHolder holder, int position) {
        holder.pizzaName.setText(pizzaNames.get(position));
        holder.pizzaImage.setImageResource(pizzaImages.get(position));
    }

    @Override
    public int getItemCount() {
        return pizzaNames.size();
    }

    class pizzaHolder extends RecyclerView.ViewHolder{
        TextView pizzaName;
        ImageView pizzaImage;

        public pizzaHolder(@NonNull View itemView) {
            super(itemView);
            this.pizzaName =itemView.findViewById(R.id.pizzaName);
            this.pizzaImage = itemView.findViewById(R.id.pizzaImage);
        }
    }
}
package com.gambelingapp.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gambelingapp.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

class pizzaAdapter extends RecyclerView.Adapter<pizzaAdapter.pizzaHolder>{
    ArrayList<String> pizzaNames;
    ArrayList<Integer> pizzaImages;
    ArrayList<String> pizzaPrices;

    public pizzaAdapter(ArrayList<String> pizzaNames, ArrayList<Integer> pizzaImages, ArrayList<String> pizzaPrices) {
        this.pizzaNames=pizzaNames;
        this.pizzaImages=pizzaImages;
        this.pizzaPrices=pizzaPrices;
    }

    @NonNull
    @Override
    public pizzaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pizza_item, parent, false);
        return new pizzaHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull pizzaHolder holder, int position) {
        int realPos = position % pizzaImages.size();
        holder.pizzaName.setText(pizzaNames.get(realPos));
        holder.pizzaImage.setImageResource(pizzaImages.get(realPos));
        holder.pizzaPrice.setText(pizzaPrices.get(realPos));
    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

    class pizzaHolder extends RecyclerView.ViewHolder{
        TextView pizzaName;
        ImageView pizzaImage;

        TextView pizzaPrice;

        public pizzaHolder(@NonNull View itemView) {
            super(itemView);
            this.pizzaName =itemView.findViewById(R.id.pizzaName);
            this.pizzaImage = itemView.findViewById(R.id.pizzaImage);
            this.pizzaPrice = itemView.findViewById(R.id.pizzaPrice);
        }
    }
}
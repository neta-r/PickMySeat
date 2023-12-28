package com.gambelingapp.menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gambelingapp.R;


import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {
    RecyclerView rv;
    ArrayList<String> pizzaNames;
    LinearLayoutManager linearLayoutManager;
    pizzaAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        rv = findViewById(R.id.pizzaMenu);
        setPizzaNames();
        linearLayoutManager = new LinearLayoutManager(MenuActivity.this, LinearLayoutManager.HORIZONTAL, false);
        adapter = new pizzaAdapter(pizzaNames);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(adapter);
    }

    void setPizzaNames(){
        pizzaNames = new ArrayList<>();
        pizzaNames.add("Vegan");
        pizzaNames.add("Black olives");
        pizzaNames.add("Mushrooms");
        pizzaNames.add("Pineapple");
        pizzaNames.add("Tomatoes");
        pizzaNames.add("Plain");
    }

    class pizzaAdapter extends RecyclerView.Adapter<pizzaAdapter.pizzaHolder>{
        ArrayList<String> pizzaNames;
        public pizzaAdapter(ArrayList<String> pizzaNames) {
            this.pizzaNames=pizzaNames;
        }

        @NonNull
        @Override
        public pizzaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(MenuActivity.this).inflate(R.layout.pizza_item, parent, false);
            return new pizzaHolder(view);

        }

        @Override
        public void onBindViewHolder(@NonNull pizzaHolder holder, int position) {
            holder.pizzaName.setText(pizzaNames.get(position));
        }

        @Override
        public int getItemCount() {
            return pizzaNames.size();
        }

        class pizzaHolder extends RecyclerView.ViewHolder{
            TextView pizzaName;

            public pizzaHolder(@NonNull View itemView) {
                super(itemView);
                this.pizzaName =itemView.findViewById(R.id.pizzaName);
            }
        }
    }
}

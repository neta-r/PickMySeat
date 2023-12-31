package com.gambelingapp.menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gambelingapp.R;


import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {
    RecyclerView rv;
    ArrayList<String> pizzaNames;

    ArrayList<Integer> pizzaImages;
    ArrayList<String> pizzaPrices;
    LinearLayoutManager linearLayoutManager;
    pizzaAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        rv = findViewById(R.id.pizzaMenu);
        setPizzaNames();
        setPizzaPrices();
        setPizzaImages();
        linearLayoutManager = new CenterZoomLayoutManager(MenuActivity.this, LinearLayoutManager.HORIZONTAL, false);
        adapter = new pizzaAdapter(pizzaNames,pizzaImages,pizzaPrices);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(adapter);
    }

    void setPizzaPrices(){
        pizzaPrices = new ArrayList<>();
        pizzaPrices.add("4$");
        pizzaPrices.add("4.5$");
        pizzaPrices.add("5$");
        pizzaPrices.add("5$");
        pizzaPrices.add("5$");
        pizzaPrices.add("5.5$");

    }

    void setPizzaNames(){
        pizzaNames = new ArrayList<>();
        pizzaNames.add("Plain");
        pizzaNames.add("Tomatoes");
        pizzaNames.add("Vegan");
        pizzaNames.add("Black olives");
        pizzaNames.add("Mushrooms");
        pizzaNames.add("Pineapple");

    }

    void setPizzaImages(){
        pizzaImages = new ArrayList<>();
        pizzaImages.add(R.drawable.pizza6);
        pizzaImages.add(R.drawable.pizza5);
        pizzaImages.add(R.drawable.pizza1);
        pizzaImages.add(R.drawable.pizza2);
        pizzaImages.add(R.drawable.pizza3);
        pizzaImages.add(R.drawable.pizza4);

    }
}

package com.gambelingapp.menu.pizza;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gambelingapp.R;
import com.gambelingapp.menu.CenterZoomLayoutManager;


import java.util.ArrayList;

public class pizzaMenuFragment extends Fragment {
    RecyclerView rv;
    ArrayList<String> pizzaNames;

    ArrayList<Integer> pizzaImages;
    ArrayList<String> pizzaPrices;
    LinearLayoutManager linearLayoutManager;
    pizzaAdapter adapter;
    public pizzaMenuFragment() {
        super(R.layout.fragment_pizza);
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        rv = view.findViewById(R.id.pizzaMenu);
        setPizzaNames();
        setPizzaPrices();
        setPizzaImages();
        linearLayoutManager = new CenterZoomLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
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

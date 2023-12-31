package com.gambelingapp.menu;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gambelingapp.R;

import java.util.ArrayList;

public class dessertMenuFragment extends Fragment {
    RecyclerView rv;
    ArrayList<String> dessertNames;

    ArrayList<Integer> dessertImages;
    ArrayList<String> dessertPrices;
    LinearLayoutManager linearLayoutManager;
    itemAdapter adapter;
    public dessertMenuFragment() {
        super(R.layout.fragment_dessert);
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        rv = view.findViewById(R.id.dessertMenu);
        setDessertNames();
        setDessertPrices();
        setDessertImages();
        linearLayoutManager = new CenterZoomLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        adapter = new itemAdapter(dessertNames,dessertImages,dessertPrices);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(adapter);
    }

    void setDessertPrices(){
        dessertPrices = new ArrayList<>();
        dessertPrices.add("12$");
        dessertPrices.add("13$");
        dessertPrices.add("10$");
        dessertPrices.add("11$");
        dessertPrices.add("3$");
        dessertPrices.add("3.5$");

    }

    void setDessertNames(){
        dessertNames = new ArrayList<>();
        dessertNames.add("Waffles");
        dessertNames.add("Pancakes");
        dessertNames.add("Chocolate cake");
        dessertNames.add("Cheese cake");
        dessertNames.add("Donut");
        dessertNames.add("Cupcake");


    }
    void setDessertImages(){
        dessertImages = new ArrayList<>();
        dessertImages.add(R.drawable.dessert1);
        dessertImages.add(R.drawable.dessert2);
        dessertImages.add(R.drawable.dessert3);
        dessertImages.add(R.drawable.dessert4);
        dessertImages.add(R.drawable.dessert5);
        dessertImages.add(R.drawable.dessert6);
    }
}


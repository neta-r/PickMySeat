package com.gambelingapp.menu.drinks;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gambelingapp.R;
import com.gambelingapp.menu.CenterZoomLayoutManager;
import com.gambelingapp.menu.itemAdapter;

import java.util.ArrayList;

public class softDrinkFragment extends Fragment {
    RecyclerView rv;
    ArrayList<String> drinkNames;

    ArrayList<Integer> drinkImages;
    ArrayList<String> drinkPrices;
    LinearLayoutManager linearLayoutManager;
    itemAdapter adapter;
    public softDrinkFragment() {
        super(R.layout.fragment_soft_drink);
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        rv = view.findViewById(R.id.softDrinkMenu);
        setDrinkNames();
        setDrinkPrices();
        setDrinkImages();
        linearLayoutManager = new CenterZoomLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        adapter = new itemAdapter(drinkNames,drinkImages,drinkPrices);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(adapter);
    }

    void setDrinkNames(){
        drinkPrices = new ArrayList<>();
        drinkPrices.add("2.5$");
        drinkPrices.add("4$");
        drinkPrices.add("4$");
        drinkPrices.add("5$");
        drinkPrices.add("4$");
        drinkPrices.add("4$");

    }

    void setDrinkPrices(){
        drinkNames = new ArrayList<>();
        drinkNames.add("Water");
        drinkNames.add("Coke");
        drinkNames.add("Orange juice");
        drinkNames.add("Strawberry milkshake");
        drinkNames.add("Ice tea");
        drinkNames.add("Lemon juice");

    }

    void setDrinkImages(){
        drinkImages = new ArrayList<>();
        drinkImages.add(R.drawable.soft_drink_2);
        drinkImages.add(R.drawable.soft_drink_1);
        drinkImages.add(R.drawable.soft_drink_3);
        drinkImages.add(R.drawable.soft_drink_4);
        drinkImages.add(R.drawable.soft_drink_5);
        drinkImages.add(R.drawable.soft_drink_6);

    }
}

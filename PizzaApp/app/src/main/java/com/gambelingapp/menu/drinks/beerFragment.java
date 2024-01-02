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

public class beerFragment extends Fragment {
    RecyclerView rv;
    ArrayList<String> drinkNames;

    ArrayList<Integer> drinkImages;
    ArrayList<String> drinkPrices;
    LinearLayoutManager linearLayoutManager;
    itemAdapter adapter;
    public beerFragment() {
        super(R.layout.fragment_beer);
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        rv = view.findViewById(R.id.beerMenu);
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
        drinkPrices.add("4$");
        drinkPrices.add("4$");
        drinkPrices.add("4$");
        drinkPrices.add("4.5$");
        drinkPrices.add("4.5$");
        drinkPrices.add("5$");

    }

    void setDrinkPrices(){
        drinkNames = new ArrayList<>();
        drinkNames.add("Heineken");
        drinkNames.add("Corona");
        drinkNames.add("Guinness");
        drinkNames.add("Blue moon");
        drinkNames.add("Samuel Adams");
        drinkNames.add("High life");

    }

    void setDrinkImages(){
        drinkImages = new ArrayList<>();
        drinkImages.add(R.drawable.beer_1);
        drinkImages.add(R.drawable.beer_2);
        drinkImages.add(R.drawable.beer_3);
        drinkImages.add(R.drawable.beer_4);
        drinkImages.add(R.drawable.beer_5);
        drinkImages.add(R.drawable.beer_6);

    }
}

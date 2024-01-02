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

public class hotDrinkFragment extends Fragment {
    RecyclerView rv;
    ArrayList<String> drinkNames;

    ArrayList<Integer> drinkImages;
    ArrayList<String> drinkPrices;
    LinearLayoutManager linearLayoutManager;
    itemAdapter adapter;
    public hotDrinkFragment() {
        super(R.layout.fragment_hot_drink);
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        rv = view.findViewById(R.id.hotDrinkMenu);
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
        drinkPrices.add("3$");
        drinkPrices.add("4$");
        drinkPrices.add("3$");
        drinkPrices.add("3$");
        drinkPrices.add("3$");

    }

    void setDrinkPrices(){
        drinkNames = new ArrayList<>();
        drinkNames.add("Espresso");
        drinkNames.add("Hot chocolate");
        drinkNames.add("Hot chocolate extra cream");
        drinkNames.add("Cappuccino");
        drinkNames.add("Cinnamon tea");
        drinkNames.add("Green tea");

    }

    void setDrinkImages(){
        drinkImages = new ArrayList<>();
        drinkImages.add(R.drawable.hot_drink_1);
        drinkImages.add(R.drawable.hot_drink_3);
        drinkImages.add(R.drawable.hot_drink_4);
        drinkImages.add(R.drawable.hot_drink_5);
        drinkImages.add(R.drawable.hot_drink_6);
        drinkImages.add(R.drawable.hot_drink_7);

    }
}

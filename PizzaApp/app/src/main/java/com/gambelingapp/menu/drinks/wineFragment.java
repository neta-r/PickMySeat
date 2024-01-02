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

public class wineFragment  extends Fragment {
    RecyclerView rv;
    ArrayList<String> drinkNames;

    ArrayList<Integer> drinkImages;
    ArrayList<String> drinkPrices;
    LinearLayoutManager linearLayoutManager;
    itemAdapter adapter;
    public wineFragment() {
        super(R.layout.fragment_wine);
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        rv = view.findViewById(R.id.wineMenu);
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
        drinkPrices.add("5.5$");
        drinkPrices.add("6$");
        drinkPrices.add("6.5$");
        drinkPrices.add("6$");
        drinkPrices.add("5.5$");
        drinkPrices.add("5.5$");

    }

    void setDrinkPrices(){
        drinkNames = new ArrayList<>();
        drinkNames.add("Pino noir");
        drinkNames.add("Malbec");
        drinkNames.add("Merlot");
        drinkNames.add("Zinfandel");
        drinkNames.add("Brachetto d'Acuqi");
        drinkNames.add("Shiraz");

    }

    void setDrinkImages(){
        drinkImages = new ArrayList<>();
        drinkImages.add(R.drawable.wine_1);
        drinkImages.add(R.drawable.wine_2);
        drinkImages.add(R.drawable.wine_3);
        drinkImages.add(R.drawable.wine_4);
        drinkImages.add(R.drawable.wine_5);
        drinkImages.add(R.drawable.wine_6);

    }
}

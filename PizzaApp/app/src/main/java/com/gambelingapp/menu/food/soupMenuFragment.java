package com.gambelingapp.menu.food;

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

public class soupMenuFragment extends Fragment {
    RecyclerView rv;
    ArrayList<String> soupNames;

    ArrayList<Integer> soupImages;
    ArrayList<String> soupPrices;
    LinearLayoutManager linearLayoutManager;
    itemAdapter adapter;
    public soupMenuFragment() {
        super(R.layout.fragment_menu_item);
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        rv = view.findViewById(R.id.itemMenu);
        setSoupNames();
        setSoupPrices();
        setSoupImages();
        linearLayoutManager = new CenterZoomLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        adapter = new itemAdapter(soupNames,soupImages,soupPrices);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(adapter);
    }

    void setSoupPrices(){
        soupPrices = new ArrayList<>();
        soupPrices.add("8$");
        soupPrices.add("9$");
        soupPrices.add("9$");
        soupPrices.add("9$");
        soupPrices.add("10$");
        soupPrices.add("10$");

    }

    void setSoupNames(){
        soupNames = new ArrayList<>();
        soupNames.add("Tomatoes soup");
        soupNames.add("Creamy radish soup");
        soupNames.add("Carrot soup");
        soupNames.add("Broccoli soup");
        soupNames.add("Vegetable soup");
        soupNames.add("Mushrooms soup");

    }

    void setSoupImages(){
        soupImages = new ArrayList<>();
        soupImages.add(R.drawable.soup3);
        soupImages.add(R.drawable.soup1);
        soupImages.add(R.drawable.soup2);
        soupImages.add(R.drawable.soup4);
        soupImages.add(R.drawable.soup5);
        soupImages.add(R.drawable.soup6);

    }
}

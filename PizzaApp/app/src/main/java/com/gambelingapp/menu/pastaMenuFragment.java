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

public class pastaMenuFragment extends Fragment {
    RecyclerView rv;
    ArrayList<String> pastaNames;

    ArrayList<Integer> pastaImages;
    ArrayList<String> pastaPrices;
    LinearLayoutManager linearLayoutManager;
    itemAdapter adapter;
    public pastaMenuFragment() {
        super(R.layout.fragment_pasta);
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        rv = view.findViewById(R.id.pastaMenu);
        setPastaNames();
        setPastaPrices();
        setPastaImages();
        linearLayoutManager = new CenterZoomLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        adapter = new itemAdapter(pastaNames,pastaImages,pastaPrices);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(adapter);
    }

    void setPastaPrices(){
        pastaPrices = new ArrayList<>();
        pastaPrices.add("15$");
        pastaPrices.add("16$");
        pastaPrices.add("16$");
        pastaPrices.add("16$");
        pastaPrices.add("17$");
        pastaPrices.add("18$");

    }

    void setPastaNames(){
        pastaNames = new ArrayList<>();
        pastaNames.add("Tomatoes sauce Fusilli");
        pastaNames.add("Mushroom cream farfalle");
        pastaNames.add("Spaghetti bolognese");
        pastaNames.add("Tomatoes cream gnocchi");
        pastaNames.add("Pesto spaghetti");
        pastaNames.add("Pena Parmesan");


    }
    void setPastaImages(){
        pastaImages = new ArrayList<>();
        pastaImages.add(R.drawable.pasta1);
        pastaImages.add(R.drawable.pasta2);
        pastaImages.add(R.drawable.pasta3);
        pastaImages.add(R.drawable.pasta6);
        pastaImages.add(R.drawable.pasta4);
        pastaImages.add(R.drawable.pasta5);
    }
}


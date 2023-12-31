package com.gambelingapp.menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.gambelingapp.R;
import com.gambelingapp.Reservation.MainActivity;

public class MenuFragment extends Fragment {
    public MenuFragment() {
        super(R.layout.fragment_main_menu);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button seats = view.findViewById(R.id.Seats);
        seats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), MainActivity.class);
                startActivity(i);
            }
        });
        ImageButton pizza = view.findViewById(R.id.pizzaBtn);
        pizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_menuFragment_to_pizzaMenuFragment);
            }
        });

        ImageButton pasta = view.findViewById(R.id.pastaBtn);
        pasta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_menuFragment_to_pastaMenuFragment);
            }
        });

        ImageButton soup = view.findViewById(R.id.soupBtn);
        soup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_menuFragment_to_soupMenuFragment);
            }
        });

        ImageButton dessert = view.findViewById(R.id.dessertBtn);
        dessert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_menuFragment_to_dessertMenuFragment);
            }
        });


        ImageButton drink = view.findViewById(R.id.drinkBtn);
        drink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_menuFragment_to_mainDrinkFragment);
            }
        });

    }
}

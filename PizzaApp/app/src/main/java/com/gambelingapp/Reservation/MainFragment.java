package com.gambelingapp.Reservation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.gambelingapp.R;
import com.gambelingapp.menu.MenuActivity;
import com.gambelingapp.menu.pizza.pizzaMenuFragment;

public class MainFragment extends Fragment{

    Button PickSeats, Menu;
    public MainFragment() {
        super(R.layout.fragment_main);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        PickSeats= (Button)view.findViewById(R.id.PickSeats);
        Menu= view.findViewById(R.id.Menu);
        PickSeats.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_bookReservationFragment);
            }
        });
        Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menuActivity = new Intent(requireContext(), MenuActivity.class);
                startActivity(menuActivity);
            }
        });
    }

}

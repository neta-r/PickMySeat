package com.gambelingapp.seats;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.gambelingapp.R;

public class MainFragment  extends Fragment{

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
    }

}

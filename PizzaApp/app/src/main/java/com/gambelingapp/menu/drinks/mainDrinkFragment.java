package com.gambelingapp.menu.drinks;

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

public class mainDrinkFragment extends Fragment {
    public mainDrinkFragment() {
        super(R.layout.fragment_drink_picker);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageButton softDrinkBtn = view.findViewById(R.id.softDrinkBtn);
//        softDrinkBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
    }
}
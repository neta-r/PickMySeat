package com.gambelingapp.seats;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gambelingapp.R;

public class MainFragment extends Fragment implements View.OnClickListener{
    Button Reservation, Menu;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Reservation= view.findViewById(R.id.Reservation);
        Menu= view.findViewById(R.id.Menu);
        Reservation.setOnClickListener(this);
        Menu.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == Reservation) {
//            Intent i = new Intent(getApplicationContext(), PickSeatsFragment.class);
//            startActivity(i);
        }
        if (v == Menu) {
//            Intent i = new Intent(getApplicationContext(), com.gambelingapp.menu.Menu.class);
//            startActivity(i);
        }
    }
}
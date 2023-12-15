package com.gambelingapp.seats;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gambelingapp.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button Reservation, Menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Reservation= findViewById(R.id.Reservation);
        Menu= findViewById(R.id.Menu);
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
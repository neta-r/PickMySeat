package com.gambelingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ReservationSuccess extends AppCompatActivity implements View.OnClickListener {
    Button Menu;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reservation_seucsess);
        Menu = findViewById(R.id.Menu);
        Menu.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(getApplicationContext(), Menu.class);
        startActivity(i);
    }
}


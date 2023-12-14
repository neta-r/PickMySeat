package com.gambelingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class restaurantSketch extends AppCompatActivity implements View.OnClickListener {
    Button Skip;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pick_seats);
        Skip = findViewById(R.id.Skip);
        Skip.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(getApplicationContext(), BookReservation.class);
        startActivity(i);
    }

}

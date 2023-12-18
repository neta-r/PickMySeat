package com.gambelingapp.Reservation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.gambelingapp.PizzaStore;
import com.gambelingapp.R;

public class MainActivity extends AppCompatActivity{
    PizzaStore pizzaRestaurant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pizzaRestaurant = new ViewModelProvider(this).get(PizzaStore.class);
        pizzaRestaurant.initializeRestaurant();
    }

}
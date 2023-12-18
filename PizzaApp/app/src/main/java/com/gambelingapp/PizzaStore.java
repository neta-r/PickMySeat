package com.gambelingapp;

import androidx.lifecycle.ViewModel;

import java.util.HashMap;

public class PizzaStore extends ViewModel implements Restaurant{
    private HashMap<String, restaurantPlace> places;

    public PizzaStore(){
        places = new HashMap<>();
        initializeRestaurant();
    }
    public void addTable(int numberOfSeats ,String tag){
        places.put(tag, new restaurantPlace(numberOfSeats));
    }

    public HashMap<String, restaurantPlace> getPlaces(){
        return places;
    }

    public void initializeRestaurant(){
        this.addTable(6, "pink1");
        this.addTable(6, "pink2");
        this.addTable(6, "pink3");
        this.addTable(4, "blue1");
        this.addTable(4, "blue2");
        this.addTable(4, "blue3");
        this.addTable(4, "blue4");
        this.addTable(4, "blue5");
        this.addTable(4, "blue6");
        this.addTable(4, "blue7");
        this.addTable(4, "blue8");
        this.addTable(4, "blue9");
        this.addTable(4, "blue10");
        this.addTable(4, "blue11");
        this.addTable(4, "blue12");
        this.addTable(8, "green1");
        this.addTable(8, "green2");
        this.addTable(8, "green3");
        this.addTable(8, "green4");
        this.addTable(2, "orange1");
        this.addTable(2, "orange2");
        this.addTable(2, "orange3");
        this.addTable(2, "orange4");
        this.addTable(2, "orange5");


    }
}

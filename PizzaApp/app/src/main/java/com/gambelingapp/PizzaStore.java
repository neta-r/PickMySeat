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
        this.addTable(1, "s1");
        this.addTable(1, "s2");
        this.addTable(1, "s3");
        this.addTable(1, "s4");
        this.addTable(1, "s5");
        this.addTable(1, "s6");
        this.addTable(1, "s7");
        this.addTable(4, "t1");
        this.addTable(4, "t2");
        this.addTable(4, "t3");
        this.addTable(4, "t4");
        this.addTable(4, "t5");
        this.addTable(4, "t6");
        this.addTable(6, "t7");
        this.addTable(2, "t8");
        this.addTable(2, "t9");
        this.addTable(2, "t10");
        this.addTable(4, "t11");
        this.addTable(4, "t12");
        this.addTable(4, "t13");

    }
}

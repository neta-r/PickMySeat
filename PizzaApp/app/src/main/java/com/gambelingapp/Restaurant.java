package com.gambelingapp;

import java.util.HashMap;

public interface Restaurant {
    public HashMap<String, restaurantPlace> places = new HashMap<>();
    public void addTable(int numberOfSeats ,String tag);
    public HashMap<String, restaurantPlace> getPlaces();
    public void initializeRestaurant();
}

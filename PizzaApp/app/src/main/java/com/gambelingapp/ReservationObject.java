package com.gambelingapp;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class ReservationObject {
    String dinerName = "";
    int numOfDiners = 0;
    String date = "";
    String time = "";
    String chosenPlace = "";

    public String getChosenPlace() {
        return chosenPlace;
    }

    private Restaurant pizzaRestaurant;

    public ReservationObject(String dinerName, int numOfDiners, String date, String time) {
        this.dinerName = dinerName;
        this.numOfDiners = numOfDiners;
        this.date = date;
        this.time = time;
    }

    public void RestaurantHandel(PizzaStore pizzaRestaurant, Context context, ArrayList<String> unavailable) {
        this.pizzaRestaurant = pizzaRestaurant;
        pizzaRestaurant.getPlaces().forEach((tag, place) -> {
            if (!unavailable.contains(tag)) {
                place.btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        place.btn.setSelected(!place.btn.isSelected());
                        chosenPlace = tag;

                    }
                });
            }

        });
    }

    public String getDinerName() {
        return dinerName;
    }

    public int getNumOfDiners() {
        return numOfDiners;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}

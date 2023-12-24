package com.gambelingapp;

import android.view.View;
import android.widget.ImageButton;

public class restaurantPlace{
    int numberOfPlaces=0;
    public ImageButton btn;

    boolean isAvailable=true;

    public restaurantPlace (int numberOfPlaces){
        this.numberOfPlaces = numberOfPlaces;
    }
    public void setBtn(View view){
        this.btn=((ImageButton) view);
    }

}

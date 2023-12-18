package com.gambelingapp;

import android.widget.ImageButton;

public class restaurantPlace {
    int numberOfPlaces=0;
    ImageButton btn;

    public restaurantPlace (int numberOfPlaces){
        this.numberOfPlaces = numberOfPlaces;
        this.btn=null;
    }
    public void setBtn(ImageButton btn){
        this.btn=btn;
    }

}

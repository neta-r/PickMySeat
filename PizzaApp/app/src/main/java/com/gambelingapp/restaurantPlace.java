package com.gambelingapp;

import android.media.Image;
import android.view.View;
import android.widget.ImageButton;

public class restaurantPlace {
    int numberOfPlaces=0;
    public ImageButton btn;

    public restaurantPlace (int numberOfPlaces){
        this.numberOfPlaces = numberOfPlaces;
    }
    public void setBtn(View view){
        this.btn=((ImageButton) view); ;
    }

}

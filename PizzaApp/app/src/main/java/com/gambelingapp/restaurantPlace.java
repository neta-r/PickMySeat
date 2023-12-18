package com.gambelingapp;

import android.view.View;
import android.widget.RadioButton;

public class restaurantPlace{
    int numberOfPlaces=0;
    public RadioButton btn;

    public restaurantPlace (int numberOfPlaces){
        this.numberOfPlaces = numberOfPlaces;
    }
    public void setBtn(View view){
        this.btn=((RadioButton) view);
    }

}

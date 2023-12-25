package com.gambelingapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageButton;

import androidx.core.content.ContextCompat;

public class restaurantPlace {
    String tag = "";
    int numberOfPlaces = 0;
    public ImageButton btn;

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    boolean isAvailable = false;

    public restaurantPlace(int numberOfPlaces, String tag) {
        this.numberOfPlaces = numberOfPlaces;
        this.tag = tag;
    }

    public void setBtn(View view) {
        this.btn = ((ImageButton) view);
        if (!this.isAvailable) {
            this.btn.setEnabled(false);
        }
    }
}

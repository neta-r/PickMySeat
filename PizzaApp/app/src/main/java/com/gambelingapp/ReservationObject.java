package com.gambelingapp;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;

public class ReservationObject implements Parcelable {
    String dinerName = "";
    int numOfDiners = 0;
    String date = "";
    String time = "";

    String chosenPlace = "";

    private Restaurant pizzaRestaurant;

    public ReservationObject(String dinerName, int numOfDiners, String date, String time) {
        this.dinerName = dinerName;
        this.numOfDiners = numOfDiners;
        this.date = date;
        this.time = time;
    }

    protected ReservationObject(Parcel in) {
        dinerName = in.readString();
        numOfDiners = in.readInt();
        date = in.readString();
        time = in.readString();
    }

    public static final Creator<ReservationObject> CREATOR = new Creator<ReservationObject>() {
        @Override
        public ReservationObject createFromParcel(Parcel in) {
            return new ReservationObject(in);
        }

        @Override
        public ReservationObject[] newArray(int size) {
            return new ReservationObject[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(dinerName);
        dest.writeInt(numOfDiners);
        dest.writeString(date);
        dest.writeString(time);
    }

    public void RestaurantHandel(PizzaStore pizzaRestaurant) {
        this.pizzaRestaurant = pizzaRestaurant;
        pizzaRestaurant.getPlaces().forEach((tag, place) -> {
            place.btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    chosenPlace = tag;
                    Log.i("Reservation", "chosen place is "+tag);
                }
            });
        });
    }
}

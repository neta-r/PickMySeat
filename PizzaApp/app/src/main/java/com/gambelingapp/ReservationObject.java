package com.gambelingapp;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class ReservationObject implements Parcelable {
    String dinerName = "";
    int numOfDiners = 0;
    String date = "";
    String time = "";
    String chosenPlace = "";

    ArrayList<String> availableTableLst = new ArrayList<>();
    private Restaurant pizzaRestaurant;

    protected ReservationObject(Parcel in) {
        dinerName = in.readString();
        numOfDiners = in.readInt();
        date = in.readString();
        time = in.readString();
        chosenPlace = in.readString();
        availableTableLst = in.createStringArrayList();
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

    public String getChosenPlace() {
        return chosenPlace;
    }


    public ReservationObject(String dinerName, int numOfDiners, String date, String time) {
        this.dinerName = dinerName;
        this.numOfDiners = numOfDiners;
        this.date = date;
        this.time = time;
    }

    public void RestaurantHandel(PizzaStore pizzaRestaurant) {
        this.pizzaRestaurant = pizzaRestaurant;
        pizzaRestaurant.getPlaces().forEach((tag, place) -> {
            if (this.availableTableLst.contains(tag)) {
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

    public void setAvailableTableLst(ArrayList<String> availableTableLst) {
        this.availableTableLst.addAll(availableTableLst);
    }

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
        dest.writeString(chosenPlace);
        dest.writeStringList(availableTableLst);
    }
}

package com.gambelingapp.Reservation;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class ReservationObject implements Parcelable {
    String dinerName = "";
    int numOfDiners = 0;
    String date = "";
    String time = "";

    public ReservationObject(String dinerName,int numOfDiners,String date,String time){
        this.dinerName=dinerName;
        this.numOfDiners=numOfDiners;
        this.date=date;
        this.time=time;
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
}

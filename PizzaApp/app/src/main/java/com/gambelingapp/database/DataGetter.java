package com.gambelingapp.database;

import androidx.annotation.NonNull;

import com.gambelingapp.ReservationObject;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DataGetter {
    public void readData(ReservationObject reservationObject, final OnGetDataListener listener) {
        listener.onStart();
        String datePath = "Date " + reservationObject.getDate();
        String timePath = "Time " + reservationObject.getTime();
        FirebaseDatabase.getInstance().getReference().child(datePath).child(timePath).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listener.onSuccess(snapshot);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                listener.onFailed(error);

            }
        });
    }
}

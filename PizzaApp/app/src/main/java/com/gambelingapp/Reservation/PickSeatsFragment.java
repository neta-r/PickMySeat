package com.gambelingapp.Reservation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.gambelingapp.PizzaStore;
import com.gambelingapp.R;
import com.gambelingapp.ReservationObject;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


public class PickSeatsFragment extends Fragment {
    ReservationObject reservationObject;
    Button next, skip;
    PizzaStore pizzaRestaurant;

    com.google.firebase.database.DatabaseReference db;
    public PickSeatsFragment() {
        super(R.layout.fragment_pick_seats);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        reservationObject = new ReservationObject(getArguments().getString("name"), getArguments().getInt("dinersNum"),
                getArguments().getString("date"),getArguments().getString("time"));
        next = view.findViewById(R.id.next);
        skip = view.findViewById(R.id.skip);
        pizzaRestaurant = ((MainActivity) requireActivity()).pizzaRestaurant;
        setBtn(view);
        reservationObject.RestaurantHandel(pizzaRestaurant, getContext());
        db = FirebaseDatabase.getInstance().getReference();
        next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                checkAvailability(v);
            }
        });
        skip.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                selectRandomPlace();
            }
        });
    }



    private void selectRandomPlace() {
    }

    private void checkAvailability(View view) {
        //check availability in db...
        registerReservation();
        Navigation.findNavController(view).navigate(R.id.action_pickSeatsFragment_to_reservationSuccessFragment);
    }

    private void registerReservation() {
        db.child("Reservations").child("date "+reservationObject.getDate())
                .child("time "+reservationObject.getTime()).child("Reservation 1")
                .child("Table tag").setValue(reservationObject.getChosenPlace());
        db.child("Reservations").child("date "+reservationObject.getDate())
                .child("time "+reservationObject.getTime()).child("Reservation 1")
                .child("Number of diners").setValue(reservationObject.getNumOfDiners());
        db.child("Reservations").child("date "+reservationObject.getDate())
                .child("time "+reservationObject.getTime()).child("Reservation 1")
                .child("Name of main diner").setValue(reservationObject.getDinerName());
    }

    private void setBtn(View view) {
        pizzaRestaurant.getPlaces().get("pink1").setBtn(view.findViewById(R.id.pinkTable1));
        pizzaRestaurant.getPlaces().get("pink2").setBtn(view.findViewById(R.id.pinkTable2));
        pizzaRestaurant.getPlaces().get("pink3").setBtn(view.findViewById(R.id.pinkTable3));
        pizzaRestaurant.getPlaces().get("blue1").setBtn(view.findViewById(R.id.blueTable1));
        pizzaRestaurant.getPlaces().get("blue2").setBtn(view.findViewById(R.id.blueTable2));
        pizzaRestaurant.getPlaces().get("blue3").setBtn(view.findViewById(R.id.blueTable3));
        pizzaRestaurant.getPlaces().get("blue4").setBtn(view.findViewById(R.id.blueTable4));
        pizzaRestaurant.getPlaces().get("blue5").setBtn(view.findViewById(R.id.blueTable5));
        pizzaRestaurant.getPlaces().get("blue6").setBtn(view.findViewById(R.id.blueTable6));
        pizzaRestaurant.getPlaces().get("blue7").setBtn(view.findViewById(R.id.blueTable7));
        pizzaRestaurant.getPlaces().get("blue8").setBtn(view.findViewById(R.id.blueTable8));
        pizzaRestaurant.getPlaces().get("blue9").setBtn(view.findViewById(R.id.blueTable9));
        pizzaRestaurant.getPlaces().get("blue10").setBtn(view.findViewById(R.id.blueTable10));
        pizzaRestaurant.getPlaces().get("blue11").setBtn(view.findViewById(R.id.blueTable11));
        pizzaRestaurant.getPlaces().get("blue12").setBtn(view.findViewById(R.id.blueTable12));
        pizzaRestaurant.getPlaces().get("green1").setBtn(view.findViewById(R.id.greenTable1));
        pizzaRestaurant.getPlaces().get("green2").setBtn(view.findViewById(R.id.greenTable2));
        pizzaRestaurant.getPlaces().get("green3").setBtn(view.findViewById(R.id.greenTable3));
        pizzaRestaurant.getPlaces().get("green4").setBtn(view.findViewById(R.id.greenTable4));
        pizzaRestaurant.getPlaces().get("orange1").setBtn(view.findViewById(R.id.orangeTable1));
        pizzaRestaurant.getPlaces().get("orange2").setBtn(view.findViewById(R.id.orangeTable2));
        pizzaRestaurant.getPlaces().get("orange3").setBtn(view.findViewById(R.id.orangeTable3));
        pizzaRestaurant.getPlaces().get("orange4").setBtn(view.findViewById(R.id.orangeTable4));
        pizzaRestaurant.getPlaces().get("orange5").setBtn(view.findViewById(R.id.orangeTable5));

    }

    void setReservation(ReservationObject reservationObject) {
        this.reservationObject = reservationObject;
    }

}
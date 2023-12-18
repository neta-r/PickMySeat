package com.gambelingapp.Reservation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.gambelingapp.PizzaStore;
import com.gambelingapp.R;
import com.gambelingapp.ReservationObject;


public class PickSeatsFragment extends Fragment {
    ReservationObject reservationObject;
    Button next, skip;
    PizzaStore pizzaRestaurant;

    public PickSeatsFragment() {
        super(R.layout.fragment_pick_seats);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();
        reservationObject = (ReservationObject) bundle.getParcelable("ResObj");
        next = view.findViewById(R.id.next);
        skip = view.findViewById(R.id.skip);
        pizzaRestaurant = ((MainActivity) requireActivity()).pizzaRestaurant;
        setBtn(view);
        reservationObject.RestaurantHandel(pizzaRestaurant, getContext());
        next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                checkAvialability();
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

    private void checkAvialability() {
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
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
        next = view.findViewById(R.id.Next);
        skip = view.findViewById(R.id.Skip);
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
        pizzaRestaurant.getPlaces().get("s1").setBtn(view.findViewById(R.id.Seat1));
        pizzaRestaurant.getPlaces().get("s2").setBtn(view.findViewById(R.id.Seat2));
        pizzaRestaurant.getPlaces().get("s3").setBtn(view.findViewById(R.id.Seat3));
        pizzaRestaurant.getPlaces().get("s4").setBtn(view.findViewById(R.id.Seat4));
        pizzaRestaurant.getPlaces().get("s5").setBtn(view.findViewById(R.id.Seat5));
        pizzaRestaurant.getPlaces().get("s6").setBtn(view.findViewById(R.id.Seat6));
        pizzaRestaurant.getPlaces().get("s7").setBtn(view.findViewById(R.id.Seat7));

        pizzaRestaurant.getPlaces().get("t1").setBtn(view.findViewById(R.id.Table1));
        pizzaRestaurant.getPlaces().get("t2").setBtn(view.findViewById(R.id.Table2));
        pizzaRestaurant.getPlaces().get("t3").setBtn(view.findViewById(R.id.Table3));
        pizzaRestaurant.getPlaces().get("t4").setBtn(view.findViewById(R.id.Table4));
        pizzaRestaurant.getPlaces().get("t5").setBtn(view.findViewById(R.id.Table5));
        pizzaRestaurant.getPlaces().get("t6").setBtn(view.findViewById(R.id.Table6));
        pizzaRestaurant.getPlaces().get("t7").setBtn(view.findViewById(R.id.Table7));
        pizzaRestaurant.getPlaces().get("t8").setBtn(view.findViewById(R.id.Table8));
        pizzaRestaurant.getPlaces().get("t9").setBtn(view.findViewById(R.id.Table9));
        pizzaRestaurant.getPlaces().get("t10").setBtn(view.findViewById(R.id.Table10));
        pizzaRestaurant.getPlaces().get("t11").setBtn(view.findViewById(R.id.Table11));
        pizzaRestaurant.getPlaces().get("t12").setBtn(view.findViewById(R.id.Table12));
        pizzaRestaurant.getPlaces().get("t13").setBtn(view.findViewById(R.id.Table13));
    }

    void setReservation(ReservationObject reservationObject) {
        this.reservationObject = reservationObject;
    }

}
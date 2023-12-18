package com.gambelingapp.Reservation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.gambelingapp.PizzaStore;
import com.gambelingapp.R;

import java.util.Objects;


public class PickSeatsFragment extends Fragment {
    String choice = null;
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
        reservationObject= (ReservationObject) bundle.getParcelable("ResObj");
        next = view.findViewById(R.id.Next);
        skip = view.findViewById(R.id.Skip);
        MainActivity parentActivity = (MainActivity) getActivity();
        pizzaRestaurant = ((MainActivity) requireActivity()).pizzaRestaurant;
        setBtn(view);
        next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                PickSeatsFragmentDirections.ActionPickSeatsFragment2ToBookReservationFragment action = PickSeatsFragmentDirections.actionPickSeatsFragment2ToBookReservationFragment();
//                action.setNumberOfDinersSelected(-1);
//                Navigation.findNavController(view).navigate(action);
            }
        });
        skip.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                PickSeatsFragmentDirections.ActionPickSeatsFragment2ToBookReservationFragment action = PickSeatsFragmentDirections.actionPickSeatsFragment2ToBookReservationFragment();
//                action.setNumberOfDinersSelected(-1);
//                Navigation.findNavController(view).navigate(action);            }
        }});
    }
    public void setBtn(View view){
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

//
//        if (v == s1) {
//            choice = "s1";
//            numberOfDiners = 1;
//        }
//        if (v == s2) {
//            choice = "s2";
//            numberOfDiners = 1;
//        }
//        if (v == s3) {
//            choice = "s3";
//            numberOfDiners = 1;
//        }
//        if (v == s4) {
//            choice = "s4";
//            numberOfDiners = 1;
//        }
//        if (v == s5) {
//            choice = "s5";
//            numberOfDiners = 1;
//        }
//        if (v == s6) {
//            choice = "s6";
//            numberOfDiners = 1;
//        }
//        if (v == s7) {
//            choice = "s7";
//            numberOfDiners = 1;
//        }
//        if (v == t1) {
//            choice = "t1";
//            numberOfDiners = 4;
//        }
//        if (v == t2) {
//            choice = "t2";
//            numberOfDiners = 4;
//        }
//        if (v == t3) {
//            choice = "t3";
//            numberOfDiners = 4;
//        }
//        if (v == t4) {
//            choice = "t4";
//            numberOfDiners = 4;
//        }
//        if (v == t5) {
//            choice = "t5";
//            numberOfDiners = 4;
//        }
//        if (v == t6) {
//            choice = "t6";
//            numberOfDiners = 4;
//        }
//        if (v == t7) {
//            choice = "t7";
//            numberOfDiners = 6;
//        }
//        if (v == t8) {
//            choice = "t8";
//            numberOfDiners = 2;
//        }
//        if (v == t9) {
//            choice = "t9";
//            numberOfDiners = 2;
//        }
//        if (v == t10) {
//            choice = "t10";
//            numberOfDiners = 2;
//        }
//        if (v == t11) {
//            choice = "t11";
//            numberOfDiners = 2;
//        }
//        if (v == t12) {
//            choice = "t12";
//            numberOfDiners = 4;
//        }
//        if (v == t13) {
//            choice = "t13";
//            numberOfDiners = 4;
//        }

    void setReservation (ReservationObject reservationObject){
        this.reservationObject = reservationObject;
    }

}
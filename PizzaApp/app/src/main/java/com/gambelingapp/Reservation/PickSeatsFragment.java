package com.gambelingapp.Reservation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.gambelingapp.R;


public class PickSeatsFragment extends Fragment {
    String choice = null;
    ReservationObject reservationObject;
    Button next, skip;
    ImageButton s1, s2, s3, s4, s5, s6, s7, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13;

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
        s1 = (ImageButton) view.findViewById(R.id.Seat1);
        s2 = (ImageButton) view.findViewById(R.id.Seat2);
        s3 = (ImageButton) view.findViewById(R.id.Seat3);
        s4 = (ImageButton) view.findViewById(R.id.Seat4);
        s5 = (ImageButton) view.findViewById(R.id.Seat5);
        s6 = (ImageButton) view.findViewById(R.id.Seat6);
        s7 = (ImageButton) view.findViewById(R.id.Seat7);
        t1 = (ImageButton) view.findViewById(R.id.Table1);
        t2 = (ImageButton) view.findViewById(R.id.Table2);
        t3 = (ImageButton) view.findViewById(R.id.Table3);
        t4 = (ImageButton) view.findViewById(R.id.Table4);
        t5 = (ImageButton) view.findViewById(R.id.Table5);
        t6 = (ImageButton) view.findViewById(R.id.Table6);
        t7 = (ImageButton) view.findViewById(R.id.Table7);
        t8 = (ImageButton) view.findViewById(R.id.Table8);
        t9 = (ImageButton) view.findViewById(R.id.Table9);
        t10 = (ImageButton) view.findViewById(R.id.Table10);
        t11 = (ImageButton) view.findViewById(R.id.Table11);
        t12 = (ImageButton) view.findViewById(R.id.Table12);
        t13 = (ImageButton) view.findViewById(R.id.Table13);
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
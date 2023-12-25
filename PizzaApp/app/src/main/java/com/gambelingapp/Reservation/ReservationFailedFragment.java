package com.gambelingapp.Reservation;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.gambelingapp.R;
import com.gambelingapp.ReservationObject;


public class ReservationFailedFragment extends Fragment {
    Button Menu;
    EditText date, time;
    ReservationObject reservationObject;

    public ReservationFailedFragment() {
        super(R.layout.fragment_reservation_falied);
    }
    @SuppressLint("SetTextI18n")
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();
        reservationObject= (ReservationObject) bundle.getParcelable("ResObj");
        date = (EditText) view.findViewById(R.id.Date);
        time = (EditText) view.findViewById(R.id.Time);
        date.setText("We are fully booked on "+reservationObject.getDate());
        time.setText("at "+reservationObject.getTime());
        Menu = (Button) view.findViewById(R.id.Menu);

    }
}
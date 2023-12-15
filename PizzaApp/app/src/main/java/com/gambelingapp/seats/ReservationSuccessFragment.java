package com.gambelingapp.seats;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.gambelingapp.R;

public class ReservationSuccessFragment extends Fragment implements View.OnClickListener {
    Button Menu;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main,container,false);        super.onCreate(savedInstanceState);
        Menu = view.findViewById(R.id.Menu);
        Menu.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
//        Intent i = new Intent(getApplicationContext(), com.gambelingapp.menu.Menu.class);
//        startActivity(i);
    }
}


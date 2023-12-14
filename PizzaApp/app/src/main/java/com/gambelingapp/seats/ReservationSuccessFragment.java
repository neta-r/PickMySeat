package com.gambelingapp.seats;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.gambelingapp.R;

public class ReservationSuccessFragment extends Fragment implements View.OnClickListener {
    Button Menu;

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Menu = view.findViewById(R.id.Menu);
        Menu.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
//        Intent i = new Intent(getApplicationContext(), com.gambelingapp.menu.Menu.class);
//        startActivity(i);
    }
}


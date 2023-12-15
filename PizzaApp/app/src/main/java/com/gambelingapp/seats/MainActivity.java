package com.gambelingapp.seats;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gambelingapp.R;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //FragmentManager fragmentManager = getSupportFragmentManager();
        //NavController navController = ((NavHostFragment) fragmentManager.findFragmentById(R.id.main_nav)).getNavController();
    }
}
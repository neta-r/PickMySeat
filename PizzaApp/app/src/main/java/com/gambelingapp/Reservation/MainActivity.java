package com.gambelingapp.Reservation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.gambelingapp.MyDatabaseHelper;
import com.gambelingapp.PizzaStore;
import com.gambelingapp.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;

public class MainActivity extends AppCompatActivity{
    PizzaStore pizzaRestaurant;
    MyDatabaseHelper myDatabaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pizzaRestaurant = new ViewModelProvider(this).get(PizzaStore.class);
        pizzaRestaurant.initializeRestaurant();
        myDatabaseHelper= new MyDatabaseHelper(this);
        try{
            myDatabaseHelper.CheckDB();
        } catch (Exception e){
            e.printStackTrace();
        }

        try{
            myDatabaseHelper.OpenDatabase();
        } catch (Exception e){
            e.printStackTrace();
        }

    }

}
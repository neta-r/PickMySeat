package com.gambelingapp;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;


public class BookReservation extends AppCompatActivity implements View.OnClickListener {
    Button Date, Time, Reserve;
    EditText txtDate, txtTime, Name, NumberOfDiners;

    ImageButton Plus, Minus;

    int Diners = 0;
    TextWatcher tt = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_reservation);

        Date = findViewById(R.id.DateBtn);
        Time = findViewById(R.id.TimeBtn);
        Plus = findViewById(R.id.PlusBtn);
        Minus = findViewById(R.id.MinusBtn);
        Reserve = findViewById(R.id.Reserve);

        txtDate = findViewById(R.id.Date);
        txtTime = findViewById(R.id.Time);
        Name = findViewById(R.id.Name);
        NumberOfDiners = findViewById(R.id.NumberOfDiners);
        NumberOfDiners.setText(Diners);

        Date.setOnClickListener(this);
        Time.setOnClickListener(this);
        Reserve.setOnClickListener(this);
        Plus.setOnClickListener(this);
        Minus.setOnClickListener(this);

        tt = new TextWatcher() {
            public void afterTextChanged(Editable s) {
                Name.setSelection(s.length());
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Name.removeTextChangedListener(tt);
                Name.setText(Name.getText().toString());
                Name.addTextChangedListener(tt);
            }
        };
        Name.addTextChangedListener(tt);
    }

    @Override
    public void onClick(View v) {
        if (v == Date) {
            final Calendar c = Calendar.getInstance();
            int mYear = c.get(Calendar.YEAR);
            int mMonth = c.get(Calendar.MONTH);
            int mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        if (v == Time) {

            // Get Current Time
            final Calendar c = Calendar.getInstance();
            int mHour = c.get(Calendar.HOUR_OF_DAY);
            int mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @SuppressLint("SetTextI18n")
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                            txtTime.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }
        if (v == Minus) {
            if (Diners > 0) {
                Diners--;
                NumberOfDiners.setText(Diners);
            }
        }
        if (v == Plus) {
            Diners++;
            NumberOfDiners.setText(Diners);
        }

        //todo:if (v == Reserve) {
        // enter a db connection and check reservation info
        //Intent i = new Intent(getApplicationContext(), PickSeats.class);
        //startActivity(i);
        //}
    }
}


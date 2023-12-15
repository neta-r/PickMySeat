package com.gambelingapp.seats;

import static java.lang.Integer.min;
import static java.lang.Integer.parseInt;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.gambelingapp.R;

import java.util.Calendar;


public class BookReservationFragment extends Fragment {

    int SelectedNumberOfDiners = -1;
    Button Date, Time, Reserve;
    EditText Name;

    TextView txtDate, txtTime, NumberOfDiners;

    ImageButton Plus, Minus;

    int Diners = 0;
    TextWatcher tt = null;
    Calendar c =null;
    int year = -1;
    int month = -1;
    int day = -1;
    int  hour = -1;
    int minute = -1;

    String strDate = "";
    String  strTime = "";
    String name = "";

    public BookReservationFragment() {
        super(R.layout.fragment_book_reservation);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Date = view.findViewById(R.id.DateBtn);
        Time = view.findViewById(R.id.TimeBtn);
        Plus = view.findViewById(R.id.PlusBtn);
        Minus = view.findViewById(R.id.MinusBtn);
        Reserve = view.findViewById(R.id.Reserve);

        txtDate = view.findViewById(R.id.Date);
        txtTime = view.findViewById(R.id.Time);
        Name = view.findViewById(R.id.Name);
        NumberOfDiners = view.findViewById(R.id.NumberOfDiners);
        NumberOfDiners.setText(String.valueOf(Diners));

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
                name = Name.getText().toString();
            }
        };
        Name.addTextChangedListener(tt);

        Minus.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            public void onClick(View v) {
                if (Diners > 0) {
                    Diners--;
                    NumberOfDiners.setText(Integer.toString(Diners));
                }
            }
        });

        Plus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (Diners <= 5) {
                    Diners++;
                    NumberOfDiners.setText(Integer.toString(Diners));
                } else {
                    Toast.makeText(requireActivity().getApplicationContext(), "Reservations are up to 6 people!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Date.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                c = Calendar.getInstance();
                year = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH);
                day = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(getView().getContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                String d = Integer.toString(dayOfMonth);
                                String m = Integer.toString(monthOfYear+1);
                                String y = Integer.toString(year);
                                if (dayOfMonth<10) d ="0"+Integer.toString(dayOfMonth);
                                if (monthOfYear<10) m="0"+Integer.toString(monthOfYear);
                                strDate = d + "-" + m + "-" + y;
                                txtDate.setText(strDate);
                            }
                        }, year, month, day);
                datePickerDialog.show();
            }
        });

        Time.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                c = Calendar.getInstance();
                hour = c.get(Calendar.HOUR_OF_DAY);
                minute = c.get(Calendar.MINUTE);

                // Launch Time Picker Dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(getView().getContext(),
                        new TimePickerDialog.OnTimeSetListener() {

                            @SuppressLint("SetTextI18n")
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {
                                if (minute<10) strTime=hourOfDay + ":0" + minute;
                                else strTime=hourOfDay + ":" + minute;
                                txtTime.setText(strTime);
                            }
                        }, hour, minute, false);
                timePickerDialog.show();
            }
        });
        Reserve.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           if (year == -1 || month == -1 || day == -1) {
                                               Toast.makeText(requireActivity().getApplicationContext(), "Pick Date", Toast.LENGTH_SHORT).show();
                                           } else if (hour == -1 || minute == -1) {
                                               Toast.makeText(requireActivity().getApplicationContext(), "Pick Time", Toast.LENGTH_SHORT).show();
                                           } else if (Integer.parseInt(NumberOfDiners.getText().toString()) == 0) {
                                               Toast.makeText(requireActivity().getApplicationContext(), "Select number of diners", Toast.LENGTH_SHORT).show();
                                           } else if (Name.getText().toString().equals("")) {
                                               Toast.makeText(requireActivity().getApplicationContext(), "Type name", Toast.LENGTH_SHORT).show();
                                           } else {
                                               BookReservationFragmentDirections.ActionBookReservationFragmentToPickSeatsFragment action =BookReservationFragmentDirections.actionBookReservationFragmentToPickSeatsFragment(name, Diners, strDate, strTime);
                                               action.setName(name);
                                               action.setNumberOfDiners(Diners);
                                               action.setDate(strDate);
                                               action.setTime(strTime);
                                               Navigation.findNavController(view).navigate(R.id.action_bookReservationFragment_to_pickSeatsFragment);
                                           }
                                       }
                                   }
        );
    }
}


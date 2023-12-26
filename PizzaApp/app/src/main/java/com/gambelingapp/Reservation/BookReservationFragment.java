package com.gambelingapp.Reservation;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.gambelingapp.PizzaStore;
import com.gambelingapp.R;
import com.gambelingapp.ReservationObject;
import com.gambelingapp.database.DataGetter;
import com.gambelingapp.database.OnGetDataListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import java.util.ArrayList;
import java.util.Calendar;


public class BookReservationFragment extends Fragment {

    Button Date, Time, Reserve;
    EditText Name;

    TextView txtDate, txtTime, NumberOfDiners;

    ImageButton Plus, Minus;

    int Diners = 0;
    TextWatcher tt = null;

    String strDate = "";
    String strTime = "";
    String name = "";

    ArrayList<String> unavailableTables = new ArrayList<>();
    ArrayList<String> availableTables = new ArrayList<>();

    int numberOfReservation = 1;

    ReservationObject reservationObject;

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
                if (Diners <= 7) {
                    Diners++;
                    NumberOfDiners.setText(Integer.toString(Diners));
                } else {
                    Toast.makeText(requireActivity().getApplicationContext(), "Reservations are up to 8 people!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Date.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        Time.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                showTimePickerDialog();
            }
        });
        Reserve.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           if (strDate.equals("")) {
                                               Toast.makeText(requireActivity().getApplicationContext(), "Pick Date", Toast.LENGTH_SHORT).show();
                                           } else if (strTime.equals("")) {
                                               Toast.makeText(requireActivity().getApplicationContext(), "Pick Time", Toast.LENGTH_SHORT).show();
                                           } else if (Integer.parseInt(NumberOfDiners.getText().toString()) == 0) {
                                               Toast.makeText(requireActivity().getApplicationContext(), "Select number of diners", Toast.LENGTH_SHORT).show();
                                           } else if (Name.getText().toString().equals("")) {
                                               Toast.makeText(requireActivity().getApplicationContext(), "Type name", Toast.LENGTH_SHORT).show();
                                           } else if (!Name.getText().toString().matches("[a-zA-Z]+")) {
                                               Toast.makeText(requireActivity().getApplicationContext(), "Only alphabetic characters are allowed", Toast.LENGTH_SHORT).show();
                                           } else {
                                               name = Name.getText().toString();
                                               reservationObject = new ReservationObject(name, Diners, strDate, strTime);
                                               loadDataFromDatabase(view);


                                           }
                                       }
                                   }
        );
    }

    private void loadDataFromDatabase(View view) {
        new DataGetter().readData(reservationObject, new OnGetDataListener() {
            @Override
            public void onStart() {
            }

            @Override
            public void onSuccess(DataSnapshot data) {
                numberOfReservation = (int) data.getChildrenCount() + 1;
                reservationObject.setReservationNumber(numberOfReservation);

                //check unavailable tables according to database and number of diners
                checkAvailability(data);
                //create available tables list
                AvailablePlace();

                Bundle bundle = new Bundle();
                bundle.putParcelable("ResObj", reservationObject);
                Fragment fragment = new Fragment();
                fragment.setArguments(bundle);

                if (availableTables.size() > 0) {

                    reservationObject.setAvailableTableLst(availableTables);
                    Navigation.findNavController(view).navigate(R.id.action_bookReservationFragment_to_pickSeatsFragment, bundle);
                } else {
                    Navigation.findNavController(view).navigate(R.id.action_bookReservationFragment_to_fragment_reservation_falied, bundle);
                }
            }

            @Override
            public void onFailed(DatabaseError databaseError) {
            }
        });
    }

    private void checkAvailability(DataSnapshot data) {
        for (DataSnapshot snapshot : data.getChildren()) {
            String currTable = snapshot.child("Table tag").getValue().toString();
            unavailableTables.add(currTable);
        }
    }

    private void buildAvailableTablesList(int numberOfTable, String tableColor) {
        for (int i = 1; i <= numberOfTable; i++) {
            if (!unavailableTables.contains(tableColor + i)) {
                availableTables.add(tableColor + i);
            }
        }
    }

    private void AvailablePlace() {
        if (reservationObject.getNumOfDiners() == 1 || reservationObject.getNumOfDiners() == 2) {
            buildAvailableTablesList(5, "orange");
        } else if (reservationObject.getNumOfDiners() == 3 || reservationObject.getNumOfDiners() == 4) {
            buildAvailableTablesList(12, "blue");
        } else if (reservationObject.getNumOfDiners() == 5 || reservationObject.getNumOfDiners() == 6) {
            buildAvailableTablesList(3, "pink");
        } else if (reservationObject.getNumOfDiners() == 7 || reservationObject.getNumOfDiners() == 8) {
            buildAvailableTablesList(4, "green");
        }

    }

    private void initializePicker(String[] pickerValues, NumberPicker picker) {
        picker.setMinValue(0);
        picker.setMaxValue(pickerValues.length - 1);
        picker.setDisplayedValues(pickerValues);
    }

    private String[] initializeValues(int max) {
        String[] values = new String[max];
        for (int i = 0; i < max; i++) {
            values[i] = Integer.toString(i + 1);
        }
        return values;
    }

    private void showTimePickerDialog() {
        Dialog timePickerDialog = new Dialog(requireContext());
        timePickerDialog.setCancelable(false);
        timePickerDialog.setContentView(R.layout.time_picker_dialog);
        NumberPicker hourPicker = timePickerDialog.findViewById(R.id.hourPicker);
        NumberPicker minutePicker = timePickerDialog.findViewById(R.id.minutePicker);
        String[] pickerHoursValues = new String[]{"10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22"};
        String[] pickerMinutesValues = new String[]{"00", "15", "30", "45"};

        initializePicker(pickerHoursValues, hourPicker);
        initializePicker(pickerMinutesValues, minutePicker);

        Button ok = timePickerDialog.findViewById(R.id.Ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strTime = pickerHoursValues[hourPicker.getValue()] + ":" + pickerMinutesValues[minutePicker.getValue()];
                txtTime.setText(strTime);
                timePickerDialog.dismiss();
            }
        });
        timePickerDialog.show();
    }

    private void showDatePickerDialog() {
        Dialog datePickerDialog = new Dialog(requireContext());
        datePickerDialog.setCancelable(false);
        datePickerDialog.setContentView(R.layout.date_picker_dialog);
        NumberPicker dayPicker = datePickerDialog.findViewById(R.id.dayPicker);
        NumberPicker monthPicker = datePickerDialog.findViewById(R.id.monthPicker);
        NumberPicker yearPicker = datePickerDialog.findViewById(R.id.yearPicker);
        String[] pickerDayValues = initializeValues(31);
        String[] pickerMonthValues = initializeValues(12);
        String[] pickerYearValues = new String[]{"2023", "2024"};

        initializePicker(pickerDayValues, dayPicker);
        initializePicker(pickerMonthValues, monthPicker);
        initializePicker(pickerYearValues, yearPicker);


        Button ok = datePickerDialog.findViewById(R.id.Ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String d = pickerDayValues[dayPicker.getValue()];
                String m = pickerMonthValues[monthPicker.getValue()];
                String y = pickerYearValues[yearPicker.getValue()];
                if (valueOf(pickerDayValues[dayPicker.getValue()]) < 10) d = "0" + pickerDayValues[dayPicker.getValue()];
                if (valueOf(pickerMonthValues[monthPicker.getValue()]) < 10) m = "0" + pickerMonthValues[monthPicker.getValue()];
                strDate = d + "-" + m + "-" + y;
                txtDate.setText(strDate);
                datePickerDialog.dismiss();
            }
        });
        datePickerDialog.show();
    }

}



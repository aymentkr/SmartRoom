package com.example.myapplication.ui.home;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentHomeBinding;

import java.util.Calendar;

public class HomeFragment extends Fragment {

    private Button setButton;
    private TableLayout setsTableLayout;
    private Button saveButton;

    Button btnDatePicker, btnTimePicker;
    EditText txtDate, txtTime;
    private int mYear, mMonth, mDay, mHour, mMinute;

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        LinearLayout mainLinearLayout = root.findViewById(R.id.mainLinearLayout);
        btnDatePicker=(Button)root.findViewById(R.id.btn_date);
        btnTimePicker=(Button)root.findViewById(R.id.btn_time);
        txtDate=(EditText)root.findViewById(R.id.in_date);
        txtTime=(EditText)root.findViewById(R.id.in_time);

        btnDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get Current Date
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(requireContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                            }
                        }, mYear, mMonth, mDay);

                datePickerDialog.show();
            }
        });

        btnTimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get Current Time
                final Calendar c = Calendar.getInstance();
                mHour = c.get(Calendar.HOUR_OF_DAY);
                mMinute = c.get(Calendar.MINUTE);

                // Launch Time Picker Dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(requireContext(),
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                txtTime.setText(hourOfDay + ":" + minute);
                            }
                        }, mHour, mMinute, false);

                timePickerDialog.show();
            }
        });

        setButton = root.findViewById(R.id.setButton);
        setsTableLayout = root.findViewById(R.id.setsTableLayout);
        saveButton = root.findViewById(R.id.saveButton);


        /*
        setButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSet();
            }
        });
*/
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

        // Adjust the layout to avoid the navigation bar
        mainLinearLayout.setPadding(0, 0, 0, saveButton.getHeight());
        return root;
    }

/*
    private void addSet() {
        String hour = timeEditText.getText().toString();
        String temperature = temperatureEditText.getText().toString();
        String durationHour = durationEditText.getText().toString();
        String durationMinute = minutesEditText.getText().toString();

        if (TextUtils.isEmpty(hour) || TextUtils.isEmpty(temperature) || TextUtils.isEmpty(durationHour) || TextUtils.isEmpty(durationMinute)) {
            // Display an error message if any of the fields are empty
            // Handle the error message display as per your application's requirements
            return;
        }

        TableRow row = new TableRow(requireContext());
        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        row.setLayoutParams(layoutParams);

        TextView hourTextView = new TextView(requireContext());
        hourTextView.setText(hour);
        hourTextView.setLayoutParams(new TableRow.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f));

        TextView temperatureTextView = new TextView(requireContext());
        temperatureTextView.setText(temperature);
        temperatureTextView.setLayoutParams(new TableRow.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f));

        TextView durationTextView = new TextView(requireContext());
        String duration = durationHour + "h " + durationMinute + "m";
        durationTextView.setText(duration);
        durationTextView.setLayoutParams(new TableRow.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f));

        Button deleteButton = new Button(requireContext());
        deleteButton.setText("Delete");
        deleteButton.setLayoutParams(new TableRow.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f));

        row.addView(hourTextView);
        row.addView(temperatureTextView);
        row.addView(durationTextView);
        row.addView(deleteButton);

        setsTableLayout.addView(row);
    }
*/
    private void saveData() {
        // Perform the save operation for your data
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
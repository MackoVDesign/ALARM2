package com.example.alarm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import java.sql.Time;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    Button Select_Button;
    int hour;
    int min;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Select_Button = findViewById(R.id.Select_Button_id);
    }

    public void pop_TimePicker(View view) {
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int selecthour, int selectmin) {
                hour= selecthour;
                min= selectmin;

                Select_Button.setText(String.format((Locale.getDefault()), "%02d: %02d", hour, min) );;
            }
        };

        TimePickerDialog timePickerDialog= new TimePickerDialog(this, onTimeSetListener, hour, min, true);

        timePickerDialog.setTitle("Ustaw alarm");
        timePickerDialog.show();
    }
}
package com.example.datepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    DatePickerDialog dpd;

    EditText e;
    Calendar cal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e=(EditText) findViewById(R.id.editText);
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 cal=Calendar.getInstance();
                int year=cal.get(Calendar.YEAR);
                int month=cal.get(Calendar.MONTH);
                  int day=cal.get(Calendar.DAY_OF_MONTH);
                dpd= new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        e.setText(dayOfMonth + "/" +(month+1) + "/" + year);
                    }
                },day,month,year);

                dpd.getDatePicker().setMaxDate(cal.getTimeInMillis()); // to set maximum date into today's date

                // following code to get the current todays' date displaied on DatePicker
                Calendar d = Calendar.getInstance();

                dpd.updateDate(d.get(Calendar.YEAR),d.get(Calendar.MONTH),d.get(Calendar.DAY_OF_MONTH));
             dpd.show();

            }
        });

    }
}

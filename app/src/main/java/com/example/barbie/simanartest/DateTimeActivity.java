package com.example.barbie.simanartest;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import org.w3c.dom.Text;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeActivity extends AppCompatActivity {
    TextView tvTime;
    SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MMM-yyyy // HH:mm:ss ");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time);
        tvTime=(TextView) findViewById(R.id.txttime);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btncurrent:
                getCurrentDateTime();
                break;
            case R.id.btndatepicker:
                eventDatePicker();
                break;
            case R.id.btntimepicker:
                eventTimePicker();
                break;
        }
    }


    public void getCurrentDateTime() {
        Date date=new Date();
        tvTime.setText(dateFormat.format(date.getTime()));
    }

    public void eventDatePicker() {
        Calendar calendar=Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(DateTimeActivity.this,
                new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                tvTime.setText(String.valueOf(year+"-"+(monthOfYear+1)+"-"+dayOfMonth));

            }
        },calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    public void eventTimePicker() {
        Calendar calendar=Calendar.getInstance();
        TimePickerDialog timePickerDialog = new TimePickerDialog(DateTimeActivity.this,
                new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                tvTime.setText(String.valueOf(hourOfDay + " : " + minute));
            }
        }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true);

        timePickerDialog.show();
    }
}

package com.example.sam.scheduler;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    String temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Context ctx = MainActivity.this;

        TextView today = findViewById(R.id.today);
        final CalendarView cal = findViewById(R.id.calendar);
        final TimePicker time = findViewById(R.id.timePicker);
        final TextView year = findViewById(R.id.year);
        final TextView month = findViewById(R.id.month);
        final TextView date = findViewById(R.id.date);
        final TextView hour = findViewById(R.id.hour);
        final TextView minute = findViewById(R.id.minute);

        // 자바에서 오늘 날짜 가져오기
        today.setText(new SimpleDateFormat("yyyy-MM-dd hh:mm").format(new Date()));

        time.setVisibility(View.INVISIBLE);

        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                temp = year + "-" + (month + 1) + "-" + dayOfMonth;

            }

        });

        findViewById(R.id.rdDate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cal.setVisibility(View.VISIBLE);
                time.setVisibility(View.INVISIBLE);

            }

        });

        findViewById(R.id.rdTime).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time.setVisibility(View.VISIBLE);
                cal.setVisibility(View.INVISIBLE);

            }

        });

        findViewById(R.id.confirmBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] arr = temp.split("-");

                year.setText(arr[0]);
                month.setText(arr[1]);
                date.setText(arr[2]);

                hour.setText(String.valueOf(time.getHour()));
                minute.setText(String.valueOf(time.getMinute()));

            }

        });

    }

}

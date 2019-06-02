package com.example.alertapplication;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

public class DayCheckActivity extends AppCompatActivity implements DatePicker.OnDateChangedListener {
    int year, month, day;
    TextView cancel, submit, date2;
    DatePicker mDate;

    TextView mTxtDate;
//Todo timepicker제대로 되면끝
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_check);

        date2 = findViewById(R.id.date2);
        final DatePicker datePicker = (DatePicker) findViewById(R.id.dp);
        datePicker.setOnDateChangedListener(this);

        cancel = findViewById(R.id.btn_cancel3);
        submit = findViewById(R.id.btn_submit3);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), SettingActivity.class);
                intent.putExtra("date", date2.getText());
                startActivity(intent);
            }
        });


    }
    @Override
    public void onDateChanged(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
        date2.setText(year+"년 "+(monthOfYear+1)+"월 "+dayOfMonth+"일");
    }
    }

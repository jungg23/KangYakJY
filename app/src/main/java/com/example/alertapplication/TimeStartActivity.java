package com.example.alertapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class TimeStartActivity extends AppCompatActivity implements TimePicker.OnTimeChangedListener{
    TextView time, submit, delete;
    TimePicker tp;
    Calendar c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_time);
        c = Calendar.getInstance();
        int hourofDay = c.get(c.HOUR_OF_DAY);
        int minute = c.get(c.MINUTE);
        time = findViewById(R.id.tv_time);
        submit = findViewById(R.id.btn_submit8);
        delete = findViewById(R.id.btn_cancel8);
        tp = (TimePicker) findViewById(R.id.tp);
        time.setText(  hourofDay + ":" + minute );
        tp.setOnTimeChangedListener(this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),SettingActivity.class);
                intent.putExtra("time",time.getText().toString());
                intent.putExtra("time2",time.getText().toString());
                intent.putExtra("time3",time.getText().toString());
                intent.putExtra("time4",time.getText().toString());
                intent.putExtra("time5",time.getText().toString());
                startActivity(intent);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
        time.setText("오전" + hourOfDay + ":" + minute );
    }
}

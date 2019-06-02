package com.example.alertapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MeasureActivity extends AppCompatActivity {
    TextView tv1,tv2, tv3, tv4, tv5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measure);

        final Intent intent = new Intent(getBaseContext(), SettingActivity.class);

        tv1 = findViewById(R.id.mon1);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("what","알");
                startActivity(intent);
            }
        });
        tv2 = findViewById(R.id.tue1);
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("what","ml");
                startActivity(intent);
            }
        });
        tv3 = findViewById(R.id.wed1);
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("what","그램");
                startActivity(intent);
            }
        });
        tv4 = findViewById(R.id.thur1);
        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("what","mg");
                startActivity(intent);
            }
        });
        tv5 = findViewById(R.id.fri1);
        tv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("what","방울");
                startActivity(intent);
            }
        });
    }
}

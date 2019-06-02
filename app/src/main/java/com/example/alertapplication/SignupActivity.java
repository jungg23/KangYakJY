package com.example.alertapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {
    TextView textView;
    RadioButton radioButton1, radioButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        radioButton1 = findViewById(R.id.radioButton);
        radioButton2 = findViewById(R.id.radioButton2);
        textView = findViewById(R.id.start_btn);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), SigninActivity.class);
                if(radioButton1.isChecked()){
                    intent.putExtra("check","big");
                    startActivity(intent);
                }else if(radioButton2.isChecked()){
                    intent.putExtra("check","small");
                    startActivity(intent);
                }else{
                    Toast.makeText(getBaseContext(),"테마를 선택해주세요.",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
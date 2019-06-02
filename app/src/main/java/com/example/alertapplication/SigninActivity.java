package com.example.alertapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SigninActivity extends AppCompatActivity {
    EditText signIn_password_et, signup_pw_again_et;

    RadioButton small_cheak, big_cheak;

    TextView start_btn;

    SharedPreferences appData;
    int i;

    private String lock_pw;
    private int theme; //1이면 big, 2면 small, 0은 최초실행(설정안됨)
    private boolean first;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        appData = getSharedPreferences("appData", MODE_PRIVATE);

        first = appData.getBoolean("isFirst", false);

        signIn_password_et = (EditText) findViewById(R.id.signIn_password_et);
        signup_pw_again_et = (EditText) findViewById(R.id.signup_pw_again_et);
        big_cheak = findViewById(R.id.radioButton);
        small_cheak = findViewById(R.id.radioButton2);
        start_btn = findViewById(R.id.start_btn);

        if (first == false) {
            Log.d("Is first Time?", "first");
            start_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SharedPreferences.Editor editor = appData.edit();

                    // 에디터객체.put타입( 저장시킬 이름, 저장시킬 값 )
                    // 저장시킬 이름이 이미 존재하면 덮어씌움

                    if (big_cheak.isChecked()) {
                        editor.putInt("SAVE_THEME_DATA", 1);
                    } else if (small_cheak.isChecked()) {
                        editor.putInt("SAVE_THEME_DATA", 2);
                    } else {
                        Toast.makeText(getBaseContext(), "테마를 선택해주세요.", Toast.LENGTH_SHORT).show();
                    }
                    editor.putString("LOCK_PW", signIn_password_et.getText().toString().trim());
                    editor.putBoolean("isFirst", true);
                    // apply, commit 을 안하면 변경된 내용이 저장되지 않음
                    editor.apply();

                    theme = appData.getInt("SAVE_THEME_DATA", 0);
                    lock_pw = appData.getString("LOCK_PW", "");

                    if (theme == 1) {
                        Intent intent = new Intent(getBaseContext(), MainActivityBig.class);
                        startActivity(intent);
                    } else if (theme == 2) {
                        Intent intent = new Intent(getBaseContext(), MainActivitySmall.class);
                        startActivity(intent);
                    }

                }
            });

        } else {
            Log.d("Is first Time?", "not first");

            if (theme == 1) {
                Intent intent = new Intent(getBaseContext(), MainActivityBig.class);
                startActivity(intent);
            } else if (theme == 2) {
                Intent intent = new Intent(getBaseContext(), MainActivitySmall.class);
                startActivity(intent);
            }
        }
    }
}


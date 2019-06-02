package com.example.alertapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class SettingPassword extends AppCompatActivity {
    TextView cancel, submit;
    String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pw_setting);

        Intent intent = getIntent();

        if(intent.hasExtra("where")){
            s = intent.getExtras().getString("where");
        }

        cancel = findViewById(R.id.pw_set);
        submit = findViewById(R.id.pw_reset);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        SettingPassword.this);

                alertDialogBuilder.setTitle("비밀번호");
                alertDialogBuilder
                        .setMessage("비밀번호를 초기화하시겠습니다.")
                        .setCancelable(false)
                        .setPositiveButton("확인",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(
                                            DialogInterface dialog, int id) {
                                        if(s.equals("small")) {
                                            Intent intent1 = new Intent(getBaseContext(),MainActivitySmall.class);
                                            startActivity(intent1);
                                            Toast.makeText(getBaseContext(),"비밀번호가 0000으로 초기화되었습니다.",Toast.LENGTH_SHORT).show();
                                        }else{
                                            Intent intent2 = new Intent(getBaseContext(),MainActivityBig.class);
                                            startActivity(intent2);
                                            Toast.makeText(getBaseContext(),"비밀번호가 0000으로 초기화되었습니다.",Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                })
                        .setNegativeButton("취소",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(
                                            DialogInterface dialog, int id) {
                                        dialog.cancel();
                                        if(s.equals("small")) {
                                            Intent intent1 = new Intent(getBaseContext(),MainActivitySmall.class);
                                            startActivity(intent1);
                                        }else{
                                            Intent intent2 = new Intent(getBaseContext(),MainActivityBig.class);
                                            startActivity(intent2);
                                        }
                                    }
                                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText et = new EditText(SettingPassword.this);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        SettingPassword.this);

                alertDialogBuilder.setTitle("비밀번호");
                alertDialogBuilder
                        .setView(et)
                        .setCancelable(false)
                        .setPositiveButton("확인",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(
                                            DialogInterface dialog, int id) {
                                        if(s.equals("small")) {
                                            Intent intent1 = new Intent(getBaseContext(),MainActivitySmall.class);
                                            startActivity(intent1);
                                            Toast.makeText(getBaseContext(),"비밀번호가 설정되었습니다.",Toast.LENGTH_SHORT).show();
                                        }else{
                                            Intent intent2 = new Intent(getBaseContext(),MainActivityBig.class);
                                            startActivity(intent2);
                                            Toast.makeText(getBaseContext(),"비밀번호가 설정되었습니다.",Toast.LENGTH_SHORT).show();
                                        }

                                    }
                                })
                        .setNegativeButton("취소",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(
                                            DialogInterface dialog, int id) {
                                        dialog.cancel();
                                        if(s.equals("small")) {
                                            Intent intent1 = new Intent(getBaseContext(),MainActivitySmall.class);
                                            startActivity(intent1);
                                        }else{
                                            Intent intent2 = new Intent(getBaseContext(),MainActivityBig.class);
                                            startActivity(intent2);
                                        }
                                    }
                                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });
    }
}
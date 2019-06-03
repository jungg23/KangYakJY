package com.example.alertapplication;

import android.Manifest;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SettingActivity extends AppCompatActivity {

    ImageView start, alertOften, measure, often, lock, plus;
    TextView delete_btn, plus_btn, how, aday, alert_often, measureT, oftenT, lockedT, dateT, setT;
    EditText name;
    String nameS, adayS, time, where, what;
    String num, date;
    ImageView imageView;
    final int CAMERA_REQUEST_CODE = 1;
    private File tempFile;

    private TextView textView_Date;
    private TimePickerDialog.OnTimeSetListener callbackMethod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        this.InitializeView();
        this.InitializeListener();

        textView_Date = (TextView)findViewById(R.id.tv_alert_often);

        final Intent intent = getIntent();
        imageView = (ImageView)findViewById(R.id.imageView);
        measureT = findViewById(R.id.tv_measure);
        oftenT = findViewById(R.id.tv_locked);
        dateT = findViewById(R.id.tv_start);
        setT = findViewById(R.id.tv_alert_often);
        plus = findViewById(R.id.imageplus_btn);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(setImage()) {
                   Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                   startActivityForResult(intent,CAMERA_REQUEST_CODE);
               }
            }
        });

        if (intent.hasExtra("what")) {
            what = intent.getExtras().getString("what");
            measureT.setText(what);
        }
        if (intent.hasExtra("date")) {
            date = intent.getExtras().getString("date");
            dateT.setText(date);
        }

        final Intent intent10 = new Intent(getBaseContext(), TimeStartActivity.class);


        delete_btn = findViewById(R.id.btn_delete);
        delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cliked(v);
            }
        });
        plus_btn = findViewById(R.id.btn_save);
        measure = findViewById(R.id.btn_measure);
        measure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cliked(v);
            }
        });
        often = findViewById(R.id.btn_often);
        often.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cliked(v);
            }
        });
        lock = findViewById(R.id.btn_locked);
        lock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cliked(v);
            }
        });

        start = findViewById(R.id.btn_start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cliked(v);
            }
        });
        alertOften = findViewById(R.id.btn_alert_often);
        alertOften.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cliked(v);
            }
        });

        name = findViewById(R.id.et_name);
        nameS = name.getText().toString();
        aday = findViewById(R.id.et_often);
        adayS = aday.getText().toString();

        plus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (where == null || where.equals("")) {
                    Intent intent4 = new Intent(getBaseContext(), MainActivitySmall.class);
                    intent4.putExtra("name", nameS);
                    intent4.putExtra("aday", adayS);
                    intent4.putExtra("time222",textView_Date.getText());
                    startActivity(intent4);
                } else {
                    if (where.equals("big")) {
                        Intent intent3 = new Intent(getBaseContext(), MainActivityBig.class);
                        intent3.putExtra("name", nameS);
                        intent3.putExtra("aday", adayS);
                        intent3.putExtra("time222",textView_Date.getText());
                        startActivity(intent3);
                    } else if (where.equals("small")) {
                        Intent intent4 = new Intent(getBaseContext(), MainActivitySmall.class);
                        intent4.putExtra("name", nameS);
                        intent4.putExtra("aday", adayS);
                        intent4.putExtra("time222",textView_Date.getText());
                        startActivity(intent4);
                    }
                }
            }
        });

    }

    public void cliked(View v) {
        switch (v.getId()) {
            case R.id.btn_start:
                Intent intent2 = new Intent(getBaseContext(), DayCheckActivity.class);
                startActivity(intent2);
                break;
            case R.id.btn_alert_often:
                TimePickerDialog dialog = new TimePickerDialog(this, callbackMethod, 8, 10, true);
                dialog.show();
                break;
            case R.id.btn_measure:
                Intent intent22 = new Intent(getBaseContext(), MeasureActivity.class);
                startActivity(intent22);
                break;
            case R.id.btn_often:
                AlertDialog.Builder alertDialogBuilder1 = new AlertDialog.Builder(
                        this);
                alertDialogBuilder1
                        .setCancelable(false)
                        .setPositiveButton("특정요일",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(
                                            DialogInterface dialog, int id) {
                                        aday.setText("특정요일");
                                        Intent intent = new Intent(getBaseContext(), DaysActivity.class);
                                        startActivity(intent);
                                    }
                                })
                        .setNeutralButton("매일",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(
                                            DialogInterface dialog, int id) {
                                        aday.setText("매일");
                                    }
                                })
                        .setNegativeButton("일간격",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(
                                            DialogInterface dialog, int id) {
                                        aday.setText("일간격");
                                        Intent intent = new Intent(getBaseContext(), OftenActivity.class);
                                        startActivity(intent);
                                    }
                                });
                AlertDialog alertDialog1 = alertDialogBuilder1.create();
                alertDialog1.show();
                break;
            case R.id.btn_locked:
                AlertDialog.Builder alertDialogBuilder3 = new AlertDialog.Builder(this);
                alertDialogBuilder3
                        .setCancelable(false)
                        .setPositiveButton("아니요",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(
                                            DialogInterface dialog, int id) {
                                        oftenT.setText("아니요");
                                    }
                                })
                        .setNegativeButton("네",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(
                                            DialogInterface dialog, int id) {
                                        oftenT.setText("네");
                                    }
                                });
                AlertDialog alertDialog3 = alertDialogBuilder3.create();
                alertDialog3.show();
                break;
            case R.id.btn_delete:
                AlertDialog.Builder alertDialogBuilder2 = new AlertDialog.Builder(
                        this);
                alertDialogBuilder2.setTitle("주의");
                alertDialogBuilder2
                        .setMessage("저장하지 않고 종료 하시겠습니까?")
                        .setCancelable(false)
                        .setPositiveButton("아니요",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(
                                            DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                })
                        .setNegativeButton("예",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(
                                            DialogInterface dialog, int id) {
                                        if (where == null || where.equals("")) {
                                            Intent intent4 = new Intent(getBaseContext(), MainActivitySmall.class);
                                            startActivity(intent4);
                                        } else {
                                            if (where.equals("big")) {
                                                Intent intent3 = new Intent(getBaseContext(), MainActivityBig.class);
                                                startActivity(intent3);
                                            } else if (where.equals("small")) {
                                                Intent intent4 = new Intent(getBaseContext(), MainActivitySmall.class);
                                                startActivity(intent4);
                                            }
                                        }
                                    }
                                });
                AlertDialog alertDialog2 = alertDialogBuilder2.create();
                alertDialog2.show();
                break;

        }
    }

    public void InitializeView()
    {
        textView_Date = (TextView)findViewById(R.id.tv_alert_often);
    }

    public void InitializeListener()
    {
        callbackMethod = new TimePickerDialog.OnTimeSetListener()
        {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute)
            {
                textView_Date.setText(hourOfDay + "시 " + minute + "분");
            }
        };
    }





    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

      if(requestCode == CAMERA_REQUEST_CODE) {
          Bundle bundle = data.getExtras();
          Bitmap bitmap = (Bitmap)bundle.get("data");
          imageView.setImageBitmap(bitmap);
      }
    }

    public boolean setImage() {

        PackageManager packageManager = getPackageManager();
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        List<ResolveInfo> list = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return list.size() >0;


    }
}
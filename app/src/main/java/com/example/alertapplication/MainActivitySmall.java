package com.example.alertapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivitySmall extends AppCompatActivity {
    ListViewAdapter2 adapter;
    final Context context = this;
    String aday, name, time;
    ImageView img;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_actions, menu) ;
        return true ;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_account :
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivitySmall.this);
                alertDialogBuilder.setTitle("권한 변경");
                alertDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("사용자",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(
                                            DialogInterface dialog, int id) {
                                        Toast.makeText(getBaseContext(),"사용자로 권한 변경.",Toast.LENGTH_SHORT).show();
                                    }
                                })
                        .setNegativeButton("관리자",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(
                                            DialogInterface dialog, int id) {
                                        Toast.makeText(getBaseContext(),"관리자로 권한 변경.",Toast.LENGTH_SHORT).show();
                                    }
                                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
                return true ;
            case R.id.menu_pw :
                Intent intent2 = new Intent(getBaseContext(), SettingPassword.class);
                intent2.putExtra("where","small");
                startActivity(intent2);
                return true ;
            case R.id.menu_logout :
                Intent intent = new Intent(getBaseContext(), SigninActivity.class);
                startActivity(intent);
                return true ;
            default :
                return super.onOptionsItemSelected(item) ;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_small);

        Intent intent = getIntent();
        if (intent.hasExtra("name")) {
            name = intent.getExtras().getString("name");
            aday = intent.getExtras().getString("aday");
        }
        if(intent.hasExtra("time222")){
            time = intent.getExtras().getString("time222");
        }

        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageView imageView = (ImageView) findViewById(R.id.plus_btn2);
        GradientDrawable drawable = (GradientDrawable) getDrawable(R.drawable.back_round);
        imageView.setBackground(drawable);
        imageView.setClipToOutline(true);


        final ImageView imageView2 = (ImageView) findViewById(R.id.locked_btn);
        GradientDrawable drawable2 = (GradientDrawable) getDrawable(R.drawable.back_round);
        imageView2.setBackground(drawable2);
        imageView2.setClipToOutline(true);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivitySmall.this.onClicked(v);
            }
        });

        img = imageView2;
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivitySmall.this.onClicked(v);
            }
        });

        adapter = new ListViewAdapter2();
        final ListView listview = findViewById(R.id.list_view10);
        adapter.addItem(ContextCompat.getDrawable(getBaseContext(), R.drawable.drug_base_img),
                "비타민", "매일 식후 1번", "13:00", "복용안함");
        adapter.addItem(ContextCompat.getDrawable(getBaseContext(), R.drawable.drug_base_img),
                "피임약", "매일 식후 1번", "10:00", "복용안함");
        if (aday != null) {
            adapter.addItem(ContextCompat.getDrawable(getBaseContext(), R.drawable.drug_base_img),
                    name, aday, time, "복용안함");
        }
        listview.setAdapter(adapter);
        listview.setFocusable(false);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getBaseContext(), SettingActivity.class);
                intent.putExtra("where","small");
                startActivity(intent);
            }
        });
    }

    public void onClicked(View v) {
        Intent intent = new Intent(getBaseContext(), SettingActivity.class);
        intent.putExtra("where","small");
        final EditText et = new EditText(this);
        switch (v.getId()) {
            case R.id.locked_btn:
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);

                alertDialogBuilder.setTitle("비밀번호");
                alertDialogBuilder
                        .setView(et)
                        .setCancelable(false)
                        .setPositiveButton("확인",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(
                                            DialogInterface dialog, int id) {
                                        img.setVisibility(View.INVISIBLE);
                                    }
                                })
                        .setNegativeButton("취소",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(
                                            DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
                break;
            case R.id.plus_btn2:
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
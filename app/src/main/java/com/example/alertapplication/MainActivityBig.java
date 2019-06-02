package com.example.alertapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivityBig extends AppCompatActivity implements View.OnClickListener  {
    ListViewAdapter adapter;
    String aday, name;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_actions, menu) ;

        return true ;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_account :
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        MainActivityBig.this);
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
                intent2.putExtra("where","big");
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
        setContentView(R.layout.activity_main_big);

        Intent intent = getIntent();
        if (intent.hasExtra("name")) {
            name = intent.getExtras().getString("name");
            aday = intent.getExtras().getString("aday");
        }

        final Intent intent1 = new Intent(getBaseContext(), SettingActivity.class);
        intent1.putExtra("where","big");


        android.support.v7.widget.Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageView imageView = (ImageView) findViewById(R.id.plus_btn);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent1);
            }
        });
        GradientDrawable drawable=(GradientDrawable) getDrawable(R.drawable.back_round);
        imageView.setBackground(drawable);
        imageView.setClipToOutline(true);

        adapter = new ListViewAdapter() ;
        final ListView listview = findViewById(R.id.listview);
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.drug_img),
                "혈압약", "복용") ;
        if (name != null) {
            adapter.addItem(ContextCompat.getDrawable(getBaseContext(), R.drawable.drug_img),
                    name, "복용안함");
        }
        adapter.notifyDataSetChanged();
        listview.setAdapter(adapter);
        listview.setFocusable(false);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {

                startActivity(intent1);
            }
        });

    }

    @Override
    public void onClick(View v) {
    }
}

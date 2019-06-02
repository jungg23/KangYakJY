package com.example.alertapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class HowMuchADay extends AppCompatActivity {

    static final ArrayList<String> list = new ArrayList<>(Arrays.asList("하루에 1번",
            "하루에 2번", "하루에 3번","하루에 4번","하루에 5번","하루에 10번","하루에 11번","하루에 12번"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_much_aday);

        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list) ;
        final ListView listview = findViewById(R.id.listview_aday) ;
        listview.setAdapter(adapter) ;
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getBaseContext(),SettingActivity.class);
                intent.putExtra("how",list.get(position));
                startActivity(intent);
            }
        });
    }
}

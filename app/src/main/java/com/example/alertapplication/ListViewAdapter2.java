package com.example.alertapplication;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter2 extends BaseAdapter {

    private ArrayList<ListData2> listViewItemList2 = new ArrayList<>();
    public ListViewAdapter2() {

    }

    @Override
    public int getCount() {
        return listViewItemList2.size() ;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_small, parent, false);
        }

        ImageView iconImageView = convertView.findViewById(R.id.imageView2) ;
        TextView titleTextView = convertView.findViewById(R.id.title) ;
        TextView howMuch = convertView.findViewById(R.id.howMuch);
        TextView time = convertView.findViewById(R.id.time);
        final Button descTextView = convertView.findViewById(R.id.modifybtn2) ;
        descTextView.setFocusable(false);
        descTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                descTextView.setText("복용완료");
            }
        });

        ListData2 listViewItem2 = listViewItemList2.get(position);

        iconImageView.setImageDrawable(listViewItem2.getDrawables());
        titleTextView.setText(listViewItem2.getTitle());
        howMuch.setText(listViewItem2.getHowMuch());
        time.setText(listViewItem2.getTime());
        descTextView.setText(listViewItem2.getEat());

        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return position ;
    }

    @Override
    public Object getItem(int position) {
        return listViewItemList2.get(position) ;
    }

    public void addItem(Drawable icon, String title, String howMuch, String time, String desc) {
        ListData2 item = new ListData2();

        item.setDrawables(icon);
        item.setTitle(title);
        item.setHowMuch(howMuch);
        item.setTime(time);
        item.setEat(desc);

        listViewItemList2.add(item);
    }
}
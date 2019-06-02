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

public class ListViewAdapter extends BaseAdapter {

    private ArrayList<ListData> listViewItemList = new ArrayList<ListData>() ;
    public ListViewAdapter() {

    }

    @Override
    public int getCount() {
        return listViewItemList.size() ;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_big, parent, false);
        }

        ImageView iconImageView = convertView.findViewById(R.id.imageView) ;
        TextView titleTextView = convertView.findViewById(R.id.textView) ;
        final Button descTextView = convertView.findViewById(R.id.modifybtn) ;

        ListData listViewItem = listViewItemList.get(position);

        iconImageView.setImageDrawable(listViewItem.getUser());
        titleTextView.setText(listViewItem.getUsername());
        descTextView.setText(listViewItem.getWhere());
        descTextView.setFocusable(false);
        descTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                descTextView.setText("복용완료");
            }
        });


        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return position ;
    }

    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position) ;
    }

    public void addItem(Drawable icon, String title, String desc) {
        ListData item = new ListData();

        item.setUser(icon);
        item.setUsername(title);
        item.setWhere(desc);

        listViewItemList.add(item);
    }
}
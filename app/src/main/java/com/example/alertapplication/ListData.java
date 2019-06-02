package com.example.alertapplication;

import android.graphics.drawable.Drawable;

public class ListData {
    public Drawable drawable;
    public String username;
    public String where;

    public ListData(){

    }

    public ListData(Drawable drawable, String username, String where){
        this.drawable = drawable;
        this.username = username;
        this.where = where;
    }


    public void setUser(Drawable drawable) {
        this.drawable = drawable;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public Drawable getUser() {
        return drawable;
    }

    public String getUsername() {
        return username;
    }

    public String getWhere() {
        return where;
    }
}

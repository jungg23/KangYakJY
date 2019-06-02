package com.example.alertapplication;

import android.graphics.drawable.Drawable;

public class ListData2 {
    Drawable drawables;
    String title;
    String howMuch;
    String time;
    String eat;

    public ListData2(){

    }

    public ListData2( Drawable drawables, String title, String howMuch, String time, String eat){
        this.drawables = drawables;
        this.title = title;
        this.howMuch = howMuch;
        this.time = time;
        this.eat =eat;
    }

    public Drawable getDrawables() {
        return drawables;
    }

    public String getEat() {
        return eat;
    }

    public String getHowMuch() {
        return howMuch;
    }

    public String getTime() {
        return time;
    }

    public String getTitle() {
        return title;
    }

    public void setDrawables(Drawable drawables) {
        this.drawables = drawables;
    }

    public void setEat(String eat) {
        this.eat = eat;
    }

    public void setHowMuch(String howMuch) {
        this.howMuch = howMuch;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

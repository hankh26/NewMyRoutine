package com.hh1995.myroutine;

import android.widget.ListView;

public class RoutineItem {
    String title;
    String date;
    ListView listView;

    public RoutineItem() {
    }

    public RoutineItem(String title, String date, ListView listView) {
        this.title = title;
        this.date = date;
        this.listView = listView;
    }
}

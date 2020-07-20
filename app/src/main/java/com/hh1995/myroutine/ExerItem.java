package com.hh1995.myroutine;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExerItem {
    String exName;
    ArrayList<SetItem> setItems=new ArrayList<>();

    public ExerItem(String exName, ArrayList<SetItem> setItems) {
        this.exName = exName;
        this.setItems = setItems;
    }

    public ExerItem() {
    }

    public ExerItem(String exName) {
        this.exName = exName;
    }
}

package com.hh1995.myroutine;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class RoutineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routine);


    }

    public void clickPlus(View view) {
        Intent intent=new Intent(RoutineActivity.this,RoutineoptionActivity.class);
        startActivity(intent);
    }
}

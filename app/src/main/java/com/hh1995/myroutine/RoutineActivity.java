package com.hh1995.myroutine;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RoutineActivity extends AppCompatActivity {

    ArrayList<RoutineItem> items=new ArrayList<>();
    RoutineAdapter adapter;
    RecyclerView recyclerView;
    TextView Rtitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routine);

        items.add(new RoutineItem("밴치","오늘"));

        recyclerView=findViewById(R.id.myRoutine);
        adapter=new RoutineAdapter(this,items);
        recyclerView.setAdapter(adapter);

        Rtitle=findViewById(R.id.routine_title);
    }

    public void clickPlus(View view) {
        Intent intent=new Intent(RoutineActivity.this,RoutineoptionActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 & resultCode == RESULT_OK) {
        }

    }
}

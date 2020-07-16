package com.hh1995.myroutine;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RoutineoptionActivity extends AppCompatActivity {
    EditText et;
    TextView tvSet;
    TextView setNum;
    ImageButton up;
    ImageButton down;

    int num=0;

    ArrayList<ExerItem> items=new ArrayList<>();
    ExerAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routineoption);

        et=findViewById(R.id.ett);


        adapter=new ExerAdapter(this,items);
        recyclerView=findViewById(R.id.addRecycler);
        recyclerView.setAdapter(adapter);



    }

    public void clickExerciseAdd(View view) {
            items.add(0,new ExerItem());
            adapter.notifyDataSetChanged();
    }


    public void clickMove(View view) {
        switch (view.getId()){
            case R.id.btnStorage:

                break;
            case R.id.btnBack:
                finish();

                break;
        }
    }
}

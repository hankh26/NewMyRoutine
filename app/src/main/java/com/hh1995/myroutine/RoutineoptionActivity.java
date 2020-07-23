package com.hh1995.myroutine;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

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

    String[] name;
    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routineoption);

        et=findViewById(R.id.ett);
        adapter=new ExerAdapter(this,items);
        recyclerView=findViewById(R.id.addRecycler);
        recyclerView.setAdapter(adapter);

        title=et.getText().toString();
    }

    public void clickExerciseAdd(View view) {
            items.add(0,new ExerItem());
            adapter.notifyItemInserted(0);
    }


    public void clickMove(View view) {
        switch (view.getId()){
            case R.id.btnStorage:
                Intent intent=new Intent(this,RoutineActivity.class);
                intent.putExtra("title",title);
                setResult(100,intent);
                finish();

                break;
            case R.id.btnBack:
                finish();

                break;
        }
    }
}

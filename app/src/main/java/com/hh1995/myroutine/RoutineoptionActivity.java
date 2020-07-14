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

public class RoutineoptionActivity extends AppCompatActivity {
    EditText et;
    TextView tvSet;
    TextView setNum;
    ImageButton up;
    ImageButton down;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routineoption);
    }

    public void clickExerciseAdd(View view) {
        AlertDialog.Builder builder= new AlertDialog.Builder(this);

        builder.setTitle("운동 추가");

        LayoutInflater inflater=this.getLayoutInflater();
        View v=inflater.inflate(R.layout.routine_dialog,null);
        et=v.findViewById(R.id.ex_name);
        tvSet=v.findViewById(R.id.tv_set);
        setNum=v.findViewById(R.id.set_num);
        up=v.findViewById(R.id.num_up);
        down=v.findViewById(R.id.num_down);
        builder.setView(v);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog dialog=builder.create();
        dialog.setCancelable(true);
        dialog.show();
    }
}

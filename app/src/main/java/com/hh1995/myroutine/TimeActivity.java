package com.hh1995.myroutine;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TimeActivity extends AppCompatActivity {

    TextView timeOut;
    TextView tvSet;

    Button btnStart;
    Button btnCancel;

    EditText etM;
    EditText etS;

    CountDownTimer timer;

   String etSecondNum="";
   String etMinNum="";

    String text="";
    String text1="";
    String text2="";

    final static int Init=0;
    final static int Run=1;
    final static int Pause=2;

    int cur_Status=Run;

    long test;

    int a;


    int num=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        btnStart = findViewById(R.id.btn_tstart);
        btnCancel = findViewById(R.id.btn_cancel);
        timeOut = findViewById(R.id.time_out);
        tvSet = findViewById(R.id.tv_set);


    }

    public void clickStop(View view) {
        Intent intent=new Intent(TimeActivity.this,TimerActivity.class);
        startActivity(intent);
        finish();

    }


    public void myOnClick(View view) throws InterruptedException {
        switch (view.getId()) {
            case R.id.btn_tstart:
                text = timeOut.getText().toString();
                text1 = text.replace(":", "");
                countDowmTimer(text1);
                timer.start();
                btnStart.setVisibility(View.INVISIBLE);
                btnCancel.setVisibility(View.VISIBLE);
                break;

            case R.id.btn_cancel:
                timer.cancel();
                timeOut.setText(text);
                btnStart.setVisibility(View.VISIBLE);
                btnCancel.setVisibility(View.INVISIBLE);
                break;

        }

    }

    public void countDowmTimer(final String time){
        long ctime=0;
        String getMin=time.substring(0,2);
        String getSecond=time.substring(2,4);

        if (getMin.substring(0, 1) == "0") {
            getMin = getMin.substring(1, 2);
        }

        if (getSecond.substring(0, 1) == "0") {
            getSecond = getSecond.substring(1, 2);
        }

        ctime=Long.valueOf(getMin)*60*1000+Long.valueOf(getSecond)*1000;
        timer=new CountDownTimer(ctime,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long getMin = millisUntilFinished - (millisUntilFinished / (60 * 60 * 1000)) ;
                test=getMin;
                String min = String.valueOf(getMin / (60 * 1000));

                String second = String.valueOf((getMin % (60 * 1000)) / 1000);

                String millis = String.valueOf((getMin % (60 * 1000)) % 1000);

                if (min.length() == 1) {
                    min = "0" + min;
                }

                if (second.length() == 1) {
                    second = "0" + second;
                }
                timeOut.setText(min + ":" + second);

            }

            @Override
            public void onFinish() {
                timeOut.setText(text);

                num++;
                tvSet.setText(num+"");
                btnCancel.setVisibility(View.INVISIBLE);
                btnStart.setVisibility(View.VISIBLE);
            }
        };


    }

    public void clickop(View view) {

        AlertDialog.Builder builder= new AlertDialog.Builder(this);

        builder.setTitle("시간설정");

        LayoutInflater inflater=this.getLayoutInflater();
        View v=inflater.inflate(R.layout.timer_list,null);
        etM = findViewById(R.id.etm);
        etS = findViewById(R.id.ets);

        builder.setView(v);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                etM = (EditText)((AlertDialog)dialog).findViewById(R.id.etm);
                etS = (EditText)((AlertDialog)dialog).findViewById(R.id.ets);
                etMinNum=etM.getText().toString();
                etSecondNum=etS.getText().toString();
                if (etMinNum.length() == 1) {
                    etMinNum = "0" + etMinNum;
                }
                if (etMinNum.length()==0){
                    etMinNum = "00" + etMinNum;
                }

                if (etSecondNum.length() == 1) {
                    etSecondNum = "0" + etSecondNum;
                }
                if (etSecondNum.length() == 0) {
                    etSecondNum = "00" + etSecondNum;
                }

                timeOut.setText(etMinNum+":"+etSecondNum);
                btnStart.setEnabled(true);

            }
        });
        AlertDialog dialog=builder.create();
        dialog.setCancelable(true);
        dialog.show();


    }

    public void clickReset(View view) {
        num=0;
        tvSet.setText(num+"");
    }
}

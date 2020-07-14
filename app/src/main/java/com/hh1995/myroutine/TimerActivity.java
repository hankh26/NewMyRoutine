package com.hh1995.myroutine;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TimerActivity extends AppCompatActivity {
    TextView Output;
    TextView Record;
    Button BtnStart;
    Button BtnRec;

    final static int Init=0;
    final static int Run=1;
    final static int Pause=2;

    int cur_Status=Init;
    int Count=1;
    long BaseTime;
    long PauseTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        Output=findViewById(R.id.time_out);
        Record=findViewById(R.id.record);
        BtnStart=findViewById(R.id.btn_start);
        BtnRec=findViewById(R.id.btn_rec);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    public void myOnClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start:
            switch (cur_Status) {
                case Init:
                    BaseTime = SystemClock.elapsedRealtime();
                    System.out.println(BaseTime);
                    myTimer.sendEmptyMessage(0);
                    BtnStart.setText("멈춤");
                    BtnRec.setEnabled(true);
                    cur_Status=Run;
                    break;
                case Run:
                    myTimer.removeMessages(0);
                    PauseTime=SystemClock.elapsedRealtime();
                    BtnStart.setText("시작");
                    BtnRec.setText("리셋");
                    cur_Status=Pause;
                    break;
                case Pause:
                    long now=SystemClock.elapsedRealtime();
                    myTimer.sendEmptyMessage(0);
                    BaseTime+=(now-PauseTime);
                    BtnStart.setText("멈춤");
                    BtnRec.setText("기록");
                    cur_Status=Run;
                    break;
            }
            break;
            case R.id.btn_rec:
                switch(cur_Status){
                    case Run:

                        String str = Record.getText().toString();
                        str +=  String.format("%d. %s\n",Count,getTimeOut());
                        Record.setText(str);
                        Count++; //카운트 증가

                        break;
                    case Pause:
                        //핸들러를 멈춤
                        myTimer.removeMessages(0);

                        BtnStart.setText("시작");
                        BtnRec.setText("기록");
                        Output.setText("00:00:00");

                        cur_Status = Init;
                        Count = 1;
                        Record.setText("");
                        BtnRec.setEnabled(false);
                        break;
                }
                break;

        }

    }
    Handler myTimer=new Handler(){
        public void handleMessage(Message msg){
            Output.setText(getTimeOut());
            myTimer.sendEmptyMessage(0);
        }
    };
    String getTimeOut(){
        long now=SystemClock.elapsedRealtime();
        long outTime=now-BaseTime;
        String easyOutTime=String.format("%02d:%02d:%02d",outTime/1000/60,(outTime/1000)%60,(outTime%1000)/10);
        return easyOutTime;
    }


    public void clickTimer(View view) {
        Intent intent=new Intent(TimerActivity.this,TimeActivity.class);
        startActivity(intent);
        finish();
    }
}

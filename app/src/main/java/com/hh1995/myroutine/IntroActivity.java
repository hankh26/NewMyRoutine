package com.hh1995.myroutine;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        handler.sendEmptyMessageDelayed(0,2000);

    }
    Handler handler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            Intent intent=new Intent(IntroActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();
        }
    };
}

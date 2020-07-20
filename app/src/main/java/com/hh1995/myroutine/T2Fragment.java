package com.hh1995.myroutine;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class T2Fragment extends Fragment {
    TextView weather;
    Context context;

    TextView mon;
    TextView tue;
    TextView wed;
    TextView thu;
    TextView fri;
    TextView sat;
    TextView sun;

    TextView tvmon;
    TextView tvtue;
    TextView tvwed;
    TextView tvthu;
    TextView tvfri;
    TextView tvsat;
    TextView tvsun;

    TextView schTv;
    EditText schEt;


    Button reset;


    
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_2,container,false);

        mon=v.findViewById(R.id.mon);
        tue=v.findViewById(R.id.tue);
        wed=v.findViewById(R.id.wed);
        thu=v.findViewById(R.id.thu);
        fri=v.findViewById(R.id.fri);
        sat=v.findViewById(R.id.sat);
        sun=v.findViewById(R.id.sun);

        tvmon=v.findViewById(R.id.tv_mon);
        tvtue=v.findViewById(R.id.tv_tue);
        tvwed=v.findViewById(R.id.tv_wed);
        tvthu=v.findViewById(R.id.tv_thur);
        tvfri=v.findViewById(R.id.tv_fri);
        tvsat=v.findViewById(R.id.tv_sat);
        tvsun=v.findViewById(R.id.tv_sun);
//
//
//        Intent intent=new Intent(getContext(),MainActivity.class);
//        startActivityForResult(intent,50);







        mon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
                builder.setTitle("일정 변경");

                LayoutInflater inflater1=getActivity().getLayoutInflater();
                View vv=inflater1.inflate(R.layout.sch_dialog,null);
                schTv=vv.findViewById(R.id.sch_tv);
                schEt=vv.findViewById(R.id.sch_et);
                builder.setView(vv);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String strMon = schEt.getText().toString();
                        tvmon.setText(strMon+"");

                        SharedPreferences pref=getContext().getSharedPreferences("Mon",Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor= pref.edit();
                        editor.putString("strMon",strMon);
                        editor.commit();
                    }
                });

                AlertDialog dialog=builder.create();
                dialog.setCancelable(true);
                dialog.show();
            }
        });


        tue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
                builder.setTitle("일정 변경");

                LayoutInflater inflater1=getActivity().getLayoutInflater();
                View vv=inflater1.inflate(R.layout.sch_dialog,null);
                schTv=vv.findViewById(R.id.sch_tv);
                schEt=vv.findViewById(R.id.sch_et);
                builder.setView(vv);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String str = schEt.getText().toString();
                        tvtue.setText(str+"");
                        SharedPreferences pref=getContext().getSharedPreferences("Tue",Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor= pref.edit();
                        editor.putString("tueMon",str);
                        editor.commit();

                    }
                });

                AlertDialog dialog=builder.create();
                dialog.setCancelable(true);
                dialog.show();
            }
        });
        wed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
                builder.setTitle("일정 변경");

                LayoutInflater inflater1=getActivity().getLayoutInflater();
                View vv=inflater1.inflate(R.layout.sch_dialog,null);
                schTv=vv.findViewById(R.id.sch_tv);
                schEt=vv.findViewById(R.id.sch_et);
                builder.setView(vv);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String strMon = schEt.getText().toString();
                        tvwed.setText(strMon+"");
                        SharedPreferences pref=getContext().getSharedPreferences("Wed",Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor= pref.edit();
                        editor.putString("strMon",strMon);
                        editor.commit();
                    }
                });

                AlertDialog dialog=builder.create();
                dialog.setCancelable(true);
                dialog.show();
            }
        });
        thu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
                builder.setTitle("일정 변경");

                LayoutInflater inflater1=getActivity().getLayoutInflater();
                View vv=inflater1.inflate(R.layout.sch_dialog,null);
                schTv=vv.findViewById(R.id.sch_tv);
                schEt=vv.findViewById(R.id.sch_et);
                builder.setView(vv);


                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String strMon = schEt.getText().toString();

                        SharedPreferences pref=getContext().getSharedPreferences("Thu",Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor= pref.edit();
                        editor.putString("strMon",strMon);
                        editor.commit();

                        SharedPreferences pref1=getContext().getSharedPreferences("Thu",Context.MODE_PRIVATE);
                        String thuP=pref1.getString("strMon","");
                        tvthu.setText(thuP+"");
                    }
                });

                AlertDialog dialog=builder.create();
                dialog.setCancelable(true);
                dialog.show();
            }
        });
        fri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
                builder.setTitle("일정 변경");

                LayoutInflater inflater1=getActivity().getLayoutInflater();
                View vv=inflater1.inflate(R.layout.sch_dialog,null);
                schTv=vv.findViewById(R.id.sch_tv);
                schEt=vv.findViewById(R.id.sch_et);
                builder.setView(vv);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String strMon = schEt.getText().toString();
                        tvfri.setText(strMon+"");
                        SharedPreferences pref=getContext().getSharedPreferences("Fri",Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor= pref.edit();
                        editor.putString("strMon",strMon);
                        editor.commit();
                    }
                });

                AlertDialog dialog=builder.create();
                dialog.setCancelable(true);
                dialog.show();
            }
        });
        sat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
                builder.setTitle("일정 변경");

                LayoutInflater inflater1=getActivity().getLayoutInflater();
                View vv=inflater1.inflate(R.layout.sch_dialog,null);
                schTv=vv.findViewById(R.id.sch_tv);
                schEt=vv.findViewById(R.id.sch_et);
                builder.setView(vv);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String strMon = schEt.getText().toString();
                        tvsat.setText(strMon+"");
                        SharedPreferences pref=getContext().getSharedPreferences("Sat",Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor= pref.edit();
                        editor.putString("strMon",strMon);
                        editor.commit();
                    }
                });

                AlertDialog dialog=builder.create();
                dialog.setCancelable(true);
                dialog.show();
            }
        });
        sun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
                builder.setTitle("일정 변경");

                LayoutInflater inflater1=getActivity().getLayoutInflater();
                View vv=inflater1.inflate(R.layout.sch_dialog,null);
                schTv=vv.findViewById(R.id.sch_tv);
                schEt=vv.findViewById(R.id.sch_et);
                builder.setView(vv);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String strMon = schEt.getText().toString();
                        tvsun.setText(strMon+"");
                        SharedPreferences pref=getContext().getSharedPreferences("Sun",Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor= pref.edit();
                        editor.putString("strMon",strMon);
                        editor.commit();
                    }
                });

                AlertDialog dialog=builder.create();
                dialog.setCancelable(true);
                dialog.show();
            }
        });
        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 50:
                String str=data.getStringExtra("weigh");
                weather.setText(str);
                break;
        }
    }
}

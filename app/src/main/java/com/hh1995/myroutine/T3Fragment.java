package com.hh1995.myroutine;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class T3Fragment extends Fragment {

    Button btn;
    Button btn2;

    ArrayList<GalItem> items=new ArrayList<>();
    GalAdapter adapter;
    RecyclerView recyclerView;

    RecyclerView recyclerView2;


    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_3,container,false);
        recyclerView=v.findViewById(R.id.recycler);
        adapter=new GalAdapter(getContext(),items);
        recyclerView.setAdapter(adapter);


        btn=v.findViewById(R.id.imgBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,200);

            }
        });


        btn2=v.findViewById(R.id.imgBtn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,201);
            }
        });



        return v;
    }


}

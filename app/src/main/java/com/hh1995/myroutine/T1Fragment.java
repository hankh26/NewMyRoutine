package com.hh1995.myroutine;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static android.app.Activity.RESULT_OK;

public class T1Fragment extends Fragment {

    ArrayList<Item> items=new ArrayList<>();
    ItemAdater adater;
    RecyclerView recyclerView;
    FloatingActionButton myBtn;

    FloatingActionButton goalBtn;

    TextView tvWei;
    TextView tvFat;
    TextView tvMus;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_1,container,false);

//        items.add(new Item(R.drawable.bazzi,"20200701","75kg","11%","38kg"));
//        items.add(new Item(R.drawable.dao,"20200701","74kg","10%","38kg"));
//        items.add(new Item(R.drawable.dizni,"20200701","73kg","9%","38kg"));

        tvFat=v.findViewById(R.id.tv_fat);
        tvWei=v.findViewById(R.id.tv_weigh);
        tvMus=v.findViewById(R.id.tv_muscle);

        myBtn=v.findViewById(R.id.float_mybtn);
        myBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getContext(),MyOptionActivity.class);
                //startActivityForResult(intent,101);
                startActivity(intent);

            }
        });
        goalBtn=v.findViewById(R.id.float_goalbtn);
        goalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),GoalActivity.class);
                //startActivityForResult(intent,100);
                startActivity(intent);
            }
        });
        recyclerView=v.findViewById(R.id.recycler);
        adater=new ItemAdater(items,getContext());
        recyclerView.setAdapter(adater);


        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        loadData();
    }

    void loadData(){
        Retrofit retrofit=RetrofitHelper.getInstance();
        RetrofitService retrofitService=retrofit.create(RetrofitService.class);
        Call<ArrayList<Item>> call=retrofitService.loadDataFromRoutine();
        call.enqueue(new Callback<ArrayList<Item>>() {
            @Override
            public void onResponse(Call<ArrayList<Item>> call, Response<ArrayList<Item>> response) {
                if (response.isSuccessful()) {
                    ArrayList<Item> item1=response.body();

                    items.clear();
                    adater.notifyDataSetChanged();

                    for(Item item: item1){
                        items.add(0,item);
                        adater.notifyItemInserted(0);
                    }

                }
            }

            @Override
            public void onFailure(Call<ArrayList<Item>> call, Throwable t) {

            }

        });

    }
}

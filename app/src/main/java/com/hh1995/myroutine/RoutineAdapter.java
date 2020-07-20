package com.hh1995.myroutine;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RoutineAdapter extends RecyclerView.Adapter {
    Context context;
    ArrayList<RoutineItem> items=new ArrayList<>();

    public RoutineAdapter(Context context, ArrayList<RoutineItem> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View itemView=inflater.inflate(R.layout.routine_list,parent,false);
        VH holder=new VH(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh=(VH)holder;

        RoutineItem routineItem=items.get(position);
        vh.title.setText("제목");
        vh.date.setText("날짜");

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class VH extends RecyclerView.ViewHolder{

        TextView title;
        TextView date;
        ListView listView;
        Button btn;

        public VH(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.routine_title);
            date=itemView.findViewById(R.id.routine_date);
            //listView=itemView.findViewById(R.id.list);
            btn=itemView.findViewById(R.id.btnAdd);
        }
    }

}

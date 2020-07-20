package com.hh1995.myroutine;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SetAdater extends RecyclerView.Adapter {
    Context context;
    ArrayList<SetItem> items;

    public SetAdater(Context context, ArrayList<SetItem> items) {
        this.context = context;
        this.items = items;
    }

    public SetAdater() {
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.set_weigh_rap,parent,false);
        VH holder=new VH(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh=(VH)holder;
        SetItem setItem=items.get(position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class VH extends RecyclerView.ViewHolder{

        TextView setNumA;
        EditText kgNumA;
        EditText lapNumA;


        public VH(@NonNull View itemView) {
            super(itemView);
            setNumA=itemView.findViewById(R.id.numadd);
            kgNumA=itemView.findViewById(R.id.kgadd);
            lapNumA=itemView.findViewById(R.id.lapadd);

        }
    }
}

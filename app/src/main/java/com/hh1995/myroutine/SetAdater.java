package com.hh1995.myroutine;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        TextView kgNumA;
        TextView lapNumA;
        ImageButton upA;
        ImageButton up2A;
        ImageButton downA;
        ImageButton down2A;

        public VH(@NonNull View itemView) {
            super(itemView);
            setNumA=itemView.findViewById(R.id.numadd);
            kgNumA=itemView.findViewById(R.id.kgadd);
            lapNumA=itemView.findViewById(R.id.lapadd);
            upA=itemView.findViewById(R.id.num_up);
            up2A=itemView.findViewById(R.id.num_up2);
            downA=itemView.findViewById(R.id.num_down);
            down2A=itemView.findViewById(R.id.num_down2);
        }
    }
}

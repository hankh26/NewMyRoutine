package com.hh1995.myroutine;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class GalAdapter extends RecyclerView.Adapter {
    Context context;
    ArrayList<GalItem> items;

    public GalAdapter(Context context, ArrayList<GalItem> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View itemView=inflater.inflate(R.layout.list_myimg,parent,false);
        VH holder=new VH(itemView);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh=(VH)holder;

        GalItem galItem=items.get(position);

        vh.tv.setText("날짜");
        Glide.with(context).load(galItem.img).into(vh.iv);

    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    class VH extends  RecyclerView.ViewHolder{

        ImageView iv;
        TextView tv;

        public VH(@NonNull View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.myimg);
            tv=itemView.findViewById(R.id.mytv);
        }
    }
}

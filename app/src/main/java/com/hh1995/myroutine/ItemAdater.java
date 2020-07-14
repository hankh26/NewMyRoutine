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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ItemAdater extends RecyclerView.Adapter {
    ArrayList<Item> items;
    Context context;

    //String Bweigh="null";


    public ItemAdater(ArrayList<Item> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View itemView=inflater.inflate(R.layout.list_mine,parent,false);
        VH holder=new VH(itemView);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh=(VH)holder;
        Item item=items.get(position);
        long now=System.currentTimeMillis();
        Date date=new Date(now);

        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd");
        String time= simpleDateFormat.format(date);

        vh.date.setText(time);
//        vh.weight.setText(item.weigh);
//        vh.fat.setText(item.fat);
//        vh.muscle.setText(item.muscle);
        vh.tvweight.setText(item.tvWeigh+"kg");
        vh.tvfat.setText(item.tvFat+"%");
        vh.tvmuscle.setText(item.tvMuscle+"kg");
        Glide.with(context).load(item.img).into(vh.iv);


    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    class VH extends RecyclerView.ViewHolder{

        ImageView iv;
        TextView date;
        TextView weight;
        TextView fat;
        TextView muscle;
        TextView tvweight;
        TextView tvfat;
        TextView tvmuscle;

        public VH(@NonNull View itemView) {
            super(itemView);

            iv=itemView.findViewById(R.id.iv);
            date=itemView.findViewById(R.id.date);
            weight=itemView.findViewById(R.id.weigh);
            fat=itemView.findViewById(R.id.fat);
            muscle=itemView.findViewById(R.id.muscle);
            tvweight=itemView.findViewById(R.id.tv_weigh);
            tvfat=itemView.findViewById(R.id.tv_fat);
            tvmuscle=itemView.findViewById(R.id.tv_muscle);
        }
    }
}

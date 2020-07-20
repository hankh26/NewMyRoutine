package com.hh1995.myroutine;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
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
        vh.tvweight.setText(item.weigh+"kg");
        vh.tvfat.setText(item.fatRate+"%");
        vh.tvmuscle.setText(item.muscle+"kg");

        String imgUri="http://hkh26.dothome.co.kr/MyRoutine/"+ item.file;
        Glide.with(context).load(imgUri).into(vh.iv);


    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    class VH extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener{

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

            itemView.setOnCreateContextMenuListener(this);
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            MenuItem delete=menu.add(Menu.NONE,2,2,"삭제");
            delete.setOnMenuItemClickListener(onMenuItemClickListener);
        }
        MenuItem.OnMenuItemClickListener onMenuItemClickListener=new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case 2:
                        items.remove(getAdapterPosition());
                        notifyItemRemoved(getAdapterPosition());
                        notifyItemChanged(getAdapterPosition(),items.size());
                        break;
                }
                return true;
            }
        };
    }
}

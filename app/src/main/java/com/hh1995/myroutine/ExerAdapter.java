package com.hh1995.myroutine;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ExerAdapter extends RecyclerView.Adapter {
    Context context;
    ArrayList<ExerItem> items;

    ArrayList<SetItem> setItems=new ArrayList<>();
    SetAdater setAdater;


    int num=0;

    public ExerAdapter() {
    }

    int posi;
    public ExerAdapter(Context context, ArrayList<ExerItem> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.addroutine_list,parent,false);
        VH holder=new VH(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh=(VH)holder;
        ExerItem exerItem=items.get(position);
        vh.exName.setText(exerItem.exName);
}

    @Override
    public int getItemCount() {
        return items.size();
    }



    class VH extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {

        EditText exName;
        TextView exSet;
        TextView exKg;
        TextView exLap;
        Button btnRecyler;
        Button getBtnRecyler;

        TextView setNum;
        TextView kgNum;
        TextView lapNum;
        ImageButton up;
        ImageButton up2;
        ImageButton down;
        ImageButton down2;

        RecyclerView recyclerView;

        public VH(@NonNull View itemView) {
            super(itemView);
            exName=itemView.findViewById(R.id.exer_name);
            exSet=itemView.findViewById(R.id.setset);
            exKg=itemView.findViewById(R.id.kgkg);
            exLap=itemView.findViewById(R.id.raprap);
            btnRecyler=itemView.findViewById(R.id.btnRecycler);
            getBtnRecyler=itemView.findViewById(R.id.btnRecycler_add);
            setNum=itemView.findViewById(R.id.numnum);
            kgNum=itemView.findViewById(R.id.kg);
            lapNum=itemView.findViewById(R.id.lap);
            up=itemView.findViewById(R.id.numup);
            up2=itemView.findViewById(R.id.numup2);
            down=itemView.findViewById(R.id.numdown);
            down2=itemView.findViewById(R.id.numdown2);
            recyclerView=itemView.findViewById(R.id.AddRR);

            itemView.setOnCreateContextMenuListener(this);

            setAdater=new SetAdater(context,setItems);
            recyclerView.setAdapter(setAdater);

            getBtnRecyler.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                        setItems.add(new SetItem());
//                        notifyDataSetChanged();
                    }

            });
            btnRecyler.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                        setItems.remove(0);
//                        notifyItemRemoved(0);
//                        notifyItemRangeChanged(0,setItems.size());
                }
            });
        }


        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            MenuItem delete=menu.add(Menu.NONE,1,1,"삭제");
            delete.setOnMenuItemClickListener(onMenuItemClickListener);
        }

        MenuItem.OnMenuItemClickListener onMenuItemClickListener=new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case 1:
                        items.remove(getAdapterPosition());

                        notifyItemRemoved(getAdapterPosition());
                        notifyItemRangeChanged(getAdapterPosition(),items.size());
                        break;
                }
                return true;
            }
        };

    }
}

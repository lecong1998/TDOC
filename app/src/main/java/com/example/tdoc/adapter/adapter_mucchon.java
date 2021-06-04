package com.example.tdoc.adapter;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tdoc.R;
import com.example.tdoc.thongtin.mucchon;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class adapter_mucchon extends RecyclerView.Adapter<adapter_mucchon.viewholder> {

    private Context context;
    private ArrayList<mucchon> mucchonArrayList;
    private OnItemClickListener listener;

    public adapter_mucchon(Context context, ArrayList<mucchon> mucchonArrayList, OnItemClickListener listener) {
        this.context = context;
        this.mucchonArrayList = mucchonArrayList;
        this.listener = listener;
    }

    @NonNull
    @NotNull
    @Override
    public viewholder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);

        View muchonview = inflater.inflate(R.layout.viewmenu,parent,false);

        viewholder viewholder = new viewholder(muchonview);

        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull viewholder holder, int position) {
        mucchon mucchon = mucchonArrayList.get(position);
        holder.img_mucchon.setImageResource(mucchon.getIcon());
        holder.title_mucchon.setText(mucchon.getTitle());
        holder.mucchon = mucchonArrayList.get(position);

    }

    @Override
    public int getItemCount() {
        return mucchonArrayList.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {

        mucchon mucchon;
        ImageView img_mucchon;
        TextView title_mucchon;



        public viewholder(@NonNull @NotNull View itemView) {
            super(itemView);

            img_mucchon = (ImageView) itemView.findViewById(R.id.icon_menu);
            title_mucchon = (TextView) itemView.findViewById(R.id.title_menu);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(mucchon);
                }
            });
        }


    }

}

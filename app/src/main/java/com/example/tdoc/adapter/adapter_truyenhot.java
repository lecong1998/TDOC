package com.example.tdoc.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.example.tdoc.R;
import com.example.tdoc.thongtin.truyen;
import com.squareup.picasso.Picasso;



import java.util.ArrayList;

public class adapter_truyenhot extends RecyclerView.Adapter<adapter_truyenhot.ViewHolder> {

    private Context context;
    private ArrayList<truyen> truyenArrayList;

    public adapter_truyenhot(Context context, ArrayList<truyen> truyenArrayList) {
        this.context = context;
        this.truyenArrayList = truyenArrayList;
    }



    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView img_truyenhot;
        private TextView txt_tentruyen_hot;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_truyenhot = itemView.findViewById(R.id.img_anhtruyenhot);
            txt_tentruyen_hot = itemView.findViewById(R.id.tentruyenhot);
        }
    }

    @NonNull
    @Override
    public adapter_truyenhot.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View truyenview = inflater.inflate(R.layout.viewtruyenhot,parent,false);

        ViewHolder viewHolder= new ViewHolder(truyenview);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull adapter_truyenhot.ViewHolder holder, int position) {

        truyen truyen = truyenArrayList.get(position);
        //Picasso.get().load(truyen.getAnhtruyen()).placeholder(R.drawable.anhtruyen).into(holder.img_truyenhot);
        holder.img_truyenhot.setImageResource(truyen.getAnhtruyen());
        holder.txt_tentruyen_hot.setText(truyen.getTentruyen());

    }

    @Override
    public int getItemCount() {
        return truyenArrayList.size();
    }
}

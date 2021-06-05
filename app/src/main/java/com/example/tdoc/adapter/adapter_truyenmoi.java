package com.example.tdoc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tdoc.R;
import com.example.tdoc.thongtin.truyen;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class adapter_truyenmoi extends RecyclerView.Adapter<adapter_truyenmoi.viewholder> {

    private Context context;
    private ArrayList<truyen> truyenArrayList;
    private OnItemClickListener listener;
    public adapter_truyenmoi(Context context, ArrayList<truyen> truyenArrayList, OnItemClickListener listener) {
        this.context = context;
        this.truyenArrayList = truyenArrayList;
        this.listener=listener;
    }

    @NonNull
    @NotNull
    @Override
    public viewholder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View truyenview = layoutInflater.inflate(R.layout.view_truyenmoi,parent,false);

        viewholder viewholder = new viewholder(truyenview);

        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull viewholder holder, int position) {

        truyen truyen = truyenArrayList.get(position);
        holder.img_anhtruyen.setImageResource(truyen.getAnhtruyen());
        holder.textView_tentruyen.setText(truyen.getTentruyen());
        holder.textView_theloai.setText(truyen.getTheloai());
        holder.truyen = truyenArrayList.get(position);

    }

    @Override
    public int getItemCount() {
        return truyenArrayList.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {

        truyen truyen;
        ImageView img_anhtruyen;
        TextView textView_tentruyen;
        TextView textView_theloai;


        public viewholder(@NonNull @NotNull View itemView) {

            super(itemView);

            img_anhtruyen = (ImageView) itemView.findViewById(R.id.imageView_truyenmoi);
            textView_tentruyen = (TextView) itemView.findViewById(R.id.tentruyenmoi);
            textView_theloai = (TextView) itemView.findViewById(R.id.theloai_truyenmoi);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(truyen);
                }
            });
        }
    }
}

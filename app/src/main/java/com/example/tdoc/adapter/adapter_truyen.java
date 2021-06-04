package com.example.tdoc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tdoc.R;
import com.example.tdoc.thongtin.truyen;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class adapter_truyen extends BaseAdapter {

    private ArrayList<truyen>  truyenArrayList;
    private Context context;


    public adapter_truyen(ArrayList<truyen> truyenArrayList, Context context) {
        this.truyenArrayList = truyenArrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return truyenArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return truyenArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }



    public class viewholder{

        ImageView imageView_anhtruyen;
        TextView txt_tentruyen;
        TextView txt_theloai;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        viewholder viewholder = null;

        viewholder = new viewholder();

        LayoutInflater intInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        convertView = intInflater.inflate(R.layout.view_truyenmoi,null);

        viewholder.imageView_anhtruyen = (ImageView) convertView.findViewById(R.id.imageView_truyenmoi);
        viewholder.txt_tentruyen = (TextView) convertView.findViewById(R.id.tentruyenmoi);
        viewholder.txt_theloai = (TextView) convertView.findViewById(R.id.theloai_truyenmoi);

        convertView.setTag(viewholder);

        truyen truyen = truyenArrayList.get(position);
        viewholder.txt_tentruyen.setText(truyen.getTentruyen());
        viewholder.txt_theloai.setText(truyen.getTheloai());
        //Picasso.get().load(truyen.getAnhtruyen()).placeholder(R.drawable.anhtruyen).into(viewholder.imageView_anhtruyen);

        viewholder.imageView_anhtruyen.setImageResource(truyen.getAnhtruyen());

        return convertView;
    }

    public void filterlist(ArrayList<truyen> truyenArrayLists)
    {
        truyenArrayList= truyenArrayLists;
        notifyDataSetChanged();
    }


}

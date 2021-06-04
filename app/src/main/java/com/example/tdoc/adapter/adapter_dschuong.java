package com.example.tdoc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tdoc.R;
import com.example.tdoc.thongtin.chuongtruyen;

import java.util.ArrayList;

public class adapter_dschuong extends BaseAdapter {

    private String tentruyen;
    private ArrayList<chuongtruyen> chuongtruyens;
    private Context context;


    public adapter_dschuong(String tentruyen, ArrayList<chuongtruyen> chuongtruyens, Context context) {
        this.tentruyen = tentruyen;
        this.chuongtruyens = chuongtruyens;
        this.context = context;
    }

    @Override
    public int getCount() {
        return chuongtruyens.size();
    }

    @Override
    public Object getItem(int position) {
        return chuongtruyens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class viewholder{
        TextView txt_chuongso;
        TextView txt_tieudechuong;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewholder viewholder = null;
        viewholder = new viewholder();

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        convertView = inflater.inflate(R.layout.llistview_dschuong,null);

        viewholder.txt_chuongso = (TextView) convertView.findViewById(R.id.listview_chuongso);
        viewholder.txt_tieudechuong =(TextView) convertView.findViewById(R.id.listview_tieudechuong);

        convertView.setTag(viewholder);

        chuongtruyen chuongtruyen = chuongtruyens.get(position);
        viewholder.txt_chuongso.setText("Chương số: "+ chuongtruyen.getChuongso());
        viewholder.txt_tieudechuong.setText(chuongtruyen.getTieude());


        return convertView;
    }
}

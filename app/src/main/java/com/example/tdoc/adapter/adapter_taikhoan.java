package com.example.tdoc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tdoc.R;
import com.example.tdoc.thongtin.taikhoan;

import java.util.ArrayList;

public class adapter_taikhoan extends BaseAdapter {

    private ArrayList<taikhoan> taikhoanArrayList;
    private Context context;

    public adapter_taikhoan(ArrayList<taikhoan> taikhoanArrayList, Context context) {
        this.taikhoanArrayList = taikhoanArrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return taikhoanArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return taikhoanArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class viewholder{
        TextView txt_tentaikhoan;
        TextView txt_email;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        viewholder viewholder = null;
        viewholder = new viewholder();

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        convertView = inflater.inflate(R.layout.nav_header,null);

        viewholder.txt_tentaikhoan = (TextView) convertView.findViewById(R.id.header_tentaikhoan);
        viewholder.txt_email = (TextView) convertView.findViewById(R.id.header_email);

        convertView.setTag(viewholder);

        taikhoan taikhoan = taikhoanArrayList.get(position);

        viewholder.txt_email.setText(taikhoan.getEmail());
        viewholder.txt_tentaikhoan.setText(taikhoan.getTentaikhoan());




        return convertView;
    }
}

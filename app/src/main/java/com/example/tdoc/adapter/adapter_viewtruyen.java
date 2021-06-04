package com.example.tdoc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tdoc.R;

import com.example.tdoc.thongtin.truyen;

import java.util.ArrayList;

public class adapter_viewtruyen extends BaseAdapter {

    private ArrayList<truyen> chitiettruyens;
    private Context context;

    public adapter_viewtruyen(ArrayList<truyen> dulieuchitiettruyens, Context context) {
        this.chitiettruyens = dulieuchitiettruyens;
        this.context = context;
    }

    @Override
    public int getCount() {
        return chitiettruyens.size();
    }

    @Override
    public Object getItem(int position) {
        return chitiettruyens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class viewholder{

        ImageView img_anhtruyen;
        TextView txt_tentruyen;
        TextView txt_theloai;
        TextView txt_chuong;
        TextView txt_luotxem;
        TextView txt_mota;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewholder viewholder=null;
        viewholder = new viewholder();

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        convertView = inflater.inflate(R.layout.llistview_viewtruyen,null);

        viewholder.img_anhtruyen = (ImageView) convertView.findViewById(R.id.img_anhviewtruyen);
        viewholder.txt_tentruyen = (TextView) convertView.findViewById(R.id.tentruyen_viewtruyen);
        viewholder.txt_theloai = (TextView) convertView.findViewById(R.id.theloai_viewtruyen);
        viewholder.txt_chuong = (TextView) convertView.findViewById(R.id.sochuong_viewtruyen);
        viewholder.txt_luotxem = (TextView) convertView.findViewById(R.id.luotxem_viewtruyen);
        viewholder.txt_mota = (TextView) convertView.findViewById(R.id.motatruyen_viewtruyen);

        convertView.setTag(viewholder);

        truyen chitiettruyen = chitiettruyens.get(position);

        viewholder.img_anhtruyen.setImageResource(chitiettruyen.getAnhtruyen());
        viewholder.txt_tentruyen.setText(chitiettruyen.getTentruyen());
        viewholder.txt_theloai.setText(chitiettruyen.getTheloai());
        viewholder.txt_chuong.setText("Số chương: "+chitiettruyen.getSochuong());
        viewholder.txt_luotxem.setText("Lượt xem: "+chitiettruyen.getLuotxem());
        viewholder.txt_mota.setText(chitiettruyen.getMotatruyen());



        return convertView;
    }
}

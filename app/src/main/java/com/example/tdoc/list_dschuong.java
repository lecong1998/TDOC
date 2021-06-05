package com.example.tdoc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tdoc.adapter.adapter_dschuong;
import com.example.tdoc.database.dulieutruyen;
import com.example.tdoc.thongtin.truyen;

import java.util.ArrayList;

public class list_dschuong extends AppCompatActivity {


    ListView listdschuong;
    com.example.tdoc.adapter.adapter_dschuong adapter_dschuong;

    TextView txttentruyen;

    ImageButton back_dschuong;
    String tentruyen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_dschuong);

        Intent intent_truyenthongtin = getIntent();

        tentruyen = intent_truyenthongtin.getStringExtra("tentruyen");

        listdschuong = findViewById(R.id.list_dschuong);


        truyen truyen = thongtintruyen(tentruyen);

        adapter_dschuong = new adapter_dschuong(truyen,this);

        listdschuong.setAdapter(adapter_dschuong);

        listdschuong.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long d) {
                Intent intent_chuong = new Intent(list_dschuong.this,hienthinoidungtruyen.class);

                intent_chuong.putExtra("tentruyen",truyen.getTentruyen());
                intent_chuong.putExtra("theloai",truyen.getTheloai());
                intent_chuong.putExtra("chuongso",truyen.getChuongtruyenArrayList().get(position).getChuongso());
                intent_chuong.putExtra("tieude",truyen.getChuongtruyenArrayList().get(position).getTieude());
                intent_chuong.putExtra("noidungtruyen",truyen.getChuongtruyenArrayList().get(position).getNoidung());
                startActivity(intent_chuong);

            }
        });

        /*------------------------------------------------------*/

        back_dschuong = findViewById(R.id._back_listchuong);
        back_dschuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        txttentruyen = findViewById(R.id.tentruyen_listchuong);

        txttentruyen.setText(tentruyen);

    }

    public truyen thongtintruyen(String tentruyen2)
    {

        dulieutruyen dulieutruyen = new dulieutruyen();
        dulieutruyen.setTruyenArrayList();
        for(truyen truyen1 : dulieutruyen.getTruyenArrayList())
        {
            if(truyen1.getTentruyen().equals(tentruyen2))
            {

                return truyen1;
            }
        }
        return null;
    }


}
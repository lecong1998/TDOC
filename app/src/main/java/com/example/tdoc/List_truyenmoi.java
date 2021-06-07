package com.example.tdoc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.tdoc.adapter.OnItemClickListener;
import com.example.tdoc.adapter.adapter_truyenmoi;
import com.example.tdoc.database.dulieutruyen;
import com.example.tdoc.thongtin.truyen;

import java.util.ArrayList;
import java.util.Collections;

public class List_truyenmoi extends AppCompatActivity implements OnItemClickListener {

    ImageButton back_listtruyenmoicapnhat;

    RecyclerView recyclerView_listtruyen;

    com.example.tdoc.adapter.adapter_truyenmoi adapter_truyenmoi;
    com.example.tdoc.database.dulieutruyen dulieutruyen;




    String tentaikhoan;
    String email;
    int phanquyen;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_truyenmoi);


        Intent intent_truyenthongtin = getIntent();

        tentaikhoan = intent_truyenthongtin.getStringExtra("tentaikhoan");
        email = intent_truyenthongtin.getStringExtra("email");
        phanquyen = intent_truyenthongtin.getIntExtra("phanquyen",0);
        id = intent_truyenthongtin.getIntExtra("id",0);



        back_listtruyenmoicapnhat = findViewById(R.id.back_listtruyenmoi);

        back_listtruyenmoicapnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        recyclerView_listtruyen = findViewById(R.id.home_truyenmoicapnhat);

        dulieutruyen = new dulieutruyen();
        dulieutruyen.setTruyenArrayList();
        ArrayList<truyen> truyens = new ArrayList<>();
        for (int i = dulieutruyen.getTruyenArrayList().size()-1;i>=0;i--)
        {
            truyens.add(dulieutruyen.getTruyenArrayList().get(i));
        }
        adapter_truyenmoi = new adapter_truyenmoi(this,truyens,this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView_listtruyen.setAdapter(adapter_truyenmoi);
        recyclerView_listtruyen.setLayoutManager(layoutManager);

    }

    @Override
    public void onClick(truyen truyen) {
        Intent intent_item = new Intent(List_truyenmoi.this,view_thongtintruyen.class);
        String tent =   truyen.getTentruyen();
        intent_item.putExtra("tentruyen",tent);
        intent_item.putExtra("tentaikhoan",tentaikhoan);
        intent_item.putExtra("email",email);
        intent_item.putExtra("phanquyen",phanquyen);
        intent_item.putExtra("id",id);
        startActivity(intent_item);
    }
}
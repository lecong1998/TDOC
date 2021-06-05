package com.example.tdoc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class hienthinoidungtruyen extends AppCompatActivity {

    ImageButton back_noidungtruyen;

    TextView txttheloai,txttentruyen,txtchuongso,txttieude,txtnoidung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hienthinoidungtruyen);

        back_noidungtruyen = findViewById(R.id.back_noidungtruyen);

        txttheloai = findViewById(R.id.noidungtruyentheloai);
        txttentruyen = findViewById(R.id.tentruyen_noidungtruyen);
        txtchuongso = findViewById(R.id.chuongso_noidungtruyen);
        txttieude = findViewById(R.id.tieude_noidtruyen);
        txtnoidung = findViewById(R.id.noidungtruyen_ndtruyen);


        Intent intent_truyenthongtin = getIntent();

        String tentruyen = intent_truyenthongtin.getStringExtra("tentruyen");
        String theloai = intent_truyenthongtin.getStringExtra("theloai");
        int chuongso = intent_truyenthongtin.getIntExtra("chuongso",0);
        String tieude = intent_truyenthongtin.getStringExtra("tieude");
        String noidungtruyen = intent_truyenthongtin.getStringExtra("noidungtruyen");

        back_noidungtruyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        txttheloai.setText(theloai);
        txttentruyen.setText(tentruyen);
        txtchuongso.setText("Ch.số: "+ chuongso);
        txttieude.setText(tieude);
        txtnoidung.setText(noidungtruyen);

    }
}
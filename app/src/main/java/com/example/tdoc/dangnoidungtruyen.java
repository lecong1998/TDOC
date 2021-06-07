package com.example.tdoc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.tdoc.database.dulieutruyen;
import com.example.tdoc.thongtin.chuongtruyen;
import com.example.tdoc.thongtin.truyen;

public class dangnoidungtruyen extends AppCompatActivity {

    ImageButton back_dangndtruyen;
    TextView tieudetentruyen;

    EditText chuongso,tieudechuong,noidung;

    Button btndangtruyen;

    dulieutruyen dulieutruyen = new dulieutruyen();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnoidungtruyen);

        Intent intent_truyenthongtin = getIntent();

        String tentruyen = intent_truyenthongtin.getStringExtra("tentruyen");

        back_dangndtruyen = findViewById(R.id.back_dangnoidungtruyen);
        back_dangndtruyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        tieudetentruyen = findViewById(R.id.tentruyencandang);
        tieudetentruyen.setText(tentruyen);

        chuongso = findViewById(R.id.edt_chuongso);
        tieudechuong = findViewById(R.id.edt_tieude);
        noidung = findViewById(R.id.edt_noidungtruyen);

        btndangtruyen = findViewById(R.id.dangnoidungtruyen);

        String chuong = chuongso.getText().toString();
        String tieude = tieudechuong.getText().toString();
        String noidungtruyen = noidung.getText().toString();

        truyen truyen = truyentrongdulieu(tentruyen);

        btndangtruyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                truyen.getChuongtruyenArrayList().add(new chuongtruyen(Integer.parseInt(chuong),tieude,noidungtruyen));

                dulieutruyen.getTruyenArrayList().set(truyen.getId()-1,truyen);
                onBackPressed();
            }
        });



    }

    public truyen truyentrongdulieu(String tentr)
    {

        dulieutruyen.setTruyenArrayList();

        for (truyen truyen : dulieutruyen.getTruyenArrayList())
        {
            if(truyen.getTentruyen()==tentr)
            {
                return truyen;
            }
        }
        return null;
    }
}
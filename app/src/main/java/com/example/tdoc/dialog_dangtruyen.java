package com.example.tdoc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.tdoc.database.dulieutruyen;
import com.example.tdoc.thongtin.truyen;


public class dialog_dangtruyen extends AppCompatActivity {

    ImageButton back_dialogdangtruyen,btnthemanh;
    Button dangtruyen;
    EditText edt_tentruyen,edt_theloai,edt_diachianh;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_dangtruyen);

        back_dialogdangtruyen = findViewById(R.id.back_dialog_dangtruyen);
        back_dialogdangtruyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        edt_tentruyen = findViewById(R.id.edt_tentruyencandang);
        edt_theloai = findViewById(R.id.edt_theloai);
        edt_diachianh = findViewById(R.id.diachianh);
        btnthemanh = findViewById(R.id.themanhtruyen);
        dangtruyen = findViewById(R.id.dangtruyen);


        String tentruyen = edt_tentruyen.getText().toString();
        String theloai = edt_theloai.getText().toString();
        String diachianh = edt_diachianh.getText().toString();

        Intent intent_truyenthongtin = getIntent();
        int sotruyendaco = intent_truyenthongtin.getIntExtra("sotruyendaco",0);
        int id = intent_truyenthongtin.getIntExtra("id",0);
        dangtruyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                truyen truyen = new truyen(sotruyendaco+1,tentruyen,Integer.parseInt(diachianh),theloai,id);

                dulieutruyen dulieutruyen = new dulieutruyen();
                dulieutruyen.themtruyen(truyen);
            }
        });

    }
}
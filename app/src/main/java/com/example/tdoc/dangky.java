package com.example.tdoc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.tdoc.database.database;

import com.example.tdoc.database.database;
import com.example.tdoc.thongtin.taikhoan;

public class dangky extends AppCompatActivity {

    private EditText edt_tentk,edt_matkhau,edt_rematkhau,edt_email;
    private Button dangky,dangnhap;
    private ImageButton back;

    database database ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangky);
        database = new database(this);

        anhxa();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_dangnhap = new Intent(dangky.this, dangnhap.class);
                startActivity(int_dangnhap);
            }
        });
        dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tentk = edt_tentk.getText().toString();
                String matkhau = edt_matkhau.getText().toString();
                String rematkhau = edt_rematkhau.getText().toString();
                String email = edt_email.getText().toString();

                if(tentk.equals("")||matkhau.equals("")||rematkhau.equals("")||email.equals("")) {
                    Toast.makeText(dangky.this, "Thông tin đăng ký chưa đầy đủ!", Toast.LENGTH_SHORT).show();
                }else {
                   Cursor cursor = database.getData();

                    while (cursor.moveToNext())
                    {
                        String tentaikhoan = cursor.getString(1);
                        if(tentaikhoan.equals(tentk))
                        {
                            Toast.makeText(dangky.this,"Tài khoản đã tồn tại!",Toast.LENGTH_LONG).show();
                            return;
                        }
                    }
                    cursor.moveToFirst();
                    cursor.close();

                    if(matkhau.equals(rematkhau))
                    {
                        database.AddTaiKhoan(new taikhoan(tentk,matkhau,email,0));
                        Toast.makeText(dangky.this,"Đăng ký thành công!",Toast.LENGTH_LONG).show();
                        Intent intent_dangky = new Intent(dangky.this,dangnhap.class);
                        startActivity(intent_dangky);
                        finish();
                    }
                    else {
                        Toast.makeText(dangky.this,"Mật khẩu không khớp!",Toast.LENGTH_LONG).show();
                    }

                }


            }
        });

    }


    public void anhxa()
    {
        edt_tentk = findViewById(R.id.dangky_tentk);
        edt_matkhau = findViewById(R.id.dangky_matkhau);
        edt_rematkhau = findViewById(R.id.dangky_rematkhau);
        edt_email = findViewById(R.id.dangky_email);
        dangky = findViewById(R.id.dangky_dangky);
        dangnhap = findViewById(R.id.dangky_dangnhap);
        back = findViewById(R.id.back_dangky);
    }

}
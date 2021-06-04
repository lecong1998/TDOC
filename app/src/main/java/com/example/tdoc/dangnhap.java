package com.example.tdoc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tdoc.database.database;


public class dangnhap extends AppCompatActivity {

    EditText editText_tentk;
    EditText editText_matkhau;
    Button dangnhap;
    Button dangky;

    database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);

        database = new database(this);
        anhxa();

        dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_dangky = new Intent(dangnhap.this, dangky.class);
                startActivity(intent_dangky);
            }
        });

        dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tentk = editText_tentk.getText().toString();
                String matkhau = editText_matkhau.getText().toString();

                if(tentk.equals("")||matkhau.equals(""))
                {
                    Toast.makeText(dangnhap.this,"Thông tin đăng nhập chưa đầy đủ",Toast.LENGTH_SHORT).show();
                }
                else {

                    Cursor cursor = database.getData();

                    while (cursor.moveToNext())
                    {
                        String tentaikhoan = cursor.getString(1);
                        String matkhautk = cursor.getString(2);
                        if(tentaikhoan.equals(tentk))
                        {
                            if(matkhautk.equals(matkhau))
                            {
                                int id = cursor.getInt(0);
                                String email = cursor.getString(3);
                                int phanquyen = cursor.getInt(4);
                                Toast.makeText(dangnhap.this,"Đăng nhập thành công!",Toast.LENGTH_LONG).show();
                                 Intent intent_dangnhap = new Intent(dangnhap.this,main_home.class);
                                 intent_dangnhap.putExtra("tentaikhoan",tentaikhoan);
                                 intent_dangnhap.putExtra("email",email);
                                 intent_dangnhap.putExtra("phanquyen",phanquyen);
                                 intent_dangnhap.putExtra("id",id);
                                 startActivity(intent_dangnhap);
                                return;
                            }
                            else
                            {
                                Toast.makeText(dangnhap.this,"Mật khẩu không đúng!",Toast.LENGTH_LONG).show();
                                return;
                            }

                        }
                    }
                    cursor.moveToFirst();
                    cursor.close();
                    Toast.makeText(dangnhap.this,"tài khoản không tồn tại !",Toast.LENGTH_LONG).show();

                }
            }
        });
    }

    public void anhxa()
    {
        editText_tentk = findViewById(R.id.dangnhap_tentk);
        editText_matkhau = findViewById(R.id.dangnhap_matkhau);
        dangnhap = findViewById(R.id.dangnhap_dangnhap);
        dangky = findViewById(R.id.dangnhap_dangky);

    }
}
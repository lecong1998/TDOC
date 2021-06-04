package com.example.tdoc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tdoc.adapter.adapter_dschuong;
import com.example.tdoc.adapter.adapter_taikhoan;
import com.example.tdoc.adapter.adapter_viewtruyen;
import com.example.tdoc.thongtin.chuongtruyen;
import com.example.tdoc.thongtin.taikhoan;
import com.example.tdoc.thongtin.truyen;
import com.google.android.material.navigation.NavigationView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class view_thongtintruyen extends AppCompatActivity {

    DrawerLayout drawerLayout_viewtruyen;
    Toolbar toolbar_viewtruyen;
    NavigationView navigationView_viewtruyen;

    ListView listView_header,listView_viewtruyen,listView_dschuong;

    ArrayList<taikhoan> taikhoans;
    com.example.tdoc.adapter.adapter_taikhoan adapter_taikhoan;


    com.example.tdoc.adapter.adapter_viewtruyen adapter_viewtruyen;
    com.example.tdoc.adapter.adapter_dschuong adapter_dschuong;
    ArrayList<chuongtruyen> chuongtruyenArrayList;
    ArrayList<truyen> truyenArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_thongtintruyen);



        Intent intent_truyenthongtin = this.getIntent();

        String tentaikhoan = intent_truyenthongtin.getStringExtra("tentaikhoan");
        String email = intent_truyenthongtin.getStringExtra("email");
        int phanquyen = intent_truyenthongtin.getIntExtra("phanquyen",0);
        int id = intent_truyenthongtin.getIntExtra("id",0);
        taikhoans = new ArrayList<>();
        taikhoans.add(new taikhoan(tentaikhoan,email,phanquyen));

        listView_header = findViewById(R.id.theloai_header);
        adapter_taikhoan = new adapter_taikhoan(taikhoans,this);
        listView_header.setAdapter(adapter_taikhoan);

        /*------------------------------------------------------------*/

        drawerLayout_viewtruyen = findViewById(R.id.drawer_layout_viewtruyen);
        toolbar_viewtruyen = findViewById(R.id.tool_bar_viewtruyen);
        navigationView_viewtruyen = findViewById(R.id.nav_view_viewtruyen);

        setSupportActionBar(toolbar_viewtruyen);

        toolbar_viewtruyen.setNavigationIcon(R.drawable.ic_baseline_menu_24);

        //toolbar_viewtruyen.setTitle();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        navigationView_viewtruyen.bringToFront();

        ActionBarDrawerToggle toggle_viewtruyen = new ActionBarDrawerToggle(this,drawerLayout_viewtruyen,toolbar_viewtruyen,R.string.navigation_drawer_open,R.string.navigation_drawer_close);

        toggle_viewtruyen.syncState();


        navigationView_viewtruyen.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {


                switch (item.getItemId())
                {
                    case R.id.nav_home:
                        Intent intent_home = new Intent(view_thongtintruyen.this,main_home.class);
                        intent_home.putExtra("tentaikhoan",tentaikhoan);
                        intent_home.putExtra("email",email);
                        intent_home.putExtra("phanquyen",phanquyen);
                        intent_home.putExtra("id",id);
                        startActivity(intent_home);
                        break;
                    case R.id.nav_search:
                        Intent intent_search = new Intent(view_thongtintruyen.this,search.class);
                        intent_search.putExtra("tentaikhoan",tentaikhoan);
                        intent_search.putExtra("email",email);
                        intent_search.putExtra("phanquyen",phanquyen);
                        intent_search.putExtra("id",id);
                        startActivity(intent_search);
                        break;
                    case R.id.nav_dangxuat:
                        Intent intent_dangxuat = new Intent(view_thongtintruyen.this,dangnhap.class);
                        startActivity(intent_dangxuat);
                        break;
                    case R.id.nav_dangtruyen:
                        if(phanquyen==2)
                        {
                            Intent intent_dangtruyen = new Intent(view_thongtintruyen.this,dangtruyen.class);
                            intent_dangtruyen.putExtra("id",id);
                            intent_dangtruyen.putExtra("tentaikhoan",tentaikhoan);
                            intent_dangtruyen.putExtra("email",email);
                            intent_dangtruyen.putExtra("phanquyen",phanquyen);
                            startActivity(intent_dangtruyen);
                        }
                        else {
                            Toast.makeText(view_thongtintruyen.this,"Bạn không có quyền đăng truyện!",Toast.LENGTH_SHORT).show();
                        }

                        break;
                    case R.id.nav_theloai:
                        Intent intent_theloai = new Intent(view_thongtintruyen.this,theloai.class);
                        intent_theloai.putExtra("tentaikhoan",tentaikhoan);
                        intent_theloai.putExtra("email",email);
                        intent_theloai.putExtra("phanquyen",phanquyen);
                        intent_theloai.putExtra("id",id);
                        startActivity(intent_theloai);
                        break;

                }


                return true;
            }
        });

        /*------------------------------------------------------------------------------*/

        listView_viewtruyen = findViewById(R.id.listviewthongtin);
        listView_dschuong = findViewById(R.id.danhsachchuong);

    }






}
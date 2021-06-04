package com.example.tdoc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tdoc.adapter.adapter_taikhoan;
import com.example.tdoc.thongtin.taikhoan;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class theloai extends AppCompatActivity {

    DrawerLayout drawerLayout_theloai;
    Toolbar toolbar_theloai;
    NavigationView navigationView_theloai;

    Button btnhuyenhuyen,btnkiemhiep,btndongnhan,btndothi;
    ListView listView_header;

    ArrayList<taikhoan> taikhoans;
    com.example.tdoc.adapter.adapter_taikhoan adapter_taikhoan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theloai);

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


        /*-----------------------------------------------------------*/

        drawerLayout_theloai = findViewById(R.id.theloai_drawer_layout);
        toolbar_theloai = findViewById(R.id.theloai_toolbar);
        navigationView_theloai = findViewById(R.id.theloai_nav_view);

        setSupportActionBar(toolbar_theloai);
        toolbar_theloai.setNavigationIcon(R.drawable.ic_baseline_menu_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        navigationView_theloai.bringToFront();

        ActionBarDrawerToggle toggle_theloai = new ActionBarDrawerToggle(this,drawerLayout_theloai,toolbar_theloai,R.string.navigation_drawer_open,R.string.navigation_drawer_close);

        toggle_theloai.syncState();
        navigationView_theloai.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.nav_home:
                        Intent intent_home = new Intent(theloai.this,main_home.class);
                        intent_home.putExtra("tentaikhoan",tentaikhoan);
                        intent_home.putExtra("email",email);
                        intent_home.putExtra("phanquyen",phanquyen);
                        intent_home.putExtra("id",id);
                        startActivity(intent_home);
                        break;
                    case R.id.nav_search:
                        Intent intent_search = new Intent(theloai.this,search.class);
                        intent_search.putExtra("tentaikhoan",tentaikhoan);
                        intent_search.putExtra("email",email);
                        intent_search.putExtra("phanquyen",phanquyen);
                        intent_search.putExtra("id",id);
                        startActivity(intent_search);
                        break;
                    case R.id.nav_dangxuat:
                        Intent intent_dangxuat = new Intent(theloai.this,dangnhap.class);
                        startActivity(intent_dangxuat);
                        break;
                    case R.id.nav_dangtruyen:
                        if(phanquyen==2)
                        {
                            Intent intent_dangtruyen = new Intent(theloai.this,dangtruyen.class);
                            intent_dangtruyen.putExtra("id",id);
                            intent_dangtruyen.putExtra("tentaikhoan",tentaikhoan);
                            intent_dangtruyen.putExtra("email",email);
                            intent_dangtruyen.putExtra("phanquyen",phanquyen);
                            startActivity(intent_dangtruyen);
                        }
                        else {
                            Toast.makeText(theloai.this,"Bạn không có quyền đăng truyện!",Toast.LENGTH_SHORT).show();
                        }

                        break;
                    case R.id.nav_theloai:
                        onBackPressed();
                        break;

                }


                return true;
            }
        });






        btnhuyenhuyen = findViewById(R.id.theloai_huyenhuyen);
        btnhuyenhuyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_huyenhuyen = new Intent(theloai.this,huyenhuyen.class);
                intent_huyenhuyen.putExtra("tentaikhoan",tentaikhoan);
                intent_huyenhuyen.putExtra("email",email);
                intent_huyenhuyen.putExtra("phanquyen",phanquyen);
                intent_huyenhuyen.putExtra("id",id);
                startActivity(intent_huyenhuyen);
            }
        });


        btnkiemhiep = findViewById(R.id.theloai_kiemhiep);
        btnkiemhiep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_kiemhiep = new Intent(theloai.this,kiemhiep.class);
                intent_kiemhiep.putExtra("tentaikhoan",tentaikhoan);
                intent_kiemhiep.putExtra("email",email);
                intent_kiemhiep.putExtra("phanquyen",phanquyen);
                intent_kiemhiep.putExtra("id",id);
                startActivity(intent_kiemhiep);
            }
        });


        btndongnhan = findViewById(R.id.theloai_dongnhan);
        btndongnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_dongnhan = new Intent(theloai.this,dongnhan.class);
                intent_dongnhan.putExtra("tentaikhoan",tentaikhoan);
                intent_dongnhan.putExtra("email",email);
                intent_dongnhan.putExtra("phanquyen",phanquyen);
                intent_dongnhan.putExtra("id",id);
                startActivity(intent_dongnhan);
            }
        });

        btndothi = findViewById(R.id.theloai_dothi);
        btndothi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_dothi = new Intent(theloai.this,dothi.class);
                intent_dothi.putExtra("tentaikhoan",tentaikhoan);
                intent_dothi.putExtra("email",email);
                intent_dothi.putExtra("phanquyen",phanquyen);
                intent_dothi.putExtra("id",id);
                startActivity(intent_dothi);
            }
        });

    }

    @Override
    public void onBackPressed() {
        if(drawerLayout_theloai.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout_theloai.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }

    }
}
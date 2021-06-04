package com.example.tdoc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.tdoc.adapter.adapter_taikhoan;
import com.example.tdoc.adapter.adapter_truyen;
import com.example.tdoc.database.dulieutruyen;
import com.example.tdoc.thongtin.taikhoan;
import com.example.tdoc.thongtin.truyen;
import com.google.android.material.navigation.NavigationView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class dangtruyen extends AppCompatActivity {


    private Button btndangtruyenmoi;

    ArrayList<taikhoan> taikhoans;
    com.example.tdoc.adapter.adapter_taikhoan adapter_taikhoan;

    ListView listView_header,listView_truyendadang;

    DrawerLayout drawerLayout_dangtruyen;
    Toolbar toolbar_dangtruyen;
    NavigationView navigationView_dangtruyen;


    com.example.tdoc.database.dulieutruyen dulieutruyen;

    ArrayList<truyen> truyens;
    com.example.tdoc.adapter.adapter_truyen adapter_truyen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangtruyen);


        Intent intent_truyenthongtin = this.getIntent();

        String tentaikhoan = intent_truyenthongtin.getStringExtra("tentaikhoan");
        String email = intent_truyenthongtin.getStringExtra("email");
        int phanquyen = intent_truyenthongtin.getIntExtra("phanquyen",0);
        int id = intent_truyenthongtin.getIntExtra("id",0);
        taikhoans = new ArrayList<>();
        taikhoans.add(new taikhoan(tentaikhoan,email,phanquyen));
        listView_header = findViewById(R.id.dangtruyen_header);
        adapter_taikhoan = new adapter_taikhoan(taikhoans,this);
        listView_header.setAdapter(adapter_taikhoan);

        /*------------------------------------------------------------*/

        drawerLayout_dangtruyen = findViewById(R.id.drawer_layout_dangtruyen);
        toolbar_dangtruyen = findViewById(R.id.dangtruyen_toolbar);
        navigationView_dangtruyen = findViewById(R.id.nav_view_dangtruyen);
        setSupportActionBar(toolbar_dangtruyen);
        toolbar_dangtruyen.setNavigationIcon(R.drawable.ic_baseline_menu_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        navigationView_dangtruyen.bringToFront();

        ActionBarDrawerToggle toggle_dangtruyen = new ActionBarDrawerToggle(this, drawerLayout_dangtruyen,toolbar_dangtruyen,R.string.navigation_drawer_open,R.string.navigation_drawer_close);

        toggle_dangtruyen.syncState();

        navigationView_dangtruyen.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.nav_home:
                        Intent intent_home = new Intent(dangtruyen.this,main_home.class);
                        intent_home.putExtra("tentaikhoan",tentaikhoan);
                        intent_home.putExtra("email",email);
                        intent_home.putExtra("phanquyen",phanquyen);
                        intent_home.putExtra("id",id);
                        startActivity(intent_home);
                        break;
                    case R.id.nav_search:
                        Intent intent_search = new Intent(dangtruyen.this,search.class);
                        intent_search.putExtra("tentaikhoan",tentaikhoan);
                        intent_search.putExtra("email",email);
                        intent_search.putExtra("phanquyen",phanquyen);
                        intent_search.putExtra("id",id);
                        startActivity(intent_search);
                        break;
                    case R.id.nav_dangxuat:
                        Intent intent_dangxuat = new Intent(dangtruyen.this,dangnhap.class);
                        startActivity(intent_dangxuat);
                        break;
                    case R.id.nav_dangtruyen:
                        onBackPressed();
                        break;
                    case R.id.nav_theloai:
                        Intent intent_theloai = new Intent(dangtruyen.this,theloai.class);
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

        /*-----------------------------------------------------------*/

        btndangtruyenmoi = findViewById(R.id.btndangtruyenmoi);
        btndangtruyenmoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogdangtruyen();
            }
        });


        /*--------------------------------------------------------*/

        listView_truyendadang = findViewById(R.id.truyendadang);


        adapter_truyen = new adapter_truyen(this.truyentaikhoandadang(id),this);

        listView_truyendadang.setAdapter(adapter_truyen);


    }

    public void dialogdangtruyen()
    {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_dangtruyen);

        EditText editText_truyentruyencandang;


    }

    @Override
    public void onBackPressed() {
        if(drawerLayout_dangtruyen.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout_dangtruyen.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }

    }

    public ArrayList<truyen> truyentaikhoandadang(int i)
    {
        ArrayList<truyen> truyenArrayList = new ArrayList<>();
        dulieutruyen= new dulieutruyen();
        dulieutruyen.setTruyenArrayList();
        for(truyen truyen : dulieutruyen.getTruyenArrayList())
        {
            if(truyen.getTaikhoandang()==i)
            {
                truyenArrayList.add(truyen);
            }
        }

        return  truyenArrayList;

    }
}
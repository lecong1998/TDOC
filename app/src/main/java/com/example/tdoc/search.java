package com.example.tdoc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.tdoc.adapter.adapter_taikhoan;
import com.example.tdoc.adapter.adapter_truyen;
import com.example.tdoc.database.database;
import com.example.tdoc.database.database_truyen;
import com.example.tdoc.database.dulieutruyen;
import com.example.tdoc.thongtin.taikhoan;
import com.example.tdoc.thongtin.truyen;
import com.google.android.material.navigation.NavigationView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class search extends AppCompatActivity {

    private ListView listView_search;
    private EditText editText;


    dulieutruyen dulieutruyen;
    adapter_truyen  adaptertruyen;


    DrawerLayout drawerLayout_search;
    Toolbar toolbar_search;
    NavigationView navigationView_search;

    ArrayList<taikhoan> taikhoans;
    ListView listView_header;
    com.example.tdoc.adapter.adapter_taikhoan adapter_taikhoan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Intent intent_truyenthongtin = this.getIntent();

        String tentaikhoan = intent_truyenthongtin.getStringExtra("tentaikhoan");
        String email = intent_truyenthongtin.getStringExtra("email");
        int phanquyen = intent_truyenthongtin.getIntExtra("phanquyen",0);
        int id = intent_truyenthongtin.getIntExtra("id",0);
        taikhoans = new ArrayList<>();
        taikhoans.add(new taikhoan(tentaikhoan,email,phanquyen));
        listView_header = findViewById(R.id.search_header);
        adapter_taikhoan = new adapter_taikhoan(taikhoans,this);
        listView_header.setAdapter(adapter_taikhoan);

        /*--------------------------------------------------------*/

        drawerLayout_search = findViewById(R.id.drawer_layout_search);
        toolbar_search = findViewById(R.id.search_toolbar);
        navigationView_search = findViewById(R.id.nav_view_search);

        setSupportActionBar(toolbar_search);
        toolbar_search.setNavigationIcon(R.drawable.ic_baseline_menu_24);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView_search.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout_search,toolbar_search,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        toggle.syncState();
        navigationView_search.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                switch (item.getItemId())
                {
                case R.id.nav_home:
                    Intent intent_home = new Intent(search.this,main_home.class);
                    intent_home.putExtra("tentaikhoan",tentaikhoan);
                    intent_home.putExtra("email",email);
                    intent_home.putExtra("phanquyen",phanquyen);
                    intent_home.putExtra("id",id);
                    startActivity(intent_home);
                    break;
                case R.id.nav_search:
                    onBackPressed();
                break;
                case R.id.nav_dangxuat:
                    Intent intent_dangxuat = new Intent(search.this,dangnhap.class);
                    startActivity(intent_dangxuat);
                break;
                case R.id.nav_dangtruyen:
                    if(phanquyen==2)
                    {
                        Intent intent_dangtruyen = new Intent(search.this,dangtruyen.class);
                        intent_dangtruyen.putExtra("id",id);
                        intent_dangtruyen.putExtra("tentaikhoan",tentaikhoan);
                        intent_dangtruyen.putExtra("email",email);
                        intent_dangtruyen.putExtra("phanquyen",phanquyen);
                        startActivity(intent_dangtruyen);
                    }
                    else {
                        Toast.makeText(search.this,"Bạn không có quyền đăng truyện!",Toast.LENGTH_SHORT).show();
                    }

                    break;
                case R.id.nav_theloai:
                    Intent intent_theloai = new Intent(search.this,theloai.class);
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

       /*-------------------------------------------------------*/

        listView_search = (ListView) findViewById(R.id.listview_timkiem);
        dulieutruyen = new dulieutruyen();
        dulieutruyen.setTruyenArrayList();
        adaptertruyen = new adapter_truyen(dulieutruyen.getTruyenArrayList(),this);
        listView_search.setAdapter(adaptertruyen);

        /*-------------------------------------------------------*/

        editText = (EditText) findViewById(R.id.search_timkiem);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });


    }


    public void filter(String text)
    {
        ArrayList<truyen> list = new ArrayList<>();
        for (truyen truyen : dulieutruyen.getTruyenArrayList() )
        {
            if(truyen.getTentruyen().toLowerCase().contains(text.toLowerCase()))
            {  list.add(truyen); }
        }
        adaptertruyen.filterlist(list);
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout_search.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout_search.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }

    }

}
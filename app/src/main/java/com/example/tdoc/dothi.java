package com.example.tdoc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tdoc.adapter.adapter_taikhoan;
import com.example.tdoc.adapter.adapter_truyen;
import com.example.tdoc.database.dulieutruyen;
import com.example.tdoc.thongtin.taikhoan;
import com.example.tdoc.thongtin.truyen;
import com.google.android.material.navigation.NavigationView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class dothi extends AppCompatActivity {

    ListView listView,listView_header;
    com.example.tdoc.database.dulieutruyen dulieutruyen;
    com.example.tdoc.adapter.adapter_truyen adapter_truyen;


    DrawerLayout drawerLayout_dothi;
    Toolbar toolbar_dothi;
    NavigationView navigationView_dothi;

    ArrayList<taikhoan> taikhoans;
    com.example.tdoc.adapter.adapter_taikhoan adapter_taikhoan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dothi);

        Intent intent_truyenthongtin = this.getIntent();

        String tentaikhoan = intent_truyenthongtin.getStringExtra("tentaikhoan");
        String email = intent_truyenthongtin.getStringExtra("email");
        int phanquyen = intent_truyenthongtin.getIntExtra("phanquyen",0);
        int id = intent_truyenthongtin.getIntExtra("id",0);
        taikhoans = new ArrayList<>();
        taikhoans.add(new taikhoan(tentaikhoan,email,phanquyen));

        listView_header = findViewById(R.id.dothi_header);

        adapter_taikhoan = new adapter_taikhoan(taikhoans,this);

        listView_header.setAdapter(adapter_taikhoan);

        /*-------------------------------------------------*/

        drawerLayout_dothi = findViewById(R.id.drawer_layout_dothi);
        toolbar_dothi = findViewById(R.id.tool_bar_dothi);
        navigationView_dothi = findViewById(R.id.nav_view_dothi);

        setSupportActionBar(toolbar_dothi);

        toolbar_dothi.setNavigationIcon(R.drawable.ic_baseline_menu_24);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView_dothi.bringToFront();

        ActionBarDrawerToggle toggle_dothi = new ActionBarDrawerToggle(this,drawerLayout_dothi,toolbar_dothi,R.string.navigation_drawer_open,R.string.navigation_drawer_close);

        toggle_dothi.syncState();

        navigationView_dothi.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.nav_home:
                        Intent intent_home = new Intent(dothi.this,main_home.class);
                        intent_home.putExtra("tentaikhoan",tentaikhoan);
                        intent_home.putExtra("email",email);
                        intent_home.putExtra("phanquyen",phanquyen);
                        intent_home.putExtra("id",id);
                        startActivity(intent_home);
                        break;
                    case R.id.nav_search:
                        Intent intent_search = new Intent(dothi.this,search.class);
                        intent_search.putExtra("tentaikhoan",tentaikhoan);
                        intent_search.putExtra("email",email);
                        intent_search.putExtra("phanquyen",phanquyen);
                        intent_search.putExtra("id",id);
                        startActivity(intent_search);
                        break;
                    case R.id.nav_dangxuat:
                        Intent intent_dangxuat = new Intent(dothi.this,dangnhap.class);
                        startActivity(intent_dangxuat);
                        break;
                    case R.id.nav_dangtruyen:
                        if(phanquyen==2)
                        {
                            Intent intent_dangtruyen = new Intent(dothi.this,dangtruyen.class);
                            intent_dangtruyen.putExtra("id",id);
                            intent_dangtruyen.putExtra("tentaikhoan",tentaikhoan);
                            intent_dangtruyen.putExtra("email",email);
                            intent_dangtruyen.putExtra("phanquyen",phanquyen);
                            startActivity(intent_dangtruyen);
                        }
                        else {
                            Toast.makeText(dothi.this,"Bạn không có quyền đăng truyện!",Toast.LENGTH_SHORT).show();
                        }

                        break;
                    case R.id.nav_theloai:
                        Intent intent_theloai = new Intent(dothi.this,theloai.class);
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

        /*---------------------------------------------------------------------------*/

        dulieutruyen = new dulieutruyen();
        dulieutruyen.setTruyenArrayList();
        adapter_truyen = new adapter_truyen(truyendothi(dulieutruyen.getTruyenArrayList()),this);
        listView = (ListView) findViewById(R.id.listview_dothi);
        listView.setAdapter(adapter_truyen);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long d) {
                Intent intent_item = new Intent(dothi.this,view_thongtintruyen.class);
                String tent =   adapter_truyen.getTruyenArrayList().get(position).getTentruyen();
                intent_item.putExtra("tentruyen",tent);
                intent_item.putExtra("tentaikhoan",tentaikhoan);
                intent_item.putExtra("email",email);
                intent_item.putExtra("phanquyen",phanquyen);
                intent_item.putExtra("id",id);
                startActivity(intent_item);

            }
        });

    }

    public ArrayList<truyen> truyendothi(ArrayList<truyen> truyenArrayList)
    {
        ArrayList<truyen> truyens = new ArrayList<>();
        for (int i=0;i<truyenArrayList.size();i++)
        {
            if(truyenArrayList.get(i).getTheloai()=="Đô thị")
            {
                truyens.add(truyenArrayList.get(i));
            }

        }
        return truyens;
    }


    @Override
    public void onBackPressed() {
        if(drawerLayout_dothi.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout_dothi.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }

    }

}
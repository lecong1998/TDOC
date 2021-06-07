package com.example.tdoc;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.tdoc.adapter.OnItemClickListener;
import com.example.tdoc.adapter.adapter_taikhoan;
import com.example.tdoc.adapter.adapter_truyenhot;
import com.example.tdoc.adapter.adapter_truyenmoi;
import com.example.tdoc.database.dulieutruyen;
import com.example.tdoc.thongtin.taikhoan;
import com.example.tdoc.thongtin.truyen;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class main_home extends AppCompatActivity  implements OnItemClickListener {


    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;

    ViewFlipper viewFlipper;

    ArrayList<truyen> truyenArrayList;

    adapter_truyenmoi adapter_truyenmoi;

    ListView listView,listView_taikhoan;

    RecyclerView recyclerView,recyclerView_truyenmoi;

    adapter_truyenhot adapter_truyenhot;

    adapter_taikhoan  adapter_taikhoan;

    Button xemthem;

    ImageView img1,img2,img3,img4,img5;

    taikhoan taikhoan;
    String tentaikhoan;
    String email;
    int phanquyen;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);

        Intent intent_truyenthongtin = getIntent();

         tentaikhoan = intent_truyenthongtin.getStringExtra("tentaikhoan");
         email = intent_truyenthongtin.getStringExtra("email");
         phanquyen = intent_truyenthongtin.getIntExtra("phanquyen",0);
         id = intent_truyenthongtin.getIntExtra("id",0);




        ArrayList<taikhoan> taikhoans =  new ArrayList<>();
        taikhoan= new taikhoan(tentaikhoan,email,phanquyen);
        taikhoans.add(taikhoan );
        adapter_taikhoan = new adapter_taikhoan(taikhoans,this);

        listView_taikhoan = (ListView) findViewById(R.id.listview_header);
        listView_taikhoan.setAdapter(adapter_taikhoan);
        /*----------------------------------------------------------------------*/


        /*--------------------------------------------------------------------------*/


        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        navigationView = (NavigationView) findViewById(R.id.nav_view_home);

        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_baseline_menu_24);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);



        navigationView.bringToFront();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);

        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@androidx.annotation.NonNull  MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.nav_home:
                        onBackPressed();
                        break;
                    case R.id.nav_search:
                        Intent intent_search = new Intent(main_home.this,search.class);
                        intent_search.putExtra("tentaikhoan",tentaikhoan);
                        intent_search.putExtra("email",email);
                        intent_search.putExtra("phanquyen",phanquyen);
                        intent_search.putExtra("id",id);
                        startActivity(intent_search);
                        break;
                    case R.id.nav_dangxuat:
                        Intent intent_dangxuat = new Intent(main_home.this,dangnhap.class);
                        startActivity(intent_dangxuat);
                        break;
                    case R.id.nav_dangtruyen:
                        if(phanquyen==2)
                        {
                            Intent intent_dangtruyen = new Intent(main_home.this,dangtruyen.class);
                            intent_dangtruyen.putExtra("id",id);
                            intent_dangtruyen.putExtra("tentaikhoan",tentaikhoan);
                            intent_dangtruyen.putExtra("email",email);
                            intent_dangtruyen.putExtra("phanquyen",phanquyen);
                            startActivity(intent_dangtruyen);
                        }
                        else {
                            Toast.makeText(main_home.this,"Bạn không có quyền đăng truyện!",Toast.LENGTH_SHORT).show();
                        }

                        break;
                    case R.id.nav_theloai:
                        Intent intent_theloai = new Intent(main_home.this,theloai.class);
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

        /*------------------------------------------------------------------*/


        img1 = findViewById(R.id.mathienky);
        img2 = findViewById(R.id.thanmo);
        img3 = findViewById(R.id.vucucthienha);
        img4 = findViewById(R.id.bothienky);
        img5 = findViewById(R.id.thuvienthiendao);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_item = new Intent(main_home.this,view_thongtintruyen.class);
                String tent =   "Ma Thiên Ký";
                intent_item.putExtra("tentruyen",tent);
                intent_item.putExtra("tentaikhoan",tentaikhoan);
                intent_item.putExtra("email",email);
                intent_item.putExtra("phanquyen",phanquyen);
                intent_item.putExtra("id",id);
                startActivity(intent_item);
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_item = new Intent(main_home.this,view_thongtintruyen.class);
                String tent =   "Thần mộ";
                intent_item.putExtra("tentruyen",tent);
                intent_item.putExtra("tentaikhoan",tentaikhoan);
                intent_item.putExtra("email",email);
                intent_item.putExtra("phanquyen",phanquyen);
                intent_item.putExtra("id",id);
                startActivity(intent_item);
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_item = new Intent(main_home.this,view_thongtintruyen.class);
                String tent =   "Vũ Cực thiên hạ";
                intent_item.putExtra("tentruyen",tent);
                intent_item.putExtra("tentaikhoan",tentaikhoan);
                intent_item.putExtra("email",email);
                intent_item.putExtra("phanquyen",phanquyen);
                intent_item.putExtra("id",id);
                startActivity(intent_item);
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_item = new Intent(main_home.this,view_thongtintruyen.class);
                String tent =   "Bổ Thiên Ký";
                intent_item.putExtra("tentruyen",tent);
                intent_item.putExtra("tentaikhoan",tentaikhoan);
                intent_item.putExtra("email",email);
                intent_item.putExtra("phanquyen",phanquyen);
                intent_item.putExtra("id",id);
                startActivity(intent_item);
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_item = new Intent(main_home.this,view_thongtintruyen.class);
                String tent =   "Thiên đạo thư viện";
                intent_item.putExtra("tentruyen",tent);
                intent_item.putExtra("tentaikhoan",tentaikhoan);
                intent_item.putExtra("email",email);
                intent_item.putExtra("phanquyen",phanquyen);
                intent_item.putExtra("id",id);
                startActivity(intent_item);
            }
        });
        /*------------------------------------------------------------------*/

        /*---------------------------------------------------------------------*/



        xemthem = findViewById(R.id.xemthem);
        xemthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_item = new Intent(main_home.this,List_truyenmoi.class);
                intent_item.putExtra("tentaikhoan",tentaikhoan);
                intent_item.putExtra("email",email);
                intent_item.putExtra("phanquyen",phanquyen);
                intent_item.putExtra("id",id);
                startActivity(intent_item);
            }
        });








        /*----------------------------------------------------------------------*/

        viewFlipper = (ViewFlipper) findViewById(R.id.view_flipper);

        viewFlipper.setFlipInterval(5000);
        //viewFlipper run
        viewFlipper.setAutoStart(true);
        //Gọi animation cho in và out . Animation giúp cho nó biến dổi giữa các giao diện hình ảnh
        Animation animation_slide_in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_right);
        Animation animation_slide_out = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_out_right);
        //Gọi animation vào ViewFlippẻ
        viewFlipper.setInAnimation(animation_slide_in);
        viewFlipper.setOutAnimation(animation_slide_out);
        /*-------------------------------------------------------*/




        dulieutruyen  dulieutruyen = new dulieutruyen();
        dulieutruyen.setTruyenArrayList();
        ArrayList<truyen> truyens = new ArrayList<>();
        int a = dulieutruyen.getTruyenArrayList().size();
        for (int i = a-1;i>=a-5;i--)
        {
            truyens.add(dulieutruyen.getTruyenArrayList().get(i));
        }
        adapter_truyenmoi = new adapter_truyenmoi(this,truyens,this);
     

        LinearLayoutManager layoutManager_truyen = new LinearLayoutManager(this);

        recyclerView_truyenmoi = (RecyclerView) findViewById(R.id.recycler_truyenmoi);

        recyclerView_truyenmoi.setAdapter(adapter_truyenmoi);

        recyclerView_truyenmoi.setLayoutManager(layoutManager_truyen);



        /*------------------------------------------------------------*/

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);

        adapter_truyenhot = new adapter_truyenhot(this,dulieutruyen.getTruyenArrayList(),this);

        recyclerView.setAdapter(adapter_truyenhot);

        recyclerView.setLayoutManager(layoutManager);








    }


    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.menu_search:
                Intent intent_menu_search = new Intent(main_home.this,search.class);
                intent_menu_search.putExtra("tentaikhoan",tentaikhoan);
                intent_menu_search.putExtra("email",email);
                intent_menu_search.putExtra("phanquyen",phanquyen);
                intent_menu_search.putExtra("id",id);
                startActivity(intent_menu_search);
                break;
        }


        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(truyen truyen) {
        Intent intent_item = new Intent(main_home.this,view_thongtintruyen.class);
        String tent =   truyen.getTentruyen();
        intent_item.putExtra("tentruyen",tent);
        intent_item.putExtra("tentaikhoan",tentaikhoan);
        intent_item.putExtra("email",email);
        intent_item.putExtra("phanquyen",phanquyen);
        intent_item.putExtra("id",id);
        startActivity(intent_item);
    }
}
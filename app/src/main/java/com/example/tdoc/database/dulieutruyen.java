package com.example.tdoc.database;

import com.example.tdoc.R;
import com.example.tdoc.thongtin.chuongtruyen;
import com.example.tdoc.thongtin.truyen;

import java.util.ArrayList;

public class dulieutruyen {

    private  ArrayList<truyen> truyenArrayList ;




    public ArrayList<truyen> getTruyenArrayList() {
        return truyenArrayList;
    }

    public void setTruyenArrayList() {

        ArrayList<truyen> truyenArrayList1 = new ArrayList<>();
        truyenArrayList1.add(new truyen(1,"Thiên đạo thư viện", R.drawable.thu_vien_thien_dao,"Huyền huyễn",1,0,0,"Thiên đạo thư viện là truyện thuộc thể loại huyền huyễn kể về...",setdanhsachchuong()));
        truyenArrayList1.add(new truyen(2,"Ma Thiên Ký",R.drawable.ma_thien_ky,"Huyền huyễn",1,0,0,"Thiên đạo thư viện là truyện thuộc thể loại huyền huyễn kể về...",setdanhsachchuong()));
        truyenArrayList1.add(new truyen(3,"Bổ Thiên Ký",R.drawable.bo_thien_ky,"Huyền huyễn",1,0,0,"Thiên đạo thư viện là truyện thuộc thể loại huyền huyễn kể về...",setdanhsachchuong()));
        truyenArrayList1.add(new truyen(4,"Vũ Cực thiên hạ",R.drawable.vu_cuc_thien_ha,"Huyền huyễn",1,0,0,"Thiên đạo thư viện là truyện thuộc thể loại huyền huyễn kể về...",setdanhsachchuong()));
        truyenArrayList1.add(new truyen(5,"Thần mộ",R.drawable.than_mo,"Huyền huyễn",1,0,0,"Thiên đạo thư viện là truyện thuộc thể loại huyền huyễn kể về...",setdanhsachchuong()));
        truyenArrayList1.add(new truyen(6,"Khí vận max câp, đánh dấu ngàn năm trở thành đại lão",R.drawable.anhtruyen,"Đồng nhân",1,0,0,"Thiên đạo thư viện là truyện thuộc thể loại huyền huyễn kể về...",setdanhsachchuong()));
        truyenArrayList1.add(new truyen(7,"Ta! nhân vật chính kim thử chỉ.",R.drawable.anhtruyen01,"Đồng nhân",1,0,0,"Thiên đạo thư viện là truyện thuộc thể loại huyền huyễn kể về...",setdanhsachchuong()));
        truyenArrayList1.add(new truyen(8,"Đao trung chi vương.",R.drawable.daotrungchivuong,"Kiếm hiệp",1,0,0,"Thiên đạo thư viện là truyện thuộc thể loại huyền huyễn kể về...",setdanhsachchuong()));
        truyenArrayList1.add(new truyen(9,"Mùa xuân độc thân",R.drawable.anhtruyentdoc2,"Đô thị",1,0,0,"Thiên đạo thư viện là truyện thuộc thể loại huyền huyễn kể về...",setdanhsachchuong()));
        this.truyenArrayList= truyenArrayList1;
    }



    public ArrayList<chuongtruyen> setdanhsachchuong()
    {
        ArrayList<chuongtruyen> chuongtruyens = new ArrayList<>();

        chuongtruyens.add(new chuongtruyen(1,"Chân linh thức tỉnh","Chu thông....."));
        chuongtruyens.add(new chuongtruyen(2,"mục tiêu","Chu thông....."));
        chuongtruyens.add(new chuongtruyen(1,"kinh hiện Hoang thiên đế","Chu thông....."));

        return  chuongtruyens;
    }

    public  void themtruyen(truyen truyen)
    {
        this.truyenArrayList.add(truyen);
    }


}

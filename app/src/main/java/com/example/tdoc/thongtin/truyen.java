package com.example.tdoc.thongtin;

import java.util.ArrayList;

public class truyen {
    private int id;
    private String tentruyen;
    private int anhtruyen;
    private String theloai;
    private int taikhoandang;
    private int sochuong;
    private int luotxem;
    private int luotthich;
    private String motatruyen;
    private ArrayList<chuongtruyen> chuongtruyenArrayList;

    public truyen(int id, String tentruyen, int anhtruyen, String theloai, int taikhoandang, int luotxem, int luotthich, String motatruyen, ArrayList<chuongtruyen> chuongtruyenArrayList) {
        this.id = id;
        this.tentruyen = tentruyen;
        this.anhtruyen = anhtruyen;
        this.theloai = theloai;
        this.taikhoandang = taikhoandang;
        this.sochuong = chuongtruyenArrayList.size();
        this.luotxem = luotxem;
        this.luotthich = luotthich;
        this.motatruyen = motatruyen;
        this.chuongtruyenArrayList = chuongtruyenArrayList;
    }

    public truyen(int id, String tentruyen, int anhtruyen, String theloai, int taikhoandang) {
        this.id = id;
        this.tentruyen = tentruyen;
        this.anhtruyen = anhtruyen;
        this.theloai = theloai;
        this.taikhoandang = taikhoandang;
    }

    public truyen(int id, String tentruyen, int anhtruyen, String theloai) {
        this.id = id;
        this.tentruyen = tentruyen;
        this.anhtruyen = anhtruyen;
        this.theloai = theloai;
    }

    public truyen(String tentruyen, int anhtruyen, String theloai) {
        this.tentruyen = tentruyen;
        this.anhtruyen = anhtruyen;
        this.theloai = theloai;
    }


    public truyen(String tentruyen, String theloai, int sochuong, int luotxem, int luotthich, int anhtruyen, String motatruyen) {
        this.tentruyen = tentruyen;
        this.theloai = theloai;
        this.sochuong = sochuong;
        this.luotxem = luotxem;
        this.luotthich = luotthich;
        this.anhtruyen = anhtruyen;
        this.motatruyen = motatruyen;
    }

    public truyen(String tentruyen, ArrayList<chuongtruyen> chuongtruyenArrayList) {
        this.tentruyen = tentruyen;
        this.chuongtruyenArrayList = chuongtruyenArrayList;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTentruyen() {
        return tentruyen;
    }

    public void setTentruyen(String tentruyen) {
        this.tentruyen = tentruyen;
    }

    public int getAnhtruyen() {
        return anhtruyen;
    }

    public void setAnhtruyen(int anhtruyen) {
        this.anhtruyen = anhtruyen;
    }

    public String getTheloai() {
        return theloai;
    }

    public void setTheloai(String theloai) {
        this.theloai = theloai;
    }

    public int getTaikhoandang() {
        return taikhoandang;
    }

    public void setTaikhoandang(int taikhoandang) {
        this.taikhoandang = taikhoandang;
    }

    public String getMotatruyen() {
        return motatruyen;
    }

    public void setMotatruyen(String motatruyen) {
        this.motatruyen = motatruyen;
    }

    public ArrayList<chuongtruyen> getChuongtruyenArrayList() {
        return chuongtruyenArrayList;
    }

    public void setChuongtruyenArrayList(ArrayList<chuongtruyen> chuongtruyenArrayList) {
        this.chuongtruyenArrayList = chuongtruyenArrayList;
    }


    public int getSochuong() {
        return sochuong;
    }

    public void setSochuong(int sochuong) {
        this.sochuong = sochuong;
    }

    public int getLuotxem() {
        return luotxem;
    }

    public void setLuotxem(int luotxem) {
        this.luotxem = luotxem;
    }

    public int getLuotthich() {
        return luotthich;
    }

    public void setLuotthich(int luotthich) {
        this.luotthich = luotthich;
    }


}

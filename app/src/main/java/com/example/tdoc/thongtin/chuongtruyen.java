package com.example.tdoc.thongtin;

public class chuongtruyen {
    String tentruyen;
    int chuongso;
    String tieude;
    String noidung;
    String binhluan;
    String tentaikhoanbinhluan;

    public chuongtruyen(String tentruyen, int chuongso, String tieude, String noidung) {
        this.tentruyen = tentruyen;
        this.chuongso = chuongso;
        this.tieude = tieude;
        this.noidung = noidung;
    }

    public chuongtruyen(int chuongso, String tieude, String noidung) {
        this.chuongso = chuongso;
        this.tieude = tieude;
        this.noidung = noidung;
    }

    public chuongtruyen(String binhluan, String tentaikhoanbinhluan) {
        this.binhluan = binhluan;
        this.tentaikhoanbinhluan = tentaikhoanbinhluan;
    }

    public int getChuongso() {
        return chuongso;
    }

    public void setChuongso(int chuongso) {
        this.chuongso = chuongso;
    }

    public String getTieude() {
        return tieude;
    }

    public void setTieude(String tieude) {
        this.tieude = tieude;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public String getBinhluan() {
        return binhluan;
    }

    public void setBinhluan(String binhluan) {
        this.binhluan = binhluan;
    }

    public String getTentaikhoanbinhluan() {
        return tentaikhoanbinhluan;
    }

    public void setTentaikhoanbinhluan(String tentaikhoanbinhluan) {
        this.tentaikhoanbinhluan = tentaikhoanbinhluan;
    }

    public String getTentruyen() {
        return tentruyen;
    }
}

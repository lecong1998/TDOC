package com.example.tdoc.thongtin;

public class chuongtruyen {

    int chuongso;
    String tieude;
    String noidung;


    public chuongtruyen( int chuongso, String tieude, String noidung) {
        this.chuongso = chuongso;
        this.tieude = tieude;
        this.noidung = noidung;
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




}

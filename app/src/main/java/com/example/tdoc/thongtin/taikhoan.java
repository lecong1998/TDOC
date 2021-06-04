package com.example.tdoc.thongtin;

public class taikhoan {

    private int id;
    private String tentaikhoan;
    private String matkhau;
    private String email;
    private int phanquyen = 0;

    public taikhoan(int id, String tentaikhoan, String matkhau, String email, int phanquyen) {
        this.id = id;
        this.tentaikhoan = tentaikhoan;
        this.matkhau = matkhau;
        this.email = email;
        this.phanquyen = phanquyen;
    }

    public taikhoan(String tentaikhoan, String email, int phanquyen) {
        this.tentaikhoan = tentaikhoan;
        this.email = email;
        this.phanquyen = phanquyen;
    }

    public taikhoan(String tentaikhoan, String matkhau, String email, int phanquyen) {
        this.tentaikhoan = tentaikhoan;
        this.matkhau = matkhau;
        this.email = email;
        this.phanquyen = phanquyen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTentaikhoan() {
        return tentaikhoan;
    }

    public void setTentaikhoan(String tentaikhoan) {
        this.tentaikhoan = tentaikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhanquyen() {
        return 0;
    }

    public void setPhanquyen(int phanquyen) {
        this.phanquyen = phanquyen;
    }
}

package com.example.tdoc.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.tdoc.R;
import com.example.tdoc.thongtin.taikhoan;
import com.example.tdoc.thongtin.truyen;

public class database extends SQLiteOpenHelper {

    private static String DATABASE_NAME = "doctruyen";
    private static String TABLE_TAIKHOAN = "taikhoan";
    private static String ID_TAI_KHOAN = "idtaikhoan";
    private static String TEN_TAI_KHOAN = "tentaikhoan";
    private static String MAT_KHAU = "matkhau";
    private static String PHAN_QUYEN = "phanquyen";
    private static String EMAIL = "email";
    private static int VERSION = 1;

    private Context context;

    private String SQLQuery = "CREATE TABLE "+ TABLE_TAIKHOAN +" ( "+ID_TAI_KHOAN+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +TEN_TAI_KHOAN+" TEXT UNIQUE, "
            +MAT_KHAU+" TEXT, "
            +EMAIL+" TEXT, "
            + PHAN_QUYEN+" INTEGER) ";



    private String SQLQuery2 = "INSERT INTO taikhoan VAlUES (null,'admin','admin','admin@gmail.com',2)";


    /*----------------------------------------------------------------------*/



            /*---------------------------------------------------------------*/

    public database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Truy vấn ko có trả về kq , Tạo bảng và insert
        db.execSQL(SQLQuery);
        db.execSQL(SQLQuery2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void AddTaiKhoan(taikhoan taiKhoan){
        SQLiteDatabase db = this.getWritableDatabase();

        //không thể lưu trực tiếp xuống insert nên thông qua contentvalues
        ContentValues values = new ContentValues();
        values.put(TEN_TAI_KHOAN,taiKhoan.getTentaikhoan());
        values.put(MAT_KHAU,taiKhoan.getMatkhau());
        values.put(EMAIL,taiKhoan.getEmail());
        values.put(PHAN_QUYEN,taiKhoan.getPhanquyen());

        db.insert(TABLE_TAIKHOAN,null,values);
        //đóng lại db cho an toàn
        db.close();

    }


    //Lấy tất cả tài khoản
    public Cursor getData(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from "+TABLE_TAIKHOAN , null );
        return res;
    }

}

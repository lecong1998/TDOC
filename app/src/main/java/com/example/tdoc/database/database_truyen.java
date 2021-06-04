package com.example.tdoc.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.tdoc.R;

public class database_truyen extends SQLiteOpenHelper {

    private static String DATABASE_NAME = "doctruyen";
    private static String TABLE_TRUYEN_TDOC = "truyen";
    private static String ID_TRUYEN = "idtruyen";
    private static String TEN_TRUYEN = "tentruyen";
    private static String THELOAI = "chuong";
    private static String IMAGE = "anh";
    private Context context;


    private String SQLQuery1 = "CREATE TABLE "+ TABLE_TRUYEN_TDOC +" ( "+ID_TRUYEN+" integer primary key AUTOINCREMENT, "
            +TEN_TRUYEN+" TEXT UNIQUE, "
            +IMAGE+" INTEGER, "
            +THELOAI+" TEXT ) ";

  /*  private String SQLQuery1_truyen = "INSERT INTO truyen VAlUES (null,'Thiên đạo thư viện',"+ R.drawable.thu_vien_thien_dao+",'Huyền huyễn')";

    private String SQLQuery2_truyen = "INSERT INTO truyen VAlUES (null,'Ma thiên ký',"+ R.drawable.ma_thien_ky +",'Huyền huyễn')";

    private String SQLQuery3_truyen = "INSERT INTO truyen VAlUES (null,'Bổ thiên ký',"+ R.drawable.bo_thien_ky +",'Huyền huyễn')";

    private String SQLQuery4_truyen = "INSERT INTO truyen VAlUES (null,'Vũ cực thiên hạ',"+ R.drawable.vu_cuc_thien_ha +",'Huyền huyễn')";

*/


    public database_truyen(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLQuery1);
      //  db.execSQL(SQLQuery1_truyen);
      //  db.execSQL(SQLQuery2_truyen);
      //  db.execSQL(SQLQuery3_truyen);
      //  db.execSQL(SQLQuery4_truyen);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public Cursor getData1(){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor res =  db.rawQuery( "select * from "+TABLE_TRUYEN_TDOC+" ORDER BY "+ID_TRUYEN+" DESC LIMIT 4" , null );
        return res;
    }




}

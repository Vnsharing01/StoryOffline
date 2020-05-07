package vn.luyenandroid.storyoffline.database;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.DefaultDatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import androidx.annotation.Nullable;


public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    private final String TAG = "QLTruyenHelper";

    public static final String DB_NAME = "QLTruyen2";
    public static final int DB_VERSION = 1;

    public static final String TABLE_TRUYEN = "truyen";
    public static final String TABLE_THELOAI = "theLoai";
    public static final String TABLE_SD_CHUONG = "DanhSach";
    public static final String TABLE_TU_TRUYEN = "truyenYeuThich";

    // bảng truyện
    private static final String ID = "ID";
    private static final String TEN_TRUYEN = "Ten_Truyen";
    private static final String TAC_GIA = "Tac_Gia";
    private static final String SO_CHUONG = "So_Chuong";
    private static final String THE_LOAI = "The_Loai";
    private static final String MO_TA = "Mo_Ta";

    // bảng thể loại
    private static String TEN_TL = "Ten_TheLoai";

    public MySQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public MySQLiteOpenHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        onCreateTruyenTable(sqLiteDatabase);
        onCreateTheLoaiTable(sqLiteDatabase);

        initDataTruyen(sqLiteDatabase);
    }

    public void onCreateTruyenTable(SQLiteDatabase db){
//        String sqlTruyen = "CREATE TABLE " + TABLE_TRUYEN +" ("+
//                ID + " INTEGER , "+
//                TEN_TRUYEN + " TEXT PRIMARY KEY , "+
//                TAC_GIA + " TEXT ,"+
//                SO_CHUONG + " INTEGER NOT NULL, " +
//                THE_LOAI + "TEXT NOT NULL, "+
//                MO_TA + "TEXT )";
        String sqlTruyen = "create table truyen(id integer primary key autoincrement, ten text, tacgia text, sochuong integer,theloai text, mota text )";
        db.execSQL(sqlTruyen);


    }

    public void onCreateTheLoaiTable(SQLiteDatabase db){
        String sqlTheLoai = "CREATE TABLE " + TABLE_THELOAI + " (" +
                TEN_TL + "TEXT PRIMARY KEY ) " ;
        db.execSQL(sqlTheLoai);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        if (i != i1){
            // xoá bảng cũ
            deleteTruyenTable(sqLiteDatabase);
            deleteTheLoaiTable(sqLiteDatabase);
            // tạo bảng mới
            onCreate(sqLiteDatabase);
            sqLiteDatabase.close();
        }
    }

    public void deleteTruyenTable(SQLiteDatabase db){
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_TRUYEN);
    }

    public void deleteTheLoaiTable(SQLiteDatabase db){
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_THELOAI);
    }

    public void initDataTruyen(SQLiteDatabase db){
        String sqlInsert = "INSERT INTO " + TABLE_TRUYEN + "(ten,tacgia,sochuong,theloai,mota) VALUES(";

        sqlInsert += "'Ten truyen 0001'";
        sqlInsert += ", 'Tac gia 0001'";
        sqlInsert += ",28";
        sqlInsert += ",'The loai 0001'";
        sqlInsert += ",'Mo ta ve truyen 0001'";
        sqlInsert += ")";
        db.execSQL(sqlInsert);

        sqlInsert = "INSERT INTO " + TABLE_TRUYEN + "(ten,tacgia,sochuong,theloai,mota) VALUES(";

        sqlInsert += "'Ten truyen 0001'";
        sqlInsert += ", 'Tac gia 0001'";
        sqlInsert += ",28";
        sqlInsert += ",'The loai 0001'";
        sqlInsert += ",'Mo ta ve truyen 0001'";
        sqlInsert += ")";
        db.execSQL(sqlInsert);

        sqlInsert = "INSERT INTO " + TABLE_TRUYEN + "(ten,tacgia,sochuong,theloai,mota) VALUES(";

        sqlInsert += "'Ten truyen 0002'";
        sqlInsert += ", 'Tac gia 0001'";
        sqlInsert += ",28";
        sqlInsert += ",'The loai 0001'";
        sqlInsert += ",'Mo ta ve truyen 0001'";
        sqlInsert += ")";
        db.execSQL(sqlInsert);

        sqlInsert = "INSERT INTO " + TABLE_TRUYEN + "(ten,tacgia,sochuong,theloai,mota) VALUES(";

        sqlInsert += "'Ten truyen 0003'";
        sqlInsert += ", 'Tac gia 0001'";
        sqlInsert += ",28";
        sqlInsert += ",'The loai 0001'";
        sqlInsert += ",'Mo ta ve truyen 0001'";
        sqlInsert += ")";
        db.execSQL(sqlInsert);
    }
}

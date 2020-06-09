package vn.luyenandroid.storyoffline.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import vn.luyenandroid.storyoffline.models.Chuong;
import vn.luyenandroid.storyoffline.models.TheLoai;
import vn.luyenandroid.storyoffline.models.Truyen;


public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    private final String TAG = "QLTruyenHelper";

    public static final String DB_NAME = "QLTruyen";
    public static final int DB_VERSION = 1;

    public static final String TABLE_TRUYEN = "truyen";
    public static final String TABLE_THELOAI = "theLoai";
    public static final String TABLE_SD_CHUONG = "DanhSach";
    public static final String TABLE_TU_TRUYEN = "truyenYeuThich";

    // bảng truyện và tủ truyện
    public static final String ID = "id";
    public static final String TEN_TRUYEN = "ten";
    public static final String TAC_GIA = "tacgia";
    public static final String SO_CHUONG = "sochuong";
    public static final String THE_LOAI = "theloai";
    public static final String MO_TA = "mota";

    // bảng thể loại
    public static final String MA_TL = "matheloai";
    public static final String TEN_TL = "tentheloai";

    // bảng danh sách chương
    public static final String ID_CHUONG = "ID";
    public static final String MA_TRUYEN = "MaTruyen";
    public static final String TEN_CHUONG = "TenChuong";
    public static final String NOI_DUNG = "NoiDung";


    public MySQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public MySQLiteOpenHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        onCreateTruyenTable(sqLiteDatabase);
        onCreateTheLoaiTable(sqLiteDatabase);
        onCreateDSChuongTable(sqLiteDatabase);
        onCreateTuTruyenTable(sqLiteDatabase);

        insertDataTruyen(sqLiteDatabase);
        insertDataTheLoai(sqLiteDatabase);
    }

    /**
     * -- << create >>  khởi tạo bảng trong database--
     */
    public void onCreateTruyenTable(SQLiteDatabase db) {
//        String sqlTruyen = "create table truyen(id integer primary key autoincrement, ten text, tacgia text, sochuong integer,theloai text, mota text )";
        String sqlTruyen = "CREATE TABLE " + TABLE_TRUYEN + " (" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                TEN_TRUYEN + " TEXT NOT NULL, " +
                TAC_GIA + " TEXT , " +
                SO_CHUONG + " INTEGER ," +
                THE_LOAI + " NOT NULL, " +
                MO_TA + " TEXT )";
        db.execSQL(sqlTruyen);
    }

    public void onCreateTheLoaiTable(SQLiteDatabase db) {
        String sqlTheLoai = "CREATE TABLE theLoai(matheloai integer primary key autoincrement, tentheloai text)";
        db.execSQL(sqlTheLoai);
    }

    public void onCreateTuTruyenTable(SQLiteDatabase db) {
        String sqlTuTruyen = "CREATE TABLE truyenYeuThich(id integer primary key autoincrement, ten text, tacgia text, sochuong integer,theloai text, mota text )";
        db.execSQL(sqlTuTruyen);
    }

    public void onCreateDSChuongTable(SQLiteDatabase db) {
        String sqlDSChuong = "CREATE TABLE " + TABLE_SD_CHUONG + " (" +
                ID_CHUONG + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                MA_TRUYEN + " INTEGER NOT NULL, " +
                TEN_CHUONG + " TEXT NOT NULL," +
                NOI_DUNG + " TEXT NOT NULL)";
        db.execSQL(sqlDSChuong);

    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // xoá bảng cũ
            deleteTruyenTable(sqLiteDatabase);
            deleteTheLoaiTable(sqLiteDatabase);
            // tạo bảng mới
            onCreate(sqLiteDatabase);
            sqLiteDatabase.close();
        }
    }

    public void deleteTruyenTable(SQLiteDatabase db) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_TRUYEN);
    }

    public void deleteTheLoaiTable(SQLiteDatabase db) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_THELOAI);
    }

    /**
     * -- << insert into >>  thêm dữ liệu vào các bảng trong database--
     */
    public void insertDataTruyen(SQLiteDatabase db) {
        String sqlInsert = "INSERT INTO " + TABLE_TRUYEN +
                "( " + TEN_TRUYEN + "," + TAC_GIA +
                "," + SO_CHUONG + "," + THE_LOAI +
                "," + MO_TA + ") VALUES(";

        sqlInsert += "'Ten truyen 0001'";
        sqlInsert += ", 'Tac gia 0001'";
        sqlInsert += ",450";
        sqlInsert += ",'Kiếm Hiệp , Võ Thuật'";
        sqlInsert += ",'Mo ta ve truyen 0001'";
        sqlInsert += ")";
        db.execSQL(sqlInsert);

        sqlInsert = "INSERT INTO " + TABLE_TRUYEN + "( ten,tacgia,sochuong,theloai,mota) VALUES(";

        sqlInsert += "'Ten truyen 0002'";
        sqlInsert += ", 'Tac gia 0001'";
        sqlInsert += ",45";
        sqlInsert += ",'Triết Học, Ngụ Ngôn'";
        sqlInsert += ",'Mo ta ve truyen 0002'";
        sqlInsert += ")";
        db.execSQL(sqlInsert);

        sqlInsert = "INSERT INTO " + TABLE_TRUYEN +
                "( ten,tacgia,sochuong,theloai,mota) VALUES(";

        sqlInsert += "'Ten truyen 0003'";
        sqlInsert += ", 'Tac gia 0001'";
        sqlInsert += ",30";
        sqlInsert += ",'Tình Cảm , Hài Hước'";
        sqlInsert += ",'Mo ta ve truyen 0003'";
        sqlInsert += ")";
        db.execSQL(sqlInsert);

        sqlInsert = "INSERT INTO " + TABLE_TRUYEN +
                "( ten,tacgia,sochuong,theloai,mota) VALUES(";

        sqlInsert += "'Ten truyen 0004'";
        sqlInsert += ", 'Tac gia 0001'";
        sqlInsert += ",280";
        sqlInsert += ",'Tiên Hiệp, Fantasy'";
        sqlInsert += ",'Mo ta ve truyen 0004'";
        sqlInsert += ")";
        db.execSQL(sqlInsert);

        sqlInsert = "INSERT INTO " + TABLE_TRUYEN +
                "( " + TEN_TRUYEN + "," + TAC_GIA +
                "," + SO_CHUONG + "," + THE_LOAI +
                "," + MO_TA + ") VALUES(";

        sqlInsert += "'Thanh Long'";
        sqlInsert += ", 'Ryu'";
        sqlInsert += ",50";
        sqlInsert += ",'Fantasy, Tiên Hiệp , Võ Thuật'";
        sqlInsert += ",'thế giới giả tưởng về rồng và kẻ cưỡi rồng!'";
        sqlInsert += ")";
        db.execSQL(sqlInsert);
    }

    public void insertDataTheLoai(SQLiteDatabase db) {
        String[] TheLoaiList = {"Kiếm Hiệp", "Tiên Hiệp", "Võ Thuật", "Lịch Sử", "Fantasy",
                "Tình Cảm", "Hài Hước", "Ngụ Ngôn", "Cổ Tích", "Trinh Thám", "Triết Học",
                "Viễn Tưởng"};
        for (String theLoai : TheLoaiList) {
            String sqlInsert = "INSERT INTO " + TABLE_THELOAI + "(tentheloai) VALUES('" + theLoai + "')";
            db.execSQL(sqlInsert);
        }
    }

    public void insertDataTuTruyen(Truyen truyen) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TEN_TRUYEN, truyen.getmTen());
        values.put(TAC_GIA, truyen.getmTacGia());
        values.put(SO_CHUONG, truyen.getmSoChuong());
        values.put(THE_LOAI, truyen.getmTheLoai());
        values.put(MO_TA, truyen.getmMoTa());
        db.insert(TABLE_TU_TRUYEN, null, values);
        Cursor cursor = db.query(TABLE_TU_TRUYEN, null, null, null, null, null, null);
        cursor.getCount();
        cursor.moveToFirst();
        db.close();
//        return result;
    }

    public void insertDataDSChuong(String truyen) {
        SQLiteDatabase db = getWritableDatabase();

        for (int i = 1; i <= 50; i++) {
            String sqlInsert = "INSERT INTO " + TABLE_SD_CHUONG + "(" + MA_TRUYEN + "," + TEN_CHUONG + "," + NOI_DUNG +
                    ") VALUES( '" + truyen + "', '  Chương " + i + "'" + ", ' Nội Dung Của Chương " + i + "')";
            db.execSQL(sqlInsert);
        }
        db.close();
    }

    /**
     * -- << select >>  hiển thị dữ liệu có trong bảng ra màn hình tương ứng--
     */
    // truy vấn dữ liệu Thể loại cho activity thể loại
    public List<TheLoai> selectDataTheLoai() {
        List<TheLoai> theLoaiList = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        String sqlSelect = "SELECT " + TEN_TL + " FROM " + TABLE_THELOAI + " ORDER BY " + TEN_TL + " ASC";

        Cursor cursor = db.rawQuery(sqlSelect, null);
        if (cursor.moveToFirst()) {
            do {
                String TenTheLoai = cursor.getString(0);
                TheLoai theLoai = new TheLoai(TenTheLoai);
                theLoaiList.add(theLoai);
            } while (cursor.moveToNext());
        }
        db.close();
        return theLoaiList;
    }

    // truy vấn dữ liệu Truyện cho homeFragment
    public List<Truyen> selectDataTruyen() {
        List<Truyen> truyenList = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        String sqlSelect = "SELECT " + TEN_TRUYEN + "," +
                TAC_GIA + "," + SO_CHUONG + "," +
                THE_LOAI + " FROM " + TABLE_TRUYEN + " ORDER BY " + ID + " DESC";

        Cursor cursor = db.rawQuery(sqlSelect, null);
        if (cursor.moveToFirst()) {
            do {
                String tenTruyen = cursor.getString(0);
                String tacGia = cursor.getString(1);
                int soChuong = cursor.getInt(2);
                String theLoai = cursor.getString(3);
                Truyen mTruyen = new Truyen(tenTruyen, tacGia, soChuong, theLoai);
                truyenList.add(mTruyen);
            } while (cursor.moveToNext());
        }
        db.close();
        return truyenList;
    }

    // hiển thị truyện trong tủ truyện ra TuTruyenFragment
    public List<Truyen> selectDatatuTruyen() {
        List<Truyen> truyenList = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        String sqlTuTruyen = "SELECT " + TEN_TRUYEN + "," + TAC_GIA +
                "," + SO_CHUONG + "," + THE_LOAI + " FROM " + TABLE_TU_TRUYEN + " ORDER BY " + ID + " DESC";

        Cursor cursor = db.rawQuery(sqlTuTruyen, null);
        if (cursor.moveToFirst()) {
            do {
                String ten = cursor.getString(0);
                String tacGia = cursor.getString(1);
                int soChuong = cursor.getInt(2);
                String theLoai = cursor.getString(3);
                Truyen truyen = new Truyen(ten, tacGia, soChuong, theLoai);
                truyenList.add(truyen);
            } while (cursor.moveToNext());
        }
        db.close();
        return truyenList;
    }

    /**
     * -- << select >>  hiển thị dữ liệu có chứa thông tin cần tìm kiếm--
     */
    // hiển thị list truyện theo thể loại ( tìm kiếm theo thể loại)
    public List<Truyen> selectDataTheLoaiTruyen(TheLoai theLoai) {
        List<Truyen> truyenList = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();

        String sqlQuery = "SELECT " + TEN_TRUYEN + "," +
                TAC_GIA + "," + SO_CHUONG + "," +
                THE_LOAI + " FROM " + TABLE_TRUYEN +
                " WHERE " + THE_LOAI + " LIKE '%" + theLoai.getmTenTheLoai() + "%' ORDER BY " + TEN_TRUYEN + " ASC ";
        Cursor cursor = db.rawQuery(sqlQuery, null);

        if (cursor.moveToFirst()) {
            do {
                String tenTruyen = cursor.getString(0);
                String tacGia = cursor.getString(1);
                int soChuong = cursor.getInt(2);
                String tl = cursor.getString(3);
                Truyen truyen = new Truyen(tenTruyen, tacGia, soChuong, tl);
                truyenList.add(truyen);
            } while (cursor.moveToNext());
        }
        db.close();
        return truyenList;
    }

    // hiển thị truyện trong tủ truyện có tên giống với thông tin tìm kiếm
    public List<Truyen> selectDataTenTruyen(String truyen) {
        List<Truyen> truyenList = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();

        String sqlQuery = "SELECT " + TEN_TRUYEN + "," +
                TAC_GIA + "," + SO_CHUONG + "," +
                THE_LOAI + " FROM " + TABLE_TRUYEN +
                " WHERE " + TEN_TRUYEN + " LIKE '%" + truyen + "%' ORDER BY " + TEN_TRUYEN + " ASC ";
        Cursor cursor = db.rawQuery(sqlQuery, null);
        if (cursor.moveToFirst()) {
            do {
                String tenTruyen = cursor.getString(0);
                String tacGia = cursor.getString(1);
                int soChuong = cursor.getInt(2);
                String tl = cursor.getString(3);
                Truyen mTruyen = new Truyen(tenTruyen, tacGia, soChuong, tl);
                truyenList.add(mTruyen);
            } while (cursor.moveToNext());
        }
        db.close();
        return truyenList;
    }

    // hiển thị thông tin chi tiết truyện trong tủ truyện ra activity Giới thiệu
    public boolean selectTruyenTrongTuTruyen(String truyen) {
        boolean check;
        SQLiteDatabase db = getWritableDatabase();

        String sqlQuery = "SELECT * FROM " + TABLE_TU_TRUYEN +
                " WHERE " + TEN_TRUYEN + " = '" + truyen + "'";

        Cursor danhsach = db.rawQuery(sqlQuery, null);
        boolean count = danhsach.moveToFirst();

        // kiểm tra có tồn tại bản ghi nào hay không . yes => check = true : no => check = false
        if (count) {
            check = true;
        } else {
            check = false;
        }
        danhsach.close();
        db.close();
        return check;
    }

    // hiển thị tên trương theo danh sách
    public List<Chuong> selectIDChuong(String truyen) {
        List<Chuong> chuongList = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        String sqlChuong = " SELECT " + MA_TRUYEN + "," + TEN_CHUONG +
                " FROM " + TABLE_SD_CHUONG +
                " WHERE " + MA_TRUYEN + " = '" + truyen + "'" +
                " ORDER BY " + ID_CHUONG + " ASC ";
        Cursor cursor = db.rawQuery(sqlChuong, null);
        if (cursor.moveToFirst()) {
            do {
                String ten = cursor.getString(0);
                String soChuong = cursor.getString(1);
                Chuong chuong = new Chuong(ten, soChuong);
                chuongList.add(chuong);
            } while (cursor.moveToNext());
        }
        db.close();
        return chuongList;
    }

    // hiển thị thông tin nội dung truyện
    public List<Chuong> selectNDChuong(String tenChuong, String tenTruyen){
        List<Chuong> chuongList = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        String sqlChuong =
                " SELECT " + ID_CHUONG + "," + TEN_CHUONG + "," + NOI_DUNG +
                " FROM " + TABLE_SD_CHUONG +
                " WHERE " + TEN_CHUONG + " LIKE '%" + tenChuong + "%' " +
                " AND " +MA_TRUYEN + "= '" + tenTruyen + "' " +
                " ORDER BY " + ID_CHUONG + " ASC ";

        Cursor cursor = db.rawQuery(sqlChuong, null);
        if (cursor.moveToFirst()) {
            do {
                int ID = cursor.getInt(0);
                String ten = cursor.getString(1);
                String ND = cursor.getString(2);
                Chuong chuong = new Chuong(ID,ten, ND);
                chuongList.add(chuong);
            } while (cursor.moveToNext());
        }
        db.close();
        return chuongList;
    }

    /**
     * -- << delete >> xoá bỏ dữ liệu trong bảng --
     */
    public void delTruyen(String tenTruyen) {
        SQLiteDatabase db = getWritableDatabase();
//        String sqlQuery = "DELETE FROM " + TABLE_TU_TRUYEN +
//                " WHERE " + TEN_TRUYEN + " = '" + tenTruyen.getmTen() + "'";
//        db.rawQuery(sqlQuery,null);
        db.delete(TABLE_TU_TRUYEN, TEN_TRUYEN + " =? ", new String[]{tenTruyen});
        db.close();
    }

}

package vn.luyenandroid.storyoffline.models;

import java.io.Serializable;

public class Chuong implements Serializable {
    private int mID;
    private String mTenTruyen;
    private String mTenChuong;
    private String mNoiDung;

    public Chuong() {
    }

    public Chuong(int mID, String mTenTruyen) {
        this.mID = mID;
        this.mTenTruyen = mTenTruyen;
    }

    public Chuong(String mTenTruyen, String mTenChuong) {
        this.mTenTruyen = mTenTruyen;
        this.mTenChuong = mTenChuong;
    }


    public Chuong(int mID, String mTenChuong, String mNoiDung) {
        this.mID = mID;
        this.mTenChuong = mTenChuong;
        this.mNoiDung = mNoiDung;
    }

    public Chuong( String mTenTruyen, String mTenChuong, String mNoiDung) {
        this.mTenTruyen = mTenTruyen;
        this.mTenChuong = mTenChuong;
        this.mNoiDung = mNoiDung;
    }

    public Chuong(int mID, String mTenTruyen, String mTenChuong, String mNoiDung) {
        this.mID = mID;
        this.mTenTruyen = mTenTruyen;
        this.mTenChuong = mTenChuong;
        this.mNoiDung = mNoiDung;
    }

    public int getmID() {
        return mID;
    }

    public void setmID(int mID) {
        this.mID = mID;
    }

    public String getmTenTruyen() {
        return mTenTruyen;
    }

    public void setmTenTruyen(String mTenTruyen) {
        this.mTenTruyen = mTenTruyen;
    }

    public String getmTenChuong() {
        return mTenChuong;
    }

    public void setmTenChuong(String mTenChuong) {
        this.mTenChuong = mTenChuong;
    }

    public String getmNoiDung() {
        return mNoiDung;
    }

    public void setmNoiDung(String mNoiDung) {
        this.mNoiDung = mNoiDung;
    }
}

package vn.luyenandroid.storyoffline.models;

import java.io.Serializable;

public class Chuong implements Serializable {
    private int mID;
    private String mTenTruyen;
    private int mSTT;
    private String mTenChuong;
    private String mNoiDung;

    public Chuong() {
    }

    public Chuong(int mSTT, String mTenTruyen) {
        this.mSTT = mSTT;
        this.mTenTruyen = mTenTruyen;
    }

    public Chuong(String mTenTruyen, String mTenChuong) {
        this.mTenTruyen = mTenTruyen;
        this.mTenChuong = mTenChuong;
    }

    public Chuong(int mSTT, String mTenChuong, String mNoiDung) {
        this.mSTT = mSTT;
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

    public int getmSTT() {
        return mSTT;
    }

    public void setmSTT(int mSTT) {
        this.mSTT = mSTT;
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

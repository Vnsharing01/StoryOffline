package vn.luyenandroid.storyoffline.models;

import java.io.Serializable;

public class Truyen implements Serializable {
    private int mId;
    private String mTen;
    private String mTacGia;
    private int mSoChuong;
    private String mTheLoai;
    private String mMoTa;

    public Truyen() {
    }

    public Truyen(String mTen, String mTacGia) {
        this.mTen = mTen;
        this.mTacGia = mTacGia;
    }

    // dùng hiển thị truyện trên list truyện .
    public Truyen(String mTen, String mTacGia, int mSoChuong, String mTheLoai) {
        this.mTen = mTen;
        this.mTacGia = mTacGia;
        this.mSoChuong = mSoChuong;
        this.mTheLoai = mTheLoai;
    }


    // dùng hiển thị dữ liệu truyện lên activity giới thiệu truyện
    public Truyen(String mTen, String mTacGia, int mSoChuong, String mTheLoai, String mMoTa) {
        this.mTen = mTen;
        this.mTacGia = mTacGia;
        this.mSoChuong = mSoChuong;
        this.mTheLoai = mTheLoai;
        this.mMoTa = mMoTa;
    }

    public Truyen(int mId, String mTen, String mTacGia, int mSoChuong, String mTheLoai, String mMoTa) {
        this.mId = mId;
        this.mTen = mTen;
        this.mTacGia = mTacGia;
        this.mSoChuong = mSoChuong;
        this.mTheLoai = mTheLoai;
        this.mMoTa = mMoTa;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmTen() {
        return mTen;
    }

    public void setmTen(String mTen) {
        this.mTen = mTen;
    }

    public String getmTacGia() {
        return mTacGia;
    }

    public void setmTacGia(String mTacGia) {
        this.mTacGia = mTacGia;
    }

    public int getmSoChuong() {
        return mSoChuong;
    }

    public void setmSoChuong(int mSoChuong) {
        this.mSoChuong = mSoChuong;
    }

    public String getmTheLoai() {
        return mTheLoai;
    }

    public void setmTheLoai(String mTheLoai) {
        this.mTheLoai = mTheLoai;
    }

    public String getmMoTa() {
        return mMoTa;
    }

    public void setmMoTa(String mMoTa) {
        this.mMoTa = mMoTa;
    }
}

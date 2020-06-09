package vn.luyenandroid.storyoffline.views;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

import vn.luyenandroid.storyoffline.R;
import vn.luyenandroid.storyoffline.database.MySQLiteOpenHelper;
import vn.luyenandroid.storyoffline.models.Chuong;
import vn.luyenandroid.storyoffline.models.Truyen;

import static vn.luyenandroid.storyoffline.views.DanhSachChuongActivity.INTENT_SD;
import static vn.luyenandroid.storyoffline.views.DanhSachChuongActivity.TAG_SD;
import static vn.luyenandroid.storyoffline.views.DocTruyenActivity.INTENT_DOCTRUYEN;
import static vn.luyenandroid.storyoffline.views.DocTruyenActivity.TAG_NOIDUNG;

public class GioiThieuTruyenActivity extends AppCompatActivity {

    private MaterialToolbar materialToolbar;
    private MaterialTextView mtvTenTruyen, mtvTacGia, mtvTheLoai, mtvSoChuong, mtvMoTa;
    private MaterialButton btnDocTruyen;
    private ImageView imgYeuThich;
    private MaterialTextView mtvYeuThich, mtvDanhSach;

    MySQLiteOpenHelper db;
    Truyen truyen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gioi_thieu_truyen);
        setMaterialToolbar();
        setWidget();
        db = new MySQLiteOpenHelper(this);
        setImgYeuThich();
    }

    private void setMaterialToolbar() {
        materialToolbar = findViewById(R.id.toolBar);
        setSupportActionBar(materialToolbar);
        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_back);
        actionBar.setTitle("Thông tin truyện");
    }

    private void setWidget() {
        mtvTenTruyen = findViewById(R.id.tv_TenTruyen);
        mtvTacGia = findViewById(R.id.tv_TacGia);
        mtvSoChuong = findViewById(R.id.tv_SoChuong);
        mtvTheLoai = findViewById(R.id.tv_TheLoai);
        mtvMoTa = findViewById(R.id.tv_MoTa);
        mtvYeuThich = findViewById(R.id.tv_YeuThich);
        mtvDanhSach = findViewById(R.id.tv_DanhSachChuong);

        btnDocTruyen = findViewById(R.id.btn_DocTruyen);
        imgYeuThich = findViewById(R.id.img_YeuThich);

        mtvYeuThich.setOnClickListener(click);
        btnDocTruyen.setOnClickListener(click); // mở activity đọc truyện
        mtvDanhSach.setOnClickListener(click);

        mtvTenTruyen.setText(getData().getmTen());
        mtvTacGia.setText(getData().getmTacGia());
        mtvSoChuong.setText(String.valueOf(getData().getmSoChuong()));
        mtvTheLoai.setText(getData().getmTheLoai());

    }

    private Truyen getData() {
        Intent mIntent = getIntent();
        Bundle bundle = mIntent.getBundleExtra("data");
        Truyen truyen = (Truyen) bundle.getSerializable("truyen");

        return truyen;
    }

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.tv_YeuThich:
                    truyen = getData();
                    boolean checkTruyen = db.selectTruyenTrongTuTruyen(mtvTenTruyen.getText().toString());
                    if (checkTruyen == false) {

                        imgYeuThich.setImageResource(R.drawable.liked);
                        db.insertDataTuTruyen(truyen);

                        Toast.makeText(GioiThieuTruyenActivity.this, "Đã Thêm vào tủ truyện", Toast.LENGTH_SHORT).show();
                    } else {
                        imgYeuThich.setImageResource(R.drawable.icon_like_white);
                        db.delTruyen(truyen.getmTen());

                        Toast.makeText(GioiThieuTruyenActivity.this, "đã xoá khỏi tủ truyện", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.btn_DocTruyen:
                    truyen = getData();
                    Intent docTruyen = new Intent(GioiThieuTruyenActivity.this, DocTruyenActivity.class);
                    // gửi dữ liệu kết nối với thông tin table chương để lấy chương truyện
                    Bundle bundle = new Bundle();
                    Chuong chuong = new Chuong();
                    chuong.setmTenChuong("Chương ");
                    chuong.setmTenTruyen(truyen.getmTen());// lol

                    bundle.putSerializable(TAG_NOIDUNG, chuong);
                    docTruyen.putExtra(INTENT_DOCTRUYEN, bundle);
                    startActivity(docTruyen);
                    break;
                case R.id.tv_DanhSachChuong:
                    truyen = getData();
                    Intent danhSach = new Intent(GioiThieuTruyenActivity.this, DanhSachChuongActivity.class);
                    Bundle list = new Bundle();
                    Chuong sdChuong = new Chuong();
                    sdChuong.setmTenTruyen(truyen.getmTen());
                    list.putSerializable(TAG_SD, sdChuong);
                    danhSach.putExtra(INTENT_SD, list);
                    startActivity(danhSach);
                    break;
            }

        }
    };

    private void setImgYeuThich() {
        truyen = getData();
        boolean result = db.selectTruyenTrongTuTruyen(mtvTenTruyen.getText().toString());
        if (result != true) {
            imgYeuThich.setImageResource(R.drawable.icon_like_white);
        } else {
            imgYeuThich.setImageResource(R.drawable.liked);
        }
    }
}

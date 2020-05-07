package vn.luyenandroid.storyoffline.views;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

import vn.luyenandroid.storyoffline.R;

public class GioiThieuTruyenActivity extends AppCompatActivity {

    private MaterialToolbar materialToolbar;
    private MaterialTextView mtvTenTruyen, mtvTacGia, mtvTheLoai, mtvSoChuong, mtvMoTa;
    private MaterialButton btnDocTruyen;
    private ImageView imgYeuThich;
    private MaterialTextView mtvYeuThich,mtvDanhSach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gioi_thieu_truyen);
        setMaterialToolbar();
        setWidget();
    }

    private void setMaterialToolbar(){
        materialToolbar = findViewById(R.id.toolBar);
        setSupportActionBar(materialToolbar);
        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_back);
        actionBar.setTitle("Thông tin truyện");
    }

    private void setWidget(){
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

        getData();
    }

    private void getData(){
        Intent mIntent = getIntent();
        String TenTruyen = mIntent.getStringExtra("name");
        String TacGia = mIntent.getStringExtra("author");
        String SoChuong = mIntent.getStringExtra("soChuong");
        String TheLoai = mIntent.getStringExtra("theLoai");

        mtvTenTruyen.setText(TenTruyen);
        mtvTacGia.setText(TacGia);
        mtvSoChuong.setText(SoChuong);
        mtvTheLoai.setText(TheLoai);
    }

    Boolean isCheck = true;
    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.tv_YeuThich:
                    if (isCheck == true){
                        isCheck = false;
                        imgYeuThich.setImageResource(R.drawable.liked);
                        Toast.makeText(GioiThieuTruyenActivity.this,"Đã Thêm Truyện vào tủ truyện",Toast.LENGTH_SHORT).show();
                    }else {
                        imgYeuThich.setImageResource(R.drawable.icon_like_white);
                        isCheck = true;
                        Toast.makeText(GioiThieuTruyenActivity.this,"đã xoá khỏi tủ truyện",Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.btn_DocTruyen:
                    Intent docTruyen = new Intent(GioiThieuTruyenActivity.this, DocTruyenActivity.class);
                    // gửi dữ liệu kết nối với thông tin table chương để lấy chương truyện
                    startActivity(docTruyen);
                    break;
                case R.id.tv_DanhSachChuong:
                    Intent danhSach = new Intent(GioiThieuTruyenActivity.this, DanhSachChuongActivity.class);
                    startActivity(danhSach);
                    break;
            }

        }
    };
}

package vn.luyenandroid.storyoffline.views;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;
import java.util.List;

import vn.luyenandroid.storyoffline.R;
import vn.luyenandroid.storyoffline.adapter.DanhSachChuongAdapter;
import vn.luyenandroid.storyoffline.database.MySQLiteOpenHelper;
import vn.luyenandroid.storyoffline.models.Chuong;
import vn.luyenandroid.storyoffline.models.Truyen;

public class DanhSachChuongActivity extends AppCompatActivity {

    public static final String TAG_SD = "name";
    public static final String INTENT_SD = "danhsach";

    MaterialToolbar toolbar;
    ImageButton imgbtnBack;
    MaterialTextView mtvTitle;
    RecyclerView lvDSChuong;
    DanhSachChuongAdapter adapter;
    List<Chuong> mChuongList;

    MySQLiteOpenHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_chuong);
        setToolbar();
        db = new MySQLiteOpenHelper(this);
        setWidget();
        setLvDSChuong();


    }

    private Chuong getData(){
        Intent mIntent = getIntent();
        Bundle bundle = mIntent.getBundleExtra(INTENT_SD);
        Chuong chuong = (Chuong) bundle.getSerializable(TAG_SD);
        return chuong;
    }

    public void setToolbar() {
        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
    }

    private void setWidget(){
        imgbtnBack = findViewById(R.id.imgbtn_back);
        mtvTitle = findViewById(R.id.tv_DanhSachChuong);
        lvDSChuong = findViewById(R.id.lv_DSChuong);

        imgbtnBack.setOnClickListener(click);
    }

    private void setLvDSChuong(){
        Chuong chuong = getData();

//        db.insertDataDSChuong(chuong.getmTenTruyen());
        mChuongList = db.selectIDChuong(chuong.getmTenTruyen()); // nhận tên truyện để select ds chuong.
        adapter = new DanhSachChuongAdapter(this,mChuongList);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        lvDSChuong.setLayoutManager(manager);
        lvDSChuong.setAdapter(adapter);
    }

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.imgbtn_back:
                    finish();
                    break;
            }
        }
    };


}

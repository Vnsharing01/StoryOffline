package vn.luyenandroid.storyoffline.views;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;
import java.util.List;

import vn.luyenandroid.storyoffline.R;
import vn.luyenandroid.storyoffline.adapter.TimTheoTheLoaiAdapter;
import vn.luyenandroid.storyoffline.database.MySQLiteOpenHelper;
import vn.luyenandroid.storyoffline.models.TheLoai;
import vn.luyenandroid.storyoffline.models.Truyen;

public class TruyenTheoTheLoaiActivity extends AppCompatActivity {

    private MaterialToolbar materialToolbar;
    private TheLoai theLoai;
    private RecyclerView rvTruyen;
    private TimTheoTheLoaiAdapter mAdapter;
    private List<Truyen> mTruyens;

    MySQLiteOpenHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truyen_theo_the_loai);
        setMaterialToolbar();
        db = new MySQLiteOpenHelper(this);
        // nên kiểm tra tên thể loại trong database
        // thêm các record có thể loại đó vào trong list hiển thị .
        setRvTruyen();
    }

    private String getmIntent() {
        Intent mIntent = getIntent();
        String tenTheLoai = mIntent.getStringExtra("name");
        return tenTheLoai;
    }

    private void setMaterialToolbar() {
        materialToolbar = findViewById(R.id.toolBar);
        setSupportActionBar(materialToolbar);
        ActionBar bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setHomeAsUpIndicator(R.drawable.ic_back_white);
        String tenTheLoai = getmIntent();
        bar.setTitle("Truyện " + tenTheLoai);
    }

    private void setRvTruyen() {
        String tenTheLoai = getmIntent();
        rvTruyen = findViewById(R.id.rv_TruyenTheoTheLoai);
        theLoai = new TheLoai(tenTheLoai);
        mTruyens = db.selectDataTheLoaiTruyen(theLoai);
        mAdapter = new TimTheoTheLoaiAdapter(mTruyens, this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvTruyen.setAdapter(mAdapter);
        rvTruyen.setLayoutManager(layoutManager);

    }

}

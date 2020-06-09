package vn.luyenandroid.storyoffline.views;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

import vn.luyenandroid.storyoffline.R;
import vn.luyenandroid.storyoffline.adapter.NoiDungChuongAdapter;
import vn.luyenandroid.storyoffline.database.MySQLiteOpenHelper;
import vn.luyenandroid.storyoffline.models.Chuong;
import vn.luyenandroid.storyoffline.models.Truyen;

public class DocTruyenActivity extends AppCompatActivity {

    public static final String TAG_NOIDUNG = "noidung";
    public static final String INTENT_DOCTRUYEN = "chuong";

    MaterialToolbar toolbar;
    ImageButton imgbtnBack;
    MaterialTextView mtvTenTruyen;
    RecyclerView lvNDTruyen;
    List<Chuong> mChuongList;
    NoiDungChuongAdapter adapter;

    MySQLiteOpenHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_truyen);
        db = new MySQLiteOpenHelper(this);
        setToolBar();
        setWidget();
        setLvNDTruyen();
    }

    private void setToolBar() {
        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
    }


    private Chuong getIntentDocTruyen() {
        Intent mIntent = getIntent();
        Bundle bundle = mIntent.getBundleExtra(INTENT_DOCTRUYEN);
        Chuong chuong = (Chuong) bundle.getSerializable(TAG_NOIDUNG);
        return chuong;
    }

    private void setWidget() {
        imgbtnBack = findViewById(R.id.imgbtn_back);
        mtvTenTruyen = findViewById(R.id.tv_TenTruyen);
        lvNDTruyen = findViewById(R.id.rv_DocTruyen);

        imgbtnBack.setOnClickListener(click);
    }

    private void setLvNDTruyen() {
        Chuong chuong = getIntentDocTruyen();

        mChuongList = db.selectNDChuong(chuong.getmTenChuong(), chuong.getmTenTruyen());
        adapter = new NoiDungChuongAdapter(this, mChuongList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(lvNDTruyen);
        layoutManager.scrollToPosition(0);
        lvNDTruyen.setAdapter(adapter);
        lvNDTruyen.setLayoutManager(layoutManager);
    }


    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.imgbtn_back:
                    finish();
                    break;
            }
        }
    };
}

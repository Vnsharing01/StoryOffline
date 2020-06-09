package vn.luyenandroid.storyoffline.views;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

import vn.luyenandroid.storyoffline.R;
import vn.luyenandroid.storyoffline.adapter.TimKiemAdapter;
import vn.luyenandroid.storyoffline.database.MySQLiteOpenHelper;
import vn.luyenandroid.storyoffline.models.Truyen;

public class TimKiemActivity extends AppCompatActivity {

    private ShapeableImageView simgBack, simgTimKiem;
    private TextInputEditText tiedtTimKiem;
    private List<Truyen> mTruyens;
    private RecyclerView rvKQTimKiem;
    TimKiemAdapter mAdapter;
    MaterialToolbar mToolBar;

    MySQLiteOpenHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tim_kiem);
        setToolBar();
        setWidget();
//        setRvKQTimKiem();
        db = new MySQLiteOpenHelper(this);
    }

    private void setToolBar(){
        mToolBar = findViewById(R.id.toolBar);

        setSupportActionBar(mToolBar);
        ActionBar mBar = getSupportActionBar();
    }
    private void setWidget(){
        simgBack = findViewById(R.id.img_QuayLai);
        simgTimKiem = findViewById(R.id.img_timKiem);
        tiedtTimKiem = findViewById(R.id.edt_timKiem);
        rvKQTimKiem = findViewById(R.id.rv_TimKiemTruyen);

        simgBack.setOnClickListener(click);
        simgTimKiem.setOnClickListener(click);
    }
    private void setRvKQTimKiem(String tenTruyen){
        mTruyens = db.selectDataTenTruyen(tenTruyen);
        mAdapter = new TimKiemAdapter(this,mTruyens);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvKQTimKiem.setAdapter(mAdapter);
        rvKQTimKiem.setLayoutManager(layoutManager);
    }

    private View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.img_QuayLai:
                    finish();
                    break;
                case R.id.img_timKiem:
                    String timKiem = String.valueOf(tiedtTimKiem.getText());
                    // kiểm tra trong db có cái dữ liệu đó không ?
                    // add vào list hiển thị .
                    setRvKQTimKiem(timKiem);
                    break;
            }
        }
    };
}

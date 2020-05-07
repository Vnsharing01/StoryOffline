package vn.luyenandroid.storyoffline.views;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;
import java.util.List;

import vn.luyenandroid.storyoffline.R;
import vn.luyenandroid.storyoffline.adapter.TheLoaiAdapter;
import vn.luyenandroid.storyoffline.database.MySQLiteOpenHelper;
//import vn.luyenandroid.storyoffline.database.QLTheLoai;
//import vn.luyenandroid.storyoffline.database.QLTruyen;
import vn.luyenandroid.storyoffline.models.TheLoai;

public class TheLoaiActivity extends AppCompatActivity{

    MaterialToolbar mToolBar;
    GridView grvTheLoai;
    List<TheLoai> mTheLoaiList;
    TheLoaiAdapter mAdapter;
    SQLiteOpenHelper sqLiteOpenHelper;
    //QLTruyen db = new QLTruyen(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_loai);
        setToolBar();



        grvTheLoai = findViewById(R.id.gv_TheLoai);
        setGridView();
    }

    private void setToolBar(){
        mToolBar = findViewById(R.id.toolBar);
        setSupportActionBar(mToolBar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_back_white);
        actionBar.setTitle("Thể Loại");
    }

    private void setGridView(){
/*        db.addTheLoai();
        mTheLoaiList = db.getTheLoai();
        mAdapter = new TheLoaiAdapter(mTheLoaiList, R.layout.row_list_the_loai, this);
        grvTheLoai.setAdapter(mAdapter);

        grvTheLoai.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View v, int position, long id) {
                TheLoai theLoai = (TheLoai) grvTheLoai.getItemAtPosition(position);
                Intent mIntent = new Intent(TheLoaiActivity.this, TruyenTheoTheLoaiActivity.class);
                mIntent.putExtra("name",theLoai.getmTenTheLoai());
                startActivity(mIntent);
            }
        });
        //*/

    }



}

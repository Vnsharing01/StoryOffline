package vn.luyenandroid.storyoffline.views;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textview.MaterialTextView;

import vn.luyenandroid.storyoffline.R;
import vn.luyenandroid.storyoffline.adapter.pagerAdapter;
import vn.luyenandroid.storyoffline.database.MySQLiteOpenHelper;
import vn.luyenandroid.storyoffline.fragment.HomeFragment;
import vn.luyenandroid.storyoffline.fragment.MoreFragment;
import vn.luyenandroid.storyoffline.fragment.TuTruyenFragment;

public class MainActivity extends AppCompatActivity {

    pagerAdapter pagerAdapter;

    TabLayout mTabLayout;
    ViewPager mViewPager;
    MaterialToolbar mToolBar;

    MaterialTextView mtvTimKiem;
    ShapeableImageView simgAvatar;
    ShapeableImageView simgTheLoai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setmToolBar();
        setWidget();

        setupViewPager();
        mTabLayout.setupWithViewPager(mViewPager);
        setIcon();

//        MySQLiteOpenHelper db = new MySQLiteOpenHelper(this);
//        SQLiteDatabase sqLiteDatabase = db.getWritableDatabase();
    }

    private void setmToolBar(){
        mToolBar = findViewById(R.id.toolBar);

        setSupportActionBar(mToolBar);
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setTitle("Reading Offline");
    }
    private void setWidget(){
        mTabLayout = findViewById(R.id.tabLayout);
        mViewPager = findViewById(R.id.viewPager);
        mtvTimKiem = findViewById(R.id.tv_timKiem);
        simgTheLoai = findViewById(R.id.img_TheLoai);

        mtvTimKiem.setOnClickListener(click);
        simgTheLoai.setOnClickListener(click);
    }

    /// thêm các fragment vào activity
    private void setupViewPager(){
        FragmentManager manager = getSupportFragmentManager();
        pagerAdapter mPagerAdapter = new pagerAdapter(manager);

        mPagerAdapter.addFragment(new HomeFragment(), "home");
        mPagerAdapter.addFragment(new TuTruyenFragment(), "tủ truyện");
        mPagerAdapter.addFragment(new MoreFragment(), "more");
        mViewPager.setAdapter(mPagerAdapter);
    }

    /// gán icon chon từng tab fragment
    private void setIcon(){
        mTabLayout.getTabAt(0).setIcon(R.drawable.home);
        mTabLayout.getTabAt(1).setIcon(R.drawable.reading_now_hands);
        mTabLayout.getTabAt(2).setIcon(R.drawable.ic_more_setting);
    }

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.tv_timKiem:
                    Intent timKiem = new Intent(MainActivity.this, TimKiemActivity.class);
                    startActivity(timKiem);
                    break;
                case R.id.img_TheLoai:
                    Intent theLoai = new Intent(MainActivity.this, TheLoaiActivity.class);
                    startActivity(theLoai);
                    break;

            }
        }
    };
}

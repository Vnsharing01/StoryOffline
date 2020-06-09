package vn.luyenandroid.storyoffline.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import vn.luyenandroid.storyoffline.R;
import vn.luyenandroid.storyoffline.database.MySQLiteOpenHelper;
import vn.luyenandroid.storyoffline.models.Truyen;
import vn.luyenandroid.storyoffline.adapter.HomeAdapter;

public class HomeFragment extends Fragment {

    RecyclerView lvTruyen;
    List<Truyen> mTruyenList;
    HomeAdapter mAdapter;
    MySQLiteOpenHelper db;
    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragment = inflater.inflate(R.layout.fragment_home, container, false);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lvTruyen = getView().findViewById(R.id.lv_Truyen);
        db = new MySQLiteOpenHelper(getContext());
        mTruyenList = db.selectDataTruyen();
//        createData();
        // setAdapter cho recyclerView
        mAdapter = new HomeAdapter(getContext(),mTruyenList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        lvTruyen.setLayoutManager(layoutManager);
        lvTruyen.setAdapter(mAdapter);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

}

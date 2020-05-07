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
import vn.luyenandroid.storyoffline.models.Truyen;
import vn.luyenandroid.storyoffline.adapter.HomeAdapter;

public class HomeFragment extends Fragment {

    RecyclerView lvTruyen;
    List<Truyen> mTruyenList;
    HomeAdapter mAdapter;
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

        mTruyenList = new ArrayList<>();
        createData();
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

    private void createData(){
        Truyen mTruyen1 = new Truyen("Long Tinh Truyền Thuyết","Hoả Vân",450,"Kiếm Hiệp, Tiên Hiệp, Fantasy");
        Truyen mTruyen2 = new Truyen("Cổ Học Tinh Hoa","Tử An",500,"Ngụ Ngôn");
        Truyen mTruyen3 = new Truyen("Kị Sĩ Rồng","Edge",1455," Fantasy, Võ Thuật");
        Truyen mTruyen4 = new Truyen("Chu Tước","Thiên Mị",50,"Tiên Hiệp, Fantasy");
        Truyen mTruyen5 = new Truyen("Gió và Trăng","Hoàng Lan",45,"Tình Cảm");
        Truyen mTruyen6 = new Truyen("Tình Yêu Nhỏ","ABCXYZ",35,"Tình Cảm, Hài Hước");

        mTruyenList.add(mTruyen1);
        mTruyenList.add(mTruyen2);
        mTruyenList.add(mTruyen3);
        mTruyenList.add(mTruyen4);
        mTruyenList.add(mTruyen5);
        mTruyenList.add(mTruyen6);
    }
}

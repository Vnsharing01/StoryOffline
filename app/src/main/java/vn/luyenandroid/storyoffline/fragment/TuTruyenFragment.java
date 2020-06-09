package vn.luyenandroid.storyoffline.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import vn.luyenandroid.storyoffline.R;
import vn.luyenandroid.storyoffline.adapter.TuTruyenAdapter;
import vn.luyenandroid.storyoffline.database.MySQLiteOpenHelper;
import vn.luyenandroid.storyoffline.models.Truyen;


public class  TuTruyenFragment extends Fragment {

    RecyclerView rvTuTruyen;
    List<Truyen> mTruyenList;
    TuTruyenAdapter mAdapter;
    MySQLiteOpenHelper db;

    public TuTruyenFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View TuTruyen = inflater.inflate(R.layout.fragment_tu_truyen, container, false);
        return TuTruyen;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        db = new MySQLiteOpenHelper(getContext());
        mTruyenList = db.selectDatatuTruyen();
        rvTuTruyen = getView().findViewById(R.id.rv_TuTruyen);
//        createData();
        mAdapter = new TuTruyenAdapter(mTruyenList,getContext());
        mAdapter.notifyDataSetChanged();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rvTuTruyen.setAdapter(mAdapter);
        rvTuTruyen.setLayoutManager(layoutManager);
        mAdapter.notifyDataSetChanged();

        /**
         * todo: 1 recyclerView cần phải có 1 adapter và 1 layout magager để được khởi tạo .
         *  1 adapter để giúp hiển thị dữ liệu 1 tiem lên recyclerView.
         *  1 layout manager để xác định cách hiển thị của các item trong recyclerView.
         *  ( - LinearLayoutManager : vertical hoặc horizontal;
         *    - GridLayoutManager : dạng lưới ;
         *    -StaggeredGridLayoutManager : dạng lưới so le nhau;
         */

    }
}

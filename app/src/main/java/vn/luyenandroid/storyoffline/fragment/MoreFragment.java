package vn.luyenandroid.storyoffline.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.textview.MaterialTextView;

import vn.luyenandroid.storyoffline.R;
import vn.luyenandroid.storyoffline.database.MySQLiteOpenHelper;
import vn.luyenandroid.storyoffline.views.ThongTinUngDungActivity;


public class MoreFragment extends Fragment {
    MySQLiteOpenHelper db;

    MaterialTextView tvVersion, tvInfo, tvSp, tvRate;
    public MoreFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View moreView = inflater.inflate(R.layout.fragment_more, container, false);
        // Inflate the layout for this fragment
        tvVersion = moreView.findViewById(R.id.tv_Version);
        tvInfo = moreView.findViewById(R.id.tv_info);
        tvSp = moreView.findViewById(R.id.tv_support);
        tvRate = moreView.findViewById(R.id.tv_rate);

        tvVersion.setOnClickListener(click);
        tvInfo.setOnClickListener(click);
        return moreView;
    }

//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        db = new MySQLiteOpenHelper(getView().getContext());
//
//
//    }

    private View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          switch (v.getId()){
              case R.id.tv_Version:
                  showAlterDialog();
                  break;
              case R.id.tv_info:
                  Intent info = new Intent(getContext(), ThongTinUngDungActivity.class);
                  startActivity(info);
                  break;
              case R.id.tv_support:
                  break;
              case R.id.tv_rate:
                  break;
          }
        }
    };

    private void showAlterDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getView().getContext());
        builder.setTitle("Read Offline");
        builder.setMessage("Version: " + db.DB_VERSION);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });

        Dialog dialog = builder.create();
        dialog.show();
    }
}

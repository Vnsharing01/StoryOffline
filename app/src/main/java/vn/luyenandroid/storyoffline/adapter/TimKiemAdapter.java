package vn.luyenandroid.storyoffline.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

import vn.luyenandroid.storyoffline.R;
import vn.luyenandroid.storyoffline.models.Truyen;
import vn.luyenandroid.storyoffline.views.GioiThieuTruyenActivity;

public class TimKiemAdapter extends RecyclerView.Adapter<TimKiemAdapter.ViewHolder> {

    private Context mContext;
    private List<Truyen> mTruyenList;

    public TimKiemAdapter(Context mContext, List<Truyen> mTruyenList) {
        this.mContext = mContext;
        this.mTruyenList = mTruyenList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View SearchView = LayoutInflater.from(mContext).inflate(R.layout.row_list_truyen_home,parent,false);
        ViewHolder holder = new ViewHolder(SearchView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        Truyen mTruyen = mTruyenList.get(position);
        holder.simgBiaSach.setImageResource(R.drawable.test);
        holder.mtvTenTruyen.setText(mTruyen.getmTen());
        holder.mtvTacGia.setText(mTruyen.getmTacGia());
        holder.mtvSoChuong.setText(String.valueOf(mTruyen.getmSoChuong()));
        holder.mtvTheLoai.setText(mTruyen.getmTheLoai());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(mContext, GioiThieuTruyenActivity.class);
                mIntent.putExtra("name",holder.mtvTenTruyen.getText());
                mIntent.putExtra("author",holder.mtvTacGia.getText());
                mIntent.putExtra("soChuong",holder.mtvSoChuong.getText());
                mIntent.putExtra("theLoai",holder.mtvTheLoai.getText());
                mContext.startActivity(mIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mTruyenList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        View mItemView;
        MaterialTextView mtvTenTruyen, mtvTacGia, mtvSoChuong, mtvTheLoai;
        ShapeableImageView simgBiaSach;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mItemView = itemView;
            mtvTenTruyen = mItemView.findViewById(R.id.tv_TenTruyen);
            mtvTacGia = mItemView.findViewById(R.id.tv_TacGia);
            mtvSoChuong = mItemView.findViewById(R.id.tv_SoChuong);
            mtvTheLoai = mItemView.findViewById(R.id.tv_TheLoai);
            simgBiaSach = mItemView.findViewById(R.id.img_BiaSach);
        }
    }
}

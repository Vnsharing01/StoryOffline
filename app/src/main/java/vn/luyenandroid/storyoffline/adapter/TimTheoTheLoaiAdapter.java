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

public class TimTheoTheLoaiAdapter extends RecyclerView.Adapter<TimTheoTheLoaiAdapter.ViewHolder>{

    private List<Truyen> mTruyenList;
    private Context mContext;

    public TimTheoTheLoaiAdapter(List<Truyen> mTruyenList, Context mContext) {
        this.mTruyenList = mTruyenList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(mContext).inflate(R.layout.row_list_truyen_home,parent,false);
        ViewHolder holder = new ViewHolder(convertView);
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

        holder.mItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(mContext , GioiThieuTruyenActivity.class);
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

    class ViewHolder extends RecyclerView.ViewHolder {
        private View mItemView;
        private MaterialTextView mtvTenTruyen, mtvTacGia, mtvSoChuong, mtvTheLoai;
        private ShapeableImageView simgBiaSach;
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

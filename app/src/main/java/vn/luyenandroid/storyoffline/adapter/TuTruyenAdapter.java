package vn.luyenandroid.storyoffline.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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

public class TuTruyenAdapter extends RecyclerView.Adapter<TuTruyenAdapter.ViewHolder> {

    private List<Truyen> mTruyenList;
    private Context mContext;

    public TuTruyenAdapter(List<Truyen> mTruyenList, Context mContext) {
        this.mTruyenList = mTruyenList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    //  tạo ra đối tượng ViewHolder, trong nó chứa View hiện thị dữ liệu
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Nạp layout cho View biểu diễn phần tử trong List
        View ConvertView = LayoutInflater.from(mContext).inflate(R.layout.row_list_tu_truyen,parent,false);
        ViewHolder viewHolder = new ViewHolder(ConvertView);
        return viewHolder;
    }

    @Override
    //  chuyển dữ liệu phần tử vào ViewHolder
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        Truyen mTruyen = mTruyenList.get(position);
         holder.mtvTenTruyen.setText(mTruyen.getmTen());
         holder.mtvTacGia.setText(mTruyen.getmTacGia());
         holder.mtvSoChuong.setText(String.valueOf(mTruyen.getmSoChuong()));
         holder.mtvTheLoai.setText(mTruyen.getmTheLoai());

         holder.mItemView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent Info = new Intent(v.getContext(), GioiThieuTruyenActivity.class);
                 Bundle bundle = new Bundle();
                 Truyen mTruyen = new Truyen();

                 mTruyen.setmTen(holder.mtvTenTruyen.getText().toString());
                 mTruyen.setmTacGia(holder.mtvTacGia.getText().toString());
                 mTruyen.setmSoChuong(Integer.valueOf(String.valueOf(holder.mtvSoChuong.getText())));
                 mTruyen.setmTheLoai(holder.mtvTheLoai.getText().toString());
                 bundle.putSerializable("truyen", mTruyen);
                 Info.putExtra("data" , bundle);
                 mContext.startActivity(Info);
             }
         });
    }

    @Override
    // đếm tổng số phần tử trong List
    public int getItemCount() {
        return mTruyenList.size();
    }

    /**
     * Lớp nắm giữ cấu trúc view
     */
    public class ViewHolder extends RecyclerView.ViewHolder {

        private View mItemView;
        private MaterialTextView mtvTenTruyen, mtvTacGia, mtvSoChuong, mtvTheLoai;
        private ShapeableImageView simgBiaSach;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mItemView = itemView;
            mtvTenTruyen = itemView.findViewById(R.id.tv_TenTruyen);
            mtvTacGia = itemView.findViewById(R.id.tv_TacGia);
            mtvSoChuong = itemView.findViewById(R.id.tv_SoChuong);
            mtvTheLoai = itemView.findViewById(R.id.tv_TheLoai);
            simgBiaSach = itemView.findViewById(R.id.img_BiaSach);
        }
    }
}

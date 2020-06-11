package vn.luyenandroid.storyoffline.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;

import java.util.List;

import vn.luyenandroid.storyoffline.R;
import vn.luyenandroid.storyoffline.models.Chuong;
import vn.luyenandroid.storyoffline.views.DocTruyenActivity;

import static vn.luyenandroid.storyoffline.views.DocTruyenActivity.INTENT_DOCTRUYEN;
import static vn.luyenandroid.storyoffline.views.DocTruyenActivity.TAG_NOIDUNG;

public class DanhSachChuongAdapter extends RecyclerView.Adapter<DanhSachChuongAdapter.ViewHolder> {

    private Context mContext;
    private List<Chuong> mChuongList;
    public DanhSachChuongAdapter(Context mContext, List<Chuong> mChuongList){
        this.mContext = mContext;
        this.mChuongList = mChuongList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(mContext).inflate(R.layout.row_list_chuong,parent,false);
        ViewHolder holder = new ViewHolder(convertView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final Chuong mChuong = mChuongList.get(position);
        holder.mtvChuongSo.setText(mChuong.getmTenChuong());

        holder.mtvChuongSo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(mContext, DocTruyenActivity.class);
                Bundle bundle = new Bundle();
                Chuong chuong = new Chuong();
                chuong.setmSTT(position+1);
                chuong.setmTenTruyen(mChuong.getmTenTruyen()); // lol

                bundle.putSerializable(TAG_NOIDUNG, chuong);
                mIntent.putExtra(INTENT_DOCTRUYEN,bundle);
                mContext.startActivity(mIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mChuongList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        View mItemView;
        MaterialTextView mtvChuongSo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mItemView = itemView;
            mtvChuongSo = mItemView.findViewById(R.id.tv_SoChuong);
        }
    }
}

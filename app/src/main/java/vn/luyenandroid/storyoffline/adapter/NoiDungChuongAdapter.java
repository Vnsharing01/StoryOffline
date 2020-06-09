package vn.luyenandroid.storyoffline.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;

import java.util.List;

import vn.luyenandroid.storyoffline.R;
import vn.luyenandroid.storyoffline.models.Chuong;

public class NoiDungChuongAdapter extends RecyclerView.Adapter<NoiDungChuongAdapter.ViewHolder>{
    private Context mContext;
    private List<Chuong> mChuongList;

    public NoiDungChuongAdapter(Context mContext, List<Chuong> mChuongList) {
        this.mContext = mContext;
        this.mChuongList = mChuongList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(mContext).inflate(R.layout.row_noi_dung_chuong,parent,false);
        ViewHolder holder = new ViewHolder(convertView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final Chuong chuong = mChuongList.get(position);
        holder.mtvTenChuong.setText(chuong.getmTenChuong());
        holder.mtvNDChuong.setText(chuong.getmNoiDung());
    }

    @Override
    public int getItemCount() {
        return mChuongList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        View mItemView;
        MaterialTextView mtvTenChuong, mtvNDChuong;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mItemView = itemView;
            mtvTenChuong = mItemView.findViewById(R.id.tv_TenChuong);
            mtvNDChuong = mItemView.findViewById(R.id.tv_NoiDungChuong);
        }
    }
}

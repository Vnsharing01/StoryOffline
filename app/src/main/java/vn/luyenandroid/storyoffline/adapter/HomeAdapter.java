package vn.luyenandroid.storyoffline.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

import vn.luyenandroid.storyoffline.R;
import vn.luyenandroid.storyoffline.models.Truyen;
import vn.luyenandroid.storyoffline.views.GioiThieuTruyenActivity;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    private Context mContext;
    private List<Truyen> mTruyenList;

    public HomeAdapter(Context mContext, List<Truyen> mTruyenList) {
        this.mContext = mContext;
        this.mTruyenList = mTruyenList;
    }

    @NonNull
    @Override
    // tạo ra đối tượng ViewHolder, trong nó chứa View hiện thị dữ liệu
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Nạp layout cho View biểu diễn phần tử trong List
        View HomeView = LayoutInflater.from(mContext).inflate(R.layout.row_list_truyen_home,parent,false);
        ViewHolder viewHolder = new ViewHolder(HomeView); //(ViewHolder(itemView)
        return viewHolder;
    }

    @Override
    //  chuyển dữ liệu phần tử vào ViewHolder
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final Truyen mTruyen = mTruyenList.get(position);
        holder.imgBiaSach.setImageResource(R.drawable.test);
        holder.tvTenTruyen.setText(mTruyen.getmTen());
        holder.tvTacGia.setText(mTruyen.getmTacGia());
        holder.tvSoChuong.setText(String.valueOf(mTruyen.getmSoChuong()));
        holder.tvTheLoai.setText(mTruyen.getmTheLoai());

        holder.mItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // truyền dữ liệu và mở activity GioiThieuTruyen
                Intent mIntent = new Intent(mContext,GioiThieuTruyenActivity.class);
                mIntent.putExtra("name",holder.tvTenTruyen.getText());
                mIntent.putExtra("author",holder.tvTacGia.getText());
                mIntent.putExtra("soChuong",holder.tvSoChuong.getText());
                mIntent.putExtra("theLoai",holder.tvTheLoai.getText());
                mContext.startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTruyenList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        private MaterialTextView tvTenTruyen, tvTacGia, tvSoChuong, tvTheLoai;
        private ShapeableImageView imgBiaSach;
        private View mItemView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mItemView = itemView;
            tvTenTruyen = mItemView.findViewById(R.id.tv_TenTruyen);
            tvTacGia = mItemView.findViewById(R.id.tv_TacGia);
            tvSoChuong = mItemView.findViewById(R.id.tv_SoChuong);
            tvTheLoai = mItemView.findViewById(R.id.tv_TheLoai);
            imgBiaSach = mItemView.findViewById(R.id.img_BiaSach);
        }
    }
}

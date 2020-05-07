package vn.luyenandroid.storyoffline.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.google.android.material.textview.MaterialTextView;

import java.util.List;

import vn.luyenandroid.storyoffline.R;
import vn.luyenandroid.storyoffline.models.TheLoai;

public class TheLoaiAdapter extends BaseAdapter {

    private List<TheLoai> mListTheLoai;
    private int mResoucre;
    private Context mContext;

    public TheLoaiAdapter(List<TheLoai> mListTheLoai, int mResoucre, Context mContext) {
        this.mListTheLoai = mListTheLoai;
        this.mResoucre = mResoucre;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mListTheLoai.size();
    }

    @Override
    public Object getItem(int position) {
        return mListTheLoai.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.row_list_the_loai,parent,false);
            viewHolder.mtvTheLoai = convertView.findViewById(R.id.mtv_TheLoai);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        TheLoai theLoai = mListTheLoai.get(position);
        viewHolder.mtvTheLoai.setText(theLoai.getmTenTheLoai());
        return convertView;
    }

    class ViewHolder{
        MaterialTextView mtvTheLoai;
    }
}

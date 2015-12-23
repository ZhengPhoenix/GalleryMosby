package com.gallery.phoenix;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gallery.phoenix.gallerymosby.R;

import java.util.ArrayList;

/**
 * Created by hui1.zheng on 12/23/2015.
 */
public class AlbumBaseAdapter extends RecyclerView.Adapter<AlbumBaseAdapter.ViewHolder>{

    private Context mContext;
    private ArrayList<String> mDataSet;

    public AlbumBaseAdapter(Context context, @Nullable ArrayList<String> attrs) {

        mContext = context;
        mDataSet = attrs;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.album_item_card, parent, false);
        ViewHolder holder = new ViewHolder(view);
        holder.setIsRecyclable(true);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.imageView.setImageResource(R.drawable.ic_cloud_off);

    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.card_image);
            textView = (TextView) itemView.findViewById(R.id.card_name);
        }
    }

    public ArrayList<String> getmDataSet() {
        return mDataSet;
    }

    public void setmDataSet(ArrayList<String> mDataSet) {
        this.mDataSet = mDataSet;
    }
}

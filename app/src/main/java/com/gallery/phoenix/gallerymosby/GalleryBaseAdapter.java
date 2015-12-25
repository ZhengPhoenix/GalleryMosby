package com.gallery.phoenix.gallerymosby;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by hui1.zheng on 12/25/2015.
 */
public class GalleryBaseAdapter extends RecyclerView.Adapter<GalleryBaseAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<String> mData = new ArrayList<String>();

    public GalleryBaseAdapter(Context context, ArrayList<String> data) {
        mContext = context;
        mData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.gallery_item_card, parent, false);
        ViewHolder holder = new ViewHolder(view);
        holder.setIsRecyclable(true);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.image.setImageResource(R.drawable.ic_cloud_off);
    }

    @Override
    public int getItemCount() {

        return mData.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.card_image_gallery);
        }
    }

    public ArrayList<String> getmData() {
        return mData;
    }

    public void setmData(ArrayList<String> mData) {
        this.mData = mData;
    }
}

package com.gallery.phoenix.gallerymosby.presenter;

import android.util.Log;

import com.gallery.phoenix.gallerymosby.view.GalleryLCEView;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import java.util.ArrayList;

/**c
 * Created by hui1.zheng on 12/22/2015.
 */
public class GalleryPresenter extends MvpBasePresenter<GalleryLCEView> {
    private final static String TAG = "GalleryPresenter";
    private ArrayList<String> mData = new ArrayList<String>();

    //this method should be called at the very beginning
    public void initiatePresenter(){
        getView().showLoading(false);
        int count = 40;
        for(int i = 0;i < count; i ++) {
            mData.add(i, "test");
        }
        Log.d(TAG, "initiate presenter finished");
    }

    //for loading specific album cover
    public void loadGalleryPhoto(){
        getView().setData(mData);
        getView().showContent();
    }
}

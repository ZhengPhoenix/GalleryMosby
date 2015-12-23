package com.gallery.phoenix.gallerymosby.presenter;

import com.gallery.phoenix.gallerymosby.view.AlbumLCEView;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;

import java.util.ArrayList;

/**
 * Created by hui1.zheng on 12/22/2015.
 */
public class AlbumPresenter extends MvpBasePresenter<AlbumLCEView>{

    private ArrayList<String> mData = new ArrayList<String>();

    //this method should be called at the very beginning
    public void initiatePresenter(){
        getView().showLoading(false);
        int count = 10;
        for(int i = 0;i < count; i ++) {
            mData.add(i, "test");
        }
    }

    //for loading specific album cover
    public void loadAlbumCover(){
        getView().setData(mData);
        getView().showContent();
    }
}

package com.gallery.phoenix.gallerymosby.presenter;

import com.gallery.phoenix.gallerymosby.view.AlbumLCEView;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by hui1.zheng on 12/22/2015.
 */
public class AlbumPresenter<V extends AlbumLCEView, M> extends MvpBasePresenter<AlbumLCEView>{


    //this method should be called at the very beginning
    public void initiatePresenter(){

    }

    //for loading specific album cover
    public void loadAlbumCover(AlbumLCEView view){

    }
}

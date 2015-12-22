package com.gallery.phoenix.gallerymosby.presenter;

import com.gallery.phoenix.gallerymosby.view.AlbumView;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;

/**
 * Created by hui1.zheng on 12/22/2015.
 */
public interface AlbumPresenter<V extends AlbumView, M> extends MvpPresenter<V> {


    //LCE method
    public void showLoading();
    public void showContent();
    public void showError();

    //this method should be called at the very beginning
    public void initiatePresenter();

    //for loading specific album cover
    public void loadAlbumCover(AlbumView view);
}

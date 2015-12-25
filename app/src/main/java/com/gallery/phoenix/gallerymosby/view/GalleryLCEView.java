package com.gallery.phoenix.gallerymosby.view;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;

import java.util.ArrayList;

/**
 * Created by hui1.zheng on 12/22/2015.
 */
public interface GalleryLCEView extends MvpLceView<ArrayList<String>> {

    public void updateGalleryPhoto();
}

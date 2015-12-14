package com.gallery.phoenix.gallerymosby.test;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

/**
 * Created by hui1.zheng on 12/14/2015.
 */
public class MvpTestPresenter extends MvpBasePresenter<MvpTestView> {


    public void doA() {
        getView().changeA();
    }

    public void doB(){
        getView().changeB();
    }
}

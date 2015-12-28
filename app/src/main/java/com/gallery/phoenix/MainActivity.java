package com.gallery.phoenix;


import android.app.FragmentManager;
import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gallery.phoenix.gallerymosby.AlbumBaseFragment;
import com.gallery.phoenix.gallerymosby.GalleryBaseFragment;
import com.gallery.phoenix.gallerymosby.R;

public class MainActivity extends AppCompatActivity implements AlbumBaseFragment.OnFragmentInteractionListener, GalleryBaseFragment.OnFragmentInteractionListener{

    protected FragmentManager mFragmentManager;
    protected AlbumBaseFragment mAlbumFragment;
    protected GalleryBaseFragment mGalleryFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(mGalleryFragment == null) {
            mGalleryFragment = new GalleryBaseFragment();
        }

        if(mAlbumFragment == null) {
            mAlbumFragment = new AlbumBaseFragment();
        }

        mAlbumFragment.setmFragmentListener(this);
        getSupportFragmentManager().beginTransaction().replace(android.R.id.content, mAlbumFragment).commit();
    }


    @Override
    public void onFragmentInteraction(String args) {
        if(args.equals(AlbumBaseFragment.ALBUM_CLICK)){
            if(mGalleryFragment == null) {
                mGalleryFragment = new GalleryBaseFragment();
            }
            mGalleryFragment.setmFragmentListener(this);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(android.R.id.content, mGalleryFragment);
            transaction.addToBackStack(null);
            transaction.commit();c
        }
    }
}

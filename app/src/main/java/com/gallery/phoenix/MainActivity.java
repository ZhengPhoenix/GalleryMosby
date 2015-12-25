package com.gallery.phoenix;


import android.app.FragmentManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gallery.phoenix.gallerymosby.AlbumBaseFragment;
import com.gallery.phoenix.gallerymosby.GalleryBaseFragment;
import com.gallery.phoenix.gallerymosby.R;

public class MainActivity extends AppCompatActivity implements AlbumBaseFragment.OnFragmentInteractionListener, GalleryBaseFragment.OnFragmentInteractionListener{

    protected FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new GalleryBaseFragment()).commit();
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

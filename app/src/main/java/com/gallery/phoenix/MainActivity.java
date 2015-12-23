package com.gallery.phoenix;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gallery.phoenix.gallerymosby.R;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceFragment;

public class MainActivity extends AppCompatActivity implements AlbumBaseFragment.OnFragmentInteractionListener{

    protected FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new AlbumBaseFragment()).commit();
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

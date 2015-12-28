package com.gallery.phoenix.gallerymosby;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gallery.phoenix.gallerymosby.presenter.GalleryPresenter;
import com.gallery.phoenix.gallerymosby.view.GalleryLCEView;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceFragment;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GalleryBaseFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class GalleryBaseFragment extends MvpLceFragment<SwipeRefreshLayout, ArrayList<String>, GalleryLCEView, GalleryPresenter> implements GalleryLCEView{

    private static final String TAG = "GalleryBaseFragment";

    public static final String GALLERY_CONTENT = "GALLERY_CONTENT";

    @Bind(R.id.recyclerView)
    RecyclerView mRecyclerView;
    GalleryBaseAdapter mAdapter;

    private ArrayList<String> mData = new ArrayList<String>();

    private OnFragmentInteractionListener mFragmentListener;

    //TODO: gallery fragment must has initial argument
    //for display certain album
    public GalleryBaseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gallery_base, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mAdapter = new GalleryBaseAdapter(getContext(), mData);

        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(mAdapter);
        loadData(false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mFragmentListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mFragmentListener = null;
    }

    @Override
    public void onPause() {
//        mFragmentListener.onFragmentInteraction(GALLERY_CONTENT);
        super.onPause();
    }

    @Override
    protected String getErrorMessage(Throwable e, boolean pullToRefresh) {
        return null;
    }

    @Override
    public void showLoading(boolean pullToRefresh) {
        super.showLoading(pullToRefresh);
    }

    @Override
    public void showContent() {
        super.showContent();
    }

    @Override
    public GalleryPresenter createPresenter() {
        return new GalleryPresenter();
    }

    @Override
    public void setData(ArrayList<String> data) {
        mData = data;
        mAdapter.setmData(mData);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void loadData(boolean pullToRefresh) {
        getPresenter().initiatePresenter();
        getPresenter().loadGalleryPhoto();
    }

    @Override
    public void updateGalleryPhoto() {

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String args);
    }

    public void setmFragmentListener(OnFragmentInteractionListener mFragmentListener) {
        this.mFragmentListener = mFragmentListener;
    }
}

package com.gallery.phoenix;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gallery.phoenix.gallerymosby.R;
import com.gallery.phoenix.gallerymosby.presenter.AlbumPresenter;
import com.gallery.phoenix.gallerymosby.view.AlbumLCEView;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceFragment;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AlbumBaseFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AlbumBaseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AlbumBaseFragment extends MvpLceFragment<SwipeRefreshLayout,ArrayList<String>, AlbumLCEView, AlbumPresenter> implements AlbumLCEView{

    @Bind(R.id.recyclerView)
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;

    private AlbumBaseAdapter mAdapter;
    private ArrayList<String> mData;

    private OnFragmentInteractionListener mListener;

    public AlbumBaseFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AlbumBaseFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AlbumBaseFragment newInstance(String param1, String param2) {
        AlbumBaseFragment fragment = new AlbumBaseFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_album_base, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());

        mAdapter = new AlbumBaseAdapter(getContext(), mData);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(mAdapter);
        loadData(false);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void updateAlbumProperty() {

    }

    @Override
    protected String getErrorMessage(Throwable e, boolean pullToRefresh) {
        return new String("this is a test");
    }

    @Override
    public AlbumPresenter createPresenter() {
        return new AlbumPresenter();
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
    public void showError(Throwable e, boolean pullToRefresh) {
    }

    @Override
    public void setData(ArrayList<String> data) {
        mData = data;
        mAdapter.setmDataSet(mData);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void loadData(boolean pullToRefresh) {
        getPresenter().initiatePresenter();
        getPresenter().loadAlbumCover();
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
        void onFragmentInteraction(Uri uri);
    }
}

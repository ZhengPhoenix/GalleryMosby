package com.gallery.phoenix.gallerymosby.test;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.gallery.phoenix.gallerymosby.R;
import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.hannesdorfmann.mosby.mvp.viewstate.MvpViewStateActivity;
import com.hannesdorfmann.mosby.mvp.viewstate.ViewState;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

public class MainActivity extends MvpActivity<MvpTestView, MvpTestPresenter>
        implements MvpTestView{


    @Bind(R.id.changeA)
    Button changeA;
    @Bind(R.id.changeB)
    Button changeB;

    @Bind(R.id.showA)
    TextView showA;
    @Bind(R.id.showB)
    TextView showB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @NonNull
    @Override
    public MvpTestPresenter createPresenter() {
        return new MvpTestPresenter();
    }


    @Override
    public void changeA() {
        showB.setVisibility(View.GONE);
        showA.setVisibility(View.VISIBLE);
    }

    @Override
    public void changeB() {
        showA.setVisibility(View.GONE);
        showB.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.changeA) public void onChangeAClick() {
        getPresenter().doA();
    }

    @OnClick(R.id.changeB) public void onChangeBClick() {
        getPresenter().doB();
    }
}

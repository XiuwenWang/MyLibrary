package com.mingxiu.apptest.ui.me;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.FrameLayout;

import com.mingxiu.apptest.App;
import com.mingxiu.apptest.R;
import com.mingxiu.apptest.fragment.Fragment_1;
import com.mingxiu.apptest.fragment.Fragment_2;
import com.mingxiu.apptest.fragment.Fragment_3;
import com.mingxiu.apptest.fragment.Fragment_4;
import com.mingxiu.library.base.BaseActivity;
import com.mingxiu.library.tablayout.CommonTabLayout;
import com.mingxiu.library.tablayout.listener.CustomTabEntity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity implements MainContract.View {


    @BindView(R.id.fl_change)
    FrameLayout mFlChange;
    @BindView(R.id.tl_3)
    CommonTabLayout mTl3;
    public MainContract.Presenter mMainPresenter;


    private ArrayList<Fragment> mFragments2 = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    public void initView() {
        mMainPresenter = new MainPresenter(this);
    }


    @Override
    public void showTitle(String title) {
        App.getInstance().showToast(title);
    }

    @Override
    public void AddFragment(ArrayList<CustomTabEntity> data) {
            mFragments2.add(Fragment_1.newInstance(data.get(0).getTabTitle().toString(),""));
            mFragments2.add(Fragment_2.newInstance(data.get(1).getTabTitle().toString(),""));
            mFragments2.add(Fragment_3.newInstance(data.get(2).getTabTitle().toString(),""));
            mFragments2.add(Fragment_4.newInstance(data.get(3).getTabTitle().toString(),""));
    }


    @Override
    public void initCommonTabLayout(ArrayList<CustomTabEntity> data) {
        mTl3.setTabData(data,this, R.id.fl_change, mFragments2);

        mTl3.setCurrentTab(1);

        mTl3.showDot(1);//红点

//        //两位数
//        mTl3.showMsg(0, 55);
//        mTl3.setMsgMargin(0, -5, 5);

        //三位数
        mTl3.showMsg(1, 109);
        mTl3.setMsgMargin(1, -5, 5);

        //三位数
        mTl3.showMsg(2, 109);
        mTl3.setMsgMargin(2, -5, 5);

    }
}

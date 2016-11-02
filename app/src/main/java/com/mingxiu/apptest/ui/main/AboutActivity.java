package com.mingxiu.apptest.ui.main;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.mingxiu.apptest.R;
import com.mingxiu.apptest.base.BaseActivity;
import com.mingxiu.apptest.view.layout.TRecyclerView;
import com.mingxiu.apptest.view.viewholder.UserItemVH;
import com.mingxiu.apptest.widget.FireView;

import butterknife.BindView;

/**
 * 简单页面无需mvp,该咋写还是咋写
 */
public class AboutActivity extends BaseActivity {


    @BindView(R.id.image)
    FireView mImage;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout mCollapsingToolbar;
    @BindView(R.id.appbar)
    AppBarLayout mAppbar;
    @BindView(R.id.lv_user)
    TRecyclerView mLvUser;
    @BindView(R.id.fab)
    FloatingActionButton mFab;
    @BindView(R.id.main_content)
    CoordinatorLayout mMainContent;

    @Override
    public int getLayoutId() {
        return R.layout.activity_about;
    }

    @Override
    public void initView() {
        setSupportActionBar(mToolbar);
        final ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setTitle("");
        mFab.setOnClickListener(v -> {
        });
        mLvUser.setView(UserItemVH.class).fetch();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) onBackPressed();
        return super.onOptionsItemSelected(item);
    }



   /* @Override
    public void initPresenter() {

    }*/
}
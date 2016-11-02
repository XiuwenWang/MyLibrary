package com.mingxiu.apptest.ui.home;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mingxiu.apptest.Contact;
import com.mingxiu.apptest.R;
import com.mingxiu.apptest.base.BaseActivity;
import com.mingxiu.apptest.base.BaseListFragment;
import com.mingxiu.apptest.base.util.ImageUtil;
import com.mingxiu.apptest.base.util.SpUtil;
import com.mingxiu.apptest.base.util.ToastUtil;
import com.mingxiu.apptest.base.util.helper.FragmentAdapter;
import com.mingxiu.apptest.data.entity._User;
import com.mingxiu.apptest.ui.article.ArticleActivity;
import com.mingxiu.apptest.ui.login.LoginActivity;
import com.mingxiu.apptest.ui.main.AboutActivity;
import com.mingxiu.apptest.ui.main.SettingsActivity;
import com.mingxiu.apptest.ui.user.UserActivity;
import com.mingxiu.apptest.view.viewholder.ArticleItemVH;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import rx.Observable;


public class HomeActivity extends BaseActivity<HomePresenter, HomeModel> implements HomeContract.View {

    ImageView mImFace;
    TextView mTvName;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tabs)
    TabLayout mTabs;
    @BindView(R.id.appbar)
    AppBarLayout mAppbar;
    @BindView(R.id.viewpager)
    ViewPager mViewpager;
    @BindView(R.id.fab)
    FloatingActionButton mFab;
    @BindView(R.id.main_content)
    CoordinatorLayout mMainContent;
    @BindView(R.id.nv_main_navigation)
    NavigationView mNvMainNavigation;
    @BindView(R.id.dl_main_drawer)
    DrawerLayout mDlMainDrawer;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_overaction, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (mDlMainDrawer.isDrawerOpen(Gravity.LEFT)) mDlMainDrawer.closeDrawers();
        else super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings)
            startActivity(new Intent(mContext, AboutActivity.class));
        else if (item.getItemId() == android.R.id.home)
            mDlMainDrawer.openDrawer(GravityCompat.START);
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void initView() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDlMainDrawer, R.string.drawer_open, R.string.drawer_close);
        mDrawerToggle.syncState();
        mDlMainDrawer.setDrawerListener(mDrawerToggle);

        mFab.setOnClickListener(v -> Snackbar.make(v, "Snackbar comes out", Snackbar.LENGTH_LONG).setAction("action", vi -> ToastUtil.show("ok")).show());
        View headerView = mNvMainNavigation.inflateHeaderView(R.layout.nav_header_main);
        mImFace = (ImageView) headerView.findViewById(R.id.im_face);
        mTvName = (TextView) headerView.findViewById(R.id.tv_name);

        mNvMainNavigation.setNavigationItemSelectedListener(item -> {
            item.setChecked(true);
            mDlMainDrawer.closeDrawers();
            switch (item.getItemId()) {
                case R.id.nav_manage:
                    startActivity(new Intent(mContext, SettingsActivity.class));
                    break;
                case R.id.nav_share:
                    startActivity(new Intent(mContext, LoginActivity.class));
                    break;
                case R.id.nav_send:
                    SpUtil.setNight(mContext, !SpUtil.isNight());
                    break;
            }
            return true;
        });
    }

    @Override
    public void showTabList(String[] mTabs) {
        List<Fragment> fragments = new ArrayList<>();
        Observable.from(mTabs).subscribe(tab -> fragments.add(BaseListFragment.newInstance(ArticleItemVH.class, tab)));
        mViewpager.setAdapter(new FragmentAdapter(getSupportFragmentManager(), fragments, Arrays.asList(mTabs)));
        this.mTabs.setupWithViewPager(mViewpager);
        this.mTabs.setTabsFromPagerAdapter(mViewpager.getAdapter());
    }

    @Override
    public void initUserInfo(_User user) {
        ImageUtil.loadRoundImg(mImFace, user.face);
        mTvName.setText(user.username);
        mImFace.setOnClickListener(v ->
                ActivityCompat.startActivity((Activity) mContext, new Intent(mContext, UserActivity.class).putExtra(Contact.HEAD_DATA, user)
                        , ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) mContext, mImFace, ArticleActivity.TRANSLATE_VIEW).toBundle())
        );
    }
}

package com.mingxiu.apptest.ui.user;

import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.mingxiu.apptest.Contact;
import com.mingxiu.apptest.R;
import com.mingxiu.apptest.base.BaseActivity;
import com.mingxiu.apptest.base.util.ImageUtil;
import com.mingxiu.apptest.base.util.SpUtil;
import com.mingxiu.apptest.base.util.ToastUtil;
import com.mingxiu.apptest.data.Pointer;
import com.mingxiu.apptest.data.entity._User;
import com.mingxiu.apptest.view.layout.TRecyclerView;
import com.mingxiu.apptest.view.viewholder.UserCommentVH;

import java.io.File;

import butterknife.BindView;

import static com.mingxiu.apptest.R.id.fab;
import static com.mingxiu.apptest.R.id.im_header;


public class UserActivity extends BaseActivity<UserPresenter, UserModel> implements UserContract.View {
    public static final String TRANSLATE_VIEW = "share_img";
    private static final int IMAGE_REQUEST_CODE = 100;
    @BindView(im_header)
    ImageView mImHeader;
    @BindView(R.id.image)
    ImageView mImage;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout mCollapsingToolbar;
    @BindView(R.id.appbar)
    AppBarLayout mAppbar;
    @BindView(R.id.lv_comment)
    TRecyclerView mLvComment;
    @BindView(fab)
    FloatingActionButton mFab;
    @BindView(R.id.main_content)
    CoordinatorLayout mMainContent;


    @Override
    public int getLayoutId() {
        return R.layout.activity_user;
    }

    @Override
    public void initView() {
        _User user = (_User) getIntent().getSerializableExtra(Contact.HEAD_DATA);
        initUser(user);
        setSupportActionBar(mToolbar);
        final ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ViewCompat.setTransitionName(mImage, TRANSLATE_VIEW);
        String creater = new Gson().toJson(new Pointer(_User.class.getSimpleName(), user.objectId));
        mLvComment.setView(UserCommentVH.class)
                .setParam("include", "article")
                .setParam("creater", creater)
                .setIsRefreshable(false)
                .fetch();

        if (SpUtil.getUser() != null && TextUtils.equals(user.objectId, SpUtil.getUser().objectId)) {
            mFab.setImageResource(R.drawable.ic_menu_camera);
            mFab.setOnClickListener(v -> startActivityForResult(new Intent().setType("image/*").setAction(Intent.ACTION_GET_CONTENT),
                    IMAGE_REQUEST_CODE));
        } else mFab.setOnClickListener(v -> ToastUtil.show("ok"));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent mdata) {
        if (mdata != null && requestCode == IMAGE_REQUEST_CODE) {
            try {
                File file = new File(ImageUtil.getUrlByIntent(mContext, mdata));
                if (file.exists())
                    mPresenter.upLoadFace(file);
                else showMsg("照片无法打开");
            } catch (Exception e) {
                e.printStackTrace();
                showMsg("照片无法打开");
            }
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showMsg(String msg) {
        Snackbar.make(mFab, msg, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void initUser(_User user) {
        ImageUtil.loadRoundAndBgImg(mImage, user.face, mImHeader);
        setTitle(user.username);
    }

}

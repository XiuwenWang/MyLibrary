package com.mingxiu.apptest.ui.article;

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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.mingxiu.apptest.Contact;
import com.mingxiu.apptest.R;
import com.mingxiu.apptest.base.BaseActivity;
import com.mingxiu.apptest.base.util.ImageUtil;
import com.mingxiu.apptest.base.util.SpUtil;
import com.mingxiu.apptest.base.util.ViewUtil;
import com.mingxiu.apptest.data.Pointer;
import com.mingxiu.apptest.data.entity.Image;
import com.mingxiu.apptest.ui.login.LoginActivity;
import com.mingxiu.apptest.view.layout.TRecyclerView;
import com.mingxiu.apptest.view.viewholder.ArticleHeaderVH;
import com.mingxiu.apptest.view.viewholder.CommentItemVH;

import butterknife.BindView;

import static com.mingxiu.apptest.R.id.bt_comment;
import static com.mingxiu.apptest.R.id.et_comment;
import static com.mingxiu.apptest.R.id.fab;
import static com.mingxiu.apptest.R.id.lv_comment;

public class ArticleActivity extends BaseActivity<ArticlePresenter, ArticleModel> implements ArticleContract.View {
    public static final String TRANSLATE_VIEW = "share_img";
    @BindView(R.id.image)
    ImageView mImage;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout mCollapsingToolbar;
    @BindView(R.id.appbar)
    AppBarLayout mAppbar;
    @BindView(lv_comment)
    TRecyclerView mLvComment;
    @BindView(fab)
    FloatingActionButton mFab;
    @BindView(R.id.main_content)
    CoordinatorLayout mMainContent;
    @BindView(et_comment)
    EditText mEtComment;
    @BindView(bt_comment)
    Button mBtComment;


    @Override
    public int getLayoutId() {
        return R.layout.activity_detail;
    }

    @Override
    public void initView() {
        Image mSubject = (Image) getIntent().getSerializableExtra(Contact.HEAD_DATA);
        setSupportActionBar(mToolbar);
        final ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ImageUtil.loadImg(mImage, mSubject.image);
        setTitle(mSubject.title);
        ViewCompat.setTransitionName(mImage, TRANSLATE_VIEW);
        mBtComment.setOnClickListener(v -> {
            if (TextUtils.isEmpty(mEtComment.getText().toString()))
                Snackbar.make(mFab, "评论不能为空!", Snackbar.LENGTH_LONG).show();
            else
                mPresenter.createComment(mEtComment.getText().toString(), mSubject, SpUtil.getUser());
        });
        String article = new Gson().toJson(new Pointer(Image.class.getSimpleName(), mSubject.objectId));
        mLvComment.setHeadView(ArticleHeaderVH.class)
                .setView(CommentItemVH.class)
                .setParam("include", "creater")
                .setParam("article", article)
                .setIsRefreshable(false)
                .fetch();
    }

    public void checkin(View view) {
        Snackbar.make(view, "没啥卵用", Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_overaction, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void commentSuc() {
        mLvComment.reFetch();
        Snackbar.make(mFab, "评论成功!", Snackbar.LENGTH_LONG).show();
        ViewUtil.hideKeyboard(this);
        mEtComment.setText("");
    }

    @Override
    public void commentFail() {
        Snackbar.make(mFab, "评论失败!", Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showLoginAction() {
        Snackbar.make(mFab, "请先登录!", Snackbar.LENGTH_LONG)
                .setAction("登录", view -> startActivity(new Intent(mContext, LoginActivity.class))).show();
    }


}

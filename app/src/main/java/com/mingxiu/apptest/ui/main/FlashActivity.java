package com.mingxiu.apptest.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.mingxiu.apptest.R;
import com.mingxiu.apptest.base.util.AnimationUtil;
import com.mingxiu.apptest.base.util.StatusBarUtil;
import com.mingxiu.apptest.ui.home.HomeActivity;
import com.mingxiu.apptest.widget.FireView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by baixiaokang on 16/4/28.
 */
public class FlashActivity extends AppCompatActivity {


    @BindView(R.id.splash_view)
    ImageView mSplashView;
    @BindView(R.id.fl_main)
    FrameLayout mFlMain;
    @BindView(R.id.view)
    View mView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);
        ButterKnife.bind(this);
        initView();
    }


    public void initView() {

        StatusBarUtil.setTranslucentBackground(this);
        FireView mFireView = new FireView(this);
        mFlMain.addView(mFireView,
                new FrameLayout.LayoutParams(
                        FrameLayout.LayoutParams.MATCH_PARENT,
                        FrameLayout.LayoutParams.MATCH_PARENT));

        AlphaAnimation anim = new AlphaAnimation(0.8f, 0.1f);
        anim.setDuration(5000);
        mView.startAnimation(anim);
        AnimationUtil.setAnimationListener(anim, () -> {
            startActivity(new Intent(getBaseContext(), HomeActivity.class));
            finish();
        });


    }


   /* @Override
    public void initPresenter() {
    }*/
}

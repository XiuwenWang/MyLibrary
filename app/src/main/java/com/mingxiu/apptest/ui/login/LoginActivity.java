package com.mingxiu.apptest.ui.login;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.widget.TextView;

import com.mingxiu.apptest.R;
import com.mingxiu.apptest.base.BaseActivity;
import com.mingxiu.apptest.ui.home.HomeActivity;

import butterknife.BindView;

import static com.mingxiu.apptest.R.id.fab;
import static com.mingxiu.apptest.R.id.tv_sign;
import static com.mingxiu.apptest.R.id.tv_title;


/**
 * Created by Administrator on 2016/1/14.
 */
public class LoginActivity extends BaseActivity<LoginPresenter, LoginModel> implements LoginContract.View {

    boolean isLogin = true;
    @BindView(tv_title)
    TextView mTvTitle;
    @BindView(R.id.tl_name)
    TextInputLayout mTlName;
    @BindView(R.id.tl_pass)
    TextInputLayout mTlPass;
    @BindView(tv_sign)
    TextView mTvSign;
    @BindView(fab)
    FloatingActionButton mFab;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        mFab.setOnClickListener(v -> {
            String name = mTlName.getEditText().getText().toString();
            String pass = mTlPass.getEditText().getText().toString();
            String msg = TextUtils.isEmpty(name) ? "用户名不能为空!" : TextUtils.isEmpty(pass) ? "密码不能为空!" : "";
            if (!TextUtils.isEmpty(msg)) showMsg(msg);
            else if (isLogin) mPresenter.login(name, pass);
            else mPresenter.sign(name, pass);
        });
        mTvSign.setOnClickListener(v -> swich());
    }

    private void swich() {
        if (isLogin) {
            isLogin = false;
            mTvTitle.setText("注册");
            mTvSign.setText("去登录");
        } else {
            isLogin = true;
            mTvTitle.setText("登录");
            mTvSign.setText("去注册");
        }
    }


    @Override
    public void loginSuccess() {
        startActivity(new Intent(LoginActivity.this, HomeActivity.class));
    }

    @Override
    public void signSuccess() {
        swich();
    }

    @Override
    public void showMsg(String msg) {
        Snackbar.make(mFab, msg, Snackbar.LENGTH_LONG).show();
    }

}
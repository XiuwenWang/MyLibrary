package com.mingxiu.library.base;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mingxiu.library.utils.AppManager;

/**
 * ----------BigGod be here!----------/
 * ***┏┓******┏┓*********
 * *┏━┛┻━━━━━━┛┻━━┓*******
 * *┃             ┃*******
 * *┃     ━━━     ┃*******
 * *┃             ┃*******
 * *┃  ━┳┛   ┗┳━  ┃*******
 * *┃             ┃*******
 * *┃     ━┻━     ┃*******
 * *┃             ┃*******
 * *┗━━━┓     ┏━━━┛*******
 * *****┃     ┃神兽保佑*****
 * *****┃     ┃代码无BUG！***
 * *****┃     ┗━━━━━━━━┓*****
 * *****┃              ┣┓****
 * *****┃              ┏┛****
 * *****┗━┓┓┏━━━━┳┓┏━━━┛*****
 * *******┃┫┫****┃┫┫********
 * *******┗┻┛****┗┻┛*********
 * ━━━━━━神兽出没━━━━━━
 * 版权所有：平行学堂
 * 作者：Created by a.wen.
 * 创建时间：2016/10/17
 * Email：13872829574@qq.com
 * 修订历史：1.0
 * 描述：
 */
public class BaseActivity extends AppCompatActivity {

    private static BaseActivity baseAct;

    public static BaseActivity getInstance() {
        return baseAct;
    }

    //获取Intent
    protected void handleIntent(Intent intent) {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        baseAct = this;
        super.onCreate(savedInstanceState);
        if (null != getIntent()) {
            handleIntent(getIntent());
        }
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//设置竖屏
        AppManager.getAppManager().addActivity(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public final void init() {
        initView();
        initData();
        setUpView();
    }

    /**
     * 重启activity
     */
    public void reStart() {
        Intent intent = getIntent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        finish();
        startActivity(intent);
    }


    /**
     * 设置监听
     */
    public void setUpView() {
        setTitleBar();
        setAbsListView();
    }

    protected void setTitleBar() {

    }

    protected  void setAbsListView(){

    }


    /**
     * 初始化控件
     */
    public void initView() {
    }

    /**
     * 初始化数据源
     */
    public void initData() {
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //设置返回数据
        Activity activity = AppManager.getAppManager().currentActivity();
        activity.setResult(RESULT_OK);
        AppManager.getAppManager().finishActivity();
    }


//
//    /**
//     * 网络错误弹出框
//     */
//    public void showErrNet(Context context, String titleName) {
//        LogUtils.d("网络错误弹出框 = " + context.getClass().getSimpleName() + "  titleName = " + titleName);
//        Intent intent = new Intent(BaseApp.getInstance(), DefaultActivity.class);
//        intent.putExtra(Constant.TITLE, titleName);
//        context.startActivity(intent);
//    }
}
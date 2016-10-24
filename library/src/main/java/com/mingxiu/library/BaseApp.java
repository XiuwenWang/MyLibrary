package com.mingxiu.library;


import android.support.multidex.MultiDexApplication;
import android.widget.Toast;

import com.apkfuns.logutils.LogUtils;
import com.mingxiu.library.utils.io.FileUtils;

import cn.finalteam.okhttpfinal.OkHttpFinal;
import cn.finalteam.okhttpfinal.OkHttpFinalConfiguration;
import okhttp3.Cache;

/**
 * 项目名称：平行学堂
 * 类描述：
 * 创建人：a.wen
 * 创建时间：2016/6/2
 * 修改人：
 * 修改时间：2016/6/2
 * 修改备注：application
 */
public class BaseApp extends MultiDexApplication {
    public static BaseApp app;

    private boolean isDebug = true;//配置全局Debug是否打开

    public static BaseApp getInstance() {
        return app;
    }

    protected void setDebug(boolean debug) {
        isDebug = debug;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        LogUtils.d("BaseApp =====>onCreate");
    }


    /**
     * 配置网络请求
     */
    protected void configOkHttpFinal(boolean isLog) {
        OkHttpFinalConfiguration.Builder builder = new OkHttpFinalConfiguration.Builder();
        builder.setCache(new Cache(FileUtils.getUserDirectory(), 1 * 1000));
        builder.setDebug(isLog);
        builder.setTimeout(1000 * 5);
        OkHttpFinal.getInstance().init(builder.build());

    }


    /**
     * 吐司一哈子
     *
     * @param msg
     */
    public void showToast(String msg) {
        Toast.makeText(BaseApp.this, msg, Toast.LENGTH_SHORT).show();
    }


    /**
     * 程序终止的时候执行
     */
    @Override
    public void onTerminate() {
        LogUtils.d("BaseApp ==> onTerminate");
        super.onTerminate();
    }
}

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

    //    {
//
//        //微信 appid appsecret
//        PlatformConfig.setWeixin("wx71263d2be20656a6", "cce496157ea86b0f0adc821def437e42");
//        //新浪微博 appkey appsecret
//        PlatformConfig.setSinaWeibo("4121936918", "36e282e15ef09a52354ad9a98a64589f");
//        //新浪微博回调
//        Config.REDIRECT_URL = "http://www.paralworld.com";
//        // QQ和Qzone appid appkey 借用平行世界的key和serket
//        PlatformConfig.setQQZone("101261101", "ba72876b33f7df70e2e12ea80d3a4240");
//
//    }
//
//    /**
//     * 极光推送
//     */
//    private void initJPush() {
//        LogUtils.d("极光推送初始化");
//        JPushInterface.setDebugMode(isDebug);
//        JPushInterface.init(this);
//    }


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

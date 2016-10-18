package com.mingxiu.library.http.callback;


import cn.finalteam.okhttpfinal.BaseHttpRequestCallback;

/**
 * 版权所有：
 * 作者：Created by a.wen.
 * 创建时间：2016/7/30
 * Email：13872829574@qq.com
 * 修订历史：1.0
 * 描述：继承okHttpFinal 的 BaseHttpRequestCallback
 * 这样可以在网络请求时，统一一些操作，为以后扩展
 */
public class BaseHttpCallback<T> extends BaseHttpRequestCallback<T> {

    public BaseHttpCallback() {
        super();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onFinish() {
        super.onFinish();
    }

    @Override
    public void onFailure(int errorCode, String msg) {
        super.onFailure(errorCode, msg);
    }

    @Override
    protected void onSuccess(T t) {
        super.onSuccess(t);
    }

    /**
     * 上传文件进度
     *
     * @param progress
     * @param networkSpeed 网速
     * @param done
     */
    @Override
    public void onProgress(int progress, long networkSpeed, boolean done) {
        super.onProgress(progress, networkSpeed, done);
    }
}

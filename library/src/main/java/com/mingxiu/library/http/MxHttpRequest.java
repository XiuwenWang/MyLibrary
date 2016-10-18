package com.mingxiu.library.http;


import com.apkfuns.logutils.LogUtils;
import com.mingxiu.library.BuildConfig;
import com.mingxiu.library.http.callback.BaseHttpCallback;
import com.mingxiu.library.http.callback.BaseHttpRequestCallback;
import com.mingxiu.library.http.callback.FileDownloadCallback;
import com.mingxiu.library.http.utils.ParseUtils;

import java.io.File;

import cn.finalteam.okhttpfinal.HttpRequest;
import cn.finalteam.okhttpfinal.RequestParams;
import okhttp3.Headers;

/**
 * 版权所有：
 * 作者：Created by a.wen.
 * 创建时间：2016/7/30
 * Email：13872829574@qq.com
 * 修订历史：1.0
 * 描述：封装常用的请求方式
 */
public final class MxHttpRequest {
    /**
     * 是否输出本类日志
     *
     * @return
     */
    private static boolean isOutputLog() {
        return BuildConfig.DEBUG;
    }

    /**
     * Get请求
     *
     * @param url      String
     * @param params   Params
     * @param callback BaseHttpRequestCallback
     */
    public static void get(String url, Params params, final BaseHttpRequestCallback callback) {

        HttpRequest.get(url, params.getParams(), new BaseHttpCallback<String>() {
            @Override
            public void onStart() {
                super.onStart();
                if (callback != null) {
                    callback.onStart();
                }
            }

            @Override
            protected void onSuccess(String result) {
                super.onSuccess(result);
                if (callback != null) {
                    ParseUtils.parseJson(result, callback);
                }
            }

            @Override
            public void onFinish() {
                super.onFinish();
                if (callback != null) {
                    callback.onFinish();
                }
            }

            @Override
            public void onFailure(int errorCode, String msg) {
                super.onFailure(errorCode, msg);
                if (callback != null) {
                    callback.onFailure(errorCode, msg);
                }
            }
        });
    }


    public static void get(String url) {
        get(url, null, null);
    }

    public static void get(String url, Params params) {
        get(url, params, null);
    }

    public static void get(String url, BaseHttpRequestCallback callback) {
        get(url, null, callback);
    }

    /**
     * Get请求
     *
     * @param url
     * @param params
     * @param timeout
     * @param callback
     */
    public static void get(String url, RequestParams params, long timeout, cn.finalteam.okhttpfinal.BaseHttpRequestCallback callback) {
        HttpRequest.get(url, params, timeout, callback);
    }

    /**
     * Post请求 徐浩的接口
     *
     * @param url      String 基础
     * @param params   Params 请求参数
     * @param callback BaseHttpRequestCallback 回调
     */
    public static void post(final String url, final Params params, final BaseHttpRequestCallback callback) {

        HttpRequest.post(url, params.getParams(), new BaseHttpCallback<String>() {
            @Override
            public void onStart() {
                super.onStart();
                if (callback != null) {
                    callback.onStart();
                }
            }

            @Override
            protected void onSuccess(Headers headers, String result) {
                super.onSuccess(headers, result);
                if (isOutputLog())
                    LogUtils.json(result);
                if (callback != null) {
                    ParseUtils.parseJson(result, callback);
                }
            }

            @Override
            protected void onSuccess(String result) {
                super.onSuccess(result);

            }

            @Override
            public void onFinish() {
                super.onFinish();
                if (callback != null) {
                    callback.onFinish();
                }
            }

            @Override
            public void onFailure(int errorCode, String msg) {
                super.onFailure(errorCode, msg);
                if (isOutputLog())
                    LogUtils.d("请求失败 url = " + url + params.getParams().toString());
                if (callback != null) {
                    callback.onFailure(errorCode, msg);
                }
            }
        });
    }

    public static void post(String url) {
        post(url, new Params(), null);
    }

    public static void post(String url, Params params) {
        post(url, params, null);
    }

    public static void post(String url, BaseHttpRequestCallback callback) {
        post(url, null, callback);
    }


    /**
     * Post请求
     *
     * @param url      String 基础
     * @param params   Params 请求参数
     * @param timeout  long 超时
     * @param callback BaseHttpRequestCallback 回调
     */
    public static void post(String url, RequestParams params, long timeout, cn.finalteam.okhttpfinal.BaseHttpRequestCallback callback) {
        HttpRequest.post(url, params, timeout, callback);
    }


    /**
     * 取消请求
     *
     * @param url
     */
    public static void cancel(String url) {
        cn.finalteam.okhttpfinal.HttpRequest.cancel(url);
    }

    public static void download(String url, File target) {
        download(url, target, null);
    }

    /**
     * 下载文件
     *
     * @param url      String
     * @param target   保存的文件
     * @param callback FileDownloadCallback
     */
    public static void download(String url, File target, final FileDownloadCallback callback) {

       HttpRequest.download(url, target, new cn.finalteam.okhttpfinal.FileDownloadCallback() {
            @Override
            public void onStart() {
                if (callback != null) {
                    callback.onStart();
                }
            }

            @Override
            public void onProgress(int progress, long networkSpeed) {
                if (callback != null) {
                    callback.onProgress(progress, networkSpeed);
                }
            }

            @Override
            public void onDone() {
                if (callback != null) {
                    callback.onDone();
                }
            }

            @Override
            public void onFailure() {
                if (callback != null) {
                    callback.onFailure();
                }
            }
        });

    }

}

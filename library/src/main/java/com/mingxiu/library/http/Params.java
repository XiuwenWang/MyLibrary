package com.mingxiu.library.http;

import java.io.File;

import cn.finalteam.okhttpfinal.RequestParams;

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
 * 版权所有：
 * 作者：Created by a.wen.
 * 创建时间：2016/8/31
 * Email：13872829574@qq.com
 * 修订历史：1.0
 * 描述：请求参数 操作类
 */
public class Params {


    private RequestParams mParams;

    public Params() {
        mParams = new RequestParams();
    }

    public static Params getInstance() {
        return new Params();
    }

    public Params add(String key, String value) {
        mParams.addFormDataPart(key, value);
        return this;
    }

    public Params add(String key, int value) {
        mParams.addFormDataPart(key, value);
        return this;
    }

    public Params add(String key, File value) {
        mParams.addFormDataPart(key, value);
        return this;
    }

    public Params add(String key, boolean value) {
        mParams.addFormDataPart(key, value);
        return this;
    }

    public Params add(String key, float value) {
        mParams.addFormDataPart(key, value);
        return this;
    }

    public Params add(String key, double value) {
        mParams.addFormDataPart(key, value);
        return this;
    }

    public RequestParams getParams() {
        return mParams;
    }

    public void setParams(RequestParams params) {
        mParams = params;
    }
//    public void getParamsToString(RequestParams params){
//        List<Part> formParams = params.getFormParams();
//        params.toString()
//    }
}

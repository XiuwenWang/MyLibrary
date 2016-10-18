package com.mingxiu.library.http.callback;


import com.mingxiu.library.http.utils.ClassTypeReflect;

import java.lang.reflect.Type;


/**
 * 版权所有：
 * 作者：Created by a.wen.
 * 创建时间：2016/8/29
 * Email：13872829574@qq.com
 * 修订历史：1.0
 * 描述：自己封装的网络请求的回调抽象类，有两个必须实现的方法有
 */
public abstract class BaseHttpRequestCallback<T> {

    public Type type;

    public BaseHttpRequestCallback() {
        type = ClassTypeReflect.getModelClazz(getClass());
    }

    public abstract void onSuccess(T t);
    public abstract void onFailure(int errorCode, String msg);

    public void onStart(){

    }

    public  void onFinish(){

    }
}

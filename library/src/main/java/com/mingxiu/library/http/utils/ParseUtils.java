package com.mingxiu.library.http.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.apkfuns.logutils.LogUtils;
import com.mingxiu.library.bean.BaseBean;
import com.mingxiu.library.http.callback.BaseHttpRequestCallback;

/**
 * 版权所有：
 * 作者：Created by a.wen.
 * 创建时间：2016/8/29
 * Email：13872829574@qq.com
 * 修订历史：1.0
 * 描述：利用fastJson解析Json 字符串
 */
public class ParseUtils {

    /**
     * @param baseBean BaseBean
     * @return String
     */
    public static String bean2String(BaseBean baseBean) {
        return JSON.toJSONString(baseBean);
    }

    /**
     * 解析
     *
     * @param result   String
     * @param callback BaseHttpRequestCallback
     */
    public static void parseJson(String result, BaseHttpRequestCallback callback) {

        if (callback.type == String.class) {
            callback.onSuccess(result);
            return;
        } else if (callback.type == JSONObject.class) {
            JSONObject jsonObject = null;
            try {
                jsonObject = JSON.parseObject(result);
            } catch (Exception e) {
                LogUtils.e(e);
            }
            if (jsonObject != null) {
                callback.onSuccess(jsonObject);
                return;
            }
        } else if (callback.type == JSONArray.class) {
            JSONArray jsonArray = null;
            try {
                jsonArray = JSON.parseArray(result);
            } catch (Exception e) {
                LogUtils.e(e);
            }

            if (jsonArray != null) {
                callback.onSuccess(jsonArray);
                return;
            }
        } else {
            Object obj = null;
            try {
                obj = JSON.parseObject(result, callback.type);
            } catch (Exception e) {
                LogUtils.e(e);
            }
            if (obj != null) {
                callback.onSuccess(obj);
                return;
            }
        }

    }
}

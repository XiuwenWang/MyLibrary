package com.mingxiu.library.http.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 版权所有：
 * 作者：Created by a.wen.
 * 创建时间：2016/8/29
 * Email：13872829574@qq.com
 * 修订历史：1.0
 * 描述：反射获取 获得泛型类型
 */
public class ClassTypeReflect {

    public static Type getModelClazz(Class<?> subclass) {
        return getGenericType(0, subclass);
    }

    /**
     * 获得泛型类型
     *
     * @param index
     * @param subclass
     * @return
     */
    private static Type getGenericType(int index, Class<?> subclass) {
        Type superclass = subclass.getGenericSuperclass();
        if (!(superclass instanceof ParameterizedType)) {
            return Object.class;
        }
        Type[] params = ((ParameterizedType) superclass).getActualTypeArguments();
        if (index >= params.length || index < 0) {
            throw new RuntimeException("Index outof bounds");
        }

        if (!(params[index] instanceof Class)) {
            return Object.class;
        }
        return params[index];
    }
}

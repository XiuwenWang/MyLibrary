package com.mingxiu.library.base.baseAdapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * 版权所有：
 * 作者：Created by a.wen.
 * 创建时间：2016/7/5
 * Email：13872829574@qq.com
 * 修订历史：1.0
 * 描述：简单封装的WenAdapter
 */
public abstract class MxBaseAdapter<T> extends BaseAdapter {
    protected List<T> data;
    protected Context context;

    public MxBaseAdapter(List<T> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data != null ? data.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return data != null ? data.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public abstract View getView(int position, View convertView, ViewGroup parent);
}

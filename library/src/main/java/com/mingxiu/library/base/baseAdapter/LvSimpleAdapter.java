package com.mingxiu.library.base.baseAdapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mingxiu.library.utils.ImageLoader;

import java.util.HashMap;
import java.util.List;

/**
 * 版权所有：
 * 作者：Created by a.wen.
 * 创建时间：2016/6/30
 * Email：13872829574@qq.com
 * 修订历史：1.0
 * 描述：封装的一个简单易用的ApBaseAdapter
 */
public abstract class LvSimpleAdapter<T> extends BaseAdapter {
    protected List<T> data;
    protected Context context;

    public LvSimpleAdapter(List<T> data, Context context) {
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

    //入口
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(getLayout(), parent, false);
            holder = new ViewHolder(context, convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        setContent(holder, data.get(position), position, convertView, parent);
        return convertView;
    }

    /**
     * 获得布局文件
     *
     * @return
     */
    protected abstract int getLayout();

    /**
     * 填充内容
     *
     * @param position    int
     * @param convertView View
     * @param parent      ViewGroup
     * @param holder      V
     * @param itemBean    T
     */
    protected abstract void setContent(ViewHolder holder, T itemBean, int position, View convertView, ViewGroup parent);


    public static class ViewHolder {
        private View convertView;
        private HashMap<Integer, View> views;
        private Context context;

        ViewHolder(Context context, View convertView) {//第1步
            this.convertView = convertView;
            views = new HashMap<>();//保存View的map
            this.context = context;
        }

        public <T extends View> T findById(int id) {
            View view = views.get(id);
            if (view == null) {
                view = convertView.findViewById(id);
                views.put(id, view);
            } else {
                view = views.get(id);
            }
            return (T) view;
        }

        public void setText(int id, String txt) {
            TextView tv = findById(id);
            tv.setText(txt);
        }

        public void setOnClickListener(int id, View.OnClickListener listener) {
            View view = findById(id);
            view.setOnClickListener(listener);
        }

        public void setTvBackground(int id, Drawable txt) {
            TextView tv = findById(id);
            tv.setBackgroundDrawable(txt);
        }

        public void setImage(int id, String url) {
            ImageView img = findById(id);
            ImageLoader.getInstance().displayCircleImage(context, url, img);
        }

        public void setImage(int id, int url) {
            ImageView img = findById(id);
            ImageLoader.getInstance().displayCircleImage(context, url, img);
        }
    }
}
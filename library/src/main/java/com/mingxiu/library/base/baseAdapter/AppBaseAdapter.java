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
 * 描述：封装的一个简单易用的AppBaseAdapter
 */
public abstract class AppBaseAdapter<T> extends BaseAdapter {
    public List<T> data;
    public Context context;

    public AppBaseAdapter(List<T> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data != null ? data.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //入口
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return createViewHolder(position, convertView, parent).getItemView();
    }

    public abstract ViewHolder createViewHolder(int position, View convertView, ViewGroup parent);

    public static class ViewHolder {
        private View convertView;
        private HashMap<Integer, View> views;
        private Context context;

        //第四步
        ViewHolder(Context context, View convertView) {
            this.convertView = convertView;
            //保存View的map
            views = new HashMap<>();
            this.context = context;
            //设置tab
            convertView.setTag(this);
        }

        //第三步
        public static ViewHolder getHolder(View convertView, Context context, int layoutId, ViewGroup parent) {
            if (convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(context);
                convertView = inflater.inflate(layoutId, parent, false);
                return new ViewHolder(context, convertView);
            } else {
                return (ViewHolder) convertView.getTag();
            }
        }

        //第六步
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

        //第五步
        public void setText(int id, String txt) {
            TextView tv = findById(id);
            tv.setText(txt);
        }

        //第五步
        public void setOnClickListener(int id, View.OnClickListener listener) {
            View view = findById(id);
            view.setOnClickListener(listener);
        }

        //第五步
        public void setTvBackground(int id, Drawable txt) {
            TextView tv = findById(id);
            tv.setBackgroundDrawable(txt);
        }

        //第五步
        public void setImage(int id, String url) {
            ImageView img = findById(id);
            ImageLoader.getInstance().displayCircleImage(context,url, img);
        }

        //第五步
        public void setImage(int id, int url) {
            ImageView img = findById(id);
            ImageLoader.getInstance().displayCircleImage(context,url, img);
        }

        public View getItemView() {
            return convertView;
        }
    }
}
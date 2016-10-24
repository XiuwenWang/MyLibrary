package com.mingxiu.library.base.baseAdapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mingxiu.library.utils.ImageLoader;

import java.util.HashMap;
import java.util.List;

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
 * 版权所有：比萨_u
 * 作者：Created by a.wen.
 * 创建时间：2016/9/12
 * Email：13872829574@163.com
 * 修订历史：1.0
 * 描述：RecyclerView.Adapter 优化 封装
 */
public abstract class RvSimpleAdapter<T> extends RecyclerView.Adapter<RvSimpleAdapter.ViewHolder> {
    public List<T> data;
    public Context context;

    public RvSimpleAdapter(List<T> data, Context context) {
        this.data = data;
        this.context = context;
    }
    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(getLayout(viewType), null);
        ViewHolder holder = new ViewHolder(itemView, context);
        return holder;
    }


    public void remove(int position) {
        data.remove(position);
        notifyItemRemoved(position);
    }

    public void add(int position, T item) {
        data.add(position, item);
        notifyItemInserted(position);
    }

    /**
     * 获得布局文件
     *
     * @return
     */
    protected abstract int getLayout(int viewType);


    public class ViewHolder extends RecyclerView.ViewHolder {
        private HashMap<Integer, View> views;
        private Context context;

        public ViewHolder(View itemView, Context context) {
            super(itemView);
            this.views = new HashMap<>();//保存View的map
            this.context = context;
        }

        public <T extends View> T findById(int id) {
            View view = views.get(id);
            if (view == null) {
                view = itemView.findViewById(id);
                views.put(id, view);
            }
            return (T) view;
        }

        public RvSimpleAdapter.ViewHolder setText(int id, String txt) {
            TextView tv = findById(id);
            tv.setText(txt);
            return this;
        }

        public RvSimpleAdapter.ViewHolder setOnClickListener(int id, View.OnClickListener listener) {
            View view = findById(id);
            view.setOnClickListener(listener);
            return this;
        }

        public RvSimpleAdapter.ViewHolder setTvBackground(int id, Drawable txt) {
            TextView tv = findById(id);
            tv.setBackgroundDrawable(txt);
            return this;
        }

        public RvSimpleAdapter.ViewHolder setImage(int id, String url) {
            ImageView img = findById(id);
            ImageLoader.getInstance().displayCircleImage(context, url, img);
            return this;
        }

        public RvSimpleAdapter.ViewHolder setImage(int id, int url) {
            ImageView img = findById(id);
            ImageLoader.getInstance().displayCircleImage(context, url, img);
            return this;
        }

        public View getItemView() {
            return itemView;
        }

    }
}

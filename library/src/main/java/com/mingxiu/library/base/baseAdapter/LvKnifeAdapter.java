package com.mingxiu.library.base.baseAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.mingxiu.library.bean.AdapterBean;

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
 * 版权所有：
 * 作者：Created by a.wen.
 * 创建时间：2016/9/1
 * Email：13872829574@qq.com
 * 修订历史：1.0
 * 描述：封装的一个可以用黄油到的 LvKnifeAdapter 子类必须实现三个抽象方法
 */

public abstract class LvKnifeAdapter<T, V> extends BaseAdapter {
    protected List<T> data;
    protected Context context;
    protected AdapterBean mAdapterBean;

    public AdapterBean getAdapterBean() {
        return mAdapterBean;
    }

    public LvKnifeAdapter(List<T> data, Context context) {
        this.data = data;
        this.context = context;
        this.mAdapterBean = new AdapterBean();
    }

    @Override
    public int getCount() {
        return data != null ? data.size() : 0;
    }

    @Override
    public T getItem(int position) {
        return data != null ? data.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        V holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(getLayout(), null);
            holder = createViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (V) convertView.getTag();
        }
        setContent(holder, getItem(position), position, convertView, parent);

        return convertView;
    }

    /**
     * 获得布局文件
     *
     * @return
     */
    protected abstract int getLayout();

    /**
     * 创建一个ViewHolder
     *
     * @param convertView View
     * @return
     */
    protected abstract V createViewHolder(View convertView);


    /**
     * 填充内容
     *
     * @param position    int
     * @param convertView View
     * @param parent      ViewGroup
     * @param holder      V
     * @param itemBean    T
     */
    protected abstract void setContent(V holder, T itemBean, int position, View convertView, ViewGroup parent);

}

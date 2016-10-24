package com.mingxiu.library.base.baseAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
 * 版权所有：平行学堂
 * 作者：Created by a.wen.
 * 创建时间：2016/9/12
 * Email：13872829574@qq.com
 * 修订历史：1.0
 * 描述：
 */
public abstract class RvKnifeAdapter<T, V extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<V> {

    public List<T> data;
    public Context context;
    protected AdapterBean mAdapterBean;

    public AdapterBean getAdapterBean() {
        return mAdapterBean;
    }
    public RvKnifeAdapter(List<T> data, Context context) {
        this.data = data;
        this.context = context;
        this.mAdapterBean = new AdapterBean();
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public V onCreateViewHolder(ViewGroup parent, int viewType) {
        return onCreateViewHolder(LayoutInflater.from(context).inflate(getLayout(viewType), null));

    }
    /**
     * 获得布局文件
     * @return
     */
    protected abstract int getLayout(int viewType);
    /**
     * 创建一个ViewHolder
     * @param convertView View
     * @return
     */
    protected abstract V onCreateViewHolder(View convertView);
    /**
     * 绑定ViewHolder
     * @param holder   ViewHolder
     * @param position 位置
     */
    @Override
    public abstract void onBindViewHolder(V holder, int position);
}

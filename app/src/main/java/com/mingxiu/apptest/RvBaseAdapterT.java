package com.mingxiu.apptest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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
 * 版权所有：个人
 * 作者：Created by a.wen.
 * 创建时间：2016/10/19
 * Email：13872829574@qq.com
 * 内容描述：
 * 修改人：a.wen
 * 修改时间：${DATA}
 * 修改备注：
 * 修订历史：1.0
 */

public class RvBaseAdapterT extends RvBaseAdapter<String, RvBaseAdapterT.ViewHolder> {

    public RvBaseAdapterT(List<String> data, Context context) {
        super(data, context);
    }

    @Override
    protected int getLayout(int viewType) {
        return R.layout.rv_adapter;
    }

    @Override
    protected ViewHolder onCreateViewHolder(View convertView) {
        return new ViewHolder(convertView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.mT1.setText(data.get(position));
        holder.mT1.setText(data.get(position));
        holder.mT1.setText(data.get(position));
        holder.mT1.setText(data.get(position));

    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.T_1)
        TextView mT1;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}

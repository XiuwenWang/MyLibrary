package com.mingxiu.apptest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;

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

public class RvBaseAdapterT extends RvBaseAdapter<String ,RvBaseAdapterT.ViewHolder> {

    public RvBaseAdapterT(List<String> data, Context context) {
        super(data, context);
    }

    @Override
    protected int getLayout(int viewType) {
        return R.layout.rv_adapter;
    }

    @Override
    protected ViewHolder onCreateViewHolder(View convertView) {
        return new ViewHolder(convertView) ;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.mT1.setText(data.get(position));
        holder.mT2.setText(data.get(position));
//        holder.mI1.setImageResource(R.mipmap.ic_launcher);
//        holder.mI2.setImageResource(R.mipmap.ic_launcher);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                App.getInstance().showToast(data.get(position));
            }
        });
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.T_1)
        TextView mT1;
        @BindView(R.id.I_1)
        ImageView mI1;
        @BindView(R.id.T_2)
        TextView mT2;
        @BindView(R.id.I_2)
        ImageView mI2;

        ViewHolder(View view) {
            super(view);
//            ButterKnife.bind(this, view);
            mT1 = (TextView) view.findViewById(R.id.T_1);
            mT2 = (TextView) view.findViewById(R.id.T_2);
        }
    }
//
//    @Override
//    public void onBindViewHolder(ViewHolder holder, final int position) {
//        holder.setText(R.id.T_1, data.get(position))
//                .setText(R.id.T_1, data.get(position))
//                .setImage(R.id.I_1, data.get(position))
//                .setImage(R.id.I_1, data.get(position))
//                .setOnClickListener(R.id.T_2, new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        App.getInstance().showToast(data.get(position));
//                    }
//                });
//    }
}

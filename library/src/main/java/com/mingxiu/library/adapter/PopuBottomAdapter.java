package com.mingxiu.library.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mingxiu.library.R;
import com.mingxiu.library.base.baseAdapter.LvBaseAdapter;
import com.mingxiu.library.bean.PopuItemBean;

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
 * 版权所有：
 * 作者：Created by a.wen.
 * 创建时间：2016/9/1
 * Email：13872829574@qq.com
 * 修订历史：1.0
 * 描述：PopupWindowUtils 底部弹出框的ListView的适配器
 */
public class PopuBottomAdapter extends LvBaseAdapter<PopuItemBean, PopuBottomAdapter.ViewHolder> {


    public PopuBottomAdapter(List<PopuItemBean> data, Context context) {
        super(data, context);
    }

    @Override
    protected int getLayout() {
        return R.layout.lv_popu_bottom;
    }

    @Override
    protected ViewHolder createViewHolder(View convertView) {
        return new ViewHolder(convertView);
    }

    @Override
    protected void setContent(ViewHolder holder, PopuItemBean itemBean, int position, View convertView, ViewGroup parent) {
        holder.mTvItemTitle.setText(data.get(position).getItemTitle());
        if (data.get(position).getTitleColor() != 0) {
            holder.mTvItemTitle.setTextColor(context.getResources().getColor(data.get(position).getTitleColor()));
        } else {
            holder.mTvItemTitle.setTextColor(context.getResources().getColor(R.color.black));
        }
        if (position == data.size() - 1) {
            holder.mTvPartingLine.setVisibility(View.GONE);
        } else {
            holder.mTvPartingLine.setVisibility(View.VISIBLE);
        }
    }


    static class ViewHolder {
        TextView mTvItemTitle;
        TextView mTvPartingLine;

        ViewHolder(View view) {
            mTvItemTitle = (TextView) view.findViewById(R.id.tv_item_title);
            mTvPartingLine = (TextView) view.findViewById(R.id.tv_partingLine);
        }
    }
}

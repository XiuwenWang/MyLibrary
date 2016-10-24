package com.mingxiu.apptest;

import android.content.Context;
import android.view.View;

import com.mingxiu.library.base.baseAdapter.RvSimpleAdapter;

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

public class RvAdapter extends RvSimpleAdapter<String> {

    public RvAdapter(List<String> data, Context context) {
        super(data, context);
    }

    @Override
    protected int getLayout(int viewType) {
        return R.layout.rv_adapter;
    }

    @Override
    public void onBindViewHolder(RvSimpleAdapter.ViewHolder holder, final int position) {
        holder.setText(R.id.T_1, data.get(position))
                .setText(R.id.T_1, data.get(position))
                .setImage(R.id.I_1, data.get(position))
                .setImage(R.id.I_1, data.get(position))
                .setOnClickListener(R.id.T_2, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        App.getInstance().showToast(data.get(position));
                    }
                });
    }
}

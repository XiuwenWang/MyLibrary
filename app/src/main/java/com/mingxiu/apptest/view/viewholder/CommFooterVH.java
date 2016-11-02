package com.mingxiu.apptest.view.viewholder;


import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mingxiu.apptest.R;
import com.mingxiu.apptest.base.BaseViewHolder;

import butterknife.BindView;

import static com.mingxiu.apptest.R.id.tv_state;


public class CommFooterVH extends BaseViewHolder<Object> {
    @BindView(R.id.progressbar)
    ProgressBar mProgressbar;
    @BindView(tv_state)
    TextView mTvState;
    public static final int LAYOUT_TYPE = R.layout.list_footer_view;


    public CommFooterVH(View view) {
        super(view);
    }

    @Override
    public int getType() {
        return LAYOUT_TYPE;
    }

    @Override
    public void onBindViewHolder(View view, Object o) {
        boolean isHasMore = (null == o ? false : true);
        mProgressbar.setVisibility(isHasMore ? View.VISIBLE : View.GONE);
        mTvState.setText(isHasMore ? "正在加载" : "已经到底");
    }
}
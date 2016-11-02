package com.mingxiu.apptest.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mingxiu.apptest.R;
import com.mingxiu.apptest.ui.me.MainActivity;
import com.mingxiu.library.base.BaseFragment;

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
 * 创建时间：2016/10/28
 * Email：13872829574@163.com
 * 内容描述：
 * 修改人：a.wen
 * 修改时间：${DATA}
 * 修改备注：
 * 修订历史：1.0
 */

public class Fragment_1 extends BaseFragment {

    @BindView(R.id.main_tv_text)
    TextView mMainTvText;

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_main;
    }

    public static Fragment_1 newInstance(String mParam1, String mParam2) {
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, mParam1);
        args.putString(ARG_PARAM2, mParam2);
        Fragment_1 fragment = new Fragment_1();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        setUpView();
        return rootView;
    }

    @Override
    public void setUpView() {
        super.setUpView();
        mMainTvText.setText(mParam1);
        mMainTvText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).mMainPresenter.showTitle(mParam1);
            }
        });
    }
}

package com.mingxiu.apptest.ui.me;

import com.mingxiu.apptest.R;
import com.mingxiu.library.tablayout.entity.TabEntity;
import com.mingxiu.library.tablayout.listener.CustomTabEntity;

import java.util.ArrayList;

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
 * 创建时间：2016/10/26
 * Email：13872829574@qq.com
 * 内容描述：
 * 修改人：a.wen
 * 修改时间：${DATA}
 * 修改备注：
 * 修订历史：1.0
 */

public class MainModel extends MainContract.Model {
    String[] mTitles = {"首页", "消息", "联系人", "更多"};
    int[] mIconUnselectIds = {
            R.mipmap.tab_home_unselect, R.mipmap.tab_speech_unselect,
            R.mipmap.tab_contact_unselect, R.mipmap.tab_more_unselect};
    int[] mIconSelectIds = {
            R.mipmap.tab_home_select, R.mipmap.tab_speech_select,
            R.mipmap.tab_contact_select, R.mipmap.tab_more_select};
    ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    public MainModel(MainContract.Presenter presenter) {
        mPresenter = presenter;
    }


    @Override
    public TabEntity getTabEntity(int position) {
        return new TabEntity(mTitles[position], mIconSelectIds[position], mIconUnselectIds[position]);
    }

    @Override
    public ArrayList<CustomTabEntity> getTabEntityList() {
        mTabEntities.clear();
        for (int i = 0; i < mTitles.length; i++) {
            TabEntity tabEntity = getTabEntity(i);
            mTabEntities.add(tabEntity);
        }
        return mTabEntities;
    }
}

package com.mingxiu.apptest.ui.me;

import com.mingxiu.library.tablayout.listener.CustomTabEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

public class MainPresenter extends MainContract.Presenter {

    public MainPresenter(MainContract.View view) {
        mView = view;
        mModel = new MainModel(this);
        onStart();
    }

    @Override
    public void onStart() {
        mView.AddFragment(mModel.getTabEntityList());
        mView.initCommonTabLayout(mModel.getTabEntityList());


        List<String> data = new ArrayList<>();
        Comparator.comparing(String::toString);
        Collections.sort(data, (o1, o2) -> 1);

        data.stream()// 1.得到容器的Steam
                .filter(str -> Character.isDigit(str.charAt(0)))// 2.选出以数字开头的字符串
                .collect(Collectors.toSet());
//                .forEach(str -> System.out.println(str));// 3.输出字符串
    }

    @Override
    public CustomTabEntity getTabEntity(int position) {
        return mModel.getTabEntity(position);
    }

    @Override
    public void showTitle(int position) {
        mView.showTitle(mModel.getTabEntity(position).getTabTitle());
    }

    @Override
    public void showTitle(String title) {
        mView.showTitle(title);
    }

}

package com.mingxiu.apptest;

import com.apkfuns.logutils.LogUtils;
import com.hyphenate.easeui.controller.EaseUI;
import com.mingxiu.apptest.base.util.SpUtil;
import com.mingxiu.library.BaseApp;

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
 * 创建时间：2016/10/18
 * Email：13872829574@qq.com
 * 内容描述：
 * 修改人：a.wen
 * 修改时间：${DATA}
 * 修改备注：
 * 修订历史：1.0
 */
public class App extends BaseApp {

    @Override
    public void onCreate() {
        super.onCreate();
//        configOkHttpFinal(false);
        SpUtil.init(this);
        LogUtils.d("------>");
        initEaseUI();
    }

    private void initEaseUI() {
        if(EaseUI.getInstance().init(this, null)){
            LogUtils.d("EaseUI 初始化成功 ~");
        }else {
            LogUtils.d("EaseUI 初始化失败 ~");
        }
    }
}

package com.mingxiu.apptest.ui.me;


import com.mingxiu.library.base.BaseModel;
import com.mingxiu.library.base.BasePresenter;
import com.mingxiu.library.base.BaseView;
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

public interface MainContract {
     abstract class Model extends BaseModel<Presenter> {

         abstract CustomTabEntity getTabEntity(int position);

        abstract ArrayList<CustomTabEntity> getTabEntityList();
    }


    interface View extends BaseView {
        void showTitle(String title);

        void AddFragment(ArrayList<CustomTabEntity> data);

        void initCommonTabLayout(ArrayList<CustomTabEntity> data);
    }

    abstract class Presenter extends BasePresenter<Model, View> {

        public abstract CustomTabEntity getTabEntity(int position);

        public abstract void showTitle(int position);
        public abstract void showTitle(String title);
    }
}

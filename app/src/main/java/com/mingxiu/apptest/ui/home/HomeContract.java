package com.mingxiu.apptest.ui.home;


import com.mingxiu.apptest.base.BaseModel;
import com.mingxiu.apptest.base.BasePresenter;
import com.mingxiu.apptest.base.BaseView;
import com.mingxiu.apptest.data.entity._User;

/**
 * Created by baixiaokang on 16/4/22.
 */
public interface HomeContract {
    interface Model extends BaseModel {
        String[] getTabs();
    }


    interface View extends BaseView {
        void showTabList(String[] mTabs);

        void initUserInfo(_User user);
    }

    abstract class Presenter extends BasePresenter<Model, View> {
        public abstract void getTabList();

        public abstract void getUserInfo();
    }
}

package com.mingxiu.apptest.ui.home;


import com.mingxiu.apptest.Contact;
import com.mingxiu.apptest.base.util.SpUtil;
import com.mingxiu.apptest.data.entity._User;

/**
 * Created by baixiaokang on 16/4/22.
 */
public class HomePresenter extends HomeContract.Presenter {

    @Override
    public void getTabList() {
        mView.showTabList(mModel.getTabs());
    }

    @Override
    public void getUserInfo() {
        _User user = SpUtil.getUser();
        if (user != null)
            mView.initUserInfo(user);
    }

    @Override
    public void onStart() {
        getTabList();
        getUserInfo();
        mRxManager.on(Contact.EVENT_LOGIN, arg -> mView.initUserInfo((_User) arg));
    }
}

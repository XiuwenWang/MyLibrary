package com.mingxiu.apptest.ui.login;


import com.mingxiu.apptest.base.BaseModel;
import com.mingxiu.apptest.base.BasePresenter;
import com.mingxiu.apptest.base.BaseView;
import com.mingxiu.apptest.data.CreatedResult;
import com.mingxiu.apptest.data.entity._User;

import rx.Observable;

/**
 * Created by baixiaokang on 16/4/29.
 */
public interface LoginContract {
    interface Model extends BaseModel {
        Observable<_User> login(String name, String pass);
        Observable<CreatedResult> sign(String name, String pass);
    }

    interface View extends BaseView {
        void loginSuccess();
        void signSuccess();
        void showMsg(String msg);
    }

    abstract class Presenter extends BasePresenter<Model, View> {
        public abstract void login(String name, String pass);
        public abstract void sign(String name, String pass);
        @Override
        public void onStart() {}
    }
}

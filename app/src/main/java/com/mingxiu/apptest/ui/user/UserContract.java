package com.mingxiu.apptest.ui.user;


import com.mingxiu.apptest.base.BaseModel;
import com.mingxiu.apptest.base.BasePresenter;
import com.mingxiu.apptest.base.BaseView;
import com.mingxiu.apptest.data.CreatedResult;
import com.mingxiu.apptest.data.entity._User;

import java.io.File;

import rx.Observable;

/**
 * Created by baixiaokang on 16/5/5.
 */
public interface UserContract {
    interface Model extends BaseModel {
        Observable<CreatedResult> upFile(File file);

        Observable upUser(_User user);
    }


    interface View extends BaseView {

        void showMsg(String msg);
       void  initUser(_User user);
    }

    abstract class Presenter extends BasePresenter<Model, View> {

        public abstract void upLoadFace(File f);

        public abstract void upUserInfo(String face);
    }
}

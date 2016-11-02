package com.mingxiu.apptest.data.repository;


import com.mingxiu.apptest.Contact;
import com.mingxiu.apptest.api.Api;
import com.mingxiu.apptest.base.util.helper.RxSchedulers;
import com.mingxiu.apptest.data.Repository;
import com.mingxiu.apptest.data.entity._User;

import rx.Observable;

/**
 * Created by baixiaokang on 16/4/29.
 */
public class _UserRepository extends Repository<_User> {
    @Override
    public Observable getPageAt(int page) {
        return Api.getInstance().service.getAllUser(Contact.PAGE_COUNT * (page - 1), Contact.PAGE_COUNT).compose(RxSchedulers.io_main());
    }
}

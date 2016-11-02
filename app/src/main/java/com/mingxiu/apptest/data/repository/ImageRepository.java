package com.mingxiu.apptest.data.repository;


import com.mingxiu.apptest.Contact;
import com.mingxiu.apptest.api.Api;
import com.mingxiu.apptest.base.util.ApiUtil;
import com.mingxiu.apptest.base.util.helper.RxSchedulers;
import com.mingxiu.apptest.data.Data;
import com.mingxiu.apptest.data.Repository;
import com.mingxiu.apptest.data.entity.Image;

import rx.Observable;


/**
 * Created by baixiaokang on 16/7/19.
 */
public class ImageRepository extends Repository<Image> {

    @Override
    public Observable<Data<Image>> getPageAt(final int page) {
        return Api.getInstance().service
                .getAllImages(ApiUtil.getWhere(param), "-createdAt", Contact.PAGE_COUNT * (page - 1), Contact.PAGE_COUNT)
                .compose(RxSchedulers.io_main());
    }
}

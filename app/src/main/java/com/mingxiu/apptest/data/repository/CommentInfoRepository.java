package com.mingxiu.apptest.data.repository;


import com.mingxiu.apptest.Contact;
import com.mingxiu.apptest.api.Api;
import com.mingxiu.apptest.base.util.ApiUtil;
import com.mingxiu.apptest.base.util.helper.RxSchedulers;
import com.mingxiu.apptest.data.Repository;
import com.mingxiu.apptest.data.entity.CommentInfo;

import rx.Observable;

/**
 * Created by baixiaokang on 16/5/4.
 */
public class CommentInfoRepository extends Repository<CommentInfo> {

    @Override
    public Observable getPageAt(int page) {
        return Api.getInstance().service
                .getCommentList(ApiUtil.getInclude(param), ApiUtil.getWhere(param), Contact.PAGE_COUNT * (page - 1), Contact.PAGE_COUNT)
                .compose(RxSchedulers.io_main());
    }
}

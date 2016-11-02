package com.mingxiu.apptest.ui.article;


import com.mingxiu.apptest.api.Api;
import com.mingxiu.apptest.base.util.helper.RxSchedulers;
import com.mingxiu.apptest.data.CreatedResult;
import com.mingxiu.apptest.data.Pointer;
import com.mingxiu.apptest.data.entity.Comment;

import rx.Observable;

/**
 * Created by baixiaokang on 16/5/4.
 */
public class ArticleModel implements ArticleContract.Model {

    @Override
    public Observable<CreatedResult> createComment(String content, Pointer article, Pointer user) {
        return Api.getInstance().service
                .createComment(new Comment(article, content, user))
                .compose(RxSchedulers.io_main());
    }
}
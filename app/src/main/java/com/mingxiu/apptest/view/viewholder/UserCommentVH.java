package com.mingxiu.apptest.view.viewholder;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mingxiu.apptest.Contact;
import com.mingxiu.apptest.R;
import com.mingxiu.apptest.base.BaseViewHolder;
import com.mingxiu.apptest.base.util.ImageUtil;
import com.mingxiu.apptest.data.repository.CommentInfoRepository;
import com.mingxiu.apptest.ui.article.ArticleActivity;

import butterknife.BindView;

import static com.mingxiu.apptest.R.id.im_article;
import static com.mingxiu.apptest.R.id.tv_title;


/**
 * Created by baixiaokang on 16/5/4.
 */
public class UserCommentVH extends BaseViewHolder<CommentInfoRepository> {


    @BindView(im_article)
    ImageView mImArticle;
    @BindView(tv_title)
    TextView mTvTitle;
    @BindView(R.id.tv_content)
    TextView mTvContent;

    public UserCommentVH(View v) {
        super(v);
    }

    @Override
    public int getType() {
        return R.layout.list_item_user_comment;
    }

    @Override
    public void onBindViewHolder(View view, final CommentInfoRepository mSubject) {
        mTvContent.setText(mSubject.data.content);
        mTvTitle.setText(mSubject.data.article.title);
        ImageUtil.loadImg(mImArticle, mSubject.data.article.image);
        view.setOnClickListener((v) ->
                ActivityCompat.startActivity((Activity) mContext, new Intent(mContext, ArticleActivity.class).putExtra(Contact.HEAD_DATA, mSubject.data.article)
                        , ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) mContext, mImArticle, ArticleActivity.TRANSLATE_VIEW).toBundle())
        );
    }
}

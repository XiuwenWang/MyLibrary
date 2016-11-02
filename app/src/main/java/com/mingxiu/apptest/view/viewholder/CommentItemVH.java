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
import com.mingxiu.apptest.ui.user.UserActivity;

import butterknife.BindView;

import static com.mingxiu.apptest.R.id.im_user;


/**
 * Created by baixiaokang on 16/5/4.
 */
public class CommentItemVH extends BaseViewHolder<CommentInfoRepository> {


    @BindView(im_user)
    ImageView mImUser;
    @BindView(R.id.tv_content)
    TextView mTvContent;

    public CommentItemVH(View v) {
        super(v);
    }

    @Override
    public int getType() {
        return R.layout.list_item_comment;
    }

    @Override
    public void onBindViewHolder(View view, final CommentInfoRepository mSubject) {
        mTvContent.setText(mSubject.data.content);
        ImageUtil.loadRoundImg(mImUser, mSubject.data.creater.face);
        mImUser.setOnClickListener(v ->
                ActivityCompat.startActivity((Activity) mContext, new Intent(mContext, UserActivity.class).putExtra(Contact.HEAD_DATA, mSubject.data.creater)
                        , ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) mContext, mImUser, ArticleActivity.TRANSLATE_VIEW).toBundle())
        );
    }
}

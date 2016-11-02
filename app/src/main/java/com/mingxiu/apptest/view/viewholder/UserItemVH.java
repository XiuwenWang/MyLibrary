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
import com.mingxiu.apptest.data.repository._UserRepository;
import com.mingxiu.apptest.ui.article.ArticleActivity;
import com.mingxiu.apptest.ui.user.UserActivity;

import butterknife.BindView;

import static com.mingxiu.apptest.R.id.im_user;


/**
 * Created by baixiaokang on 16/5/4.
 */
public class UserItemVH extends BaseViewHolder<_UserRepository> {


    @BindView(im_user)
    ImageView mImUser;
    @BindView(R.id.tv_content)
    TextView mTvContent;

    public UserItemVH(View v) {
        super(v);
    }

    @Override
    public int getType() {
        return R.layout.list_item_user;
    }

    @Override
    public void onBindViewHolder(View view, final _UserRepository user) {
        mTvContent.setText(user.data.username);
        ImageUtil.loadRoundImg(mImUser, user.data.face);
        mImUser.setOnClickListener(v ->
                ActivityCompat.startActivity((Activity) mContext, new Intent(mContext, UserActivity.class).putExtra(Contact.HEAD_DATA, user.data)
                        , ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) mContext, mImUser, ArticleActivity.TRANSLATE_VIEW).toBundle())
        );
    }
}

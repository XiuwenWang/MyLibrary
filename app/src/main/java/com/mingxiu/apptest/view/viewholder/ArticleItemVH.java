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
import com.mingxiu.apptest.data.repository.ImageRepository;
import com.mingxiu.apptest.ui.article.ArticleActivity;

import butterknife.BindView;


/**
 * Created by baixiaokang on 16/4/23.
 */
public class ArticleItemVH extends BaseViewHolder<ImageRepository> {


    @BindView(R.id.image)
    ImageView mImage;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.tv_des)
    TextView mTvDes;
    @BindView(R.id.tv_info)
    TextView mTvInfo;
    @BindView(R.id.tv_time)
    TextView mTvTime;

    public ArticleItemVH(View v) {
        super(v);
    }

    @Override
    public int getType() {
        return R.layout.list_item_card_main;
    }

    @Override
    public void onBindViewHolder(View view, final ImageRepository mSubject) {
        ImageUtil.loadImg(mImage, mSubject.data.image);
        mTvTitle.setText(mSubject.data.title);
        mTvDes.setText(mSubject.data.author);
        mTvInfo.setText(mSubject.data.type);
        mTvTime.setText(mSubject.data.createdAt);
        view.setOnClickListener((v) ->
                ActivityCompat.startActivity((Activity) mContext, new Intent(mContext, ArticleActivity.class).putExtra(Contact.HEAD_DATA, mSubject.data)
                        , ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) mContext, mImage, ArticleActivity.TRANSLATE_VIEW).toBundle())
        );
    }
}

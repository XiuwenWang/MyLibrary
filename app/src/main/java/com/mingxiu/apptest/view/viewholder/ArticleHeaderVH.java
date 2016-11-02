package com.mingxiu.apptest.view.viewholder;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.mingxiu.apptest.R;
import com.mingxiu.apptest.base.BaseViewHolder;
import com.mingxiu.apptest.data.entity.Image;

import butterknife.BindView;


/**
 * Created by baixiaokang on 16/5/4.
 */
public class ArticleHeaderVH extends BaseViewHolder<Image> {


    @BindView(R.id.tv_article)
    TextView mTvArticle;

    public ArticleHeaderVH(View v) {
        super(v);
    }

    @Override
    public int getType() {
        return R.layout.list_item_article;
    }

    @Override
    public void onBindViewHolder(View view, Image obj) {
        String article = obj.article.replace("<br>", "\n").replaceAll(" ", "").replaceAll("//", "");
        if (!TextUtils.isEmpty(article)) {
            article = article.substring(article.indexOf("&gt;") + 4, article.length());
            mTvArticle.setText(article);
        }
    }
}

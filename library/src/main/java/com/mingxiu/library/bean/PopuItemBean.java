package com.mingxiu.library.bean;

/**
 * 版权所有：
 * 作者：Created by a.wen.
 * 创建时间：2016/7/3
 * Email：13872829574@qq.com
 * 修订历史：1.0
 * 描述：
 */
public class PopuItemBean {

    public PopuItemBean(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public PopuItemBean(int resColorId, String itemTitle) {
        this.titleColor = resColorId;
        this.itemTitle = itemTitle;
    }

    private String itemTitle;
    private int titleColor;


    public int getTitleColor() {
        return titleColor;
    }

    public void setTitleColor(int titleColor) {
        this.titleColor = titleColor;
    }


    public String getItemTitle() {
        return itemTitle;
    }
    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }
}

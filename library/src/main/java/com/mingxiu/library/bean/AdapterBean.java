package com.mingxiu.library.bean;
/**
 * ----------BigGod be here!----------/
 * ***┏┓******┏┓*********
 * *┏━┛┻━━━━━━┛┻━━┓*******
 * *┃             ┃*******
 * *┃     ━━━     ┃*******
 * *┃             ┃*******
 * *┃  ━┳┛   ┗┳━  ┃*******
 * *┃             ┃*******
 * *┃     ━┻━     ┃*******
 * *┃             ┃*******
 * *┗━━━┓     ┏━━━┛*******
 * *****┃     ┃神兽保佑*****
 * *****┃     ┃代码无BUG！***
 * *****┃     ┗━━━━━━━━┓*****
 * *****┃              ┣┓****
 * *****┃              ┏┛****
 * *****┗━┓┓┏━━━━┳┓┏━━━┛*****
 * *******┃┫┫****┃┫┫********
 * *******┗┻┛****┗┻┛*********
 * ━━━━━━神兽出没━━━━━━
 * 版权所有：平行学堂
 * 作者：Created by a.wen.
 * 创建时间：2016/9/7
 * Email：13872829574@qq.com
 * 修订历史：1.0
 * 描述：
 */
public class AdapterBean {
    private boolean isShowAdd;                  //是否添加
    private boolean isShowDel;                  //是否删除
    private boolean isShowSelect;               //是否显示选择
    private boolean isShowSearchResult;         //是否显示搜索结果

    public boolean isShowSearchResult() {
        return isShowSearchResult;
    }

    public void setShowSearchResult(boolean showSearchResult) {
        isShowSearchResult = showSearchResult;
    }

    public boolean isShowAdd() {
        return isShowAdd;
    }

    public void setShowAdd(boolean showAdd) {
        isShowAdd = showAdd;
    }

    public boolean isShowDel() {
        return isShowDel;
    }

    public void setShowDel(boolean showDel) {
        isShowDel = showDel;
    }

    public boolean isShowSelect() {
        return isShowSelect;
    }

    public void setShowSelect(boolean showSelect) {
        isShowSelect = showSelect;
    }
}

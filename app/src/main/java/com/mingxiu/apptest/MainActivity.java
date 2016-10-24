package com.mingxiu.apptest;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.apkfuns.logutils.LogUtils;
import com.mingxiu.library.base.BaseActivity;
import com.mingxiu.library.bean.PopuItemBean;
import com.mingxiu.library.picker.InitAreaTask;
import com.mingxiu.library.utils.widget.DialogUtils;
import com.mingxiu.library.utils.widget.PopupWindowUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity {


    List<String> data = new ArrayList<>();
    RvBaseAdapterT mAdapter;
    @BindView(R.id.tv_Main)
    TextView mTvMain;
    @BindView(R.id.RecyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.activity_main)
    RelativeLayout mActivityMain;
    private RecyclerView.LayoutManager mLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    public void initView() {
        super.initView();
//        LogUtils.d("initView");
//        data.add("1");
//        data.add("2");
//        data.add("3");
//        data.add("4");
//        data.add("5");
//        LogUtils.d("data.size = " + data.size());
//
//        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
//        mRecyclerView.setLayoutManager(getLayout());//设置布局管理器
//        mAdapter = new RvBaseAdapterT(data, this);
//        mRecyclerView.setAdapter(mAdapter);
//        mAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        List<PopuItemBean> data = new ArrayList();
        switch (item.getItemId()) {
            case R.id._1:
                data.add(new PopuItemBean("1"));
                data.add(new PopuItemBean("2"));
                data.add(new PopuItemBean("3"));
                data.add(new PopuItemBean("4"));
                data.add(new PopuItemBean("5"));
                data.add(new PopuItemBean("6"));
                PopupWindowUtils.getInstance().showBottomPopupWindow(this, data, new PopupWindowUtils.ShowBottomPopupWindowListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        App.getInstance().showToast(position + "");
                    }

                    @Override
                    public void onCancel() {

                    }
                });
                break;
            case R.id._2:
                PopupWindowUtils.getInstance().showSimpleSelectPopupWindow(this, "哈哈", new PopupWindowUtils.ShowSimplePopupWindowListener() {
                    @Override
                    public void onConfirm() {
                        App.getInstance().showToast("確定" + "");
                    }

                    @Override
                    public void onCancel() {

                    }
                });
                break;
            case R.id._3:
                DialogUtils.showLoadingDialog(this, "加载中~", true, true);
                break;
            case R.id._4:
                InitAreaTask initAreaTask = new InitAreaTask(this, new InitAreaTask.CityPickerCallBack() {
                    @Override
                    public void onFinish(String address) {
                        App.getInstance().showToast(address);
                    }
                });

                initAreaTask.execute();
                break;
            case R.id._5:
                if (mRecyclerView == null) {
                    App.getInstance().showToast("mRecyclerView 等于空");
                    LogUtils.d("mRecyclerView 等于空");
                } else {
                    App.getInstance().showToast("mRecyclerView 不等于空===============>");
                    LogUtils.d("mRecyclerView 不等于空===============>");
                }

                break;
        }
        App.getInstance().showToast(item.getItemId() + "");
        return super.onOptionsItemSelected(item);
    }

    public RecyclerView.LayoutManager getLayout() {
        // 创建一个线性布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        return layoutManager;
    }
}

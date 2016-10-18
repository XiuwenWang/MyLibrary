package com.mingxiu.apptest;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.mingxiu.library.base.BaseActivity;
import com.mingxiu.library.bean.PopuItemBean;
import com.mingxiu.library.http.MxHttpRequest;
import com.mingxiu.library.http.Params;
import com.mingxiu.library.picker.InitAreaTask;
import com.mingxiu.library.utils.widget.DialogUtils;
import com.mingxiu.library.utils.widget.PopupWindowUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private TextView tvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MxHttpRequest.post("--->", new Params());
    }

    @Override
    public void initView() {
        super.initView();
        tvMain = (TextView) findViewById(R.id.tv_main);
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
                DialogUtils.showLoadingDialog(this, "加载中~");
                break;
            case R.id._4:
                InitAreaTask initAreaTask = new InitAreaTask(this, tvMain);
                initAreaTask.execute();

                break;
            case R.id._5:


                break;
        }
        App.getInstance().showToast(item.getItemId() + "");
        return super.onOptionsItemSelected(item);
    }
}

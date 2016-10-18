package com.mingxiu.library.picker;

import android.app.Activity;
import android.app.Dialog;
import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.mingxiu.library.picker.address.City;
import com.mingxiu.library.picker.address.County;
import com.mingxiu.library.picker.address.Province;

import org.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 版权所有：
 * 作者：Created by a.wen.
 * 创建时间：2016/8/26
 * Email：13872829574@qq.com
 * 修订历史：1.0
 * 描述：
 */
public class InitAreaTask extends AsyncTask<Integer, Integer, Boolean> {

    Activity mActivity;
    private List<Province> provinces = new ArrayList<>();
    Dialog progressDialog;
    TextView etDistrictSelect;

    public InitAreaTask(Activity mActivity,TextView etDistrictSelect) {
        this.mActivity = mActivity;
        this.etDistrictSelect = etDistrictSelect;
        progressDialog = Util.createLoadingDialog(mActivity, "请稍等...", true, 0);
    }

    @Override
    protected void onPreExecute() {

        progressDialog.show();
    }

    @Override
    protected void onPostExecute(Boolean result) {
        progressDialog.dismiss();
        if (provinces.size() > 0) {
            showAddressDialog(mActivity,etDistrictSelect);
        } else {
            Toast.makeText(mActivity, "数据初始化失败", Toast.LENGTH_SHORT).show();
        }
    }

    private void showAddressDialog(Activity activity, final TextView etDistrictSelect) {
        CityPickerDialog.showCityPickerDialog(activity, provinces, new CityPickerDialog.onCityPickedListener() {

            @Override
            public void onPicked(Province selectProvince, City selectCity, County selectCounty) {
                StringBuilder address = new StringBuilder();
                address.append(selectProvince != null ? selectProvince.getAreaName() : "")
                        .append(selectCity != null ? selectCity.getAreaName() : "")
                        .append(selectCounty != null && selectCounty.getAreaName() != null ? selectCounty.getAreaName() : "");
                etDistrictSelect.setText(address);
            }

            @Override
            public void onCancel() {
            }
        });
    }

    @Override
    protected Boolean doInBackground(Integer... params) {
        String address;
        InputStream in = null;
        try {
            in = mActivity.getResources().getAssets().open("address");
            byte[] arrayOfByte = new byte[in.available()];
            in.read(arrayOfByte);
            address = new String(arrayOfByte, "UTF-8");
            JSONArray jsonList = new JSONArray(address);
            for (int i = 0; i < jsonList.length(); i++) {
                try {
                    provinces.add(JSON.parseObject(jsonList.getString(i), Province.class));
                } catch (Exception e) {
                }
            }
            return true;
        } catch (Exception e) {
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
        }
        return false;
    }


}
package com.mingxiu.library.utils.widget;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.mingxiu.library.R;
import com.mingxiu.library.adapter.PopuBottomAdapter;
import com.mingxiu.library.bean.PopuItemBean;
import com.mingxiu.library.utils.DeviceUtils;
import com.mingxiu.library.utils.PixelUtils;

import java.util.List;

import static com.mingxiu.library.utils.DeviceUtils.getScreenPix;


/**
 * 版权所有：
 * 作者：Created by a.wen.
 * 创建时间：2016/7/3
 * Email：13872829574@qq.com
 * 修订历史：1.0
 * 描述：
 */
public class PopupWindowUtils {

    private static PopupWindowUtils popu;

    /**
     * 单例模式
     *
     * @return
     */
    public static PopupWindowUtils getInstance() {
        if (popu == null) {
            popu = new PopupWindowUtils();
        }
        return popu;
    }


    /**
     * 中间的简单选择的popupWindow
     * 默认点击popupWindow 之外 关闭
     *
     * @param title
     * @param listener
     */
    public void showSimpleSelectPopupWindow(final Activity context, String title, final ShowSimplePopupWindowListener listener) {
        showSimpleSelectPopupWindow(context, title, true, listener,null);
    }
    /**
     * 中间的简单选择的popupWindow
     * 默认点击popupWindow 之外 关闭
     *
     * @param title
     * @param listener
     */
    public void showSimpleSelectPopupWindow(final Activity context, String title, final ShowSimplePopupWindowListener listener,SetCancelConfirmTextListener setCancelConfirmTextListener) {
        showSimpleSelectPopupWindow(context, title, true, listener,setCancelConfirmTextListener);
    }

    /**
     * 中间的简单选择的popupWindow
     *
     * @param isOutsideTouchable
     * @param title
     * @param listener
     */
    public void showSimpleSelectPopupWindow(final Activity context, String title, boolean isOutsideTouchable, final ShowSimplePopupWindowListener listener, SetCancelConfirmTextListener setCancelConfirmTextListener) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.alertdialog, null);
        TextView tvTitle = (TextView) inflate.findViewById(R.id.tv_content);
        TextView tvCancel = (TextView) inflate.findViewById(R.id.tv_cancel);
        TextView tvConfirm = (TextView) inflate.findViewById(R.id.tv_confirm);
        tvTitle.setText(title);
        if (setCancelConfirmTextListener != null) {
            setCancelConfirmTextListener.setCancelConfirmText(tvCancel, tvConfirm);
        }
        final PopupWindow popupWindow = new PopupWindow(inflate, PixelUtils.dp2px(270), PixelUtils.dp2px(144), true);
        popupWindow.setAnimationStyle(R.style.DialogAnimation);                     //动画
        popupWindow.setBackgroundDrawable(new BitmapDrawable());                    //设置PopupWindow的背景为一个空的Drawable对象，如果不设置这个，那么PopupWindow弹出后就无法退出了
        popupWindow.setOutsideTouchable(isOutsideTouchable);                        //设置是否点击PopupWindow外退出PopupWindow
        DeviceUtils.setActivityAlpha(context, 0.6f);                                //设置开始时的背景透明度
        //屏幕亮度
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                DeviceUtils.setActivityAlpha(context, 1f);
            }
        });

        tvConfirm.setOnClickListener(new View.OnClickListener() {                  //确定回调
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onConfirm();
                }
                popupWindow.dismiss();
            }
        });
        tvCancel.setOnClickListener(new View.OnClickListener() {                   //取消回调
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onCancel();
                }
                popupWindow.dismiss();
            }
        });
        popupWindow.showAtLocation(inflate, Gravity.CENTER, 0, 0);                  //显示位置

    }



    /**
     * 显示底部弹出的PopupWindow
     *
     * @param data     数据
     * @param listener 点击的监听
     */
    public void showBottomPopupWindow(final Activity context, List<PopuItemBean> data, final ShowBottomPopupWindowListener listener) {
        showBottomPopupWindow(context, data, true, listener);

    }

    /**
     * 显示底部弹出的PopupWindow
     *
     * @param isOutsideTouchable 是否触摸窗口以外关闭
     * @param data               数据
     * @param listener           点击的监听
     */
    public void showBottomPopupWindow(final Activity context, List<PopuItemBean> data, boolean isOutsideTouchable, final ShowBottomPopupWindowListener listener) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.popuwindow_bottom, null);           //布局文件
        final PopupWindow popupWindow = new PopupWindow(inflate,                                         //创建一个popupWindow
                getScreenPix(context).widthPixels - PixelUtils.dp2px(18),                    //宽度
                PixelUtils.dp2px(9 + 44 + 9 + ((44 + 1) * (data == null ? 0 : data.size())) - 1), true); //高度
        TextView tvItemCancel = (TextView) inflate.findViewById(R.id.tv_cancel);                         //取消按键
        tvItemCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                listener.onCancel();
            }
        });
        ListView lvPopuBottom = (ListView) inflate.findViewById(R.id.lv_popuwindow_bottom);
        lvPopuBottom.setDividerHeight(0);
        lvPopuBottom.setAdapter(new PopuBottomAdapter(data, context));
        lvPopuBottom.setOnItemClickListener(new AdapterView.OnItemClickListener() {                     //listView item 的监听
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                popupWindow.dismiss();
                listener.onItemClick(parent, view, position, id);
            }
        });

        popupWindow.setAnimationStyle(R.style.AlertAnimation);                                          //动画
        DeviceUtils.setActivityAlpha(context, 0.6f);                                      //屏幕亮度
        popupWindow.setBackgroundDrawable(new BitmapDrawable());                                        //设置PopupWindow的背景为一个空的Drawable对象，如果不设置这个，那么PopupWindow弹出后就无法退出了
        popupWindow.setOutsideTouchable(isOutsideTouchable);                                            //设置是否点击PopupWindow外退出PopupWindow
        popupWindow.setOutsideTouchable(true);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {                          //popupWindow 关闭时候的监听事件
            @Override
            public void onDismiss() {
                DeviceUtils.setActivityAlpha(context, 1.0f);                             //屏幕亮度
            }
        });
        popupWindow.showAtLocation(inflate, Gravity.BOTTOM, 0, 0);                                       //显示位置
    }

    /**
     * 定义一个 接口 用于 popupWindow 点击的监听
     */
    public interface ShowBottomPopupWindowListener {
        void onItemClick(AdapterView<?> parent, View view, int position, long id);                    //listView item 的监听

        void onCancel();                                                                              //取消监听
    }

    /**
     * 用于中间的简单选择的popupWindow回调的接口
     */
    public interface ShowSimplePopupWindowListener {
        void onConfirm();                                                                           //确定

        void onCancel();                                                                            //取消
    }

    /**
     * 用于中间的简单选择的popupWindow回调的接口
     */
    public interface SetCancelConfirmTextListener {
        void setCancelConfirmText(TextView cancel, TextView confirm);
    }
}

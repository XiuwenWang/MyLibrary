package com.mingxiu.library.utils;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.File;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

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
 * 版权所有：个人
 * 作者：Created by a.wen.
 * 创建时间：2016/10/18
 * Email：13872829574@qq.com
 * 内容描述：图片加载工具类
 * 修改人：a.wen
 * 修改时间：${DATA}
 * 修改备注：
 * 修订历史：1.0
 */
public class ImageLoader {
    private static volatile ImageLoader mInstance;
    public static final String ANDROID_RESOURCE = "android.resource://";
    public static final String FOREWARD_SLASH = "/";

    private ImageLoader() {

    }

    public static ImageLoader getInstance() {
        ImageLoader instance = mInstance;
        if (instance == null) {
            synchronized (ImageLoader.class) {
                if (instance == null) {
                    instance = new ImageLoader();
                    mInstance = instance;
                }
            }
        }
        return instance;
    }


    //直接加载网络图片
    public void displayImage(Context context, String url, ImageView imageView) {

        Glide
                .with(context)
                .load(url)
                .centerCrop()
//                .error(R.drawable.zhanwei_nopic)
                .crossFade()
                .into(imageView);
    }


    //加载SD卡图片
    public void displayImage(Context context, File file, ImageView imageView) {
        Glide
                .with(context)
                .load(file)
                .centerCrop()
                .into(imageView);

    }

    //加载SD卡图片并设置大小
    public void displayImage(Context context, File file, ImageView imageView, int width, int height) {
        Glide
                .with(context)
                .load(file)
                .override(width, height)
                .centerCrop()
                .into(imageView);

    }

    //加载网络图片并设置大小
    public void displayImage(Context context, String url, ImageView imageView, int width, int height) {
        Glide
                .with(context)
                .load(url)
                .centerCrop()
                .override(width, height)
                .crossFade()
                .into(imageView);
    }

    //加载drawable图片
    public void displayImage(Context context, int resId, ImageView imageView) {
        Glide.with(context)
                .load(resourceIdToUri(context, resId))
                .crossFade()
                .into(imageView);
    }

    //加载drawable图片显示为圆形图片
    public void displayCircleImage(Context context, int resId, ImageView imageView) {
        Glide.with(context)
                .load(resourceIdToUri(context, resId))
                .crossFade()
//                .error(R.drawable.zhanwei_nopic)
                .bitmapTransform(new CropCircleTransformation(context))
                .into(imageView);
    }

    //加载网络图片显示为圆形图片
    public void displayCircleImage(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .centerCrop()
//                .error(R.drawable.touxiang)
                .bitmapTransform(new CropCircleTransformation(context))
                .crossFade()
                .into(imageView);
    }

    //加载SD卡图片显示为圆形图片
    public void displayCircleImage(Context context, File file, ImageView imageView) {
        Glide
                .with(context)
                .load(file)
                .centerCrop()
                .bitmapTransform(new CropCircleTransformation(context))
                .into(imageView);

    }

    //将资源ID转为Uri
    public Uri resourceIdToUri(Context context, int resourceId) {
        return Uri.parse(ANDROID_RESOURCE + context.getPackageName() + FOREWARD_SLASH + resourceId);
    }

}

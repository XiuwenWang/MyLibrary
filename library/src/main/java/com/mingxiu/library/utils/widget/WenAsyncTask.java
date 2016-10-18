package com.mingxiu.library.utils.widget;

import android.os.Handler;
import android.os.Message;

import com.apkfuns.logutils.LogUtils;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 版权所有：
 * 作者：Created by a.wen.
 * 创建时间：2016/7/5
 * Email：13872829574@qq.com
 * 修订历史：1.0
 * 描述：
 */
public class WenAsyncTask {

    private Executor threadPool = Executors.newCachedThreadPool();
    private static WenAsyncTask sChatCallBack;

    private static Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            TaskListener listener;
            switch (msg.what) {
                case 1:
                    listener = (TaskListener) msg.obj;
                    listener.onFinish(true);
                    break;

                case 2:
                    listener = (TaskListener) msg.obj;
                    listener.onFinish(false);
                    break;
            }
        }
    };


    public static WenAsyncTask getInstance() {
        if (sChatCallBack == null) {
            sChatCallBack = new WenAsyncTask();
        }
        return sChatCallBack;
    }

    /**
     * 后台跑
     */
    public synchronized void execute(final TaskListener listener) {
        execute(listener, 0);
    }


    /**
     * 后台跑
     */
    public synchronized void execute(final TaskListener listener, final long delayed) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                LogUtils.d(delayed+"");
                if (delayed != 0) {
                    try {
                        Thread.sleep(delayed);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (listener != null) {
                    boolean isSuccess = listener.startRun();
                    if (isSuccess) {
                        Message message = new Message();
                        message.what = 1;
                        message.obj = listener;
                        handler.sendMessage(message);
                    } else {
                        Message message = new Message();
                        message.what = 2;
                        message.obj = listener;
                        handler.sendMessage(message);
                    }
                }
            }
        });

    }


    //    private TaskListener mRunListener;
    public interface TaskListener {
        boolean startRun();
        void onFinish(boolean isSuccess);
    }

}

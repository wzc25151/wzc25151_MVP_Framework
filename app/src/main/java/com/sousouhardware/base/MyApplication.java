package com.sousouhardware.base;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Process;
import android.text.TextUtils;
import android.widget.Toast;

import com.sousouhardware.config.Constants;
import com.sousouhardware.util.ACache;
import com.sousouhardware.util.HttpUtil;
import com.sousouhardware.util.LogUtil;
import com.sousouhardware.view.stack.StackActivity;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wangxiangbo on 2016/7/5.
 */
public class MyApplication extends Application {
    private static Toast mToast;
    public static MyApplication instance;
    public static ACache aCache;
    public static LinkedList<BaseActivity> actList = new LinkedList<BaseActivity>();
    public static LinkedList<BaseFragment> fgList= new LinkedList<BaseFragment>();
    public static ExecutorService executorService = Executors.newFixedThreadPool(3);

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        instance = this;
        aCache = ACache.get(instance);
        HttpUtil.initializeDefaultHttpsClient(instance);
    }

    public static void showToast(String tip) {
        if (TextUtils.isEmpty(tip)) {
            return;
        }
        if (mToast == null) {
            mToast = Toast.makeText(instance, "", Toast.LENGTH_SHORT);
        }
        mToast.setText(tip);
        mToast.show();
        LogUtil.defaultInfo(tip);
    }

    public static void showStackActivity(Activity context, String className) {
        Intent intent = new Intent();
        intent.putExtra(Constants.INTENT_EXTRA_VIEW_CLASSNAME, className);
        if (context instanceof StackActivity) {
            ((StackActivity) context).showView(intent);
        } else {
            intent.setClass(context, StackActivity.class);
            context.startActivity(intent);
        }
    }

    public void exit() {
        LinkedList<BaseActivity> copys = new LinkedList<BaseActivity>(actList);
        for (int i = 0; i < actList.size(); i++) {
            BaseActivity activity = copys.getFirst();
            if (activity != null) {
                activity.finish();
                copys.removeFirst();
            }
        }
        Process.killProcess(Process.myPid());
    }
}

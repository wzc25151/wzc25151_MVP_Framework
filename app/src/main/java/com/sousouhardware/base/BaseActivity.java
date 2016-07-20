package com.sousouhardware.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sousouhardware.util.LogUtil;

import java.util.List;

/**
 * Created by wangxiangbo on 2016/7/5.
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected MyApplication application = MyApplication.instance;
    private List actList = application.actList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        actList.add(this);
        LogUtil.defaultInfo(this.toString()+"创建\t" + actList);
        init();
        initLayout();
        initToolBar();
        initClickButton();
    }

    protected void init() {
    }

    protected void initLayout() {
    }

    protected void initToolBar() {
    }

    protected void initClickButton() {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        actList.remove(this);
        LogUtil.defaultInfo(this.toString()+"销毁\t" + actList);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
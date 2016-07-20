package com.sousouhardware.base;

import android.support.v4.app.Fragment;

import com.sousouhardware.util.LogUtil;

import java.util.LinkedList;

/**
 * Created by wangxiangbo on 2016/7/20.
 */
public class BaseFragment extends Fragment {
    private LinkedList<BaseFragment> fgList = MyApplication.fgList;

    @Override
    public void onResume() {
        super.onResume();
        if (!fgList.contains(this)){
            fgList.add(this);
            LogUtil.defaultInfo(this.toString()+"创建\t"+fgList.toString());
        }
    }

    public void onClear(){

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        onClear();
        fgList.remove(this);
        LogUtil.defaultInfo(this.toString()+"销毁\t"+fgList.toString());
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}

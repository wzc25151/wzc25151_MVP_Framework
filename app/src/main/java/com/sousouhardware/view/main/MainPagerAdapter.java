package com.sousouhardware.view.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.sousouhardware.base.ObjViewManager;

/**
 * Created by wangxiangbo on 2016/7/19.
 */
public class MainPagerAdapter extends FragmentPagerAdapter {
    private String[] str_arr;
    public MainPagerAdapter(FragmentManager fm, String[] str_arr) {
        super(fm);
        this.str_arr = str_arr;
    }
    @Override
    public Fragment getItem(int position) {
        return (Fragment) ObjViewManager.getFragmentClassInstance(str_arr[position]);
    }
    @Override
    public int getCount() {
        return str_arr == null?0:str_arr.length;
    }
}

package com.sousouhardware.view.main;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by wangxiangbo on 2016/7/19.
 */
public class MainOnClickListener implements View.OnClickListener {
    private int[]arr_tabIds;
    private ViewPager vp;
    public MainOnClickListener(int[]arr_tabIds, ViewPager vp){
        this.arr_tabIds = arr_tabIds;
        this.vp = vp;
    }
    @Override
    public void onClick(View view) {
        for(int i  = 0;i<arr_tabIds.length;i++){
            if (view.getId() == arr_tabIds[i]) {
                vp.setCurrentItem(i);
                break;
            }
        }
    }
}
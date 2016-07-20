package com.sousouhardware.view.home;

import android.widget.AdapterView;

import com.sousouhardware.base.BasePresenter;
import com.sousouhardware.base.BaseView;
import com.sousouhardware.bean.HomeRefreshBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by wangxiangbo on 2016/7/13.
 */
public interface HomeContract {
    interface View extends BaseView<HomeContract.Presenter> {
        void showBanner(List<HomeRefreshBean.SlideadsBean> bannerBeanList);

        void showGridView(ArrayList<Map<String, Object>> gv_list, AdapterView.OnItemClickListener itemClickListener);

        void showListView(int[] listTypes, ArrayList list);
    }

    interface Presenter extends BasePresenter<HomeContract.View> {
    }
}

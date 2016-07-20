package com.sousouhardware.view.home;

import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;

import com.sousouhardware.R;
import com.sousouhardware.base.MyApplication;
import com.sousouhardware.bean.HomeRefreshBean;
import com.sousouhardware.http.ToHomeRefresh;
import com.sousouhardware.util.JsonUtil;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;

/**
 * Created by wangxiangbo on 2016/7/13.
 */
public class HomePresenter implements HomeContract.Presenter {
    private HomeContract.View view;
    private ArrayList<Map<String, Object>> gv_list = new ArrayList<Map<String, Object>>();
    private final int[] gvIcon = {R.mipmap.home_gv_popularity_brand, R.mipmap.home_gv_user_buy,
            R.mipmap.home_gv_spread, R.mipmap.home_gv_consult, R.mipmap.home_gv_repair,
            R.mipmap.home_gv_build, R.mipmap.home_gv_advertise, R.mipmap.home_gv_more
    };
    private final String[] gvIconName = {"人气品牌", "用户求购", "商家推广", "行业资讯", "便民维修", "便民施工", "专业招聘", "更多"};
    //表示首页list条目类型
    private final int HOME_LIST_HORIZONTAL = 0xB0;
    private final int HOME_LIST_GRID = 0xB1;
    private final int[] listTypes = new int[]{
            HOME_LIST_HORIZONTAL, HOME_LIST_HORIZONTAL, HOME_LIST_GRID, HOME_LIST_GRID
    };


    public HomePresenter() {
    }

    public HomePresenter(HomeContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void start() {
        new ToHomeRefresh("南通市", homeRefreshCallback).submit();
    }

    @Override
    public void setView(HomeContract.View view) {
        this.view = view;
    }

    private void setupBanner(List<HomeRefreshBean.SlideadsBean> bannerBeanList) {
        view.showBanner(bannerBeanList);
    }

    private void setupGridView() {
        if (gv_list.size() <= 0) {
            for (int i = 0; i < gvIcon.length; i++) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("image", gvIcon[i]);
                map.put("text", gvIconName[i]);
                gv_list.add(map);
            }
        }
        view.showGridView(gv_list, new HomeListItemClickListener());
    }

    private void setupListView(List<HomeRefreshBean.ShopsBean.RowsBean> popStoreBeanlist, List<HomeRefreshBean.BrandBean> popBrandBeanList, List<HomeRefreshBean.MessageBean.RowsBean> discountSaleBeanList, List<HomeRefreshBean.ProTypeBean.RowsBean> hotProductBeanList) {
        ArrayList list = new ArrayList<>();
        list.add(popStoreBeanlist);
        list.add(popBrandBeanList);
        list.add(discountSaleBeanList);
        list.add(hotProductBeanList);
        view.showListView(listTypes, list);
        view.setIsCanResume(false);
    }

    private StringCallback homeRefreshCallback = new StringCallback() {
        @Override
        public void onError(Call call, Exception e, int id) {
            String str_home_refresh_json = MyApplication.aCache.getAsString(ToHomeRefresh.class.getSimpleName());
            if (!TextUtils.isEmpty(str_home_refresh_json)) {
                dispenseJson(str_home_refresh_json);
            }
        }

        @Override
        public void onResponse(String response, int id) {
            String str_home_refresh_json = MyApplication.aCache.getAsString(ToHomeRefresh.class.getSimpleName());
            if (!response.equals(str_home_refresh_json)) {
                MyApplication.aCache.put(ToHomeRefresh.class.getSimpleName(), response);
            }
            dispenseJson(response);
        }
    };

    private void dispenseJson(String homeRefreshJson) {
        HomeRefreshBean homeRefreshBean = JsonUtil.fromJson(homeRefreshJson, HomeRefreshBean.class);
        //banner
        List<HomeRefreshBean.SlideadsBean> bannerBeanList = homeRefreshBean.getSlideads();
        setupBanner(bannerBeanList);
        //gridview
        setupGridView();
        //人气商铺
        List<HomeRefreshBean.ShopsBean.RowsBean> popStoreBeanlist = homeRefreshBean.getShops().getRows();
        //人气品牌
        List<HomeRefreshBean.BrandBean> popBrandBeanList = homeRefreshBean.getBrand();
        //折扣特卖
        List<HomeRefreshBean.MessageBean.RowsBean> discountSaleBeanList = homeRefreshBean.getMessage().getRows();
        //热销单品
        List<HomeRefreshBean.ProTypeBean.RowsBean> hotProductBeanList = homeRefreshBean.getProType().getRows();
        setupListView(popStoreBeanlist, popBrandBeanList, discountSaleBeanList, hotProductBeanList);
        view.setIsCanResume(false);
    }

    private class HomeListItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            MyApplication.showToast("" + i);
        }
    };

}

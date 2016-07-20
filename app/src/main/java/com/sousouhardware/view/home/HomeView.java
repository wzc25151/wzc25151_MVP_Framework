package com.sousouhardware.view.home;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.sousouhardware.R;
import com.sousouhardware.base.BaseFragment;
import com.sousouhardware.bean.HomeRefreshBean;
import com.sousouhardware.util.DisplayUtil;
import com.sousouhardware.widget.AutoScrollViewPager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by wangxiangbo on 2016/7/7.
 */
public class HomeView extends BaseFragment implements HomeContract.View {
    private Context context;
    private View rootView;
    private HomeContract.Presenter presenter;
    private boolean isCanResume = true;
    private AutoScrollViewPager banner_vp;
    private RelativeLayout banner_indicator;
    private GridView home_gv;
    private ListView home_lv;
    private String[] title_arr = new String[]{
            "人气店铺", "人气品牌", "折扣特卖", "热销单品"
    };
    private final int HOME_LIST_HORIZONTAL = 0xB0;
    private final int HOME_LIST_GRID = 0xB1;


    @Override
    public void setPresenter(HomeContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setIsCanResume(boolean b) {
        isCanResume = b;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (isCanResume) {
            presenter.start();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fg_home, null);
        init();
        return rootView;
    }

    private void init() {
        context = getContext();
        banner_vp = (AutoScrollViewPager) rootView.findViewById(R.id.home_banner_vp);
        banner_indicator = (RelativeLayout) rootView.findViewById(R.id.home_banner_indicator);
        home_gv = (GridView) rootView.findViewById(R.id.home_gv);
        home_lv = (ListView) rootView.findViewById(R.id.home_lv);
    }

    public void showBanner(List<HomeRefreshBean.SlideadsBean> bannerBeanList) {
        banner_vp.setupData(null, bannerBeanList, banner_indicator);
    }

    public void showGridView(ArrayList<Map<String, Object>> gv_list, AdapterView.OnItemClickListener itemClickListener) {
        home_gv.setAdapter(new SimpleAdapter(context, gv_list, R.layout.gv_item_home, new String[]{"image", "text"}, new int[]{R.id.home_gv_image, R.id.home_gv_text}));
        home_gv.setOnItemClickListener(itemClickListener);
    }

    public void showListView(int[] listTypes, ArrayList list) {
        home_lv.setAdapter(new HomeListAdapter(listTypes, list));
        DisplayUtil.setListViewHeightBasedOnChildren(home_lv);
    }

    @Override
    public void showViewType(int viewType) {
    }

    @Override
    public void onClear() {
        super.onClear();
        isCanResume = true;
    }
    private class HomeListAdapter extends BaseAdapter implements ListAdapter {
        private int[] listTypes;
        private List list;

        public HomeListAdapter(int[] listTypes, List list) {
            this.listTypes = listTypes;
            this.list = list;
        }

        @Override
        public int getCount() {
            return listTypes.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (null == view) {
                view = LayoutInflater.from(context).inflate(R.layout.lv_item_home, null);
                TextView tv = (TextView) view.findViewById(R.id.item_home_lv_title);
                tv.setText(title_arr[i]);
                RecyclerView rv = (RecyclerView) view.findViewById(R.id.item_home_lv_rv);
                if (listTypes[i] == HOME_LIST_HORIZONTAL) {
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
                    linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                    rv.setLayoutManager(linearLayoutManager);
                } else {
                    rv.setLayoutManager(new GridLayoutManager(context, 3));
                }
                rv.setHasFixedSize(true);
                rv.setAdapter(new HomeRecyclerViewAdapter(context, (List) list.get(i)));
            }
            return view;
        }
    }


}

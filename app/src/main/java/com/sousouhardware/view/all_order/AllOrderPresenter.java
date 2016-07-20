package com.sousouhardware.view.all_order;

import com.sousouhardware.base.MyApplication;
import com.sousouhardware.http.ToGetOrderList;
import com.sousouhardware.base.TokenManager;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by wangxiangbo on 2016/7/13.
 */
public class AllOrderPresenter implements AllOrderContract.Presenter {
    private AllOrderContract.View view;

    public AllOrderPresenter() {
    }

    public AllOrderPresenter(AllOrderContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void start() {
    }

    @Override
    public void setView(AllOrderContract.View view) {
        this.view = view;
    }

    @Override
    public void getOrder() {
        new ToGetOrderList(TokenManager.getToken(),ToGetOrderList.TYPE_ALL,"1",getOrderCallback).submit();
    }

    private StringCallback getOrderCallback = new StringCallback() {
        @Override
        public void onError(Call call, Exception e, int id) {

        }

        @Override
        public void onResponse(String response, int id) {
            MyApplication.aCache.put(ToGetOrderList.class.getName(),response);
            MyApplication.showToast(response);
        }
    };
}
